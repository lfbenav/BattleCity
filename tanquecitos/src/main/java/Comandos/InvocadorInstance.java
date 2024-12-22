/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comandos;

import Tanques.Jugador;
import Ventanas.VentanaJuego;
import java.util.ArrayList;

/**
 *
 * @author wisfer
 */
public class InvocadorInstance {
    private Comando comando;
    private ArrayList<Comando> comandos = new ArrayList<Comando>();
    private static InvocadorInstance 
            invocador;
    public boolean respawnear = false;
    
    
    //public Jugador jugador;
    public VentanaJuego ventana;
    
    private InvocadorInstance(){
    
    }
    
    public static InvocadorInstance getInstance(){
        if (invocador == null)
            invocador = new InvocadorInstance();
        
        return invocador;
    }
    
    public void recibirComando(Comando comando){
        comandos.add(comando);
    }
    
    public void execute(){
        comando.execute(ventana);
    }
    
    public void executeAll(){
        for(Comando comando : comandos){
            if(respawnear)
                break;
            comando.execute(ventana);
        }
        comandos.clear();
    }
    
    public void limpiar(){
        comandos.clear();
    
    }

    public Comando getComando() {
        return comando;
    }

    public void setComando(Comando comando) {
        this.comando = comando;
    }
    
    public VentanaJuego getVentana() {
        return ventana;
    }

    public void setVentana(VentanaJuego ventana) {
        this.ventana = ventana;
    }
    
    
    
}
