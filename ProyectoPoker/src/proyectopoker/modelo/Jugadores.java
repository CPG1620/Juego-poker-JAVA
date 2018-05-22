/*Descripcion de la clase:
Esta clase es la que crea a cada jugador con su respectivo nombre y el tiempo que dura en hacer las jugadas
y los construye en el archivo XML
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

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import xml.UtilidadesXML;

 public class Jugadores {
    
    public Jugadores(){
    this.nombre="";
    this.tiempo="";
    }
    //constructor que recibe el nombre y el tiempo para el xml
    public Jugadores(String nombre,String minutos, String segundos){
    this.nombre=nombre;
    this.tiempo=minutos+":"+segundos;
    }
    //escritura en xml
    public Node toXML(Document doc) {
    Node n = doc.createElement(getNodeName());
    n.appendChild(UtilidadesXML.crearNodo(doc, "NOMBRE", nombre));
    n.appendChild(UtilidadesXML.crearNodo(doc, "TIEMPO", tiempo));
    return n;
    }
    
    //lectura en xml
    public void leerXML(Node nodo)
    {
        NodeList arbolEtiquetas = nodo.getChildNodes();
        nombre = ((Element)arbolEtiquetas.item(0)).getTextContent();
        tiempo = ((Element)arbolEtiquetas.item(1)).getTextContent();
        
    }
    
    //devuelve el nombre del nodo
    public String getNodeName() {
        return DESCRIPCION_XML;
    }

    //Atributos
    public static final String DESCRIPCION_XML = "jugador";
    private String nombre;
    private String tiempo;
}

