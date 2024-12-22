/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Elementos;

/**
 *
 * @author wisfer
 */
public class ConfiguracionSingleton {
    private static ConfiguracionSingleton 
            singletonInstance;

    private double velocidadDisparo;
    private double velocidadMovimiento;
    private double tiempoAparicion;
    
            
    
    private ConfiguracionSingleton()
    {
        velocidadDisparo = 1;
        velocidadMovimiento = 6;
        tiempoAparicion = 2;
    }
    
    public static ConfiguracionSingleton getInstance()
    {
        if (singletonInstance == null)
            singletonInstance = new ConfiguracionSingleton();
        
        return singletonInstance;
    }

    public double getVelocidadDisparo() {
        return velocidadDisparo;
    }

    public void setVelocidadDisparo(double velocidadDisparo) {
        this.velocidadDisparo = velocidadDisparo;
    }

    public double getVelocidadMovimiento() {
        return velocidadMovimiento;
    }

    public void setVelocidadMovimiento(double velocidadMovimiento) {
        this.velocidadMovimiento = velocidadMovimiento;
    }

    public double getTiempoAparicion() {
        return tiempoAparicion;
    }

    public void setTiempoAparicion(double tiempoAparicion) {
        this.tiempoAparicion = tiempoAparicion;
    }

    
    
    
}
