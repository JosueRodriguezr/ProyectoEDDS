package edu.espol.proyectoestructuras;

import TDA.DoublyLinkedCircularList;
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

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("PInicio"), 1080, 720);
        stage.setScene(scene);
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
        launch();
        DoublyLinkedCircularList prueba = new DoublyLinkedCircularList<>();
        
        prueba.addLast(1);
        prueba.addLast(2);
        prueba.addLast(3);
        prueba.addLast(4);
        prueba.addLast(5);
        
        System.out.println(prueba.isEmpty());
        
        for(int i=0; i<prueba.size();i++){
            System.out.println(prueba.get(i));
        }
        System.out.println("Header:"+prueba.get(0));
        
        prueba.moverLista("derecha");
        
        for(int i=0; i<prueba.size();i++){
            System.out.println(prueba.get(i));
        }
        System.out.println("Header:"+prueba.get(0));
    }

}