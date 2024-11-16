module pizzeria.rupizzeria {
    requires javafx.controls;
    requires javafx.fxml;


    opens pizzeria to javafx.fxml;
    exports pizzeria;
}