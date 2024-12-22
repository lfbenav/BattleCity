/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Threads;

import Bloques.Bloque;
import Comandos.*;
import Tanques.Tanque;
import Ventanas.VentanaJuego;
import java.awt.Component;
import java.awt.Point;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author wisfer
 */
public class ThreadEnemigos extends Thread{
    
    VentanaJuego ventana;
    public ArrayList<Tanque> tanques;
    boolean isRunning = true;
    InvocadorInstance invocador = InvocadorInstance.getInstance();
    
    boolean isPaused = false;
    
    public ThreadEnemigos(VentanaJuego ventana) {
        this.ventana = ventana;
        this.tanques = ventana.tanques;
    }
    
    
    @Override
    public void run(){
        
        while(isRunning){

            try {
                
                sleep(100);
                
                
                for(Tanque tanque : tanques){
                    
                    while(isPaused){
                        sleep(1000);
                    }
                    
                    if(!isRunning)
                        break;
                    
                    decidirMovimiento(tanque);
                    decidirDisparo(tanque);


                }
                
                
                
            } catch (InterruptedException | ConcurrentModificationException ex) {
                //System.out.println("ErrorEnEnemigos");
            }
        
        
        
        
        
        
        
        }
        
    }
    
    private void decidirMovimiento(Tanque tanque){
           
        int direccion = tanque.getDireccion();

        int random = new Random().nextInt(4 - 1 + 1) + 1;
        
        switch(direccion){
            
            case Tanque.ABAJO:
                boolean abajo = puedeAbajo(tanque);
                if(!abajo){
                    tanque.setDireccion(random);
                    break;
                }
                
                invocador.recibirComando(new FlechaAbajo(tanque));
                break;
             
            case Tanque.ARRIBA:
                boolean arriba = puedeArriba(tanque);
                if(!arriba){
                    tanque.setDireccion(random);
                    break;
                }

                invocador.recibirComando(new FlechaArriba(tanque));
                break;
                
            case Tanque.DERECHA:
                boolean derecha = puedeDerecha(tanque);
                if(!derecha){
                    tanque.setDireccion(random);
                    break;
                }
                
                invocador.recibirComando(new FlechaDerecha(tanque));
                break;
                
            case Tanque.IZQUIERDA:
                boolean izquierda = puedeIzquierda(tanque);
                if(!izquierda){
                    tanque.setDireccion(random);
                    break;
                }
                
                invocador.recibirComando(new FlechaIzquierda(tanque));
                break;
        
        
        }
        
        
        
 
    }
    
    private void decidirDisparo(Tanque tanque){
    
        int random;
        random = new Random().nextInt(13);
        //if(tanque.getTipo().equals("Fuerte")){
        //    random = 0;
        //}
        
        if(random==0){
            invocador.recibirComando(new Disparar(tanque));
        }
        
    
    }
    
    private int cambiarDeCamino(boolean[] direcciones, int direccionActual){
        
        return 0;
    }
    
    private boolean puedeDerecha(Tanque tanque){
        try{
        double velocidad = tanque.getVelocidadMovimiento();
        
        int tankSize = Tanque.size;
        
        Component validacion;
        JLabel labelJugador = tanque.getTanqueLabel();

        Point izquierdaArriba = new Point(labelJugador.getX(),labelJugador.getY());
        Point izquierdaAbajo = new Point(labelJugador.getX(),labelJugador.getY()+tankSize-1);
        Point derechaArriba = new Point(labelJugador.getX()+tankSize-1,labelJugador.getY());
        Point derechaAbajo = new Point(labelJugador.getX()+tankSize-1,labelJugador.getY()+tankSize-1);

        ArrayList<Point> esquinas = new ArrayList<Point>();
        esquinas.add(izquierdaArriba);
        esquinas.add(izquierdaAbajo);
        esquinas.add(derechaArriba);
        esquinas.add(derechaAbajo);     

        for(Point esquina : esquinas){
            int X = (int)(esquina.x+velocidad);
            int Y = esquina.y;

            if(Y>ventana.panelSize){
                return false;
            }

            validacion = ventana.pnlJuego.getComponentAt(X,Y);
            if(validacion!=ventana.pnlJuego && validacion!=labelJugador){
                Bloque bloqueEncontrado = encontrarBloque((JLabel)(validacion),ventana.mapa);

                if(validacion.getBackground().getRed()==50)
                    return false;

                if(validacion.getBackground().getRed()==51)
                    return false;

                if(!bloqueEncontrado.isPuedenPasarTanques())
                    return false;

            }

        }
        return true;
        }catch(NullPointerException error){
            return false;
        }
        
    }
    
        private boolean puedeIzquierda(Tanque tanque){
        try{
        double velocidad = tanque.getVelocidadMovimiento();
        
        int tankSize = Tanque.size;
        
        Component validacion;
        JLabel labelJugador = tanque.getTanqueLabel();

        Point izquierdaArriba = new Point(labelJugador.getX(),labelJugador.getY());
        Point izquierdaAbajo = new Point(labelJugador.getX(),labelJugador.getY()+tankSize-1);
        Point derechaArriba = new Point(labelJugador.getX()+tankSize-1,labelJugador.getY());
        Point derechaAbajo = new Point(labelJugador.getX()+tankSize-1,labelJugador.getY()+tankSize-1);

        ArrayList<Point> esquinas = new ArrayList<Point>();
        esquinas.add(izquierdaArriba);
        esquinas.add(izquierdaAbajo);
        esquinas.add(derechaArriba);
        esquinas.add(derechaAbajo);     

        for(Point esquina : esquinas){
            int X = (int)(esquina.x-velocidad);
            int Y = esquina.y;


            if(Y<=0){
                return false;
            }

            validacion = ventana.pnlJuego.getComponentAt(X,Y);
            if(validacion!=ventana.pnlJuego && validacion!=labelJugador){
                Bloque bloqueEncontrado = encontrarBloque((JLabel)(validacion),ventana.mapa);
                if(validacion.getBackground().getRed()==50)
                    return false;

                if(validacion.getBackground().getRed()==51)
                    return false;

                if(!bloqueEncontrado.isPuedenPasarTanques())
                    return false;
            }

        }
        return true;
        }catch(NullPointerException error){
            return false;
        }
        
    }
        
    private boolean puedeArriba(Tanque tanque){
        try{
        double velocidad = tanque.getVelocidadMovimiento();
        
        int tankSize = Tanque.size;
        
        Component validacion;
        JLabel labelJugador = tanque.getTanqueLabel();

        Point izquierdaArriba = new Point(labelJugador.getX(),labelJugador.getY());
        Point izquierdaAbajo = new Point(labelJugador.getX(),labelJugador.getY()+tankSize-1);
        Point derechaArriba = new Point(labelJugador.getX()+tankSize-1,labelJugador.getY());
        Point derechaAbajo = new Point(labelJugador.getX()+tankSize-1,labelJugador.getY()+tankSize-1);

        ArrayList<Point> esquinas = new ArrayList<Point>();
        esquinas.add(izquierdaArriba);
        esquinas.add(izquierdaAbajo);
        esquinas.add(derechaArriba);
        esquinas.add(derechaAbajo);     

        for(Point esquina : esquinas){
            int X = esquina.x;
            int Y = (int)(esquina.y-velocidad);



            if(Y<=0){
                return false;
            }

            validacion = ventana.pnlJuego.getComponentAt(X,Y);
            if(validacion!=ventana.pnlJuego && validacion!=labelJugador){
                Bloque bloqueEncontrado = encontrarBloque((JLabel)(validacion),ventana.mapa);

                if(validacion.getBackground().getRed()==50)
                    return false;

                if(validacion.getBackground().getRed()==51)
                    return false;

                if(!bloqueEncontrado.isPuedenPasarTanques())
                    return false;

            }

        }
        return true;
        }catch(NullPointerException error){
            return false;
        }
        
    }
    
    private boolean puedeAbajo(Tanque tanque){
        try{
        double velocidad = tanque.getVelocidadMovimiento();
        
        int tankSize = Tanque.size;
        
        Component validacion;
        JLabel labelJugador = tanque.getTanqueLabel();

        Point izquierdaArriba = new Point(labelJugador.getX(),labelJugador.getY());
        Point izquierdaAbajo = new Point(labelJugador.getX(),labelJugador.getY()+tankSize-1);
        Point derechaArriba = new Point(labelJugador.getX()+tankSize-1,labelJugador.getY());
        Point derechaAbajo = new Point(labelJugador.getX()+tankSize-1,labelJugador.getY()+tankSize-1);

        ArrayList<Point> esquinas = new ArrayList<Point>();
        esquinas.add(izquierdaArriba);
        esquinas.add(izquierdaAbajo);
        esquinas.add(derechaArriba);
        esquinas.add(derechaAbajo);     

        for(Point esquina : esquinas){
            int X = esquina.x;
            int Y = (int)(esquina.y+velocidad);


            if(Y>ventana.panelSize){
                return false;
            }

            validacion = ventana.pnlJuego.getComponentAt(X,Y);
            if(validacion!=ventana.pnlJuego && validacion!=labelJugador){
                Bloque bloqueEncontrado = encontrarBloque((JLabel)(validacion),ventana.mapa);

                if(validacion.getBackground().getRed()==50)
                    return false;

                if(validacion.getBackground().getRed()==51)
                    return false;

                if(!bloqueEncontrado.isPuedenPasarTanques())
                    return false;

            }

        }
        return true;
        }catch(NullPointerException error){
            return false;
        }
        
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
    
    public void detener(){
    
        invocador.limpiar();
        isRunning = false;
    
    }
    
    public void pausar(){
    
        invocador.limpiar();
        isPaused = true;
    
    }
    
    public void desPausar(){
    
        invocador.limpiar();
        isPaused = false;
    
    }
    
    
}
