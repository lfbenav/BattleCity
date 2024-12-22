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
public class Hojas extends Bloque{
    
    public Hojas(){
        super();
        setVida(100);
        setPuedenPasarTanques(true);
        setPuedenPasarBalas(true);
        setIndestructible(true);
        
        setIcon(ObtenerRutaSprite.get("tile067.png"));
    }
    
    @Override
    public String getInfo() {
        return "Bloque de Hojas.";
    }
    
    @Override
    public String getTipo(){
        return "Hojas";
    }
}
