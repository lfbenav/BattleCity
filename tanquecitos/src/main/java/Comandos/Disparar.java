/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comandos;

import Elementos.PuntuacionSingleton;
import Tanques.*;
import Threads.ThreadBala;

import Ventanas.VentanaJuego;
import java.awt.Point;

/**
 *
 * @author wisfer
 */
public class Disparar extends Comando{
    
    Tanque jugador;

    public Disparar(Tanque jugador) {
        this.jugador = jugador;
    }
    
    PuntuacionSingleton puntuacion = PuntuacionSingleton.getInstance();
    public static int bulletSize = 10;
    
    @Override
    public String getCommandName() {
        return "Disparar";
    }

    @Override
    public void execute(VentanaJuego ventana) {
        Bala bala = new Bala(jugador.direccion);
        ThreadBala thread;
        int spawnX;
        int spawnY;
        switch(jugador.direccion){
            case Tanque.ARRIBA:

                if(!jugador.isPuedeDisparar()){
                    break;
                }
                
                if(jugador.getTipo().equals("Jugador")){
                    ventana.setDisparos();
                }
                ventana.balas.add(bala);
                jugador.setPuedeDisparar(false);
                
                spawnX = jugador.getTanqueLabel().getX()+(Tanque.size/2)-bulletSize-1+2;
                spawnY = jugador.getTanqueLabel().getY()-bulletSize;
                
                bala.getTanqueLabel().setSize(bulletSize,bulletSize);
                bala.setIcon(bala.getTexturaPrincipalArriba1());
                
                ventana.pnlJuego.add(bala.getTanqueLabel());
                bala.getTanqueLabel().setLocation(spawnX, spawnY);
                
                thread = new ThreadBala(jugador,bala,ventana);
                thread.start();
                
                break;
                
            case Tanque.ABAJO:

                if(!jugador.isPuedeDisparar()){
                    break;
                }
                
                if(jugador.getTipo().equals("Jugador")){
                    ventana.setDisparos();
                }
                
                ventana.balas.add(bala);
                jugador.setPuedeDisparar(false);
                
                spawnX = jugador.getTanqueLabel().getX()+(Tanque.size/2)-bulletSize-1+4;
                spawnY = jugador.getTanqueLabel().getY()+Tanque.size;
                
                bala.getTanqueLabel().setSize(bulletSize,bulletSize);
                bala.setIcon(bala.getTexturaPrincipalAbajo1());
                
                ventana.pnlJuego.add(bala.getTanqueLabel());
                bala.getTanqueLabel().setLocation(spawnX, spawnY);
                
                thread = new ThreadBala(jugador,bala,ventana);
                thread.start();
                
                break;
                
            case Tanque.IZQUIERDA:

                if(!jugador.isPuedeDisparar()){
                    break;
                }
                
                if(jugador.getTipo().equals("Jugador")){
                    ventana.setDisparos();
                }
                
                ventana.balas.add(bala);
                jugador.setPuedeDisparar(false);
                
                spawnX = jugador.getTanqueLabel().getX()-bulletSize;
                spawnY = jugador.getTanqueLabel().getY()+(Tanque.size/2)-bulletSize-1+2;
                
                bala.getTanqueLabel().setSize(bulletSize,bulletSize);
                bala.setIcon(bala.getTexturaPrincipalDerecha1());
                
                ventana.pnlJuego.add(bala.getTanqueLabel());
                bala.getTanqueLabel().setLocation(spawnX, spawnY);
                
                thread = new ThreadBala(jugador,bala,ventana);
                thread.start();
                
                break;
                
            case Tanque.DERECHA:

                if(!jugador.isPuedeDisparar()){
                    break;
                }
                
                if(jugador.getTipo().equals("Jugador")){
                    ventana.setDisparos();
                }
                
                ventana.balas.add(bala);
                jugador.setPuedeDisparar(false);
                
                spawnX = jugador.getTanqueLabel().getX()+Tanque.size;
                spawnY = jugador.getTanqueLabel().getY()+(Tanque.size/2)-bulletSize-1+4;
                
                bala.getTanqueLabel().setSize(bulletSize,bulletSize);
                bala.setIcon(bala.getTexturaPrincipalIzquierda1());
                
                ventana.pnlJuego.add(bala.getTanqueLabel());
                bala.getTanqueLabel().setLocation(spawnX, spawnY);
                
                thread = new ThreadBala(jugador,bala,ventana);
                thread.start();
                
                break;
                
            default:
                break;
        }        
               
        
        
        
    }
    
}
