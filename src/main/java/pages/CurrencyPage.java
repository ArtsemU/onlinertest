package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CurrencyPage {

    private WebDriver driver;
    private By titleText = By.cssSelector(".b-currency-main__top > h1");
    private By amountInput = By.cssSelector("#amount-in");
    private By resultAmount = By.cssSelector(".js-cur-result");

    private By elements = By.cssSelector(".b-currency-table__best");
    private By elementsTest = By.cssSelector(".tr-main");



    public CurrencyPage(WebDriver driver){
        this.driver = driver;
    }

    public String getTitleText(){
        return driver.findElement(titleText).getText();
    }

    public void inputAmount(String value){
        driver.findElement(amountInput).clear();
        driver.findElement(amountInput).sendKeys(value);
    }

    public String getResultAmount(){
        return driver.findElement(resultAmount).getText();
    }

    public Currency getElement(int index){
        WebElement element = driver.findElements(elements).get(index);
        return new Currency(element.findElement(elementsTest));
    }


}
