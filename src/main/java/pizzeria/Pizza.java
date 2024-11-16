package pizzeria;

public abstract class Pizza {
    private ArrayList<Topping> toppings;
    private Crust crust;
    private Size size;
    public abstract double price();

    public Pizza() {
        this.toppings = new ArrayList<Topping>();
        this.crust = Crust.REGULAR;
        this.size = Size.MEDIUM;
    }
}
