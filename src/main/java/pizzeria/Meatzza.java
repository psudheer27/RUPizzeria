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
        return 0;
    }
}
