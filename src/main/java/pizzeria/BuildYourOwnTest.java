package pizzeria;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class BuildYourOwnTest {

    @Test
    public void testMoreThan7Toppings() {
        PizzaFactory pizzaFactory = new NYPizza();
        Pizza pizza = pizzaFactory.createBuildYourOwn();
        pizza.addTopping(Topping.Sausage);
        pizza.addTopping(Topping.Pepperoni);
        pizza.addTopping(Topping.GreenPepper);
        pizza.addTopping(Topping.Onion);
        pizza.addTopping(Topping.Mushroom);
        pizza.addTopping(Topping.BBQChicken);
        pizza.addTopping(Topping.Provolone);
        pizza.addTopping(Topping.Cheddar);
        pizza.setSize(Size.Small);

        Exception exception = assertThrows(IllegalStateException.class, pizza::price);
        assertEquals("Cannot have more than 7 toppings!", exception.getMessage());
    }

    @Test
    public void testInvalidSize() {
        PizzaFactory pizzaFactory = new ChicagoPizza();
        Pizza pizza = pizzaFactory.createBuildYourOwn();
        pizza.addTopping(Topping.Sausage);

        pizza.setSize(null);

        Exception exception = assertThrows(IllegalStateException.class, pizza::price);
        assertEquals("Invalid Size!", exception.getMessage());
    }

    @Test
    public void testValidSmallSizeWith5Toppings() {
        PizzaFactory pizzaFactory = new NYPizza();
        Pizza pizza = pizzaFactory.createBuildYourOwn();

        pizza.addTopping(Topping.Sausage);
        pizza.addTopping(Topping.Pepperoni);
        pizza.addTopping(Topping.GreenPepper);
        pizza.addTopping(Topping.Onion);
        pizza.addTopping(Topping.Mushroom);

        pizza.setSize(Size.Small);

        double expectedPrice = 8.99 + (5 * 1.69);
        assertEquals(expectedPrice, pizza.price(), 0.01);
    }

    @Test
    public void testValidMediumSizeWith3Toppings() {
        PizzaFactory pizzaFactory = new ChicagoPizza();
        Pizza pizza = pizzaFactory.createBuildYourOwn();

        pizza.addTopping(Topping.Sausage);
        pizza.addTopping(Topping.Pepperoni);
        pizza.addTopping(Topping.GreenPepper);

        pizza.setSize(Size.Medium);

        double expectedPrice = 10.99 + (3 * 1.69);
        assertEquals(expectedPrice, pizza.price(), 0.01);
    }

    @Test
    public void testValidLargeSizeWith1Topping() {
        PizzaFactory pizzaFactory = new NYPizza();
        Pizza pizza = pizzaFactory.createBuildYourOwn();

        pizza.addTopping(Topping.Jalapenos);

        pizza.setSize(Size.Large);

        double expectedPrice = 12.99 + (1 * 1.69);
        assertEquals(expectedPrice, pizza.price(), 0.01);
    }
}