package pizzeria;

import java.util.ArrayList;

public class Order {
    private int number;
    private ArrayList<Pizza> pizzas;

    public Order(int number, ArrayList<Pizza> pizzas) {
        this.number = number;
        this.pizzas = pizzas;
        System.out.println(pizzas);
    }

    public int getNumber() {
        return number;
    }



    public ArrayList<Pizza> getPizza() {
        return pizzas;
    }
}
