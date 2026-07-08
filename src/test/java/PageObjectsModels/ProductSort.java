package PageObjectsModels;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductSort {

    WebDriver driver;
    public ProductSort(WebDriver driver){
        this.driver=driver;
    }

    By sortFilter = By.xpath("//select");
    By lowestToHighest= By.xpath("//select/option[2]");
    By highestToLowest= By.xpath("//select/option[3]");
    By productPrices = By.xpath("//div[@class='val']");

    

    public WebElement sortFilter(){
        return driver.findElement(sortFilter);
    }

    public WebElement lowestToHighest(){
        return driver.findElement(lowestToHighest);
    }

    public WebElement highestToLowest(){
        return driver.findElement(highestToLowest);
    }

    public List<Double> getProductPrices(){

        List<WebElement> priceElements = driver.findElements(productPrices);
        List<Double> prices= new ArrayList<>();

        for (WebElement element: priceElements){
            String price= element.getText().replace("$","").trim();
            prices.add(Double.parseDouble(price));
        }
        return prices;
    }
}
