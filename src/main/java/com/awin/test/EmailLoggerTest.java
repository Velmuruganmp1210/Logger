package com.awin.test;

import com.awin.api.Logger;
import com.awin.api.LoggerWithConfiguration;
import com.awin.api.SMTPDetail;
import com.awin.implementation.ConsoleLogger;
import com.awin.implementation.EmailLogger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmailLoggerTest {

    /**
     * The Console logger.
     */
    EmailLogger emailLogger = new EmailLogger();
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
    @org.testng.annotations.Test
    public void test_setup() {
        com.awin.api.Configuration configuration = new com.awin.api.Configuration();
        SMTPDetail smtpDetail = new SMTPDetail();
        smtpDetail.setHostname("Hostname");
        configuration.setSMTPDetails(smtpDetail);
        emailLogger.setup(LoggerWithConfiguration.LogLevel.DEBUG, "%m%c", EmailLogger.class,configuration);
        assertEquals("DEBUG", config.getRootLogger().getLevel().toString());
        assertTrue(config.getAppenders().containsKey("SMTPAppender"));
        assertEquals("%m%c", config.getAppender("SMTPAppender").getLayout().toString());
    }

    /**
     * Tests log method
     */
    @org.testng.annotations.Test
    public void test_log() {
        com.awin.api.Configuration configuration = new com.awin.api.Configuration();
        SMTPDetail smtpDetail = new SMTPDetail();
        smtpDetail.setHostname("Hostname");
        configuration.setSMTPDetails(smtpDetail);
        emailLogger.setup(LoggerWithConfiguration.LogLevel.DEBUG, "%m%c", EmailLogger.class,configuration);
        org.apache.logging.log4j.Logger logger = LogManager.getLogger( EmailLogger.class);
        emailLogger.log(LoggerWithConfiguration.LogLevel.INFO,"Test message");
        assertEquals("DEBUG", logger.getLevel().toString());
    }
    /**
     * Tests Info method
     */
    @Test
    public void test_logInfo() {
        com.awin.api.Configuration configuration = new com.awin.api.Configuration();
        SMTPDetail smtpDetail = new SMTPDetail();
        smtpDetail.setHostname("Hostname");
        configuration.setSMTPDetails(smtpDetail);
        emailLogger.setup(LoggerWithConfiguration.LogLevel.ERROR, "%m%c", EmailLogger.class,configuration);
        org.apache.logging.log4j.Logger logger = LogManager.getLogger( EmailLogger.class);
        emailLogger.info("Test message");
        assertEquals("ERROR", logger.getLevel().toString());
    }

    /**
     * Tests Info method without the set_up method
     */
    @Test
    public void test_logInfo_without_setup() {
        com.awin.api.Configuration configuration = new com.awin.api.Configuration();
        SMTPDetail smtpDetail = new SMTPDetail();
        smtpDetail.setHostname("Hostname");
        configuration.setSMTPDetails(smtpDetail);
        org.apache.logging.log4j.Logger logger = LogManager.getLogger( EmailLogger.class);
        emailLogger.info("Test message");
        assertEquals("INFO", logger.getLevel().toString());
    }
}