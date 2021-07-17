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
public class PRegistroController implements Initializable {

    @FXML
    private PasswordField txtPassword;
    @FXML
    private TextField txtCorreo;
    @FXML
    private TextField txtUsuario;
    @FXML
    private TextField txtNombre;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void sceneLogIn() throws IOException {
        App.setRoot("PLogIn");
    }
    
    public void validarRegistro() throws IOException{
        DoublyLinkedCircularList<Jugador> jugadores = Jugador.jugadoresRegistrados;
        int veces = jugadores.size();
        for(int i =0; i<veces; i++){
            if(jugadores.get(i).getUsuario().equals(txtUsuario.getText())){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setTitle("Informacion Invalida");
                alert.setContentText("El usuario ya se encuentra registrado");
                alert.showAndWait();
                return;
            }
        }
        Registro();
        
    }
    
    public void Registro() throws IOException{
        System.out.println("registrando");
        if(!txtNombre.getText().equals("") && !txtUsuario.getText().equals("") && !txtPassword.getText().equals("") && !txtCorreo.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setTitle("Registro Completo");
            alert.setContentText("Se ha registrado correctamente");
            alert.showAndWait();
            Jugador nuevo = new Jugador(txtNombre.getText(), txtUsuario.getText(), txtPassword.getText(), txtCorreo.getText());
            Jugador.jugadoresRegistrados.addLast(nuevo);
            App.setRoot("PLogIn");
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setTitle("Informacion Invalida");
            alert.setContentText("Datos insuficientes");
            alert.showAndWait();
        }
    }
    
}
