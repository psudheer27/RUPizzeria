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

/**
 * Controller for the Starting Menu View.
 * This class handles the user interactions and updates the view accordingly.
 * @author Pranav Sudheer and Pranav Komarla
 */
public class StartingMenuController {
    private ArrayList<Pizza> pizzas;
    private ArrayList<Order> orders;

    private int orderNumber;

    @FXML
    public Button chicagoStyleButton, nyStyleButton, ordersPlacedButton, currentOrderButton;

    /**
     * Initializes the controller.
     * Sets up the initial state of the view components and initializes the order number, pizzas, and orders.
     */
    @FXML
    public void initialize() {
        orderNumber = 1;
        pizzas = new ArrayList<Pizza>();
        orders = new ArrayList<Order>();
    }

    /**
     * Opens the Chicago Style Pizza view.
     * Loads the FXML file and sets the main controller.
     *
     * @throws IOException if the FXML file cannot be loaded
     */
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

    /**
     * Opens the New York Style Pizza view.
     * Loads the FXML file and sets the main controller.
     *
     * @throws IOException if the FXML file cannot be loaded
     */
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

    /**
     * Opens the Orders Placed view.
     * Loads the FXML file and sets the main controller.
     *
     * @throws IOException if the FXML file cannot be loaded
     */
    @FXML
    private void openOrdersPlaced() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("store-orders-view.fxml"));

        Stage stage = new Stage();
        stage.setScene(new Scene(loader.load()));

        StoreOrdersViewController storeOrdersViewController = loader.getController();
        storeOrdersViewController.setMainController(this);


        stage.setTitle("Orders Placed");

        stage.show();
    }

    /**
     * Opens the Current Order view.
     * Loads the FXML file and sets the main controller.
     *
     * @throws IOException if the FXML file cannot be loaded
     */
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

    /**
     * Returns the list of orders.
     *
     * @return the list of orders
     */
    public ArrayList<Order> getOrders() {
        return orders;
    }

    /**
     * Returns the list of pizzas.
     *
     * @return the list of pizzas
     */
    public ArrayList<Pizza> getPizzas() {
        return pizzas;
    }

    /**
     * Adds a pizza to the current order.
     *
     * @param pizza the pizza to add
     */
    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
    }

    /**
     * Clears the list of pizzas in the current order.
     */
    public void clearPizzas() {
        pizzas.clear();
    }

    /**
     * Removes a pizza from the current order.
     *
     * @param pizza the pizza to remove
     */
    public void removePizza(Pizza pizza) {
        pizzas.remove(pizza);
    }

    /**
     * Adds the current order to the list of orders.
     * Clears the current order and increments the order number.
     */
    public void addOrder() {
        ArrayList<Pizza> tempPizzas = new ArrayList<Pizza>(pizzas.size());
        for(int i = 0; i < pizzas.size(); i++){
            tempPizzas.add(pizzas.get(i));
        }
        Order order = new Order(orderNumber, tempPizzas);
        orders.add(order);
        pizzas.clear();
        orderNumber++;
    }

    /**
     * Removes an order from the list of orders.
     *
     * @param order the order to remove
     */
    public void removeOrder(Order order) {
        orders.remove(order);
    }

    /**
     * Clears the list of orders.
     */
    public void clearOrders() {
        orders.clear();
    }

    /**
     * Returns the current order number.
     *
     * @return the current order number
     */
    public int getOrderNumber() {
        return orderNumber;
    }
}
