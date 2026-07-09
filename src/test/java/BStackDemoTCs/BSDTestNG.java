package BStackDemoTCs;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.qameta.allure.testng.AllureTestNg;
import utils.ExtentManager;
import utils.baseClass;

@Listeners({AllureTestNg.class})
public class BSDTestNG extends baseClass {

    // Extent Report
    private ExtentReports extent;
    private ExtentTest test;

    // Log4j2 Logger
    private static final Logger log = LogManager.getLogger(BSDTestNG.class);

    // Create Extent Report
    @BeforeSuite
    public void setupReport() {

        extent = ExtentManager.getReportInstance();
        log.info("Extent Report initialized successfully");
    }

    // Launch Browser
    @Parameters(value = {"browser"})
    @BeforeClass
    public void CallingBrowser(String browser) {
        invokeBrowser(browser);
        log.info("Chrome Browser launched successfully");
    }

    // Create Test Entry
    @BeforeMethod
    public void createTest() {
        test = extent.createTest("BrowserStack Demo Automation TestNG");
        ExtentManager.setTest(test);
        log.info("Test execution started");
    }

    @Test
    public void BSDTestNG() {

    }

    // Handle Test Result
    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        if(result.getStatus() == ITestResult.FAILURE){
            test.fail("Test Failed");
            screenShot();
        }
    }

    // Close Browser
    @AfterClass
    public void CloseBrowser() throws InterruptedException {
        closeBrowser();
        log.info("Browser closed successfully");
    }

    // Flush Report
    @AfterSuite
    public void closeReport() {
        extent.flush();
        log.info("Extent Report flushed successfully");
    }
}