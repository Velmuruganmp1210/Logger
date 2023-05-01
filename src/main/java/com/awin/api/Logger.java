package com.awin.api;

/**
 * The interface Logger.
 */
public interface Logger {
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
     * @param level     the root logger level
     * @param pattern   the pattern for the log
     * @param classname the classname , the classname to be printed
     */
    void setup(LogLevel level, String pattern , Class classname);

    /**
     * Logs the message with the given level
     *
     * @param level   the level
     * @param message the message
     */
    void log(LogLevel level , String message);

    /**
     * Logs the message with INFO Level.
     *
     * @param message the message
     */
    void info(String message);

    /**
     * Logs the message with ERROR Level.
     *
     * @param message the message
     */
    void error(String message);

    /**
     * Logs the message with DEBUG Level.
     *
     * @param message the message
     */
    void debug(String message);

    /**
     * Logs the message with WARN Level.
     *
     * @param message the message
     */
    void warn(String message);

    /**
     * Logs the message with TRACE Level.
     *
     * @param message the message
     */
    void trace(String message);


}
