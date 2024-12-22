/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Threads;

import Comodines.Comodin;
import Ventanas.VentanaJuego;

/**
 *
 * @author wisfer
 */
public class ThreadComodinDesaparecer extends Thread{
    
    VentanaJuego ventana;
    Comodin comodin;

    public ThreadComodinDesaparecer(VentanaJuego ventana, Comodin comodin) {
        this.ventana = ventana;
        this.comodin = comodin;
    }
    
    @Override
    public void run(){

        try {
            Thread.sleep(25000);
        } catch (InterruptedException ex) {}
        
        if(!comodin.recogido)
            comodin.desaparecer(ventana);
        
    }
}
