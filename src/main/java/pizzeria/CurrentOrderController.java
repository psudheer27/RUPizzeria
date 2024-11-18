package pizzeria;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class CurrentOrderController {

    @FXML
    public ListView<Pizza> orderList;

    @FXML
    public TextField orderNumberField;


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
    }

    @FXML
    private void onRemovePizza() {
        startingMenuController.removePizza(orderList.getSelectionModel().getSelectedItem());
        orderList.getItems().remove(orderList.getSelectionModel().getSelectedItem());
    }

    @FXML
    private void onPlaceOrder() {
        startingMenuController.addOrder();
        orderList.getItems().clear();
    }

    @FXML
    private void onClearOrder() {
        startingMenuController.clearPizzas();
        orderList.getItems().clear();
    }




}
