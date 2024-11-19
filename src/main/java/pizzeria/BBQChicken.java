package pizzeria;

/**
 * @author Pranav Sudheer and Pranav Komarla
 * Represents a BBQ Chicken pizza.
 * This class extends the abstract Pizza class and defines the specific toppings and price for a BBQ Chicken pizza.
 */
public class BBQChicken extends Pizza{

    /**
     * Constructs a BBQ Chicken pizza with the default toppings.
     * The default toppings are BBQ Chicken, Green Pepper, Provolone, and Cheddar.
     */
    public BBQChicken() {
        addTopping(Topping.BBQChicken);
        addTopping(Topping.GreenPepper);
        addTopping(Topping.Provolone);
        addTopping(Topping.Cheddar);
    }

    /**
     * Calculates the price of the BBQ Chicken pizza based on its size.
     *
     * @return the price of the pizza
     * @throws IllegalStateException if the size is invalid
     */
    @Override
    public double price() {
        return switch (getSize()) {
            case Small -> 14.99;
            case Medium -> 16.99;
            case Large -> 19.99;
            default -> throw new IllegalStateException("Invalid Size!");
        };
    }
}
