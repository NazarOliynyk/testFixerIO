import client.CustomClientBuilder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import javax.ws.rs.client.Invocation;
import java.net.URI;

//import static client.CustomClientBuilder.logger;

@Listeners({TestListener.class})
public abstract class BaseTest {

    CustomClientBuilder customClientBuilder;
    URI uri;
    Invocation.Builder invocationBuilder;

    @BeforeMethod
    public void reinitialize() {
        customClientBuilder= new CustomClientBuilder();
        System.out.println("BeforeMethod: Initialize CustomClientBuilder");
//        logger.trace("BeforeMethod: Initialize CustomClientBuilder");
    }

    @AfterMethod
    public void cleanUp(){
        customClientBuilder.quit();
        System.out.println("AfterMethod: Quit CustomClientBuilder");
//        logger.trace("AfterMethod: Quit CustomClientBuilder");
    }
}
