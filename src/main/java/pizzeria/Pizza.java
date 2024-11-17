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

    public void setSize(Size size){
        this.size = size;
    }

    public void addTopping(Topping topping){
        toppings.add(topping);
    }
}
