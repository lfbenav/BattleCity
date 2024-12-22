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
public class ThreadComodinCasco extends Thread{
    
    VentanaJuego ventana;
    Tanque jugador;
    int tiempo;

    public ThreadComodinCasco(VentanaJuego ventana, Tanque jugador, int segundos) {
        this.ventana = ventana;
        this.jugador = jugador;
        this.tiempo = segundos;
    }
    
    @Override
    public void run(){
        
        ventana.lblInmune.setVisible(true);
        ventana.lblInmune.setText("IMMUNE");
        jugador.setVida(100);
        
        try {
            Thread.sleep(tiempo*1000);
        } catch (InterruptedException ex) {}
        
        ventana.lblInmune.setText("");
        
        jugador.setVida(1);
        System.out.println("Se acabo el efecto del Casco");
        
    }
}
