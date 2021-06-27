/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.espol.proyectoestructuras;

import TDA.DoublyLinkedCircularList;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import javafx.scene.layout.FlowPane;
/**
 * FXML Controller class
 *
 * @author josue
 */
public class PGameController implements Initializable {


    @FXML
    private FlowPane panelCentral;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DoublyLinkedCircularList<Integer> ListaPrincipal = new DoublyLinkedCircularList<>();
        for (int i = 0; i<10;i++){
            ListaPrincipal.addLast(i);
        }
        mostrarLista(ListaPrincipal);
    }    
    
    public void mostrarLista(DoublyLinkedCircularList<Integer> lista){
        panelCentral.getChildren().clear();
//        for(int numero: lista){
//            Label newlbl = new Label(String.valueOf(numero));
//            panelCentral.getChildren().add(newlbl);
//        }        
    }
}
