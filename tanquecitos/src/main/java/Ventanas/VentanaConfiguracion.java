/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package Ventanas;

import Elementos.ObtenerRutaSprite;
import Elementos.ConfiguracionSingleton;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author wisfer
 */
public class VentanaConfiguracion extends javax.swing.JFrame implements KeyListener{
    
    ConfiguracionSingleton config;
    
    public VentanaConfiguracion() {
        this.setContentPane(new FondoPanel());
        initComponents();
        asignarImagenes();
        
        addKeyListener(this);
        this.setFocusable(true);

        config = ConfiguracionSingleton.getInstance();
        
        lblDisparo.setText(config.getVelocidadDisparo()+"");
        lblMovimiento.setText(config.getVelocidadMovimiento()+"");
        lblAparicion.setText(config.getTiempoAparicion()+"");
    }

    @Override
    public void keyTyped(KeyEvent ke) 
    {}

    @Override
    public void keyPressed(KeyEvent ke) 
    {
        int opcion = ke.getKeyCode();
        switch(opcion)
        {
                case 16:
                    //System.out.println("presiona shift");
                    
                    if(opcionDisparo.isVisible())
                    {
                        opcionDisparo.setVisible(false);
                        opcionMovimiento.setVisible(true);
                        opcionSpawn.setVisible(false);
                    }  
                    else if(opcionMovimiento.isVisible())
                    {
                        opcionDisparo.setVisible(false);
                        opcionMovimiento.setVisible(false);
                        opcionSpawn.setVisible(true);
                    }  
                    else if(opcionSpawn.isVisible())
                    {
                        opcionDisparo.setVisible(true);
                        opcionMovimiento.setVisible(false);
                        opcionSpawn.setVisible(false);
                    }
                    break;
                    
                case 38:
                    //System.out.println("presiona arriba");
                    if(opcionDisparo.isVisible())
                    {
                        config.setVelocidadDisparo((float)(config.getVelocidadDisparo()+0.5));
                        lblDisparo.setText(config.getVelocidadDisparo()+"");
                    }  
                    if(opcionMovimiento.isVisible())
                    {
                        config.setVelocidadMovimiento((float)(config.getVelocidadMovimiento()+0.5));
                        lblMovimiento.setText(config.getVelocidadMovimiento()+"");
                    }  
                    if(opcionSpawn.isVisible())
                    {
                        config.setTiempoAparicion((float)(config.getTiempoAparicion()+0.5));
                        lblAparicion.setText(config.getTiempoAparicion()+"");
                    }
                    break;
                    
                    
                case 40:
                    //System.out.println("presiona abajo");
                    if(opcionDisparo.isVisible())
                    {
                        if(config.getVelocidadDisparo()==1)
                            break;
                        config.setVelocidadDisparo((float)(config.getVelocidadDisparo()-0.5));
                        lblDisparo.setText(config.getVelocidadDisparo()+"");
                    }  
                    if(opcionMovimiento.isVisible())
                    {
                        if(config.getVelocidadMovimiento()==0.5)
                            break;
                        config.setVelocidadMovimiento((float)(config.getVelocidadMovimiento()-0.5));
                        lblMovimiento.setText(config.getVelocidadMovimiento()+"");
                    }  
                    if(opcionSpawn.isVisible())
                    {
                        if(config.getTiempoAparicion()==0.5)
                            break;
                        config.setTiempoAparicion((float)(config.getTiempoAparicion()-0.5));
                        lblAparicion.setText(config.getTiempoAparicion()+"");
                    }
                    break;
                 
                    
                case 10:
                    //System.out.println("presiona enter");
                    new VentanaPrincipal().setVisible(true);
                    this.dispose();
                    break;
          
                default:
                    break;          
        }
    }
    
    @Override
    public void keyReleased(KeyEvent ke) 
    {}
    
    
    
    
    
    
    private void asignarImagenes()
    {
        JLabel label;
        String rutaImagen;
        ImageIcon icono;
        Image imagenOriginal;
        Image imagenEscalada;
        ImageIcon iconoEscalado;
        
        label = opcionDisparo;
        rutaImagen = ObtenerRutaSprite.get("tile006.png");
        icono = new ImageIcon(rutaImagen);
        imagenOriginal = icono.getImage();
        imagenEscalada = imagenOriginal.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT);
        iconoEscalado = new ImageIcon(imagenEscalada);
        label.setIcon(iconoEscalado);
        
        label = opcionMovimiento;
        rutaImagen = ObtenerRutaSprite.get("tile006.png");
        icono = new ImageIcon(rutaImagen);
        imagenOriginal = icono.getImage();
        imagenEscalada = imagenOriginal.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT);
        iconoEscalado = new ImageIcon(imagenEscalada);
        label.setIcon(iconoEscalado);
        
        label = opcionSpawn;
        rutaImagen = ObtenerRutaSprite.get("tile006.png");
        icono = new ImageIcon(rutaImagen);
        imagenOriginal = icono.getImage();
        imagenEscalada = imagenOriginal.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT);
        iconoEscalado = new ImageIcon(imagenEscalada);
        label.setIcon(iconoEscalado);
        
        opcionMovimiento.setVisible(false);
        opcionSpawn.setVisible(false);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnComenzar = new javax.swing.JButton();
        btnVelocidadDisparo = new javax.swing.JButton();
        btnVelocidadMovimiento = new javax.swing.JButton();
        btnTiempoAparicion = new javax.swing.JButton();
        btnComenzar1 = new javax.swing.JButton();
        lblAparicion = new javax.swing.JLabel();
        lblDisparo = new javax.swing.JLabel();
        lblMovimiento = new javax.swing.JLabel();
        opcionSpawn = new javax.swing.JLabel();
        opcionDisparo = new javax.swing.JLabel();
        opcionMovimiento = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(512, 448));

        btnComenzar.setBackground(new java.awt.Color(0, 0, 0));
        btnComenzar.setFont(new java.awt.Font("Nintendo NES Font", 0, 15));
        btnComenzar.setForeground(new java.awt.Color(204, 51, 0));
        btnComenzar.setText("CONFIGURACION");
        btnComenzar.setBorder(null);
        btnComenzar.setBorderPainted(false);
        btnComenzar.setContentAreaFilled(false);
        btnComenzar.setFocusable(false);

        btnVelocidadDisparo.setBackground(new java.awt.Color(0, 0, 0));
        btnVelocidadDisparo.setFont(new java.awt.Font("Nintendo NES Font", 0, 15));
        btnVelocidadDisparo.setForeground(new java.awt.Color(255, 255, 255));
        btnVelocidadDisparo.setText(" DISPARO:    ");
        btnVelocidadDisparo.setBorder(null);
        btnVelocidadDisparo.setBorderPainted(false);
        btnVelocidadDisparo.setContentAreaFilled(false);
        btnVelocidadDisparo.setFocusable(false);
        btnVelocidadDisparo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnVelocidadDisparo.setMaximumSize(new java.awt.Dimension(224, 35));
        btnVelocidadDisparo.setMinimumSize(new java.awt.Dimension(224, 35));
        btnVelocidadDisparo.setPreferredSize(new java.awt.Dimension(224, 35));
        btnVelocidadDisparo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVelocidadDisparoActionPerformed(evt);
            }
        });

        btnVelocidadMovimiento.setBackground(new java.awt.Color(0, 0, 0));
        btnVelocidadMovimiento.setFont(new java.awt.Font("Nintendo NES Font", 0, 15));
        btnVelocidadMovimiento.setForeground(new java.awt.Color(255, 255, 255));
        btnVelocidadMovimiento.setText(" MOVIMIENTO: ");
        btnVelocidadMovimiento.setBorder(null);
        btnVelocidadMovimiento.setBorderPainted(false);
        btnVelocidadMovimiento.setContentAreaFilled(false);
        btnVelocidadMovimiento.setFocusable(false);
        btnVelocidadMovimiento.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnVelocidadMovimiento.setMaximumSize(new java.awt.Dimension(224, 35));
        btnVelocidadMovimiento.setMinimumSize(new java.awt.Dimension(224, 35));
        btnVelocidadMovimiento.setPreferredSize(new java.awt.Dimension(224, 35));
        btnVelocidadMovimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVelocidadMovimientoActionPerformed(evt);
            }
        });

        btnTiempoAparicion.setBackground(new java.awt.Color(0, 0, 0));
        btnTiempoAparicion.setFont(new java.awt.Font("Nintendo NES Font", 0, 15));
        btnTiempoAparicion.setForeground(new java.awt.Color(255, 255, 255));
        btnTiempoAparicion.setText(" SPAWN:      ");
        btnTiempoAparicion.setBorder(null);
        btnTiempoAparicion.setBorderPainted(false);
        btnTiempoAparicion.setContentAreaFilled(false);
        btnTiempoAparicion.setFocusable(false);
        btnTiempoAparicion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnTiempoAparicion.setMaximumSize(new java.awt.Dimension(224, 35));
        btnTiempoAparicion.setMinimumSize(new java.awt.Dimension(224, 35));
        btnTiempoAparicion.setPreferredSize(new java.awt.Dimension(224, 35));
        btnTiempoAparicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTiempoAparicionActionPerformed(evt);
            }
        });

        btnComenzar1.setBackground(new java.awt.Color(0, 0, 0));
        btnComenzar1.setFont(new java.awt.Font("Nintendo NES Font", 0, 15));
        btnComenzar1.setForeground(new java.awt.Color(204, 51, 0));
        btnComenzar1.setText(" VELOCIDADES");
        btnComenzar1.setBorder(null);
        btnComenzar1.setBorderPainted(false);
        btnComenzar1.setContentAreaFilled(false);
        btnComenzar1.setFocusable(false);
        btnComenzar1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnComenzar1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        lblAparicion.setFont(new java.awt.Font("Nintendo NES Font", 0, 15));
        lblAparicion.setForeground(new java.awt.Color(255, 153, 0));
        lblAparicion.setText("1");
        lblAparicion.setMaximumSize(new java.awt.Dimension(60, 35));
        lblAparicion.setMinimumSize(new java.awt.Dimension(60, 35));
        lblAparicion.setPreferredSize(new java.awt.Dimension(60, 35));

        lblDisparo.setFont(new java.awt.Font("Nintendo NES Font", 0, 15));
        lblDisparo.setForeground(new java.awt.Color(255, 153, 0));
        lblDisparo.setText("1");
        lblDisparo.setMaximumSize(new java.awt.Dimension(60, 35));
        lblDisparo.setMinimumSize(new java.awt.Dimension(60, 35));
        lblDisparo.setPreferredSize(new java.awt.Dimension(60, 35));

        lblMovimiento.setFont(new java.awt.Font("Nintendo NES Font", 0, 15));
        lblMovimiento.setForeground(new java.awt.Color(255, 153, 0));
        lblMovimiento.setText("1");
        lblMovimiento.setMaximumSize(new java.awt.Dimension(60, 35));
        lblMovimiento.setMinimumSize(new java.awt.Dimension(60, 35));
        lblMovimiento.setPreferredSize(new java.awt.Dimension(60, 35));

        opcionSpawn.setForeground(new java.awt.Color(204, 255, 255));
        opcionSpawn.setText("3");
        opcionSpawn.setMaximumSize(new java.awt.Dimension(30, 30));
        opcionSpawn.setMinimumSize(new java.awt.Dimension(30, 30));
        opcionSpawn.setPreferredSize(new java.awt.Dimension(30, 30));

        opcionDisparo.setForeground(new java.awt.Color(204, 255, 255));
        opcionDisparo.setText("1");
        opcionDisparo.setMaximumSize(new java.awt.Dimension(30, 30));
        opcionDisparo.setMinimumSize(new java.awt.Dimension(30, 30));
        opcionDisparo.setPreferredSize(new java.awt.Dimension(30, 30));

        opcionMovimiento.setForeground(new java.awt.Color(204, 255, 255));
        opcionMovimiento.setText("2");
        opcionMovimiento.setMaximumSize(new java.awt.Dimension(30, 30));
        opcionMovimiento.setMinimumSize(new java.awt.Dimension(30, 30));
        opcionMovimiento.setPreferredSize(new java.awt.Dimension(30, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnComenzar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnComenzar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(opcionSpawn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(opcionMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(opcionDisparo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnTiempoAparicion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnVelocidadMovimiento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnVelocidadDisparo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAparicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDisparo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnComenzar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnComenzar1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVelocidadDisparo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDisparo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opcionDisparo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVelocidadMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opcionMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTiempoAparicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAparicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opcionSpawn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(157, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVelocidadDisparoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVelocidadDisparoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVelocidadDisparoActionPerformed

    private void btnVelocidadMovimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVelocidadMovimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVelocidadMovimientoActionPerformed

    private void btnTiempoAparicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTiempoAparicionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTiempoAparicionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComenzar;
    private javax.swing.JButton btnComenzar1;
    private javax.swing.JButton btnTiempoAparicion;
    private javax.swing.JButton btnVelocidadDisparo;
    private javax.swing.JButton btnVelocidadMovimiento;
    private javax.swing.JLabel lblAparicion;
    private javax.swing.JLabel lblDisparo;
    private javax.swing.JLabel lblMovimiento;
    private javax.swing.JLabel opcionDisparo;
    private javax.swing.JLabel opcionMovimiento;
    private javax.swing.JLabel opcionSpawn;
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
