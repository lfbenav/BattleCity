/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Threads;

import Bloques.Bloque;
import Comandos.Disparar;
import Comandos.InvocadorInstance;
import Elementos.ConfiguracionSingleton;
import Elementos.ObtenerRutaSprite;
import Tanques.Bala;
import Tanques.Jugador;
import Tanques.Tanque;
import Ventanas.VentanaJuego;
import java.awt.Component;
import java.awt.Point;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author wisfer
 */
public class ThreadBala extends Thread{
    
    Bala bala;
    Tanque jugador;
    VentanaJuego ventana;

    int velocidad;// = (int) ConfiguracionSingleton.getInstance().getVelocidadDisparo();
    boolean isRunning;

    public ThreadBala(Tanque jugador, Bala bala, VentanaJuego ventana) {
        this.jugador = jugador;
        this.bala = bala;
        this.ventana = ventana;
        this.isRunning = true;
        bala.threadBala = this;
        velocidad = (int)jugador.getVelocidadDisparo();
        
    }
    
    
    
    @Override
    public void run(){
        while(isRunning){
            try {
                Thread.sleep(5);
   
                JLabel label = bala.getTanqueLabel();
                int X = label.getX();
                int Y = label.getY();
                int direccion = bala.getDireccion();
                
                Point izquierdaArriba = new Point(label.getX(),label.getY());
                Point izquierdaAbajo = new Point(label.getX(),label.getY()+Disparar.bulletSize-1-1);
                Point derechaArriba = new Point(label.getX()+Disparar.bulletSize-1,label.getY());
                Point derechaAbajo = new Point(label.getX()+Disparar.bulletSize-1-1,label.getY()+Disparar.bulletSize-1-1);

                ArrayList<Point> esquinas = new ArrayList<Point>();
                esquinas.add(izquierdaArriba);
                esquinas.add(izquierdaAbajo);
                esquinas.add(derechaArriba);
                esquinas.add(derechaAbajo);
                
                int nuevoX;
                int nuevoY;
                Component validacion;
                                
                switch(direccion){
                    
                    
                    
                    
                    case Tanque.ARRIBA:
                        for(Point esquina : esquinas){
                            nuevoX = esquina.x;
                            nuevoY = (int)(esquina.y-velocidad);
                            
                            if(nuevoY<0){
                                explotar();
                                break;
                            }
                            
                            validacion = ventana.pnlJuego.getComponentAt(nuevoX,nuevoY);
                            
                            if(validacion==ventana.getJugador().getTanqueLabel()){
                                explotarSilenciosamente();
                                ventana.getJugador().recibirDano(ventana);
                                return;
                            }
                            
                            if(validacion!=ventana.pnlJuego && validacion!=label){
                                Bloque bloqueEncontrado = encontrarBloque((JLabel)(validacion),ventana.mapa);
                                
                                if(validacion == null){
                                    explotar();
                                    return;
                                }
                                if(validacion.getBackground().getRed()==50){
                                    JLabel labelDelTanque = (JLabel) ventana.pnlJuego.getComponentAt(nuevoX,nuevoY);
                                    Tanque tanqueObjetivo = encontrarTanque(labelDelTanque,ventana.tanques);

                                    
                                    if("Malo".equals(jugador.getEquipo())&& "Malo".equals(tanqueObjetivo.getEquipo())){
                                    }else{
                                        if(tanqueObjetivo.getVida()==1){
                                            explotarSilenciosamente();
                                            tanqueObjetivo.recibirDano(ventana);
                                        }
                                        else{
                                            explotar();
                                            tanqueObjetivo.recibirDano(ventana);
                                        }
                                        return;
                                    }
                                    
                                }
                                
                                else if(validacion.getBackground().getRed()==51){
                                    JLabel validacion2 = (JLabel)validacion;
                                    Bala balaChocada = encontrarBala(validacion2,ventana.balas);
                                    balaChocada.threadBala.explotarSilenciosamente();
                                    explotar();
                                    return;
                                }
                                else if(validacion.getBackground().getRed()==49){
                                    //explotar();
                                    //return;
                                }
                                else if(validacion.getBackground().getRed()==48){
                                    //explotar();
                                    //return;
                                }
                                else if(bloqueEncontrado.isPuedenPasarBalas()){
                                }
                                
                                else if(bloqueEncontrado.isIndestructible()){
                                    explotar();
                                    break;
                                }
                                
                                else if(!bloqueEncontrado.isPuedenPasarBalas()){
                                    bloqueEncontrado.recibirDano(ventana);
                                    explotar();
                                    return;
                                }

                            }
                        
                        }
                        label.setLocation(label.getX(), (int)(label.getY()-velocidad));
                        
                        break;
                        
                        
                        
                        
                    case Tanque.ABAJO:
                        for(Point esquina : esquinas){
                            nuevoX = esquina.x;
                            nuevoY = (int)(esquina.y+velocidad);
                            
                            if(nuevoY>ventana.panelSize){
                                explotar();
                                break;
                            }
                            
                            validacion = ventana.pnlJuego.getComponentAt(nuevoX,nuevoY);
                            
                            if(validacion==ventana.getJugador().getTanqueLabel()){
                                explotarSilenciosamente();
                                ventana.getJugador().recibirDano(ventana);
                                return;
                            }
                            
                            if(validacion!=ventana.pnlJuego && validacion!=label){
                                Bloque bloqueEncontrado = encontrarBloque((JLabel)(validacion),ventana.mapa);
                                
                                if(validacion == null){
                                    explotar();
                                    return;
                                }
                                
                                if(validacion.getBackground().getRed()==50){
                                    JLabel labelDelTanque = (JLabel) ventana.pnlJuego.getComponentAt(nuevoX,nuevoY);
                                    Tanque tanqueObjetivo = encontrarTanque(labelDelTanque,ventana.tanques);
                                    
                                    if("Malo".equals(jugador.getEquipo())&& "Malo".equals(tanqueObjetivo.getEquipo())){

                                    }else{
                                        if(tanqueObjetivo.getVida()==1){
                                            explotarSilenciosamente();
                                            tanqueObjetivo.recibirDano(ventana);
                                        }
                                        else{
                                            explotar();
                                            tanqueObjetivo.recibirDano(ventana);
                                        }
                                        return;
                                    }
                                }
                                
                                else if(validacion.getBackground().getRed()==51){
                                    JLabel validacion2 = (JLabel)validacion;
                                    Bala balaChocada = encontrarBala(validacion2,ventana.balas);
                                    balaChocada.threadBala.explotarSilenciosamente();
                                    explotar();
                                    return;
                                }
                                
                                else if(validacion.getBackground().getRed()==49){
                                    //explotar();
                                    //return;
                                }
                                else if(validacion.getBackground().getRed()==48){
                                    //explotar();
                                    //return;
                                }

                                else if(bloqueEncontrado.isPuedenPasarBalas()){
                                }
                                
                                else if(bloqueEncontrado.isIndestructible()){
                                    explotar();
                                    break;
                                }
                                
                                else if(!bloqueEncontrado.isPuedenPasarBalas()){
                                    bloqueEncontrado.recibirDano(ventana);
                                    explotar();
                                    return;
                                }

                            }
                        
                        }
                        label.setLocation(label.getX(), (int)(label.getY()+velocidad));
                        
                        break;        
                        
                        
                        
                        
                    case Tanque.IZQUIERDA:
                        
                        for(Point esquina : esquinas){
                            nuevoX = (int) (esquina.x-velocidad);
                            nuevoY = esquina.y;
                            
                            if(nuevoX<0){
                                explotar();
                                break;
                            }
                            validacion = ventana.pnlJuego.getComponentAt(nuevoX,nuevoY);
                            if(validacion==ventana.getJugador().getTanqueLabel()){
                                explotarSilenciosamente();
                                ventana.getJugador().recibirDano(ventana);
                                return;
                            }
                            
                            if(validacion!=ventana.pnlJuego && validacion!=label){
                                Bloque bloqueEncontrado = encontrarBloque((JLabel)(validacion),ventana.mapa);
                                
                                if(validacion == null){
                                    explotar();
                                    return;
                                }
                                                                
                                if(validacion.getBackground().getRed()==50){
                                    JLabel labelDelTanque = (JLabel) ventana.pnlJuego.getComponentAt(nuevoX,nuevoY);
                                    Tanque tanqueObjetivo = encontrarTanque(labelDelTanque,ventana.tanques);
                                    
                                    if("Malo".equals(jugador.getEquipo())&& "Malo".equals(tanqueObjetivo.getEquipo())){

                                    }else{
                                        if(tanqueObjetivo.getVida()==1){
                                            explotarSilenciosamente();
                                            tanqueObjetivo.recibirDano(ventana);
                                        }
                                        else{
                                            explotar();
                                            tanqueObjetivo.recibirDano(ventana);
                                        }
                                        return;
                                    }
                                }
                                
                                else if(validacion.getBackground().getRed()==51){
                                    JLabel validacion2 = (JLabel)validacion;
                                    Bala balaChocada = encontrarBala(validacion2,ventana.balas);
                                    balaChocada.threadBala.explotarSilenciosamente();
                                    explotar();
                                    return;
                                }
                                
                                else if(validacion.getBackground().getRed()==49){
                                    //explotar();
                                    //return;
                                }
                                else if(validacion.getBackground().getRed()==48){
                                    //explotar();
                                    //return;
                                }

                                else if(bloqueEncontrado.isPuedenPasarBalas()){
                                }
                                
                                else if(bloqueEncontrado.isIndestructible()){
                                    explotar();
                                    break;
                                }
                                
                                else if(!bloqueEncontrado.isPuedenPasarBalas()){
                                    bloqueEncontrado.recibirDano(ventana);
                                    explotar();
                                    return;
                                }
                                

                            }
                        
                        }
                        label.setLocation((int)(label.getX()-velocidad),label.getY());
                        
                        break;
                        
                        
                        
                    case Tanque.DERECHA:
                        for(Point esquina : esquinas){
                            nuevoX = (int) (esquina.x+velocidad);
                            nuevoY = esquina.y;
                            
                            if(nuevoX>ventana.panelSize){
                                explotar();
                                break;
                            }
                            
                            validacion = ventana.pnlJuego.getComponentAt(nuevoX,nuevoY);
                            
                            if(validacion==ventana.getJugador().getTanqueLabel()){
                                explotarSilenciosamente();
                                ventana.getJugador().recibirDano(ventana);
                                return;
                            }
                            
                            
                            if(validacion!=ventana.pnlJuego && validacion!=label){
                                Bloque bloqueEncontrado = encontrarBloque((JLabel)(validacion),ventana.mapa);

                                if(validacion == null){
                                    explotar();
                                    return;
                                }
                                
                                if(validacion.getBackground().getRed()==50){
                                    JLabel labelDelTanque = (JLabel) ventana.pnlJuego.getComponentAt(nuevoX,nuevoY);
                                    Tanque tanqueObjetivo = encontrarTanque(labelDelTanque,ventana.tanques);                                    
                                    
                                    if("Malo".equals(jugador.getEquipo())&& "Malo".equals(tanqueObjetivo.getEquipo())){

                                    }else{
                                        if(tanqueObjetivo.getVida()==1){
                                            explotarSilenciosamente();
                                            tanqueObjetivo.recibirDano(ventana);
                                        }
                                        else{
                                            explotar();
                                            tanqueObjetivo.recibirDano(ventana);
                                        }
                                        return;
                                    }
                                }
                                
                                else if(validacion.getBackground().getRed()==51){
                                    JLabel validacion2 = (JLabel)validacion;
                                    Bala balaChocada = encontrarBala(validacion2,ventana.balas);
                                    balaChocada.threadBala.explotarSilenciosamente();
                                    explotar();
                                    return;
                                }
                                
                                else if(validacion.getBackground().getRed()==49){
                                    //explotar();
                                    //return;
                                }
                                else if(validacion.getBackground().getRed()==48){
                                    //explotar();
                                    //return;
                                }

                                else if(bloqueEncontrado.isPuedenPasarBalas()){
                                }
                                
                                else if(bloqueEncontrado.isIndestructible()){
                                    explotar();
                                    break;
                                }
                                
                                else if(!bloqueEncontrado.isPuedenPasarBalas()){
                                    bloqueEncontrado.recibirDano(ventana);
                                    explotar();
                                    return;
                                }

                            }
                        
                        }
                        label.setLocation((int)(label.getX()+velocidad),label.getY());
                        
                        break;
                        
                    default:
                        break;
                }        
                
                
                
            } catch (InterruptedException | ConcurrentModificationException | NullPointerException | ClassCastException ex) {
                //System.out.println("ErrorEnBala");
            }
        }
    }
    
    public void explotar(){
        ventana.balas.remove(bala);
        JLabel label = bala.getTanqueLabel();
        
        int X = label.getLocation().x;
        int Y = label.getLocation().y;
        
        Point centro = new Point(X-Disparar.bulletSize/2,Y-Disparar.bulletSize/2);
        label.setLocation(centro);
        
        try {
            
            label.setSize(30,30);
            bala.setIcon(ObtenerRutaSprite.get("tile216.png"));
            Thread.sleep(100);
            bala.setIcon(ObtenerRutaSprite.get("tile217.png"));
            Thread.sleep(100);
            bala.setIcon(ObtenerRutaSprite.get("tile218.png"));
            Thread.sleep(100);
            bala.setIcon(ObtenerRutaSprite.get("tile217.png"));
            Thread.sleep(100);
            bala.setIcon(ObtenerRutaSprite.get("tile021.png"));
            Thread.sleep(300);
            
        } catch (InterruptedException ex) {}
        ventana.pnlJuego.remove(label);
        ventana.pnlJuego.revalidate();
        isRunning = false;
        jugador.setPuedeDisparar(true);
        
    }
    
    public void explotarSilenciosamente(){
        ventana.balas.remove(bala);
        JLabel label = bala.getTanqueLabel();
        
        int X = label.getLocation().x;
        int Y = label.getLocation().y;

        bala.setIcon(ObtenerRutaSprite.get("tile021.png"));
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {}
        
        ventana.pnlJuego.remove(label);
        ventana.pnlJuego.revalidate();
        isRunning = false;
        jugador.setPuedeDisparar(true);
        
    }
    
    public void explotarParaTerminar(){

        JLabel label = bala.getTanqueLabel();
        
        int X = label.getLocation().x;
        int Y = label.getLocation().y;

        bala.setIcon(ObtenerRutaSprite.get("tile021.png"));
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {}
        
        ventana.pnlJuego.remove(label);
        ventana.pnlJuego.revalidate();
        isRunning = false;
        jugador.setPuedeDisparar(true);
        
    }
    
    
    private Bloque encontrarBloque(JLabel label, ArrayList<Bloque> mapa){
        for(Bloque bloque : mapa){
            
            if(bloque.getBloqueLabel()==label)
                return bloque;
        
        }
        return null;
    }
    
    private Tanque encontrarTanque(JLabel label, ArrayList<Tanque> tanques){
        for(Tanque tanque : tanques){
            
            if(tanque.getTanqueLabel()==label)
                return tanque;
        
        }
        return null;
    }
    
    private Bala encontrarBala(JLabel label, ArrayList<Bala> balas){
        for(Bala bala : balas){
            
            if(bala.getTanqueLabel()==label)
                return bala;
        
        }
        return null;
    }
    
    public void detener(){
    
        explotarParaTerminar();
        this.isRunning = false;
    
    }
    
    
}
