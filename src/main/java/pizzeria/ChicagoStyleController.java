package pizzeria;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class ChicagoStyleController {
    @FXML
    private Label welcomeText;

    @FXML
    private ListView<String> availableToppingsChicagoStyle, selectedToppingsChicagoStyle;

    @FXML
    private Button backwardsChicago, forwardsChicago;

    @FXML
    public void initialize() {
        ObservableList<String> listItems = FXCollections.observableArrayList("Sausage", "Pepperoni", "GreenPepper", "Onion", "Mushroom", "BBQChicken", "Provolone", "Cheddar", "Beef", "Ham", "Jalapenos", "Olives", "BananaPepper");
        availableToppingsChicagoStyle.setItems(listItems);
        System.out.println("HELLO");
    }


    @FXML
    private void onForwards() {
        String selectedItem = availableToppingsChicagoStyle.getSelectionModel().getSelectedItem();
        selectedToppingsChicagoStyle.getItems().add(selectedItem);
        availableToppingsChicagoStyle.getItems().remove(selectedItem);

    }

    @FXML
    private void onBackwards() {
        String selectedItem = selectedToppingsChicagoStyle.getSelectionModel().getSelectedItem();
        selectedToppingsChicagoStyle.getItems().remove(selectedItem);
        availableToppingsChicagoStyle.getItems().add(selectedItem);
    }
}
