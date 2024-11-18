package pizzeria;

/**
 * Represents a Deluxe pizza.
 * This class extends the abstract Pizza class and defines the specific toppings and price for a Deluxe pizza.
 */
public class Deluxe extends Pizza{

    /**
     * Constructs a Deluxe pizza with the default toppings.
     * The default toppings are Sausage, Pepperoni, Green Pepper, Onion, and Mushroom.
     */
    public Deluxe() {
        addTopping(Topping.Sausage);
        addTopping(Topping.Pepperoni);
        addTopping(Topping.GreenPepper);
        addTopping(Topping.Onion);
        addTopping(Topping.Mushroom);
    }

    /**
     * Calculates the price of the Deluxe pizza based on its size.
     *
     * @return the price of the pizza
     * @throws IllegalStateException if the size is invalid
     */
    @Override
    public double price() {
        return switch (getSize()) {
            case Small -> 16.99;
            case Medium -> 18.99;
            case Large -> 20.99;
            default -> throw new IllegalStateException("Invalid Size!");
        };
    }
}
