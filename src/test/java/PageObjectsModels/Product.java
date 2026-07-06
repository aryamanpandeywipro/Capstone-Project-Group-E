package PageObjectsModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Product {

    WebDriver driver;

    // Iphone 12
    @FindBy(css = "[id='1'] > div.shelf-item__buy-btn")
    WebElement iphone12AddToCart;
    @FindBy(css = "#\\31  > div.shelf-stopper > button > span.MuiIconButton-label > svg")
    WebElement iphone12AddToWishList;

    // Samsung Galaxy S10
    @FindBy(css = "[id='13'] > div.shelf-item__buy-btn")
    WebElement galaxyS10AddToCart;
    @FindBy(css = "#\\31 3 > div.shelf-stopper > button > span.MuiIconButton-label > svg")
    WebElement galaxyS10AddToWishList;

    // Oneplus 8T
    @FindBy(css = "[id='21'] > div.shelf-item__buy-btn")
    WebElement oneplus8TAddToCart;
    @FindBy(css = "#\\32 1 > div.shelf-stopper > button > span.MuiIconButton-label > svg")
    WebElement oneplus8TAddToWishList;

    public Product(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    // Returns iphone12 add to cart element
    public WebElement productAddToCart(){
        return iphone12AddToCart;
    }

    // Returns iphone12 add to wishlist
    public WebElement productAddToWishList(){
        return iphone12AddToWishList;
    }

    // Returns galaxyS10 add to cart element
    public WebElement galaxyS10AddToCart(){
        return galaxyS10AddToCart;
    }

    // Returns galaxyS10 add to wish list element
    public WebElement galaxyS10AddToWishList(){
        return galaxyS10AddToWishList;
    }

    // Returns oneplus8T add to cart element
    public WebElement oneplus8TAddToCart(){
        return oneplus8TAddToCart;
    }

    // Returns oneplus8T add to wishlist
    public WebElement oneplus8TAddToWishList(){
        return oneplus8TAddToWishList;
    }
}
