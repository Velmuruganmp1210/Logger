package com.awin.test;

import com.awin.api.LoggerWithConfiguration;
import com.awin.implementation.HttpLogger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HttpLoggerTest {

    /**
     * The Console logger.
     */
    HttpLogger httpLogger = new HttpLogger();
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
        configuration.setApiUrl("API URL");
        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            httpLogger.setup(LoggerWithConfiguration.LogLevel.DEBUG, "%m%c", HttpLogger.class, configuration);
        }, "HTTP URL configuration error");
        assertEquals("HTTP URL configuration error", thrown.getMessage());
    }

    /**
     * Test setup method
     */
    @Test
    public void test_setup_without_configuration() {
        com.awin.api.Configuration configuration = null;
        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            httpLogger.setup(LoggerWithConfiguration.LogLevel.DEBUG, "%m%c", HttpLogger.class, configuration);
        }, "RuntimeException was expected");
        assertEquals("Configuration is required", thrown.getMessage());
    }


}