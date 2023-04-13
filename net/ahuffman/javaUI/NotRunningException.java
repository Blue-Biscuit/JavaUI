package net.ahuffman.javaUI;

/**
 * An exception for when a UI command is performed, but the UI has been
 * already killed.
 */
public class NotRunningException extends UIException {
    public NotRunningException(String msg) {
        super(msg);
    }
}
