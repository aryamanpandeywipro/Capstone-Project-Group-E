package PageObjectsModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Product {

    WebDriver driver;

    @FindBy(xpath = "//*[@id='1']/div[4]")
    WebElement productAddToCart;
    @FindBy(xpath = "//*[@id='1']/div[1]")
    WebElement productAddToWishList;

    public Product(WebDriver driver){
        this.driver=driver;
    }

    // Returns product add to cart element
    public WebElement productAddToCart(){
        return productAddToCart;
    }

    // Returns product add to wishlist
    public WebElement productAddToWishList(){
        return productAddToWishList;
    }

}
