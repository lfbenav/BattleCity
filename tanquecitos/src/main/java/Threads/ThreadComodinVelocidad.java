/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Threads;

import Elementos.ObtenerRutaSprite;
import Tanques.Tanque;
import Ventanas.VentanaJuego;

/**
 *
 * @author wisfer
 */
public class ThreadComodinVelocidad extends Thread{
    
    VentanaJuego ventana;
    Tanque jugador;

    public ThreadComodinVelocidad(VentanaJuego ventana, Tanque jugador) {
        this.ventana = ventana;
        this.jugador = jugador;
    }
    
    @Override
    public void run(){

        int original = (int) jugador.getVelocidadMovimiento();
        jugador.setVelocidadMovimiento(original+3.5);
        
        try {
            Thread.sleep(15000);
        } catch (InterruptedException ex) {}
        
        jugador.setVelocidadMovimiento(original);  
        System.out.println("Se acabo el efecto del Tanque Veloz");
        
    }
}
