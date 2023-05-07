package main;

import domain.DomeinController;
import gui.ConsoleUi;

public class StartUp {
    public static void main(String [] arg) {
        new StartUp().run();
    }

    private void run() {
        new ConsoleUi(new DomeinController(true)).run();
        //new ConsoleUi(new DomeinController(false)).run(); //zonder DB populate
    }
    
}
