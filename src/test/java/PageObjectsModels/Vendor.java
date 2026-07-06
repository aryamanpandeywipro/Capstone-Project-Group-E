package PageObjectsModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Vendor {

    WebDriver driver;

    // Apple vendor filter
    @FindBy(xpath = "//span[text()='Apple']")
    WebElement appleVendor;

    // Samsung vendor filter
    @FindBy(xpath = "//span[text()='Samsung']")
    WebElement samsungVendor;

    // Google vendor filter
    @FindBy(xpath = "//span[text()='Google']")
    WebElement googleVendor;

    // OnePlus vendor filter
    @FindBy(xpath = "//span[text()='OnePlus']")
    WebElement oneplusVendor;

    // Constructor
    public Vendor(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Return Apple filter
    public WebElement appleVendor(){
        return appleVendor;
    }

    // Return Samsung filter
    public WebElement samsungVendor(){
        return samsungVendor;
    }

    // Return Google filter
    public WebElement googleVendor(){
        return googleVendor;
    }

    // Return OnePlus filter
    public WebElement oneplusVendor(){
        return oneplusVendor;
    }
}