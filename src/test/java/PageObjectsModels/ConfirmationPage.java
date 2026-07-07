package PageObjectsModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConfirmationPage {
    WebDriver driver;
    By downloadReceipt = By.cssSelector(".underline.cursor-pointer");
    By continueShoppingButton= By.xpath("//button[contains(@class,'button--tertiary')]");
    By orderSummary= By.cssSelector(".cart.optimizedCheckout-orderSummary");

    public ConfirmationPage(WebDriver driver){
        this.driver=driver;
    }

    // Get download receipt element
    public WebElement downloadReceipt(){
        return driver.findElement(downloadReceipt);
    }

    // Get continue shopping element
    public WebElement continueShopping(){
        return driver.findElement(continueShoppingButton);
    }

    // Get order summary element
    public WebElement orderSummary(){
        return driver.findElement(orderSummary);
    }
}