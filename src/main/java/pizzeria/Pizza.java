package pizzeria;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Represents a pizza.
 * This abstract class defines the common properties and methods for all types of pizzas.
 * It includes the toppings, crust, and size of a pizza.
 */
public abstract class Pizza {
    private ArrayList<Topping> toppings;
    private Crust crust;
    private Size size;

    /**
     * Calculates the price of the pizza.
     * This method must be implemented by subclasses to provide specific price calculations.
     *
     * @return the price of the pizza
     */
    public abstract double price();

    /**
     * Constructs a Pizza object with an empty list of toppings.
     */
    public Pizza() {
        this.toppings = new ArrayList<Topping>();
    }

    /**
     * Sets the crust type of the pizza.
     *
     * @param crust the crust type
     */
    public void setCrust(Crust crust){
        this.crust = crust;
    }

    /**
     * Sets the size of the pizza.
     *
     * @param size the size of the pizza
     */
    public void setSize(Size size){
        this.size = size;
    }

    /**
     * Returns the size of the pizza.
     *
     * @return the size of the pizza
     */
    public Size getSize(){
        return this.size;
    }

    /**
     * Adds a topping to the pizza.
     *
     * @param topping the topping to add
     */
    public void addTopping(Topping topping){
        toppings.add(topping);
    }

    /**
     * Returns the list of toppings on the pizza.
     *
     * @return the list of toppings
     */
    public ArrayList<Topping> getToppings(){
        return toppings;
    }

    /**
     * Returns the crust type of the pizza.
     *
     * @return the crust type
     */
    public Crust getCrust(){
        return crust;
    }

    /**
     * Sets the list of toppings on the pizza.
     *
     * @param toppings the list of toppings
     */
    public void setToppings(ArrayList<Topping> toppings) {
        this.toppings = toppings;
    }

    /**
     * Returns a string representation of the pizza.
     * The string includes the type, crust, toppings, size, and price of the pizza.
     *
     * @return a string representation of the pizza
     */
    @Override
    public String toString() {
        String str = "";
        if(crust == Crust.DeepDish)
            str += "Deluxe (Chicago Style - " + crust.name() + "), ";
        else if(crust == Crust.Stuffed) {
            str += "Meatzza (Chicago Style - " + crust.name() + "), ";
        } else if(crust == Crust.Brooklyn) {
            str += "Deluxe (NY Style - " + crust.name() + "), ";
        } else if(crust == Crust.Thin) {
            str += "BBQ Chicken (NY Style - " + crust.name() + "), ";
        } else if(crust == Crust.Pan) {
            if(this instanceof BBQChicken)
                str += "BBQ Chicken (Chicago Style - " + crust.name() + "), ";
            else
                str += "Build Your Own (Chicago Style - " + crust.name() + "), ";
        } else if(crust == Crust.HandTossed) {
            if(this instanceof Meatzza)
                str += "Meatzza (NY Style - " + crust.name() + "), ";
            else
                str += "Build Your Own (NY Style - " + crust.name() + "), ";

        }
        str += "Toppings: ";
        for(Topping topping : toppings){
            if(toppings.indexOf(topping) == toppings.size() - 1) str += topping.name()+ ", ";
            else str += topping.name() + ", ";
        }
        DecimalFormat df = new DecimalFormat("#.##");
        str += "Size : " + size.name() + ", Price: $" + df.format(price());
        return str;
    }
}

