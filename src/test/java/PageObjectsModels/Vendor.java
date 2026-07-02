package PageObjectsModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Vendor {

    WebDriver driver;

    @FindBy(xpath = "//span[text()='Apple']")
    WebElement appleVendor;

    @FindBy(xpath = "//span[text()='Samsung']")
    WebElement samsungVendor;

    @FindBy(xpath = "//span[text()='Google']")
    WebElement googleVendor;

    @FindBy(xpath = "//span[text()='OnePlus']")
    WebElement oneplusVendor;

    public Vendor(WebDriver driver){
        this.driver=driver;
    }

    // Returns Apple Vendor Filter element
    public WebElement appleVendor(){
        return appleVendor;
    }

    // Returns Samsung Vendor Filter Element
    public WebElement samsungVendor(){
        return samsungVendor;
    }

    // Returns Google Vendor Filter Element
    public WebElement googleVendor(){
        return googleVendor;
    }

    // Returns OnePlus Vendor Filter Element
    public WebElement oneplusVendor(){
        return oneplusVendor;
    }

}
