/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Ventanas;

import Bloques.Bloque;
import Bloques.Estatua;
import Comandos.*;
import Comandos.InvocadorInstance;
import Comodines.Comodin;
import Elementos.Casilla;
import Elementos.ConfiguracionSingleton;
import Elementos.FileManager;
import Elementos.IObserver;
import Elementos.ObtenerRutaSprite;
import Elementos.PuntuacionSingleton;
import Tanques.Bala;
import Tanques.Jugador;
import Tanques.Tanque;
import Tanques.TanqueFactory;
import Tanques.TanqueFactoryMethod;
import Threads.ThreadEnemigos;
import Threads.ThreadJugador;
import Threads.ThreadSpawnearTanques;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author wisfer
 */

//ULTIMA VERSION AS OF nov25 18:01
public class VentanaJuego extends javax.swing.JFrame implements KeyListener, IObserver{

    Casilla[][] tablero = new Casilla[13][13];
    Jugador jugador;
    public Bloque estatua;
    
    ConfiguracionSingleton config = ConfiguracionSingleton.getInstance();
    
    InvocadorInstance invocador = InvocadorInstance.getInstance();
    
    public ThreadJugador threadJugador;
    
    public int panelSize;
    int tankSize = Tanque.size;
    int brickSize = Bloque.size;
    
    public ArrayList<Bloque> mapa;
    public ArrayList<Tanque> tanques = new ArrayList<Tanque>();
    public ArrayList<Bala> balas = new ArrayList<Bala>();
    public ArrayList<Comodin> comodinesEnJuego = new ArrayList<Comodin>();
    ArrayList<JLabel> iconosEnemigos;
    
    
    PuntuacionSingleton puntuacion = PuntuacionSingleton.getInstance();
    int disparos = puntuacion.getDisparos();
    int comodines = puntuacion.getComodines(); 
    int kills = puntuacion.getKills();
    public int vidas;
    
    public ThreadSpawnearTanques threadSpawnearTanques;
    public ThreadEnemigos threadMoverTanques;
    
    public int enemigosRestantes = ThreadSpawnearTanques.cantidad;
    
    public JLabel spawn;
    
    public VentanaJuego()
    {
        this.setContentPane(new FondoPanel());
        
        initComponents();
        lblInmune.setVisible(false);
        //pnlJuego.setLayout(new javax.swing.OverlayLayout(pnlJuego));
        
        asignarImagenes();
        generarMatrizTanquesRestantes();
        addKeyListener(this);
        this.setFocusable(true);
        
        vidas = puntuacion.getVidas();
        int nivel = puntuacion.getNivel();
        colocarVidas();
        //setDisparos();
        //sumarComodin();
        //sumarTanqueDestruido();
        
        
        //ultima version
        mapa = (ArrayList<Bloque>)FileManager.readObject(nivel+".dat");
        //mapa = (ArrayList<Bloque>)FileManager.readObject("6.dat");
        
        
        cargarMapa(mapa);
        panelSize = pnlJuego.getSize().width;

        threadJugador = new ThreadJugador(jugador,this);
        threadJugador.start();
        threadJugador.respawnear = true;
        
        threadSpawnearTanques = new ThreadSpawnearTanques(this);
        threadSpawnearTanques.start();
        
        threadMoverTanques = new ThreadEnemigos(this);
        threadMoverTanques.start();
        
        puntuacion.addObserver(this);
        
        lblContadorDestruidos.setText(puntuacion.getKills()+"");
        lblContadorDisparos.setText(puntuacion.getDisparos()+"");
        lblContadorPowerUps.setText(puntuacion.getComodines()+"");   
        
    }
    
    @Override
    public void keyTyped(KeyEvent ke) 
    {}

    @Override
    public void keyPressed(KeyEvent ke) 
    {
                
        int tecla = ke.getKeyCode();
        switch(tecla){
            
            case 10:
                System.out.println("enter");
                break;
            
            case 16:
                System.out.println("shift");
                break;
                
            case 37:
                if(jugador==null) break;
                invocador.recibirComando(new FlechaIzquierda(jugador));
                break;
            
            case 38:
                if(jugador==null) break;
                invocador.recibirComando(new FlechaArriba(jugador));
                break;
            
            case 39:
                if(jugador==null) break;
                invocador.recibirComando(new FlechaDerecha(jugador));
                break;
                
            case 40:
                if(jugador==null) break;
                invocador.recibirComando(new FlechaAbajo(jugador));
                break;
             
            case 90:
                System.out.println("z");
                break;
                
            case 88:
                if(jugador==null) break;
                invocador.recibirComando(new Disparar(jugador));
                break;
        
        
        }
    
    }
    
    @Override
    public void keyReleased(KeyEvent ke) 
    {}
    
    private void cargarMapa(ArrayList<Bloque> mapa)
    {
        for(Bloque bloque : mapa){
            if(bloque.getTipo().equals("Spawn")){
                //Aqui se mete el jugador
                this.spawn = bloque.getBloqueLabel();
                continue;
            }
            if(bloque.getTipo().equals("Estatua")){
                this.estatua = bloque;
            }
            if(bloque.getTipo().equals("LadrilloDerecha")){
                bloque.getBloqueLabel().setSize(bloque.getBloqueLabel().getWidth()/2, bloque.getBloqueLabel().getHeight());
                bloque.getBloqueLabel().setLocation(bloque.getBloqueLabel().getX()+brickSize/2,bloque.getBloqueLabel().getY());
                bloque.setIcon(ObtenerRutaSprite.get("pared.png"));
            }
            if(bloque.getTipo().equals("LadrilloIzquierda")){
                bloque.getBloqueLabel().setSize(bloque.getBloqueLabel().getWidth()/2, bloque.getBloqueLabel().getHeight());
                bloque.setIcon(ObtenerRutaSprite.get("pared.png"));
            }
            if(bloque.getTipo().equals("LadrilloHorizontal")){
                bloque.getBloqueLabel().setSize(bloque.getBloqueLabel().getWidth(), bloque.getBloqueLabel().getHeight()/2);
                bloque.getBloqueLabel().setLocation(bloque.getBloqueLabel().getX(),bloque.getBloqueLabel().getY()+brickSize/2);
                bloque.setIcon(ObtenerRutaSprite.get("losa.png"));
            }
            if(bloque.getTipo().equals("EsquinaIzquierda")){
                bloque.getBloqueLabel().setSize(bloque.getBloqueLabel().getWidth()/2, bloque.getBloqueLabel().getHeight()/2);
                bloque.getBloqueLabel().setLocation(bloque.getBloqueLabel().getX()+brickSize/2,bloque.getBloqueLabel().getY()+brickSize/2);
                bloque.setIcon(ObtenerRutaSprite.get("Esquina.png"));
            }
            if(bloque.getTipo().equals("EsquinaDerecha")){
                bloque.getBloqueLabel().setSize(bloque.getBloqueLabel().getWidth()/2, bloque.getBloqueLabel().getHeight()/2);
                bloque.getBloqueLabel().setLocation(bloque.getBloqueLabel().getX(),bloque.getBloqueLabel().getY()+brickSize/2);
                bloque.setIcon(ObtenerRutaSprite.get("Esquina.png"));
            }

            
            
            pnlJuego.add(bloque.getBloqueLabel());
        }
    }
    
    public void spawnearJugador(){
        TanqueFactoryMethod fabricaTanques = new TanqueFactory();
        Tanque tanqueNuevo = fabricaTanques.crearTanque(TanqueFactory.JUGADOR, false);
        pnlJuego.add(tanqueNuevo.getTanqueLabel());
        tanqueNuevo.getTanqueLabel().setLocation(spawn.getLocation());
        jugador = (Jugador)tanqueNuevo;
    
    }
    
    private void generarMatrizTanquesRestantes(){
        
        int indice = 0;
        iconosEnemigos = new ArrayList<JLabel>();
        for(int i = 0; i<enemigosRestantes/2; i++){
            for(int j=0; j<2; j++){
                
                indice++;
                
                JLabel label = new JLabel();
                label.setBackground(new java.awt.Color(0, 0, 0,0));
                label.setForeground(new java.awt.Color(1, 1, 1));
                label.setMaximumSize(new java.awt.Dimension(30, 30));
                label.setMinimumSize(new java.awt.Dimension(30, 30));
                label.setPreferredSize(new java.awt.Dimension(30, 30));
                label.setSize(new java.awt.Dimension(30, 30));

                String rutaImagen = ObtenerRutaSprite.get("tanquecitoMalo.png");
                ImageIcon icono = new ImageIcon(rutaImagen);
                Image imagenOriginal = icono.getImage();
                Image imagenEscalada = imagenOriginal.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);
                label.setIcon(iconoEscalado);


                pnlTanquesRestantes.add(label);
                label.setLocation(j*30, i*30);
                iconosEnemigos.add(label);
                
                if(indice>enemigosRestantes){
                    return;
                }
                
            }
        }
    
    }
    
    public void refrescarMatrizTanquesRestantes(){
        
        enemigosRestantes--;
                
        JLabel label = iconosEnemigos.get(enemigosRestantes);
        iconosEnemigos.remove(label);
                
        String rutaImagen = ObtenerRutaSprite.get("tile024.png");
        ImageIcon icono = new ImageIcon(rutaImagen);
        Image imagenOriginal = icono.getImage();
        Image imagenEscalada = imagenOriginal.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT);
        ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);
        label.setIcon(iconoEscalado);
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {}
        pnlTanquesRestantes.remove(label);
        //System.out.println("Tanques Restantes: "+enemigosRestantes);
    
    }
    
    public void colocarVidas(){
        
        puntuacion.setVidas(vidas);
        lblVidas.setText(vidas+"");
        //lblPruebas.setText(vidas+"");
        //System.out.println("Vidas restantes: "+ vidas);
    
    }
    
    
    public void refrescarVidas(){
    
        vidas--;
        puntuacion.setVidas(vidas);
        if(vidas==-1){
            //System.out.println("Estas muerto mano");
            jugador.setIcon("tile021.png");
        }
        if(vidas==0){
            lblVidas.setText("0");
            //lblPruebas.setText("0");
            //System.out.println("No te quedan vidas");
        }else{
            lblVidas.setText(vidas+"");
            //lblPruebas.setText(vidas+"");
            //System.out.println("Vidas restantes: "+ vidas);
        }
    }
   
    private void asignarImagenes()
    {
        JLabel label;
        String rutaImagen;
        ImageIcon icono;
        Image imagenOriginal;
        Image imagenEscalada;
        ImageIcon iconoEscalado;
        
        label = lblBanderita;
        rutaImagen = ObtenerRutaSprite.get("banderita.png");
        icono = new ImageIcon(rutaImagen);
        imagenOriginal = icono.getImage();
        imagenEscalada = imagenOriginal.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT);
        iconoEscalado = new ImageIcon(imagenEscalada);
        label.setIcon(iconoEscalado);
        
        label = lblTanquecin;
        rutaImagen = ObtenerRutaSprite.get("tanquecin.png");
        icono = new ImageIcon(rutaImagen);
        imagenOriginal = icono.getImage();
        imagenEscalada = imagenOriginal.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT);
        iconoEscalado = new ImageIcon(imagenEscalada);
        label.setIcon(iconoEscalado);
        
        //"/home/wisfer/NetBeansProjects/tanquecitos/src/main/java/sprites/tanquecitoMalo.png"
    
    }
    
    public void ganar(){
    
        //System.out.println("yayy");
        siguienteNivel();
        
    }
    
    public void perder(){
        //System.out.println("booo");
        siguienteNivel();
        
    }
    
    public void siguienteNivel(){
        //System.out.println("entra");
        threadSpawnearTanques.detener();
        //System.out.println("detiene spawn");
        if(balas.isEmpty()){
        }else
            for(Bala bala : balas){
   
                bala.threadBala.detener();
                //System.out.println("detiene una bala");

            }
        //System.out.println("detiene las balas");
        threadMoverTanques.detener();
        //System.out.println("detiene mover");
        
        threadJugador.detener();
        //System.out.println("detiene jugador");
        
        //System.out.println("Siguiente nivel");
        
        if(vidas<0){
            //System.out.println("no tenia vidas");
            puntuacion.setVidas(2);
        }
        
        puntuacion.setNivel(puntuacion.getNivel()+1);
        puntuacion.removeObserver(this);
         
        
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {}
        
        this.dispose();

        new VentanaResumen().setVisible(true);
        
        //System.out.println("fin del nivel");
    }
    
    public Comodin encontrarComodin(JLabel label){
    
        for(Comodin comodin : comodinesEnJuego){
        
            if(comodin.getLabel().equals(label)){
                return comodin;
            }
        
        }
        return null;
    
    }
    
    @Override
    public void notifyObserver(String command, Object source){
        if(command.equals("disparos")){               
            puntuacion = (PuntuacionSingleton)source;
            lblContadorDisparos.setText(puntuacion.getDisparos()+"");
            //System.out.println("Disparos: "+puntuacion.getDisparos());
        }
        if(command.equals("kills")){               
            puntuacion = (PuntuacionSingleton)source;     
            lblContadorDestruidos.setText(puntuacion.getKills()+"");
            //System.out.println("Tanques destruidos: "+puntuacion.getKills());
        }
        if(command.equals("comodines")){               
            puntuacion = (PuntuacionSingleton)source;     
            lblContadorPowerUps.setText(puntuacion.getComodines()+"");
            //System.out.println("Comodines recogidos: "+puntuacion.getComodines());
        }

        
        
    
    }
    
    
    
    

    public void setDisparos(){
        puntuacion.setDisparos(puntuacion.getDisparos()+1);
    }
    
    public void sumarTanqueDestruido(){
        puntuacion.setKills(puntuacion.getKills()+1);
    }
    
    public void sumarComodin(){
        puntuacion.setComodines(puntuacion.getComodines()+1);
    }
    
    public JLabel getLblContadorDisparos() {
        return lblContadorDisparos;
    }

    public void setLblContadorDisparos(JLabel lblContadorDisparos) {
        this.lblContadorDisparos = lblContadorDisparos;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlJuego = new javax.swing.JPanel();
        pnlNiveles = new javax.swing.JPanel();
        lblTanquecin = new javax.swing.JLabel();
        lblVidas = new javax.swing.JLabel();
        lblLetraI = new javax.swing.JLabel();
        lblLetraP = new javax.swing.JLabel();
        lblBanderita = new javax.swing.JLabel();
        lblStage = new javax.swing.JLabel();
        pnlTanquesRestantes = new javax.swing.JPanel();
        pnlContadores = new javax.swing.JPanel();
        lblTextoTanquesDestruidos = new javax.swing.JLabel();
        lblContadorDestruidos = new javax.swing.JLabel();
        lblContadorDisparos = new javax.swing.JLabel();
        lblTextoDisparosRealizados = new javax.swing.JLabel();
        lblTextoPowerUps = new javax.swing.JLabel();
        lblContadorPowerUps = new javax.swing.JLabel();
        lblInmune = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(950, 690));
        setResizable(false);

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
        pnlNiveles.setPreferredSize(new java.awt.Dimension(95, 624));

        lblTanquecin.setText("tanque");

        lblVidas.setBackground(new java.awt.Color(99, 99, 99));
        lblVidas.setFont(new java.awt.Font("Nintendo NES Font", 0, 18));
        lblVidas.setForeground(new java.awt.Color(0, 0, 0));
        lblVidas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblVidas.setText("2");
        lblVidas.setDoubleBuffered(true);
        lblVidas.setMaximumSize(new java.awt.Dimension(60, 35));
        lblVidas.setMinimumSize(new java.awt.Dimension(60, 35));
        lblVidas.setOpaque(true);
        lblVidas.setPreferredSize(new java.awt.Dimension(60, 35));

        lblLetraI.setFont(new java.awt.Font("Nintendo NES Font", 0, 18));
        lblLetraI.setForeground(new java.awt.Color(0, 0, 0));
        lblLetraI.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLetraI.setText("I");
        lblLetraI.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lblLetraI.setMaximumSize(new java.awt.Dimension(60, 35));
        lblLetraI.setMinimumSize(new java.awt.Dimension(60, 35));
        lblLetraI.setPreferredSize(new java.awt.Dimension(60, 35));

        lblLetraP.setFont(new java.awt.Font("Nintendo NES Font", 0, 18));
        lblLetraP.setForeground(new java.awt.Color(0, 0, 0));
        lblLetraP.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLetraP.setText("P");
        lblLetraP.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lblLetraP.setMaximumSize(new java.awt.Dimension(60, 35));
        lblLetraP.setMinimumSize(new java.awt.Dimension(60, 35));
        lblLetraP.setPreferredSize(new java.awt.Dimension(60, 35));

        lblBanderita.setForeground(new java.awt.Color(102, 204, 0));
        lblBanderita.setText("bandera");
        lblBanderita.setMaximumSize(new java.awt.Dimension(65, 54));
        lblBanderita.setMinimumSize(new java.awt.Dimension(65, 54));
        lblBanderita.setPreferredSize(new java.awt.Dimension(65, 54));

        lblStage.setBackground(new java.awt.Color(99, 99, 99));
        lblStage.setFont(new java.awt.Font("Nintendo NES Font", 0, 18));
        lblStage.setForeground(new java.awt.Color(0, 0, 0));
        lblStage.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblStage.setText("0");
        lblStage.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblStage.setDoubleBuffered(true);
        lblStage.setMaximumSize(new java.awt.Dimension(60, 35));
        lblStage.setMinimumSize(new java.awt.Dimension(60, 35));
        lblStage.setOpaque(true);
        lblStage.setPreferredSize(new java.awt.Dimension(60, 35));

        pnlTanquesRestantes.setBackground(new java.awt.Color(255, 102, 0,0));
        pnlTanquesRestantes.setMaximumSize(new java.awt.Dimension(60, 326));
        pnlTanquesRestantes.setMinimumSize(new java.awt.Dimension(60, 326));

        javax.swing.GroupLayout pnlTanquesRestantesLayout = new javax.swing.GroupLayout(pnlTanquesRestantes);
        pnlTanquesRestantes.setLayout(pnlTanquesRestantesLayout);
        pnlTanquesRestantesLayout.setHorizontalGroup(
            pnlTanquesRestantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );
        pnlTanquesRestantesLayout.setVerticalGroup(
            pnlTanquesRestantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 326, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlNivelesLayout = new javax.swing.GroupLayout(pnlNiveles);
        pnlNiveles.setLayout(pnlNivelesLayout);
        pnlNivelesLayout.setHorizontalGroup(
            pnlNivelesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNivelesLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(pnlNivelesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTanquesRestantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlNivelesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblStage, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblBanderita, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlNivelesLayout.createSequentialGroup()
                        .addGroup(pnlNivelesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTanquecin, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLetraI, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlNivelesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblVidas, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLetraP, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        pnlNivelesLayout.setVerticalGroup(
            pnlNivelesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNivelesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlTanquesRestantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlNivelesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLetraI, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLetraP, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlNivelesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTanquecin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblVidas, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(78, 78, 78)
                .addComponent(lblBanderita, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblStage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );

        pnlContadores.setBackground(new java.awt.Color(255, 255, 255, 0));
        pnlContadores.setMaximumSize(new java.awt.Dimension(260, 624));
        pnlContadores.setMinimumSize(new java.awt.Dimension(260, 624));
        pnlContadores.setPreferredSize(new java.awt.Dimension(260, 624));

        lblTextoTanquesDestruidos.setFont(new java.awt.Font("Nintendo NES Font", 0, 8));
        lblTextoTanquesDestruidos.setForeground(new java.awt.Color(255, 255, 255));
        lblTextoTanquesDestruidos.setText("TANQUES DESTRUIDOS:");
        lblTextoTanquesDestruidos.setMaximumSize(new java.awt.Dimension(60, 35));
        lblTextoTanquesDestruidos.setMinimumSize(new java.awt.Dimension(60, 35));
        lblTextoTanquesDestruidos.setPreferredSize(new java.awt.Dimension(60, 35));

        lblContadorDestruidos.setBackground(new java.awt.Color(99, 99, 99));
        lblContadorDestruidos.setFont(new java.awt.Font("Nintendo NES Font", 0, 8));
        lblContadorDestruidos.setForeground(new java.awt.Color(255, 153, 0));
        lblContadorDestruidos.setText("0");
        lblContadorDestruidos.setDoubleBuffered(true);
        lblContadorDestruidos.setMaximumSize(new java.awt.Dimension(60, 35));
        lblContadorDestruidos.setMinimumSize(new java.awt.Dimension(60, 35));
        lblContadorDestruidos.setOpaque(true);
        lblContadorDestruidos.setPreferredSize(new java.awt.Dimension(60, 35));

        lblContadorDisparos.setBackground(new java.awt.Color(99, 99, 99));
        lblContadorDisparos.setFont(new java.awt.Font("Nintendo NES Font", 0, 8));
        lblContadorDisparos.setForeground(new java.awt.Color(255, 153, 0));
        lblContadorDisparos.setText("0");
        lblContadorDisparos.setDoubleBuffered(true);
        lblContadorDisparos.setMaximumSize(new java.awt.Dimension(60, 35));
        lblContadorDisparos.setMinimumSize(new java.awt.Dimension(60, 35));
        lblContadorDisparos.setOpaque(true);
        lblContadorDisparos.setPreferredSize(new java.awt.Dimension(60, 35));

        lblTextoDisparosRealizados.setFont(new java.awt.Font("Nintendo NES Font", 0, 8));
        lblTextoDisparosRealizados.setForeground(new java.awt.Color(255, 255, 255));
        lblTextoDisparosRealizados.setText("DISPAROS REALIZADOS:");
        lblTextoDisparosRealizados.setMaximumSize(new java.awt.Dimension(60, 35));
        lblTextoDisparosRealizados.setMinimumSize(new java.awt.Dimension(60, 35));
        lblTextoDisparosRealizados.setPreferredSize(new java.awt.Dimension(60, 35));

        lblTextoPowerUps.setFont(new java.awt.Font("Nintendo NES Font", 0, 8));
        lblTextoPowerUps.setForeground(new java.awt.Color(255, 255, 255));
        lblTextoPowerUps.setText("POWER-UPS RECOGIDOS:");
        lblTextoPowerUps.setMaximumSize(new java.awt.Dimension(60, 35));
        lblTextoPowerUps.setMinimumSize(new java.awt.Dimension(60, 35));
        lblTextoPowerUps.setPreferredSize(new java.awt.Dimension(60, 35));

        lblContadorPowerUps.setBackground(new java.awt.Color(99, 99, 99));
        lblContadorPowerUps.setFont(new java.awt.Font("Nintendo NES Font", 0, 8));
        lblContadorPowerUps.setForeground(new java.awt.Color(255, 153, 0));
        lblContadorPowerUps.setText("0");
        lblContadorPowerUps.setDoubleBuffered(true);
        lblContadorPowerUps.setMaximumSize(new java.awt.Dimension(60, 35));
        lblContadorPowerUps.setMinimumSize(new java.awt.Dimension(60, 35));
        lblContadorPowerUps.setOpaque(true);
        lblContadorPowerUps.setPreferredSize(new java.awt.Dimension(60, 35));

        lblInmune.setBackground(new java.awt.Color(99, 99, 99));
        lblInmune.setFont(new java.awt.Font("Nintendo NES Font", 0, 18));
        lblInmune.setForeground(new java.awt.Color(255, 255, 255));
        lblInmune.setText("IMMUNE");
        lblInmune.setDoubleBuffered(true);
        lblInmune.setOpaque(true);

        javax.swing.GroupLayout pnlContadoresLayout = new javax.swing.GroupLayout(pnlContadores);
        pnlContadores.setLayout(pnlContadoresLayout);
        pnlContadoresLayout.setHorizontalGroup(
            pnlContadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContadoresLayout.createSequentialGroup()
                .addGroup(pnlContadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlContadoresLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblInmune, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblTextoPowerUps, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTextoDisparosRealizados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTextoTanquesDestruidos, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlContadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblContadorDestruidos, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblContadorDisparos, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                    .addComponent(lblContadorPowerUps, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlContadoresLayout.setVerticalGroup(
            pnlContadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContadoresLayout.createSequentialGroup()
                .addContainerGap(359, Short.MAX_VALUE)
                .addComponent(lblInmune, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91)
                .addGroup(pnlContadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTextoTanquesDestruidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblContadorDestruidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlContadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTextoDisparosRealizados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblContadorDisparos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlContadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTextoPowerUps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblContadorPowerUps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlJuego, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlNiveles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlContadores, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlJuego, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlContadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlNiveles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblBanderita;
    private javax.swing.JLabel lblContadorDestruidos;
    private javax.swing.JLabel lblContadorDisparos;
    private javax.swing.JLabel lblContadorPowerUps;
    public javax.swing.JLabel lblInmune;
    private javax.swing.JLabel lblLetraI;
    private javax.swing.JLabel lblLetraP;
    private javax.swing.JLabel lblStage;
    private javax.swing.JLabel lblTanquecin;
    private javax.swing.JLabel lblTextoDisparosRealizados;
    private javax.swing.JLabel lblTextoPowerUps;
    private javax.swing.JLabel lblTextoTanquesDestruidos;
    private javax.swing.JLabel lblVidas;
    private javax.swing.JPanel pnlContadores;
    public javax.swing.JPanel pnlJuego;
    private javax.swing.JPanel pnlNiveles;
    private javax.swing.JPanel pnlTanquesRestantes;
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
