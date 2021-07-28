package com.sra.qa.Testcases;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sra.qa.TC.Homepage;
import com.sra.qa.TC.Loginpage;
import com.sra.qa.TC.Ocrfileupload;
import com.sra.qa.TC.excelupload;
import com.sra.qa.base.Testbase;
import com.sra.qa.extentreport.ExtentReporterNG;
import com.sra.qa.utils.TestUtil;

public class Ocrfileuploads extends Testbase {

	Loginpage loginpage;
	Homepage homepage;
	WebDriverWait wait; 
	TestUtil testutils;
	Ocrfileupload ocrupload;
	excelupload excel;
	Ocrfileupload ocrs;
	ExtentTest extentTest;
	ExtentReporterNG extent;
	
	
	public Ocrfileuploads() {
		super();
	}
	

	
	@BeforeTest
	public void setup() throws IOException
	{
		
		initialization();
		loginpage=new Loginpage();
		ocrs= new Ocrfileupload();
		
	}
	
	@Test(priority=1)
	public void login() throws InterruptedException, IOException
	{
		excel = new excelupload("username", "password");
		
		homepage=loginpage.pagelogin(prop.getProperty("username"), prop.getProperty("password"));
		
		Thread.sleep(4000);
		
	}
	
	@Test(priority=2)
	public void selectcompany() throws InterruptedException
	{
		
		wait = new WebDriverWait(driver,40);
		
		ocrupload = new Ocrfileupload();
		
		WebElement companyname = driver.findElement(By.id("lblCompanytxt"));
		
		String cmp = companyname.getText();
		
		if(cmp.equalsIgnoreCase(prop.getProperty("admin"))) {
			
		    
			}
			
			else {
				
			ocrupload.adminbrowser();
			
			Thread.sleep(4000);
			
			driver.switchTo().frame(driver.findElement(By.id("popupFrameDraggable")));
		    
		    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"browSearch\"]"))));
		    
			ocrupload.browbox(prop.getProperty("admin"));
		    
			ocrupload.searchicon();
		
			
			List<WebElement> cmpylist = driver.findElements(By.xpath("//*[@id='divGrid']//tr//td"));
			
			for(int i=0;i<cmpylist.size();i++) {
				try {
				
					String cmpyname = cmpylist.get(i).getText();
					
					if(cmpyname.equals(prop.getProperty("admin"))) {
						
						cmpylist.get(i).click();
						
						break;
						
					}
				
				}catch(StaleElementReferenceException e) {
					
					
				}finally {
				
				}
				
			 	
			Thread.sleep(5000);
			
		}
		}}
	
	
	
	
	    @Test(priority=3)
		
		public void invoiceupload() throws InterruptedException, IOException {
			
	    	wait = new WebDriverWait(driver,40);
	    	
	    	Actions act= new Actions(driver);
	
		act.moveToElement(driver.findElement(By.id("lblheaderModules"))).perform();
		

	   List<WebElement> ocrscrn = driver.findElements(By.xpath("//*[@id='ModuleMenuDiv']//div[@id='div14']//a"));
	
	   for(int i=0;i<ocrscrn.size();i++) {
		
		String moduletxt= ocrscrn.get(i).getText();
		
		if(moduletxt.equals(prop.getProperty("module"))) {
			
			ocrscrn.get(i).click();
			
		}
		
		}
	   
	   Thread.sleep(5000);
	    
	   	driver.findElement(By.id("txtSearch")).click();
	   	
	   	Thread.sleep(5000);
	 	
	   	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.switchTo().frame(driver.findElement(By.id("mainwindow")));
		
		
		
		ocrupload.invoiceuploadicon();
	
		driver.switchTo().frame(driver.findElement(By.id("popupFrameDraggable")));
		
		try {
		
			WebElement uploadicon = driver.findElement(By.id("AjaxFileUpload11_Html5InputFile"));
	
			uploadicon.sendKeys("C:\\Users\\PRASANT\\Documents\\move\\Eclipse_project\\SRAauto\\Invoices\\CF0355Verkoopfactuur_V180226.pdf");
	
		}catch(Throwable e) {
	
		}
	
		finally {
		
	
			WebElement uploadbutton = driver.findElement(By.id("AjaxFileUpload11_UploadOrCancelButton"));
		
			uploadbutton.click();
			
			TestUtil.takeScreenshotAtEndOfTest();
		
			Thread.sleep(4000);
	
			driver.navigate().refresh();
			
			act.moveToElement(driver.findElement(By.id("lblheaderModules"))).perform();
			

			   List<WebElement> ocrscrn1 = driver.findElements(By.xpath("//*[@id='ModuleMenuDiv']//div[@id='div14']//a"));
			
			   for(int i=0;i<ocrscrn1.size();i++) {
				
				String moduletxt= ocrscrn1.get(i).getText();
				
				if(moduletxt.equals(prop.getProperty("module"))) {
					
					ocrscrn1.get(i).click();
					
				}
				
				}
			   
			   Thread.sleep(5000);
			    
			   	driver.findElement(By.id("txtSearch")).click();
			   	
			   	Thread.sleep(5000);
			 	
			   	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
				driver.switchTo().frame(driver.findElement(By.id("mainwindow")));
				
				ocrs.Reload();
				
				Thread.sleep(5000);
				
				
				
				
		
			}
		
	    }
	    
	    
	    @Test(priority=4) 
	    	public void questionraising() throws InterruptedException, IOException {
	    	
	    	wait = new WebDriverWait(driver,40);
		   
//	    	driver.switchTo().frame(driver.findElement(By.id("mainwindow")));
	    	
		   Select invoicetype = new Select(driver.findElement(By.id("ddltype")));
		   
		   invoicetype.selectByVisibleText(prop.getProperty("invoicetype"));
		   
		   Thread.sleep(4000);
		   
		   Select questiontype =new Select(driver.findElement(By.id("ddlQuestion")));
		   
		   questiontype.selectByVisibleText(prop.getProperty("questiontype"));
		   
		   WebElement datum = driver.findElement(By.id("ocrdate"));
		   
		   datum.clear();
		   
		   datum.sendKeys(prop.getProperty("ocrdatum"));
		   
		   WebElement Factuurnum = driver.findElement(By.id("txtinvoicenumber"));

		   Factuurnum.clear();
		   
		   Factuurnum.sendKeys("eerr1112");
		   
		   Thread.sleep(4000);
		   
		   WebElement raisequestion = driver.findElement(By.id("imgMess"));
		   
		   raisequestion.click();
		   
		   TestUtil.takeScreenshotAtEndOfTest();
		   		   	   
	   }
	    
	    @AfterTest
	
	    public void teardown() throws IOException {
	    	
	    driver.quit();
	  
		
		
		}



		
}
