package net.ahuffman.javaUI;

import java.util.Scanner;

public class TestMain {
    public static void main(String[] args) {
        CommandCallback helloCallback = (a, stream) -> {
            stream.println("Hello!");
        };

        Command c = new Command("hello", helloCallback, "", "");

        UI ui = new UI();
        ui.registerCommand(c);
        Scanner s = new Scanner(System.in);
        
        while (true) {
            System.out.print(">> ");
            String input = s.nextLine();
            ui.run(input, System.out);
        }
    }
}
