/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bloques;

import Elementos.ObtenerRutaSprite;
import Ventanas.VentanaJuego;

/**
 *
 * @author wisfer
 */
public class Estatua extends Bloque{
    
    public Estatua(){
        super();
        setVida(1);
        setPuedenPasarTanques(false);
        setPuedenPasarBalas(false);
        setIndestructible(false);
        
        setIcon(ObtenerRutaSprite.get("tile069.png"));
    }
    
    @Override
    public String getInfo() {
        return "La Estatua.";
    }
    
    @Override
    public String getTipo(){
        return "Estatua";
    }
    
    @Override
    public void recibirDano(VentanaJuego ventana){
        setVida(getVida()-1);
        if(getVida()<=0){
            ventana.pnlJuego.revalidate();
            setIcon(ObtenerRutaSprite.get("tile070.png"));
            try {
                Thread.sleep(2);
            } catch (InterruptedException ex) {}
            ventana.pnlJuego.revalidate();
            
            System.out.println("Estatua destruida");
            ventana.vidas = -1;
            ventana.getJugador().setVida(1);
            ventana.getJugador().recibirDano(ventana);
        }
    
    }
}
