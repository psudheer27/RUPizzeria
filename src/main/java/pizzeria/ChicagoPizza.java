package pizzeria;

public class ChicagoPizza implements PizzaFactory{

    public Pizza createDeluxe() {
        Pizza pizza = new Deluxe();
        pizza.setCrust(Crust.DeepDish);
        return pizza;
    }
    public Pizza createMeatzza() {
        Pizza pizza = new Meatzza();
        pizza.setCrust(Crust.Stuffed);
        return pizza;
    }
    public Pizza createBBQChicken() {
        Pizza pizza = new BBQChicken();
        pizza.setCrust(Crust.Pan);
        return pizza;
    }
    public Pizza createBuildYourOwn() {
        Pizza pizza = new BuildYourOwn();
        pizza.setCrust(Crust.Pan);
        return pizza;
    }
}
