/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tanques;

import Elementos.ConfiguracionSingleton;
import Elementos.ObtenerRutaSprite;
import Threads.ThreadBala;
import java.awt.Color;

/**
 *
 * @author wisfer
 */
public class Bala extends Tanque{

    ConfiguracionSingleton config = ConfiguracionSingleton.getInstance();
    String direccionString;
    public ThreadBala threadBala;
    
    
    public Bala(int direccion) {
        super(false);
        setVida(1);
        setVelocidadMovimiento(config.getVelocidadMovimiento());
        setVelocidadDisparo((float)(config.getVelocidadDisparo()*0.5));         //Se puede cambiar aqui si sigue siendo muy lento. Tambien se le puede sumar en lugar de multiplicar
        setCooldown((int)getVelocidadDisparo());
        
        setTexturaPrincipalArriba1(ObtenerRutaSprite.get("BalaArriba.png"));
        setTexturaPrincipalAbajo1(ObtenerRutaSprite.get("BalaAbajo.png"));
        setTexturaPrincipalIzquierda1(ObtenerRutaSprite.get("BalaIzquierda.png"));
        setTexturaPrincipalDerecha1(ObtenerRutaSprite.get("BalaDerecha.png"));
        
        this.getTanqueLabel().setBackground(new Color(51,51,51));
        this.direccion = direccion;
        
        switch(direccion){
            case ARRIBA:
                this.direccionString = "Arriba";
                break;
            case ABAJO:
                this.direccionString = "Abajo";
                break;        
            case IZQUIERDA:
                this.direccionString = "Izquierda";
                break;
            case DERECHA:
                this.direccionString = "Derecha";
                break;
            default:
                this.direccionString = "N/a";
                break;
        }        
    }

    @Override
    public void moverse() {
        
    }

    @Override
    public void disparar() {
    }

    @Override
    public String getInfo() {
        return "Bala";
    }

    public String getDireccionString() {
        return direccionString;
    }

    public void setDireccionString(String direccionString) {
        this.direccionString = direccionString;
    }
    
    @Override
    public String getTipo() {
        return "Bala";
    }
    
}
