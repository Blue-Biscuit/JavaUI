package net.ahuffman.javaUI;

import java.io.PrintStream;

public interface CommandCallback {
    /**
     * The command callback function.
     * @param args The string used to call the command.
     * @param stream The IO stream.
     */
    public abstract void callback(String[] args, PrintStream stream);
}
