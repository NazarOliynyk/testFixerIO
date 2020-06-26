package logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.yandex.qatools.allure.annotations.Step;

public class AllureLogger {

    private static final Logger logger = LogManager.getLogger(AllureLogger.class);

    @Step("{0}")
    public static void logToAllureInfo(String log) {
        logger.info("Logged to allure: " + log);
    }

    @Step("{0}")
    public static void logToAllureError(String log) {
        logger.error("Logged to allure: " + log);
    }

    @Step("{0}")
    public static void logToAllureWarn(String log) {
        logger.warn("Logged to allure: " + log);
    }
}