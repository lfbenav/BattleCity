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
public class Simple extends Tanque {

    ConfiguracionSingleton config = ConfiguracionSingleton.getInstance();
    
    public Simple(boolean especial){
        super(especial);
        setVida(2);
        setVelocidadMovimiento(config.getVelocidadMovimiento());
        setVelocidadDisparo(config.getVelocidadDisparo());
        setCooldown((int)getVelocidadDisparo());
        
        setTexturaPrincipalArriba1(ObtenerRutaSprite.get("tile108.png"));
        setTexturaPrincipalAbajo1(ObtenerRutaSprite.get("tile112.png"));
        setTexturaPrincipalIzquierda1(ObtenerRutaSprite.get("tile110.png"));
        setTexturaPrincipalDerecha1(ObtenerRutaSprite.get("tile114.png"));
        
        setTexturaPrincipalArriba2(ObtenerRutaSprite.get("tile109.png"));
        setTexturaPrincipalAbajo2(ObtenerRutaSprite.get("tile113.png"));
        setTexturaPrincipalIzquierda2(ObtenerRutaSprite.get("tile111.png"));
        setTexturaPrincipalDerecha2(ObtenerRutaSprite.get("tile115.png"));
        
        setTexturaEspecialArriba(ObtenerRutaSprite.get("tile308.png"));
        setTexturaEspecialAbajo(ObtenerRutaSprite.get("tile312.png"));
        setTexturaEspecialIzquierda(ObtenerRutaSprite.get("tile310.png"));
        setTexturaEspecialDerecha(ObtenerRutaSprite.get("tile314.png"));
    }
    
    @Override
    public void moverse(){
    }

    @Override
    public void disparar(){
    }

    @Override
    public String getInfo() {
        return "Tanque de tipo Simple. Vida: "+getVida()+" Velocidad de movimiento: " +getVelocidadMovimiento() + " Velocidad de Disparo: " + getVelocidadDisparo() +" Especial: "+isEspecial()+ ".";
    }

    @Override
    public String getTipo() {
        return "Simple";
    }
    
}
