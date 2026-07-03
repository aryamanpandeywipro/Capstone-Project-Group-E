package Hooks;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class BStackDemoHooks {
	 public static WebDriver driver;
	 
	    @Before
	    public void setup() {
	 
	        System.out.println("Launching browser...");
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.get("https://bstackdemo.com/");
	    }
	    
	    @After
	    public void tearDown(Scenario scenario) throws InterruptedException, IOException
	    {
	    	if (scenario.isFailed()) {
	    		 
	            //  Create unique file name
	            String fileName = scenario.getName().replaceAll(" ", "_")
	                              + "_" + System.currentTimeMillis();
	     
	            //  Take screenshot
	            TakesScreenshot ts = (TakesScreenshot) driver;
	            File src = ts.getScreenshotAs(OutputType.FILE);
	     
	            // Define path (your existing folder)
	            String path = "./screenshot/" + fileName + ".png";
	     
	            //  Ensure folder exists
	            File folder = new File("./screenshot/");
	            if (!folder.exists()) {
	                folder.mkdirs();
	            }
	     
	            //  Save screenshot
	            Files.copy(src.toPath(), Paths.get(path));
	     
	            //  Attach to report
	            scenario.attach(ts.getScreenshotAs(OutputType.BYTES), "image/png", fileName);
	     
	            System.out.println("Screenshot saved at: " + path);
	        }
	    	Thread.sleep(2000);
	        driver.quit();
	    }

}
