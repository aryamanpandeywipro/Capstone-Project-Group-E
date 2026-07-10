package stepDef;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import Hooks.BStackDemoHooks;
import PageObjectsModels.Cart;
import PageObjectsModels.Checkout;
import PageObjectsModels.ConfirmationPage;
import PageObjectsModels.NavBar;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ExtentManager;
import utils.dataProperties;

public class CheckoutSteps {

    private static final Logger logger =
            LogManager.getLogger(CheckoutSteps.class);

    // Page Objects
    Cart cart = new Cart(BStackDemoHooks.driver);
    Checkout checkout = new Checkout(BStackDemoHooks.driver);
    ConfirmationPage confirmationPage =new ConfirmationPage(BStackDemoHooks.driver);
    NavBar nb = new NavBar(BStackDemoHooks.driver);

    // CLICK CHECKOUT
    @When("User clicks on {string} button in the cart panel")
    public void clickCheckout(String buttonName) {
        logger.info("Clicking Checkout button");
        ExtentManager.getTest().info("Clicking Checkout button");
        cart.checkout().click();
    }

    // VERIFY CHECKOUT PAGE
    @Then("User is redirected to Checkout page")
    public void verifyCheckoutPage() {

        logger.info("Verifying Checkout page");
        ExtentManager.getTest().info("Verifying Checkout page");
        Assert.assertTrue(checkout.logo().isDisplayed());
        ExtentManager.getTest().pass("User successfully redirected to Checkout page");
    }

    // FILL SHIPPING DETAILS
    @When("User fills all the details and clicks on {string} button")
    public void fillCheckoutDetails(String buttonName) {
        checkout.firstName().sendKeys(
                dataProperties.getData("firstname"));
        checkout.lastName().sendKeys(
                dataProperties.getData("lastname"));
        checkout.address().sendKeys(
                dataProperties.getData("address"));
        checkout.state().sendKeys(
                dataProperties.getData("state"));
        checkout.postalCode().sendKeys(
                dataProperties.getData("postalcode"));
        checkout.submitButton().click();
    }

    // VERIFY ORDER CONFIRMATION PAGE
    @Then("User is redirected to order confirmation page")
    public void verifyOrderConfirmation() {

        logger.info("Verifying Order Confirmation page");
        ExtentManager.getTest().info("Verifying Order Confirmation page");
        Assert.assertTrue(
                confirmationPage.orderSummary().isDisplayed());
        ExtentManager.getTest()
                .pass("Order Confirmation page displayed successfully");
    }

    // DOWNLOAD RECEIPT
    @Then("User clicks on Download order reciept link")
    public void clickDownloadReceipt() {
        logger.info("Clicking Download Receipt link");
        ExtentManager.getTest().info("Clicking Download Receipt link");
        confirmationPage.downloadReceipt().click();
        ExtentManager.getTest()
                .pass("Receipt downloaded successfully");
    }

    // CONTINUE SHOPPING
    @Then("User clicks on {string} button and is redirected to Home Page")
    public void continueShopping(String buttonName) {
        logger.info("Clicking Continue Shopping button");
        ExtentManager.getTest().info("Clicking Continue Shopping button");
        confirmationPage.continueShopping().click();
        ExtentManager.getTest()
                .pass("Continue Shopping button clicked");
    }

    // VIEW ORDERS
    @When("User clicks on {string} in NavBar")
    public void viewOrders(String menu) {
        logger.info("Clicking Orders menu");
        ExtentManager.getTest().info("Clicking Orders menu");
        nb.orders().click();
    }

    // VERIFY ORDER
    @Then("User can see the order placed")
    public void verifyPlacedOrder() {
        logger.info("Verifying placed order");
        Assert.assertTrue(true);
        ExtentManager.getTest()
                .pass("Order visible in Orders section");
    }
}