package pizzeria;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;

/**
 * Controller for the Current Order View.
 * This class handles the user interactions and updates the view accordingly.
 * @author Pranav Sudheer and Pranav Komarla
 */
public class CurrentOrderController {

    @FXML
    private ListView<Pizza> orderList;

    @FXML
    private TextField orderNumberField, subtotalField, salesTaxField, orderTotalField;

    @FXML
    private Button placeOrderButton;

    private StartingMenuController startingMenuController;

    private ObservableList<Pizza> items;


    /**
     * Sets the main controller.
     * Initializes the current order view with the main controller's data.
     *
     * @param startingMenuController the main controller
     */
    @FXML
    public void setMainController(StartingMenuController startingMenuController) {
        this.startingMenuController = startingMenuController;
        initializing();
    }

    /**
     * Initializes the current order view.
     * Sets the order number, populates the order list, and updates the text fields.
     */
    @FXML
    private void initializing() {
        orderNumberField.setText("" + startingMenuController.getOrderNumber());
        orderNumberField.setDisable(true);

        items = FXCollections.observableArrayList(startingMenuController.getPizzas());

        if(items.isEmpty()){placeOrderButton.setDisable(true);}
        else{placeOrderButton.setDisable(false);}

        orderList.setItems(items);
        setTextFields();
    }

    /**
     * Removes the selected pizza from the order.
     * Updates the order list and text fields.
     */
    @FXML
    private void onRemovePizza() {
        startingMenuController.removePizza(orderList.getSelectionModel().getSelectedItem());
        orderList.getItems().remove(orderList.getSelectionModel().getSelectedItem());
        if(items.isEmpty()){
            placeOrderButton.setDisable(true);
        }
        else{
            placeOrderButton.setDisable(false);
        }
        setTextFields();
    }

    /**
     * Places the current order.
     * Clears the order list and updates the text fields.
     */
    @FXML
    private void onPlaceOrder() {
        startingMenuController.addOrder();
        orderList.getItems().clear();
        setTextFields();
    }

    /**
     * Clears the current order.
     * Removes all pizzas from the order list and updates the text fields.
     */
    @FXML
    private void onClearOrder() {
        startingMenuController.clearPizzas();
        orderList.getItems().clear();
        placeOrderButton.setDisable(true);
        setTextFields();
    }

    /**
     * Updates the text fields for subtotal, sales tax, and order total.
     * Calculates the values based on the current pizzas in the order.
     */
    @FXML
    private void setTextFields() {
        double subtotal = 0;
        double salesTax = 0;

        for(Pizza pizza: startingMenuController.getPizzas()) {
            subtotal += pizza.price();
        }

        salesTax = subtotal * 0.06625;

        DecimalFormat df = new DecimalFormat("#.##");
        subtotalField.setText(String.valueOf(df.format(subtotal)));
        salesTaxField.setText(String.valueOf(df.format(salesTax)));
        orderTotalField.setText(String.valueOf(df.format(subtotal + salesTax)));
    }
}
