package net.ahuffman.javaUI;

/**
 * An exception caused when an invalid command is attempted to be registered
 * to the UI.
 */
public class CommandRegisterException extends CommandException {
    /**
     * Constructor.
     * @param msg The excpetion message.
     */
    public CommandRegisterException(String msg) {
        super(msg);
    }
}
