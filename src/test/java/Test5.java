import io.qameta.allure.*;
import model.CurrencyRates;
import org.testng.annotations.Test;

import javax.ws.rs.core.Response;

import static org.testng.Assert.*;
import static utils.PropertyFileHandler.*;
import static utils.UriUtil.buildURI;

public class Test5 extends BaseTest {

    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 5, description = "Verify call to the resource with the incomplete set of symbols")
    @Description("Verify call to the resource with the incomplete set of symbols")
    @Epic("Allure reports example")
    @Feature("Feature1: call with the incomplete symbols")
    @Step("Story: Verify call with the incomplete set of symbols to check that the symbol, which is not in set, is not present in the response")
    @Link("https://fixer.io/documentation")
    public void testResponseWithIncompleteSymbols() {

        uri = buildURI(BASE_URL, LATEST_DATE, ACCESS_KEY, "", INCOMPLETE_SYMBOLS);
        invocationBuilder = customClientBuilder.getInvocationBuilder(uri);

        CurrencyRates currencyRates = invocationBuilder.get(CurrencyRates.class);
        Response response = invocationBuilder.get();

        assertEquals(response.getStatus(), 200, " Response status not OK");
        assertTrue(currencyRates.isSuccess(), " Rates not success !!");
        assertNull(currencyRates.getError(), " Rates error !!");
        assertNotNull(currencyRates.getRates(), " Rates is null ");
        assertEquals(currencyRates.getRates().getEUR(), 1.0, " Rate for EUR not 1.0");
        assertNotEquals(currencyRates.getRates().getPLN(), 0.0, " Rate for PLN not calculated");
        assertNotEquals(currencyRates.getRates().getUSD(), 0.0, " Rate for USD not calculated");
        assertEquals(currencyRates.getRates().getUAH(), 0.0, " Rate for UAH is calculated");
    }
}
