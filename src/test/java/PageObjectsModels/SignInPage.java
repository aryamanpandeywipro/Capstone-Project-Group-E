package PageObjectsModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
	WebDriver driver;
	
	public  SignInPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@id='username']")WebElement usernameBox;
	@FindBy(xpath="//div[@id='password']")WebElement passwordBox;
	@FindBy(xpath="//button[@id='login-btn']")WebElement loginButton;
	
	public WebElement usernameBox() {
		return usernameBox;
	}
	
	public WebElement passwordBox() {
		return passwordBox;
	}
	
	public WebElement loginButton() {
		return loginButton;
	}


}
