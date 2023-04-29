package com.awin.test;

import com.awin.api.Configuration;
import com.awin.api.Logger;
import com.awin.api.LoggerWithConfiguration;
import com.awin.api.SMTPDetail;
import com.awin.implementation.*;

public class UseLoggerApp {
    static String LOG_PATTERN_FORMAT = "%d{yyyy-MM-dd HH:mm:ss}  %-5p %c{5} - %m%n";

    public  static void main(String a[]) {


            //To test console Logger
            Logger consoleLogger = new ConsoleLogger();
            consoleLogger.setup(Logger.LogLevel.DEBUG, LOG_PATTERN_FORMAT, UseLoggerApp.class);
            consoleLogger.log(Logger.LogLevel.INFO, "Logging from Use logger with console logger");

            //To test file Logger
            LoggerWithConfiguration fileLogger = new FileLogger();
            Configuration configuration = new Configuration();
            configuration.setFilename("log/app.log");
            fileLogger.setup(LoggerWithConfiguration.LogLevel.WARN, LOG_PATTERN_FORMAT, UseLoggerApp.class, configuration);
            fileLogger.log(LoggerWithConfiguration.LogLevel.DEBUG, "Logging from Use logger with File logger");

            //To test http Logger
            try {
                LoggerWithConfiguration httpLogger = new HttpLogger();
                configuration.setApiUrl("API");
                httpLogger.setup(LoggerWithConfiguration.LogLevel.DEBUG, LOG_PATTERN_FORMAT, UseLoggerApp.class, configuration);
                httpLogger.log(LoggerWithConfiguration.LogLevel.INFO, "Logging from Use logger with http logger");
            } catch (Exception e) {
                consoleLogger.log(Logger.LogLevel.ERROR, "Logging from Use logger with console logger for HTTP Logger");
            }

            //To test RollingFileLogger
            LoggerWithConfiguration rollingFileLogger = new RollingFileLogger();
            configuration.setFilename("target/log4j2/app.log");
            configuration.setFilePattern("target/log4j2/app.%d{MM-dd-yyyy-HH-mm}.log.gz");
            rollingFileLogger.setup(LoggerWithConfiguration.LogLevel.WARN, LOG_PATTERN_FORMAT, UseLoggerApp.class, configuration);
            rollingFileLogger.log(LoggerWithConfiguration.LogLevel.INFO, "Logging from Use logger with rollingFileLogger");

            //To test Email Logger
            LoggerWithConfiguration emailLogger = new EmailLogger();
            SMTPDetail smtpDetail = new SMTPDetail();
            smtpDetail.setHostname("Hostname");
            configuration.setSMTPDetails(smtpDetail);
            emailLogger.setup(LoggerWithConfiguration.LogLevel.WARN, LOG_PATTERN_FORMAT, UseLoggerApp.class, configuration);
            emailLogger.log(LoggerWithConfiguration.LogLevel.INFO, "Logging from Use logger with email logger");

    }
}
