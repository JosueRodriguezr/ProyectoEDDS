/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.espol.proyectoestructuras;

import TDA.DoublyLinkedCircularList;
import java.net.URL;
import java.util.Optional;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
/**
 * FXML Controller class
 *
 * @author josue
 */
public class PGameController implements Initializable {


    @FXML
    private Pane panelCentral;
    @FXML
    private ToggleGroup selection;
    @FXML
    private RadioButton optionEliminar;
    @FXML
    private RadioButton optionRotar;
    
    private boolean rotar = false;
    private boolean eliminar = false;
    @FXML
    private GridPane gridPane;
    
    private DoublyLinkedCircularList<DoublyLinkedCircularList> Listacirculos = new DoublyLinkedCircularList<>();
    
    private int v = 1;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Thread t = new Thread(()-> juego(PInicioController.circulosJugar, Listacirculos));
        t.start();
    }    
    
    public void juego(int numeroCirculos, DoublyLinkedCircularList<DoublyLinkedCircularList> listas){
        for(int i=0; i<numeroCirculos;i++){
            DoublyLinkedCircularList<Integer> temp = new DoublyLinkedCircularList<>();
            for(int n=0; n<5;n++){
                Random random = new Random();
                int x= random.nextInt(9);
                if(!temp.equals(x)){
                    temp.addLast(x); 
                    }
            }
            Listacirculos.addLast(temp);
        }
        while(App.isOpen){
            if(rotar == true){
                Platform.runLater(()->gridPane.getChildren().clear());
                Button bIzquierda = new Button("Izquierda");
                Button bDerecha = new Button("Derecha");
                Platform.runLater(()-> {
                    gridPane.add(bIzquierda, 0, 0);
                    gridPane.add(bDerecha, 1, 0);
                    });
                bIzquierda.setOnAction(e -> {
                        Operar("izquierda",listas);     
                        eliminar = true;
                        rotar = false;
                        v=1;
                });
                bDerecha.setOnAction(e -> {
                        Operar("derecha",listas);
                        eliminar = true;
                        rotar = false;
                        v=1;
                });
            }
            if(eliminar == true){
                TextField indiceEliminar = new TextField();
                Button bAceptar = new Button("Eliminar");
                if(v==1){
                    v=0;
                    Platform.runLater(()-> {
                    gridPane.getChildren().clear();
                    gridPane.add(indiceEliminar, 0, 0);
                    gridPane.add(bAceptar, 1, 0);
                    });
                }
                bAceptar.setOnAction(e -> {
                    int indice = Integer.parseInt(indiceEliminar.getText());
                    for (int a = 0; a<listas.size();a++){
                        listas.get(a).remove(indice);
                    }
                    eliminar = false;
                    rotar = true;
                });
                
            }
            Platform.runLater(()-> mostrarLista(Listacirculos));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }    
            
        }
        
    }
    public void mostrarLista(DoublyLinkedCircularList<DoublyLinkedCircularList> listas ){
        panelCentral.getChildren().clear();
        int nLista = 1;
        if(PInicioController.circulosJugar>3){
            for(int i = 0; i<listas.size(); i++){
                int radioNecesario = (radio((listas.get(i).size())-2) * nLista) ;
                crearCirculos(listas.get(i), radioNecesario);
                nLista+=1;
            }
        }else{
            for(int i = 0; i<listas.size(); i++){
                int radioNecesario = (radio(listas.get(i).size()) * nLista) ;
                crearCirculos(listas.get(i), radioNecesario);
                nLista+=1;
            }
        }
               
    }
    
    public void crearCirculos (DoublyLinkedCircularList<Integer> circulo, int radioNecesario){
        double anguloNecesario = angulo (circulo.size());
        double cont = 0;
        Circle c1 = new Circle (600.0, 400.0, radioNecesario);
        c1.setFill (null);
        c1.setStroke(Color.BLACK);
        c1.setLayoutX(90.00);
        c1.setLayoutY(30.00);       
        panelCentral.getChildren().add(c1);
        for(int i=0; i<circulo.size();i++){
            double x = radioNecesario * Math.cos(Math.toRadians(cont)) + 600.0;
            double y = radioNecesario * Math.sin(Math.toRadians(cont)) + 400.0;
            Label numeroAc = new Label(String.valueOf(circulo.get(i)));
            Label indice = new Label(String.valueOf(i));
            indice.setLayoutX(x+100);
            indice.setLayoutY(y);
            indice.setTextFill(Color.RED);
            numeroAc.setLayoutX(x+82);
            numeroAc.setLayoutY(y+12);
            Circle circuloNumero = new Circle (200.0, 200.0, 25);
            circuloNumero.setLayoutX(x-110);
            circuloNumero.setLayoutY(y-170);
            circuloNumero.setFill(Color.GOLD);
            numeroAc.setFont(new Font("Times New Roman Bold", 30));
            indice.setFont(new Font("Arial", 25));
            panelCentral.getChildren().addAll(circuloNumero,numeroAc,indice);
            cont+=anguloNecesario;
        }
    }
    private int radio (int circulo){
        double perimetro = circulo * 15;
        int radio = (int) Math.ceil((perimetro / 2 * Math.PI));
        return radio;
    }
    
    private double angulo (int circulo){
        double angulo = 360 / circulo;
        return angulo;
    }
    
    @FXML
    public void accion(){
        if(selection.getSelectedToggle().equals(optionRotar)){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setTitle("Confirmación");
            alert.setContentText("¿Estas seguro que quieres iniciar rotando?");
            Optional<ButtonType> action = alert.showAndWait();
            if(action.get() == ButtonType.OK){
                rotar = true;
                gridPane.getChildren().clear();
            }
        }else if(selection.getSelectedToggle().equals(optionEliminar)){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setTitle("Confirmación");
            alert.setContentText("¿Estas seguro que quieres iniciar eliminando?");
            Optional<ButtonType> action = alert.showAndWait();
            if(action.get() == ButtonType.OK){
                eliminar = true;
                gridPane.getChildren().clear();
            }
        }
    }
    
    public static void Operar(String orientacion, DoublyLinkedCircularList<DoublyLinkedCircularList> listas ){
        for(int i = 0; i<listas.size(); i++){
            if("derecha".equals(orientacion)){
                listas.get(i).moverLista(orientacion);
                for(int n=0; n<listas.get(i).size();n++){
                    int valor= (int) listas.get(i).get(n);
                    valor++;
                    listas.get(i).set(n,valor);

                }
            }else if("izquierda".equals(orientacion)){
                listas.get(i).moverLista(orientacion);
                for(int n=0; n<listas.get(i).size();n++){
                    int valor= (int) listas.get(i).get(n);
                    valor--;
                    listas.get(i).set(n,valor);
                }
            }
        }
        
    
    }
}
