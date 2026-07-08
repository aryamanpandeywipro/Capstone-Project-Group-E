package PageObjectsModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Favouritespage {

    WebDriver driver;
    
    public Favouritespage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    
    By favouritesTab= By.xpath("//*[@id='favourites']/strong");

    
 // Iphone 12
    @FindBy(xpath = "//div[@id='1']/div[4]")
    WebElement iphone12AddToCart;

    @FindBy(xpath = "//div[@id='1']/div[1]")
    WebElement iphone12AddToWishList;


    // Samsung Galaxy S10
    @FindBy(xpath = "//div[@id='13']/div[4]")
    WebElement galaxyS10AddToCart;

    @FindBy(xpath = "//div[@id='13']/div[1]")
    WebElement galaxyS10AddToWishList;


    // OnePlus 8T
    @FindBy(xpath = "//div[@id='21']/div[4]")
    WebElement oneplus8TAddToCart;

    @FindBy(xpath = "//div[@id='21']/div[1]")
    WebElement oneplus8TAddToWishList;

    
    public WebElement favouritesTab(){
        return driver.findElement(favouritesTab);
    }

    // Returns iphone12 add to cart element
    public WebElement iphone12AddToCart(){
        return iphone12AddToCart;
    }
    
    // Returns iphone12 add to wishlist element
    public WebElement iphone12AddToWishList(){return iphone12AddToWishList;}

    // Returns galaxyS10 add to cart element
    public WebElement galaxyS10AddToCart(){
        return galaxyS10AddToCart;
    }
    
    // Returns galaxys10 add to wishlist element
    public WebElement galaxyS10AddToWishList(){return galaxyS10AddToWishList;}

    // Returns oneplus8T add to cart element
    public WebElement oneplus8TAddToCart(){
        return oneplus8TAddToCart;
    }
    
    // Returns oneplus8T add to wishlist element
    public WebElement oneplus8TAddToWishList(){return oneplus8TAddToWishList;}


    }