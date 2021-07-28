package com.sra.qa.Testcases;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sra.qa.TC.Homepage;
import com.sra.qa.TC.Loginpage;
import com.sra.qa.TC.Ocrfileupload;
import com.sra.qa.base.Testbase;
import com.sra.qa.utils.TestUtil;
import com.sra.qa.utils.Xls_Reader;

public class OCRfieldchecking extends Testbase {
			Loginpage loginpage;
			Homepage homepage;
			WebDriverWait wait; 
			TestUtil testutils;
			Ocrfileuploads ocr;
			Ocrfileupload ocrs;
			
			public OCRfieldchecking() 
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
			
			
			    @Test(priority=3)
				
				public void invoiceupload() throws InterruptedException, IOException {
			    	
			  
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
				
				WebElement invoiceupload = driver.findElement(By.xpath("//*[@id=\"td1\"]"));
				
				invoiceupload.click();
				
				driver.switchTo().frame(driver.findElement(By.id("popupFrameDraggable")));
				
				try {
				
					WebElement uploadicon = driver.findElement(By.id("AjaxFileUpload11_Html5InputFile"));
			
			
					uploadicon.sendKeys("C:\\Saran\\SRAauto\\Sra\\Invoices\\BMW.pdf");

					uploadicon.sendKeys("C:\\Saran\\SRAauto\\Sra\\Invoices\\Auto process inv-Ziggo-SRA (1).pdf");

				}catch(Throwable e) {
			
					
				}
	  		
				finally {
				
			
					WebElement uploadbutton = driver.findElement(By.id("AjaxFileUpload11_UploadOrCancelButton"));
				
					uploadbutton.click();
					
					Thread.sleep(5000); 
					
					driver.switchTo().defaultContent();
					
					WebElement textbox = driver.findElement(By.id("txtSearch"));
					
					textbox.click();
			    	
			    	Thread.sleep(4000);
			    	
			    	driver.navigate().refresh();
			    	
			    	Thread.sleep(5000);
			    	
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
						
				
					}
			    	
			    	
					
					WebElement Relatie = driver.findElement(By.id("txtaccountname"));
				
					String textInsideRelatieBox = Relatie.getAttribute("value");

					if(textInsideRelatieBox.isEmpty())
					{
					   
						System.out.println("Relatie field is empty");
					
					}else{
						
						System.out.println("Relatie : " + textInsideRelatieBox);
						
					}
					
					WebElement Datum = driver.findElement(By.id("ocrdate"));
					
					String textInsideDatumBox = Datum.getAttribute("value");

					if(textInsideDatumBox.isEmpty())
					{
					   System.out.println("Datum field is empty");
					       
					}else{
						
						System.out.println("Datum : " + textInsideDatumBox);
						
					}
					
					WebElement Factuurnummer = driver.findElement(By.id("txtinvoicenumber"));
					
					String textInsideFactuurnummerBox = Factuurnummer.getAttribute("value");

					if(textInsideFactuurnummerBox.isEmpty())
					{
					   System.out.println("Factuurnummer field is empty");
					   
					}else{
						
						System.out.println("Factuurnummer :" + textInsideFactuurnummerBox);
						
					}
					
					WebElement Total = driver.findElement(By.id("txtTotal"));
					
					String textInsidetxtTotalBox = Total.getAttribute("value");

					if(textInsidetxtTotalBox.isEmpty())
					{
					   System.out.println("Factuurnummer field is empty");
					   
					}else{
						
						System.out.println("Total :" + textInsidetxtTotalBox);
						
					}

					WebElement Banknumber = driver.findElement(By.id("txtBanknumber"));
					
					String textInsideBanknumberBox = Banknumber.getAttribute("value");

					if(textInsideBanknumberBox.isEmpty())
					{
					   System.out.println("Banknumber field is empty");
					   
					}else{
						
						System.out.println("Banknumber :" + textInsideBanknumberBox);
						
					}
					
					WebElement BTWnummer = driver.findElement(By.id("txtbtwnumber"));
					
					String textInsideBTWnummerBox = BTWnummer.getAttribute("value");

					if(textInsideBTWnummerBox.isEmpty())
					{
					   System.out.println("BTW nummer field is empty");
					   
					}else{
						
						System.out.println("BTWnummer : " + textInsideBTWnummerBox);
						
					}
					
					Thread.sleep(5000);
					
			    }
	
			    
			@Test(priority = 4)
			public void nextinvoice() throws InterruptedException {
				
				WebElement nextpage = driver.findElement(By.id("txtnumber"));
				
				nextpage.clear();
				
				nextpage.sendKeys("2");
				
				nextpage.sendKeys(Keys.ENTER);
				
//				driver.navigate().refresh();
				Thread.sleep(5000);
				
				System.out.println("----------------Next Invoice---------------");
				
//				driver.switchTo().frame(driver.findElement(By.id("mainwindow")));
				
				WebElement Relatie = driver.findElement(By.id("txtaccountname"));
				
				String textInsideRelatieBox = Relatie.getAttribute("value");

				if(textInsideRelatieBox.isEmpty())
				{
				   System.out.println("Relatie field is empty");
				
				}else{
					
					System.out.println("Relatie : " + textInsideRelatieBox);
					
				}
				
				WebElement Datum = driver.findElement(By.id("ocrdate"));
				
				String textInsideDatumBox = Datum.getAttribute("value");

				if(textInsideDatumBox.isEmpty())
				{
				   System.out.println("Datum field is empty");
				   
				}else{
					
					System.out.println("Datum : " + textInsideDatumBox);
					
				}
				
				WebElement Factuurnummer = driver.findElement(By.id("txtinvoicenumber"));
				
				String textInsideFactuurnummerBox = Factuurnummer.getAttribute("value");

				if(textInsideFactuurnummerBox.isEmpty())
				{
				   System.out.println("Factuurnummer field is empty");
				   
				}else{
					
					System.out.println("Factuurnummer :" + textInsideFactuurnummerBox);
					
				}
				
				WebElement Total = driver.findElement(By.id("txtTotal"));
				
				String textInsidetxtTotalBox = Total.getAttribute("value");

				if(textInsidetxtTotalBox.isEmpty())
				{
				   System.out.println("Factuurnummer field is empty");
				   
				}else{
					
					System.out.println("Total :" + textInsidetxtTotalBox);
					
				}

				WebElement Banknumber = driver.findElement(By.id("txtBanknumber"));
				
				String textInsideBanknumberBox = Banknumber.getAttribute("value");

				if(textInsideBanknumberBox.isEmpty())
				{
				   System.out.println("Banknumber field is empty");
				   
				}else{
					
					System.out.println("Banknumber :" + textInsideBanknumberBox);
					
				}
				
				WebElement BTWnummer = driver.findElement(By.id("txtbtwnumber"));
				
				String textInsideBTWnummerBox = BTWnummer.getAttribute("value");

				if(textInsideBTWnummerBox.isEmpty())
				{
				   System.out.println("BTW nummer field is empty");
				   
				}else{
					
					System.out.println("BTWnummer : " + textInsideBTWnummerBox);
					
				}
				
			}
	
		}

