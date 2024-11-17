package pizzeria;

public class Meatzza extends Pizza{

    public Meatzza() {
        addTopping(Topping.Sausage);
        addTopping(Topping.Pepperoni);
        addTopping(Topping.Ham);
        addTopping(Topping.Beef);
    }

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
