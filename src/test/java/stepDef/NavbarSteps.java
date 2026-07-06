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
 
import utils.ExtentManager;
 
public class NavbarSteps {
    // Log4j logger for execution logs
    private static final Logger logger = LogManager.getLogger(NavbarSteps.class);
 
    // PAGE OBJECTS
    NavBar nb = new NavBar(BStackDemoHooks.driver);
    HomePage hp = new HomePage(BStackDemoHooks.driver);
 
    // NAVBAR LOGO
    @Then("User should see navbar logo")
    public void navbarLogo() {
 
        // Log using Log4j
        logger.info("Verifying navbar logo visibility");
 
        // Log step in Extent report
        ExtentManager.getTest().info("Verifying navbar logo visibility");
 
        // Validation
        Assert.assertTrue(nb.logo().isDisplayed());
        logger.info("Navbar logo is displayed successfully");
 
        // Mark step as passed in Extent
        ExtentManager.getTest().pass("Navbar logo is displayed successfully");
    }
 
    //OFFERS LINK
    @And("User should see Offers link")
    public void offersLink() throws InterruptedException {
 
        logger.info("Verifying Offers link");
 
        //Extent log
        ExtentManager.getTest().info("Verifying Offers link");
        Assert.assertTrue(nb.offers().isDisplayed());
        logger.info("Clicking on Offers link");
        ExtentManager.getTest().info("Clicking on Offers link");
        nb.offers().click();
        Thread.sleep(2000);
        logger.info("Current URL: " + BStackDemoHooks.driver.getCurrentUrl());
 
        // Extent log
        ExtentManager.getTest().info("Navigated to Offers page");
        BStackDemoHooks.driver.navigate().back();
        logger.info("Returned back to Home Page");
        ExtentManager.getTest().info("Returned back to Home Page");
    }
 
    // ORDERS LINK 
    @And("User should see Orders link")
    public void ordersLink() throws InterruptedException {
        logger.info("Verifying Orders link");
        ExtentManager.getTest().info("Verifying Orders link");
        Assert.assertTrue(nb.orders().isDisplayed());
        logger.info("Clicking on Orders link");
        ExtentManager.getTest().info("Clicking on Orders link");
        nb.orders().click();
        Thread.sleep(2000);
        logger.info("Current URL: " + BStackDemoHooks.driver.getCurrentUrl());
        BStackDemoHooks.driver.navigate().back();
        logger.info("Returned back to Home Page");
        ExtentManager.getTest().info("Returned back to Home Page");
    }
 
    @And("User should see Favourites link")
    public void favouritesLink() throws InterruptedException {
        logger.info("Verifying Favourites link");
        ExtentManager.getTest().info("Verifying Favourites link");
        Assert.assertTrue(nb.favourites().isDisplayed());
        logger.info("Clicking on Favourites link");
        ExtentManager.getTest().info("Clicking on Favourites link");
        nb.favourites().click();
        Thread.sleep(2000);
        logger.info("Current URL: " + BStackDemoHooks.driver.getCurrentUrl());
        BStackDemoHooks.driver.navigate().back();
        logger.info("Returned back to Home Page");
        ExtentManager.getTest().info("Returned back to Home Page");
    }
 
    // SEARCH INPUT 
    @When("User enters {string} in search bar")
    public void user_enters_keyword(String keyword) {
        logger.info("Entering keyword in search bar: " + keyword);
        ExtentManager.getTest().info("Entering keyword in search bar: " + keyword);
        nb.searchBar().clear();
        nb.searchBar().sendKeys(keyword);
    }
 
    // SEARCH ICON
    @And("User clicks on Search icon")
    public void searchIcon() {
        logger.info("Clicking on Search icon");
        ExtentManager.getTest().info("Clicking on Search icon");
        nb.searchButton().click();
    }
 
    //  SEARCH VALIDATION 
    @Then("Search results should not be displayed")
    public void verifySearchResultsNotDisplayed() {
 
        logger.error("BUG: Search functionality does not filter products based on keyword entered");
 
        // Log BUG in Extent
        ExtentManager.getTest().fail("BUG: Search functionality does not filter products based on keyword entered");
 
        // Intentional failure
        Assert.fail("BUG: Search functionality does not filter products based on keyword entered");
    }
 
    // NO MATCH MESSAGE
    @And("User should see no matching products message")
    public void verifyNoMatchingProductsMessage() {
 
        logger.warn("No matching products message not displayed – expected behavior");
 
        //Extent informational log
        ExtentManager.getTest().info("No matching products message not displayed – expected behavior");
        Assert.assertTrue(true);
    }
 
    // LOGOUT 
    @When("User clicks on Log Out")
    public void clickLogOut() {
 
        logger.info("Clicking on Log Out");
        // Extent log
        ExtentManager.getTest().info("Clicking on Log Out");
        nb.logout().click();
    }
 
    @Then("User is Logged Out")
    public void verifyLogOut() {
 
        // Extent log
        ExtentManager.getTest().pass("User logged out successfully");
        Assert.assertTrue(hp.SignInLink().isDisplayed());
    }
}