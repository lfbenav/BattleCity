/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Threads;

import Ventanas.VentanaResumen;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wisfer
 */
public class ThreadAnimacionResultados extends Thread{
    
    VentanaResumen ventana;

    public ThreadAnimacionResultados(VentanaResumen ventana) {
        this.ventana = ventana;
    }
    
    public void run(){

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {}
        
        ventana.revelar1();
        ventana.revelar2();
        ventana.revelar3();
        ventana.revelar4();
        ventana.revelar5();
        
        ventana.esperando = false;

    
    }
}
