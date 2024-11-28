package view;

import controller.PizzeriaController;

import java.util.Scanner;

public class PizzeriaView {

    public static void main(String[] args) {
        // Gusti disponibili
        String[] gusti = {"Margherita", "Diavola", "Quattro Formaggi", "Capricciosa"};
        PizzeriaController controller = new PizzeriaController(3); // Max 3 forni
        Scanner scanner = new Scanner(System.in);

        System.out.println("Benvenuti alla Pizzeria!");
        System.out.print("Quante pizze vuoi ordinare? ");
        int numPizze = scanner.nextInt();
        scanner.nextLine(); // Consuma newline

        for (int i = 0; i < numPizze; i++) {
            System.out.println("Scegli un gusto per la pizza " + (i + 1) + ":");
            for (int j = 0; j < gusti.length; j++) {
                System.out.println((j + 1) + ". " + gusti[j]);
            }

            int sceltaGusto = -1;
            while (sceltaGusto < 1 || sceltaGusto > gusti.length) {
                System.out.print("Inserisci il numero del gusto: ");
                sceltaGusto = scanner.nextInt();
                scanner.nextLine(); // Consuma newline
            }

            String gustoScelto = gusti[sceltaGusto - 1];
            controller.aggiungiPizza(gustoScelto);
        }

        System.out.println("\nEcco il tuo ordine:");
        controller.mostraOrdine();

        System.out.println("\nPrepariamo le tue pizze...");
        controller.avviaPreparazione();
        controller.completaPreparazione();

        System.out.println("Grazie per aver ordinato da noi!");
    }
}
