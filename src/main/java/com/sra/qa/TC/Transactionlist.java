package com.sra.qa.TC;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.sra.qa.base.Testbase;

public class Transactionlist extends Testbase {
	
	@FindBy(id="txtCompany")
	WebElement bedRijf;
	
	@FindBy(id="txtAccountName")
	WebElement accounantName;
	
	@FindBy(id="txtSubledgerName")
	WebElement subCatagories;
	
	@FindBy(id="txtStartDate")
	WebElement startDate;
	
	@FindBy(id="txtInvoiceDate")
	WebElement endDate;
	
	@FindBy(id="ddlField")
	WebElement searchField;
	
	@FindBy(id="txtCompanyName")
	WebElement relatie;
	
	@FindBy(id="txtJournalName")
	WebElement jourNal;
	
	@FindBy(id="txtProjectName")
	WebElement proJect; 
	
	@FindBy(id="btnrefersh")
	WebElement reFresh;
	
	public  Transactionlist() {
		
		PageFactory.initElements(driver, this);
		
	}
	public void refreshbtn() {
		
		reFresh.click();
		
	}

	public void company(String company) {
		
		bedRijf.sendKeys(company);
	}

	public void grootboek(String accountname) {
		
		accounantName.sendKeys(accountname);
	}

	
	public void subcatagories(String subs) {
		
		subCatagories.sendKeys(subs);
	}
	
	public void startdate(String stdate) {
		
		startDate.sendKeys(stdate);
	}

	public void endDate(String eddate) {
		
		endDate.sendKeys(eddate);
	}

	public void search(String srch) {
		
		Select field = new Select(searchField);
		
		field.selectByVisibleText(srch);
	}

	public void cmpyName(String cmpyname) {
		
		relatie.sendKeys(cmpyname);
	}

	public void journal(String journalname) {
		
		jourNal.sendKeys(journalname);
	}
	
	public void project(String projectname) {
		
		proJect.sendKeys(projectname);
	}

	
	public void ledgerfiltertest(String ledger ) {
		
		Transactionlist translist = new Transactionlist();
		
		translist.grootboek(ledger);
		
		translist.refreshbtn();
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}


