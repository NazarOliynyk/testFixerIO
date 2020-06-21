import io.qameta.allure.*;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class Test7 extends BaseTest {

    @Severity(SeverityLevel.MINOR)
    @Test(priority = 7, description = "Test to skip")
    public void testToSkip() {
        throw new SkipException("Skipping this Test");
    }
}
