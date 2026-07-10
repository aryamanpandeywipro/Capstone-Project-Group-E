package PageObjectsModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

	WebDriver driver;

	// Constructor
	public SignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Username dropdown
	@FindBy(xpath = "//div[@id='username']")
	WebElement usernameBox;

	// Password dropdown
	@FindBy(xpath = "//div[@id='password']")
	WebElement passwordBox;

	// Login button
	@FindBy(xpath = "//button[@id='login-btn']")
	WebElement loginButton;

	// Return username dropdown
	public WebElement usernameBox() {
		return usernameBox;
	}

	// Return password dropdown
	public WebElement passwordBox() {
		return passwordBox;
	}

	// Return login button
	public WebElement loginButton() {
		return loginButton;
	}

}