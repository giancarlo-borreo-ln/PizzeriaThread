package controller;

import model.Pizza;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Controller per la gestione della logica della pizzeria
public class PizzeriaController {
    private final int maxForni; // Numero massimo di thread/forni
    private final ExecutorService pizzeriaPool; // Thread pool
    private final List<Pizza> ordinePizze; // Lista delle pizze

    public PizzeriaController(int maxForni) {
        this.maxForni = maxForni;
        this.pizzeriaPool = Executors.newFixedThreadPool(maxForni);
        this.ordinePizze = new ArrayList<>();
    }

    // Aggiunge una pizza all'ordine
    public void aggiungiPizza(String nomePizza) {
        Pizza pizza = new Pizza(nomePizza);
        ordinePizze.add(pizza);
        System.out.println("Pizza " + nomePizza + " aggiunta all'ordine.");
    }

    // Avvia la preparazione di tutte le pizze
    public void avviaPreparazione() {
        System.out.println("Inizio preparazione delle pizze...");
        for (Pizza pizza : ordinePizze) {
            pizzeriaPool.execute(pizza); // Avvia ogni pizza come thread
        }
    }

    // Attende il completamento di tutte le pizze
    public void completaPreparazione() {
        pizzeriaPool.shutdown(); // Chiude il pool dopo aver inviato tutti i task
        while (!pizzeriaPool.isTerminated()) {
            // Aspetta che tutti i thread siano completati
        }
        System.out.println("Preparazione completata per tutte le pizze!");
    }

    // Mostra l'elenco delle pizze ordinate
    public void mostraOrdine() {
        System.out.println("Pizze in ordine:");
        for (Pizza pizza : ordinePizze) {
            System.out.println("- " + pizza.getName());
        }
    }
}
