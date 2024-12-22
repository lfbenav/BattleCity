/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Elementos;
import java.nio.file.Path;
import java.nio.file.Paths;
/**
 *
 * @author wisfer
 */
public final class ObtenerRutaSprite {
    
    public static final String get(String nombre){
        Path path = Paths.get("");
        String nombreDirectorio = path.toAbsolutePath().toString();
        //System.out.println("El directorio actual es " + nombreDirectorio);
        String rutaSprite = nombreDirectorio + "/src/main/java/sprites/" + nombre;
        //System.out.println("La ruta del sprite es " + rutaSprite);
        return rutaSprite;
    }
    
}
