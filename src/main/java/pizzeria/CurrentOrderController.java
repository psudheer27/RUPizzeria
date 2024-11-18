package pizzeria;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class CurrentOrderController {

    @FXML
    public ListView<String> orderList;

    private StartingMenuController startingMenuController;



    @FXML
    public void setMainController(StartingMenuController startingMenuController) {
        this.startingMenuController = startingMenuController;
        initializing();
    }

    @FXML
    public void initializing() {
        ObservableList<String> items = FXCollections.observableArrayList();


            for(Pizza pizza : startingMenuController.getPizzas()) {
                items.add(pizza.toString());
            }


        orderList.setItems(items);
    }


}
