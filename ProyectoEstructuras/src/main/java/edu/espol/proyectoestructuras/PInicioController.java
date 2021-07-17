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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

/**
 * FXML Controller class
 *
 * @author josue
 */
public class PInicioController implements Initializable {
    @FXML
    private TextField txtCircles;
    @FXML
    private Label labelInformacion;
    @FXML
    private TextField txtApuesta;
    
    public static int circulosJugar = 0;
    
    public static int apuesta = 0;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        labelInformacion.setText("Bienvenido "+App.jugadorAc.getUsuario());
        labelInformacion.setFont(new Font("Times New Roman Bold", 40));
    }    
    
    @FXML
    public void scenePlay() throws IOException{
        if(!txtCircles.getText().equals("") && !txtApuesta.getText().equals("")){
            circulosJugar = Integer.parseInt(txtCircles.getText());
            apuesta = Integer.parseInt(txtApuesta.getText());
            App.setRoot("PGame");
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setTitle("Informacion Insuficiente");
            alert.setContentText("Debe seleccionar escribir el numero de circulos con los que desea inciar");
            alert.showAndWait();
        }        
    }
    
    public void sceneBack() throws IOException{
        App.setRoot("PLogIn");
    }
}
