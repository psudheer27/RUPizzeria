package pizzeria;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author Pranav Sudheer and Pranav Komarla
 * The main class for the RUPizza application.
 * This class starts the application and displays the starting menu.
 */
public class StartingMenu extends Application {
    @Override

    /**
     * Starts the application and displays the starting menu.
     *
     * @param stage the stage for the application
     * @throws IOException if the FXML file for the starting menu cannot be loaded
     */
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StartingMenu.class.getResource("starting-menu-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("RUPizza");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Launches the application.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch();
    }
}