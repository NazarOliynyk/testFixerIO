package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static client.CustomClientBuilder.logger;

public class PropertyFileHandler {

    public static final String BASE_URL;
    public static final String ACCESS_KEY;
    public static final String MALFORMED_ACCESS_KEY;
    public static final String SYMBOLS;
    public static final String INCOMPLETE_SYMBOLS;
    public static final String LATEST_DATE;
    public static final String BASE_CURRENCY;
    public static final String INVALID_DATE;

    static {
        Properties prop = new Properties();
        try (InputStream input =
                     new FileInputStream("src"+ File.separator+"main"+ File.separator+"resources"+ File.separator+"config.properties")) {
            prop.load(input);
            logger.info("Constants are extracted from the property file");
        } catch (IOException ex) {
            logger.error(ex.getMessage());
            logger.error(ex.getCause());
        }
        BASE_URL = prop.getProperty("baseurl");
        ACCESS_KEY = prop.getProperty("accessKey");
        MALFORMED_ACCESS_KEY = prop.getProperty("malformedAccessKey");
        SYMBOLS = prop.getProperty("symbols");
        INCOMPLETE_SYMBOLS = prop.getProperty("incompleteSymbols");
        LATEST_DATE = prop.getProperty("latestDate");
        BASE_CURRENCY = prop.getProperty("baseCurrency");
        INVALID_DATE = prop.getProperty("invalidDate");
    }
}
