package com.sra.qa.TC;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sra.qa.base.Testbase;
import com.sra.qa.base.homepage;

public class Loginpage extends Testbase{

	@FindBy(id="lgPlanner_UserName")
	
	WebElement Username;
	
	@FindBy(id="lgPlanner_Password")
	
	WebElement Password;
	
	@FindBy(id="lgPlanner_LoginButton")
	
	WebElement Loginbutton;
	
	@FindBy(id="hypLogin")
	
	WebElement Logoutbutton;
	
	@FindBy(id="kop")
	
	WebElement switchframe;
	
	
	
	public Loginpage() {
		PageFactory.initElements(driver, this);
	}
	
	public Homepage pagelogin(String un,String pwd) {
		Username.sendKeys(un);
		Password.sendKeys(pwd);
		Loginbutton.click();
		//driver.switchTo().frame(switchframe);
		//Logoutbutton.click();
		return null;
		
	}
	

	
	
}
