import io.qameta.allure.*;
import model.CurrencyRates;
import org.testng.annotations.Test;

import javax.ws.rs.core.Response;

import static org.testng.Assert.*;
import static utils.PropertyFileHandler.*;
import static utils.UriUtil.buildURI;

public class Test3 extends BaseTest {

    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 3, description = "Verify call to the resource with the wrong access key")
    @Description("Verify call to the resource with the wrong access key")
    @Epic("Allure reports example")
    @Feature("Feature1: call with the wrong access key")
    @Step("Story: Verify call with the wrong access key")
    @Link("https://fixer.io/documentation")
    public void testResponseWithWrongKey() {

        uri = buildURI(BASE_URL, LATEST_DATE, MALFORMED_ACCESS_KEY, "", SYMBOLS);
        invocationBuilder = customClientBuilder.getInvocationBuilder(uri);

        CurrencyRates currencyRates = invocationBuilder.get(CurrencyRates.class);
        Response response = invocationBuilder.get();

        assertEquals(response.getStatus(), 200, " Response status not OK");
        assertFalse(currencyRates.isSuccess(), " Rates - success, not failed");
        assertNotNull(currencyRates.getError(), " No error, not failed");
        assertEquals(currencyRates.getError().getCode(), 101, " Wrong error code");
        assertEquals(currencyRates.getError().getType(), "invalid_access_key", " Wrong error type");
        assertNull(currencyRates.getRates(), " Rates not null ");
    }
}
