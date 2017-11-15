package main;

import org.apache.log4j.Logger;

/**
 * Class created by Arkadiusz Parafiniuk
 * arkadiusz.parafiniuk@gmail.com
 */
public class Application {

    final static Logger logger = Logger.getLogger(Application.class);

    public static void main(String[] args) {
        logger.info("Application started");


        logger.info("Application stopped");
    }
}
