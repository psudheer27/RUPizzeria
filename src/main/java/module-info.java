module pizzeria.rupizzeria {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires org.testng;
    requires junit;


    opens pizzeria to javafx.fxml;
    exports pizzeria;
}