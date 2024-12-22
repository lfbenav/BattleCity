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
public class Spawn extends Bloque{
    
    public Spawn(){
        super();
        setVida(100);
        setPuedenPasarTanques(true);
        setPuedenPasarBalas(true);
        setIndestructible(true);
        
        setIcon(ObtenerRutaSprite.get("tile241.png"));
    }
    
    @Override
    public String getInfo() {
        return "El Spawn.";
    }
    
    @Override
    public String getTipo(){
        return "Spawn";
    }
}
