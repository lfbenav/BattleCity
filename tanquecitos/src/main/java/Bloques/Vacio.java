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
public class Vacio extends Bloque{
    
    public Vacio(){
        super();
        setVida(-1);
        setPuedenPasarTanques(false);
        setPuedenPasarBalas(false);
        setIndestructible(false);
        
        setIcon(ObtenerRutaSprite.get("error.jpeg"));
    }
    
    @Override
    public String getInfo() {
        return "Bloque de Nada.";
    }
    
    @Override
    public String getTipo(){
        return "Vacio";
    }
}
