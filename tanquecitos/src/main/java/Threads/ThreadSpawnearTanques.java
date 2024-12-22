/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Threads;

import Bloques.Bloque;
import Elementos.ConfiguracionSingleton;
import Elementos.ObtenerRutaSprite;
import Tanques.Tanque;
import Tanques.TanqueFactory;
import Tanques.TanqueFactoryMethod;
import Ventanas.VentanaJuego;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author wisfer
 */
public class ThreadSpawnearTanques extends Thread{
    
    ArrayList<Tanque> enemigos;
    VentanaJuego ventana;
    public static final int cantidad = 20;
    boolean isRunning;

    ConfiguracionSingleton config = ConfiguracionSingleton.getInstance();
    
    public ThreadSpawnearTanques(VentanaJuego ventana) {
        this.ventana = ventana;
        this.isRunning = true;
        this.enemigos = ventana.tanques;
    }
    
    @Override
    public void run(){
        
        int especiales = 4;
        TanqueFactoryMethod fabricaTanques = new TanqueFactory();
        
        int max = 4;
        int min = 1;
        
        while(isRunning){
            
            for(int indice = 0; indice<cantidad; indice++){
                
                if(!isRunning)
                    return;
                
                
                while(enemigos.size()>=4){
                    try {
                        if(!isRunning)
                            return;
                        Thread.sleep(300);
                    } catch (InterruptedException ex) {}
                }
                
                try {
                    Thread.sleep((long) config.getTiempoAparicion()*1000);
                } catch (InterruptedException ex) {}
                

                int tipo = new Random().nextInt(max - min + 1) + min;

                Tanque tanqueNuevo = fabricaTanques.crearTanque(tipo, false);
                
                if(indice==3||indice==7||indice==11||indice==16){
                    tanqueNuevo.setEspecial(true);
                    especiales--;
                }

                meterTanqueEnMapa(tanqueNuevo);
                
                enemigos.add(tanqueNuevo);
                //System.out.println(ventana.tanques);
                
                if(tanqueNuevo.isEspecial()){
                    ThreadTanque thread = new ThreadTanque(tanqueNuevo,ventana);
                    tanqueNuevo.thread = thread;
                    thread.start();
                }
                
                tanqueNuevo.getTanqueLabel().setBackground(new java.awt.Color(50, 50, 50));
                tanqueNuevo.getTanqueLabel().setForeground(new java.awt.Color(50, 50, 50));
                ventana.refrescarMatrizTanquesRestantes();
                //System.out.println(tanqueNuevo.getInfo());
                
            }
            System.out.println("Todos Colocados");
            break;
        }
    }
    
    public void meterTanqueEnMapa(Tanque tanque){
        
        int tankSize = Tanque.size;
        boolean colocado = false;
        boolean ocupado = false;
        
        while(!colocado){

            int i = new Random().nextInt(ventana.panelSize);
            int j = new Random().nextInt(ventana.panelSize/2);
            if(ventana.pnlJuego.getComponentAt(i, j)==ventana.pnlJuego){
                ocupado = false;
                Point izquierdaArriba = new Point(i,j);
                Point izquierdaAbajo = new Point(i,j+tankSize-1);
                Point derechaArriba = new Point(i+tankSize-1,j);
                Point derechaAbajo = new Point(i+tankSize-1,j+tankSize-1);

                ArrayList<Point> esquinas = new ArrayList<Point>();
                esquinas.add(izquierdaArriba);
                esquinas.add(izquierdaAbajo);
                esquinas.add(derechaArriba);
                esquinas.add(derechaAbajo);

                for(Point punto : esquinas){

                    int X = punto.x;
                    int Y = punto.y;

                    if(ventana.pnlJuego.getComponentAt(X, Y)!=ventana.pnlJuego){
                        ocupado=true;
                        break;
                    }

                }

                if(!ocupado){
                    pintarTanque(tanque,i,j);
                    return;
                }


            }
        
        }
            
    
    }
    
    
    private void pintarTanque(Tanque tanque, int i, int j){
        
        try {
            tanque.setIcon(ObtenerRutaSprite.get("tile166.png"));
            JLabel label = tanque.getTanqueLabel();
            ventana.pnlJuego.add(label);
            label.setLocation(i, j);
            
            tanque.setIcon(ObtenerRutaSprite.get("tile166.png"));
            Thread.sleep(300);
            tanque.setIcon(ObtenerRutaSprite.get("tile167.png"));
            Thread.sleep(200);
            tanque.setIcon(ObtenerRutaSprite.get("tile168.png"));
            Thread.sleep(200);
            tanque.setIcon(ObtenerRutaSprite.get("tile169.png"));
            Thread.sleep(250);
            tanque.setIcon(ObtenerRutaSprite.get("tile168.png"));
            Thread.sleep(200);
            tanque.setIcon(ObtenerRutaSprite.get("tile166.png"));
            Thread.sleep(200);
            tanque.setIcon(ObtenerRutaSprite.get("tile166.png"));
            Thread.sleep(200);
            tanque.setIcon(ObtenerRutaSprite.get("tile167.png"));
            Thread.sleep(200);
            tanque.setIcon(ObtenerRutaSprite.get("tile168.png"));
            Thread.sleep(200);
            tanque.setIcon(ObtenerRutaSprite.get("tile169.png"));
            Thread.sleep(200);
            tanque.setIcon(tanque.getTexturaPrincipalAbajo1());
            Thread.sleep(100);
            
            
        } catch (InterruptedException ex) {}
    
    
    
    }
    
    
    public void detener(){
    
        isRunning = false;
    
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
    
    
}
