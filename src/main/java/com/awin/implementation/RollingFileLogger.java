package com.awin.implementation;

import com.awin.api.LoggerWithConfiguration;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.appender.RollingFileAppender;
import org.apache.logging.log4j.core.appender.rolling.SizeBasedTriggeringPolicy;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.LoggerConfig;
import org.apache.logging.log4j.core.layout.PatternLayout;

/**
 * The type Rolling file logger used to log in the rolling file with the given configuration
 */
public class RollingFileLogger implements LoggerWithConfiguration {

    /**
     * The Context.
     */
    LoggerContext context = (LoggerContext) LogManager.getContext(false);
    /**
     * The Config.
     */
    Configuration config = context.getConfiguration();
    /**
     * The Logger.
     */
    static org.apache.logging.log4j.Logger logger = LogManager.getLogger();
    /**
     * sets up the root logger leve and all other configurations.
     * @param level        the root logger level
     * @param pattern      the pattern to be used to log
     * @param classname    the classname to be used to log
     */
    @Override
    public synchronized void setup(LogLevel level, String pattern, Class classname,com.awin.api.Configuration configuration) {
        if(configuration == null || configuration.getFilename().isEmpty()){
            throw new RuntimeException("Configuration is required");
        }
        logger = LogManager.getLogger(classname);
        config.getRootLogger().setLevel(Level.valueOf(level.toString()));
        PatternLayout layout = PatternLayout.newBuilder().withPattern(pattern).build();
        Appender appender = RollingFileAppender.newBuilder()
                .setLayout(layout)
                .withFilePattern(configuration.getFilePattern())
                .withFileName(configuration.getFilename())
                .withPolicy(SizeBasedTriggeringPolicy.createPolicy("1KB"))
                .setName("RollingFileAppender")
                .build();

        appender.start();
        config.addAppender(appender);
        LoggerConfig loggerConfig = config.getLoggerConfig(classname.getName());
        loggerConfig.addAppender(appender, null, null);
        context.updateLoggers();
    }
    /**
     * Logs the message with the provided level
     * @param level   the level required to be logged
     * @param message the message required to be logged
     */
    @Override
    public void log(LogLevel level, String message) {
        logger.log(Level.valueOf(level.toString()),message);
    }

    /**
     * Logs message with INFO level
     * @param message
     */
    @Override
    public void info(String message) {
        logger.log(Level.INFO,message);
    }
    /**
     * Logs message with ERROR level
     * @param message
     */
    @Override
    public void error(String message) {
        logger.log(Level.ERROR,message);
    }
    /**
     * Logs message with DEBUG level
     * @param message
     */
    @Override
    public void debug(String message) {
        logger.log(Level.DEBUG,message);
    }
    /**
     * Logs message with TRACE level
     * @param message
     */
    @Override
    public void warn(String message) {
        logger.log(Level.WARN,message);
    }

    @Override
    public void trace(String message) {
        logger.log(Level.TRACE,message);
    }
}
