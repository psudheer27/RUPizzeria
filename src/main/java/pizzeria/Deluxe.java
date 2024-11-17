package pizzeria;

public class Deluxe extends Pizza{

    public Deluxe() {
        addTopping(Topping.Sausage);
        addTopping(Topping.Pepperoni);
        addTopping(Topping.GreenPepper);
        addTopping(Topping.Onion);
        addTopping(Topping.Mushroom);
    }

    @Override
    public double price() {
        return 0;
    }
}
