package pizzeria;

import java.util.ArrayList;

public abstract class Pizza {
    private ArrayList<Topping> toppings;
    private Crust crust;
    private Size size;
    public abstract double price();

    public Pizza() {
        this.toppings = new ArrayList<Topping>();
    }

    public void setCrust(Crust crust){
        this.crust = crust;
    }

    public void setSize(Size size){
        this.size = size;
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

    public Crust getCrust(){
        return crust;
    }

    public void setToppings(ArrayList<Topping> toppings) {
        this.toppings = toppings;
    }

    @Override
    public String toString() {


        String str = "";
        if(crust == Crust.DeepDish)
            str += "Deluxe(Chicago Style - " + crust.name() + "),";
        else if(crust == Crust.Stuffed) {
            str += "Meatzza(Chicago Style - " + crust.name() + "),";
        } else if(crust == Crust.Brooklyn) {
            str += "Deluxe(NY Style - " + crust.name() + "),";
        } else if(crust == Crust.Thin) {
            str += "BBQ Chicken(NY Style - " + crust.name() + "),";
        } else if(crust == Crust.Pan) {
            if(this instanceof BBQChicken)
                str += "BBQ Chicken(Chicago Style - " + crust.name() + "),";
            else
                str += "Build Your Own(Chicago Style - " + crust.name() + "),";
        } else if(crust == Crust.HandTossed) {
            if(this instanceof Meatzza)
                str += "Meatzza(NY Style - " + crust.name() + "),";
            else
                str += "Build Your Own(NY Style - " + crust.name() + "),";

        }


        for(Topping topping : toppings){
            str += topping.name() + ",";
        }
        str += size.name() + ",$" + price();
        return str;
    }
}

