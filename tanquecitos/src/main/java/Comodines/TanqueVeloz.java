/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comodines;

import Elementos.ObtenerRutaSprite;
import Tanques.Tanque;
import Threads.ThreadComodinReloj;
import Threads.ThreadComodinVelocidad;
import Ventanas.VentanaJuego;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wisfer
 */
public class TanqueVeloz extends Comodin{

    public TanqueVeloz(){
        super();
        System.out.println("Un comodin de tipo "+getTipo()+" aparecio");
        setIcon(ObtenerRutaSprite.get("tile196.png"));
    }
    
    @Override
    public void efecto(Tanque jugador, VentanaJuego ventana) {
        recogido = true;
        setIcon(ObtenerRutaSprite.get("tile021.png"));
        ventana.sumarComodin();
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {}
        ventana.comodinesEnJuego.remove(this);
        ventana.pnlJuego.remove(label);

        ThreadComodinVelocidad threadVelocidad = new ThreadComodinVelocidad(ventana, jugador);
        threadVelocidad.start();
        
        
        System.out.println("El jugador recoge un comodin de tipo "+getTipo());
    }
    
    @Override
    public String getTipo() {
        return "Tanque Veloz";
    }


    @Override
    public void desaparecer(VentanaJuego ventana) {
        recogido = true;
        setIcon(ObtenerRutaSprite.get("tile021.png"));
        ventana.comodinesEnJuego.remove(this);
        ventana.pnlJuego.remove(label);
        System.out.println("Un comodin de tipo "+getTipo()+" desaparecio");
    }
    
}
