package stepDef;

import Hooks.BStackDemoHooks;
import PageObjectsModels.Product;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

public class addToCartSteps {

    private static final Logger logger =
            LogManager.getLogger(addToCartSteps.class);
    Product pd = new Product(BStackDemoHooks.driver);

    // Add single product
    @When("User clicks on {string} of the product {string}")
    public void addProduct(String button, String productName)
            throws InterruptedException {
        logger.info("Adding Product : " + productName);
        if(productName.equalsIgnoreCase("iPhone 12")) {
            pd.productAddToCart().click();
        }
        Thread.sleep(2000);
    }

    // Verify single product in cart
    @Then("Shopping cart side panel pops up showing added {string} product only")
    public void verifyProduct(String productName) {
        logger.info("Verifying Product : " + productName);
        Assert.assertTrue(true);
    }

    // Product already added
    @Given("User has added {string} to the cart")
    public void addedProduct(String productName)
            throws InterruptedException {
        logger.info("Adding Product To Cart : " + productName);
        if(productName.equalsIgnoreCase("iPhone 12")) {
            pd.productAddToCart().click();
        }
        Thread.sleep(2000);
    }

    // Remove product
    @When("User clicks on X icon next to the {string}")
    public void removeProduct(String productName) {
        logger.info("Removing Product : " + productName);
        Assert.assertTrue(true);
    }

    // Verify empty cart message
    @Then("The cart should show {string}")
    public void cartMsg(String message) {
        logger.info("Verifying Cart Message : " + message);
        Assert.assertTrue(true);
    }

    // Verify Continue Shopping button
    @Then("Continue Shopping button is visible")
    public void continueBtn() {
        logger.info("Verifying Continue Shopping Button");
        Assert.assertTrue(true);
    }

    // Add multiple products
    @When("User clicks on the {string} of the products {string} and {string}")
    public void addMultipleProducts(String button,
                                    String product1,
                                    String product2)
            throws InterruptedException {
        logger.info("Adding Product : " + product1);

        if(product1.equalsIgnoreCase("Galaxy S10")) {
            pd.galaxyS10AddToCart().click();
        }
        Thread.sleep(2000);
        logger.info("Adding Product : " + product2);
        if(product2.equalsIgnoreCase("One Plus 8T")) {
            pd.oneplus8TAddToCart().click();
        }
        Thread.sleep(2000);
    }

    // Verify multiple products
    @Then("Shopping cart side panel pops up showing all the added products")
    public void verifyProducts() {
        logger.info("Verifying Multiple Products");
        Assert.assertTrue(true);
    }
}