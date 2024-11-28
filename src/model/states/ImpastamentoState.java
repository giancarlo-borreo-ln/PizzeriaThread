package model.states;

import model.Pizza;

public class ImpastamentoState implements PizzaState {
    @Override
    public void next(Pizza pizza) {
        System.out.println("Pizza " + pizza.getName() + ": Passaggio a condimento.");
        pizza.setState(new CondimentoState());
    }

    @Override
    public void printState() {
        System.out.println("Stato attuale: Impastamento.");
    }
}
