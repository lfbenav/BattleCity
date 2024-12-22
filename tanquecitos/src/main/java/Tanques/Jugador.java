/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tanques;

import Comandos.InvocadorInstance;
import Elementos.ConfiguracionSingleton;
import Elementos.ObtenerRutaSprite;
import Ventanas.VentanaJuego;

/**
 *
 * @author wisfer
 */
public class Jugador extends Tanque{

    ConfiguracionSingleton config = ConfiguracionSingleton.getInstance();

    public Jugador() {
        super(false);
        setVida(1);
        setVelocidadMovimiento(config.getVelocidadMovimiento());
        setVelocidadDisparo(config.getVelocidadDisparo());
        setCooldown((int)getVelocidadDisparo());

        setTexturaPrincipalArriba1(ObtenerRutaSprite.get("tile000.png"));
        setTexturaPrincipalAbajo1(ObtenerRutaSprite.get("tile004.png"));
        setTexturaPrincipalIzquierda1(ObtenerRutaSprite.get("tile002.png"));
        setTexturaPrincipalDerecha1(ObtenerRutaSprite.get("tile006.png"));
        
        setTexturaPrincipalArriba2(ObtenerRutaSprite.get("tile001.png"));
        setTexturaPrincipalAbajo2(ObtenerRutaSprite.get("tile005.png"));
        setTexturaPrincipalIzquierda2(ObtenerRutaSprite.get("tile003.png"));
        setTexturaPrincipalDerecha2(ObtenerRutaSprite.get("tile007.png"));
    
        this.direccion=1;
        tanqueLabel.setBackground(new java.awt.Color(49, 49, 49));
        tanqueLabel.setForeground(new java.awt.Color(49, 49, 49));
        //setIcon(ObtenerRutaSprite.get("tile000.png"));
        setIcon(ObtenerRutaSprite.get("tile166.png"));
    }    
    
    
    
    
    @Override
    public void recibirDano(VentanaJuego ventana){
        this.setVida(getVida()-1);
        
        
        
        if(getVida()<=0){
            
            InvocadorInstance.getInstance().respawnear=true;
            
            ventana.tanques.remove(this);
            ventana.pnlJuego.revalidate();
            
            try {
                Thread.sleep(2);
                setIcon(ObtenerRutaSprite.get("tile216.png"));
                Thread.sleep(100);
                setIcon(ObtenerRutaSprite.get("tile217.png"));
                Thread.sleep(100);
                setIcon(ObtenerRutaSprite.get("tile218.png"));
                Thread.sleep(100);
                setIcon(ObtenerRutaSprite.get("tile217.png"));
                Thread.sleep(100);
                setIcon(ObtenerRutaSprite.get("tile021.png"));
                Thread.sleep(100);
            } catch (InterruptedException ex) {}
            
            ventana.pnlJuego.remove(tanqueLabel);
            ventana.pnlJuego.revalidate();
            
            if(this.getEquipo().equals("Jugador")){
                System.out.println("Te moriste");
                if(ventana.vidas>0){
                    InvocadorInstance.getInstance().respawnear=true;
                    ventana.threadJugador.respawnear = true;
                    //ventana.setJugador(null);
                    ventana.refrescarVidas();
                }else{
                    ventana.getJugador().setIcon("tile021.png");
                    ventana.setJugador(null);
                    System.out.println("Game Over");
                    ventana.vidas = -1;
                    ventana.perder();
                }
                
            }else ventana.sumarTanqueDestruido();

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
        return "Tanque de tipo Simple. Vida: "+getVida()+" Velocidad de movimiento: " +getVelocidadMovimiento() + " Velocidad de Disparo: " + getVelocidadDisparo() + ".";

    }
    
    @Override
    public String getEquipo(){
        return "Jugador";
    }
    
    @Override
    public String getTipo() {
        return "Jugador";
    }
}
