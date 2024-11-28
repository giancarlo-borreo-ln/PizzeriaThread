package model.states;

import model.Pizza;

public class CondimentoState implements PizzaState{
    @Override
    public void next(Pizza pizza) {
        System.out.println("Pizza " + pizza.getName() + ": Passaggio al forno.");
        pizza.setState(new FornoState());
    }

    @Override
    public void printState() {
        System.out.println("Stato attuale: Condimento.");
    }
}
