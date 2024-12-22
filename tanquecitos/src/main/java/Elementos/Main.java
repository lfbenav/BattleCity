/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Elementos;

import Comandos.FlechaArriba;
import Comandos.InvocadorInstance;
import Tanques.Tanque;
import Tanques.TanqueFactory;
import Tanques.TanqueFactoryMethod;
import Ventanas.VentanaPrincipal;

/**
 *
 * @author wisfer
 */

/*
  Luis Fernando Benavides
  Proyecto 3 de Programacion Orientada a Objetos

*/
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        new VentanaPrincipal().setVisible(true);
        
        
        /*
        TanqueFactoryMethod fabricaTanques = new TanqueFactory();
        Tanque tanqueNuevo = fabricaTanques.crearTanque(TanqueFactory.SIMPLE, true);
        System.out.println(tanqueNuevo.getInfo());
        */
        
        //ObtenerRutaSprite.get("aa.png");
        
        /*
        FlechaArriba arriba = new FlechaArriba();
        InvocadorInstance invocador = InvocadorInstance.getInstance();
        invocador.recibirComando(arriba);
        invocador.recibirComando(arriba);
        invocador.executeAll();
        */
    }
}
