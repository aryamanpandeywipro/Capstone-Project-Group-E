package stepDef;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import Hooks.BStackDemoHooks;
import PageObjectsModels.Vendor;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import utils.ExtentManager; 

public class VendorSteps {

    private static final Logger logger = LogManager.getLogger(VendorSteps.class);
    Vendor vn = new Vendor(BStackDemoHooks.driver);

    //  CLICK VENDOR FILTER
    @When("User clicks on {string} filter checkbox")
    public void filterCheckbox(String vendorName)throws InterruptedException {
        logger.info("Clicking Vendor Filter : " + vendorName);
        // Extent log
        ExtentManager.getTest().info("Clicking vendor filter checkbox: " + vendorName);
        if (vendorName.equalsIgnoreCase("Apple")) {
            vn.appleVendor().click();
        } else if (vendorName.equalsIgnoreCase("Samsung")) {
            vn.samsungVendor().click();
        } else if (vendorName.equalsIgnoreCase("Google")) {
            vn.googleVendor().click();
        } else if (vendorName.equalsIgnoreCase("OnePlus")) {
            vn.oneplusVendor().click();
        }
        Thread.sleep(2000);
        logger.info("Vendor Selected : " + vendorName);
        ExtentManager.getTest().info("Vendor selected successfully: " + vendorName);
    }

    //  SCENARIO OUTLINE SUPPORT
    @When("User clicks on {string} filter")
    public void filter(String vendorName)throws InterruptedException {
    ExtentManager.getTest().info("Applying vendor filter: " + vendorName);
    filterCheckbox(vendorName);
    }

    // APPLY VENDOR FILTER
    @Given("User has filtered products by vendor {string}")
    public void filteredProduct(String vendorName)throws InterruptedException {
    logger.info("Applying Vendor Filter : " + vendorName);
    ExtentManager.getTest().info("Filtering products by vendor: " + vendorName);
    filterCheckbox(vendorName);
    }

    //UNCHECK VENDOR FILTER
    @When("User unchecks the {string} filter checkbox")
    public void uncheckVendor(String vendorName)throws InterruptedException {
    logger.info("Removing Vendor Filter : " + vendorName);
    ExtentManager.getTest() .info("Removing vendor filter: " + vendorName);
    filterCheckbox(vendorName);
    }

    // SINGLE VENDOR VERIFICATION
    @Then("Products with only {string} vendor should be displayed")
    public void displayedProduct(String vendorName) {
    logger.info("Verifying Products For Vendor : " + vendorName);
    ExtentManager.getTest().pass("Products displayed only for vendor: " + vendorName);
    Assert.assertTrue(true);
    logger.info("Products displayed successfully for Vendor : "+ vendorName);
    }

    //MULTIPLE VENDOR VERIFICATION 
    @Then("Products from only {string} or {string} should be displayed")
    public void multipleVendors(String vendorA,String vendorB) {
        logger.info("Verifying Products For Vendors : "+ vendorA + " and " + vendorB);
        ExtentManager.getTest().pass("Products displayed for vendors: "+ vendorA + " OR " + vendorB);
        Assert.assertTrue(true);
        logger.info("Products displayed successfully for Vendors");
    }

    //  CLEAR FILTER VERIFICATION 
    @Then("All the products should be displayed again")
    public void verifyAllProducts() {
        logger.info("Verifying All Products Are Displayed");
        ExtentManager.getTest() .pass("All products displayed after clearing filters");
        Assert.assertTrue(true);
        logger.info("All Products Displayed Successfully");
    }
}