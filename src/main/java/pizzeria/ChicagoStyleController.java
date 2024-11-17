package pizzeria;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ChicagoStyleController {
    @FXML
    private ListView<String> availableToppingsChicagoStyle, selectedToppingsChicagoStyle;

    @FXML
    private Button backwardsChicago, forwardsChicago;

    @FXML
    private RadioButton small, medium, large;

    @FXML
    ToggleGroup group = new ToggleGroup();

    @FXML
    ComboBox<String> pizzaType = new ComboBox<String>();

    @FXML
    TextField priceField, crustField;

    PizzaFactory pizzaFactory = new ChicagoPizza();
    Pizza pizza;

    Size size = Size.Small;


    @FXML
    public void initialize() {
        ObservableList<String> listItems = FXCollections.observableArrayList("Sausage", "Pepperoni", "Green Pepper", "Onion", "Mushroom", "BBQ Chicken", "Provolone", "Cheddar", "Beef", "Ham", "Jalapenos", "Olives", "BananaPepper");
        availableToppingsChicagoStyle.setItems(listItems);

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
            availableToppingsChicagoStyle.setItems(listItems);
            selectedToppingsChicagoStyle.getItems().clear();
            if(!pizzaType.getValue().equals("Build Your Own")){
                availableToppingsChicagoStyle.setDisable(true);
                backwardsChicago.setDisable(true);
                forwardsChicago.setDisable(true);
                availableToppingsChicagoStyle.setStyle("-fx-background-color: lightgrey");
                if(pizzaType.getValue().equals("Deluxe")){
                    ObservableList<String> deluxeToppings = FXCollections.observableArrayList("Sausage", "Pepperoni", "Green Pepper", "Onion", "Mushroom");
                    selectedToppingsChicagoStyle.setItems(deluxeToppings);
                    availableToppingsChicagoStyle.getItems().removeAll(deluxeToppings);
                    pizza = pizzaFactory.createDeluxe();
                }
                else if(pizzaType.getValue().equals("Meatzza")){
                    ObservableList<String> meatzzaToppings = FXCollections.observableArrayList("Sausage", "Pepperoni", "Ham", "Beef");
                    availableToppingsChicagoStyle.getItems().removeAll(meatzzaToppings);
                    selectedToppingsChicagoStyle.setItems(meatzzaToppings);
                    pizza = pizzaFactory.createMeatzza();
                }
                else if(pizzaType.getValue().equals("BBQ Chicken")){
                    ObservableList<String> bbqChickenToppings = FXCollections.observableArrayList("BBQ Chicken", "Provolone", "Cheddar", "Green Pepper");
                    selectedToppingsChicagoStyle.setItems(bbqChickenToppings);
                    availableToppingsChicagoStyle.getItems().removeAll(bbqChickenToppings);
                    pizza = pizzaFactory.createBBQChicken();
                }
            }
            else{
                availableToppingsChicagoStyle.setDisable(false);
                backwardsChicago.setDisable(false);
                forwardsChicago.setDisable(false);
                availableToppingsChicagoStyle.setStyle("-fx-background-color: white");
                availableToppingsChicagoStyle.setItems(listItems);
                selectedToppingsChicagoStyle.getItems().clear();
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
            System.out.println(size);
        });
    }

    @FXML
    private void buildPizza(){

        pizza.getToppings().clear();
        for(String topping : selectedToppingsChicagoStyle.getItems()){
            pizza.addTopping(Topping.valueOf(topping.replace(" ", "")));
        }
        pizza.setSize(size);
        priceField.setText(String.valueOf(pizza.price()));
        crustField.setText(pizza.getCrust().name());
    }

    @FXML
    private void onForwards() {
        String selectedItem = availableToppingsChicagoStyle.getSelectionModel().getSelectedItem();
        if(selectedItem != null) {
            selectedToppingsChicagoStyle.getItems().add(selectedItem);
            availableToppingsChicagoStyle.getItems().remove(selectedItem);
            buildPizza();
        }
    }

    @FXML
    private void onBackwards() {
        String selectedItem = selectedToppingsChicagoStyle.getSelectionModel().getSelectedItem();
        if(selectedItem != null) {
            selectedToppingsChicagoStyle.getItems().remove(selectedItem);
            availableToppingsChicagoStyle.getItems().add(selectedItem);
            buildPizza();
        }
    }


}
