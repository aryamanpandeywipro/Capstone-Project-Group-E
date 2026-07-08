package stepDef;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import Hooks.BStackDemoHooks;
import PageObjectsModels.ProductSort;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ExtentManager;

public class SortingSteps {

    private static final Logger logger = LogManager.getLogger(SortingSteps.class);
    ProductSort ps= new ProductSort(BStackDemoHooks.driver);

    @When("User clicks on the sort filter")
    public void user_clicks_on_the_sort_filter() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        logger.info("User is clicking on the sort filter");
        ExtentManager.getTest().info("User is clicking on the sort filter");

        ps.sortFilter().click();
        Thread.sleep(2000);
    }

    @When("User selects the {string} from the dropdown")
    public void user_selects_the_order_from_the_dropdown(String string) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        logger.info("User selects the "+ string+" from the dropdown");
        ExtentManager.getTest().info("User selects the "+ string+" from the dropdown");

        if (string.equalsIgnoreCase("Select")){
            ps.sortFilter().click();
        }
        else if (string.equalsIgnoreCase("Lowest to highest")){
            ps.lowestToHighest().click();
        }
        else if (string.equalsIgnoreCase("Highest to lowest")){
            ps.highestToLowest().click();
        }
        Thread.sleep(2000);
    }

    @Then("Products are sorted in {string} order")
    public void products_are_sorted_in_order(String string) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        logger.info("Products are sorted in "+ string+" order");
        ExtentManager.getTest().info("Products are sorted in "+string+" order");

        List<Double> actualList= ps.getProductPrices();
        List<Double> expectedList= new ArrayList<>(actualList);

        if (string.equalsIgnoreCase("Ascending")){
            Collections.sort(expectedList);

            Assert.assertEquals("Products are not sorted in Ascending order",actualList,expectedList);
        }
        else if (string.equalsIgnoreCase("Descending")) {
            Collections.sort(expectedList,Collections.reverseOrder());

            Assert.assertEquals("Products are not sorted in Descending order",actualList, expectedList);
        }

        else if (string.equalsIgnoreCase("Default")) {
            Assert.assertTrue( "Sort filter is not displayed",ps.sortFilter().isDisplayed());
            Thread.sleep(2000);
        }
    }
}
