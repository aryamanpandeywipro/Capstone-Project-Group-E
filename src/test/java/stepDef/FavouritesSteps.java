package stepDef;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import Hooks.BStackDemoHooks;
import PageObjectsModels.Cart;
import PageObjectsModels.Favouritespage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ExtentManager;

public class FavouritesSteps{

    private static final Logger logger = LogManager.getLogger(FavouritesSteps.class);
    Favouritespage fp = new Favouritespage(BStackDemoHooks.driver);
    Cart c= new Cart(BStackDemoHooks.driver);

    @When("User Clicks the heart icon on the {string} product")
    public void adding_iphone12_toFavourites(String string) throws InterruptedException {

        logger.info("Adding Product to Favourites : " + string);
        ExtentManager.getTest().info("Adding product to favourites: " + string);

        if (string.equalsIgnoreCase("iphone 12")) {
            fp.iphone12AddToWishList().click();
        }
        Thread.sleep(2000);
    }

    @When("User clicks on the heart icon of the {string} and {string} products")
    public void adding_galaxys10_and_oneplus_to_wishlist(String string, String string2) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        logger.info("Adding Product to Favourites : " + string + "," + string2);
        ExtentManager.getTest().info("Adding products to favourites: " + string + "," + string2);

        if (string.equalsIgnoreCase("Galaxy s10")
                && string2.equalsIgnoreCase("One Plus 8T")) {
            fp.galaxyS10AddToWishList().click();
            fp.oneplus8TAddToWishList().click();
        }
        Thread.sleep(2000);
    }

    @When("User clicks on the {string} tab in the NavBar")
    public void user_clicks_on_Favourites_tab(String string) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        logger.info("Clicking Navbar Tab : " + string);
        ExtentManager.getTest().info("Clicking Navbar Tab : " + string);

        if (string.equalsIgnoreCase("Favourites")) {
            fp.favouritesTab().click();
        }
        Thread.sleep(2000);
    }

    @Then("User is redirected to the Favourites page and can see the products added")
    public void user_is_redirected_to_the_favourites_page() {

        logger.info("Verifying navigation to Favourites page");
        ExtentManager.getTest().info("Verifying navigation to Favourites page");

        Assert.assertTrue("The user is not navigated to favourites page",BStackDemoHooks.driver.getCurrentUrl().contains("favourites"));
    }

    @When("User clicks on the heart icon again of the {string}")
    public void user_removes_the_product_from_wishlist(String string) throws InterruptedException {
        logger.info("Removing Product from Favourites : " + string);
        ExtentManager.getTest().info("Removing Product from Favourites : " + string);

        if (string.equalsIgnoreCase("iPhone 12")) {
            fp.iphone12AddToWishList().click();
        }
        Thread.sleep(2000);
    }

    @Then("{string} product gets removed from the favourites list")
    public void product_gets_removed_from_the_favourites_list(String string) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions

        logger.info("Verifying product removed from favourites : " + string);
        ExtentManager.getTest().info("Verifying product removed from favourites : " + string);

        Assert.assertTrue(  string+ " is not removed",fp.iphone12AddToWishList().isDisplayed());
        Thread.sleep(2000);
    }

    @When("User clicks on the {string} of the product {string}")
    public void user_adds_iphone12_to_cart_from_favourites(String string, String string2) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions

        logger.info("Clicking " + string + " for product : " + string2);
        ExtentManager.getTest().info("Clicking " + string + " for product : " + string2);

        if (string2.equalsIgnoreCase("iphone 12")) {
            fp.favouritesTab().click();
            fp.iphone12AddToWishList().click();
            fp.iphone12AddToCart().click();
        }
        Thread.sleep(2000);
    }

    @Then("Shopping cart panel pops up showing added {string} product only")
    public void shopping_cart_panel_pops_up_showing_added_product_only(String string) {
        // Write code here that turns the phrase above into concrete actions

        logger.info("Verifying shopping cart side panel for product : " + string);
        ExtentManager.getTest().info("Verifying shopping cart side panel for product : " + string);

        if (string.equalsIgnoreCase("iphone 12")){
            Assert.assertTrue("The shopping cart side panel is not popped up",c.checkout().isDisplayed());
            Assert.assertTrue( "The cart does not contain " + string,c.iphone12Remove().isDisplayed());
        }
    }

}