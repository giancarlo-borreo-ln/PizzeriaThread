package model;

import model.states.BruciataState;
import model.states.ImpastamentoState;
import model.states.PizzaState;
import model.states.ProntaState;

public class Pizza implements Runnable {
    private String name;
    private PizzaState state;

    public Pizza(String name) {
        this.name = name;
        this.state = new ImpastamentoState(); // Stato iniziale
    }

    public String getName() {
        return name;
    }

    public void setState(PizzaState state) {
        this.state = state;
    }

    public void nextState() {
        state.next(this);
    }

    public void printState() {
        state.printState();
    }

    @Override
    public void run() {
        System.out.println("Preparazione della pizza " + name + " iniziata.");
        while (!(state instanceof ProntaState || state instanceof BruciataState)) {
            printState();
            nextState();
            try {
                Thread.sleep((long) (Math.random() * 3000 + 1000)); // Ritardo casuale tra 1 e 4 secondi
            } catch (InterruptedException e) {
                System.out.println("Errore nella preparazione della pizza " + name);
                Thread.currentThread().interrupt();
            }
        }
        printState();
        System.out.println("Preparazione della pizza " + name + " completata.");
    }
}

