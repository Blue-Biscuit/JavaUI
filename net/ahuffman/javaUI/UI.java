package net.ahuffman.javaUI;

import java.util.ArrayList;
import java.io.PrintStream;

/**
 * The class which holds the commands to be run.
 */
public class UI {
    /**
     * The command list.
     */
    private final ArrayList<Command> commands;

    /**
     * The default capacity of the command list.
     */
    private static final int DEFAULT_ARR_CAPCITY = 50;

    /**
     * Constructor.
     */
    public UI() {
        this.commands = new ArrayList<>(DEFAULT_ARR_CAPCITY);
    }

    /**
     * Runs the UI.
     * @param input The user input string.
     * @param stream The output stream.
     */
    public void run(String input, PrintStream stream) {
        // TODO: null checks

        String[] args = input.split("\\s+");

        // If there are no args, return.

        if (args.length == 0) {
            return;
        }

        // Otherwise, loop through the commands, and call whichever matches
        // the command name.

        String cmdName = args[0];
        for (Command c : this.commands) {
            if (c.getName().equals(cmdName)) {
                c.call(args, stream);
                break;
            }
        }
    }

    /**
     * Registers a command into the command list.
     * @param c The command to register.
     * @throws CommandRegisterException If a command with this name has already been registered,
     * or c is null.
     */
    public void registerCommand(Command c) throws CommandRegisterException {
        // Check if the command is null.

        if (c == null) {
            throw new CommandRegisterException("Command to register was null.");
        }

        // Check if a command has already been registered under this name.

        String cName = c.getName();
        for (Command regCmd : this.commands) {
            String regName = regCmd.getName();

            if (regName.equals(cName)) {
                throw new CommandRegisterException("A command with the name " + regName + " already exists.");
            }
        }
        
        // Add the command to the commands list.

        this.commands.add(c);
    }
}
