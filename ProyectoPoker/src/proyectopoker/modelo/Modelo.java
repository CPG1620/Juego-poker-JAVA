/*Descripcion de la clase:
La clase Modelo es la encarga de efectuar los cambios y ejecutar los metodos del juego en ella se actualizan los cambios
efectuados por el usuario.
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
package proyectopoker.modelo;

import java.util.Observable;
import org.w3c.dom.Node;

public class Modelo extends Observable {

    public Modelo(){
    baraja=new Baraja(); 
    }
    public void cargar(){
    baraja.cargar();
    actualizar("Se ha actualizado");
    }
    
    public void cargarFichas(){
    baraja.cargarFichas();
    actualizar("Se ha actualizado");
    }
    
    public void agregar(Jugadores jugador){
    baraja.Agregar(jugador);
    baraja.exportarJugadoresToXML();
    actualizar("Se ha actualizado");
    }
    
    public void leerXML(Node nodo)
    {
    baraja.leerXML(nodo);
    actualizar("Se ha actualizado");
    }
    
    public void devuelveCarta(int p){
    baraja.devuelveCarta(p);
    actualizar(baraja.devuelveCarta(p));
    }
    
    public void devuelveFondo(int jugador,int apuesta){
    baraja.devuelveFondo(jugador, apuesta);
    actualizar(baraja.devuelveFondo(jugador, apuesta));
    }
    
    public void ganador(int jugadores){
    baraja.ganador(jugadores);
    actualizar(baraja.ganador(jugadores));
    }
    
    public void actualizar(Object evento){
    setChanged();
    notifyObservers(evento);
    }


//atributos
Baraja baraja;
}
