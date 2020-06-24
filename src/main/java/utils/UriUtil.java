package utils;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;

import static client.CustomClientBuilder.logger;

public class UriUtil {

    public static synchronized URI buildURI(String baseUrl,
                               String date,
                               String accessKey,
                               String baseCurrency,
                               String symbols)
    {
        URI uri = UriBuilder.fromUri(baseUrl + date +
                "?access_key=" + accessKey +
                "&base=" + baseCurrency +
                "&symbols=" + symbols).build();
        logger.debug("Trigger URI: ----- " + uri + " -------");
        return uri;
    }
}
