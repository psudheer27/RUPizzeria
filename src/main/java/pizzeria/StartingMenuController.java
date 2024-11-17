package pizzeria;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class StartingMenuController {




    @FXML
    public Button chicagoStyleButton, nyStyleButton, ordersPlacedButton, currentOrderButton;


    @FXML
    private void openChicagoStyle() throws IOException {
//        FXMLLoader loader = new FXMLLoader(getClass().getResource(".fxml"));
//
//        Stage stage = new Stage();
//        stage.setScene(new Scene(loader.load()));
//
//        stage.setTitle("Scene 2");
//
//        stage.show();

    }
    @FXML
    private void openNYStyle() {

    }
    @FXML
    private void openOrdersPlaced() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("store-orders-view.fxml"));

        Stage stage = new Stage();
        stage.setScene(new Scene(loader.load()));

        stage.setTitle("Orders Placed");

        stage.show();
    }
    @FXML
    private void openCurrentOrder() {

    }
}
