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

/**
 * Controller for the Chicago Style Pizza View.
 * This class handles the user interactions and updates the view accordingly.
 */
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

    /**
     * Initializes the controller.
     * Sets up the initial state of the view components and binds event listeners.
     */
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

    /**
     * Updates the pizza image based on the selected pizza type.
     */
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

    /**
     * Disables the toppings list and navigation buttons.
     */
    private void disableList(){
        backwardsChicago.setDisable(true);
        forwardsChicago.setDisable(true);
        availableToppingsChicagoStyle.setDisable(true);
        availableToppingsChicagoStyle.setStyle("-fx-background-color: lightgrey");
    }

    /**
     * Enables the toppings list and navigation buttons.
     */
    private void enableList(){
        availableToppingsChicagoStyle.setDisable(false);
        backwardsChicago.setDisable(false);
        forwardsChicago.setDisable(false);
        availableToppingsChicagoStyle.setStyle("-fx-background-color: white");
    }

    /**
     * Handles the pizza type selection and updates the view accordingly.
     */
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

    /**
     * Handles the size selection and updates the pizza size.
     */
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

    /**
     * Builds the pizza based on the selected toppings and size.
     * Updates the price and crust fields in the view.
     */
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

    /**
     * Moves the selected topping from the available list to the selected list.
     */
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

    /**
     * Moves the selected topping from the selected list to the available list.
     */
    @FXML
    private void onBackwards() {
        String selectedItem = selectedToppingsChicagoStyle.getSelectionModel().getSelectedItem();
        if(selectedItem != null) {
            selectedToppingsChicagoStyle.getItems().remove(selectedItem);
            availableToppingsChicagoStyle.getItems().add(selectedItem);

            buildPizza();
        }
    }

    /**
     * Sets the main controller.
     *
     * @param startingMenuController the main controller
     */
    public void setMainController(StartingMenuController startingMenuController) {
        this.startingMenuController = startingMenuController;
    }

    /**
     * Adds the current pizza to the order.
     */
    @FXML
    public void onAddToOrder() {
        startingMenuController.addPizza(pizza);
    }


}
