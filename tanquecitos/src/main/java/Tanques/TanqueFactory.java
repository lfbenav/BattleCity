/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tanques;

import Elementos.PuntuacionSingleton;

/**
 *
 * @author wisfer
 */

public class TanqueFactory implements TanqueFactoryMethod{

    public static final int SIMPLE = 1;
    public static final int RAPIDO = 2;
    public static final int FUERTE = 3;
    public static final int REFORZADO = 4;
    public static final int JUGADOR = 5;
    public static final int BALA = 6;

    public TanqueFactory(){
    }
    
    @Override
    public Tanque crearTanque(int tipo, boolean especial) 
    {
        switch(tipo)
        {
            case SIMPLE:
                return new Simple(especial);
                
            case RAPIDO:
                return new Rapido(especial);
            
            case FUERTE:
                return new Fuerte(especial);
                
            case REFORZADO:
                return new Reforzado(especial);
             
            case JUGADOR:
                return new Jugador();
            
            default:
                return null;
        
        }
    
    }
    
}
