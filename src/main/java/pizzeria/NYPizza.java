package pizzeria;

/**
 * @author Pranav Sudheer and Pranav Komarla
 * Represents a factory for creating New York-style pizzas.
 * This class implements the PizzaFactory interface and defines the specific pizzas that can be created in New York.
 */
public class NYPizza implements PizzaFactory{
    /**
     * Creates a New York-style Deluxe pizza.
     *
     * @return the Deluxe pizza
     */
    public Pizza createDeluxe() {
        Pizza pizza = new Deluxe();
        pizza.setCrust(Crust.Brooklyn);
        return pizza;
    }

    /**
     * Creates a New York-style Meatzza pizza.
     *
     * @return the Meatzza pizza
     */
    public Pizza createMeatzza() {
        Pizza pizza = new Meatzza();
        pizza.setCrust(Crust.HandTossed);
        return pizza;
    }

    /**
     * Creates a New York-style BBQ Chicken pizza.
     *
     * @return the BBQ Chicken pizza
     */
    public Pizza createBBQChicken() {
        Pizza pizza = new BBQChicken();
        pizza.setCrust(Crust.Thin);
        return pizza;
    }

    /**
     * Creates a New York-style Build Your Own pizza.
     *
     * @return the Build Your Own pizza
     */
    public Pizza createBuildYourOwn() {
        Pizza pizza = new BuildYourOwn();
        pizza.setCrust(Crust.HandTossed);
        return pizza;
    }
}
