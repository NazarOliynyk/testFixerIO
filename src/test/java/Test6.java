import io.qameta.allure.*;
import model.CurrencyRates;
import org.testng.annotations.Test;

import javax.ws.rs.core.Response;
import java.util.Date;

import static org.testng.Assert.*;
import static utils.PropertyFileHandler.*;
import static utils.UriUtil.buildURI;

public class Test6 extends BaseTest {

    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 6, description = "Verify call to the resource and check if the date matches to current date")
    @Description("Verify call to the resource and check if the date matches to current date")
    @Epic("Allure reports example")
    @Feature("Feature1: date of response matches with current date")
    @Step("Story: Verify if the date of response matches with current date")
    @Link("https://fixer.io/documentation")
    public void testDatesMatch() {

        uri = buildURI(BASE_URL, LATEST_DATE, ACCESS_KEY, "", SYMBOLS);
        invocationBuilder = customClientBuilder.getInvocationBuilder(uri);

        CurrencyRates currencyRates = invocationBuilder.get(CurrencyRates.class);
        Response response = invocationBuilder.get();

        assertEquals(response.getStatus(), 200, " Response status not OK");
        assertTrue(currencyRates.isSuccess(), " Rates not success !!");
        assertNull(currencyRates.getError(), " Rates error !!");
        assertEquals(currencyRates.getDate(), new Date(), " Date does not match");
        assertEquals(currencyRates.getRates().getEUR(), 1.0, " Rate for EUR not 1.0");
        assertNotEquals(currencyRates.getRates().getPLN(), 0, " Rate for PLN not calculated");
        assertNotEquals(currencyRates.getRates().getUSD(), 0, " Rate for USD not calculated");
        assertNotEquals(currencyRates.getRates().getUAH(), 0, " Rate for UAH not calculated");
    }
}
