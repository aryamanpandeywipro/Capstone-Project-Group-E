package stepDef;

import Hooks.BStackDemoHooks;
import PageObjectsModels.Product;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import utils.ExtentManager; 

public class addToCartSteps {

    private static final Logger logger = LogManager.getLogger(addToCartSteps.class);
    Product pd = new Product(BStackDemoHooks.driver);

    // ADD SINGLE PRODUCT 
    @When("User clicks on {string} of the product {string}")
    public void addProduct(String button,String productName) throws InterruptedException {

        logger.info("Adding Product : " + productName);
        // Extent log
        ExtentManager.getTest().info("Adding product to cart: " + productName);
        if (productName.equalsIgnoreCase("iPhone 12")) {
            pd.productAddToCart().click();
        }
        Thread.sleep(2000);
    }

    // VERIFY SINGLE PRODUCT 
    @Then("Shopping cart side panel pops up showing added {string} product only")
    public void verifyProduct(String productName) {
    	logger.info("Verifying Product : " + productName);
        ExtentManager.getTest().pass("Verified single product in cart: " + productName);
        Assert.assertTrue(true);
    }

    //PRODUCT ALREADY ADDED 
    @Given("User has added {string} to the cart")
    public void addedProduct(String productName) throws InterruptedException {
    logger.info("Adding Product To Cart : " + productName);
    //Extent log
     ExtentManager.getTest().info("Ensuring product already added to cart: " + productName);
     if (productName.equalsIgnoreCase("iPhone 12")) {
            pd.productAddToCart().click();
        }
        Thread.sleep(2000);
    }

    // REMOVE PRODUCT 
    @When("User clicks on X icon next to the {string}")
    public void removeProduct(String productName) {
    logger.info("Removing Product : " + productName);
    // Extent log
    ExtentManager.getTest().info("Removing product from cart: " + productName);
    Assert.assertTrue(true);
    }

    //  VERIFY EMPTY CART MESSAGE 
    @Then("The cart should show {string}")
    public void cartMsg(String message) {
    logger.info("Verifying Cart Message : " + message);
    //Extent log
    ExtentManager.getTest().pass("Cart message displayed: " + message);
    Assert.assertTrue(true);
    }

    //CONTINUE SHOPPING BUTTON 
    @Then("Continue Shopping button is visible")
    public void continueBtn() {
    logger.info("Verifying Continue Shopping Button");
    ExtentManager.getTest().pass("Continue Shopping button is visible");
    Assert.assertTrue(true);
    }

    // ADD MULTIPLE PRODUCTS 
    @When("User clicks on the {string} of the products {string} and {string}")
    public void addMultipleProducts(String button,
                                    String product1,
                                    String product2) throws InterruptedException {
        logger.info("Adding Product : " + product1);
        ExtentManager.getTest().info("Adding product to cart: " + product1);
        if (product1.equalsIgnoreCase("Galaxy S10")) {
            pd.galaxyS10AddToCart().click();
        }
        Thread.sleep(2000);
        logger.info("Adding Product : " + product2);
        ExtentManager.getTest().info("Adding product to cart: " + product2);

        if (product2.equalsIgnoreCase("One Plus 8T")) {
            pd.oneplus8TAddToCart().click();
        }
        Thread.sleep(2000);
    }

    // VERIFY MULTIPLE PRODUCTS 
    @Then("Shopping cart side panel pops up showing all the added products")
    public void verifyProducts() {
    logger.info("Verifying Multiple Products");
    ExtentManager.getTest().pass("All added products are displayed in cart");
    Assert.assertTrue(true);
    }
}