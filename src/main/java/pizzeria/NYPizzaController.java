package pizzeria;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.text.DecimalFormat;

/**
 * @author Pranav Sudheer and Pranav Komarla
 * Controller for the New York Style Pizza View.
 * This class handles the user interactions and updates the view accordingly.
 */
public class NYPizzaController {

    @FXML
    private Button addToOrderNY;

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

    @FXML
    ImageView imageView;

    PizzaFactory pizzaFactory = new NYPizza();
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
        addToOrderNY.setDisable(true);

        ObservableList<String> listItems = FXCollections.observableArrayList("Sausage", "Pepperoni", "Green Pepper", "Onion", "Mushroom", "BBQ Chicken", "Provolone", "Cheddar", "Beef", "Ham", "Jalapenos", "Olives", "BananaPepper");
        availableToppingsNYStyle.setItems(listItems);

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
                Image image = new Image(getClass().getResource("/nyDeluxe.jpg").toExternalForm());
                imageView.setPreserveRatio(true);
                imageView.setImage(image);
            }
            else if(pizzaType.getValue().equals("Meatzza")){
                Image image = new Image(getClass().getResource("/nyMeatzza.jpg").toExternalForm());
                imageView.setPreserveRatio(true);
                imageView.setImage(image);
            }
            else if(pizzaType.getValue().equals("BBQ Chicken")){
                Image image = new Image(getClass().getResource("/nyBBQ.jpg").toExternalForm());
                imageView.setPreserveRatio(true);
                imageView.setImage(image);
            }
            else if(pizzaType.getValue().equals("Build Your Own")){
                Image image = new Image(getClass().getResource("/nyBYO.jpg").toExternalForm());
                imageView.setPreserveRatio(true);
                imageView.setImage(image);
            }
        });
    }

    /**
     * Disables the toppings list and navigation buttons.
     */
    private void disableList(){
        backwardsNY.setDisable(true);
        forwardsNY.setDisable(true);
        availableToppingsNYStyle.setDisable(true);
        availableToppingsNYStyle.setStyle("-fx-background-color: lightgrey");
    }

    /**
     * Enables the toppings list and navigation buttons.
     */
    private void enableList(){
        availableToppingsNYStyle.setDisable(false);
        backwardsNY.setDisable(false);
        forwardsNY.setDisable(false);
        availableToppingsNYStyle.setStyle("-fx-background-color: white");
    }

    /**
     * Handles the pizza type selection and updates the view accordingly.
     */
    @FXML
    private void pizzaSelection(){
        pizzaType.setOnAction(e -> {
            ObservableList<String> listItems = FXCollections.observableArrayList("Sausage", "Pepperoni", "Green Pepper", "Onion", "Mushroom", "BBQ Chicken", "Provolone", "Cheddar", "Beef", "Ham", "Jalapenos", "Olives", "BananaPepper");
            availableToppingsNYStyle.setItems(listItems);
            selectedToppingsNYStyle.getItems().clear();
            disableList();

            if(!pizzaType.getValue().equals("Build Your Own")){
                addToOrderNY.setDisable(false);
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
                enableList();
                addToOrderNY.setDisable(false);
                availableToppingsNYStyle.setItems(listItems);
                selectedToppingsNYStyle.getItems().clear();
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
        for(String topping : selectedToppingsNYStyle.getItems()){
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
        String selectedItem = availableToppingsNYStyle.getSelectionModel().getSelectedItem();
        if(selectedItem != null && selectedToppingsNYStyle.getItems().size() < 7) {
            selectedToppingsNYStyle.getItems().add(selectedItem);
            availableToppingsNYStyle.getItems().remove(selectedItem);
            addToOrderNY.setDisable(false);
            buildPizza();
        }
    }

    /**
     * Moves the selected topping from the selected list to the available list.
     */
    @FXML
    private void onBackwards() {
        String selectedItem = selectedToppingsNYStyle.getSelectionModel().getSelectedItem();
        if(selectedItem != null) {
            selectedToppingsNYStyle.getItems().remove(selectedItem);
            availableToppingsNYStyle.getItems().add(selectedItem);

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
