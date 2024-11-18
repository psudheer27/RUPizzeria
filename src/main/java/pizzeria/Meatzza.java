package pizzeria;

/**
 * Represents a Meatzza pizza.
 * This class extends the abstract Pizza class and defines the specific toppings and price for a Meatzza pizza.
 */
public class Meatzza extends Pizza{

    /**
     * Constructs a Meatzza pizza with the default toppings.
     * The default toppings are Sausage, Pepperoni, Ham, and Beef.
     */
    public Meatzza() {
        addTopping(Topping.Sausage);
        addTopping(Topping.Pepperoni);
        addTopping(Topping.Ham);
        addTopping(Topping.Beef);
    }

    /**
     * Calculates the price of the Meatzza pizza based on its size.
     *
     * @return the price of the pizza
     * @throws IllegalStateException if the size is invalid
     */
    @Override
    public double price() {
        return switch (getSize()) {
            case Small -> 17.99;
            case Medium -> 19.99;
            case Large -> 21.99;
            default -> throw new IllegalStateException("Invalid Size!");
        };
    }
}
