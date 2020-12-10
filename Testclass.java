package Gmail;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Testclass extends baseclass {
	WebDriver driver;
	
	Homepage objhomepage;
	Loginpage objloginpage;
	
	
	@Test
	public void Loginpage() {
	objloginpage = new Loginpage(driver);
	objloginpage.inputusername("saravananselva");
	objloginpage.inputpassword("Qwerty@1234");
	objloginpage.clickloginbutton();
	
	}
	
	@Test
	public void Homepage() throws AWTException, IOException {
		objhomepage = new Homepage(driver);
		objhomepage.clickcompossbutton();
		objhomepage.clickonsendto("prakashgowda");
		objhomepage.clickonsub("suma");
		objhomepage.clickoncontent("Onum ila ");
		
		
		
		
		objhomepage.clickonsend();
		
	}
	
	
	
	
	

}
