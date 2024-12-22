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
public class BloqueFactory implements BloqueFactoryMethod{
    
    public static final int HOJAS = 1;
    public static final int AGUA = 2;
    public static final int LADRILLOS_ENTEROS = 3;
    public static final int METAL_ENTERO = 4;
    public static final int LADRILLOS_IZQUIERDOS = 5;
    public static final int LADRILLOS_DERECHOS = 6;
    public static final int LADRILLOS_HORIZONTALES = 7;
    public static final int ESTATUA = 8;
    public static final int SPAWN = 9;
    public static final int ESQUINA_DERECHA = 10;
    public static final int ESQUINA_IZQUIERDA = 11;
    
    public BloqueFactory(){
    }

    @Override
    public Bloque crearBloque(int tipo) 
    {
        
        switch(tipo)
        {
            case HOJAS:
                return new Hojas();
                
            case AGUA:
                return new Agua();
                
            case LADRILLOS_ENTEROS:
                return new Ladrillo();
                
            case METAL_ENTERO:
                return new Metal();
                
            case LADRILLOS_IZQUIERDOS:
                return new LadrilloIzquierda();
            
            case LADRILLOS_DERECHOS:
                return new LadrilloDerecha();
            
            case LADRILLOS_HORIZONTALES:
                return new LadrilloHorizontal();
             
            case ESTATUA:
                return new Estatua();
            
            case SPAWN:
                return new Spawn();
                
            case ESQUINA_DERECHA:
                return new EsquinaDerecha();
                
            case ESQUINA_IZQUIERDA:
                return new EsquinaIzquierda();
                
            default:
                return null;
        }


    }
    
    
}
