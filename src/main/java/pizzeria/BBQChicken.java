package pizzeria;

public class BBQChicken extends Pizza{

    public BBQChicken() {
        addTopping(Topping.BBQChicken);
        addTopping(Topping.GreenPepper);
        addTopping(Topping.Provolone);
        addTopping(Topping.Cheddar);
    }

    @Override
    public double price() {
        return switch (getSize()) {
            case Small -> 14.99;
            case Medium -> 16.99;
            case Large -> 19.99;
            default -> throw new IllegalStateException("Invalid Size!");
        };
    }
}
