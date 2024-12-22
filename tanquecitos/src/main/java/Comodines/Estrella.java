/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comodines;

import static Comodines.Comodin.SIZE;
import Elementos.ObtenerRutaSprite;
import Tanques.Tanque;
import Threads.ThreadComodinEstrella;
import Threads.ThreadComodinReloj;
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
public class Estrella extends Comodin{

    public Estrella(){
        super();
        System.out.println("Un comodin de tipo "+getTipo()+" aparecio");
        setIcon(ObtenerRutaSprite.get("tile194.png"));
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

        
        ThreadComodinEstrella threadEstrella = new ThreadComodinEstrella(ventana, jugador);
        threadEstrella.start();
        
        System.out.println("El jugador recoge un comodin de tipo "+getTipo());
    }
    
    @Override
    public String getTipo() {
        return "Estrella";
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