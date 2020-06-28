import io.qameta.allure.*;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class Test7 extends BaseTest {

    @Severity(SeverityLevel.MINOR)
    @Test(priority = 7, description = "Test to skip")
    @Description("Test to skip")
    @Step("Test is going to be skipped")
    public void testToSkip() {
        throw new SkipException("Skipping this Test");
    }
}
