package pizzeria;

/**
 * Represents a factory for creating pizzas.
 * This interface defines the specific pizzas that can be created.
 * @author Pranav Sudheer and Pranav Komarla
 */
public interface PizzaFactory {
    Pizza createDeluxe();
    Pizza createMeatzza();
    Pizza createBBQChicken();
    Pizza createBuildYourOwn();
}


