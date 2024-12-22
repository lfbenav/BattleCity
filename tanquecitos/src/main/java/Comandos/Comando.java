/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comandos;

import Elementos.ConfiguracionSingleton;
import Tanques.Jugador;
import Ventanas.VentanaJuego;

/**
 *
 * @author wisfer
 */
public abstract class Comando implements ICommand{
    
    ConfiguracionSingleton config = ConfiguracionSingleton.getInstance();
    
    @Override       
    public abstract String getCommandName();       
    
    @Override       
    public abstract void execute(VentanaJuego ventana);   
}
