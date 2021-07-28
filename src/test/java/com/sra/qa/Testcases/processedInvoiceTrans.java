package com.sra.qa.Testcases;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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

public class processedInvoiceTrans extends Testbase {

	Loginpage loginpage;
	Homepage homepage;
	WebDriverWait wait; 
	TestUtil testutils;
	Ocrfileupload ocrupload;
	excelupload excel;
	Ocrfileupload ocrs;
	ExtentTest extentTest;
	ExtentReporterNG extent;
	String docnum;
	
	
	public processedInvoiceTrans() {
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
	   	
	   	Thread.sleep(10000);
	 	
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
			   	
			   	Thread.sleep(10000);
			 	
			   	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
				driver.switchTo().frame(driver.findElement(By.id("mainwindow")));
				
				Thread.sleep(5000);
				
				
				
				
		
			}
		
	    }
	    
	    
	    @Test(priority=4) 
	    	public void questionraising() throws InterruptedException, IOException {
	    	
	    	wait = new WebDriverWait(driver,40);
		   
	    	WebElement docNumber =driver.findElement(By.id("txtDocumentNum"));
	    	
	    	docnum = docNumber.getText();
	    	
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
		   
		   ocrupload.ledgerBrowser();
		   
		   driver.findElement(By.id("btnsavetrans")).click();
		   
		   Thread.sleep(10000);
		   
		   
	   }

	    
	    @Test(priority=5)
	    public void transactions() throws InterruptedException {
	
	    driver.switchTo().defaultContent();
	    	
	    Actions act= new Actions(driver);
	
		act.moveToElement(driver.findElement(By.id("lblheaderModules"))).perform();
		
        List<WebElement> ocrscrn = driver.findElements(By.xpath("//*[@id='ModuleMenuDiv']//div//a"));
	
	    for(int i=0;i<ocrscrn.size();i++) {
		
		String moduletxt= ocrscrn.get(i).getText();
		
		if(moduletxt.equals("Transactielijst")) {
			
		ocrscrn.get(i).click();
			
		}
		
		}
	   
	  
	   	Thread.sleep(5000);
	   	
	   	driver.findElement(By.id("txtSearch")).click();
	   	
	   	driver.switchTo().frame(driver.findElement(By.id("mainwindow")));
	   	
	   	WebElement relatie = driver.findElement(By.xpath("//*[@id=\"tblTransactionList\"]/tbody/tr[1]/td[8]"));
	   	
	   	String relatiename = relatie.getText();
	   	
	   	System.out.println(relatiename);
	   	
	   	if(relatiename.contains("Plant Health Cure")) {
	   	
	   	driver.findElement(By.xpath("//*[@id=\"tblTransactionList\"]/tbody/tr[1]/td[5]/a")).click();
	   	
	   	Thread.sleep(5000);
	   	
	    	
	    }}
	    
	    
	    @Test(priority=6)
	    public void editTransaction() throws InterruptedException {
	    	
	    	driver.findElement(By.id("btnEdit")).click();
	    	
	    	Thread.sleep(4000);
	    	
	    	driver.findElement(By.id("btndelete")).click();
	    	
	    	WebElement dropdown = driver.findElement(By.id("DropDownList2"));
	    	
	    	Select drop = new Select(dropdown);
	    	
	    	drop.selectByIndex(2);
	    	
	    	driver.findElement(By.id("btnDeleteYes")).click();
	    	
	    }
	    
	    @Test(priority=7)
	    public void cocKpitcount() throws InterruptedException {
	    	
	    	driver.switchTo().defaultContent();
	    	
		    Actions act= new Actions(driver);
		
			act.moveToElement(driver.findElement(By.id("lblheaderModules"))).perform();
			
	        List<WebElement> ocrscrn = driver.findElements(By.xpath("//*[@id='ModuleMenuDiv']//div//a"));
		
		    for(int i=0;i<ocrscrn.size();i++) {
			
			String moduletxt= ocrscrn.get(i).getText();
			
			if(moduletxt.equals("Cockpit")) {
				
			ocrscrn.get(i).click();
				
			}
			
			}
		   
		   	Thread.sleep(5000);
		   	
		   	driver.findElement(By.id("txtSearch")).click();
	    
	    	}
	    
	    @Test(priority=8)
	    public void deletedInvoice() {
	    	
	    	driver.switchTo().frame("mainwindow");
	    	
	    	driver.findElement(By.xpath("//*[@id=\"tblUploadTransactionsList\"]/tbody/tr[1]/td[13]/a")).click();
	    	
	    	driver.findElement(By.xpath("//*[@id=\"gvTaskprocess_ctl02_lblCode\"]")).click();
	    	
	    	getScreenshot();
	    	
	    	//driver.switchTo().frame("mainwindow");
	    	
	    	driver.findElement(By.id("btnUndo")).click();
	    	
	    }
	    	
	    	
	    }
	    

