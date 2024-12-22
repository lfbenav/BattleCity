/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comodines;

import static Comodines.Comodin.SIZE;
import Elementos.ObtenerRutaSprite;
import Tanques.Tanque;
import Threads.ThreadComodinReloj;
import Ventanas.VentanaJuego;
import java.awt.Point;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wisfer
 */
public class Bomba extends Comodin{

    public Bomba(){
        super();
        System.out.println("Un comodin de tipo "+getTipo()+" aparecio");
        setIcon(ObtenerRutaSprite.get("tile195.png"));
    }
    
    @Override
    public void efecto(Tanque jugador, VentanaJuego ventana) {
        System.out.println("El jugador recoge un comodin de tipo "+getTipo());
        recogido = true;
        setIcon(ObtenerRutaSprite.get("tile021.png"));
        ventana.sumarComodin();
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {}
        ventana.comodinesEnJuego.remove(this);
        ventana.pnlJuego.remove(label);

        
        
        try{

            while(!ventana.tanques.isEmpty()){
                Tanque tanque = ventana.tanques.get(0);

                if(tanque.getVida()==0){

                }
                if(tanque.getVida()==1){
                    tanque.recibirDano(ventana);
                }
                if(tanque.getVida()==2){
                    tanque.recibirDano(ventana);
                    tanque.recibirDano(ventana);
                }
                if(tanque.getVida()==3){
                    tanque.recibirDano(ventana);
                    tanque.recibirDano(ventana);
                    tanque.recibirDano(ventana);
                    
                }
                
 
            }
            
            
        }catch(ConcurrentModificationException ex){System.out.println("hubo un error ayuda");}
        
        
        
    }
    
    @Override
    public String getTipo() {
        return "Bomba";
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
