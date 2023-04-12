package net.ahuffman.javaUI;

/**
 * The superclass for all UI-related exceptions.
 */
public class UIException extends RuntimeException {
    /**
     * Constructor.
     * @param msg The exception message.
     */
    public UIException(String msg) {
        super(msg);
    }
}
