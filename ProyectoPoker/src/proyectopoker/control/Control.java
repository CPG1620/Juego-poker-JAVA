/*Descripcion de la clase
La clase control se utiliza para efectuar los eventos producidos por el usuario y enviar la actualizacion al modelo
Aqui podemos registrar, leer el archivo XML y cargar las fichas y el escenario jugadores etc
*/

//Fecha de creación: Miercoles 28 de diciembre del 2016
/*Historial de modificaciones
-Jueves 29 de diciembre del 2016
-Viernes 30 de diciembre del 2016
-Martes 03 de enero del 2017
-Miercoles 04 de enero del 2017
-Jueves 05 de enero del 2017
-Viernes 06 de enero del 2017
-Sabado 07 de enero del 2017
-Lunes 16 de enero del 2017
-Miercoles 18 de enero del 2017
-Jueves 19 de enero del 2017
-Viernes 20 de enero del 2017
-Domingo 22 de enero del 2017
-Lunes 23 de enero del 2017
-Martes 24 de enero del 2017
-Jueves 26 de enero del 2017
-Viernes 27 de enero del 2017
-Sabado 28 de enero del 2017
*/

/*Revisores
-Alex Baltodano
-Andres Barrantes
-Caleb Perez
*/

/**Autores
 * @author Alex Baltodano
 * @author Andres Barrantes
 * @author Caleb Perez
 */

package proyectopoker.control;

import java.util.Observer;
import proyectopoker.modelo.Modelo;
import org.w3c.dom.Node;
import proyectopoker.modelo.Jugadores;

public class Control {
        
    public Control(Modelo nuevosDatos){
        datos = nuevosDatos;
    }
    
    public Control(){
        this(new Modelo());
    }
    
    public void registrar(Observer nuevoObservador){
        datos.addObserver(nuevoObservador);
    }
    
    public void agregar(Jugadores jugador){
        datos.agregar(jugador);
    }
    public void leerXML(Node nodo){
        datos.leerXML(nodo);
    }
    
    public void cargar(){
        datos.cargar();
    }
    public void cargarFichas(){
        datos.cargarFichas();
    }
    
    public void devuelveCarta(int p){
        datos.devuelveCarta(p);
    }
    
    public void devuelveFondo(int jugador,int apuesta){
        datos.devuelveFondo(jugador,apuesta);
    }
    
    public void ganador(int jugadores){
        datos.ganador(jugadores);
    }

    
    //aributos
    Modelo datos;   
}
