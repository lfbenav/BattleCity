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
public class EsquinaDerecha extends Bloque{
    
    public EsquinaDerecha(){
        super();
        setVida(2);
        setPuedenPasarTanques(false);
        setPuedenPasarBalas(false);
        setIndestructible(false);
        
        setIcon(ObtenerRutaSprite.get("EsquinaDerecha.png"));
    }

    @Override
    public String getInfo() {
        return "Bloque de Esquina Derecha, Vida: " + getVida() + ".";
    }
    
    @Override
    public String getTipo(){
        return "EsquinaDerecha";
    }
    
    
}
