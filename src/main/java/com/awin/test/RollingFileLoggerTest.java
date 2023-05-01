package com.awin.test;

import com.awin.api.LoggerWithConfiguration;
import com.awin.implementation.FileLogger;
import com.awin.implementation.RollingFileLogger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RollingFileLoggerTest {

    /**
     * The Console logger.
     */
    RollingFileLogger rollingFileLogger = new RollingFileLogger();
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
        com.awin.api.Configuration configuration = new com.awin.api.Configuration();
        configuration.setFilename("target/log4j2/app.log");
        configuration.setFilePattern("target/log4j2/app.%d{MM-dd-yyyy-HH-mm}.log.gz");
        rollingFileLogger.setup(LoggerWithConfiguration.LogLevel.DEBUG, "%m%c", RollingFileLogger.class, configuration);
        assertEquals("DEBUG", config.getRootLogger().getLevel().toString());
        assertTrue(config.getAppenders().containsKey("RollingFileAppender"));
        assertEquals("%m%c", config.getAppender("RollingFileAppender").getLayout().toString());
    }

    /**
     * Test setup method
     */
    @Test
    public void test_setup_without_configuration() {
        com.awin.api.Configuration configuration = null;
        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            rollingFileLogger.setup(LoggerWithConfiguration.LogLevel.DEBUG, "%m%c", RollingFileLogger.class, configuration);
        }, "RuntimeException was expected");
        assertEquals("Configuration is required", thrown.getMessage());
    }

    /**
     * Tests log method
     */
    @Test
    public void test_log() {
        com.awin.api.Configuration configuration = new com.awin.api.Configuration();
        configuration.setFilename("target/log4j2/app.log");
        configuration.setFilePattern("target/log4j2/app.%d{MM-dd-yyyy-HH-mm}.log.gz");
        rollingFileLogger.setup(LoggerWithConfiguration.LogLevel.DEBUG, "%m%c", RollingFileLogger.class, configuration);
        org.apache.logging.log4j.Logger logger = LogManager.getLogger(FileLogger.class);
        rollingFileLogger.log(LoggerWithConfiguration.LogLevel.INFO, "Test message");
        assertEquals("DEBUG", logger.getLevel().toString());
    }

    /**
     * Tests Info method
     */
    @Test
    public void test_logInfo() {
        com.awin.api.Configuration configuration = new com.awin.api.Configuration();
        configuration.setFilename("target/log4j2/app.log");
        configuration.setFilePattern("target/log4j2/app.%d{MM-dd-yyyy-HH-mm}.log.gz");
        rollingFileLogger.setup(LoggerWithConfiguration.LogLevel.ERROR, "%m%c", RollingFileLogger.class, configuration);
        org.apache.logging.log4j.Logger logger = LogManager.getLogger(FileLogger.class);
        rollingFileLogger.info("Test message");
        assertEquals("ERROR", logger.getLevel().toString());
    }

    /**
     * Tests Info method without the set_up method
     */
    @Test
    public void test_logInfo_without_setup() {
        com.awin.api.Configuration configuration = new com.awin.api.Configuration();
        configuration.setFilename("target/log4j2/app.log");
        configuration.setFilePattern("target/log4j2/app.%d{MM-dd-yyyy-HH-mm}.log.gz");
        org.apache.logging.log4j.Logger logger = LogManager.getLogger(RollingFileLogger.class);
        rollingFileLogger.info("Test message");
        assertEquals("ERROR", logger.getLevel().toString());
    }
}