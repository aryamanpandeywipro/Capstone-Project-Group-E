package PageObjectsModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Cart {

    WebDriver driver;

    @FindBy (xpath = "//span[contains(@class,'bag')]")
    WebElement cartButton;

    @FindBy (xpath = "//div[contains(@class,'float-cart__close-btn')]")
    WebElement closeCart;

    @FindBy (xpath = "//*[contains(@class,'shelf-item__del')]")
    WebElement removeItem;

    @FindBy (xpath = "(//button[contains(@class,'change-product-button')])[2]")
    WebElement increaseQuantity;

    @FindBy (xpath = "(//button[contains(@class,'change-product-button')])[1]")
    WebElement decreaseQuantity;

    @FindBy (className = "buy-btn")
    WebElement checkout;

    public Cart(WebDriver driver){
        this.driver=driver;
    }

    // Returns cart button element
    public WebElement cartButton(){
        return cartButton;
    }

    // Returns close cart element
    public WebElement closeCart(){
        return closeCart;
    }

    // Returns remove item from cart element
    public WebElement removeItem(){
        return removeItem;
    }

    // Returns increase quantity element
    public WebElement increaseQuantity(){
        return increaseQuantity;
    }

    // Returns decrease quantity element
    public WebElement decreaseQuantity(){
        return decreaseQuantity;
    }

    // Returns checkout element
    public WebElement checkout(){
        return checkout;
    }
}
