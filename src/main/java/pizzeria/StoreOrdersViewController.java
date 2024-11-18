package pizzeria;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class StoreOrdersViewController {


    @FXML
    private Label welcomeText;

    private StartingMenuController startingMenuController;

    public void setMainController(StartingMenuController startingMenuController) {
        this.startingMenuController = startingMenuController;
    }



}
