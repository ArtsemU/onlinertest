package mytests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import pages.CartPage;
import pages.ProductPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProductTests extends BaseTests{

    // Main test
    @Test
    public void CheckAndDeleteiPhone(){
        homePage.searchPhone("Apple iPhone");
        homePage.getCatalog();
        ProductPage iphone = homePage.clickFirstPhone();
        assertTrue(iphone.getTitle().contains("Apple iPhone"), "Not equals");
        assertTrue(iphone.getDescription().contains("Apple iOS, экран 6.1\" IPS (828x1792), Apple A13 Bionic, ОЗУ 4 ГБ"));
        iphone.hoverOverPriceAndBuy(1);
        CartPage cart = iphone.clickOnCart();
        assertEquals(cart.getCartTitle(),"Корзина");
        assertTrue(cart.getCartProductTitle().contains("Apple iPhone"));
        cart.deleteProductFromCart();
        cart.closeCart();
        assertTrue(cart.getEmptyTitle().contains("Ваша корзина пуста"));
    }
}
