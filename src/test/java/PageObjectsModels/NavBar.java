package PageObjectsModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavBar {

	WebDriver driver;
	
	// Constructor
		public NavBar(WebDriver driver) {
			this.driver = driver;
		}

	// Navbar logo
	By logo = By.className("Navbar_logo__image__3Blki");

	// Offers link
	By offers = By.xpath("//*[@id='offers']/strong");

	// Orders link
	By orders = By.xpath("//*[@id='orders']/strong");

	// Favourites link
	By favourites = By.xpath("//*[@id='favourites']/strong");

	// Search text box
	By searchBar = By.xpath("//input[@type='text']");

	// Search button
	By searchButton = By.xpath("//button[contains(@class,'px-4')]");

	// Logged in username
	By usernameDisplay = By.className("username");

	// Logout button
	By logout = By.xpath("//*[@id='signin']");

	

	// Return navbar logo
	public WebElement logo() {
		return driver.findElement(logo);
	}

	// Return Offers link
	public WebElement offers() {
		return driver.findElement(offers);
	}

	// Return Orders link
	public WebElement orders() {
		return driver.findElement(orders);
	}

	// Return Favourites link
	public WebElement favourites() {
		return driver.findElement(favourites);
	}

	// Return search bar
	public WebElement searchBar() {
		return driver.findElement(searchBar);
	}

	// Return search button
	public WebElement searchButton() {
		return driver.findElement(searchButton);
	}

	// Return username
	public WebElement usernameDisplay() {
		return driver.findElement(usernameDisplay);
	}

	// Return logout button
	public WebElement logout() {
		return driver.findElement(logout);
	}
}