/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Threads;

import Comandos.*;
import Elementos.ConfiguracionSingleton;
import Elementos.ObtenerRutaSprite;
import Tanques.Jugador;
import Tanques.Tanque;
import Ventanas.VentanaJuego;
import java.util.ConcurrentModificationException;

/**
 *
 * @author wisfer
 */
public class ThreadTanque extends Thread{
    
    Tanque tanque;
    VentanaJuego ventana;
    InvocadorInstance invocador = InvocadorInstance.getInstance();
    ConfiguracionSingleton config = ConfiguracionSingleton.getInstance();
    double velocidadMovimiento = config.getVelocidadMovimiento();
    public boolean isRunning;

    public ThreadTanque(Tanque tanque, VentanaJuego ventana) {
        this.tanque = tanque;
        this.ventana = ventana;
        this.isRunning = true;
        
        //invocador.setVentana(ventana);
        
    }
    
    
    
    @Override
    public void run(){
        
        while(isRunning){
            try {
                Thread.sleep(100);
                
                if(tanque.isEspecial()){
                    switch(tanque.direccion){
                        case Tanque.ARRIBA:
                            tanque.setIcon(tanque.getTexturaEspecialArriba());
                            break;
                        case Tanque.ABAJO:
                            tanque.setIcon(tanque.getTexturaEspecialAbajo());
                            break;        
                        case Tanque.IZQUIERDA:
                            tanque.setIcon(tanque.getTexturaEspecialIzquierda());
                            break;
                        case Tanque.DERECHA:
                            tanque.setIcon(tanque.getTexturaEspecialDerecha());
                            break;
                        default:
                            break;
                    }
                }
                
                
                
                
                
            } catch (InterruptedException | ConcurrentModificationException ex) {
            }
        }
    }
    
}
