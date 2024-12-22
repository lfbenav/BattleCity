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
public class Metal extends Bloque{
    
    public Metal(){
        super();
        setVida(100);
        setPuedenPasarTanques(false);
        setPuedenPasarBalas(false);
        setIndestructible(true);
        
        setIcon(ObtenerRutaSprite.get("tile041.png"));
    }

    @Override
    public String getInfo() {
        return "Bloque de Metal.";
    }
    
    @Override
    public String getTipo(){
        return "Metal";
    }
    
}
