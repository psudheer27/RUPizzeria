package pizzeria;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

/**
 * Controller for the Store Orders View.
 * This class handles the user interactions and updates the view accordingly.
 * @author Pranav Sudheer and Pranav Komarla
 */
public class StoreOrdersViewController {

    @FXML
    private ComboBox<String> orderNumberComboBox;

    @FXML
    private TextField orderTotalField;

    @FXML
    private Button cancelOrderButton, exportOrdersButton;

    @FXML
    private ListView<Pizza> orderListView;

    private ObservableList<Pizza> items;
    private StartingMenuController startingMenuController;

    /**
     * Sets the main controller.
     * Initializes the store orders view with the main controller's data.
     *
     * @param startingMenuController the main controller
     */
    public void setMainController(StartingMenuController startingMenuController) {
        this.startingMenuController = startingMenuController;
        cancelOrderButton.setDisable(true);
        exportOrdersButton.setDisable(true);
        cancelOrder();
        exportOrder();
        initializing();

    }


    /**
     * Initializes the store orders view.
     * Populates the order number combo box and sets up event listeners.
     */
    public void initializing() {
        for(Order order : startingMenuController.getOrders()) {
            orderNumberComboBox.getItems().add("" + order.getNumber());
        }
        orderNumberComboBox.setOnAction(event -> {
            String selectedItem = orderNumberComboBox.getValue();
            for (Order order : startingMenuController.getOrders()) {
                if (("" + order.getNumber()).equals(selectedItem)) {
                    items = FXCollections.observableArrayList(order.getPizza());
                    orderListView.setItems(null);
                    orderListView.setItems(items);
                    double overallPrice = 0;
                    for(int i = 0; i < order.getPizza().size(); i++){
                        overallPrice += order.getPizza().get(i).price();
                    }
                    overallPrice += overallPrice * 0.06625;
                    DecimalFormat df = new DecimalFormat("#.##");
                    orderTotalField.setText("$" + df.format(overallPrice));
                    break;
                }
            }
        });

    }

    /**
     * Cancels the selected order.
     * Removes the order from the list and updates the view.
     */
    @FXML
    private void cancelOrder(){
        orderNumberComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue != null){
                cancelOrderButton.setDisable(false);
            }
            else{
                cancelOrderButton.setDisable(true);
            }
            if(orderNumberComboBox.getItems().isEmpty()){
                exportOrdersButton.setDisable(true);
            }
            else{
                exportOrdersButton.setDisable(false);
            }
        });
        cancelOrderButton.setOnAction(event -> {
            if(orderNumberComboBox.getValue() != null) {
                String selectedItem = orderNumberComboBox.getValue();
                for (Order order : startingMenuController.getOrders()) {
                    if (("" + order.getNumber()).equals(selectedItem)) {
                        startingMenuController.removeOrder(order);
                        orderNumberComboBox.getItems().remove(selectedItem);
                        orderNumberComboBox.setValue(null);
                        orderListView.setItems(null);
                        break;
                    }
                }
                orderTotalField.setText("");
            }
        });
    }

    /**
     * Exports the orders to a text file.
     * Prompts the user to choose a file location and writes the order details to the file.
     */
    private void exportOrder() {
        exportOrdersButton.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Order List");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("OrderList", "*.txt"));
            File file = fileChooser.showSaveDialog(null);
            if (file != null) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                    for (int i = 0; i < startingMenuController.getOrders().size(); i++) {
                        writer.write("Order Number: " + startingMenuController.getOrders().get(i).getNumber());
                        writer.newLine();
                        double overallPrice = 0;
                        for(int j = 0; j < startingMenuController.getOrders().get(i).getPizza().size(); j++){
                            writer.write("Pizza " + (j + 1) + ":");
                            writer.newLine();
                            for (String line : startingMenuController.getOrders().get(i).getPizza().get(j).toString().split("\n")) {
                                overallPrice += startingMenuController.getOrders().get(i).getPizza().get(j).price();
                                writer.write(line);
                                writer.newLine();
                            }
                        }
                        overallPrice += overallPrice * 0.06625;
                        DecimalFormat df = new DecimalFormat("#.##");
                        writer.write("Order Total (tax included): $" + df.format(overallPrice));
                        writer.newLine();
                    }

                } catch (IOException e) {
                    throw new RuntimeException("Error writing to file", e);
                }
            }
        });
    }



}
