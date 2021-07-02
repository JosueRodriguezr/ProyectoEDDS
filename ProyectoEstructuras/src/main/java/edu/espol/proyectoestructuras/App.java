package edu.espol.proyectoestructuras;

import TDA.DoublyLinkedCircularList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

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
        Scanner sc = new Scanner(System.in);
        launch();
        DoublyLinkedCircularList circuloP = new DoublyLinkedCircularList<>();
        DoublyLinkedCircularList circuloG = new DoublyLinkedCircularList<>();
       
        for(int i=0; i<5;i++){
            Random random = new Random();
            int x= random.nextInt(9);
            if(!circuloG.equals(x)){
                circuloG.addLast(x); 
            }
        }
        
        for(int i=0; i<5;i++){
            Random random = new Random();
            int y= random.nextInt(9);
            if(!circuloP.equals(y)){
                circuloP.addLast(y); 
            }
        }
        int opcion=0;
        int decre=0;
        int apuesta=25;
        int estado=1;
        while(opcion!=4 || estado!=0){
        System.out.println("***************");
            for(int i=0; i<circuloP.size();i++){
                System.out.println("g: "+circuloG.get(i)+" p: "+circuloP.get(i));

            }
        System.out.println("***************");
        System.out.println("1. Giro a la derecha");
        System.out.println("2. Giro a la izquierda");
        System.out.println("3. Eliminar Par");
        System.out.println("4. Salir");
        int partida= endMatch(circuloG,circuloP,apuesta);
        System.out.println("Total Actual: "+partida);
        if(partida==0){
            estado=0;
        }
        int valor=sc.nextInt();
            if(valor==1){
                giroDerecha(circuloG,circuloP);
            }else if(valor==2){
                giroIzquierda(circuloG,circuloP);
            }else if(valor==4){
                opcion=3;
            }else if(valor==3){
                System.out.println("Indice a Eliminar");
                int eliminar=sc.nextInt();
                circuloG.remove(eliminar);
                circuloP.remove(eliminar);
                decre++;
            }
        }
        
    }
    
    
    public static void Operar(String orientacion, DoublyLinkedCircularList lista){
        if("derecha".equals(orientacion)){
            for(int i=0; i<lista.size();i++){
                int valor= (int) lista.get(i);
                valor++;
                lista.set(i,valor);

            }
        }else if("izquierda".equals(orientacion)){
            for(int i=0; i<lista.size();i++){
                int valor= (int) lista.get(i);
                valor--;
                lista.set(i,valor);
                
                
            }
        }
    
    }
    
    public static void giroDerecha(DoublyLinkedCircularList cg,DoublyLinkedCircularList cp){
        cg.moverLista("derecha");
        Operar("derecha",cg);
        cp.moverLista("derecha");
        Operar("derecha",cp);
                
    }
    public static void giroIzquierda(DoublyLinkedCircularList cg,DoublyLinkedCircularList cp){
        cg.moverLista("izquierda");
        Operar("izquierda",cg);
        cp.moverLista("izquierda");
        Operar("izquierda",cp);
                
    }
    
    public static int endMatch(DoublyLinkedCircularList cg,DoublyLinkedCircularList cp,Integer apuesta){
        int total=0;
        for(int i=0; i<cg.size();i++){
                int valorG= (int) cg.get(i);
                int valorP= (int) cp.get(i);
                total+=valorG;
                total+=valorP;
        }
        if(total==apuesta){
            //Gano el juego
            return 1;
        }else if(total<=0){
            // Perdio el juego
            return 0;
        }else{
            // Sigue jugando
            return total;
        }
    }

}
    

