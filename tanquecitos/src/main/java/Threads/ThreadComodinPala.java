/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Threads;

import Elementos.ObtenerRutaSprite;
import Ventanas.VentanaJuego;

/**
 *
 * @author wisfer
 */
public class ThreadComodinPala extends Thread{
    
    VentanaJuego ventana;

    public ThreadComodinPala(VentanaJuego ventana) {
        this.ventana = ventana;
    }
    
    @Override
    public void run(){

        ventana.estatua.setVida(100);
        ventana.estatua.setIcon(ObtenerRutaSprite.get("EstatuaMetal.png"));
        
        try {
            Thread.sleep(20000);
        } catch (InterruptedException ex) {}
        
        ventana.estatua.setIcon(ObtenerRutaSprite.get("tile069.png"));
        ventana.estatua.setVida(1);     
        System.out.println("Se acabo el efecto de la Pala");
        
    }
}
