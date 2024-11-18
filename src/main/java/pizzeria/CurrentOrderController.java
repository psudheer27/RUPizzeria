package pizzeria;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;

public class CurrentOrderController {

    @FXML
    public ListView<Pizza> orderList;

    @FXML
    public TextField orderNumberField;
    public TextField subtotalField;
    public TextField salesTaxField;
    public TextField orderTotalField;


    private StartingMenuController startingMenuController;

    private ObservableList<Pizza> items;



    @FXML
    public void setMainController(StartingMenuController startingMenuController) {
        this.startingMenuController = startingMenuController;
        initializing();
    }

    @FXML
    public void initializing() {
        orderNumberField.setText("" + startingMenuController.getOrderNumber());
        orderNumberField.setDisable(true);

        items = FXCollections.observableArrayList(startingMenuController.getPizzas());
        orderList.setItems(items);
        setTextFields();
    }

    @FXML
    private void onRemovePizza() {
        startingMenuController.removePizza(orderList.getSelectionModel().getSelectedItem());
        orderList.getItems().remove(orderList.getSelectionModel().getSelectedItem());
        setTextFields();
    }

    @FXML
    private void onPlaceOrder() {
        startingMenuController.addOrder();
        orderList.getItems().clear();
        setTextFields();
    }

    @FXML
    private void onClearOrder() {
        startingMenuController.clearPizzas();
        orderList.getItems().clear();
        setTextFields();
    }

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
