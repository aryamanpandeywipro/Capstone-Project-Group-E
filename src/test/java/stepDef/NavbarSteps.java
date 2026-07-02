package stepDef;
 
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import Hooks.BStackDemoHooks;
import PageObjectsModels.HomePage;
import PageObjectsModels.NavBar;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
 
public class NavbarSteps {
	private static final Logger logger = LogManager.getLogger(NavbarSteps.class);
 
    NavBar nb = new NavBar(BStackDemoHooks.driver);
    HomePage hp=new HomePage(BStackDemoHooks.driver);
    
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
    
    @When("User enters {string} in search bar")
    public void user_enters_keyword(String keyword) {
        logger.info("Entering keyword in search bar: " + keyword);
        nb.searchBar().clear();
        nb.searchBar().sendKeys(keyword);
    }
 
    @And("User clicks on Search icon")
    public void searchIcon() {
        logger.info("Clicking on Search icon");
        nb.searchButton().click();
    }
 
    @Then("Search results should not be displayed")
    public void verifySearchResultsNotDisplayed() {
        // INTENTIONAL FAILURE – BUG LOG
        logger.error("BUG: Search functionality does not filter products based on keyword entered");
 
        Assert.fail("BUG: Search functionality does not filter products based on keyword entered");
    }
 
    @And("User should see no matching products message")
    public void verifyNoMatchingProductsMessage() {
        logger.warn("No matching products message not displayed – expected behavior");
        Assert.assertTrue(true);
    }
    
    @When("User clicks on Log Out")
    public void clickLogOut() {
    	logger.info("Clicking on Log Out");
    	nb.logout().click();
    	
    }
    
    @Then("User is Logged Out")
    public void verifyLogOut() {
    	Assert.assertTrue(hp.SignInLink().isDisplayed());
    }
    
}
 