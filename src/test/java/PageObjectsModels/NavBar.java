package PageObjectsModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavBar {

    WebDriver driver;

    By logo= By.className("Navbar_logo__image__3Blki");
    By offers= By.xpath("//*[@id='offers']/strong");
    By orders= By.xpath("//*[@id='orders']/strong");
    By favourites= By.xpath("//*[@id='favourites']/strong");

    By searchBar= By.xpath("//input[@type='text']");
    By searchButton= By.xpath("//button[contains(@class,'px-4')]");

    By usernameDisplay= By.className("username");
    By logout= By.xpath("//*[@id='signin']");

    public NavBar(WebDriver driver){
        this.driver=driver;
    }

    public WebElement logo(){
        return driver.findElement(logo);
    }

    public WebElement offers() {
        return driver.findElement(offers);
    }

    public WebElement orders() {
        return driver.findElement(orders);
    }

    public WebElement favourites() {
        return driver.findElement(favourites);
    }

    public WebElement searchBar() {
        return driver.findElement(searchBar);
    }

    public WebElement searchButton() {
        return driver.findElement(searchButton);
    }

    public WebElement usernameDisplay() {
        return driver.findElement(usernameDisplay);
    }

    public WebElement logout() {
        return driver.findElement(logout);
    }

}
