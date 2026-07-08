package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class baseClass {

    public static WebDriver driver;

    //invoke the browser
    public static void invokeBrowser(String browser)
    {
        if(browser.equalsIgnoreCase("Chrome"))
        {
            driver = new ChromeDriver();
            driver.manage().window().maximize();//maximize the window
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        else if(browser.equalsIgnoreCase("EDGE"))
        {
            //invoke edge browser
            driver = new EdgeDriver();
            driver.manage().window().maximize();//maximize the window
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        else if(browser.equalsIgnoreCase("firefox"))
        {
            //invoke firefox browser
            driver = new FirefoxDriver();
            //driver.manage().window().maximize();//maximize the window
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
    }

    public static String screenShot() throws IOException {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = "./screenShots/" + "screenshot-" + System.currentTimeMillis() + ".png";
        File dest = new File(path);
        Files.copy(src.toPath(), dest.toPath());
        return path;
    }


    //close browser
    public static void closeBrowser() throws InterruptedException
    {
        Thread.sleep(2000);
        driver.quit();
    }

}