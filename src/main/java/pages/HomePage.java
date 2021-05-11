package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    private By currencyLink = By.cssSelector("#currency-informer > a");
    private By quickSearch = By.cssSelector(".fast-search__input");
    private By iPhoneTitle = By.cssSelector(".result__wrapper > .result__item_product > .product__details > .product__title ");
    private By iframe2 = By.cssSelector(".modal-iframe");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public CurrencyPage clickCurrency(){
        driver.findElement(currencyLink).click();
        return new CurrencyPage(driver);
    }

    public void switchToParentFrame(){
        driver.switchTo().parentFrame();
    }

    public ProductPage clickFirstPhone(){
        driver.findElement(iPhoneTitle).click();
        return new ProductPage(driver);
    }

    public void searchPhone(String name){
        driver.findElement(quickSearch).sendKeys(name);
    }

    public void getCatalog(){
        driver.switchTo().frame(driver.findElement(iframe2));
    }
}
