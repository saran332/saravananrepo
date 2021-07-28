package com.sra.qa.Testcases;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sra.qa.TC.Homepage;
import com.sra.qa.TC.Loginpage;
import com.sra.qa.TC.Ocrfileupload;
import com.sra.qa.TC.Transactionlist;
import com.sra.qa.base.Testbase;
import com.sra.qa.utils.TestUtil;

public class Transactionlisttest extends Testbase {
	Loginpage loginpage;
	Homepage homepage;
	WebDriverWait wait; 
	TestUtil testutils;
	Ocrfileuploads ocr;
	Ocrfileupload ocrs;
	Transactionlist translist;
	
	String sheetNames = "Sheet2";
	
	public Transactionlisttest() 
	{
		super();
	}
	
	@BeforeTest
	public void setup()
	{
		initialization();
		loginpage=new Loginpage();
		ocrs= new Ocrfileupload();
	}
	
	@DataProvider
	public Object[][] getTestData() throws Exception{
		Object data[][] = testutils.getTestData(sheetNames);
		return data;
	}
	
	@Test(priority=1)
	public void login() throws InterruptedException
	{
		homepage=loginpage.pagelogin(prop.getProperty("username"), prop.getProperty("password"));
		
		Thread.sleep(4000);
	}
	
	@Test(priority=2)
	public void selectadmin() throws InterruptedException
	{
		ocr= new Ocrfileuploads();
		ocr.selectcompany();
	}
	
	
	
	   @Test(priority=3,dataProvider="getTestData")
		
		public void invoiceupload(String module) throws InterruptedException, IOException {
	    	
	  
	    Actions act= new Actions(driver);
	
		act.moveToElement(driver.findElement(By.id("lblheaderModules"))).perform();
		

	   List<WebElement> ocrscrn = driver.findElements(By.xpath("//*[@id='ModuleMenuDiv']//div[@id='div16']//a"));
	
	   for(int i=0;i<ocrscrn.size();i++) {
		
		String moduletxt= ocrscrn.get(i).getText();
		
		if(moduletxt.equals(module)) {
			
			ocrscrn.get(i).click();
			
		}
		
		}
	   
	   Thread.sleep(5000);
	    
	   	driver.findElement(By.id("txtSearch")).click();
	   	
	   	Thread.sleep(5000);
	 	
	   	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.switchTo().frame(driver.findElement(By.id("mainwindow"))); 
	
	
	
	   }
	   
	   @Test(priority=4,dataProvider="getTestData")
	   public void transactionlisttest(String ledger) {
		   
		translist.ledgerfiltertest(ledger);
		   
		   
		   
	   }








}
	


