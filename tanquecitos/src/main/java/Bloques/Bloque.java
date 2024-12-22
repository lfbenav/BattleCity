/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bloques;

import Elementos.ObtenerRutaSprite;
import Ventanas.VentanaJuego;
import java.awt.Image;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author wisfer
 */
public abstract class Bloque implements Serializable{
    private int vida;
    private boolean puedenPasarTanques;
    private boolean puedenPasarBalas;
    private boolean indestructible;
    
    String textura;
    
    JLabel bloqueLabel;
    
    public static final int size = 48;

    public Bloque() {    
        bloqueLabel = new JLabel();
        bloqueLabel.setBackground(new java.awt.Color(204, 255, 153));
        bloqueLabel.setForeground(new java.awt.Color(255, 51, 51));
        bloqueLabel.setText("-[]-");
        bloqueLabel.setMaximumSize(new java.awt.Dimension(size, size));
        bloqueLabel.setMinimumSize(new java.awt.Dimension(size, size));
        bloqueLabel.setPreferredSize(new java.awt.Dimension(size, size));
        bloqueLabel.setSize(new java.awt.Dimension(size, size));
        
        setIcon(ObtenerRutaSprite.get("error.jpeg"));
    }
    
    public abstract String getInfo();
    
    public abstract String getTipo();
    
    public void recibirDano(VentanaJuego ventana){
        vida = vida-1;
        if(vida<=0){
            ventana.pnlJuego.revalidate();
            setIcon(ObtenerRutaSprite.get("tile021.png"));
            try {
                Thread.sleep(2);
            } catch (InterruptedException ex) {}
            ventana.pnlJuego.remove(bloqueLabel);
            ventana.mapa.remove(this);
            ventana.pnlJuego.revalidate();
            
        }
    
    }
    
    public void setIcon(String rutaImagen)
    {
        JLabel label = this.bloqueLabel;
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

    public boolean isPuedenPasarTanques() {
        return puedenPasarTanques;
    }

    public void setPuedenPasarTanques(boolean puedenPasarTanques) {
        this.puedenPasarTanques = puedenPasarTanques;
    }

    public boolean isPuedenPasarBalas() {
        return puedenPasarBalas;
    }

    public void setPuedenPasarBalas(boolean puedenPasarBalas) {
        this.puedenPasarBalas = puedenPasarBalas;
    }

    public String getTextura() {
        return textura;
    }

    public void setTextura(String textura) {
        this.textura = textura;
    }

    public JLabel getBloqueLabel() {
        return bloqueLabel;
    }

    public void setBloqueLabel(JLabel bloqueLabel) {
        this.bloqueLabel = bloqueLabel;
    }

    public boolean isIndestructible() {
        return indestructible;
    }

    public void setIndestructible(boolean indestructible) {
        this.indestructible = indestructible;
    }
    
    
    
}
