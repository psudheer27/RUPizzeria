package pizzeria;

import java.util.ArrayList;

public class Order {
    private int number;
    private ArrayList<Pizza> pizzas;

    public Order() {
        this.number = 0;
        this.pizzas = new ArrayList<Pizza>();
    }
}
