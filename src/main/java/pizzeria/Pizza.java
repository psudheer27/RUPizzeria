package pizzeria;

import java.util.ArrayList;

public abstract class Pizza {
    private ArrayList<Topping> toppings;
    private Crust crust;
    private Size size;
    public abstract double price();

    public Pizza() {
        this.toppings = new ArrayList<Topping>();
        this.crust = crust;
        this.size = size;
    }

    public ArrayList<Topping> getToppings(){
        return toppings;
    }

    public Crust getCrust(){
        return crust;
    }

    public Size getSize(){
        return size;
    }
}
