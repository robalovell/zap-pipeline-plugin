/* HEADER */
package com.vrondakis.zap;

import java.io.PrintStream;
import org.apache.commons.lang.exception.ExceptionUtils;

public class ZapExecutionException extends Exception {

    public ZapExecutionException(String message) {
        super(message);
    }

    public ZapExecutionException(String message, Throwable cause) {
        super(message, cause);
    }

    public ZapExecutionException(String message, PrintStream logger) {
        super(message);
        logMessage(message, logger);
    }

    public ZapExecutionException(String message, Throwable cause, PrintStream logger) {
        super(message, cause);
        logMessageAndCause(message,cause, logger);
    }

    private void logMessage(String message, PrintStream logger) {
        if (logger != null) {
            logger.println("zap: " + message);
        }
    }
    private void logMessageAndCause(String message, Throwable cause, PrintStream logger) {
        if (logger != null) {
            logger.println("zap: " + message);
            logger.println("Trace :" + ExceptionUtils.getStackTrace(cause));
        }
    }
}
