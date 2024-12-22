/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Ventanas;

import Elementos.ObtenerRutaSprite;
import Elementos.ConfiguracionSingleton;
import Elementos.PuntuacionSingleton;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author wisfer
 */
public class VentanaFinal extends JFrame{
        
    int puntuacionFinal;
        
    public VentanaFinal() 
    {
        
        this.setContentPane(new FondoPanel());
        
        initComponents();
        
        puntuacionFinal = PuntuacionSingleton.getInstance().getPuntuacion();
        btnPuntuacion.setText(puntuacionFinal+"");
        
        asignarImagenes();
        
        this.setFocusable(true);


        
            
    }
    
    
    private void asignarImagenes()
    {
        JLabel label;
        String rutaImagen;
        ImageIcon icono;
        Image imagenOriginal;
        Image imagenEscalada;
        ImageIcon iconoEscalado;
        
        label = lblTitulo;
        
        if(puntuacionFinal<10000){
            //final malo
            btnRes.setText("FINAL MALO");
            rutaImagen = ObtenerRutaSprite.get("final.jpg");
            
        }else{
            //final bueno
            btnRes.setText("FINAL BUENO");
            rutaImagen = ObtenerRutaSprite.get("tankyou.png");
        }
        

        icono = new ImageIcon(rutaImagen);
        imagenOriginal = icono.getImage();
        imagenEscalada = imagenOriginal.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT);
        iconoEscalado = new ImageIcon(imagenEscalada);
        label.setIcon(iconoEscalado);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnComenzar = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        lblCosasArriba = new javax.swing.JLabel();
        btnPuntuacion = new javax.swing.JButton();
        btnRes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(512, 448));
        setPreferredSize(new java.awt.Dimension(400, 389));
        setResizable(false);

        btnComenzar.setBackground(new java.awt.Color(0, 0, 0));
        btnComenzar.setFont(new java.awt.Font("Nintendo NES Font", 0, 15));
        btnComenzar.setForeground(new java.awt.Color(255, 0, 0));
        btnComenzar.setText("SCORE");
        btnComenzar.setBorder(null);
        btnComenzar.setBorderPainted(false);
        btnComenzar.setContentAreaFilled(false);
        btnComenzar.setFocusable(false);
        btnComenzar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        lblTitulo.setText("titulo");
        lblTitulo.setMaximumSize(new java.awt.Dimension(365, 138));
        lblTitulo.setMinimumSize(new java.awt.Dimension(365, 138));
        lblTitulo.setPreferredSize(new java.awt.Dimension(365, 138));

        lblCosasArriba.setFont(new java.awt.Font("Nintendo NES Font", 0, 15));
        lblCosasArriba.setForeground(new java.awt.Color(255, 255, 255));
        lblCosasArriba.setText("I-    00  HI-    00");
        lblCosasArriba.setMaximumSize(new java.awt.Dimension(365, 33));
        lblCosasArriba.setMinimumSize(new java.awt.Dimension(365, 33));
        lblCosasArriba.setPreferredSize(new java.awt.Dimension(365, 33));

        btnPuntuacion.setBackground(new java.awt.Color(255, 153, 0));
        btnPuntuacion.setFont(new java.awt.Font("Nintendo NES Font", 0, 15));
        btnPuntuacion.setForeground(new java.awt.Color(255, 153, 0));
        btnPuntuacion.setText("SCORE");
        btnPuntuacion.setBorder(null);
        btnPuntuacion.setBorderPainted(false);
        btnPuntuacion.setContentAreaFilled(false);
        btnPuntuacion.setFocusable(false);
        btnPuntuacion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        btnRes.setBackground(new java.awt.Color(0, 0, 0));
        btnRes.setFont(new java.awt.Font("Nintendo NES Font", 0, 15));
        btnRes.setForeground(new java.awt.Color(255, 255, 255));
        btnRes.setText("YOU WON");
        btnRes.setBorder(null);
        btnRes.setBorderPainted(false);
        btnRes.setContentAreaFilled(false);
        btnRes.setFocusable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(57, Short.MAX_VALUE)
                        .addComponent(lblCosasArriba, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(130, 130, 130))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(2, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnComenzar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPuntuacion, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCosasArriba, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRes, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnComenzar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPuntuacion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(179, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComenzar;
    private javax.swing.JButton btnPuntuacion;
    private javax.swing.JButton btnRes;
    private javax.swing.JLabel lblCosasArriba;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables

    class FondoPanel extends JPanel
    {
        private Image imagen;
        
        @Override
        public void paint(Graphics g)
        {
            imagen = new ImageIcon("negro.png").getImage();
            g.drawImage(imagen,0, 0, getWidth(), getHeight(),this);
            setOpaque(false);
            
            super.paint(g);
        }
    }
}
