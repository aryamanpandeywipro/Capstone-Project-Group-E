package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
 
public class ExtentManager {
 
    private static ExtentReports extent;
 
    public static ExtentReports getReportInstance() {
 
        if (extent == null) {
 
            ExtentSparkReporter spark =
                    new ExtentSparkReporter("./Reports/ExtentReport.html");
 
            extent = new ExtentReports();
            extent.attachReporter(spark);
 
            extent.setSystemInfo("Tester", "Group E");
            extent.setSystemInfo("Environment", "Stage");
        }
 
        return extent;
    }
}




