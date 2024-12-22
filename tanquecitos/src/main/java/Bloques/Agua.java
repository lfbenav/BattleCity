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
public class Agua extends Bloque{
    
    public Agua(){
        super();
        setVida(100);
        setPuedenPasarTanques(false);
        setPuedenPasarBalas(true);
        setIndestructible(true);
        
        setIcon(ObtenerRutaSprite.get("tile092.png"));
    }
    
    @Override
    public String getInfo() {
        return "Bloque de Agua.";
    }
    
    @Override
    public String getTipo(){
        return "Agua";
    }
}
