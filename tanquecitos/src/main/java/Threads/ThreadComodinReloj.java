/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Threads;

import Ventanas.VentanaJuego;

/**
 *
 * @author wisfer
 */
public class ThreadComodinReloj extends Thread{
    
    VentanaJuego ventana;

    public ThreadComodinReloj(VentanaJuego ventana) {
        this.ventana = ventana;
    }
    
    @Override
    public void run(){
        
        ventana.threadMoverTanques.pausar();
        
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {}
        
        ventana.threadMoverTanques.desPausar();   
        System.out.println("Se acabo el efecto del Reloj");
        
    }
}
