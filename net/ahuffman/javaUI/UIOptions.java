package net.ahuffman.javaUI;

/**
 * A data class which specifies certain options for the UI.
 */
public class UIOptions {
    /**
     * The name of the help command.
     */
    public String helpCommandName = "help";

    /**
     * The callback function used by the help command. If null,
     * the default will be used.
     */
    public CommandCallback helpCommandCallback = null;

    /**
     * The short help text used for the help command.
     */
    public String helpCommandHelpTextShort = "Prints help for all commands or more detailed help for a single command.";

    /**
     * The long help text used for the help command.
     */
    public String helpCommandHelpTextLong = 
        "Prints help for all commands or more detailed help for a single command.\n\n"
        + "Usage:"
        + "\nhelp"
        + "\n\tPrints general help for all commands."
        + "\nhelp <name>"
        + "\n\tPrints more specific help for one command."
        + "\n\t<name> = The name of the command to print help for.";

    /**
     * If true, a space will be printed after the result of a command.
     */
    public boolean spaceAfterCommandResult = true;

    /**
     * Default constructor (stub)
     */
    UIOptions() {

    }

    /**
     * Cloning constructor.
     * @param clone The object to clone.
     */
    UIOptions(UIOptions clone) {
        this.helpCommandName = clone.helpCommandName;
        this.helpCommandCallback = clone.helpCommandCallback;
        this.helpCommandHelpTextShort = clone.helpCommandHelpTextShort;
        this.helpCommandHelpTextLong = clone.helpCommandHelpTextShort;
        this.spaceAfterCommandResult = clone.spaceAfterCommandResult;
    }
}
