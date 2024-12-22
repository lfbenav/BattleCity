/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bloques;

import Elementos.ObtenerRutaSprite;

/**
 *
 * @author wisfer
 */
public class LadrilloDerecha extends Bloque{
    
    public LadrilloDerecha(){
        super();
        setVida(2);
        setPuedenPasarTanques(false);
        setPuedenPasarBalas(false);
        setIndestructible(false);
        
        setIcon(ObtenerRutaSprite.get("tile017.png"));
    }

    @Override
    public String getInfo() {
        return "Bloque de Ladrillo Derecho, Vida: " + getVida() + ".";
    }
    
    @Override
    public String getTipo(){
        return "LadrilloDerecha";
    }
    
    
}
