package net.ahuffman.javaUI;

/**
 * The superclass for all command-related exceptions;
 * a "catch-all" exception type for command related
 * runtime exceptions.
 */
public class CommandException extends RuntimeException {
    /**
     * Constructor
     * @param msg The exception message.
     */
    public CommandException(String msg) {
        super(msg);
    }
}
