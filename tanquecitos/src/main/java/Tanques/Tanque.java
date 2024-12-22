/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tanques;

import Comandos.InvocadorInstance;
import Comodines.Comodin;
import Comodines.ComodinFactory;
import Elementos.ObtenerRutaSprite;
import Elementos.PuntuacionSingleton;
import Threads.ThreadComodinDesaparecer;
import Threads.ThreadTanque;
import Ventanas.VentanaJuego;
import java.awt.Image;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author wisfer
 */
public abstract class Tanque {
    private int vida;
    private double velocidadMovimiento;
    private double velocidadDisparo;
    private boolean especial = false;
    
    String texturaPrincipalArriba1;
    String texturaPrincipalAbajo1;
    String texturaPrincipalIzquierda1;
    String texturaPrincipalDerecha1;
    
    String texturaPrincipalArriba2;
    String texturaPrincipalAbajo2;
    String texturaPrincipalIzquierda2;
    String texturaPrincipalDerecha2;
    
    String texturaEspecialArriba;
    String texturaEspecialAbajo;
    String texturaEspecialIzquierda;
    String texturaEspecialDerecha;
    
    JLabel tanqueLabel;
    
    public static final int size = 40;                                          //Por defecto es 48, tambien es el maximo
    
    public static final int ARRIBA = 1;
    public static final int ABAJO = 2;
    public static final int IZQUIERDA = 3;
    public static final int DERECHA = 4;
    
    public int direccion;
    
    private int cooldown;
    private boolean puedeDisparar = true;
    
    public boolean estaEnRojo = false;
    
    public ThreadTanque thread;
    
    public Tanque(boolean especial){
        this.direccion = new Random().nextInt(4 - 1 + 1) + 1;
        setEspecial(especial);
        tanqueLabel = new JLabel();
        tanqueLabel.setBackground(new java.awt.Color(49, 49, 49));
        tanqueLabel.setForeground(new java.awt.Color(49, 49, 49));
        tanqueLabel.setText("-+-");
        tanqueLabel.setMaximumSize(new java.awt.Dimension(size, size));
        tanqueLabel.setMinimumSize(new java.awt.Dimension(size, size));
        tanqueLabel.setPreferredSize(new java.awt.Dimension(size, size));
        tanqueLabel.setSize(new java.awt.Dimension(size, size));
        
        setIcon(ObtenerRutaSprite.get("error.jpeg"));
    }
    
    public abstract void moverse();
    
    public abstract void disparar();

    public abstract String getInfo();
        
    public void recibirDano(VentanaJuego ventana){
        this.vida = this.vida-1;
        
        if(this.vida<=0){
            
            
            if(this.especial){
                thread.isRunning = false;

                ComodinFactory fabrica = new ComodinFactory();
                Comodin comodinNuevo = fabrica.generarComodin();
                comodinNuevo.colocar(ventana);
                
                ThreadComodinDesaparecer threadComodin = new ThreadComodinDesaparecer(ventana, comodinNuevo);
                threadComodin.start();
                
            }
            
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
                setIcon(ObtenerRutaSprite.get("tile268.png"));
                Thread.sleep(200);
                setIcon(ObtenerRutaSprite.get("tile021.png"));
                Thread.sleep(100);
            } catch (InterruptedException ex) {}
            
            ventana.pnlJuego.remove(tanqueLabel);
            ventana.pnlJuego.revalidate();
            
            ventana.sumarTanqueDestruido();
            if(getTipo().equals("Simple")){
                PuntuacionSingleton.getInstance().setSimples(PuntuacionSingleton.getInstance().getSimples()+1);
            }
            if(getTipo().equals("Reforzado")){
                PuntuacionSingleton.getInstance().setReforzados(PuntuacionSingleton.getInstance().getReforzados()+1);
            }
            if(getTipo().equals("Rapido")){
                PuntuacionSingleton.getInstance().setRapidos(PuntuacionSingleton.getInstance().getRapidos()+1);
            }
            if(getTipo().equals("Fuerte")){
                PuntuacionSingleton.getInstance().setFuertes(PuntuacionSingleton.getInstance().getFuertes()+1);
            }
            
            
            
            if(ventana.tanques.isEmpty()&&ventana.enemigosRestantes==0){
                System.out.println("Ganaste");
                ventana.ganar();
            }
        }
        
    }
    
    public String getEquipo(){
        return "Malo";
    
    }
    
    public abstract String getTipo();
    
    public void setIcon(String rutaImagen)
    {
        JLabel label = this.tanqueLabel;
        ImageIcon icono = new ImageIcon(rutaImagen);
        Image imagenOriginal = icono.getImage();
        Image imagenEscalada = imagenOriginal.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT);
        ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);
        label.setIcon(iconoEscalado);
    }
    
    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public double getVelocidadMovimiento() {
        return velocidadMovimiento;
    }

    public void setVelocidadMovimiento(double velocidadMovimiento) {
        this.velocidadMovimiento = velocidadMovimiento;
    }

    public double getVelocidadDisparo() {
        return velocidadDisparo;
    }

    public void setVelocidadDisparo(double velocidadDisparo) {
        this.velocidadDisparo = velocidadDisparo;
    }

    public boolean isEspecial() {
        return especial;
    }

    public void setEspecial(boolean especial) {
        this.especial = especial;
    }

    public String getTexturaEspecialArriba() {
        return texturaEspecialArriba;
    }

    public void setTexturaEspecialArriba(String texturaEspecialArriba) {
        this.texturaEspecialArriba = texturaEspecialArriba;
    }

    public String getTexturaEspecialAbajo() {
        return texturaEspecialAbajo;
    }

    public void setTexturaEspecialAbajo(String texturaEspecialAbajo) {
        this.texturaEspecialAbajo = texturaEspecialAbajo;
    }

    public String getTexturaEspecialIzquierda() {
        return texturaEspecialIzquierda;
    }

    public void setTexturaEspecialIzquierda(String texturaEspecialIzquierda) {
        this.texturaEspecialIzquierda = texturaEspecialIzquierda;
    }

    public String getTexturaEspecialDerecha() {
        return texturaEspecialDerecha;
    }

    public void setTexturaEspecialDerecha(String texturaEspecialDerecha) {
        this.texturaEspecialDerecha = texturaEspecialDerecha;
    }

    public JLabel getTanqueLabel() {
        return tanqueLabel;
    }

    public void setTanqueLabel(JLabel tanqueLabel) {
        this.tanqueLabel = tanqueLabel;
    }

    public String getTexturaPrincipalArriba1() {
        return texturaPrincipalArriba1;
    }

    public void setTexturaPrincipalArriba1(String texturaPrincipalArriba1) {
        this.texturaPrincipalArriba1 = texturaPrincipalArriba1;
    }

    public String getTexturaPrincipalAbajo1() {
        return texturaPrincipalAbajo1;
    }

    public void setTexturaPrincipalAbajo1(String texturaPrincipalAbajo1) {
        this.texturaPrincipalAbajo1 = texturaPrincipalAbajo1;
    }

    public String getTexturaPrincipalIzquierda1() {
        return texturaPrincipalIzquierda1;
    }

    public void setTexturaPrincipalIzquierda1(String texturaPrincipalIzquierda1) {
        this.texturaPrincipalIzquierda1 = texturaPrincipalIzquierda1;
    }

    public String getTexturaPrincipalDerecha1() {
        return texturaPrincipalDerecha1;
    }

    public void setTexturaPrincipalDerecha1(String texturaPrincipalDerecha1) {
        this.texturaPrincipalDerecha1 = texturaPrincipalDerecha1;
    }

    public String getTexturaPrincipalArriba2() {
        return texturaPrincipalArriba2;
    }

    public void setTexturaPrincipalArriba2(String texturaPrincipalArriba2) {
        this.texturaPrincipalArriba2 = texturaPrincipalArriba2;
    }

    public String getTexturaPrincipalAbajo2() {
        return texturaPrincipalAbajo2;
    }

    public void setTexturaPrincipalAbajo2(String texturaPrincipalAbajo2) {
        this.texturaPrincipalAbajo2 = texturaPrincipalAbajo2;
    }

    public String getTexturaPrincipalIzquierda2() {
        return texturaPrincipalIzquierda2;
    }

    public void setTexturaPrincipalIzquierda2(String texturaPrincipalIzquierda2) {
        this.texturaPrincipalIzquierda2 = texturaPrincipalIzquierda2;
    }

    public String getTexturaPrincipalDerecha2() {
        return texturaPrincipalDerecha2;
    }

    public void setTexturaPrincipalDerecha2(String texturaPrincipalDerecha2) {
        this.texturaPrincipalDerecha2 = texturaPrincipalDerecha2;
    }

    public int getDireccion() {
        return direccion;
    }

    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }

    public int getCooldown() {
        return cooldown;
    }

    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }

    public boolean isPuedeDisparar() {
        return puedeDisparar;
    }

    public void setPuedeDisparar(boolean puedeDisparar) {
        this.puedeDisparar = puedeDisparar;
    }
    
    
    
    

    
    
}
