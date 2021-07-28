package com.sra.qa.Testcases;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.sra.qa.TC.Homepage;
import com.sra.qa.TC.Loginpage;
import com.sra.qa.TC.Ocrfileupload;
import com.sra.qa.TC.excelupload;
import com.sra.qa.base.Testbase;
import com.sra.qa.extentreport.ExtentReporterNG;
import com.sra.qa.utils.TestUtil;

public class Ledgerchecking extends Testbase {

	Loginpage loginpage;
	Homepage homepage;
	WebDriverWait wait; 
	TestUtil testutils;
	Ocrfileupload ocrupload;
	excelupload excel;
	Ocrfileupload ocrs;
	ExtentTest extentTest;
	ExtentReporterNG extent;
	
	
	public Ledgerchecking() {
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
		
		if(cmp.equalsIgnoreCase(prop.getProperty("Vishandel Molenaar"))) {
			
		    
			}
			
			else {
				
			ocrupload.adminbrowser();
			
			Thread.sleep(4000);
			
			driver.switchTo().frame(driver.findElement(By.id("popupFrameDraggable")));
		    
		    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"browSearch\"]"))));
		    
			ocrupload.browbox(prop.getProperty("Vishandel Molenaar"));
		    
			ocrupload.searchicon();
		
			
			List<WebElement> cmpylist = driver.findElements(By.xpath("//*[@id='divGrid']//tr//td"));
			
			for(int i=0;i<cmpylist.size();i++) {
				try {
				
					String cmpyname = cmpylist.get(i).getText();
					
					if(cmpyname.equals(prop.getProperty("Vishandel Molenaar"))) {
						
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
	
			uploadicon.sendKeys("C:\\Saran\\SRAauto\\Sra\\Invoices\\CF0355Verkoopfactuur_V180226.pdf");
	
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





















}
	
	
	
	
	
	
	
	
	
	
	
	


