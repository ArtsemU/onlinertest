package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    private By currencyLink = By.cssSelector("#currency-informer > a");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public CurrencyPage clickCurrency(){
        driver.findElement(currencyLink).click();
        return new CurrencyPage(driver);
    }




}
