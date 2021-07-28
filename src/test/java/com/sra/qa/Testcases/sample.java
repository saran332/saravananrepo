package com.sra.qa.Testcases;

import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sra.qa.TC.Homepage;
import com.sra.qa.TC.Loginpage;
import com.sra.qa.TC.Ocrfileupload;
import com.sra.qa.TC.excelupload;
import com.sra.qa.base.Testbase;
import com.sra.qa.utils.TestUtil;

public class sample extends Testbase {
	
	
	Loginpage loginpage;
	Homepage homepage;
	WebDriverWait wait; 
	TestUtil testutils;
	Ocrfileupload ocrupload;
	excelupload excel;
	
	String sheetName = "Sheet1";
	
	public sample() {
		super();
	}
	
	
	
	@BeforeTest
	public void setup() {
		initialization();
		loginpage=new Loginpage();
		testutils = new TestUtil();
	}
	
	@DataProvider
	public Object[][] getTestData() throws Exception{
		Object data[][] = testutils.getTestData(sheetName);
		return data;
	}
	
	
	
	@Test(priority=1, dataProvider="getTestData")
	public void validatlogin(String Username,String Password) throws InterruptedException, IOException, InvalidFormatException {
		
		
		loginpage.pagelogin(Username,Password);
		
		Thread.sleep(4000);
		
	}
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	


