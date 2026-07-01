package stepDef;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Hooks.BStackDemoHooks;
import PageObjectsModels.HomePage;
import PageObjectsModels.SignInPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignInSteps {
	HomePage hp;
	SignInPage sip;
	private final WebDriver driver=BStackDemoHooks.driver;
	private final WebDriverWait wait=new WebDriverWait(BStackDemoHooks.driver,Duration.ofSeconds(10));
	
	@Given("User is on BStackDemo HomePage")
	public void homePage() {
		driver.get("https://bstackdemo.com/#");
	
	}
	//----------SCENARIOS----------
	
	// Navigating to SignIn Page
	@When("User clicks on {string} link")
	public void clickSignIn(String linkName) {
		hp=new HomePage(BStackDemoHooks.driver);
		sip=new SignInPage(BStackDemoHooks.driver);
		hp.SignInLink().click();
		wait.until(ExpectedConditions.visibilityOf(sip.loginButton()));
	}
	
	@Then("User is redirected to Sign In Page")
	public void verifySignInPage() {
		Assert.assertTrue(BStackDemoHooks.driver.getCurrentUrl().contains("signin"));
	}
	
	@When("User selects {string} username from dropdown")
	public void selectUsername(String username) {
		
	}
	
	@And("User selects {string} password from dropdown")
	public void selectPassword(String password) {
		
	}
	
	@And("User clicks on {string} button")
	public void clickLogInButton(String loginBtn) {
		
	}
	
	@Then("User is Signed In successfully and redirected to HomePage where username is visible in Navbar")
	public void verifySignIn() {
		
	}
	
}
