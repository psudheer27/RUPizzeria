package pizzeria;

import java.util.ArrayList;

/**
 * @author Pranav Sudheer and Pranav Komarla
 * Represents an order.
 * This class defines the order number and the pizzas in the order.
 */
public class Order {
    private int number;
    private ArrayList<Pizza> pizzas;

    /**
     * Creates an order with the given order number and pizzas.
     *
     * @param number the order number
     * @param pizzas the pizzas in the order
     */
    public Order(int number, ArrayList<Pizza> pizzas) {
        this.number = number;
        this.pizzas = pizzas;
    }

    /**
     * Returns the order number.
     *
     * @return the order number
     */
    public int getNumber() {
        return number;
    }

    /**
     * Returns the pizzas in the order.
     *
     * @return the pizzas in the order
     */
    public ArrayList<Pizza> getPizza() {
        return pizzas;
    }
}
