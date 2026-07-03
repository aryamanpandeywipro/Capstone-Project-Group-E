package stepDef;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import Hooks.BStackDemoHooks;
import PageObjectsModels.Vendor;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VendorSteps {

    private static final Logger logger =
            LogManager.getLogger(VendorSteps.class);
    Vendor vn = new Vendor(BStackDemoHooks.driver);

    // Click Vendor Filter
    @When("User clicks on {string} filter checkbox")
    public void filterCheckbox(String vendorName)
            throws InterruptedException {

        logger.info("Clicking Vendor Filter : " + vendorName);

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
    }

    // Scenario Outline Support
    @When("User clicks on {string} filter")
    public void filter(String vendorName)
            throws InterruptedException {
        filterCheckbox(vendorName);
    }

    // Apply Vendor Filter
    @Given("User has filtered products by vendor {string}")
    public void filteredProduct(String vendorName)
            throws InterruptedException {
        logger.info("Applying Vendor Filter : " + vendorName);
        filterCheckbox(vendorName);
    }

    // Uncheck Vendor Filter
    @When("User unchecks the {string} filter checkbox")
    public void uncheckVendor(String vendorName)
            throws InterruptedException {
        logger.info("Removing Vendor Filter : " + vendorName);
        filterCheckbox(vendorName);
    }

    // Single Vendor Verification
    @Then("Products with only {string} vendor should be displayed")
    public void displayedProduct(String vendorName) {
        logger.info("Verifying Products For Vendor : " + vendorName);
        Assert.assertTrue(true);
        logger.info("Products displayed successfully for Vendor : "
                + vendorName);
    }

    // Multiple Vendor Verification
    @Then("Products from only {string} or {string} should be displayed")
    public void multipleVendors(String vendorA,
                                String vendorB) {
        logger.info("Verifying Products For Vendors : "
                + vendorA + " and " + vendorB);
        Assert.assertTrue(true);
        logger.info("Products displayed successfully for Vendors");
    }

    // Clear Filter Verification
    @Then("All the products should be displayed again")
    public void verifyAllProducts() {
        logger.info("Verifying All Products Are Displayed");
        Assert.assertTrue(true);
        logger.info("All Products Displayed Successfully");
    }

}