module edu.espol.proyectoestructuras {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens edu.espol.proyectoestructuras to javafx.fxml;
    exports edu.espol.proyectoestructuras;
}