package mytests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import pages.Currency;
import pages.CurrencyPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CurrencyTests extends BaseTests{

    final Logger logger = LoggerFactory.getLogger(CurrencyTests.class);

    @Test
    public void checkTitle(){
        logger.info("checkTitle test is started");
        CurrencyPage currPage = homePage.clickCurrency();
        String expected = currPage.getTitleText();
        assertTrue(expected.contains("Лучшие курсы валют"));
    }

    @Test
    public void checkCalculatedAmount(){
        logger.info("checkCalculatedAmount test is started");
        CurrencyPage currPage = homePage.clickCurrency();
        currPage.inputAmount("200");
        String expected = currPage.getResultAmount();
        assertEquals(expected, "507");
    }

    @Test
    public void calulateValues(){
        logger.info("calulateValues test is started");
        CurrencyPage currPage = homePage.clickCurrency();
        currPage.inputAmount("200");
        String observed = currPage.getResultAmount();
        Currency currField = currPage.getElement(0);
        double expectedResult = currField.calculatedAmount(200);
        double result = Double.parseDouble(observed.replace(',','.'));
        assertTrue(Math.abs(expectedResult-result) < 0.00001);
    }
}
