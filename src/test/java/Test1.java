import io.qameta.allure.*;
import model.CurrencyRates;
import org.testng.annotations.Test;

import javax.ws.rs.core.Response;

import static org.testng.Assert.*;
import static utils.PropertyFileHandler.*;
import static utils.UriUtil.buildURI;

public class Test1 extends BaseTest {

    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 1, description = "Verify Successful call to the resource")
    @Description("Verify Successful call to the resource")
    @Epic("Allure reports example")
    @Feature("Feature1: Successful call")
    @Step("Story: Verify call with all normal parameters")
    @Link("https://fixer.io/documentation")
    public void testCorrectResponse() {

        uri = buildURI(BASE_URL, LATEST_DATE, ACCESS_KEY, "", SYMBOLS);
        invocationBuilder = customClientBuilder.getInvocationBuilder(uri);

        CurrencyRates currencyRates = invocationBuilder.get(CurrencyRates.class);
        Response response = invocationBuilder.get();

        assertEquals(response.getStatus(), 200, " Response status not OK");
        assertTrue(currencyRates.isSuccess(), " Rates not success !!");
        assertNull(currencyRates.getError(), " Rates error !!");
        assertEquals(currencyRates.getRates().getEUR(), 1.0, " Rate for EUR not 1.0");
        assertNotEquals(currencyRates.getRates().getPLN(), 0, " Rate for PLN not calculated");
        assertNotEquals(currencyRates.getRates().getUSD(), 0, " Rate for USD not calculated");
        assertNotEquals(currencyRates.getRates().getUAH(), 0, " Rate for UAH not calculated");
    }
}
