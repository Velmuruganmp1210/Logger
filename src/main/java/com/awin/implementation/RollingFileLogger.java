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
    static org.apache.logging.log4j.Logger logger ;
    /**
     * sets up the root logger leve and all other configurations.
     * @param level        the root logger level
     * @param pattern      the pattern to be used to log
     * @param classname    the classname to be used to log
     */
    @Override
    public void setup(LogLevel level, String pattern, Class classname,com.awin.api.Configuration configuration) {
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
}
