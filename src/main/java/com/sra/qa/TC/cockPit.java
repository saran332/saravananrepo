package com.sra.qa.TC;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.sra.qa.base.Testbase;

public class cockPit extends Testbase{
	
	@FindBy(id="txtAccName")
	WebElement Klant;
	
	@FindBy(id="txtCompany")
	WebElement Company;
	
	@FindBy(id="StartDatetxt")
	WebElement startDate;
	
	@FindBy(id="Enddatetxt")
	WebElement endDate;
	
	@FindBy(id="lblAuditFiles")
	WebElement auditFile;
	
	@FindBy(id="lblAdhoc")
	WebElement adHoc;
	
	@FindBy(id="lblBankImport")
	WebElement bankImport;
	
	@FindBy(id="lblQuestions")
	WebElement questions;
	
	@FindBy(id="lblUploadTransactions")
	WebElement tranSactions;
	
	@FindBy(id="lblEnrichment")
	WebElement enrichment;
	
	@FindBy(id="btnrefersh")
	WebElement referancebtn;
	
	@FindBy(id="btnCreate")
	WebElement addNewauditFile;
	
	@FindBy(id="ddlaudittypes")
	WebElement auditfileType;
	
	@FindBy(id="btnSourceUploadFile")
	WebElement upLoadauditFile;
	
	@FindBy(id="btnsaveaccount")
	WebElement submitButton;
	
	
	@FindBy(id="chkGroup")
	WebElement groupingCheckbox;
	
	@FindBy(xpath="//*[@id=\"tblUploadTransactionsList\"]/tbody/tr[1]/td[4]/div/a")
	WebElement inwatchinginvoice;
	
	@FindBy(id="mainwindow")
	WebElement switchtomain;
	
	@FindBy(id="btnBack")
	WebElement backicon;
	
	@FindBy(id="btndelete")
	WebElement deleteicon;
	
	
	public cockPit() {
		PageFactory.initElements(driver, this);
		
	}
	
	public void groupingcheckbox() {
		
		inwatchinginvoice.click();
		
		
	}
	
	public void inwatchinginvoice() throws InterruptedException {
		
		inwatchinginvoice.click();
		
		Thread.sleep(10000);
		
		
		
		
	}
	
	public void deleteinvoice() throws InterruptedException {
		
		driver.switchTo().activeElement();
		
		deleteicon.click();
		
		Select drop = new Select(driver.findElement(By.id("DropDownList2")));
		
		drop.selectByIndex(2);
		
		driver.findElement(By.id("btnDeleteYes")).click();
		
		Thread.sleep(5000);
		
		backicon.click();
		
	}
	
	
	public void adminbrowser (String klant) {
		
		Klant.clear();
		
		Klant.sendKeys(klant);
				
	}
	
	public void startdate (String date) {
		
		startDate.sendKeys(date);
				
	}
	
	public void enddate (String edate) {
		
		endDate.sendKeys(edate);
				
	}
	
	public void referance () {
		
		referancebtn.click();
				
	}
	
	public void createNewAuditfile () {
		
		addNewauditFile.click();
				
	}
	
	public void auditType (String filename) {
		
		Select select = new Select(auditfileType);
		
		select.selectByVisibleText(filename);
				
	}
	
	public void imPortAuditfile () {
		
		upLoadauditFile.sendKeys("C:\\Saran\\SRAauto\\Sra\\XML\\XmlAuditfileFinancieel3.2_test (1).xml");
				
	}
	
	public void submitButton () {
		
		submitButton.sendKeys("C:\\Saran\\SRAauto\\Sra\\XML\\XmlAuditfileFinancieel3.2_test (1).xml");
				
	}
	
	public void adhoctest() {
		
		adHoc.click();
				
	}
	
	public void bankimport() {
		
		bankImport.click();
				
	}
	
	public void auditBestand() {
		
		auditFile.click();
				
	}
	
	public void companyname(String cmpny) {
		
		Company.sendKeys(cmpny);
				
	}
	
	public void transactionstab() {
		
		tranSactions.click();
				
	}
	
	
	public void search(String klant,String cmpny, String date, String edate,String filename) throws InterruptedException {
		
		cockPit cockpit = new cockPit();
		
		cockpit.auditBestand();
		
		cockpit.adminbrowser(klant);
		
		cockpit.companyname(cmpny);
		
		cockpit.startdate(date);
		
		cockpit.enddate(edate);
		
		cockpit.referance();
		
		Thread.sleep(3000);
		
//		cockpit.createNewAuditfile();
//		
//		cockpit.auditType(filename);
//		
//		cockpit.imPortAuditfile();
//		
//		cockpit.submitButton();
		
				
	}
	
	
	public void adhoc() throws InterruptedException {
		
		cockPit cockpit = new cockPit();
		
		cockpit.adhoctest();
		
		Thread.sleep(5000);
		
	}
	
	public void bankimportan() {
		
		cockPit cockpit = new cockPit();
		
		cockpit.bankimport();
		
	}
	
	public void auditBestandtab() {
		
		cockPit cockpit = new cockPit();
		
		cockpit.auditBestand();
		
	}
	
	public void transactiontab() throws InterruptedException {
		
		cockPit cockpit = new cockPit();
		
		cockpit.transactionstab();
		
		Thread.sleep(10000);
		
	}

	public void groupingCheckbox() throws InterruptedException {
		
		cockPit cockpit = new cockPit();
		
		Company.clear();
		
		Klant.clear();
		
		cockpit.groupingCheckbox();
		
		Thread.sleep(10000);
		
		cockpit.referance();
		
		Thread.sleep(10000);
		
		
	}
	
	
	
	

}
