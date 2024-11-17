package pizzeria;

public class NYPizza implements PizzaFactory{
    public Pizza createDeluxe() {
        Pizza pizza = new Deluxe();
        pizza.setCrust(Crust.Brooklyn);
        return pizza;
    }
    public Pizza createMeatzza() {
        Pizza pizza = new Meatzza();
        pizza.setCrust(Crust.HandTossed);
        return pizza;
    }
    public Pizza createBBQChicken() {
        Pizza pizza = new BBQChicken();
        pizza.setCrust(Crust.Thin);
        return pizza;
    }
    public Pizza createBuildYourOwn() {
        Pizza pizza = new BuildYourOwn();
        pizza.setCrust(Crust.HandTossed);
        return pizza;
    }
}
