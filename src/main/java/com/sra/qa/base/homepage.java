package com.sra.qa.base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class homepage {
	
	@FindBy(id="lblheaderModules")
	@CacheLookup
	WebElement module;
	
	@FindBy(id="txtSearch")
	@CacheLookup
	WebElement txtbox;
	
	@FindBy(id="btnDelegation")
	@CacheLookup
	WebElement delegate;
	
	
	
	
	
	

}
