package com.sra.qa.TC;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.sra.qa.base.Testbase;

public class Ocrfileupload extends Testbase {
	
	@FindBy(id="imgCompany")
	@CacheLookup
	WebElement Company;
	
	@FindBy(xpath="//*[@id=\"browSearch\"]")
	@CacheLookup
	WebElement browbox;
	
	@FindBy(id="Search")
	@CacheLookup
	WebElement search;
	
	@FindBy(xpath="//*[@id=\"td1\"]")
	@CacheLookup
	WebElement invoiceupload;
	
	@FindBy(id="AjaxFileUpload11_Html5InputFile")
	@CacheLookup
    WebElement uploadicon;
	
	@FindBy(id="AjaxFileUpload11_UploadOrCancelButton")
	@CacheLookup
	WebElement uploadbutton;
	
	@FindBy(id="btnReload")
	@CacheLookup
	WebElement reLoad;
	
	@FindBy(id="btnnewaccount")
	@CacheLookup
	WebElement btnNewaccount;
	
	@FindBy(id="btnsavevalues")
	@CacheLookup
	WebElement btnSavevalue;
	
	@FindBy(id="btnPreview")
	@CacheLookup
	WebElement btnPreview;
	
	@FindBy(id="btn")
	@CacheLookup
	WebElement btnMatching;

	@FindBy(id="imgMerge")
	@CacheLookup
	WebElement imgMerge;

	@FindBy(id="BtnReject")
	@CacheLookup
	WebElement btnReject;
	
    @FindBy(id="ImageButton2")
	@CacheLookup
	WebElement beforeInvoice;
    
    @FindBy(id="ImageButton3")
  	@CacheLookup
  	WebElement nextInvoice;
    
    @FindBy(id="btndelete")
  	@CacheLookup
  	WebElement Delete;
   
    @FindBy(id=" imgPending")
  	@CacheLookup
  	WebElement pendinglink;
    
    @FindBy(id=" imgVat_0")
  	@CacheLookup
  	WebElement vatBTW;
    
    @FindBy(id="txtaccountname")
    WebElement Relatie;
    
    @FindBy(id="ocrdate")
    @CacheLookup
    WebElement datum;
    
    @FindBy(id="ocrtime")
    @CacheLookup
    WebElement time;
    
    @FindBy(id="txtinvoicenumber")
    @CacheLookup
    WebElement invoicenumber;
    
   @FindBy(id="ddlTaxtype_0")
   @CacheLookup
   WebElement BTWpercentage;
   
   @FindBy(id="txtLedger_1")
   @CacheLookup
   WebElement BTWledger;
   
   @FindBy(id="txtLedger_1")
   @CacheLookup
   WebElement ledgertextBroswser;
   
   
   @FindBy(id="txtBTWtotal")
   @CacheLookup
   WebElement BTWtotal;
  
   @FindBy(id="txtdiffAmount")
   @CacheLookup
   WebElement BTWdiffAmount;
  
   @FindBy(id="txttotexcludebtw")
   @CacheLookup
   WebElement totalExediff;
   
   @FindBy(id="txtTotal")
   @CacheLookup
   WebElement txtTotal;
   
   @FindBy(id="txtBanknumber")
   @CacheLookup
   WebElement bankNumber;
   
   @FindBy(id="txtbtwnumber")
   @CacheLookup
   WebElement btwNum;
   
   
   
   
   
   
	
	public Ocrfileupload() {
		PageFactory.initElements(driver, this);
	}
	
	public void adminbrowser () {
		
		Company.click();
				
	}
	
	public void browbox (String browserbox) {
		
	browbox.sendKeys(browserbox);
	
	
	}
	public void searchicon () {
	
		search.click();
	
	}
	public void invoiceuploadicon () {
	invoiceupload.click();
	
	}
	public void uploaded4 (String uplicon) {
	
	uploadicon.sendKeys(uplicon);
	
	}
	
	public void uploaded5 () {
		
	uploadbutton.click();
	
	}
	
	public void Reload() {
		
	reLoad.click();
		
	}
	
	public void createNewaccount() {
		
	btnNewaccount.click();
			
	}
	
	public void saveicon() {
		
	btnSavevalue.click();
				
	}

	public void preView() {
		
	btnPreview.click();
					
	}

	public void Btnmaching() {
		
	btnMatching.click();
						
	}

	public void mergeImg() {
		
	imgMerge.click();
							
	}
	
	public void Rejecticon() {
		
	btnReject.click();
								
	}
	
	public void perviousInvoice() {
		
	beforeInvoice.click();
									
	}
	
	public void nextInvoice() {

	nextInvoice.click();
	
										
	}
	
	public void deleteicon() {
		
	Delete.click();
											
	}
	
	public void linkPendings() {
		
	pendinglink.click();
												
	}
	
	public void vatBtw() {
		
	vatBTW.click();
													
	}
	
	
	
	public String relatie() {
		
	 return Relatie.getAttribute("value");
	 
	 								
	}
	
	public String datum() {
		
	return datum.getAttribute("value");
	
															
	}

	public String Ocrtime() {
		
	return time.getAttribute("value");
		
																
	}

	public String invoicenumber() {	
		
	return invoicenumber.getAttribute("value");
																	
	}


	public String btwperc() {	
		
	return BTWpercentage.getAttribute("value");
																	
	}
	
	
	public String btwledger() {	
		
	return BTWledger.getAttribute("value");
																		
	}
	
	public String btwtotal() {	
		
	return BTWtotal.getAttribute("value");
																			
	}
	
	public String btwDiffamt() {	
		
	return BTWdiffAmount.getAttribute("value");
																				
	}
	
	public String totalecediff() {	
		
	return totalExediff.getAttribute("value");
																					
	}
	
	public String txttotal() {	
		
	return txtTotal.getAttribute("value");
																						
		}
	
	public String bankaccnumber() {	
		
		return bankNumber.getAttribute("value");
																							
			}
	
	public String btwNumber() {	
		
		return btwNum.getAttribute("value");
																							
			}
	
	public void ledgerBrowser() throws InterruptedException {
		
		ledgertextBroswser.clear();
		
		ledgertextBroswser.sendKeys("0100-Goodwill");;
		
	
		
	}
	
	public void excelUpload(String relatie,String date,String amount,String reknum,String BTW,String btwled,String totaldiff,String btwdiffamt,String bankaccnum) throws Exception {
		
		Ocrfileupload ocrupload = new Ocrfileupload();
		
		Thread.sleep(5000);
		
		SoftAssert softAssert = new SoftAssert();
		
	
		String text = ocrupload.relatie();
		
		softAssert.assertEquals(text, relatie);
		
		
		String dat = ocrupload.datum();
		
		softAssert.assertEquals(dat, date);
		
		String totamt = ocrupload.txttotal();
		
		softAssert.assertEquals(totamt, amount);

		String reknumber = ocrupload.bankaccnumber();
		
		softAssert.assertEquals(reknumber, reknum);
		
		String btwNum = ocrupload.btwNumber();
		
		softAssert.assertEquals(btwNum, BTW);
		
		String btwledger = ocrupload.btwledger();
		
		softAssert.assertEquals(btwledger, btwled);
		
		String btwtotamount = ocrupload.btwtotal();
		
		softAssert.assertEquals(btwtotamount, totaldiff);
		
		String totaldifferance = ocrupload.btwDiffamt();
		
		softAssert.assertEquals(totaldifferance, btwdiffamt);
		
		Thread.sleep(3000);
		
		ocrupload.nextInvoice();
		
		Thread.sleep(5000);
			
		softAssert.assertAll();
		
		
		
	}
	
	
	
	
	public boolean retryingFindClick(By by) {
        boolean result = false;
        int attempts = 0;
        while(attempts < 2) {
            try {
                driver.findElement(By.id("txtaccountname")).click();
                result = true;
                break;
            } catch(StaleElementReferenceException e) {
            }
            attempts++;
        }
        return result;
}
	
	
	
	

}
	
	
	
	
	
	
	
	
	