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

public class Methods {
	
	public Methods() throws AWTException, IOException {
		Robot robot=new Robot();
		Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rec=new Rectangle(dim);
		BufferedImage img=robot.createScreenCapture(rec);
		File file =new File("");
		ImageIO.write(img, "png", file);
		
		
		
		
		
	}
	
	
	
	
	

}
