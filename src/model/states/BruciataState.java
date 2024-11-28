package model.states;

import model.Pizza;

public class BruciataState implements PizzaState {
    @Override
    public void next(Pizza pizza) {
        System.out.println("Pizza " + pizza.getName() + ": È già bruciata. Nessun ulteriore cambiamento di stato.");
    }

    @Override
    public void printState() {
        System.out.println("Stato attuale: Bruciata.");
    }
}
