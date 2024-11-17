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
        return switch (getSize()) {
            case Small -> 16.99;
            case Medium -> 18.99;
            case Large -> 20.99;
            default -> throw new IllegalStateException("Invalid Size!");
        };
    }
}
