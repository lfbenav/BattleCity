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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author wisfer
 */
public class VentanaPrincipal extends JFrame implements KeyListener{
        
        
    public VentanaPrincipal() 
    {
        
        this.setContentPane(new FondoPanel());
        
        initComponents();
        asignarImagenes();
        
        addKeyListener(this);
        this.setFocusable(true);

        ConfiguracionSingleton.getInstance();
        //System.out.println(ConfiguracionSingleton.getInstance().getVelocidadDisparo()+" Velocidad Disparo");
        //System.out.println(ConfiguracionSingleton.getInstance().getVelocidadMovimiento()+" Velocidad Movimiento");
        //System.out.println(ConfiguracionSingleton.getInstance().getTiempoAparicion()+" Tiempo Aparicion");
        System.out.println("Recuerda desactivar el repeat key delay para una mejor experiencia de juego");
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
                    if(lblSeleccion1.isVisible())
                    {
                        lblSeleccion1.setVisible(false);
                        lblSeleccion2.setVisible(true);
                        lblSeleccion3.setVisible(false);
                    }
                    else if(lblSeleccion2.isVisible())
                    {
                        lblSeleccion1.setVisible(false);
                        lblSeleccion2.setVisible(false);
                        lblSeleccion3.setVisible(true);
                    }
                    else if(lblSeleccion3.isVisible())
                    {
                        lblSeleccion1.setVisible(true);
                        lblSeleccion2.setVisible(false);
                        lblSeleccion3.setVisible(false);
                    }
                    break;
                    
                case 10:
                    //System.out.println("presiona enter");
                    if(lblSeleccion1.isVisible())
                    {
                        //comienza el juego
                        new VentanaJuego().setVisible(true);
                        this.dispose();
                    }
                    if(lblSeleccion2.isVisible())
                    {
                        //se va a la config
                        new VentanaConfiguracion().setVisible(true);
                        this.dispose();
                    }
                    if(lblSeleccion3.isVisible())
                    {
                        //se va a crear un mapa
                        new VentanaCrearMapa().setVisible(true);
                        this.dispose();
                    }
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
        
        label = lblTitulo;
        rutaImagen = "titulo.png";
        icono = new ImageIcon(rutaImagen);
        imagenOriginal = icono.getImage();
        imagenEscalada = imagenOriginal.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT);
        iconoEscalado = new ImageIcon(imagenEscalada);
        label.setIcon(iconoEscalado);
        
        label = lblSeleccion1;
        rutaImagen = ObtenerRutaSprite.get("tile006.png");
        icono = new ImageIcon(rutaImagen);
        imagenOriginal = icono.getImage();
        imagenEscalada = imagenOriginal.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT);
        iconoEscalado = new ImageIcon(imagenEscalada);
        label.setIcon(iconoEscalado);
        
        label = lblSeleccion2;
        rutaImagen = ObtenerRutaSprite.get("tile006.png");
        icono = new ImageIcon(rutaImagen);
        imagenOriginal = icono.getImage();
        imagenEscalada = imagenOriginal.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT);
        iconoEscalado = new ImageIcon(imagenEscalada);
        label.setIcon(iconoEscalado);
        
        label = lblSeleccion3;
        rutaImagen = ObtenerRutaSprite.get("tile006.png");
        icono = new ImageIcon(rutaImagen);
        imagenOriginal = icono.getImage();
        imagenEscalada = imagenOriginal.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT);
        iconoEscalado = new ImageIcon(imagenEscalada);
        label.setIcon(iconoEscalado);
        
        lblSeleccion2.setVisible(false);
        lblSeleccion3.setVisible(false);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnConfiguracion = new javax.swing.JButton();
        btnComenzar = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        lblSeleccion1 = new javax.swing.JLabel();
        lblSeleccion2 = new javax.swing.JLabel();
        lblCosasArriba = new javax.swing.JLabel();
        btnConstruction = new javax.swing.JButton();
        lblSeleccion3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(512, 448));
        setResizable(false);

        btnConfiguracion.setBackground(new java.awt.Color(0, 0, 0));
        btnConfiguracion.setFont(new java.awt.Font("Nintendo NES Font", 0, 15));
        btnConfiguracion.setForeground(new java.awt.Color(255, 255, 255));
        btnConfiguracion.setText("OPCIONES");
        btnConfiguracion.setBorder(null);
        btnConfiguracion.setBorderPainted(false);
        btnConfiguracion.setContentAreaFilled(false);
        btnConfiguracion.setFocusable(false);
        btnConfiguracion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        btnComenzar.setBackground(new java.awt.Color(0, 0, 0));
        btnComenzar.setFont(new java.awt.Font("Nintendo NES Font", 0, 15));
        btnComenzar.setForeground(new java.awt.Color(255, 255, 255));
        btnComenzar.setText("1 PLAYER");
        btnComenzar.setBorder(null);
        btnComenzar.setBorderPainted(false);
        btnComenzar.setContentAreaFilled(false);
        btnComenzar.setFocusable(false);
        btnComenzar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        lblTitulo.setText("titulo");
        lblTitulo.setMaximumSize(new java.awt.Dimension(365, 138));
        lblTitulo.setMinimumSize(new java.awt.Dimension(365, 138));
        lblTitulo.setPreferredSize(new java.awt.Dimension(365, 138));

        lblSeleccion1.setText("1");
        lblSeleccion1.setMaximumSize(new java.awt.Dimension(30, 30));
        lblSeleccion1.setMinimumSize(new java.awt.Dimension(30, 30));
        lblSeleccion1.setPreferredSize(new java.awt.Dimension(30, 30));

        lblSeleccion2.setText("2");
        lblSeleccion2.setMaximumSize(new java.awt.Dimension(30, 30));
        lblSeleccion2.setMinimumSize(new java.awt.Dimension(30, 30));
        lblSeleccion2.setPreferredSize(new java.awt.Dimension(30, 30));

        lblCosasArriba.setFont(new java.awt.Font("Nintendo NES Font", 0, 15));
        lblCosasArriba.setForeground(new java.awt.Color(255, 255, 255));
        lblCosasArriba.setText("I-    00  HI-    00");
        lblCosasArriba.setMaximumSize(new java.awt.Dimension(365, 33));
        lblCosasArriba.setMinimumSize(new java.awt.Dimension(365, 33));
        lblCosasArriba.setPreferredSize(new java.awt.Dimension(365, 33));

        btnConstruction.setBackground(new java.awt.Color(0, 0, 0));
        btnConstruction.setFont(new java.awt.Font("Nintendo NES Font", 0, 15));
        btnConstruction.setForeground(new java.awt.Color(255, 255, 255));
        btnConstruction.setText("CONSTRUCTION");
        btnConstruction.setBorder(null);
        btnConstruction.setBorderPainted(false);
        btnConstruction.setContentAreaFilled(false);
        btnConstruction.setFocusable(false);
        btnConstruction.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        lblSeleccion3.setText("3");
        lblSeleccion3.setMaximumSize(new java.awt.Dimension(30, 30));
        lblSeleccion3.setMinimumSize(new java.awt.Dimension(30, 30));
        lblSeleccion3.setPreferredSize(new java.awt.Dimension(30, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblCosasArriba, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblSeleccion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSeleccion2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSeleccion3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnConstruction, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnComenzar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnConfiguracion, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(130, 130, 130))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCosasArriba, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnComenzar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSeleccion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfiguracion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSeleccion2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConstruction, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSeleccion3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(142, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComenzar;
    private javax.swing.JButton btnConfiguracion;
    private javax.swing.JButton btnConstruction;
    private javax.swing.JLabel lblCosasArriba;
    private javax.swing.JLabel lblSeleccion1;
    private javax.swing.JLabel lblSeleccion2;
    private javax.swing.JLabel lblSeleccion3;
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
