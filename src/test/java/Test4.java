import io.qameta.allure.*;
import model.CurrencyRates;
import org.testng.annotations.Test;

import javax.ws.rs.core.Response;

import static org.testng.Assert.*;
import static utils.PropertyFileHandler.*;
import static utils.UriUtil.buildURI;

public class Test4 extends BaseTest {

    @Severity(SeverityLevel.NORMAL)
    @Test(priority=4, description="Verify call to the resource with invalid date")
    @Epic("Allure reports example")
    @Feature("Feature1: call with invalid date")
    @Story("Story: Verify call with invalid(non-existing) date")
    @Link("https://fixer.io/documentation")
    public void testResponseWithInvalidDate(){

        uri = buildURI(BASE_URL, INVALID_DATE, ACCESS_KEY, "", SYMBOLS);
        invocationBuilder = customClientBuilder.getInvocationBuilder(uri);

        CurrencyRates currencyRates = invocationBuilder.get(CurrencyRates.class);
        Response response= invocationBuilder.get();

        assertEquals(response.getStatus(), 200, " Response status not OK");
        assertFalse(currencyRates.isSuccess(), " Rates - success, not failed");
        assertNotNull(currencyRates.getError(), " No error, not failed");
        assertEquals(currencyRates.getError().getCode(), 302, " Wrong error code");
        assertEquals(currencyRates.getError().getType(), "invalid_date", " Wrong error type");
        assertNull(currencyRates.getRates(), " Rates not null ");
    }
}
