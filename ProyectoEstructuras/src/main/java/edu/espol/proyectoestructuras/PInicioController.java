/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.espol.proyectoestructuras;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author josue
 */
public class PInicioController implements Initializable {

    @FXML
    private Button button_scoreboard;
    @FXML
    private TextField txt_nombre;
    @FXML
    private TextField txtCircles;
    
    public static int circulosJugar = 0;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void scenePlay() throws IOException{
        if(!txtCircles.getText().equals("")){
            circulosJugar = Integer.parseInt(txtCircles.getText());
            App.setRoot("PGame");
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setTitle("Informacion Insuficiente");
            alert.setContentText("Debe seleccionar escribir el numero de circulos con los que desea inciar");
            alert.showAndWait();
        }        
    }
}
