import org.apache.logging.log4j.*;


public class LogForJ {



    public static void main(String[] args) {
        Logger logger = LogManager.getLogger(LogForJ.class.getName());

        logger.error("testError");
        logger.debug("TestDebug");
        logger.fatal("TestFatal");
        logger.info("testInfo");

    }
}
