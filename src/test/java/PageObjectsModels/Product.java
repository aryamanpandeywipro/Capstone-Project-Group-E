package PageObjectsModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Product {
    WebDriver driver;

    // Add to Cart button
    @FindBy(xpath = "//*[@id='1']/div[4]")
    WebElement productAddToCart;

    // Add to Wishlist button
    @FindBy(xpath = "//*[@id='1']/div[1]")
    WebElement productAddToWishList;

    // Constructor
    public Product(WebDriver driver){
        this.driver = driver;
    }

    // Return Add to Cart button
    public WebElement productAddToCart(){
        return productAddToCart;
    }

    // Return Add to Wishlist button
    public WebElement productAddToWishList(){
        return productAddToWishList;
    }
}