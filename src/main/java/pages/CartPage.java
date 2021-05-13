package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CartPage {
    // Var's
    private WebDriver driver;
    private By title = By.cssSelector(".cart-form__title_big-alter");
    private By productTitle = By.cssSelector(".cart-form__offers-item_secondary > .cart-form__offers-flex > .cart-form__offers-part_data > .cart-form__description_font-weight_semibold > a");
    private By deleteFromCart = By.cssSelector(".cart-form__offers-part_action > .cart-form__offers-flex a.cart-form__button_remove");
    private By deleteFormCartBlock = By.cssSelector("div.cart-form__offers-part_action");
    private By closeCart = By.linkText("Закрыть");
    private By titleEmptyCart = By.cssSelector(".cart-message__title_big");

    public CartPage(WebDriver driver){
        this.driver = driver;
    }

    public String getCartTitle(){
        return driver.findElement(title).getText();
    }

    public String getCartProductTitle(){
        return driver.findElement(productTitle).getText();
    }

    public void deleteProductFromCart(){
        Actions actions = new Actions(driver);
        WebElement price2 = driver.findElement(deleteFormCartBlock);
        actions.moveToElement(price2).perform();
        driver.findElement(deleteFromCart).click();
    }

    public void closeCart(){
        driver.findElement(closeCart).click();
    }

    public String getEmptyTitle(){
        return driver.findElement(titleEmptyCart).getText();
    }
}
