package utils;
 
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
 
public class ExtentManager {
 
    
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
 
    // Create or return ExtentReports instance
    public static ExtentReports getReportInstance() {
 
        if (extent == null) {
 
            // SAFE absolute path 
            String reportPath = System.getProperty("user.dir") + "/Reports/ExtentReport.html";
 
            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
 
            extent = new ExtentReports();
            extent.attachReporter(spark);
 
            // System information
            extent.setSystemInfo("Project", "Capstone Project");
            extent.setSystemInfo("Tester", "Group E");
            extent.setSystemInfo("Environment", "Stage");
        }
 
        return extent;
    }
 
    // Store ExtentTest created in Hooks
    public static void setTest(ExtentTest test) {
    extentTest.set(test);
    }
 
    // Retrieve ExtentTest in Step Definitions
    public static ExtentTest getTest() {
    return extentTest.get();
    }
}

