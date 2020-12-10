package Gmail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class baseclass {

	public static void main(String []args) {
	
	System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe")	;
		
	WebDriver driver=new ChromeDriver();
	
	driver.get("http://gmail.com");
	
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	
	}
	
	
	
	
}
