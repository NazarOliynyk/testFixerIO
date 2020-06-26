import client.CustomClientBuilder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import javax.ws.rs.client.Invocation;
import java.net.URI;

import static logger.AllureLogger.logToAllureInfo;

@Listeners({TestListener.class})
public abstract class BaseTest {

    CustomClientBuilder customClientBuilder;
    URI uri;
    Invocation.Builder invocationBuilder;

    @BeforeMethod
    public void reinitialize() {
        customClientBuilder = new CustomClientBuilder();
        logToAllureInfo("BeforeMethod: Initialize CustomClientBuilder");
    }

    @AfterMethod
    public void cleanUp() {
        customClientBuilder.quit();
        logToAllureInfo("AfterMethod: Quit CustomClientBuilder");
    }
}
