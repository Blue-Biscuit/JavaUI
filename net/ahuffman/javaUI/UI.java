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
     * A signal to used to determine whether or not an "exit" signal has been given
     * to this UI.
     */
    private boolean running = false;

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
     * @throws NotRunningException If the UI has not been started with the start() method.
     */
    public void run(String input, PrintStream stream) throws NotRunningException {
        // If the UI is not running, throw.

        if (!running) {
            throw new NotRunningException("Attempted to run a command while the UI is not running. Run the start() method first.");
        }

        // TODO: null checks

        String[] args = input.split("\\s+");

        // If there are no args, return.

        if (args.length == 0) {
            return;
        }

        String cmdName = args[0];

        // If the command is "help," call that; help is a special command
        // which cannot be handled generically.

        if (cmdName.equals("help")) {
            defaultHelpCommand(args, stream);
        }

        // Otherwise, loop through the commands, and call whichever matches
        // the command name.

        else {
            for (Command c : this.commands) {
                if (c.getName().equals(cmdName)) {
                    c.call(args, stream);
                    break;
                }
            }
        }

        stream.println(); // So that there is a space between the current prompt and command ouput.
    }

    /**
     * Registers a command into the command list.
     * @param c The command to register.
     * @throws CommandRegisterException If a command with this name has already been registered,
     * or c is null.
     * @throws RunningException If the UI has already been started.
     */
    public void registerCommand(Command c) throws CommandRegisterException, RunningException {
        // If the UI is running, except.

        if (running) {
            throw new RunningException("Cannot register a command while the UI is running. It should be killed with the stop() method first.");
        }

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

    /**
     * Whether the command name given is registered.
     * @param name The name to test.
     * @return True if that name has been registered; false otherwise.
     */
    public boolean commandIsRegistered(String name) {
        for (Command c : commands) {
            String cmdName = c.getName();

            if (cmdName.equals(name)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Whether the command name given is registered.
     * @param name The name to test.
     * @return True if that name has been registered; false otherwise.
     */
    public boolean commandIsRegistered(Command command) {
        String name = command.getName();
        return this.commandIsRegistered(name);
    }

    /**
     * Gets a command based upon a name.
     * @param name The name of the command.
     * @return The command with that name.
     * @throws CommandException If the command was not found.
     */
    public Command getCommand(String name) throws CommandException {
        for (Command c : commands) {
            String n = c.getName();

            if (n.equals(name)) {
                return c;
            }
        }

        throw new CommandException("Command with name \"" + name + "\" not found among registered commands.");
    }

    /**
     * Whether or not the UI has been sent the "exit" command.
     * @return False if the UI has been sent an exit signal; true otherwise.
     */
    public boolean isRunning() {
        return running;
    }

    /**
     * Starts the UI.
     */
    public void start() {
        this.running = true;
    }

    /**
     * Stops the UI.
     */
    public void stop() {
        this.running = false;
    }

    /**
     * The default help command, which is called if it has not been overriden
     * by another (TODO: implement this feature)
     */
    protected void defaultHelpCommand(String[] args, PrintStream stream) {
        // If no specific command is provided, print a general list of all
        // commands.

        if (args.length <= 1) {
            for (Command c : this.commands) {
                stream.printf("%-30s%s\n", c.getName(), c.getShortHelpText());
            }
        }

        // Otherwise, print the extended help for the command provided.

        else {
            String commandName = args[1];

            if (commandIsRegistered(commandName)) {
                Command c = getCommand(commandName);

                stream.println(c.getLongHelpText());
            }
            else {
                stream.println("Command \"" + commandName + "\" not found.");
            }
        }
    }
}
