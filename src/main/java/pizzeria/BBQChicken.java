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
        return 0;
    }
}
