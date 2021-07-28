package com.sra.qa.Testcases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.sra.qa.TC.Homepage;
import com.sra.qa.TC.Loginpage;
import com.sra.qa.TC.Ocrfileupload;
import com.sra.qa.TC.cockPit;
import com.sra.qa.TC.excelupload;
import com.sra.qa.base.Testbase;
import com.sra.qa.utils.TestUtil;

public class cockPitTest extends Testbase {
	
	Loginpage loginpage;
	Homepage homepage;
	WebDriverWait wait; 
	TestUtil testutils;
	Ocrfileupload ocrupload;
	excelupload excel;
	SoftAssert softAssert;
	cockPit cockpit;
	
	String sheetName = "Sheet2";
	public cockPitTest() {
		super();
	}
	
	@BeforeTest
	public void setup() {
		initialization();
		loginpage=new Loginpage();
		testutils = new TestUtil();
		ocrupload = new Ocrfileupload();
		cockpit = new cockPit();
		
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
		 
		 ocrupload.adminbrowser();
		 
		 Thread.sleep(4000);
		 
		 driver.switchTo().frame(driver.findElement(By.id("popupFrameDraggable")));
		 
		 driver.findElement(By.id("Annuleren")).click();
	
	    Actions act= new Actions(driver);
	
		act.moveToElement(driver.findElement(By.id("lblheaderModules"))).perform();
		

	   List<WebElement> ocrscrn = driver.findElements(By.xpath("//*[@id='ModuleMenuDiv']//div[@id='div13']//a"));
	
	   for(int i=0;i<ocrscrn.size();i++) {
		
		String moduletxt= ocrscrn.get(i).getText();
		
		System.out.println(moduletxt);
		
		if(moduletxt.equalsIgnoreCase(prop.getProperty("modules"))) {
			
			ocrscrn.get(i).click();
			
			
			
		}
		
		}
	    
	   Thread.sleep(5000);
	   
	   	driver.findElement(By.id("txtSearch")).click();
	 	
		Thread.sleep(10000);
		
		driver.switchTo().frame(driver.findElement(By.id("mainwindow")));
	
	}
	
	@Test(priority=3,dataProvider="getTestData")
	public void search(String klant,String cmpny,String date, String edate,String filename) throws InterruptedException {
		
		cockpit.search(klant,cmpny,date,edate,filename);
		
	}

	@Test(priority=4)
	public void adhoctest() throws InterruptedException {
		
		cockpit.adhoc();
		
	}

	@Test(priority=5)
	public void bankimport() {
		
		cockpit.bankimportan();
		
	}
	
	@Test(priority=6)
	public void transactionstab() throws InterruptedException {
		
		cockpit.transactiontab();
		
	}
	
	@Test(priority=7)
	public void inwatchinginvoice() throws InterruptedException{
		
		cockpit.inwatchinginvoice();
		
	}
	
	@Test(priority=8)
	public void deleteinvoice() throws InterruptedException{
		
		cockpit.deleteinvoice();
		
	}
	
	
	/*
	@Test(priority=8)
	public void grouping() throws InterruptedException{
		
		cockpit.groupingCheckbox();
		
	}*/
	
	
	@AfterTest
	public void tearDown() {
	
		driver.close();
		
		
		
	}
	
	
	
	
	
}
	
	
	


