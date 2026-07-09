package stepDef;

import static Hooks.BStackDemoHooks.driver;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import PageObjectsModels.Cart;
import PageObjectsModels.Favouritespage;
import PageObjectsModels.NavBar;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ExtentManager;

public class FavouritesSteps {

    private static final Logger logger = LogManager.getLogger(FavouritesSteps.class);
    Favouritespage fp = new Favouritespage(driver);
    NavBar nb= new NavBar(driver);
    Cart c= new Cart(driver);
    WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));

    @When("User Clicks the heart icon on the {string} product")
    public void adding_iphone12_toFavourites(String string) throws InterruptedException {

        logger.info("Adding Product to Favourites : " + string);
        ExtentManager.getTest().info("Adding product to favourites: " + string);

        if (string.equalsIgnoreCase("iphone12")) {
            fp.iphone12AddToWishList().click();
        }
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
    }

    @When("User clicks on the {string} tab in the NavBar")
    public void user_clicks_on_Favourites_tab(String string) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        logger.info("Clicking Navbar Tab : " + string);
        ExtentManager.getTest().info("Clicking Navbar Tab : " + string);

        if (string.equalsIgnoreCase("Favourites")) {
            fp.favouritesTab().click();
        }
        wait.until(ExpectedConditions.urlContains("favourites"));
    }

    @Then("User is redirected to the Favourites page and can see the products added")
    public void user_is_redirected_to_the_favourites_page() {

        logger.info("Verifying navigation to Favourites page");
        ExtentManager.getTest().info("Verifying navigation to Favourites page");

        Assert.assertTrue(
                driver.getCurrentUrl().contains("favourites"),
                "The user is not navigated to favourites page");
    }

    @When("User clicks on the heart icon again of the {string}")
    public void user_removes_the_product_from_wishlist(String string) throws InterruptedException {
        logger.info("Removing Product from Favourites : " + string);
        ExtentManager.getTest().info("Removing Product from Favourites : " + string);

        if (string.equalsIgnoreCase("iPhone12")) {
        	wait.until(ExpectedConditions.elementToBeClickable(fp.iphone12AddToWishList()));
            fp.iphone12AddToWishList().click();
        }
    }

    @Then("{string} product gets removed from the favourites list")
    public void product_gets_removed_from_the_favourites_list(String string) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions

        logger.info("Verifying product removed from favourites : " + string);
        ExtentManager.getTest().info("Verifying product removed from favourites : " + string);

        Assert.assertTrue(
                driver.findElements(By.xpath("//div[@id='1']/div[1]")).isEmpty(),
                string + " is still present in favourites"
        );
    }

    @When("User clicks on {string} of the favourite product {string}")
    public void user_adds_iphone12_to_cart_from_favourites(String string, String string2) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions

        logger.info("Clicking " + string + " for product : " + string2);
        ExtentManager.getTest().info("Clicking " + string + " for product : " + string2);

        if (string2.equalsIgnoreCase("iphone12")) {
        	wait.until(ExpectedConditions.elementToBeClickable(fp.iphone12AddToWishList()));
            fp.iphone12AddToWishList().click();
            wait.until(ExpectedConditions.elementToBeClickable(nb.favourites()));
            nb.favourites().click();
            System.out.println("favourites clicked");
            wait.until(ExpectedConditions.elementToBeClickable(fp.iphone12AddToCart()));
            WebElement addToCart= fp.iphone12AddToCart();
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click()",addToCart);
            System.out.println("add to cart clicked");
        }
    }

    @Then("Shopping cart side panel pops up showing favourite {string} product only")
    public void shopping_cart_side_panel_pops_up_showing_added_product_only(String string) {
        // Write code here that turns the phrase above into concrete actions

        logger.info("Verifying shopping cart side panel for product : " + string);
        ExtentManager.getTest().info("Verifying shopping cart side panel for product : " + string);

        if (string.equalsIgnoreCase("iphone12")){
            Assert.assertTrue(c.checkout().isDisplayed(),"The shopping cart side panel is not popped up");
            Assert.assertTrue(c.iphone12Remove().isDisplayed(), "The cart does not contain " + string);
        }
    }

}
 