package pizzeria;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class StoreOrdersViewController {


    @FXML
    public ComboBox<String> orderNumberComboBox;
    public TextField orderTotalField;

    @FXML
    public ListView<Pizza> orderListView;

    private ObservableList<Pizza> items;
    private StartingMenuController startingMenuController;

    public void setMainController(StartingMenuController startingMenuController) {
        this.startingMenuController = startingMenuController;
        initializing();

    }

    public void initializing() {


        System.out.println(startingMenuController.getOrders().size());

        for(Order order : startingMenuController.getOrders()) {
            orderNumberComboBox.getItems().add("" + order.getNumber());
        }

        orderNumberComboBox.setOnAction(event -> {
            // Get the selected item from the ComboBox
            String selectedItem = orderNumberComboBox.getValue();
            System.out.println("SELECTED ITEM: " + selectedItem);
            System.out.println(startingMenuController.getOrders().get(0).getPizza());

            // Loop through orders and find the matching one
            for (Order order : startingMenuController.getOrders()) {

                if (("" + order.getNumber()).equals(selectedItem)) {
                    System.out.println("Matches");

                    // Get the list of pizzas for the selected order
                    items = FXCollections.observableArrayList(order.getPizza());

                    // Check if items is populated correctly
                    System.out.println("Items: " + items);

                    // Set the items to the ListView
                    orderListView.setItems(null); // Clear the ListView
                    orderListView.setItems(items); // Set the new items

                    break;
                }
            }
        });

    }

    private void onOrderNumber() {

    }



}
