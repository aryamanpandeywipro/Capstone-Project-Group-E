package stepDef;

import Hooks.BStackDemoHooks;
import PageObjectsModels.NavBar;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class NavbarLinks {

    NavBar nb = new NavBar(BStackDemoHooks.driver);

    @Then("User should see navbar logo")
    public void navbarLogo() {
        Assert.assertTrue(nb.logo().isDisplayed());
        System.out.println("Navbar Logo is displayed successfully");
    }

    @And("User should see Offers link")
    public void offersLink() throws InterruptedException {

        Assert.assertTrue(nb.offers().isDisplayed());
        System.out.println("Offers Link is displayed");

        nb.offers().click();
        System.out.println("Clicked on Offers Link");

        Thread.sleep(2000);

        System.out.println("Current URL : "
                + BStackDemoHooks.driver.getCurrentUrl());

        BStackDemoHooks.driver.navigate().back();
        System.out.println("Returned back to Home Page");
    }

    @And("User should see Orders link")
    public void ordersLink() throws InterruptedException {

        Assert.assertTrue(nb.orders().isDisplayed());
        System.out.println("Orders Link is displayed");

        nb.orders().click();
        System.out.println("Clicked on Orders Link");

        Thread.sleep(2000);

        System.out.println("Current URL : "
                + BStackDemoHooks.driver.getCurrentUrl());

        BStackDemoHooks.driver.navigate().back();
        System.out.println("Returned back to Home Page");
    }

    @And("User should see Favourites link")
    public void favouritesLink() throws InterruptedException {

        Assert.assertTrue(nb.favourites().isDisplayed());
        System.out.println("Favourites Link is displayed");

        nb.favourites().click();
        System.out.println("Clicked on Favourites Link");

        Thread.sleep(2000);

        System.out.println("Current URL : "
                + BStackDemoHooks.driver.getCurrentUrl());

        BStackDemoHooks.driver.navigate().back();
        System.out.println("Returned back to Home Page");
    }
}