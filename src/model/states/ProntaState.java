package model.states;

import model.Pizza;

public class ProntaState implements PizzaState{
    @Override
    public void next(Pizza pizza) {
        // Nessun cambiamento di stato, la pizza è già pronta
        System.out.println("Pizza " + pizza.getName() + ": È già pronta. Nessun ulteriore cambiamento di stato.");
    }

    @Override
    public void printState() {
        System.out.println("Stato attuale: Pronta.");
    }
}
