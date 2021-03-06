/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.espol.proyectoestructuras;

import Personaje.Jugador;
import TDA.DoublyLinkedCircularList;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author josue
 */
public class PLogInController implements Initializable {

    @FXML
    private TextField txtUserName;
    @FXML
    private PasswordField txtPassword;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
    @FXML
    public void sceneRegistro() throws IOException{
        App.setRoot("PRegistro");
    }
    
    public void sceneInicio() throws IOException{
        DoublyLinkedCircularList<Jugador> jugadores = Jugador.jugadoresRegistrados;
        for(int i =0; i<jugadores.size(); i++){
            if(jugadores.get(i).getUsuario().equals(txtUserName.getText()) && jugadores.get(i).getPassword().equals(txtPassword.getText())){
                App.jugadorAc =jugadores.get(i);
                App.setRoot("PInicio");
                return;
            }
        }
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText(null);
        alert.setTitle("Informacion Incorrecta");
        alert.setContentText("El usuario o la contraseña ingresada no es correcta");
        alert.showAndWait();
    }
}
    
    

