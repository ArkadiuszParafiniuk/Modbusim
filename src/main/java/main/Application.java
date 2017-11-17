package main;

import gui.GUI;
import org.apache.log4j.Logger;

/**
 * Class created by Arkadiusz Parafiniuk
 * arkadiusz.parafiniuk@gmail.com
 */
public class Application {

    final static Logger logger = Logger.getLogger(Application.class);

    public static void main(String[] args) {
        logger.info("Application started");
        GUI.main(args);
        logger.info("Application stopped");
    }
}
