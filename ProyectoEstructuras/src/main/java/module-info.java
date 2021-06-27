module edu.espol.proyectoestructuras {
    requires javafx.controls;
    requires javafx.fxml;

    opens edu.espol.proyectoestructuras to javafx.fxml;
    exports edu.espol.proyectoestructuras;
}