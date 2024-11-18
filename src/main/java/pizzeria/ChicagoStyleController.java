package pizzeria;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.control.TextField;

import javafx.scene.image.ImageView;

import java.text.DecimalFormat;


public class ChicagoStyleController {

    @FXML
    public Button addToOrderChicago;

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
    ImageView imageView;

    @FXML
    TextField priceField, crustField;

    PizzaFactory pizzaFactory = new ChicagoPizza();
    Pizza pizza;

    Size size = Size.Small;

    private StartingMenuController startingMenuController;


    @FXML
    public void initialize() {

        disableList();
        addToOrderChicago.setDisable(true);

        ObservableList<String> listItems = FXCollections.observableArrayList("Sausage", "Pepperoni", "Green Pepper", "Onion", "Mushroom", "BBQ Chicken", "Provolone", "Cheddar", "Beef", "Ham", "Jalapenos", "Olives", "BananaPepper");
        availableToppingsChicagoStyle.setItems(listItems);

        ObservableList<String> pizzaTypes = FXCollections.observableArrayList("Deluxe", "Meatzza", "BBQ Chicken", "Build Your Own");
        pizzaType.setItems(pizzaTypes);


        small.setToggleGroup(group);
        medium.setToggleGroup(group);
        large.setToggleGroup(group);

        small.setSelected(true);



        sizeSelection();
        imageSelection();
        pizzaSelection();
    }

    @FXML
    private void imageSelection(){
        pizzaType.valueProperty().addListener(e -> {
            if(pizzaType.getValue().equals("Deluxe")){
                Image image = new Image(getClass().getResource("/chicagoDeluxe.jpg").toExternalForm());
                imageView.setPreserveRatio(true);
                imageView.setImage(image);
            }
            else if(pizzaType.getValue().equals("Meatzza")){
                Image image = new Image(getClass().getResource("/chicagoMeatzza.jpg").toExternalForm());
                imageView.setPreserveRatio(true);
                imageView.setImage(image);
            }
            else if(pizzaType.getValue().equals("BBQ Chicken")){
                Image image = new Image(getClass().getResource("/chicagoBBQ.jpg").toExternalForm());
                imageView.setPreserveRatio(true);
                imageView.setImage(image);
            }
            else if(pizzaType.getValue().equals("Build Your Own")){
                Image image = new Image(getClass().getResource("/chicagoBYO.jpg").toExternalForm());
                imageView.setPreserveRatio(true);
                imageView.setImage(image);
            }
        });
    }

    private void disableList(){
        backwardsChicago.setDisable(true);
        forwardsChicago.setDisable(true);
        availableToppingsChicagoStyle.setDisable(true);
        availableToppingsChicagoStyle.setStyle("-fx-background-color: lightgrey");
    }

    private void enableList(){
        availableToppingsChicagoStyle.setDisable(false);
        backwardsChicago.setDisable(false);
        forwardsChicago.setDisable(false);
        availableToppingsChicagoStyle.setStyle("-fx-background-color: white");
    }

    @FXML
    private void pizzaSelection(){
        pizzaType.setOnAction(e -> {
            ObservableList<String> listItems = FXCollections.observableArrayList("Sausage", "Pepperoni", "Green Pepper", "Onion", "Mushroom", "BBQ Chicken", "Provolone", "Cheddar", "Beef", "Ham", "Jalapenos", "Olives", "BananaPepper");
            availableToppingsChicagoStyle.setItems(listItems);
            selectedToppingsChicagoStyle.getItems().clear();
            disableList();
            if(!pizzaType.getValue().equals("Build Your Own")){
                addToOrderChicago.setDisable(false);
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
                enableList();
                addToOrderChicago.setDisable(false);
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
        });
    }

    @FXML
    private void buildPizza(){
        pizza.getToppings().clear();
        for(String topping : selectedToppingsChicagoStyle.getItems()){
            pizza.addTopping(Topping.valueOf(topping.replace(" ", "")));
        }
        pizza.setSize(size);
        DecimalFormat df = new DecimalFormat("#.##");
        priceField.setText(String.valueOf(df.format(pizza.price())));
        crustField.setText(pizza.getCrust().name());
    }

    @FXML
    private void onForwards() {
        String selectedItem = availableToppingsChicagoStyle.getSelectionModel().getSelectedItem();
        if(selectedItem != null && selectedToppingsChicagoStyle.getItems().size() < 7) {
            selectedToppingsChicagoStyle.getItems().add(selectedItem);
            availableToppingsChicagoStyle.getItems().remove(selectedItem);
            addToOrderChicago.setDisable(false);
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


    public void setMainController(StartingMenuController startingMenuController) {
        this.startingMenuController = startingMenuController;
    }

    @FXML
    public void onAddToOrder() {
        startingMenuController.addPizza(pizza);
    }


}
