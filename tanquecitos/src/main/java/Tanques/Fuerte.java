/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tanques;

import Elementos.ObtenerRutaSprite;
import Elementos.ConfiguracionSingleton;

/**
 *
 * @author wisfer
 */
public class Fuerte extends Tanque {

    ConfiguracionSingleton config = ConfiguracionSingleton.getInstance();
    
    public Fuerte(boolean especial){
        super(especial);
        setVida(1);
        setVelocidadMovimiento(config.getVelocidadMovimiento());
        setVelocidadDisparo((float)(config.getVelocidadDisparo()+1.5));         //Se puede cambiar aqui si sigue siendo muy lento. Tambien se le puede sumar en lugar de multiplicar
        setCooldown((int)getVelocidadDisparo());
        
        setTexturaPrincipalArriba1(ObtenerRutaSprite.get("tile158.png"));
        setTexturaPrincipalAbajo1(ObtenerRutaSprite.get("tile162.png"));
        setTexturaPrincipalIzquierda1(ObtenerRutaSprite.get("tile160.png"));
        setTexturaPrincipalDerecha1(ObtenerRutaSprite.get("tile164.png"));
        
        setTexturaPrincipalArriba2(ObtenerRutaSprite.get("tile159.png"));
        setTexturaPrincipalAbajo2(ObtenerRutaSprite.get("tile163.png"));
        setTexturaPrincipalIzquierda2(ObtenerRutaSprite.get("tile161.png"));
        setTexturaPrincipalDerecha2(ObtenerRutaSprite.get("tile165.png"));
        
        setTexturaEspecialArriba(ObtenerRutaSprite.get("tile358.png"));
        setTexturaEspecialAbajo(ObtenerRutaSprite.get("tile362.png"));
        setTexturaEspecialIzquierda(ObtenerRutaSprite.get("tile360.png"));
        setTexturaEspecialDerecha(ObtenerRutaSprite.get("tile364.png"));
    }
    
    @Override
    public void moverse(){
    }

    @Override
    public void disparar(){
    }

    @Override
    public String getInfo() {
        return "Tanque de tipo Fuerte. Vida: "+getVida()+" Velocidad de movimiento: " +getVelocidadMovimiento() + " Velocidad de Disparo: " + getVelocidadDisparo() +" Especial: "+isEspecial()+ ".";
    }
    
    @Override
    public String getTipo() {
        return "Fuerte";
    }
    
}
