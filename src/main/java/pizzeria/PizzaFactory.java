package pizzeria;

/**
 * Represents a factory for creating pizzas.
 * This interface defines the specific pizzas that can be created.
 */
public interface PizzaFactory {
    Pizza createDeluxe();
    Pizza createMeatzza();
    Pizza createBBQChicken();
    Pizza createBuildYourOwn();
}


