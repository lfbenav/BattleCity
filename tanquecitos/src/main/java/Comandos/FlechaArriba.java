/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comandos;

import Bloques.Bloque;
import Comodines.Comodin;
import Elementos.ConfiguracionSingleton;
import Tanques.Jugador;
import Tanques.Tanque;
import Ventanas.VentanaJuego;
import java.awt.Component;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JLabel;

/**
 *
 * @author wisfer
 */
public class FlechaArriba extends Comando{
    
    Tanque jugador;

    public FlechaArriba(Tanque jugador) {
        this.jugador = jugador;
    }
    
    @Override
    public String getCommandName() {
        return "FlechaArriba";
    }

    @Override
    public void execute(VentanaJuego ventana) {
        
        jugador.direccion = Tanque.ARRIBA;
        
        double velocidad = jugador.getVelocidadMovimiento();
        
        int tankSize = Tanque.size;
        
        Component validacion;
        JLabel labelJugador = jugador.getTanqueLabel();

        Point izquierdaArriba = new Point(labelJugador.getX(),labelJugador.getY());
        Point izquierdaAbajo = new Point(labelJugador.getX(),labelJugador.getY()+tankSize-1);
        Point derechaArriba = new Point(labelJugador.getX()+tankSize-1,labelJugador.getY());
        Point derechaAbajo = new Point(labelJugador.getX()+tankSize-1,labelJugador.getY()+tankSize-1);

        ArrayList<Point> esquinas = new ArrayList<Point>();
        esquinas.add(izquierdaArriba);
        esquinas.add(izquierdaAbajo);
        esquinas.add(derechaArriba);
        esquinas.add(derechaAbajo);
        
        
        jugador.setIcon(jugador.getTexturaPrincipalArriba1());
        try{
            for(Point esquina : esquinas){
                int X = esquina.x;
                int Y = (int)(esquina.y-velocidad);

                if(Y<0){
                    return;
                }

                validacion = ventana.pnlJuego.getComponentAt(X,Y);
                if(validacion!=ventana.pnlJuego && validacion!=labelJugador){
                    Bloque bloqueEncontrado = encontrarBloque((JLabel)(validacion),ventana.mapa);

                    if(validacion.getBackground().getRed()==50)
                        return;
                    
                    if(validacion.getBackground().getRed()==51)
                        return;
                    
                    if(validacion.getBackground().getRed()==48){
                        if(!jugador.getTipo().equals("Jugador")){
                            return;
                        }
                        Comodin comodin = ventana.encontrarComodin((JLabel)validacion);
                        if(comodin!=null)
                            comodin.efecto(jugador, ventana);
                        return;
                    }

                    if(!bloqueEncontrado.isPuedenPasarTanques())
                        return;

                }

            }
            labelJugador.setLocation(labelJugador.getX(), (int)(labelJugador.getY()-velocidad));
        }catch(NullPointerException | ArrayIndexOutOfBoundsException  error){}
            
    }
    
    private Bloque encontrarBloque(JLabel label, ArrayList<Bloque> mapa){
        for(Bloque bloque : mapa){
            
            if(bloque.getBloqueLabel()==label)
                return bloque;
        
        }
        return null;
    }
    
}
