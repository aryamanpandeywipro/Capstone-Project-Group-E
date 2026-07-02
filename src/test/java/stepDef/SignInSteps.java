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

public class SignInSteps {
	HomePage hp=new HomePage(BStackDemoHooks.driver);
	SignInPage sip=new SignInPage(BStackDemoHooks.driver);
	NavBar nb=new NavBar(BStackDemoHooks.driver);
	Actions act = new Actions(BStackDemoHooks.driver);
	
	private final WebDriver driver=BStackDemoHooks.driver;
	private final WebDriverWait wait=new WebDriverWait(BStackDemoHooks.driver,Duration.ofSeconds(10));
	
	@Given("User is on BStackDemo HomePage")
	public void homePage() {
		driver.get("https://bstackdemo.com/#");
	
	}
	//----------SCENARIO----------
	
	// Navigating to SignIn Page
	@When("User clicks on {string} link")
	public void clickSignIn(String linkName) {
		hp.SignInLink().click();
		wait.until(ExpectedConditions.visibilityOf(sip.loginButton()));
	}
	
	@Then("User is redirected to Sign In Page")
	public void verifySignInPage() {
		Assert.assertTrue(BStackDemoHooks.driver.getCurrentUrl().contains("signin"));
	}
	
	
	//  Signing In
	@When("User selects {string} username from dropdown")
	public void selectUsername(String username) {
		sip.usernameBox().click();
		if(username.equals("demouser")) {
			act.sendKeys(Keys.ENTER).perform();
		}else{
			act.sendKeys(Keys.END).sendKeys(Keys.ENTER).perform();
		}	
	}
	
	@And("User selects {string} password from dropdown")
	public void selectPassword(String password) {
		sip.passwordBox().click();
		act.sendKeys(Keys.ENTER).perform();
	}
	
	@And("User clicks on {string} button")
	public void clickLogInButton(String loginBtn) {
		sip.loginButton().click();
	}
	
	@Then("User SignIn Status is {string}")
	public void verifySignIn(String signInStatus) throws InterruptedException {
		Thread.sleep(3000);
		if(signInStatus.equals("SignedIn")) {
			Assert.assertTrue("SignedIn ", BStackDemoHooks.driver.getCurrentUrl().contains("signin=true"));
		}else{
			String errorMessage=BStackDemoHooks.driver.findElement(By.xpath("//h3[@class='api-error']")).getText();
			Assert.assertEquals(errorMessage,"Your account has been locked.");
		}
	}
	
}
