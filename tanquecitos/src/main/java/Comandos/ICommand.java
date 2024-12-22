/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Comandos;

import Tanques.Jugador;
import Ventanas.VentanaJuego;

/**
 *
 * @author wisfer
 */
public interface ICommand {
    public String getCommandName();       
    public void execute(VentanaJuego ventana);   
}
