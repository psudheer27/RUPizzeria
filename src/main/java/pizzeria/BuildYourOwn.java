package pizzeria;

public class BuildYourOwn extends Pizza{

    private static final double TOPPING_PRICE = 1.69;

    @Override
    public double price() {
        return switch (getSize()) {
            case Small -> 9.99 + (TOPPING_PRICE * getToppings().size());
            case Medium -> 11.99 + (TOPPING_PRICE * getToppings().size());
            case Large -> 13.99 + (TOPPING_PRICE * getToppings().size());
            default -> throw new IllegalStateException("Invalid Size!");
        };
    }
}
