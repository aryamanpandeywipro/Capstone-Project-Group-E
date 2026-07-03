package PageObjectsModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Cart {

    WebDriver driver;

    // Cart icon
    @FindBy(xpath = "//span[contains(@class,'bag')]")
    WebElement cartButton;

    // Close cart button
    @FindBy(xpath = "//div[contains(@class,'float-cart__close-btn')]")
    WebElement closeCart;

    // Remove product
    @FindBy(xpath = "//*[contains(@class,'shelf-item__del')]")
    WebElement removeItem;

    // Increase quantity
    @FindBy(xpath = "(//button[contains(@class,'change-product-button')])[2]")
    WebElement increaseQuantity;

    // Decrease quantity
    @FindBy(xpath = "(//button[contains(@class,'change-product-button')])[1]")
    WebElement decreaseQuantity;

    // Checkout button
    @FindBy(className = "buy-btn")
    WebElement checkout;

    public Cart(WebDriver driver){
        this.driver = driver;
    }

    // Return cart icon
    public WebElement cartButton(){
        return cartButton;
    }

    // Return close cart button
    public WebElement closeCart(){
        return closeCart;
    }

    // Return remove item button
    public WebElement removeItem(){
        return removeItem;
    }

    // Return increase quantity button
    public WebElement increaseQuantity(){
        return increaseQuantity;
    }

    // Return decrease quantity button
    public WebElement decreaseQuantity(){
        return decreaseQuantity;
    }

    // Return checkout button
    public WebElement checkout(){
        return checkout;
    }
}