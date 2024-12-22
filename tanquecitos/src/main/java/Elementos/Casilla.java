/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Elementos;

import Bloques.Bloque;
import Tanques.Tanque;
import javax.swing.JLabel;

/**
 *
 * @author wisfer
 */
public class Casilla {
    int x;
    int y;
    Bloque ocupadoPorBloque;
    JLabel label;

    public Casilla(int x, int y) {
        this.x = x;
        this.y = y;
        
        label = new JLabel();
        label.setBackground(new java.awt.Color(0, 0, 0,0));
        label.setForeground(new java.awt.Color(1, 1, 1));
        label.setMaximumSize(new java.awt.Dimension(48, 48));
        label.setMinimumSize(new java.awt.Dimension(48, 48));
        label.setPreferredSize(new java.awt.Dimension(48, 48));
        label.setSize(new java.awt.Dimension(48, 48));
        label.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40,40,40), 1, false));  //BORRAR ESTA LINEA
        label.setEnabled(false);
    }

    @Override
    public String toString() {
        if(ocupadoPorBloque!=null)
            return "Casilla{" + "x=" + x + ", y=" + y + ", ocupadoPorBloque=" + ocupadoPorBloque.getInfo() + '}';
        return "Casilla{" + "x=" + x + ", y=" + y+ '}';
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Bloque getOcupadoPorBloque() {
        return ocupadoPorBloque;
    }

    public void setOcupadoPorBloque(Bloque ocupadoPorBloque) {
        this.ocupadoPorBloque = ocupadoPorBloque;
    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }
    
    
}
