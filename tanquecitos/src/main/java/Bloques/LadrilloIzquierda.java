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
public class LadrilloIzquierda extends Bloque{
    
    public LadrilloIzquierda(){
        super();
        setVida(2);
        setPuedenPasarTanques(false);
        setPuedenPasarBalas(false);
        setIndestructible(false);
        
        setIcon(ObtenerRutaSprite.get("tile019.png"));
    }

    @Override
    public String getInfo() {
        return "Bloque de Ladrillo Izquierdo, Vida: " + getVida() + ".";
    }
    
    @Override
    public String getTipo(){
        return "LadrilloIzquierda";
    }
    
}
