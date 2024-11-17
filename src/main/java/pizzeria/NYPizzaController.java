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
    private ListView<String> availableToppings, selectedToppings;
    private Button backwards, forwards;

    @FXML
    public void initialize() {
        ObservableList<String> listItems = FXCollections.observableArrayList("Sausage", "Pepperoni", "GreenPepper", "Onion", "Mushroom", "BBQChicken", "Provolone", "Cheddar", "Beef", "Ham", "Jalapenos", "Olives", "BananaPepper");
        availableToppings = new ListView<>(listItems);
    }


    @FXML
    private void onForwards() {
        String selectedItem = availableToppings.getSelectionModel().getSelectedItem();
        selectedToppings.getItems().add(selectedItem);
    }

    @FXML
    private void onBackwards() {

    }
}
