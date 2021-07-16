/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personaje;

/**
 *
 * @author Joao
 */
public class Jugador {
    private String nombre;
    private String usuario;
    private int password;
    private String email;
    private int partidasG;
    private int partidasT;

    public Jugador(String nombre, String usuario, int password, String email) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.password = password;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPartidasG() {
        return partidasG;
    }

    public void setPartidasG(int partidasG) {
        this.partidasG = partidasG;
    }

    public int getPartidasT() {
        return partidasT;
    }

    public void setPartidasT(int partidasP) {
        this.partidasT = partidasP;
    }

    public float estadistica(int totales, int ganadas){
        return totales/ganadas;
    
    }
    
}
