package Gmail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {

	WebDriver driver;
	
	@FindBy()
	private WebElement Username;
	
	@FindBy()
	private WebElement Password;
	
	@FindBy()
	private WebElement LoginButton;
	
	
	public Loginpage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void inputusername(String args) {
		Username.sendKeys(args);
	}
	
	public void inputpassword(String args) {
		Password.sendKeys(args);
		
	}
	
	public void clickloginbutton() {
		LoginButton.click();
	}
	
	
	
	
	
	
	
	
	
}
