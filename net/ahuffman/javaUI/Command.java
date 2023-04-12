package net.ahuffman.javaUI;

import java.io.PrintStream;

/**
 * A console UI command.
 */
public class Command {
    /**
     * The name of the command, by which it is called.
     */
    private final String name;

    /**
     * The one-line help text displayed when the "help" command
     * is called.
     */
    private final String helpTextShort;

    /**
     * The full help text displayed when "help <name>" is called.
     */
    private final String helpTextLong;

    /**
     * The callback function object.
     */
    private final CommandCallback callback;

    /**
     * Constructor.
     * @param name The name of the command, by which it is called.
     * @param callback The callback function.
     * @param helpTextShort The short, one-line version of the help text, which is printed when "help"
     * is called.
     * @param helpTextLong The full help text, which is printed when "help <name>" is called.
     */
    public Command(String name, CommandCallback callback, String helpTextShort, String helpTextLong) {
        this.name = name;
        this.callback = callback;
        this.helpTextShort = helpTextShort;
        this.helpTextLong = helpTextLong;
    }

    /**
     * Calls the command.
     * @param args The input string used to call the command.
     * @param stream The IO stream used.
     */
    public void call(String[] args, PrintStream stream) {
        this.callback.callback(args, stream);
    }

    /**
     * Getter for the name of the command.
     * @return The name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter for the short help text.
     * @return The short help text.
     */
    public String getShortHelpText() {
        return this.helpTextShort;
    }

    /**
     * Getter for the long help text.
     * @return The long help text.
     */
    public String getLongHelpText() {
        return this.helpTextLong;
    }
}
