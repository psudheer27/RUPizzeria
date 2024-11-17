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

    public void setCrust(Crust crust){
        this.crust = crust;
    }

    public Size getSize(){
        return this.size;
    }

    public void addTopping(Topping topping){
        toppings.add(topping);
    }

    public ArrayList<Topping> getToppings(){
        return toppings;
    }
}
