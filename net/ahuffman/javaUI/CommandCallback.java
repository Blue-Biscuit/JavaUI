package net.ahuffman.javaUI;

public interface CommandCallback {
    /**
     * The command callback function.
     * @param args The string used to call the command.
     */
    public abstract void callback(String args);
}
