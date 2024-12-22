/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Ventanas;

import Bloques.Agua;
import Bloques.Bloque;
import Bloques.BloqueFactory;
import static Bloques.BloqueFactory.AGUA;
import static Bloques.BloqueFactory.HOJAS;
import static Bloques.BloqueFactory.LADRILLOS_ENTEROS;
import static Bloques.BloqueFactory.METAL_ENTERO;
import Bloques.EsquinaDerecha;
import Bloques.EsquinaIzquierda;
import Bloques.Estatua;
import Bloques.Hojas;
import Bloques.Ladrillo;
import Bloques.LadrilloDerecha;
import Bloques.LadrilloHorizontal;
import Bloques.LadrilloIzquierda;
import Bloques.Metal;
import Bloques.Spawn;
import Bloques.Vacio;
import Elementos.Casilla;
import Elementos.FileManager;
import Elementos.ObtenerRutaSprite;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author wisfer
 */
public class VentanaCrearMapa extends javax.swing.JFrame {

    Casilla[][] tablero = new Casilla[13][13];
    Bloque seleccionado = null;
    Casilla seleccionada = null;
    
    public VentanaCrearMapa() {
        this.setContentPane(new FondoPanel());
        initComponents();
        generarMatriz();
        asignarImagenes();
    }
    
    
    private void generarMatriz(){
    
        for(int i = 0; i<13; i++){
            for(int j = 0; j<13; j++){
                
                Casilla casilla = new Casilla(i,j);
                pnlJuego.add(casilla.getLabel());
                casilla.getLabel().setLocation(j*48,i*48);
                tablero[i][j]=casilla;
                casilla.getLabel().addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        casillaMouseClicked(evt, casilla);
                    }
                });
                
            }
        }
    }
    
    private void casillaMouseClicked(java.awt.event.MouseEvent evt, Casilla casilla){
        seleccionada = casilla;
        System.out.println(seleccionada.toString());
        
        if(seleccionado!=null){
            
            if(seleccionado.getVida()==-1){
                
                if(seleccionada.getOcupadoPorBloque()==null){
                    seleccionado = null;
                    seleccionada = null;
                }else{
                    pnlJuego.remove(seleccionada.getOcupadoPorBloque().getBloqueLabel());
                    pnlJuego.revalidate();
                    pnlJuego.repaint();
                    seleccionada.setOcupadoPorBloque(null);
                }
            }else{
                
                if(seleccionada.getOcupadoPorBloque()!=null){
                    seleccionado = null;
                    seleccionada = null;
                    return;
                }
                
                //El for valida que no se puedan poner varios spawns y varias estatuas
                for(int i = 0; i<13; i++){
                    for(int j = 0; j<13; j++){
                        Casilla casillaTest = tablero[i][j];
                        if(casillaTest.getOcupadoPorBloque()!=null){
                            if(casillaTest.getOcupadoPorBloque().getTipo().equals("Estatua")&&seleccionado.getTipo().equals("Estatua")){
                                seleccionado = null;
                                seleccionada = null;
                                return;
                            }
                        }
                        if(casillaTest.getOcupadoPorBloque()!=null){
                            if(casillaTest.getOcupadoPorBloque().getTipo().equals("Spawn")&&seleccionado.getTipo().equals("Spawn")){
                                seleccionado = null;
                                seleccionada = null;
                                return;
                            }
                        }
                    }
                }
                
                pnlJuego.add(seleccionado.getBloqueLabel());
                seleccionado.getBloqueLabel().setLocation(seleccionada.getLabel().getLocation());
                seleccionada.setOcupadoPorBloque(seleccionado);            
            }
            
            
        }
        
        seleccionado = null;
        seleccionada = null;
        
    }
    
    private void asignarImagenes(){
        JLabel label;
        String rutaImagen;
        ImageIcon icono;
        Image imagenOriginal;
        Image imagenEscalada;
        ImageIcon iconoEscalado;
    
        label = lblHojas;
        rutaImagen = ObtenerRutaSprite.get("tile067.png");
        icono = new ImageIcon(rutaImagen);
        imagenOriginal = icono.getImage();
        imagenEscalada = imagenOriginal.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT);
        iconoEscalado = new ImageIcon(imagenEscalada);
        label.setIcon(iconoEscalado);
        label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bloqueMouseClicked(evt, BloqueFactory.HOJAS);
            }
        });
        
        label = lblAgua;
        rutaImagen = ObtenerRutaSprite.get("tile091.png");
        icono = new ImageIcon(rutaImagen);
        imagenOriginal = icono.getImage();
        imagenEscalada = imagenOriginal.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT);
        iconoEscalado = new ImageIcon(imagenEscalada);
        label.setIcon(iconoEscalado);
        label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bloqueMouseClicked(evt, BloqueFactory.AGUA);
            }
        });
        
        label = lblLadrillo;
        rutaImagen = ObtenerRutaSprite.get("tile016.png");
        icono = new ImageIcon(rutaImagen);
        imagenOriginal = icono.getImage();
        imagenEscalada = imagenOriginal.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT);
        iconoEscalado = new ImageIcon(imagenEscalada);
        label.setIcon(iconoEscalado);
        label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bloqueMouseClicked(evt, BloqueFactory.LADRILLOS_ENTEROS);
            }
        });
    
        label = lblMetal;
        rutaImagen = ObtenerRutaSprite.get("tile041.png");
        icono = new ImageIcon(rutaImagen);
        imagenOriginal = icono.getImage();
        imagenEscalada = imagenOriginal.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT);
        iconoEscalado = new ImageIcon(imagenEscalada);
        label.setIcon(iconoEscalado);
        label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bloqueMouseClicked(evt, BloqueFactory.METAL_ENTERO);
            }
        });
        
        label = lblLadrilloVerticalLeft;
        rutaImagen = ObtenerRutaSprite.get("tile019.png");
        icono = new ImageIcon(rutaImagen);
        imagenOriginal = icono.getImage();
        imagenEscalada = imagenOriginal.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT);
        iconoEscalado = new ImageIcon(imagenEscalada);
        label.setIcon(iconoEscalado);
        label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bloqueMouseClicked(evt, BloqueFactory.LADRILLOS_IZQUIERDOS);
            }
        });
        
        label = lblLadrilloVerticalRight;
        rutaImagen = ObtenerRutaSprite.get("tile017.png");
        icono = new ImageIcon(rutaImagen);
        imagenOriginal = icono.getImage();
        imagenEscalada = imagenOriginal.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT);
        iconoEscalado = new ImageIcon(imagenEscalada);
        label.setIcon(iconoEscalado);
        label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bloqueMouseClicked(evt, BloqueFactory.LADRILLOS_DERECHOS);
            }
        });
        
        label = lblLadrilloHorizontal;
        rutaImagen = ObtenerRutaSprite.get("tile018.png");
        icono = new ImageIcon(rutaImagen);
        imagenOriginal = icono.getImage();
        imagenEscalada = imagenOriginal.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT);
        iconoEscalado = new ImageIcon(imagenEscalada);
        label.setIcon(iconoEscalado);
        label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bloqueMouseClicked(evt, BloqueFactory.LADRILLOS_HORIZONTALES);
            }
        });
        
        label = lblSpawn;
        rutaImagen = ObtenerRutaSprite.get("tile241.png");
        icono = new ImageIcon(rutaImagen);
        imagenOriginal = icono.getImage();
        imagenEscalada = imagenOriginal.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT);
        iconoEscalado = new ImageIcon(imagenEscalada);
        label.setIcon(iconoEscalado);
        label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bloqueMouseClicked(evt, BloqueFactory.SPAWN);
            }
        });
        
        label = lblEstatua;
        rutaImagen = ObtenerRutaSprite.get("tile069.png");
        icono = new ImageIcon(rutaImagen);
        imagenOriginal = icono.getImage();
        imagenEscalada = imagenOriginal.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT);
        iconoEscalado = new ImageIcon(imagenEscalada);
        label.setIcon(iconoEscalado);
        label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bloqueMouseClicked(evt, BloqueFactory.ESTATUA);
            }
        });
        
        label = lblQuitar;
        rutaImagen = ObtenerRutaSprite.get("error.png");
        icono = new ImageIcon(rutaImagen);
        imagenOriginal = icono.getImage();
        imagenEscalada = imagenOriginal.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT);
        iconoEscalado = new ImageIcon(imagenEscalada);
        label.setIcon(iconoEscalado);
        label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bloqueMouseClicked(evt, -1);
            }
        });
        
        label = lblEsquinaDerecha;
        rutaImagen = ObtenerRutaSprite.get("EsquinaDerecha.png");
        icono = new ImageIcon(rutaImagen);
        imagenOriginal = icono.getImage();
        imagenEscalada = imagenOriginal.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT);
        iconoEscalado = new ImageIcon(imagenEscalada);
        label.setIcon(iconoEscalado);
        label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bloqueMouseClicked(evt, BloqueFactory.ESQUINA_DERECHA);
            }
        });
        
        label = lblEsquinaIzquierda;
        rutaImagen = ObtenerRutaSprite.get("EsquinaIzquierda.png");
        icono = new ImageIcon(rutaImagen);
        imagenOriginal = icono.getImage();
        imagenEscalada = imagenOriginal.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT);
        iconoEscalado = new ImageIcon(imagenEscalada);
        label.setIcon(iconoEscalado);
        label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bloqueMouseClicked(evt, BloqueFactory.ESQUINA_IZQUIERDA);
            }
        });
    }
    
    private void bloqueMouseClicked(java.awt.event.MouseEvent evt, int indicador){
        switch(indicador)
        {
            case BloqueFactory.HOJAS:
                seleccionado = new Hojas();
                break;
                
            case BloqueFactory.AGUA:
                seleccionado = new Agua();
                break;
                
            case BloqueFactory.LADRILLOS_ENTEROS:
                seleccionado = new Ladrillo();
                break;
                
            case BloqueFactory.METAL_ENTERO:
                seleccionado = new Metal();
                break;
            
            case BloqueFactory.LADRILLOS_IZQUIERDOS:
                seleccionado = new LadrilloIzquierda();
                break;
            
            case BloqueFactory.LADRILLOS_DERECHOS:
                seleccionado = new LadrilloDerecha();
                break;
                
            case BloqueFactory.LADRILLOS_HORIZONTALES:
                seleccionado = new LadrilloHorizontal();
                break;
            
            case BloqueFactory.ESTATUA:
                seleccionado = new Estatua();
                break;
            
            case BloqueFactory.SPAWN:
                seleccionado = new Spawn();
                break;
                
            case BloqueFactory.ESQUINA_DERECHA:
                seleccionado = new EsquinaDerecha();
                break;
             
            case BloqueFactory.ESQUINA_IZQUIERDA:
                seleccionado = new EsquinaIzquierda();
                break;
            
            case -1:
                seleccionado = new Vacio();
                break;
                
            default:
                seleccionado = null;
                break;
        }
        System.out.println(seleccionado.getInfo());
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlJuego = new javax.swing.JPanel();
        pnlNiveles = new javax.swing.JPanel();
        lblHojas = new javax.swing.JLabel();
        lblMetal = new javax.swing.JLabel();
        lblAgua = new javax.swing.JLabel();
        lblLadrilloHorizontal = new javax.swing.JLabel();
        lblLadrillo = new javax.swing.JLabel();
        lblLadrilloVerticalRight = new javax.swing.JLabel();
        lblEsquinaIzquierda = new javax.swing.JLabel();
        lblLadrilloVerticalLeft = new javax.swing.JLabel();
        lblEsquinaDerecha = new javax.swing.JLabel();
        lblSpawn = new javax.swing.JLabel();
        lblEstatua = new javax.swing.JLabel();
        lblQuitar = new javax.swing.JLabel();
        btnGuardar1 = new javax.swing.JButton();
        VOLVER = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlJuego.setBackground(new java.awt.Color(0, 0, 0));
        pnlJuego.setForeground(new java.awt.Color(0, 0, 0));
        pnlJuego.setMaximumSize(new java.awt.Dimension(624, 624));
        pnlJuego.setMinimumSize(new java.awt.Dimension(624, 624));
        pnlJuego.setPreferredSize(new java.awt.Dimension(624, 624));
        pnlJuego.setRequestFocusEnabled(false);

        javax.swing.GroupLayout pnlJuegoLayout = new javax.swing.GroupLayout(pnlJuego);
        pnlJuego.setLayout(pnlJuegoLayout);
        pnlJuegoLayout.setHorizontalGroup(
            pnlJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 624, Short.MAX_VALUE)
        );
        pnlJuegoLayout.setVerticalGroup(
            pnlJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 624, Short.MAX_VALUE)
        );

        pnlNiveles.setBackground(new java.awt.Color(255, 255, 255, 0));
        pnlNiveles.setMaximumSize(new java.awt.Dimension(95, 624));
        pnlNiveles.setMinimumSize(new java.awt.Dimension(95, 624));

        lblHojas.setBackground(new java.awt.Color(204, 255, 153));
        lblHojas.setForeground(new java.awt.Color(255, 51, 51));
        lblHojas.setText("LOL");
        lblHojas.setMaximumSize(new java.awt.Dimension(48, 48));
        lblHojas.setMinimumSize(new java.awt.Dimension(48, 48));
        lblHojas.setPreferredSize(new java.awt.Dimension(48, 48));

        lblMetal.setBackground(new java.awt.Color(204, 255, 153));
        lblMetal.setForeground(new java.awt.Color(255, 51, 51));
        lblMetal.setText("LOL");
        lblMetal.setMaximumSize(new java.awt.Dimension(48, 48));
        lblMetal.setMinimumSize(new java.awt.Dimension(48, 48));
        lblMetal.setPreferredSize(new java.awt.Dimension(48, 48));

        lblAgua.setBackground(new java.awt.Color(204, 255, 153));
        lblAgua.setForeground(new java.awt.Color(255, 51, 51));
        lblAgua.setText("LOL");
        lblAgua.setMaximumSize(new java.awt.Dimension(48, 48));
        lblAgua.setMinimumSize(new java.awt.Dimension(48, 48));
        lblAgua.setPreferredSize(new java.awt.Dimension(48, 48));

        lblLadrilloHorizontal.setBackground(new java.awt.Color(204, 255, 153));
        lblLadrilloHorizontal.setForeground(new java.awt.Color(255, 51, 51));
        lblLadrilloHorizontal.setText("LOL");
        lblLadrilloHorizontal.setMaximumSize(new java.awt.Dimension(48, 48));
        lblLadrilloHorizontal.setMinimumSize(new java.awt.Dimension(48, 48));
        lblLadrilloHorizontal.setPreferredSize(new java.awt.Dimension(48, 48));

        lblLadrillo.setBackground(new java.awt.Color(204, 255, 153));
        lblLadrillo.setForeground(new java.awt.Color(255, 51, 51));
        lblLadrillo.setText("LOL");
        lblLadrillo.setMaximumSize(new java.awt.Dimension(48, 48));
        lblLadrillo.setMinimumSize(new java.awt.Dimension(48, 48));
        lblLadrillo.setPreferredSize(new java.awt.Dimension(48, 48));

        lblLadrilloVerticalRight.setBackground(new java.awt.Color(204, 255, 153));
        lblLadrilloVerticalRight.setForeground(new java.awt.Color(255, 51, 51));
        lblLadrilloVerticalRight.setText("LOL");
        lblLadrilloVerticalRight.setMaximumSize(new java.awt.Dimension(48, 48));
        lblLadrilloVerticalRight.setMinimumSize(new java.awt.Dimension(48, 48));
        lblLadrilloVerticalRight.setPreferredSize(new java.awt.Dimension(48, 48));

        lblEsquinaIzquierda.setBackground(new java.awt.Color(204, 255, 153));
        lblEsquinaIzquierda.setForeground(new java.awt.Color(255, 51, 51));
        lblEsquinaIzquierda.setText("LOL");
        lblEsquinaIzquierda.setMaximumSize(new java.awt.Dimension(48, 48));
        lblEsquinaIzquierda.setMinimumSize(new java.awt.Dimension(48, 48));
        lblEsquinaIzquierda.setPreferredSize(new java.awt.Dimension(48, 48));

        lblLadrilloVerticalLeft.setBackground(new java.awt.Color(204, 255, 153));
        lblLadrilloVerticalLeft.setForeground(new java.awt.Color(255, 51, 51));
        lblLadrilloVerticalLeft.setText("LOL");
        lblLadrilloVerticalLeft.setMaximumSize(new java.awt.Dimension(48, 48));
        lblLadrilloVerticalLeft.setMinimumSize(new java.awt.Dimension(48, 48));
        lblLadrilloVerticalLeft.setPreferredSize(new java.awt.Dimension(48, 48));

        lblEsquinaDerecha.setBackground(new java.awt.Color(204, 255, 153));
        lblEsquinaDerecha.setForeground(new java.awt.Color(255, 51, 51));
        lblEsquinaDerecha.setText("LOL");
        lblEsquinaDerecha.setMaximumSize(new java.awt.Dimension(48, 48));
        lblEsquinaDerecha.setMinimumSize(new java.awt.Dimension(48, 48));
        lblEsquinaDerecha.setPreferredSize(new java.awt.Dimension(48, 48));

        lblSpawn.setBackground(new java.awt.Color(204, 255, 153));
        lblSpawn.setForeground(new java.awt.Color(255, 51, 51));
        lblSpawn.setText("LOL");
        lblSpawn.setMaximumSize(new java.awt.Dimension(48, 48));
        lblSpawn.setMinimumSize(new java.awt.Dimension(48, 48));
        lblSpawn.setPreferredSize(new java.awt.Dimension(48, 48));

        lblEstatua.setBackground(new java.awt.Color(204, 255, 153));
        lblEstatua.setForeground(new java.awt.Color(255, 51, 51));
        lblEstatua.setText("LOL");
        lblEstatua.setMaximumSize(new java.awt.Dimension(48, 48));
        lblEstatua.setMinimumSize(new java.awt.Dimension(48, 48));
        lblEstatua.setPreferredSize(new java.awt.Dimension(48, 48));

        lblQuitar.setBackground(new java.awt.Color(204, 255, 153));
        lblQuitar.setForeground(new java.awt.Color(255, 51, 51));
        lblQuitar.setText("LOL");
        lblQuitar.setMaximumSize(new java.awt.Dimension(48, 48));
        lblQuitar.setMinimumSize(new java.awt.Dimension(48, 48));
        lblQuitar.setPreferredSize(new java.awt.Dimension(48, 48));

        javax.swing.GroupLayout pnlNivelesLayout = new javax.swing.GroupLayout(pnlNiveles);
        pnlNiveles.setLayout(pnlNivelesLayout);
        pnlNivelesLayout.setHorizontalGroup(
            pnlNivelesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNivelesLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(pnlNivelesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLadrilloVerticalLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblLadrilloVerticalRight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblLadrillo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlNivelesLayout.createSequentialGroup()
                        .addGroup(pnlNivelesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEstatua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSpawn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEsquinaDerecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEsquinaIzquierda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLadrilloHorizontal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlNivelesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblHojas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblMetal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblAgua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlNivelesLayout.setVerticalGroup(
            pnlNivelesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNivelesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHojas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAgua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMetal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLadrillo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLadrilloHorizontal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLadrilloVerticalRight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEsquinaIzquierda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLadrilloVerticalLeft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEsquinaDerecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSpawn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEstatua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnGuardar1.setFont(new java.awt.Font("Nintendo NES Font", 0, 10));
        btnGuardar1.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar1.setText("GUARDAR");
        btnGuardar1.setBorder(null);
        btnGuardar1.setContentAreaFilled(false);
        btnGuardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardar1ActionPerformed(evt);
            }
        });

        VOLVER.setFont(new java.awt.Font("Nintendo NES Font", 0, 10));
        VOLVER.setForeground(new java.awt.Color(255, 255, 255));
        VOLVER.setText("VOLVER");
        VOLVER.setBorder(null);
        VOLVER.setContentAreaFilled(false);
        VOLVER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VOLVERActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGuardar1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(VOLVER, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlJuego, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlNiveles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlJuego, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardar1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(VOLVER, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(pnlNiveles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardar1ActionPerformed
        String nombre = JOptionPane.showInputDialog("Nombre del mapa: ");
        ArrayList<Bloque> mapa = new ArrayList<Bloque>();
        for(int i = 0; i<13; i++){
            for(int j = 0; j<13; j++){
                
                Casilla casilla = tablero[i][j];
                if(casilla.getOcupadoPorBloque()!=null){
                    mapa.add(casilla.getOcupadoPorBloque());
                }
            }
        }
        FileManager.writeObject(mapa, nombre+".dat");
    }//GEN-LAST:event_btnGuardar1ActionPerformed

    private void VOLVERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VOLVERActionPerformed
        new VentanaPrincipal().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_VOLVERActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton VOLVER;
    private javax.swing.JButton btnGuardar1;
    private javax.swing.JLabel lblAgua;
    private javax.swing.JLabel lblEsquinaDerecha;
    private javax.swing.JLabel lblEsquinaIzquierda;
    private javax.swing.JLabel lblEstatua;
    private javax.swing.JLabel lblHojas;
    private javax.swing.JLabel lblLadrillo;
    private javax.swing.JLabel lblLadrilloHorizontal;
    private javax.swing.JLabel lblLadrilloVerticalLeft;
    private javax.swing.JLabel lblLadrilloVerticalRight;
    private javax.swing.JLabel lblMetal;
    private javax.swing.JLabel lblQuitar;
    private javax.swing.JLabel lblSpawn;
    private javax.swing.JPanel pnlJuego;
    private javax.swing.JPanel pnlNiveles;
    // End of variables declaration//GEN-END:variables

    class FondoPanel extends JPanel
    {
        private Image imagen;
        
        @Override
        public void paint(Graphics g)
        {
            imagen = new ImageIcon("gris.png").getImage();
            g.drawImage(imagen,0, 0, getWidth(), getHeight(),this);
            setOpaque(false);
            
            super.paint(g);
        }
    }

}
