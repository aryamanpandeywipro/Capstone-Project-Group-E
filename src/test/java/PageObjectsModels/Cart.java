package PageObjectsModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.openqa.selenium.support.locators.RelativeLocator.with;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cart {

    WebDriver driver;
    @FindBy(css = ".bag.bag--float-cart-closed")
    WebElement cartOpenButton;

    @FindBy (className = "float-cart__close-btn")
    WebElement cartCloseButton;


    public Cart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // iphone12
    @FindBy (xpath = "//p[text()='iphone 12']")
    WebElement iphone12Title;

    // removing iphone12 from cart
    public WebElement iphone12Remove(){
        return driver.findElement(with(By.className("shelf-item__del")).toRightOf(iphone12Title));
    }

    // increasing iphone12 quantity
    public WebElement iphone12IncreaseQty(){
        return driver.findElement(with(By.className("change-product-button")).below(iphone12Remove()));
    }

    // decreasing iphone12 quantity
    public WebElement iphone12DecreaseQty(){
        return driver.findElement(with(By.className("change-product-button")).toLeftOf(iphone12IncreaseQty()));
    }


    // Galaxy S10 (Samsung)
    @FindBy(xpath = "//p[text()='Galaxy S10']")
    WebElement galaxyS10Title;

    // removing Galaxy S10 from cart
    public WebElement galaxyS10Remove() {
        return driver.findElement(
                with(By.className("shelf-item__del"))
                        .toRightOf(galaxyS10Title));
    }

    // increasing Galaxy S10 quantity
    public WebElement galaxyS10IncreaseQty() {
        return driver.findElement(
                with(By.className("change-product-button"))
                        .below(galaxyS10Remove()));
    }

    // decreasing Galaxy S10 quantity
    public WebElement galaxyS10DecreaseQty() {
        return driver.findElement(
                with(By.className("change-product-button"))
                        .toLeftOf(galaxyS10IncreaseQty()));
    }

    // OnePlus 8T
    @FindBy(xpath = "//p[text()='One Plus 8T']")
    WebElement onePlus8TTitle;

    // removing OnePlus 8T from cart
    public WebElement onePlus8TRemove() {
        return driver.findElement(
                with(By.className("shelf-item__del"))
                        .toRightOf(onePlus8TTitle));
    }

    // increasing OnePlus 8T quantity
    public WebElement onePlus8TIncreaseQty() {
        return driver.findElement(
                with(By.className("change-product-button"))
                        .below(onePlus8TRemove()));
    }

    // decreasing OnePlus 8T quantity
    public WebElement onePlus8TDecreaseQty() {
        return driver.findElement(
                with(By.className("change-product-button"))
                        .toLeftOf(onePlus8TIncreaseQty()));
    }

    // Checkout Element
    @FindBy (className = "buy-btn")
    WebElement checkout;

    public WebElement checkout(){
        return checkout;
    }
}
 