package Hooks;
 
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
 
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
 
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
 
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ExtentManager;
 
public class BStackDemoHooks {
 
    // WebDriver instance 
    public static WebDriver driver;
 
    // Log4j Logger for execution logs
    private static final Logger logger = LogManager.getLogger(BStackDemoHooks.class);
 
    // ExtentReports instance
    private static ExtentReports extent = ExtentManager.getReportInstance();
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
 
    // This method runs BEFORE every Cucumber scenario
    @Before
    public void setup(Scenario scenario) {
 
        // Log browser launch
        logger.info("Launching browser");
 
        // Initialize Chrome browser
        driver = new ChromeDriver();
 
        // Maximize window
        driver.manage().window().maximize();
 
        // Apply implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 
        // Navigate to application
        driver.get("https://bstackdemo.com/");
        logger.info("Navigated to BSTACKDEMO application");
 
        // Create Extent test for current scenario
        ExtentTest test = extent.createTest(scenario.getName());
 
        extentTest.set(test);
        ExtentManager.setTest(test);
    }
 
    // This method runs AFTER every Cucumber scenario
    @After
    public void tearDown(Scenario scenario)
            throws IOException, InterruptedException {
 
            // If scenario FAILED
            if (scenario.isFailed()) {
 
            // Mark scenario FAILED in Extent report
            extentTest.get().fail("Scenario FAILED: " + scenario.getName());
 
            // Log failure
            logger.error("Scenario FAILED: " + scenario.getName());
 
            // Take screenshot
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
 
            // Create screenshot file name
            String fileName = scenario.getName().replaceAll(" ", "_") + "_" + System.currentTimeMillis();
 
            // Screenshot path
            String path = "./screenshot/" + fileName + ".png";
 
            // Create screenshot folder if not present
            File folder = new File("./screenshot/");
            if (!folder.exists()) {
                folder.mkdirs();
            }
 
            // Save screenshot
            Files.copy(src.toPath(),
            Paths.get(path));
 
            // Attach screenshot to Extent report
            extentTest.get().addScreenCaptureFromPath(path);
 
            // Attach screenshot to Cucumber report
            scenario.attach(ts.getScreenshotAs(OutputType.BYTES),"image/png",fileName);
 
            logger.error("Screenshot saved at: " + path);
        }
        else {
            // Mark scenario PASSED in Extent report
            extentTest.get().pass("Scenario PASSED");
 
            logger.info("Scenario PASSED: " + scenario.getName());
        }
 
        // Write all Extent logs to HTML file
        extent.flush();
 
        // Small wait before closing browser
        Thread.sleep(2000);
 
        // Close browser
        logger.info("Closing browser");
        driver.quit();
    }
}
