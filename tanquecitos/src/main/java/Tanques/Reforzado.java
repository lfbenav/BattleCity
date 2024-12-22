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
public class Reforzado extends Tanque {

    ConfiguracionSingleton config = ConfiguracionSingleton.getInstance();
    
    public Reforzado(boolean especial){
        super(especial);
        setVida(3);                                                         //POR DEFECTO ES 4
        setVelocidadMovimiento(config.getVelocidadMovimiento());
        setVelocidadDisparo(config.getVelocidadDisparo());
        setCooldown((int)getVelocidadDisparo());
        
        setTexturaPrincipalArriba1(ObtenerRutaSprite.get("tile183.png"));
        setTexturaPrincipalAbajo1(ObtenerRutaSprite.get("tile187.png"));
        setTexturaPrincipalIzquierda1(ObtenerRutaSprite.get("tile185.png"));
        setTexturaPrincipalDerecha1(ObtenerRutaSprite.get("tile189.png"));
        
        setTexturaPrincipalArriba2(ObtenerRutaSprite.get("tile184.png"));
        setTexturaPrincipalAbajo2(ObtenerRutaSprite.get("tile188.png"));
        setTexturaPrincipalIzquierda2(ObtenerRutaSprite.get("tile186.png"));
        setTexturaPrincipalDerecha2(ObtenerRutaSprite.get("tile190.png"));
        
        setTexturaEspecialArriba(ObtenerRutaSprite.get("tile383.png"));
        setTexturaEspecialAbajo(ObtenerRutaSprite.get("tile387.png"));
        setTexturaEspecialIzquierda(ObtenerRutaSprite.get("tile386.png"));
        setTexturaEspecialDerecha(ObtenerRutaSprite.get("tile389.png"));
    }
    
    @Override
    public void moverse(){
    }

    @Override
    public void disparar(){
    }

    @Override
    public String getInfo() {
        return "Tanque de tipo Reforzado. Vida: "+getVida()+" Velocidad de movimiento: " +getVelocidadMovimiento() + " Velocidad de Disparo: " + getVelocidadDisparo() +" Especial: "+isEspecial()+ ".";
    }

    @Override
    public String getTipo() {
        return "Reforzado";
    }
    
}
