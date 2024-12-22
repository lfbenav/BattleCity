/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comodines;

import Bloques.Bloque;
import Elementos.ObtenerRutaSprite;
import Tanques.Tanque;
import Threads.ThreadComodinDesaparecer;
import Ventanas.VentanaJuego;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author wisfer
 */
public abstract class Comodin {
    
    public static final int SIZE = 44;
    JLabel label;
    public boolean recogido = false;
    
    public Comodin(){
    
        label = new JLabel();
        label.setBackground(new java.awt.Color(48, 48, 48));
        label.setForeground(new java.awt.Color(255, 51, 51));
        label.setText("-O-");
        label.setMaximumSize(new java.awt.Dimension(SIZE, SIZE));
        label.setMinimumSize(new java.awt.Dimension(SIZE, SIZE));
        label.setPreferredSize(new java.awt.Dimension(SIZE, SIZE));
        label.setSize(new java.awt.Dimension(SIZE, SIZE));
        label.setDoubleBuffered(true);
        
        setIcon(ObtenerRutaSprite.get("error.jpeg"));
        
    }
        
    public void setIcon(String rutaImagen)
    {
        ImageIcon icono = new ImageIcon(rutaImagen);
        Image imagenOriginal = icono.getImage();
        Image imagenEscalada = imagenOriginal.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT);
        ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);
        label.setIcon(iconoEscalado);
        
    }
        
    public abstract void efecto(Tanque jugador, VentanaJuego ventana);
    
    public abstract String getTipo();
    
    public void colocar(VentanaJuego ventana){
        boolean colocado = false;
        boolean ocupado = false;

        while(!colocado){

            int i = new Random().nextInt(ventana.panelSize-SIZE-1);
            int j = new Random().nextInt(ventana.panelSize-SIZE-1);
            
            if(ventana.pnlJuego.getComponentAt(i, j)==ventana.pnlJuego){
                ocupado = false;
                Point izquierdaArriba = new Point(i,j);
                Point izquierdaAbajo = new Point(i,j+SIZE-1);
                Point derechaArriba = new Point(i+SIZE-1,j);
                Point derechaAbajo = new Point(i+SIZE-1,j+SIZE-1);

                ArrayList<Point> esquinas = new ArrayList<Point>();
                esquinas.add(izquierdaArriba);
                esquinas.add(izquierdaAbajo);
                esquinas.add(derechaArriba);
                esquinas.add(derechaAbajo);

                for(Point punto : esquinas){

                    int X = punto.x;
                    int Y = punto.y;

                    if(ventana.pnlJuego.getComponentAt(X, Y)!=ventana.pnlJuego){
                        if(encontrarBloque((JLabel)ventana.pnlJuego.getComponentAt(X, Y),ventana.mapa)!=null){
                            ocupado=true;
                            break;
                        }
                    }

                }

                if(!ocupado){
                    ventana.pnlJuego.add(label);
                    label.setLocation(i, j);
                    ventana.comodinesEnJuego.add(this);
                    //System.out.println("coloca en "+ i +", "+ j);
                    break;
                }


            }

        }

    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public abstract void desaparecer(VentanaJuego ventana);

    private Bloque encontrarBloque(JLabel label, ArrayList<Bloque> mapa){
        for(Bloque bloque : mapa){
            
            if(bloque.getBloqueLabel()==label)
                return bloque;
        
        }
        return null;
    }
}
