package com.sra.qa.Testcases;

import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.sra.qa.TC.Homepage;
import com.sra.qa.TC.Loginpage;
import com.sra.qa.TC.Ocrfileupload;
import com.sra.qa.TC.excelupload;
import com.sra.qa.base.Testbase;
import com.sra.qa.utils.TestUtil;



public class mutipleDatadriver extends Testbase {
	
	Loginpage loginpage;
	Homepage homepage;
	WebDriverWait wait; 
	TestUtil testutils;
	Ocrfileupload ocrupload;
	excelupload excel;
	SoftAssert softAssert;
	
	String sheetName = "Sheet1";
	
	
	public mutipleDatadriver() {
		super();
	}
	
	
	
	@BeforeTest
	public void setup() {
		initialization();
		loginpage=new Loginpage();
		testutils = new TestUtil();
		ocrupload = new Ocrfileupload();
	}
	
	@DataProvider
	public Object[][] getTestData() throws Exception{
		Object data[][] = testutils.getTestData(sheetName);
		return data;
	}
	
	
	
	@Test(priority=1)
	public void login() throws InterruptedException, IOException {
		
		
		homepage=loginpage.pagelogin(prop.getProperty("username"), prop.getProperty("password"));
		
		Thread.sleep(4000);
		
	}
	

	
	@Test(priority=2)
	public void selectcompany() throws InterruptedException {
		wait = new WebDriverWait(driver,40);
		
		ocrupload = new Ocrfileupload();
		
		WebElement companyname = driver.findElement(By.id("lblCompanytxt"));
		
		String cmp = companyname.getText();
		
		System.out.println(cmp);
		
		String temp = prop.getProperty("admin");
		
		System.out.println("Temp"+temp);
		
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
				
				if(cmpyname.equalsIgnoreCase(prop.getProperty("admin"))) {
					
					cmpylist.get(i).click();
					
					break;
					
				}
			
			}catch(StaleElementReferenceException e) {
				
				
			}finally {
			
			}
			
		 	
		Thread.sleep(5000);
		}
	}
		
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
	 	
		Thread.sleep(10000);
		
//		driver.switchTo().frame(driver.findElement(By.id("mainwindow")));
//		
//		ocrupload.invoiceuploadicon();
//	
//		driver.switchTo().frame(driver.findElement(By.id("popupFrameDraggable")));
//		
//		try {
//		
//			WebElement uploadicon = driver.findElement(By.id("AjaxFileUpload11_Html5InputFile"));
//	
//			uploadicon.sendKeys("C:\\Users\\PRASANT\\Documents\\move\\Eclipse_project\\SRAauto\\Invoices\\CF0355Verkoopfactuur_V180226.pdf");
//	
//		}catch(Throwable e) {
//	
//		}
//	
//		finally {
//		
//	
//			WebElement uploadbutton = driver.findElement(By.id("AjaxFileUpload11_UploadOrCancelButton"));
//		
//			uploadbutton.click();
//			
//			TestUtil.takeScreenshotAtEndOfTest();		
//		    
//			Thread.sleep(4000);
//
//			driver.navigate().refresh();
//			
//			Thread.sleep(4000);
//			
//			
//		
//			}
		
		driver.switchTo().frame(driver.findElement(By.id("mainwindow")));
		
	    }
	    
	
	@Test(priority=4, dataProvider="getTestData")
	public void newexcelUpload(String relatie,String date,String amount,String reknum,String BTW,String btwled,String totaldiff,String btwdiffamt,String bankaccnum) throws Exception {
		
		ocrupload.excelUpload(relatie, date, amount, reknum, BTW, btwled, totaldiff, btwdiffamt, bankaccnum);
		
		
		
	}
	


}


	

	
	
		
	
