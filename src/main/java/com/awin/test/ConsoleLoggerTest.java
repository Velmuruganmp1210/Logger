package com.awin.test;

import com.awin.api.Logger;
import com.awin.implementation.ConsoleLogger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The type Console logger test.
 */
public class ConsoleLoggerTest {
    /**
     * The Console logger.
     */
    ConsoleLogger consoleLogger = new ConsoleLogger();
    /**
     * The Context.
     */
    LoggerContext context = (LoggerContext) LogManager.getContext(false);
    /**
     * The Config.
     */
    Configuration config = context.getConfiguration();

    /**
     * Test setup method
     */
    @Test
    public void test_setup() {
        consoleLogger.setup(Logger.LogLevel.DEBUG, "%m%c", ConsoleLogger.class);
        assertEquals("DEBUG", config.getRootLogger().getLevel().toString());
        assertTrue(config.getAppenders().containsKey("ConsoleAppender"));
        assertEquals("%m%c", config.getAppender("ConsoleAppender").getLayout().toString());
    }

    /**
     * Tests log method
     */
    @Test
    public void test_log() {
        consoleLogger.setup(Logger.LogLevel.DEBUG, "%m%c", ConsoleLogger.class);
        org.apache.logging.log4j.Logger logger = LogManager.getLogger( ConsoleLogger.class);
        consoleLogger.log(Logger.LogLevel.INFO,"Test message");
       assertEquals("DEBUG", logger.getLevel().toString());
    }
    /**
     * Tests Info method
     */
    @Test
    public void test_logInfo() {
        consoleLogger.setup(Logger.LogLevel.ERROR, "%m%c", ConsoleLogger.class);
        org.apache.logging.log4j.Logger logger = LogManager.getLogger( ConsoleLogger.class);
        consoleLogger.info("Test message");
        assertEquals("ERROR", logger.getLevel().toString());
    }
}