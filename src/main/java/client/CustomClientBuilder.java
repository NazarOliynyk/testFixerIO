package client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.net.URI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomClientBuilder {

//    public static Logger logger = LogManager.getLogger(CustomClientBuilder.class);
    private Invocation.Builder invocationBuilder = null;

    public CustomClientBuilder() {
    }

    synchronized public Invocation.Builder getInvocationBuilder(URI uri) {

        if (invocationBuilder == null) {
//            logger.info("Starting ClientBuilder");
            System.out.println("Starting ClientBuilder");
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target(uri);
            invocationBuilder = target.request(MediaType.APPLICATION_JSON);
        }
        return invocationBuilder;
    }

    public void quit(){
//        logger.info("Quitting builder");
        System.out.println("Quitting builder");
        invocationBuilder= null;
    }

}
