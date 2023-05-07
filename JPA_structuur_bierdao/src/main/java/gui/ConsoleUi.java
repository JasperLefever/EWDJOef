package gui;

import domain.DomeinController;
import java.util.Scanner;

public class ConsoleUi {
    private final DomeinController domeinController;
    private final Scanner in = new Scanner(System.in);
    public ConsoleUi(DomeinController dc) {
       domeinController = dc;
    }

    public void run() {
        doStandardJob();
        domeinController.close();
    }

    private void doStandardJob() {
        System.out.println("BierWinkelSysteem Actief");
        System.out.println("Winkels :");
        System.out.println(domeinController.geefWinkelList());
        System.out.println("Geef winkelnaam voor toe te voegen bier");
        String winkelNaam = in.nextLine();
        System.out.println("Geef naam van toe te voegen bier");
        String bierNaam = in.nextLine();
        try {
            domeinController.voegBierBijWinkel(bierNaam, winkelNaam);
        } catch (IllegalArgumentException ex) {
            System.out.println("Operatie mislukt " + ex.getMessage());
        }
    }
    
}
