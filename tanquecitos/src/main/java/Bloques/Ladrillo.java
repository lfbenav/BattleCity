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
public class Ladrillo extends Bloque{
    
    public Ladrillo(){
        super();
        setVida(3);                                                         //POR DEFECTO ES 4
        setPuedenPasarTanques(false);
        setPuedenPasarBalas(false);
        setIndestructible(false);
        
        setIcon(ObtenerRutaSprite.get("tile016.png"));
    }

    @Override
    public String getInfo() {
        return "Bloque de Ladrillo, Vida: " + getVida() + ".";
    }
    
    @Override
    public String getTipo(){
        return "Ladrillo";
    }
    
}
