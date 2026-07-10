package PageObjectsModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	// Constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Sign In link
	@FindBy(xpath = "//span[@id='signin']")
	WebElement SignInLink;

	// Return Sign In link
	public WebElement SignInLink() {
		return SignInLink;
	}
}