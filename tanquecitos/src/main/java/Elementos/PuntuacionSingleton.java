/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Elementos;

/**
 *
 * @author wisfer
 */
public class PuntuacionSingleton extends AbstractObservable{
    private static PuntuacionSingleton 
            puntuacionSingleton;

    private int disparos = 0;
    private int comodines = 0; 
    private int kills = 0;
    private int vidas = 2;
    private int nivel = 1;
    
    private int simples = 0;
    private int rapidos = 0;
    private int fuertes = 0;
    private int reforzados = 0;
    
    private int puntuacion = 0;
            
    
    private PuntuacionSingleton(){}
    
    public static PuntuacionSingleton getInstance()
    {
        if (puntuacionSingleton == null)
            puntuacionSingleton = new PuntuacionSingleton();
        
        return puntuacionSingleton;
    }

    public int getDisparos() {
        return disparos;
    }

    public void setDisparos(int disparos) {
        this.disparos = disparos;
        notifyAllObservers("disparos", this);  
    }

    public int getComodines() {
        return comodines;
    }

    public void setComodines(int comodines) {
        this.comodines = comodines;
        notifyAllObservers("comodines", this);  
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
        notifyAllObservers("kills", this);  
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
        notifyAllObservers("vidas", this);  
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
        notifyAllObservers("nivel", this);  
    }

    public int getSimples() {
        return simples;
    }

    public void setSimples(int simples) {
        this.simples = simples;
    }

    public int getRapidos() {
        return rapidos;
    }

    public void setRapidos(int rapidos) {
        this.rapidos = rapidos;
    }

    public int getFuertes() {
        return fuertes;
    }

    public void setFuertes(int fuertes) {
        this.fuertes = fuertes;
    }

    public int getReforzados() {
        return reforzados;
    }

    public void setReforzados(int reforzados) {
        this.reforzados = reforzados;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
    
    
    
}
