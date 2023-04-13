package net.ahuffman.javaUI;

/**
 * Exception thrown if something is done to the UI while it is
 * running, when it was supposed to be killed.
 */
public class RunningException extends UIException {
    /**
     * Constructor.
     * @param msg The exception message.
     */
    public RunningException(String msg) {
        super(msg);
    }
}
