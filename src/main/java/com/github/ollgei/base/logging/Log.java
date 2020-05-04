package com.github.ollgei.base.logging;

import java.util.function.Supplier;

import org.apache.commons.logging.LogFactory;

/**
 * A simple logging interface abstracting logging APIs.  In order to be
 * instantiated successfully by {@link LogFactory}, classes that implement
 * this interface must have a constructor that takes a single String
 * parameter representing the "name" of this Log.
 *
 * <p>The six logging levels used by <code>Log</code> are (in order):
 * <ol>
 * <li>trace (the least serious)</li>
 * <li>debug</li>
 * <li>info</li>
 * <li>warn</li>
 * <li>error</li>
 * <li>fatal (the most serious)</li>
 * </ol>
 * <p>
 * The mapping of these log levels to the concepts used by the underlying
 * logging system is implementation dependent.
 * The implementation should ensure, though, that this ordering behaves
 * as expected.
 *
 * <p>Performance is often a logging concern.
 * By examining the appropriate property,
 * a component can avoid expensive operations (producing information
 * to be logged).
 *
 * <p>For example,
 * <pre>
 *    if (log.isDebugEnabled()) {
 *        ... do something expensive ...
 *        log.debug(theResult);
 *    }
 * </pre>
 *
 * <p>Configuration of the underlying logging system will generally be done
 * external to the Logging APIs, through whatever mechanism is supported by
 * that system.
 * <p>
 * add default.
 *
 * @author Juergen Hoeller (for the {@code spring-jcl} variant)
 * @author ollgei
 * @since 5.0
 */
public interface Log {

    /**
     * Is fatal logging currently enabled?
     * <p>Call this method to prevent having to perform expensive operations
     * (for example, <code>String</code> concatenation)
     * when the log level is more than fatal.
     *
     * @return true if fatal is enabled in the underlying logger.
     */
    boolean isFatalEnabled();

    /**
     * Is error logging currently enabled?
     * <p>Call this method to prevent having to perform expensive operations
     * (for example, <code>String</code> concatenation)
     * when the log level is more than error.
     *
     * @return true if error is enabled in the underlying logger.
     */
    boolean isErrorEnabled();

    /**
     * Is warn logging currently enabled?
     * <p>Call this method to prevent having to perform expensive operations
     * (for example, <code>String</code> concatenation)
     * when the log level is more than warn.
     *
     * @return true if warn is enabled in the underlying logger.
     */
    boolean isWarnEnabled();

    /**
     * Is info logging currently enabled?
     * <p>Call this method to prevent having to perform expensive operations
     * (for example, <code>String</code> concatenation)
     * when the log level is more than info.
     *
     * @return true if info is enabled in the underlying logger.
     */
    boolean isInfoEnabled();

    /**
     * Is debug logging currently enabled?
     * <p>Call this method to prevent having to perform expensive operations
     * (for example, <code>String</code> concatenation)
     * when the log level is more than debug.
     *
     * @return true if debug is enabled in the underlying logger.
     */
    boolean isDebugEnabled();

    /**
     * Is trace logging currently enabled?
     * <p>Call this method to prevent having to perform expensive operations
     * (for example, <code>String</code> concatenation)
     * when the log level is more than trace.
     *
     * @return true if trace is enabled in the underlying logger.
     */
    boolean isTraceEnabled();

    /**
     * Logs a message with fatal log level.
     *
     * @param message log this message
     */
    void fatal(Object message);

    /**
     * Logs an error with fatal log level.
     *
     * @param message log this message
     * @param t       log this cause
     */
    void fatal(Object message, Throwable t);

    /**
     * Logs a message with error log level.
     *
     * @param message log this message
     */
    void error(Object message);

    /**
     * Logs an error with error log level.
     *
     * @param message log this message
     * @param t       log this cause
     */
    void error(Object message, Throwable t);

    /**
     * Logs a message with warn log level.
     *
     * @param message log this message
     */
    void warn(Object message);

    /**
     * Logs an error with warn log level.
     *
     * @param message log this message
     * @param t       log this cause
     */
    void warn(Object message, Throwable t);

    /**
     * Logs a message with info log level.
     *
     * @param message log this message
     */
    void info(Object message);

    /**
     * Logs an error with info log level.
     *
     * @param message log this message
     * @param t       log this cause
     */
    void info(Object message, Throwable t);

    /**
     * Logs a message with debug log level.
     *
     * @param message log this message
     */
    void debug(Object message);

    /**
     * Logs an error with debug log level.
     *
     * @param message log this message
     * @param t       log this cause
     */
    void debug(Object message, Throwable t);

    /**
     * Logs a message with trace log level.
     *
     * @param message log this message
     */
    void trace(Object message);

    /**
     * Logs an error with trace log level.
     *
     * @param message log this message
     * @param t       log this cause
     */
    void trace(Object message, Throwable t);

    /************* ollgei add  ****************/

    /**
     * Logs a message with trace log level.
     *
     * @param supplier supplier for log this message
     */
    default void trace0(Supplier<Object> supplier) {
        if (isTraceEnabled()) {
            trace(supplier.get());
        }
    }

    /**
     * Logs an error with trace log level.
     *
     * @param supplier supplier for log this message
     * @param t        log this cause
     */
    default void trace0(Supplier<Object> supplier, Throwable t) {
        if (isTraceEnabled()) {
            trace(supplier.get(), t);
        }
    }

    /**
     * Logs a message with trace log level.
     *
     * @param arg1 arg1
     */
    default void trace0(String format, Object arg1) {
        trace0(() -> String.format(format, arg1));
    }

    /**
     * Logs a message with trace log level.
     *
     * @param arg1 arg1
     * @param arg2 arg2
     */
    default void trace0(String format, Object arg1, Object arg2) {
        trace0(() -> String.format(format, arg1, arg2));
    }

    /**
     * Logs a message with trace log level.
     *
     * @param arg1 arg1
     * @param arg2 arg2
     * @param arg3 arg3
     */
    default void trace0(String format, Object arg1, Object arg2, Object arg3) {
        trace0(() -> String.format(format, arg1, arg2, arg3));
    }

    /**
     * Logs a message with trace log level.
     *
     * @param arg1 arg1
     * @param arg2 arg2
     * @param arg3 arg3
     * @param arg4 arg4
     */
    default void trace0(String format, Object arg1, Object arg2, Object arg3, Object arg4) {
        trace0(() -> String.format(format, arg1, arg2, arg3, arg4));
    }

    /**
     * Logs a message with trace log level.
     *
     * @param arg1 arg1
     * @param arg2 arg2
     * @param arg3 arg3
     * @param arg4 arg4
     * @param arg5 arg5
     */
    default void trace0(String format, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5) {
        trace0(() -> String.format(format, arg1, arg2, arg3, arg4, arg5));
    }

    /**
     * Logs a message with debug log level.
     *
     * @param supplier supplier for log this message
     */
    default void debug0(Supplier<Object> supplier) {
        if (isDebugEnabled()) {
            debug(supplier.get());
        }
    }

    /**
     * Logs an error with debug log level.
     *
     * @param supplier supplier for log this message
     * @param t        log this cause
     */
    default void debug0(Supplier<Object> supplier, Throwable t) {
        if (isDebugEnabled()) {
            debug(supplier.get(), t);
        }
    }

    /**
     * Logs a message with debug log level.
     *
     * @param arg1 arg1
     */
    default void debug0(String format, Object arg1) {
        debug0(() -> String.format(format, arg1));
    }

    /**
     * Logs a message with debug log level.
     *
     * @param arg1 arg1
     * @param arg2 arg2
     */
    default void debug0(String format, Object arg1, Object arg2) {
        debug0(() -> String.format(format, arg1, arg2));
    }

    /**
     * Logs a message with debug log level.
     *
     * @param arg1 arg1
     * @param arg2 arg2
     * @param arg3 arg3
     */
    default void debug0(String format, Object arg1, Object arg2, Object arg3) {
        debug0(() -> String.format(format, arg1, arg2, arg3));
    }

    /**
     * Logs a message with debug log level.
     *
     * @param arg1 arg1
     * @param arg2 arg2
     * @param arg3 arg3
     * @param arg4 arg4
     */
    default void debug0(String format, Object arg1, Object arg2, Object arg3, Object arg4) {
        debug0(() -> String.format(format, arg1, arg2, arg3, arg4));
    }

    /**
     * Logs a message with debug log level.
     *
     * @param arg1 arg1
     * @param arg2 arg2
     * @param arg3 arg3
     * @param arg4 arg4
     * @param arg5 arg5
     */
    default void debug0(String format, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5) {
        debug0(() -> String.format(format, arg1, arg2, arg3, arg4, arg5));
    }

    /**
     * Logs a message with info log level.
     *
     * @param supplier supplier for log this message
     */
    default void info0(Supplier<Object> supplier) {
        if (isInfoEnabled()) {
            info(supplier.get());
        }
    }

    /**
     * Logs an error with info log level.
     *
     * @param supplier supplier for log this message
     * @param t        log this cause
     */
    default void info0(Supplier<Object> supplier, Throwable t) {
        if (isInfoEnabled()) {
            info(supplier.get(), t);
        }
    }

    /**
     * Logs a message with info log level.
     *
     * @param arg1 arg1
     */
    default void info0(String format, Object arg1) {
        info0(() -> String.format(format, arg1));
    }

    /**
     * Logs a message with info log level.
     *
     * @param arg1 arg1
     * @param arg2 arg2
     */
    default void info0(String format, Object arg1, Object arg2) {
        info0(() -> String.format(format, arg1, arg2));
    }

    /**
     * Logs a message with info log level.
     *
     * @param arg1 arg1
     * @param arg2 arg2
     * @param arg3 arg3
     */
    default void info0(String format, Object arg1, Object arg2, Object arg3) {
        info0(() -> String.format(format, arg1, arg2, arg3));
    }

    /**
     * Logs a message with info log level.
     *
     * @param arg1 arg1
     * @param arg2 arg2
     * @param arg3 arg3
     * @param arg4 arg4
     */
    default void info0(String format, Object arg1, Object arg2, Object arg3, Object arg4) {
        info0(() -> String.format(format, arg1, arg2, arg3, arg4));
    }

    /**
     * Logs a message with info log level.
     *
     * @param arg1 arg1
     * @param arg2 arg2
     * @param arg3 arg3
     * @param arg4 arg4
     * @param arg5 arg5
     */
    default void info0(String format, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5) {
        info0(() -> String.format(format, arg1, arg2, arg3, arg4, arg5));
    }

    /**
     * Logs a message with warn log level.
     *
     * @param supplier supplier for log this message
     */
    default void warn0(Supplier<Object> supplier) {
        if (isWarnEnabled()) {
            warn(supplier.get());
        }
    }

    /**
     * Logs an error with warn log level.
     *
     * @param supplier supplier for log this message
     * @param t        log this cause
     */
    default void warn0(Supplier<Object> supplier, Throwable t) {
        if (isWarnEnabled()) {
            warn(supplier.get(), t);
        }
    }

    /**
     * Logs a message with warn log level.
     *
     * @param arg1 arg1
     */
    default void warn0(String format, Object arg1) {
        warn0(() -> String.format(format, arg1));
    }

    /**
     * Logs a message with warn log level.
     *
     * @param arg1 arg1
     * @param arg2 arg2
     */
    default void warn0(String format, Object arg1, Object arg2) {
        warn0(() -> String.format(format, arg1, arg2));
    }

    /**
     * Logs a message with warn log level.
     *
     * @param arg1 arg1
     * @param arg2 arg2
     * @param arg3 arg3
     */
    default void warn0(String format, Object arg1, Object arg2, Object arg3) {
        warn0(() -> String.format(format, arg1, arg2, arg3));
    }

    /**
     * Logs a message with warn log level.
     *
     * @param arg1 arg1
     * @param arg2 arg2
     * @param arg3 arg3
     * @param arg4 arg4
     */
    default void warn0(String format, Object arg1, Object arg2, Object arg3, Object arg4) {
        warn0(() -> String.format(format, arg1, arg2, arg3, arg4));
    }

    /**
     * Logs a message with warn log level.
     *
     * @param arg1 arg1
     * @param arg2 arg2
     * @param arg3 arg3
     * @param arg4 arg4
     * @param arg5 arg5
     */
    default void warn0(String format, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5) {
        warn0(() -> String.format(format, arg1, arg2, arg3, arg4, arg5));
    }

    /**
     * Logs a message with error log level.
     *
     * @param supplier supplier for log this message
     */
    default void error0(Supplier<Object> supplier) {
        if (isErrorEnabled()) {
            error(supplier.get());
        }
    }

    /**
     * Logs an error with error log level.
     *
     * @param supplier supplier for log this message
     * @param t        log this cause
     */
    default void error0(Supplier<Object> supplier, Throwable t) {
        if (isErrorEnabled()) {
            error(supplier.get(), t);
        }
    }

    /**
     * Logs a message with error log level.
     *
     * @param arg1 arg1
     */
    default void error0(String format, Object arg1) {
        error0(() -> String.format(format, arg1));
    }

    /**
     * Logs a message with error log level.
     *
     * @param arg1 arg1
     * @param arg2 arg2
     */
    default void error0(String format, Object arg1, Object arg2) {
        error0(() -> String.format(format, arg1, arg2));
    }

    /**
     * Logs a message with error log level.
     *
     * @param arg1 arg1
     * @param arg2 arg2
     * @param arg3 arg3
     */
    default void error0(String format, Object arg1, Object arg2, Object arg3) {
        error0(() -> String.format(format, arg1, arg2, arg3));
    }

    /**
     * Logs a message with error log level.
     *
     * @param arg1 arg1
     * @param arg2 arg2
     * @param arg3 arg3
     * @param arg4 arg4
     */
    default void error0(String format, Object arg1, Object arg2, Object arg3, Object arg4) {
        error0(() -> String.format(format, arg1, arg2, arg3, arg4));
    }

    /**
     * Logs a message with error log level.
     *
     * @param arg1 arg1
     * @param arg2 arg2
     * @param arg3 arg3
     * @param arg4 arg4
     * @param arg5 arg5
     */
    default void error0(String format, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5) {
        error0(() -> String.format(format, arg1, arg2, arg3, arg4, arg5));
    }

    /**
     * Logs a message with fatal log level.
     *
     * @param supplier supplier for log this message
     */
    default void fatal0(Supplier<Object> supplier) {
        if (isFatalEnabled()) {
            fatal(supplier.get());
        }
    }

    /**
     * Logs an fatal with fatal log level.
     *
     * @param supplier supplier for log this message
     * @param t        log this cause
     */
    default void fatal0(Supplier<Object> supplier, Throwable t) {
        if (isFatalEnabled()) {
            fatal(supplier.get(), t);
        }
    }

    /**
     * Logs a message with fatal log level.
     *
     * @param arg1 arg1
     */
    default void fatal0(String format, Object arg1) {
        fatal0(() -> String.format(format, arg1));
    }

    /**
     * Logs a message with fatal log level.
     *
     * @param arg1 arg1
     * @param arg2 arg2
     */
    default void fatal0(String format, Object arg1, Object arg2) {
        fatal0(() -> String.format(format, arg1, arg2));
    }

    /**
     * Logs a message with fatal log level.
     *
     * @param arg1 arg1
     * @param arg2 arg2
     * @param arg3 arg3
     */
    default void fatal0(String format, Object arg1, Object arg2, Object arg3) {
        fatal0(() -> String.format(format, arg1, arg2, arg3));
    }

    /**
     * Logs a message with fatal log level.
     *
     * @param arg1 arg1
     * @param arg2 arg2
     * @param arg3 arg3
     * @param arg4 arg4
     */
    default void fatal0(String format, Object arg1, Object arg2, Object arg3, Object arg4) {
        fatal0(() -> String.format(format, arg1, arg2, arg3, arg4));
    }

    /**
     * Logs a message with fatal log level.
     *
     * @param arg1 arg1
     * @param arg2 arg2
     * @param arg3 arg3
     * @param arg4 arg4
     * @param arg5 arg5
     */
    default void fatal0(String format, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5) {
        fatal0(() -> String.format(format, arg1, arg2, arg3, arg4, arg5));
    }
}