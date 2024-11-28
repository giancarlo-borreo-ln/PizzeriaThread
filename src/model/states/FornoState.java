package model.states;

import model.Pizza;

import java.util.concurrent.ThreadLocalRandom;

public class FornoState implements PizzaState{
    @Override
    public void next(Pizza pizza) {
        boolean success = ThreadLocalRandom.current().nextDouble() > 0.5;

        if (success) {
            System.out.println("Pizza " + pizza.getName() + ": Pronta!");
            pizza.setState(new ProntaState());
        } else {
            System.out.println("Pizza " + pizza.getName() + ": È stata bruciata da Gino Managgino!");
            pizza.setState(new BruciataState());
        }
    }

    @Override
    public void printState() {
        System.out.println("Stato attuale: Forno.");
    }
}
