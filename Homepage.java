package Gmail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {

	WebDriver driver;
	
	
	@FindBy()
	private WebElement Compossemail;
	
	
	@FindBy()
	private WebElement Clickonsendto;
	
	
	@FindBy()
	private WebElement Clickonsub;
	
	
	
	@FindBy()
	private WebElement Clickoncontent;

	@FindBy()
	private WebElement Clicksend;
	
	
	
	
	
	public Homepage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	
	public void clickcompossbutton() {
		
		Compossemail.click();
		
	}
	
    public void clickonsendto(String args) {
		
	Clickonsendto.clear();
	Clickonsendto.sendKeys(args);
     }
	
	public void clickonsub(String args) {
		Clickonsub.clear();
		Clickonsub.sendKeys(args);
	}

	public void clickoncontent(String args) {
		Clickoncontent.clear();
		Clickoncontent.sendKeys(args);
	}
	
	public void clickonsend() {
		Clicksend.submit();
		
	}
	
	
	
}
