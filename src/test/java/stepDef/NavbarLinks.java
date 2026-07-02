package stepDef;
 
import Hooks.BStackDemoHooks;
import PageObjectsModels.NavBar;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
 
public class NavbarLinks {
	private static final Logger logger = LogManager.getLogger(NavbarLinks.class);
 
    NavBar nb = new NavBar(BStackDemoHooks.driver);
 
    @Then("User should see navbar logo")
    public void navbarLogo() {
    	logger.info("Verifying navbar logo visibility");
        Assert.assertTrue(nb.logo().isDisplayed());
        logger.info("Navbar logo is displayed successfully");
    }
 
    @And("User should see Offers link")
    public void offersLink() throws InterruptedException {
    	logger.info("Verifying Offers link");
        Assert.assertTrue(nb.offers().isDisplayed());
        logger.info("Clicking on Offers link");
        nb.offers().click();
        Thread.sleep(2000);
        logger.info("Current URL: " +BStackDemoHooks.driver.getCurrentUrl());
        BStackDemoHooks.driver.navigate().back();
        logger.info("Returned back to Home Page");
    }
 
    @And("User should see Orders link")
    public void ordersLink() throws InterruptedException {
    	logger.info("Verifying Orders link");
 
        Assert.assertTrue(nb.orders().isDisplayed());
        logger.info("Clicking on Orders link");
        nb.orders().click();
        Thread.sleep(2000);
        logger.info("Current URL: " +BStackDemoHooks.driver.getCurrentUrl());
        BStackDemoHooks.driver.navigate().back();
        logger.info("Returned back to Home Page");
    }
 
    @And("User should see Favourites link")
    public void favouritesLink() throws InterruptedException {
    	logger.info("Verifying Favourites link");
 
        Assert.assertTrue(nb.favourites().isDisplayed());
        logger.info("Clicking on Favourites link");
        nb.favourites().click();
        Thread.sleep(2000);
        logger.info("Current URL: " +BStackDemoHooks.driver.getCurrentUrl());
        BStackDemoHooks.driver.navigate().back();
        logger.info("Returned back to Home Page");
    }
}
 