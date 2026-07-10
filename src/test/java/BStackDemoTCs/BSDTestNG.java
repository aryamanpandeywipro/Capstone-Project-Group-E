package BStackDemoTCs;

import java.io.IOException;
import java.time.Duration;

import PageObjectsModels.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.qameta.allure.testng.AllureTestNg;
import utils.*;
import org.openqa.selenium.interactions.Actions;

@Listeners({AllureTestNg.class})
public class BSDTestNG extends baseClass {
    // Extent Report
    private ExtentReports extent;
    private ExtentTest test;
    private WebDriverWait wait;
    // Logger
    private static final Logger log = LogManager.getLogger(BSDTestNG.class);

    HomePage homePage;
    SignInPage signInPage;
    Cart cart;
    Checkout checkout;
    NavBar navBar;
    Product product;
    Favouritespage favouritespage;
    ConfirmationPage confirmpage;
    ScreenShot ss = new ScreenShot();
    Actions act;


    @BeforeSuite
    public void setupReport() {
        extent = ExtentManager.getReportInstance();
        log.info("Extent Report initialized successfully");
    }

    @BeforeClass
    public void CallingBrowser() {
        log.info("BrowserStack Demo Automation Started");
        invokeBrowser("Chrome");
        log.info("Chrome browser launched successfully");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(dataProperties.getData("url"));
        log.info("Application launched successfully : {}", dataProperties.getData("url"));

        // Initialize all Page Object classes
        homePage = new HomePage(driver);
        signInPage = new SignInPage(driver);
        cart = new Cart(driver);
        checkout = new Checkout(driver);
        navBar = new NavBar(driver);
        product = new Product(driver);
        favouritespage = new Favouritespage(driver);
        confirmpage = new ConfirmationPage(driver);
        act = new Actions(driver);
        log.info("All Page Object Model classes initialized successfully");
    }

    @BeforeMethod
    public void createTest() {
        test = extent.createTest("BrowserStack End To End Purchase Flow");
        ExtentManager.setTest(test);
        test.info("Test execution started");
        log.info("Test Case Execution Started");
    }

    @Test(dataProvider = "excelData", dataProviderClass = ExcelUtils.class)
    public void EndToEndFlow(String firstName,
                             String lastName, String address,
                             String state, String postalCode) throws InterruptedException, IOException {

        log.info("User login process started");
        test.info("Login process started");
        homePage.SignInLink().click();

        log.info("Clicked on Sign In link");
        signInPage.usernameBox().click();
        act.sendKeys(Keys.ENTER).perform();
        log.info("Username selected successfully");

        signInPage.passwordBox().click();
        act.sendKeys(Keys.ENTER).perform();

        log.info("Password selected successfully");
        signInPage.loginButton().click();
        log.info("Login button clicked");

        test.pass("User logged in successfully");


        // Adding products to Wishlist
        log.info("Adding products to Wishlist");
        test.info("Adding products into Wishlist");
        wait.until(ExpectedConditions.elementToBeClickable(product.productAddToWishList())).click();
        log.info("iPhone 12 added to wishlist");

        wait.until(ExpectedConditions.elementToBeClickable(product.galaxyS10AddToWishList())).click();
        log.info("Galaxy S10 added to wishlist");

        wait.until(ExpectedConditions.elementToBeClickable(product.oneplus8TAddToWishList())).click();
        log.info("OnePlus 8T added to wishlist");

        test.pass("Products added successfully into Wishlist");

        navBar.favourites().click();
        wait.until(ExpectedConditions.visibilityOf(
                favouritespage.favouritesTab()));
        String favShot = screenShot();
        test.addScreenCaptureFromPath(favShot);
        log.info("Favorites page screenshot captured successfully");

        // Adding to cart section
        log.info("Navigated to Favorites page");
        wait.until(ExpectedConditions.elementToBeClickable(
                favouritespage.iphone12AddToCart())).click();
        log.info("iPhone 12 added to cart");

        wait.until(ExpectedConditions.elementToBeClickable(
                favouritespage.galaxyS10AddToCart())).click();
        log.info("Galaxy S10 added to cart");
        test.pass("Wishlist products added into Cart successfully");

        // Checkout
        cart.checkout().click();
        log.info("Checkout button clicked");

        wait.until(ExpectedConditions.visibilityOf(checkout.firstName()));
        log.info("Checkout page loaded successfully");
        checkout.firstName().sendKeys(firstName);
        checkout.lastName().sendKeys(lastName);
        checkout.address().sendKeys(address);
        checkout.state().sendKeys(state);
        checkout.postalCode().sendKeys(postalCode);

        log.info("Checkout details entered successfully");
        test.pass("Checkout details entered successfully");

        wait.until(ExpectedConditions.elementToBeClickable(
                checkout.submitButton())).click();

        // Download Receipt and Continue Shopping
        wait.until(ExpectedConditions.elementToBeClickable(confirmpage.downloadReceipt())).click();
        test.pass("Receipt Download Successfully");
        log.info("Receipt Download successfully");

        wait.until(ExpectedConditions.elementToBeClickable(confirmpage.continueShopping())).click();
        test.pass("Continue shopping works ");
        log.info("Continue shopping button works successfully now we are on home page");

        // Continuing with Order section from navbar
        wait.until(ExpectedConditions.elementToBeClickable(navBar.orders())).click();
        log.info("Navigated to Orders page");
        String orderShot = screenShot();
        test.addScreenCaptureFromPath(orderShot);
        log.info("Order History page screenshot captured successfully");
        Thread.sleep(2000);

        wait.until(ExpectedConditions.elementToBeClickable(navBar.logo())).click();
        log.info("Returned back to Home page");
        Thread.sleep(2000);

        wait.until(ExpectedConditions.elementToBeClickable(navBar.logout())).click();
        log.info("User logged out successfully");

        test.pass("Logout functionality verified successfully");
        log.info("End To End Flow completed successfully");
        test.pass("End To End Flow Passed Successfully");
        log.info("End To End Flow executed successfully");

    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.fail("Test Failed");
            screenShot();
        }
    }

    @AfterClass
    public void CloseBrowser() throws InterruptedException {
        closeBrowser();
        log.info("Browser closed successfully");
    }

    @AfterSuite
    public void closeReport() {
        extent.flush();
        log.info("Extent Report flushed successfully");
    }
}