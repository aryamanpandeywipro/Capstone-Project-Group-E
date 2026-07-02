package stepDef;

import org.junit.Assert;
import org.openqa.selenium.By;

import Hooks.BStackDemoHooks;
import PageObjectsModels.NavBar;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class searchSteps {

    NavBar nav;
    int productCountBefore;
    int productCountAfter;

    @When("User enters {string} in search bar")
    public void user_enters_keyword(String keyword) {

        nav = new NavBar(BStackDemoHooks.driver);

        //  Product count BEFORE search
        productCountBefore = BStackDemoHooks.driver
                .findElements(By.className("shelf-item"))
                .size();

        nav.searchBar().clear();
        nav.searchBar().sendKeys(keyword);
    }

    @And("User clicks on Search icon")
    public void searchIcon() {
        nav.searchButton().click();
    }

    @Then("Search results should not be displayed")
    public void verifySearchResultsNotDisplayed() {

        //  Product count AFTER search
        productCountAfter = BStackDemoHooks.driver
                .findElements(By.className("shelf-item"))
                .size();

     // INTENTIONAL FAILURE
        Assert.fail(
            "BUG: Search functionality does not filter products based on keyword entered"
        );
    }

    @And("User should see no matching products message")
    public void verifyNoMatchingProductsMessage() {
        // Not displayed in BSTACKDEMO – intentional
        Assert.assertTrue(true);
    }
}