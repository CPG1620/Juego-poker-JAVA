/*Descripcion de la clase:
La clase Baraja es la encargada de almacenar los jugadores, de exportarlos al archivo XML, de cargar las fichas de los jugadores,
de cargar las cartas, de cargar los escenarios y maneja los ganes, empates, derrotas.
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

import java.util.Random;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import xml.UtilidadesXML;

public class Baraja {
    //constructor inicializa los arraylist
    public Baraja() {
    cartas = new ArrayList<>();
    juego = new ArrayList<>();
    }
    //llena el arraylist con las 52 cartas
    public void llenaArraylist(){
    for(int i=0;i<52;i++){
    
    if(numero==74){
    numero=80;
    }
    if(numero==64){
    numero=70;
    }
       
    if(numero==54){
    numero=60;
    }
    
    if(numero==41){
    numero=50;
    }
    if(numero==11){
    numero=12;
    } 
    if(numero==21){
    numero=22;
    }
    if(numero==31){
    numero=32;
    }
    
    cartas.add(numero);
    
    numero++;
    }  
    
    }
    //crea un arraylist con cartas no repetidas
    public int llenaJuego(){
    Random rm = new Random();    
    if(juego.size() < 15){ 
    int numeroR=(int)(rm.nextDouble() * 51 + 0); 
    if(juego.isEmpty()){ 
    juego.add(numeroR); 
    return numeroR;
    }
    else{ 
    if(juego.contains(numeroR)){ 
    return llenaJuego(); 
    }
    else{ 
    juego.add(numeroR); 
    return numeroR;
    } 
    }
    
    } else {
    return -1;
    }
}
    //carga el juego
    public void cargar(){
     llenaArraylist();
     juego.clear();
     for(int i=0;i<15;i++)
     {
     llenaJuego();
     }
    }
    //devuelve lo que contiene el arraylist
    public Jugadores recuperar(int p){
        return jugadores.get(p);
    }
    //agrega al arraylist
    public void Agregar(Jugadores jugador){
        jugadores.add(jugador);
    }
    //Guarda los jugadores registrados en el documento XML
    public void exportarJugadoresToXML(){
        try{
        Document d = UtilidadesXML.crearDocumento();
            Node r = d.createElement("Partida");
            
        for (int i = 0; i < jugadores.size(); i++){
            r.appendChild(recuperar(i).toXML(d));
        }
        d.appendChild(r);
        UtilidadesXML.guardarArchivoXML(d, "Registro.xml");
        }catch (ParserConfigurationException ex) {}
    }
    //lee los datos registrados en el documento, tiene que estar creado
    public void leerXML(Node nodo){
       NodeList arbolEtiquetas = nodo.getChildNodes();
       int numJugadores = arbolEtiquetas.getLength();
       for (int i = 0; i < numJugadores; i++)
       {
           Node etiqueta = arbolEtiquetas.item(i);
           Jugadores lectura = new Jugadores();
           lectura.leerXML(etiqueta);
           jugadores.add(lectura);
       }
    } 
    //setea la cantidad de fichas
    public void cargarFichas(){
     fondoJ1=10000;
     fondoJ2=10000;
     fondoJ3=10000;
     fondoJ4=10000;
    }
    //metodo que devuelve la carta en la posicion p
    public int devuelveCarta(int p){
    int aux=cartas.get(juego.get(p));
    return aux;
    }
    //metodo que devuelve el fondo actual de los jugadores
    public String devuelveFondo(int jugador,int apuesta){
    if(jugador==1){
    fondoJ1=fondoJ1-apuesta/2;
    return String.valueOf(fondoJ1);
    }
    
    if(jugador==2){
    fondoJ2=fondoJ2-apuesta/2;
    return String.valueOf(fondoJ2);
    }
    if(jugador==3){
    fondoJ3=fondoJ3-apuesta/2;
    return String.valueOf(fondoJ3);
    }
    if(jugador==4){
    fondoJ4=fondoJ4-apuesta/2;
    return String.valueOf(fondoJ4);
    }
    else 
    return "";
    }
    //metodo para verificar la carta mas alta
    //recibe posiciones del arraylist del juego
    public int suma(int pos){
    int suma=0;
    if(cartas.get(juego.get(pos))%10==0){
    suma=10;
    }
    
    if(cartas.get(juego.get(pos))%10!=0){
    suma=cartas.get(juego.get(pos))%10;
    }
    
    if(cartas.get(juego.get(pos))>=50){
    suma=10;
    }
    
    if(cartas.get(juego.get(pos))>=80){
    suma=11;
    }
    
    return suma;
    }
    //metodo para verificar el ganador del juego
    public String ganador(int p){
      String ganador="empate";
      sumaJ1=0;
      sumaJ2=0;
      sumaJ3=0;
      sumaJ4=0;
      sumaCasa=0;
      
      if(p==1){
      sumaJ1=suma(7)+suma(8);
      sumaCasa=suma(5)+suma(6);
      
      if(sumaJ1<sumaCasa){
      ganador="ganaCasa";
      }
      if(sumaJ1>sumaCasa){
      ganador="ganaJ1";
      }
      if(sumaJ1==sumaCasa){
      ganador="empate";
      }
      }
        
    if(p==2){
    sumaJ1=suma(7)+suma(8);
    sumaJ2=suma(9)+suma(10);
    sumaCasa=suma(5)+suma(6);
    
    if(sumaJ1>sumaJ2 && sumaJ1>sumaCasa){
    ganador= "ganaJ1";
    }
    else if(sumaJ2>sumaJ1 && sumaJ2>sumaCasa){
    ganador= "ganaJ2";
    }
    else if(sumaCasa>sumaJ1 && sumaCasa>sumaJ2){
    ganador= "ganaCasa";
    }
    
    }
    
    if(p==3){
    sumaJ1=suma(7)+suma(8);
    sumaJ2=suma(9)+suma(10);
    sumaJ3=suma(11)+suma(12);
    sumaCasa=suma(5)+suma(6);
    
    if(sumaJ1>sumaJ2 && sumaJ1>sumaCasa && sumaJ1>sumaJ3){
    ganador= "ganaJ1";
    }
    else if(sumaJ2>sumaJ1 && sumaJ2>sumaCasa && sumaJ2>sumaJ3){
    ganador= "ganaJ2";
    }
    else if(sumaCasa>sumaJ1 && sumaCasa>sumaJ2 && sumaCasa>sumaJ3){
    ganador= "ganaCasa";
    }
    else if(sumaJ3>sumaJ1 && sumaJ3>sumaJ2 && sumaJ3>sumaCasa){
    ganador= "ganaJ3";
    }
    
    }
    
    if(p==4){
    sumaJ1=suma(7)+suma(8);
    sumaJ2=suma(9)+suma(10);
    sumaJ3=suma(11)+suma(12);
    sumaJ4=suma(13)+suma(14);
    sumaCasa=suma(5)+suma(6);
    
    if(sumaJ1>sumaJ2 && sumaJ1>sumaCasa && sumaJ1>sumaJ3 && sumaJ1>sumaJ4){
    ganador= "ganaJ1";
    }
    else if(sumaJ2>sumaJ1 && sumaJ2>sumaCasa && sumaJ2>sumaJ3 && sumaJ2>sumaJ4){
    ganador= "ganaJ2";
    }
    else if(sumaCasa>sumaJ1 && sumaCasa>sumaJ2 && sumaCasa>sumaJ3 && sumaCasa>sumaJ4){
    ganador= "ganaCasa";
    }
    else if(sumaJ3>sumaJ1 && sumaJ3>sumaJ2 && sumaJ3>sumaCasa && sumaJ3>sumaJ4){
    ganador= "ganaJ3";
    }
    else if(sumaJ4>sumaJ1 && sumaJ4>sumaJ2 && sumaJ4>sumaCasa && sumaJ4>sumaJ3){
    ganador= "ganaJ4";
    } 
    }
     
    
    return ganador;
    }
    
    //atributos
    ArrayList<Integer> cartas;
    ArrayList<Integer> juego;
    private int numero=2;
    private int fondoJ1;
    private int fondoJ2;
    private int fondoJ3;
    private int fondoJ4;
    private int sumaJ1;
    private int sumaJ2;
    private int sumaJ3;
    private int sumaJ4;
    private int sumaCasa;
    private ArrayList<Jugadores> jugadores=new ArrayList<>();
   }
