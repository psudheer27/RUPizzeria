package pizzeria;

/**
 *
 * Represents a Build Your Own pizza.
 * This class extends the abstract Pizza class and calculates the price for a Build Your Own pizza based on size and toppings.
 * @author Pranav Sudheer and Pranav Komarla
 */
public class BuildYourOwn extends Pizza{

    private static final double TOPPING_PRICE = 1.69;

    /**
     * Calculates the price of the Build Your Own pizza based on its size and number of toppings.
     *
     * @return the price of the pizza
     * @throws IllegalStateException if the size is invalid or if there are more than 7 toppings
     */
    @Override
    public double price() {
        if(getToppings().size() <= 7) {
            if(getSize() != null) {
                return switch (getSize()) {
                    case Small -> 8.99 + (TOPPING_PRICE * getToppings().size());
                    case Medium -> 10.99 + (TOPPING_PRICE * getToppings().size());
                    case Large -> 12.99 + (TOPPING_PRICE * getToppings().size());
                };
            }
            else {
                throw new IllegalStateException("Invalid Size!");
            }
        }
        else {
            throw new IllegalStateException("Cannot have more than 7 toppings!");
        }
    }
}
