import io.qameta.allure.*;
import model.CurrencyRates;
import org.testng.annotations.Test;

import javax.ws.rs.core.Response;

import static org.testng.Assert.*;
import static utils.PropertyFileHandler.*;
import static utils.UriUtil.buildURI;

public class Test2 extends BaseTest {

    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 2, description = "Verify call to the resource with non-default base currency")
    @Epic("Allure reports example")
    @Feature("Feature1: call with non-default base currency")
    @Story("Story: Verify call with non-default base currency providing that subscription allows only default currency")
    @Link("https://fixer.io/documentation")
    public void testResponseWithBaseCurrency() {

        uri = buildURI(BASE_URL, LATEST_DATE, ACCESS_KEY, BASE_CURRENCY, SYMBOLS);
        invocationBuilder = customClientBuilder.getInvocationBuilder(uri);

        CurrencyRates currencyRates = invocationBuilder.get(CurrencyRates.class);
        Response response = invocationBuilder.get();

        assertEquals(response.getStatus(), 200, " Response status not OK");
        assertFalse(currencyRates.isSuccess(), " Rates - success, not failed");
        assertNotNull(currencyRates.getError(), " No error, not failed");
        assertEquals(currencyRates.getError().getCode(), 105, " Wrong error code");
        assertEquals(currencyRates.getError().getType(), "base_currency_access_restricted", " Wrong error type");
        assertNull(currencyRates.getRates(), " Rates not null ");
    }
}
