package com.sra.qa.Testcases;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import com.sra.qa.TC.Homepage;
import com.sra.qa.TC.Loginpage;
import com.sra.qa.TC.Ocrfileupload;
import com.sra.qa.base.Testbase;
import com.sra.qa.utils.TestUtil;

public class Accountantansflow extends Testbase {
	Loginpage loginpage;
	Homepage homepage;
	WebDriverWait wait; 
	TestUtil testutils;
	Ocrfileuploads ocr;
	Ocrfileupload ocrs;
	Testbase base;
	
	
	
	public Accountantansflow() 
	{
		super();
	}
	
	@BeforeTest
	public void setup() throws IOException
	{
		initialization();
		loginpage=new Loginpage();
		ocrs =  new Ocrfileupload();
		
	}
	
	

	@Test(priority=1)
	public void login() throws InterruptedException
	{
		homepage=loginpage.pagelogin(prop.getProperty("username"), prop.getProperty("password"));
		
		Thread.sleep(4000);
	}
	
	
	@Test(priority=2)
	public void delegateaccountant() throws InterruptedException
	{
		
			ocr= new Ocrfileuploads();
			
			ocr.selectcompany();
			
		    driver.findElement(By.id("lblheaderModules")).click();
			
		 	List<WebElement> ocrscrn = driver.findElements(By.xpath("//*[@id='div12']//a"));
		
		 	for(int i=0;i<ocrscrn.size();i++)
		 	{
			
			String moduletxt= ocrscrn.get(i).getText();
			
			System.out.println(moduletxt);
			
			if(moduletxt.equals(prop.getProperty("delegate"))) 
			{
				
				ocrscrn.get(i).click();
				
				break;
				
			}
			}
		 	
		 	Thread.sleep(2000);
	
		 	driver.findElement(By.id("txtSearch")).click();
		 	
		 	driver.switchTo().frame(driver.findElement(By.id("mainwindow")));
		 	
			WebElement delegate = driver.findElement(By.id("btnDelegation"));
			
			delegate.click();
			
			driver.switchTo().frame("popupFrameDraggable");
			
			WebElement accname = driver.findElement(By.id("browSearch"));
			
			accname.sendKeys(prop.getProperty("accountant"));
			
			Thread.sleep(3000);
			
			driver.findElement(By.id("Search")).click();
			
			List<WebElement> accoutantlist  = driver.findElements(By.xpath("//*[@id='divGrid']//div//table//tr//td"));
			
			for(int i=0;i<accoutantlist.size();i++) 
			{
			
				String acctaname = accoutantlist.get(i).getText();
				
				if(acctaname.contains("1461")) 
				{
					
					accoutantlist.get(i).click();
					
					break;
					
				}
				
			}
			
			driver.navigate().refresh();
			 
			Thread.sleep(5000);
			
			driver.switchTo().frame(driver.findElement(By.id("mainwindow")));
			
	}	
			
	@Test(priority=3)		
	public void answerflow() throws InterruptedException {
			
			WebElement Vragen = driver.findElement(By.id("icon_404e925a-e91d-4f8b-b4c3-f14036a13c28"));
			
			Vragen.click();
			
			List<WebElement> question = driver.findElements(By.xpath("//*[@id='tblQuestionsList']//tbody//tr//td//a"));
			
			question.get(0).click();
			
			Thread.sleep(3000);
		 
			System.out.println(prop.getProperty("questiontype"));
		 
			  if(prop.getProperty("questiontype").equals("Relatie?")) 
				  
			  {
				
		    	WebElement accrelatieselection = driver.findElement(By.id("imgAccounts"));
		    	
		    	accrelatieselection.click();
		    	
		    	driver.switchTo().frame("popupFrameDraggable");
		    	
		    	Thread.sleep(3000);
		    	
		    	WebElement browsersrch = driver.findElement(By.id("browSearch"));
		    	
		    	browsersrch.sendKeys(prop.getProperty("selectrelatie"));
		    	
		    	driver.findElement(By.id("Search")).click();
			    
		    	List <WebElement> relatielst1 = driver.findElements(By.xpath("//*[@id='divGrid']//div//table//tbody//tr//td"));
	
		    	relatielst1.get(0).click();
		    	 
		    }else if(prop.getProperty("questiontype").equals("GBR Nr.")){
		    	
		    	WebElement ledgerbrow = driver.findElement(By.id("imgLedger_1"));
				
				ledgerbrow.click();
				
				driver.switchTo().frame("popupFrameDraggable");
				
				WebElement ledgersel = driver.findElement(By.xpath("//*[@id=\"gvBrowse\"]/tbody/tr[2]"));
				
				ledgersel.click();
		    
		    }else if(prop.getProperty("questiontype").equals("Relatie & GBR Nr.?")){
		    	
		    	WebElement accrelatieselection = driver.findElement(By.id("imgAccounts"));
		    	
		    	accrelatieselection.click();
		    	
		    	driver.switchTo().frame("popupFrameDraggable");
		    	
		    	Thread.sleep(3000);
		    	
		    	WebElement browsersrch = driver.findElement(By.id("browSearch"));
		    	
		    	browsersrch.sendKeys(prop.getProperty("selectrelatie"));
		    	
		    	driver.findElement(By.id("Search")).click();
			    
		    	List <WebElement> relatielst1 = driver.findElements(By.xpath("//*[@id='divGrid']//div//table//tbody//tr//td"));
	
		    	 relatielst1.get(0).click();
		    	 
		    	 Thread.sleep(4000);
		    	 
		    	 driver.switchTo().parentFrame();
		    	 
		    	 WebElement ledgerbrow = driver.findElement(By.id("imgLedger_1"));
					
				ledgerbrow.click();
				
				Thread.sleep(3000);
					
				driver.switchTo().frame("popupFrameDraggable");
					
				WebElement ledgersel = driver.findElement(By.xpath("//*[@id=\"gvBrowse\"]/tbody/tr[2]"));
					
				ledgersel.click();
		    	 
		    	 
		    }
			  
			  Thread.sleep(3000);
			  
			  driver.switchTo().parentFrame();
			  
			  Thread.sleep(3000);
			  
			  JavascriptExecutor js = (JavascriptExecutor) driver;
			   
			  js.executeScript("window.scrollBy(0,-250)", "");
				  
			  WebElement datum = driver.findElement(By.id("lblInvDt"));
			  
			  datum.clear();
			  
			  datum.sendKeys("20-03-2021");
			  
			  System.out.println("Realtie is filled");
			  
			  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			  
			  boolean icon = driver.findElement(By.id("btnSave")).isDisplayed();
		  
		  		System.out.println(icon);
			  
			  List<WebElement> icons = driver.findElements(By.xpath("//*[@id='headerDiv']//span//input"));
			  
			  for(int i=0;i<icons.size();i++) {
				 
				  
			  }if(icons.get(1) != null) {
				  
				  icons.get(1).click();
				  
			  }
			
			  
	}
	
			
			@AfterTest
			public void teardown() {
				
			driver.quit();	
				
			}
	
	}

  