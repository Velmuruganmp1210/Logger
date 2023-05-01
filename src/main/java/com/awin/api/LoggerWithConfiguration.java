package com.awin.api;

/**
 * The interface Logger with configuration.
 */
public interface LoggerWithConfiguration {
    /**
     * The enum Log level.
     */
    enum LogLevel {
        /**
         * Info log level.
         */
        INFO,
        /**
         * Debug log level.
         */
        DEBUG,
        /**
         * Error log level.
         */
        ERROR,
        /**
         * Warn log level.
         */
        WARN,
        /**
         * Trace log level.
         */
        TRACE,
        /**
         * Fatal log level.
         */
        FATAL
     }

    /**
     * The enum Appender type.
     */
    enum AppenderType {
        /**
         * File appender type.
         */
        FILE,
        /**
         * Console appender type.
         */
        CONSOLE,
        /**
         * Http appender type.
         */
        HTTP,
        /**
         * Rolling file appender type.
         */
        ROLLING_FILE
     }

    /**
     * Method used to set up the logger with the required configuration
     *
     * @param level             the root level
     * @param pattern           the pattern
     * @param classname         the classname
     * @param configuration     the configuration
     */
    void setup(LogLevel level, String pattern , Class classname,Configuration configuration);

    /**
     * Logs the message with the given level
     *
     * @param level   the level
     * @param message the message
     */
    void log(LogLevel level , String message);
    void info(String message);
    void error(String message);
    void debug(String message);
    void warn(String message);
    void trace(String message);
}
