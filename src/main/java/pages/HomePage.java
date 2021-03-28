package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;

    private By currencyLink = By.cssSelector("#currency-informer > a");
    private By navigationText = By.cssSelector(".b-main-navigation__text");
    private By quickSearch = By.cssSelector(".fast-search__form > .fast-search__input");

    private By resultItems = By.cssSelector("div.result__item");
    private By productDetails = By.cssSelector(".product__details > .product__title");


    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public CurrencyPage clickCurrency(){
        driver.findElement(currencyLink).click();
        return new CurrencyPage(driver);
    }

    // NEED CHECK!!!
    public String getCatalogMenu(int item){
        return driver.findElements(navigationText).get(item).getText();
    }

    public void searchProduct(String product){
        driver.findElement(quickSearch).sendKeys(product);
    }

    public ProductPage selectFirstProduct(){
        WebElement item = driver.findElements(resultItems).get(0);
        item.findElement(productDetails).click();
        return new ProductPage(driver);
    }

    public ProductPage testMethod_del_it(){
        driver.get("https://catalog.onliner.by/mobile/apple/iphone7pr128");
        return new ProductPage(driver);
    }


}
