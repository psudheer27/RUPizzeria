package pizzeria;

/**
 * Represents a factory for creating Chicago-style pizzas.
 * This class implements the PizzaFactory interface and defines the specific pizzas that can be created in Chicago.
 */
public class ChicagoPizza implements PizzaFactory{

    /**
     * Creates a Chicago-style Deluxe pizza.
     *
     * @return the Deluxe pizza
     */
    public Pizza createDeluxe() {
        Pizza pizza = new Deluxe();
        pizza.setCrust(Crust.DeepDish);
        return pizza;
    }

    /**
     * Creates a Chicago-style Meatzza pizza.
     *
     * @return the Meatzza pizza
     */
    public Pizza createMeatzza() {
        Pizza pizza = new Meatzza();
        pizza.setCrust(Crust.Stuffed);
        return pizza;
    }

    /**
     * Creates a Chicago-style BBQ Chicken pizza.
     *
     * @return the BBQ Chicken pizza
     */
    public Pizza createBBQChicken() {
        Pizza pizza = new BBQChicken();
        pizza.setCrust(Crust.Pan);
        return pizza;
    }

    /**
     * Creates a Chicago-style Build Your Own pizza.
     *
     * @return the Build Your Own pizza
     */
    public Pizza createBuildYourOwn() {
        Pizza pizza = new BuildYourOwn();
        pizza.setCrust(Crust.Pan);
        return pizza;
    }
}
