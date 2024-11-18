package pizzeria;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class StartingMenuController {



    private ArrayList<Pizza> pizzas;
    private ArrayList<Order> orders;



    @FXML
    public Button chicagoStyleButton, nyStyleButton, ordersPlacedButton, currentOrderButton;


    @FXML
    public void initialize() {
        pizzas = new ArrayList<Pizza>();
        orders = new ArrayList<Order>();
    }

    @FXML
    private void openChicagoStyle() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("chicagoStyle.fxml"));

        Stage stage = new Stage();
        stage.setScene(new Scene(loader.load()));

        ChicagoStyleController chicagoStyleController = loader.getController();
        chicagoStyleController.setMainController(this);



        stage.setTitle("Chicago Style");

        stage.show();

    }
    @FXML
    private void openNYStyle() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ny-pizza-view.fxml"));

        Stage stage = new Stage();
        stage.setScene(new Scene(loader.load()));

        NYPizzaController nyPizzaController = loader.getController();
        nyPizzaController.setMainController(this);

        stage.setTitle("NY Style");

        stage.show();

    }
    @FXML
    private void openOrdersPlaced() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("store-orders-view.fxml"));

        Stage stage = new Stage();
        stage.setScene(new Scene(loader.load()));

        stage.setTitle("Orders Placed");

        stage.show();
    }

    @FXML
    private void openCurrentOrder() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("current-order.fxml"));



        Stage stage = new Stage();
        stage.setScene(new Scene(loader.load()));

        CurrentOrderController currentOrderController = loader.getController();
        currentOrderController.setMainController(this);



        stage.setTitle("Current Order");

        stage.show();
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public ArrayList<Pizza> getPizzas() {
        return pizzas;
    }

    public void setOrders(Order order) {

    }

    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
    }

    public void addPizza(String pizza) {

    }
}
