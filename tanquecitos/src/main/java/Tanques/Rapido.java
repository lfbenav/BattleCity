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
public class Rapido extends Tanque {

    ConfiguracionSingleton config = ConfiguracionSingleton.getInstance();
    
    public Rapido(boolean especial){
        super(especial);
        setVida(1);
        setVelocidadMovimiento((float)(config.getVelocidadMovimiento()+5.0));   //Se puede cambiar aqui si sigue siendo muy lento. Tambien se le puede sumar en lugar de multiplicar
        setVelocidadDisparo(config.getVelocidadDisparo());
        setCooldown((int)getVelocidadDisparo());
        
        setTexturaPrincipalArriba1(ObtenerRutaSprite.get("tile133.png"));
        setTexturaPrincipalAbajo1(ObtenerRutaSprite.get("tile137.png"));
        setTexturaPrincipalIzquierda1(ObtenerRutaSprite.get("tile135.png"));
        setTexturaPrincipalDerecha1(ObtenerRutaSprite.get("tile139.png"));
        
        setTexturaPrincipalArriba2(ObtenerRutaSprite.get("tile134.png"));
        setTexturaPrincipalAbajo2(ObtenerRutaSprite.get("tile138.png"));
        setTexturaPrincipalIzquierda2(ObtenerRutaSprite.get("tile136.png"));
        setTexturaPrincipalDerecha2(ObtenerRutaSprite.get("tile140.png"));
        
        setTexturaEspecialArriba(ObtenerRutaSprite.get("tile333.png"));
        setTexturaEspecialAbajo(ObtenerRutaSprite.get("tile337.png"));
        setTexturaEspecialIzquierda(ObtenerRutaSprite.get("tile335.png"));
        setTexturaEspecialDerecha(ObtenerRutaSprite.get("tile339.png"));
    }
    
    @Override
    public void moverse(){
    }

    @Override
    public void disparar(){
    }
    
    @Override
    public String getInfo() {
        return "Tanque de tipo Rapido. Vida: "+getVida()+" Velocidad de movimiento: " +getVelocidadMovimiento() + " Velocidad de Disparo: " + getVelocidadDisparo() +" Especial: "+isEspecial()+ ".";
    }
    
    @Override
    public String getTipo() {
        return "Rapido";
    }
}
