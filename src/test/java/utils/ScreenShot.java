package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Hooks.BStackDemoHooks;

public class ScreenShot {
	WebDriver driver=BStackDemoHooks.driver;
	 public void  screenshot() throws IOException {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        String path = "./screenShots/" + "screenshot-" + System.currentTimeMillis() + ".png";
	        File dest = new File(path);
	        Files.copy(src.toPath(), dest.toPath());
	        
	    }	

}


