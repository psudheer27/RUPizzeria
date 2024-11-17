package pizzeria;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.text.DecimalFormat;

public class NYPizzaController {

    @FXML
    private ListView<String> availableToppingsNYStyle, selectedToppingsNYStyle;

    @FXML
    private Button backwardsNY, forwardsNY;

    @FXML
    private RadioButton small, medium, large;

    @FXML
    ToggleGroup group = new ToggleGroup();

    @FXML
    ComboBox<String> pizzaType = new ComboBox<String>();

    @FXML
    TextField priceField, crustField;

    PizzaFactory pizzaFactory = new NYPizza();
    Pizza pizza;

    Size size = Size.Small;

    @FXML
    public void initialize() {
        ObservableList<String> listItems = FXCollections.observableArrayList("Sausage", "Pepperoni", "Green Pepper", "Onion", "Mushroom", "BBQ Chicken", "Provolone", "Cheddar", "Beef", "Ham", "Jalapenos", "Olives", "BananaPepper");
        availableToppingsNYStyle.setItems(listItems);

        ObservableList<String> pizzaTypes = FXCollections.observableArrayList("Deluxe", "Meatzza", "BBQ Chicken", "Build Your Own");
        pizzaType.setItems(pizzaTypes);


        small.setToggleGroup(group);
        medium.setToggleGroup(group);
        large.setToggleGroup(group);

        small.setSelected(true);

        sizeSelection();
        pizzaSelection();
    }

    @FXML
    private void pizzaSelection(){
        pizzaType.setOnAction(e -> {
            ObservableList<String> listItems = FXCollections.observableArrayList("Sausage", "Pepperoni", "Green Pepper", "Onion", "Mushroom", "BBQ Chicken", "Provolone", "Cheddar", "Beef", "Ham", "Jalapenos", "Olives", "BananaPepper");
            availableToppingsNYStyle.setItems(listItems);
            selectedToppingsNYStyle.getItems().clear();
            if(!pizzaType.getValue().equals("Build Your Own")){
                availableToppingsNYStyle.setDisable(true);
                backwardsNY.setDisable(true);
                forwardsNY.setDisable(true);
                availableToppingsNYStyle.setStyle("-fx-background-color: lightgrey");
                if(pizzaType.getValue().equals("Deluxe")){
                    ObservableList<String> deluxeToppings = FXCollections.observableArrayList("Sausage", "Pepperoni", "Green Pepper", "Onion", "Mushroom");
                    selectedToppingsNYStyle.setItems(deluxeToppings);
                    availableToppingsNYStyle.getItems().removeAll(deluxeToppings);
                    pizza = pizzaFactory.createDeluxe();
                }
                else if(pizzaType.getValue().equals("Meatzza")){
                    ObservableList<String> meatzzaToppings = FXCollections.observableArrayList("Sausage", "Pepperoni", "Ham", "Beef");
                    availableToppingsNYStyle.getItems().removeAll(meatzzaToppings);
                    selectedToppingsNYStyle.setItems(meatzzaToppings);
                    pizza = pizzaFactory.createMeatzza();
                }
                else if(pizzaType.getValue().equals("BBQ Chicken")){
                    ObservableList<String> bbqChickenToppings = FXCollections.observableArrayList("BBQ Chicken", "Provolone", "Cheddar", "Green Pepper");
                    selectedToppingsNYStyle.setItems(bbqChickenToppings);
                    availableToppingsNYStyle.getItems().removeAll(bbqChickenToppings);
                    pizza = pizzaFactory.createBBQChicken();
                }
            }
            else{
                availableToppingsNYStyle.setDisable(false);
                backwardsNY.setDisable(false);
                forwardsNY.setDisable(false);
                availableToppingsNYStyle.setStyle("-fx-background-color: white");
                availableToppingsNYStyle.setItems(listItems);
                selectedToppingsNYStyle.getItems().clear();
                pizza = pizzaFactory.createBuildYourOwn();
            }
            buildPizza();
        });
    }

    @FXML
    private void sizeSelection(){
        group.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            RadioButton selectedRadioButton = (RadioButton) newValue;
            if(selectedRadioButton != null){
                if(selectedRadioButton.getText().equals("Small")){
                    size = Size.Small;
                }
                else if(selectedRadioButton.getText().equals("Medium")){
                    size = Size.Medium;
                }
                else if(selectedRadioButton.getText().equals("Large")){
                    size = Size.Large;
                }
            }
            buildPizza();
        });
    }

    @FXML
    private void buildPizza(){

        pizza.getToppings().clear();
        for(String topping : selectedToppingsNYStyle.getItems()){
            pizza.addTopping(Topping.valueOf(topping.replace(" ", "")));
        }
        pizza.setSize(size);
        DecimalFormat df = new DecimalFormat("#.##");
        priceField.setText(String.valueOf(df.format(pizza.price())));
        crustField.setText(pizza.getCrust().name());
    }

    @FXML
    private void onForwards() {
        String selectedItem = availableToppingsNYStyle.getSelectionModel().getSelectedItem();
        if(selectedItem != null && selectedToppingsNYStyle.getItems().size() < 7) {
            selectedToppingsNYStyle.getItems().add(selectedItem);
            availableToppingsNYStyle.getItems().remove(selectedItem);
            buildPizza();
        }
    }

    @FXML
    private void onBackwards() {
        String selectedItem = selectedToppingsNYStyle.getSelectionModel().getSelectedItem();
        if(selectedItem != null) {
            selectedToppingsNYStyle.getItems().remove(selectedItem);
            availableToppingsNYStyle.getItems().add(selectedItem);
            buildPizza();
        }
    }
}
