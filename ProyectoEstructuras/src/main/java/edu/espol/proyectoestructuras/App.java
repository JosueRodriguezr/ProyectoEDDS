package edu.espol.proyectoestructuras;

import Personaje.Jugador;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    public static boolean isOpen = true;
    public static Jugador jugadorAc;
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("PLogIn"), 1800, 900);
        stage.setScene(scene);
        stage.setOnCloseRequest(e -> isOpen=false);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        Jugador.deserializar();
        launch();
        Jugador.serializar();
    }
}