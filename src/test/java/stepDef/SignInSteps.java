package stepDef;
 
import java.time.Duration;
 
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
import Hooks.BStackDemoHooks;
import PageObjectsModels.HomePage;
import PageObjectsModels.SignInPage;
import PageObjectsModels.NavBar;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
 
 
public class SignInSteps {
 
	// LOGGER
    private static final Logger logger = LogManager.getLogger(SignInSteps.class);
    private final WebDriver driver=BStackDemoHooks.driver;
	private final WebDriverWait wait=new WebDriverWait(BStackDemoHooks.driver,Duration.ofSeconds(10));
 
	HomePage hp=new HomePage(BStackDemoHooks.driver);
	SignInPage sip=new SignInPage(BStackDemoHooks.driver);
	NavBar nb=new NavBar(BStackDemoHooks.driver);
	Actions act = new Actions(BStackDemoHooks.driver);
	
 
    @Given("User is on BStackDemo HomePage")
    public void homePage() {
 
        logger.info("Navigating to BStackDemo Home Page");
        driver.get("https://bstackdemo.com/#");
    }
 
	//----------SCENARIO----------
	
	// Navigating to SignIn Page
	@When("User clicks on {string} link")
	public void clickSignIn(String linkName) {
		logger.info("Clicking on Sign In link");
		hp.SignInLink().click();
		wait.until(ExpectedConditions.visibilityOf(sip.loginButton()));
		logger.info("Sign In page loaded successfully");
	}
	
	@Then("User is redirected to Sign In Page")
	public void verifySignInPage() {
		logger.info("Verifying Sign In page URL");
		Assert.assertTrue(BStackDemoHooks.driver.getCurrentUrl().contains("signin"));
	}
	
	
	//  Signing In
	@When("User selects {string} username from dropdown")
	public void selectUsername(String username) {
		logger.info("Selecting username: " + username);
		sip.usernameBox().click();
		if(username.equals("demouser")) {
			act.sendKeys(Keys.ENTER).perform();
		}else{
			act.sendKeys(Keys.END).sendKeys(Keys.ENTER).perform();
		}	
	}
	
	@And("User selects {string} password from dropdown")
	public void selectPassword(String password) {
		logger.info("Selecting password");
		sip.passwordBox().click();
		act.sendKeys(Keys.ENTER).perform();
	}
	
	@And("User clicks on {string} button")
	public void clickLogInButton(String loginBtn) {
		logger.info("Clicking on Login button");
		sip.loginButton().click();
	}
	
	@Then("User SignIn Status is {string}")
	public void verifySignIn(String signInStatus) throws InterruptedException {
		Thread.sleep(3000);
		if(signInStatus.equals("SignedIn")) {
			logger.info("Verifying successful login");
			Assert.assertTrue("SignedIn ", BStackDemoHooks.driver.getCurrentUrl().contains("signin=true"));
		}else{
			logger.error("Verifying login failure due to locked account");
			String errorMessage=BStackDemoHooks.driver.findElement(By.xpath("//h3[@class='api-error']")).getText();
			Assert.assertEquals(errorMessage,"Your account has been locked.");
		}
	}
	
}