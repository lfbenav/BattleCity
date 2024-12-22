/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Ventanas;

import Elementos.ObtenerRutaSprite;
import Elementos.PuntuacionSingleton;
import Threads.ThreadAnimacionResultados;
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
public class VentanaResumen extends javax.swing.JFrame implements KeyListener{

    public boolean esperando = true;
    
    public VentanaResumen() {
        this.setContentPane(new FondoPanel());
        initComponents();
        asignarImagenes();
        setPuntos();
        
        addKeyListener(this);
        this.setFocusable(true);
        
        ThreadAnimacionResultados thread = new ThreadAnimacionResultados(this);
        thread.start();
        
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
                    
                    
                    break;
                    
                    
                case 10:
                    //System.out.println("presiona enter");
                    if(esperando)
                        break;
                    
                    if(PuntuacionSingleton.getInstance().getNivel()==9){
                        System.out.println("Ya no hay mas niveles (WIP)");
                        
                        new VentanaFinal().setVisible(true);
                        this.dispose();
                        break;
                    }
                    
                    try{
                        Thread.sleep(100);
                    }catch(InterruptedException ex){}
                   
                    new VentanaJuego().setVisible(true);
                    this.dispose();
                    
                    break;
          
                default:
                    break;          
        }
    }
    
    @Override
    public void keyReleased(KeyEvent ke) 
    {}
    
    public void revelar1(){
        try{
            lblPuntos1.setVisible(true);
            btnPts1.setVisible(true);
            lblMatados1.setVisible(true);
            lblFlecha1.setVisible(true);
            lblTanque1.setVisible(true);
            Thread.sleep(1000);
        }catch(InterruptedException ex){}
        
        
    }
    
    public void revelar2(){
        try{
            lblPuntos2.setVisible(true);
            btnPts2.setVisible(true);
            lblMatados2.setVisible(true);
            lblFlecha2.setVisible(true);
            lblTanque2.setVisible(true);
            Thread.sleep(1000);
        }catch(InterruptedException ex){}
        
        
    }
    public void revelar3(){
        try{
            lblPuntos3.setVisible(true);
            btnPts3.setVisible(true);
            lblMatados3.setVisible(true);
            lblFlecha3.setVisible(true);
            lblTanque3.setVisible(true);
            Thread.sleep(1000);
        }catch(InterruptedException ex){}
        
        
    }
    public void revelar4(){
        try{
            lblPuntos4.setVisible(true);
            btnPts4.setVisible(true);
            lblMatados4.setVisible(true);
            lblFlecha4.setVisible(true);
            lblTanque4.setVisible(true);
            Thread.sleep(1000);
        }catch(InterruptedException ex){}
        
        
    }
    public void revelar5(){
        try{
            btnPts5.setVisible(true);
            lblMatados5.setVisible(true);
            Thread.sleep(1000);
        }catch(InterruptedException ex){}
        
        
    }
    
    
    private void setPuntos(){
    
        PuntuacionSingleton puntuacion = PuntuacionSingleton.getInstance();
        
        bnStage.setText("STAGE "+(puntuacion.getNivel()-1));
        
        int suma = 0;
        
        int simples = puntuacion.getSimples();
        int rapidos = puntuacion.getRapidos();
        int fuertes = puntuacion.getFuertes();
        int reforzados = puntuacion.getReforzados();
        int puntuacionJugador = puntuacion.getPuntuacion();
        
        lblMatados1.setText(simples+"");
        lblMatados2.setText(rapidos+"");
        lblMatados3.setText(fuertes+"");
        lblMatados4.setText(reforzados+"");
        
        lblPuntosTotales.setText(puntuacionJugador+"");
        
        simples*=100;
        rapidos*=100;
        fuertes*=100;
        reforzados*=100;
        
        
        
        suma = simples+rapidos+fuertes+reforzados;
        
        lblPuntos1.setText(simples+"");
        lblPuntos2.setText(rapidos+"");
        lblPuntos3.setText(fuertes+"");
        lblPuntos4.setText(reforzados+"");
        lblMatados5.setText(suma+"");
        
        puntuacion.setPuntuacion(puntuacionJugador+suma);
        
        puntuacion.setSimples(0);
        puntuacion.setRapidos(0);
        puntuacion.setFuertes(0);
        puntuacion.setReforzados(0);
        
        lblPuntos1.setVisible(false);
        btnPts1.setVisible(false);
        lblMatados1.setVisible(false);
        lblFlecha1.setVisible(false);
        lblTanque1.setVisible(false);
        
        lblPuntos2.setVisible(false);
        btnPts2.setVisible(false);
        lblMatados2.setVisible(false);
        lblFlecha2.setVisible(false);
        lblTanque2.setVisible(false);
        
        lblPuntos3.setVisible(false);
        btnPts3.setVisible(false);
        lblMatados3.setVisible(false);
        lblFlecha3.setVisible(false);
        lblTanque3.setVisible(false);
        
        lblPuntos4.setVisible(false);
        btnPts4.setVisible(false);
        lblMatados4.setVisible(false);
        lblFlecha4.setVisible(false);
        lblTanque4.setVisible(false);
        
        btnPts5.setVisible(false);
        lblMatados5.setVisible(false);
    
    }
    
    
    private void asignarImagenes()
    {
        JLabel label;
        String rutaImagen;
        ImageIcon icono;
        Image imagenOriginal;
        Image imagenEscalada;
        ImageIcon iconoEscalado;
        
        label = lblTanque1;
        rutaImagen = ObtenerRutaSprite.get("tile108.png");
        icono = new ImageIcon(rutaImagen);
        imagenOriginal = icono.getImage();
        imagenEscalada = imagenOriginal.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT);
        iconoEscalado = new ImageIcon(imagenEscalada);
        label.setIcon(iconoEscalado);
        
        label = lblTanque2;
        rutaImagen = ObtenerRutaSprite.get("tile133.png");
        icono = new ImageIcon(rutaImagen);
        imagenOriginal = icono.getImage();
        imagenEscalada = imagenOriginal.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT);
        iconoEscalado = new ImageIcon(imagenEscalada);
        label.setIcon(iconoEscalado);
        
        label = lblTanque3;
        rutaImagen = ObtenerRutaSprite.get("tile158.png");
        icono = new ImageIcon(rutaImagen);
        imagenOriginal = icono.getImage();
        imagenEscalada = imagenOriginal.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT);
        iconoEscalado = new ImageIcon(imagenEscalada);
        label.setIcon(iconoEscalado);
        
        label = lblTanque4;
        rutaImagen = ObtenerRutaSprite.get("tile183.png");
        icono = new ImageIcon(rutaImagen);
        imagenOriginal = icono.getImage();
        imagenEscalada = imagenOriginal.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT);
        iconoEscalado = new ImageIcon(imagenEscalada);
        label.setIcon(iconoEscalado);
        
        label = lblFlecha1;
        rutaImagen = ObtenerRutaSprite.get("Flecha.png");
        icono = new ImageIcon(rutaImagen);
        imagenOriginal = icono.getImage();
        imagenEscalada = imagenOriginal.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT);
        iconoEscalado = new ImageIcon(imagenEscalada);
        label.setIcon(iconoEscalado);
        
        label = lblFlecha2;
        rutaImagen = ObtenerRutaSprite.get("Flecha.png");
        icono = new ImageIcon(rutaImagen);
        imagenOriginal = icono.getImage();
        imagenEscalada = imagenOriginal.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT);
        iconoEscalado = new ImageIcon(imagenEscalada);
        label.setIcon(iconoEscalado);
        
        label = lblFlecha3;
        rutaImagen = ObtenerRutaSprite.get("Flecha.png");
        icono = new ImageIcon(rutaImagen);
        imagenOriginal = icono.getImage();
        imagenEscalada = imagenOriginal.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT);
        iconoEscalado = new ImageIcon(imagenEscalada);
        label.setIcon(iconoEscalado);
        
        label = lblFlecha4;
        rutaImagen = ObtenerRutaSprite.get("Flecha.png");
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
        btnPts1 = new javax.swing.JButton();
        btnComenzar1 = new javax.swing.JButton();
        lblPuntos1 = new javax.swing.JLabel();
        lblTanque1 = new javax.swing.JLabel();
        bnStage = new javax.swing.JButton();
        lblPuntosTotales = new javax.swing.JLabel();
        lblMatados1 = new javax.swing.JLabel();
        lblFlecha1 = new javax.swing.JLabel();
        btnHiScore = new javax.swing.JButton();
        lblPuntos2 = new javax.swing.JLabel();
        btnPts2 = new javax.swing.JButton();
        lblMatados2 = new javax.swing.JLabel();
        lblFlecha2 = new javax.swing.JLabel();
        lblTanque2 = new javax.swing.JLabel();
        btnPts3 = new javax.swing.JButton();
        lblTanque3 = new javax.swing.JLabel();
        lblPuntos3 = new javax.swing.JLabel();
        lblMatados3 = new javax.swing.JLabel();
        lblFlecha3 = new javax.swing.JLabel();
        btnPts4 = new javax.swing.JButton();
        lblTanque4 = new javax.swing.JLabel();
        lblMatados4 = new javax.swing.JLabel();
        lblPuntos4 = new javax.swing.JLabel();
        lblFlecha4 = new javax.swing.JLabel();
        lblMatados5 = new javax.swing.JLabel();
        btnPts5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(512, 448));
        setMinimumSize(new java.awt.Dimension(512, 448));
        setPreferredSize(new java.awt.Dimension(512, 448));

        btnComenzar.setBackground(new java.awt.Color(0, 0, 0));
        btnComenzar.setFont(new java.awt.Font("Nintendo NES Font", 0, 15));
        btnComenzar.setForeground(new java.awt.Color(204, 51, 0));
        btnComenzar.setText("HI-SCORE");
        btnComenzar.setBorder(null);
        btnComenzar.setBorderPainted(false);
        btnComenzar.setContentAreaFilled(false);
        btnComenzar.setFocusable(false);
        btnComenzar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        btnPts1.setBackground(new java.awt.Color(0, 0, 0));
        btnPts1.setFont(new java.awt.Font("Nintendo NES Font", 0, 15));
        btnPts1.setForeground(new java.awt.Color(255, 255, 255));
        btnPts1.setText("PTS");
        btnPts1.setBorder(null);
        btnPts1.setBorderPainted(false);
        btnPts1.setContentAreaFilled(false);
        btnPts1.setFocusable(false);
        btnPts1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPts1.setMaximumSize(new java.awt.Dimension(224, 35));
        btnPts1.setMinimumSize(new java.awt.Dimension(224, 35));
        btnPts1.setPreferredSize(new java.awt.Dimension(224, 35));
        btnPts1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPts1ActionPerformed(evt);
            }
        });

        btnComenzar1.setBackground(new java.awt.Color(0, 0, 0));
        btnComenzar1.setFont(new java.awt.Font("Nintendo NES Font", 0, 15));
        btnComenzar1.setForeground(new java.awt.Color(204, 51, 0));
        btnComenzar1.setText("   I-PLAYER");
        btnComenzar1.setBorder(null);
        btnComenzar1.setBorderPainted(false);
        btnComenzar1.setContentAreaFilled(false);
        btnComenzar1.setFocusable(false);
        btnComenzar1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnComenzar1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        lblPuntos1.setFont(new java.awt.Font("Nintendo NES Font", 0, 15));
        lblPuntos1.setForeground(new java.awt.Color(255, 255, 255));
        lblPuntos1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPuntos1.setText("0");
        lblPuntos1.setMaximumSize(new java.awt.Dimension(60, 35));
        lblPuntos1.setMinimumSize(new java.awt.Dimension(60, 35));
        lblPuntos1.setPreferredSize(new java.awt.Dimension(60, 35));

        lblTanque1.setForeground(new java.awt.Color(204, 255, 255));
        lblTanque1.setText("1");
        lblTanque1.setMaximumSize(new java.awt.Dimension(30, 30));
        lblTanque1.setMinimumSize(new java.awt.Dimension(30, 30));
        lblTanque1.setPreferredSize(new java.awt.Dimension(30, 30));

        bnStage.setBackground(new java.awt.Color(0, 0, 0));
        bnStage.setFont(new java.awt.Font("Nintendo NES Font", 0, 15));
        bnStage.setForeground(new java.awt.Color(255, 255, 255));
        bnStage.setText("STAGE 0");
        bnStage.setBorder(null);
        bnStage.setBorderPainted(false);
        bnStage.setContentAreaFilled(false);
        bnStage.setFocusable(false);

        lblPuntosTotales.setFont(new java.awt.Font("Nintendo NES Font", 0, 15));
        lblPuntosTotales.setForeground(new java.awt.Color(255, 153, 0));
        lblPuntosTotales.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPuntosTotales.setText("1");
        lblPuntosTotales.setMaximumSize(new java.awt.Dimension(60, 35));
        lblPuntosTotales.setMinimumSize(new java.awt.Dimension(60, 35));
        lblPuntosTotales.setPreferredSize(new java.awt.Dimension(60, 35));

        lblMatados1.setFont(new java.awt.Font("Nintendo NES Font", 0, 15));
        lblMatados1.setForeground(new java.awt.Color(255, 255, 255));
        lblMatados1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMatados1.setText("0");
        lblMatados1.setMaximumSize(new java.awt.Dimension(60, 35));
        lblMatados1.setMinimumSize(new java.awt.Dimension(60, 35));
        lblMatados1.setPreferredSize(new java.awt.Dimension(60, 35));

        lblFlecha1.setForeground(new java.awt.Color(204, 255, 255));
        lblFlecha1.setText("1");
        lblFlecha1.setMaximumSize(new java.awt.Dimension(30, 30));
        lblFlecha1.setMinimumSize(new java.awt.Dimension(30, 30));
        lblFlecha1.setPreferredSize(new java.awt.Dimension(30, 30));

        btnHiScore.setBackground(new java.awt.Color(0, 0, 0));
        btnHiScore.setFont(new java.awt.Font("Nintendo NES Font", 0, 15));
        btnHiScore.setForeground(new java.awt.Color(255, 153, 0));
        btnHiScore.setText("20000");
        btnHiScore.setBorder(null);
        btnHiScore.setBorderPainted(false);
        btnHiScore.setContentAreaFilled(false);
        btnHiScore.setFocusable(false);
        btnHiScore.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnHiScore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHiScoreActionPerformed(evt);
            }
        });

        lblPuntos2.setFont(new java.awt.Font("Nintendo NES Font", 0, 15));
        lblPuntos2.setForeground(new java.awt.Color(255, 255, 255));
        lblPuntos2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPuntos2.setText("0");
        lblPuntos2.setMaximumSize(new java.awt.Dimension(60, 35));
        lblPuntos2.setMinimumSize(new java.awt.Dimension(60, 35));
        lblPuntos2.setPreferredSize(new java.awt.Dimension(60, 35));

        btnPts2.setBackground(new java.awt.Color(0, 0, 0));
        btnPts2.setFont(new java.awt.Font("Nintendo NES Font", 0, 15));
        btnPts2.setForeground(new java.awt.Color(255, 255, 255));
        btnPts2.setText("PTS");
        btnPts2.setBorder(null);
        btnPts2.setBorderPainted(false);
        btnPts2.setContentAreaFilled(false);
        btnPts2.setFocusable(false);
        btnPts2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPts2.setMaximumSize(new java.awt.Dimension(224, 35));
        btnPts2.setMinimumSize(new java.awt.Dimension(224, 35));
        btnPts2.setPreferredSize(new java.awt.Dimension(224, 35));
        btnPts2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPts2ActionPerformed(evt);
            }
        });

        lblMatados2.setFont(new java.awt.Font("Nintendo NES Font", 0, 15));
        lblMatados2.setForeground(new java.awt.Color(255, 255, 255));
        lblMatados2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMatados2.setText("0");
        lblMatados2.setMaximumSize(new java.awt.Dimension(60, 35));
        lblMatados2.setMinimumSize(new java.awt.Dimension(60, 35));
        lblMatados2.setPreferredSize(new java.awt.Dimension(60, 35));

        lblFlecha2.setForeground(new java.awt.Color(204, 255, 255));
        lblFlecha2.setText("1");
        lblFlecha2.setMaximumSize(new java.awt.Dimension(30, 30));
        lblFlecha2.setMinimumSize(new java.awt.Dimension(30, 30));
        lblFlecha2.setPreferredSize(new java.awt.Dimension(30, 30));

        lblTanque2.setForeground(new java.awt.Color(204, 255, 255));
        lblTanque2.setText("1");
        lblTanque2.setMaximumSize(new java.awt.Dimension(30, 30));
        lblTanque2.setMinimumSize(new java.awt.Dimension(30, 30));
        lblTanque2.setPreferredSize(new java.awt.Dimension(30, 30));

        btnPts3.setBackground(new java.awt.Color(0, 0, 0));
        btnPts3.setFont(new java.awt.Font("Nintendo NES Font", 0, 15));
        btnPts3.setForeground(new java.awt.Color(255, 255, 255));
        btnPts3.setText("PTS");
        btnPts3.setBorder(null);
        btnPts3.setBorderPainted(false);
        btnPts3.setContentAreaFilled(false);
        btnPts3.setFocusable(false);
        btnPts3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPts3.setMaximumSize(new java.awt.Dimension(224, 35));
        btnPts3.setMinimumSize(new java.awt.Dimension(224, 35));
        btnPts3.setPreferredSize(new java.awt.Dimension(224, 35));
        btnPts3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPts3ActionPerformed(evt);
            }
        });

        lblTanque3.setForeground(new java.awt.Color(204, 255, 255));
        lblTanque3.setText("1");
        lblTanque3.setMaximumSize(new java.awt.Dimension(30, 30));
        lblTanque3.setMinimumSize(new java.awt.Dimension(30, 30));
        lblTanque3.setPreferredSize(new java.awt.Dimension(30, 30));

        lblPuntos3.setFont(new java.awt.Font("Nintendo NES Font", 0, 15));
        lblPuntos3.setForeground(new java.awt.Color(255, 255, 255));
        lblPuntos3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPuntos3.setText("0");
        lblPuntos3.setMaximumSize(new java.awt.Dimension(60, 35));
        lblPuntos3.setMinimumSize(new java.awt.Dimension(60, 35));
        lblPuntos3.setPreferredSize(new java.awt.Dimension(60, 35));

        lblMatados3.setFont(new java.awt.Font("Nintendo NES Font", 0, 15));
        lblMatados3.setForeground(new java.awt.Color(255, 255, 255));
        lblMatados3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMatados3.setText("0");
        lblMatados3.setMaximumSize(new java.awt.Dimension(60, 35));
        lblMatados3.setMinimumSize(new java.awt.Dimension(60, 35));
        lblMatados3.setPreferredSize(new java.awt.Dimension(60, 35));

        lblFlecha3.setForeground(new java.awt.Color(204, 255, 255));
        lblFlecha3.setText("1");
        lblFlecha3.setMaximumSize(new java.awt.Dimension(30, 30));
        lblFlecha3.setMinimumSize(new java.awt.Dimension(30, 30));
        lblFlecha3.setPreferredSize(new java.awt.Dimension(30, 30));

        btnPts4.setBackground(new java.awt.Color(0, 0, 0));
        btnPts4.setFont(new java.awt.Font("Nintendo NES Font", 0, 15));
        btnPts4.setForeground(new java.awt.Color(255, 255, 255));
        btnPts4.setText("PTS");
        btnPts4.setBorder(null);
        btnPts4.setBorderPainted(false);
        btnPts4.setContentAreaFilled(false);
        btnPts4.setFocusable(false);
        btnPts4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPts4.setMaximumSize(new java.awt.Dimension(224, 35));
        btnPts4.setMinimumSize(new java.awt.Dimension(224, 35));
        btnPts4.setPreferredSize(new java.awt.Dimension(224, 35));
        btnPts4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPts4ActionPerformed(evt);
            }
        });

        lblTanque4.setForeground(new java.awt.Color(204, 255, 255));
        lblTanque4.setText("1");
        lblTanque4.setMaximumSize(new java.awt.Dimension(30, 30));
        lblTanque4.setMinimumSize(new java.awt.Dimension(30, 30));
        lblTanque4.setPreferredSize(new java.awt.Dimension(30, 30));

        lblMatados4.setFont(new java.awt.Font("Nintendo NES Font", 0, 15));
        lblMatados4.setForeground(new java.awt.Color(255, 255, 255));
        lblMatados4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMatados4.setText("0");
        lblMatados4.setMaximumSize(new java.awt.Dimension(60, 35));
        lblMatados4.setMinimumSize(new java.awt.Dimension(60, 35));
        lblMatados4.setPreferredSize(new java.awt.Dimension(60, 35));

        lblPuntos4.setFont(new java.awt.Font("Nintendo NES Font", 0, 15));
        lblPuntos4.setForeground(new java.awt.Color(255, 255, 255));
        lblPuntos4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPuntos4.setText("0");
        lblPuntos4.setMaximumSize(new java.awt.Dimension(60, 35));
        lblPuntos4.setMinimumSize(new java.awt.Dimension(60, 35));
        lblPuntos4.setPreferredSize(new java.awt.Dimension(60, 35));

        lblFlecha4.setForeground(new java.awt.Color(204, 255, 255));
        lblFlecha4.setText("1");
        lblFlecha4.setMaximumSize(new java.awt.Dimension(30, 30));
        lblFlecha4.setMinimumSize(new java.awt.Dimension(30, 30));
        lblFlecha4.setPreferredSize(new java.awt.Dimension(30, 30));

        lblMatados5.setFont(new java.awt.Font("Nintendo NES Font", 0, 15));
        lblMatados5.setForeground(new java.awt.Color(255, 255, 255));
        lblMatados5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMatados5.setText("000");
        lblMatados5.setMaximumSize(new java.awt.Dimension(60, 35));
        lblMatados5.setMinimumSize(new java.awt.Dimension(60, 35));
        lblMatados5.setPreferredSize(new java.awt.Dimension(60, 35));

        btnPts5.setBackground(new java.awt.Color(0, 0, 0));
        btnPts5.setFont(new java.awt.Font("Nintendo NES Font", 0, 15));
        btnPts5.setForeground(new java.awt.Color(255, 255, 255));
        btnPts5.setText("TOTAL");
        btnPts5.setBorder(null);
        btnPts5.setBorderPainted(false);
        btnPts5.setContentAreaFilled(false);
        btnPts5.setFocusable(false);
        btnPts5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPts5.setMaximumSize(new java.awt.Dimension(224, 35));
        btnPts5.setMinimumSize(new java.awt.Dimension(224, 35));
        btnPts5.setPreferredSize(new java.awt.Dimension(224, 35));
        btnPts5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPts5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bnStage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnComenzar, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnHiScore, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnComenzar1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPuntosTotales, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblPuntos2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPts2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblMatados2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblFlecha2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTanque2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblPuntos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPts1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblMatados1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblFlecha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTanque1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblPuntos3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPts3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblMatados3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblFlecha3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTanque3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblPuntos4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPts4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblMatados4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblFlecha4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTanque4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(btnPts5, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblMatados5, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnComenzar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHiScore, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bnStage, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnComenzar1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(lblPuntosTotales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPts1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPuntos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMatados1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTanque1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFlecha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPts2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPuntos2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMatados2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTanque2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFlecha2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPts3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPuntos3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMatados3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTanque3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFlecha3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPts4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPuntos4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMatados4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTanque4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFlecha4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMatados5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPts5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPts1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPts1ActionPerformed
    }//GEN-LAST:event_btnPts1ActionPerformed

    private void btnHiScoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHiScoreActionPerformed
    }//GEN-LAST:event_btnHiScoreActionPerformed

    private void btnPts2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPts2ActionPerformed
    }//GEN-LAST:event_btnPts2ActionPerformed

    private void btnPts3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPts3ActionPerformed
    }//GEN-LAST:event_btnPts3ActionPerformed

    private void btnPts4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPts4ActionPerformed
    }//GEN-LAST:event_btnPts4ActionPerformed

    private void btnPts5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPts5ActionPerformed
    }//GEN-LAST:event_btnPts5ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bnStage;
    private javax.swing.JButton btnComenzar;
    private javax.swing.JButton btnComenzar1;
    private javax.swing.JButton btnHiScore;
    private javax.swing.JButton btnPts1;
    private javax.swing.JButton btnPts2;
    private javax.swing.JButton btnPts3;
    private javax.swing.JButton btnPts4;
    private javax.swing.JButton btnPts5;
    private javax.swing.JLabel lblFlecha1;
    private javax.swing.JLabel lblFlecha2;
    private javax.swing.JLabel lblFlecha3;
    private javax.swing.JLabel lblFlecha4;
    private javax.swing.JLabel lblMatados1;
    private javax.swing.JLabel lblMatados2;
    private javax.swing.JLabel lblMatados3;
    private javax.swing.JLabel lblMatados4;
    private javax.swing.JLabel lblMatados5;
    private javax.swing.JLabel lblPuntos1;
    private javax.swing.JLabel lblPuntos2;
    private javax.swing.JLabel lblPuntos3;
    private javax.swing.JLabel lblPuntos4;
    private javax.swing.JLabel lblPuntosTotales;
    private javax.swing.JLabel lblTanque1;
    private javax.swing.JLabel lblTanque2;
    private javax.swing.JLabel lblTanque3;
    private javax.swing.JLabel lblTanque4;
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
