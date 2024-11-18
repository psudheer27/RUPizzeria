module pizzeria.rupizzeria {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens pizzeria to javafx.fxml;
    exports pizzeria;
}