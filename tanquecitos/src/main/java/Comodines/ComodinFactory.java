/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comodines;

import java.util.Random;

/**
 *
 * @author wisfer
 */
public class ComodinFactory implements ComodinFactoryMethod{
    
    public static final int RELOJ = 0;
    public static final int CASCO = 1;
    public static final int TANQUE_VELOZ = 2;
    public static final int ESTRELLA = 3;
    public static final int PALA = 4;
    public static final int BOMBA = 5;
    
    public ComodinFactory(){
    }
    
    @Override
    public Comodin generarComodin(){
    
        int tipo = new Random().nextInt(6);
        
        switch(tipo){
        
            case RELOJ:
                return new Reloj();
              
            case CASCO:
                return new Casco();
             
            case TANQUE_VELOZ:
                return new TanqueVeloz();
              
            case ESTRELLA:
                return new Estrella();
              
            case PALA:
                return new Pala();
              
            case BOMBA:
                return new Bomba();
            
            default:
                return null;
        }
        
        
    }
    
}
