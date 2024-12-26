package com.veeva.pageobjects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtil {

    private static final Logger logger = LoggerFactory.getLogger(LogUtil.class);

    public static Logger getLogger(Class<?> clazz) {
        return LoggerFactory.getLogger(clazz);
    }

    // Sample log usage
    public static void logInfo(String message) {
        logger.info(message);
    }

    public static void logWarn(String message) {
        logger.warn(message);
    }

    public static void logError(String message) {
        logger.error(message);
    }
}
