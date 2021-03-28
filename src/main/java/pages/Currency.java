package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Currency {
    private WebElement element;
    private By title = By.cssSelector("td > .abbr > b");
    private By values = By.cssSelector(".value > b");

    public Currency(WebElement element){
        this.element = element;
    }

    public String getTitle(){
        return element.findElement(title).getText();
    }

    public String getBankBuys(){
        return element.findElements(values).get(0).getText();
    }

    public String getBankSells(){
        return element.findElements(values).get(1).getText();
    }

    public String getBankNBRB(){
        return element.findElements(values).get(2).getText();
    }

    public double calculatedAmount(double value){
        String x = element.findElements(values).get(0).getText();
        x = x.replace(',','.');
        double d = Double.parseDouble(x);
        double result = d * value;
        return result;
    }
}
