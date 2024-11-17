package pizzeria;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class NYPizzaController {
    @FXML
    private Label welcomeText;

    @FXML
    private ListView<String> availableToppingsNYStyle, selectedToppingsNYStyle;

    @FXML
    private Button backwardsNY, forwardsNY;

    @FXML
    public void initialize() {
        ObservableList<String> listItems = FXCollections.observableArrayList("Sausage", "Pepperoni", "GreenPepper", "Onion", "Mushroom", "BBQChicken", "Provolone", "Cheddar", "Beef", "Ham", "Jalapenos", "Olives", "BananaPepper");
        availableToppingsNYStyle = new ListView<>(listItems);
        System.out.println("HELLO");
    }


    @FXML
    private void onForwards() {
        String selectedItem = selectedToppingsNYStyle.getSelectionModel().getSelectedItem();
        selectedToppingsNYStyle.getItems().add(selectedItem);
        availableToppingsNYStyle.getItems().remove(selectedItem);

    }

    @FXML
    private void onBackwards() {
        String selectedItem = availableToppingsNYStyle.getSelectionModel().getSelectedItem();
        selectedToppingsNYStyle.getItems().remove(selectedItem);
        availableToppingsNYStyle.getItems().add(selectedItem);
    }
}
