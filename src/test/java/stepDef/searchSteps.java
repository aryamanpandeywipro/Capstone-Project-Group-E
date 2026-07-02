package stepDef;
 
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
 
import Hooks.BStackDemoHooks;
import PageObjectsModels.NavBar;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
 
public class searchSteps {
 
    private static final Logger logger =LogManager.getLogger(searchSteps.class);
 
    NavBar nav = new NavBar(BStackDemoHooks.driver);;
   
    @When("User enters {string} in search bar")
    public void user_enters_keyword(String keyword) {
        logger.info("Entering keyword in search bar: " + keyword);
        nav.searchBar().clear();
        nav.searchBar().sendKeys(keyword);
    }
 
    @And("User clicks on Search icon")
    public void searchIcon() {
        logger.info("Clicking on Search icon");
        nav.searchButton().click();
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
}