package net.ahuffman.javaUI;

import java.util.Scanner;

public class TestMain {
    public static void main(String[] args) {

        CommandCallback helloCallback = (a, stream) -> {
            stream.println("Hello!");
        };

        Command c = new Command("hello", helloCallback, "Prints \"Hello!\" to the output stream.", "This command will print hello to output.\nThis is a long comment.\nThis is soo long!");

        UI ui = new UI();
        ui.registerCommand(c);
        Scanner s = new Scanner(System.in);
        Command exitCommand = new Command (
            "exit",
            (a, stream) -> {
                ui.stop();
            },
            "Exits the program.",
            "Exits the program."
        );
        ui.registerCommand(exitCommand);

        ui.start();
        
        while (ui.isRunning()) {
            System.out.print(">> ");
            String input = s.nextLine();
            ui.run(input, System.out);
        }
        s.close();
    }
}
