/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Threads;

import Comandos.InvocadorInstance;
import Elementos.ConfiguracionSingleton;
import Elementos.ObtenerRutaSprite;
import Tanques.Jugador;
import Tanques.Tanque;
import Ventanas.VentanaJuego;
import java.util.ConcurrentModificationException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wisfer
 */
public class ThreadJugador extends Thread{
    
    Tanque jugador;
    VentanaJuego ventana;
    InvocadorInstance invocador = InvocadorInstance.getInstance();
    ConfiguracionSingleton config = ConfiguracionSingleton.getInstance();
    double velocidadMovimiento = config.getVelocidadMovimiento();
    boolean isRunning;
    public boolean respawnear = false;
    //public boolean gameOver = false;

    public ThreadJugador(Jugador jugador, VentanaJuego ventana) {
        this.jugador = jugador;
        this.ventana = ventana;
        this.isRunning = true;
        
        //invocador.setJugador(jugador);
        invocador.setVentana(ventana);
        
    }
    
    
    
    @Override
    public void run(){
        
        while(isRunning){
            try {
                
                ventana.spawnearJugador();
                this.jugador = ventana.getJugador();
                jugador.setIcon(ObtenerRutaSprite.get("tile166.png"));
                Thread.sleep(300);
                jugador.setIcon(ObtenerRutaSprite.get("tile167.png"));
                Thread.sleep(200);
                jugador.setIcon(ObtenerRutaSprite.get("tile168.png"));
                Thread.sleep(200);
                jugador.setIcon(ObtenerRutaSprite.get("tile169.png"));
                Thread.sleep(250);
                jugador.setIcon(ObtenerRutaSprite.get("tile168.png"));
                Thread.sleep(200);
                jugador.setIcon(ObtenerRutaSprite.get("tile166.png"));
                Thread.sleep(200);
                jugador.setIcon(ObtenerRutaSprite.get("tile166.png"));
                Thread.sleep(200);
                jugador.setIcon(ObtenerRutaSprite.get("tile167.png"));
                Thread.sleep(200);
                jugador.setIcon(ObtenerRutaSprite.get("tile168.png"));
                Thread.sleep(200);
                jugador.setIcon(ObtenerRutaSprite.get("tile169.png"));
                Thread.sleep(200);
                jugador.setIcon(jugador.getTexturaPrincipalArriba1());
                Thread.sleep(100);

                //quitar si molesta mucho
                ThreadComodinCasco threadCasco = new ThreadComodinCasco(ventana, jugador, 2);
                threadCasco.start();
  

                invocador.limpiar();
                invocador.respawnear = false;
                respawnear = false;
                
            } catch (InterruptedException ex) {}
            
            while(isRunning){
                try {
                    //System.out.println("?");
                    if(respawnear)
                        break;
                    Thread.sleep((long)velocidadMovimiento);
                    invocador.executeAll();
                } catch (InterruptedException | ConcurrentModificationException ex) {
                    //System.out.println("ErrorEnJugador");
                    invocador.limpiar();
                }
            }



        }
        //System.out.println("terminado");
        
    }
    
    public void detener(){
        
        isRunning = false;

    }
}
