package PageObjectsModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Checkout {
	WebDriver driver;
	public Checkout(WebDriver driver){
	    this.driver=driver;
	}

	By logo= By.xpath("//a[contains(@class,'checkoutHeader-link')]");
	By firstName= By.id("firstNameInput");
	By lastName= By.id("lastNameInput");
	By address= By.id("addressLine1Input");
	By state= By.id("provinceInput");
	By postalCode= By.id("postCodeInput");
	By submitButton= By.id("checkout-shipping-continue");

	

	public WebElement logo(){
	    return driver.findElement(logo);
	}

	public WebElement firstName(){
	    return driver.findElement(firstName);
	}

	public WebElement lastName(){
	    return driver.findElement(lastName);
	}

	public WebElement address(){
	    return driver.findElement(address);
	}

	public WebElement state(){
	    return driver.findElement(state);
	}

	public WebElement postalCode(){
	    return driver.findElement(postalCode);
	}

	public WebElement submitButton(){
	    return driver.findElement(submitButton);
	}

}
