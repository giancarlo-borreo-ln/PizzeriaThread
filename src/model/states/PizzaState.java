package model.states;

import model.Pizza;

public interface PizzaState {
    /**
     * Passa la pizza allo stato successivo.
     *
     * @param pizza La pizza su cui applicare la transizione di stato.
     */
    void next(Pizza pizza);

    /**
     * Stampa lo stato attuale della pizza.
     */
    void printState();
}
