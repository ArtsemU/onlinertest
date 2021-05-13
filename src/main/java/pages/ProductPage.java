package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ProductPage {

    private WebDriver driver;

    private By title = By.cssSelector(".catalog-masthead__title");
    private By description = By.cssSelector(".offers-description__specs > p");
    private By tableElements = By.cssSelector(".product-specs__table > tbody");
    private By priceBlock = By.cssSelector(".product-aside__item-i");
    private By cart = By.cssSelector(".auth-bar__counter");
    private By cartLink = By.cssSelector(".auth-bar__item--cart");


    public ProductPage(WebDriver driver){
        this.driver = driver;
    }

    public String getTitle(){
        return driver.findElement(title).getText();
    }

    public String getDescription(){
        return driver.findElement(description).getText();
    }

    public CartPage clickOnCart(){
        driver.findElement(cartLink).click();
        return new CartPage(driver);
    }

    public void hoverOverPriceAndBuy(int index){
        Actions actions = new Actions(driver);
        WebElement price2 = driver.findElements(priceBlock).get(index);
        actions.moveToElement(price2).perform();
        driver.findElement(By.cssSelector("a.product-aside__item-button")).click();
    }
}
