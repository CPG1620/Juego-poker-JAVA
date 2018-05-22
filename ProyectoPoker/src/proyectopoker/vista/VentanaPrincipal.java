/*Descripcion de la clase:
Esta clase Ventana Principal es donde se muestra todo lo grafico,  es donde se inicia el hilo y ademas es donde se crean 
los paneles que van a almacenar las cartas, las fichas respectivas de cada jugador se muestra las cartas de la casa y del 
juego.
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
package proyectopoker.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import proyectopoker.control.Control;
import proyectopoker.modelo.Jugadores;
import java.io.File;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import xml.UtilidadesXML;

public class VentanaPrincipal extends JFrame implements Observer, Runnable{
    //constructor para un jugador
    public VentanaPrincipal(String pNombre, int i) {
        nombre1=pNombre;
        cantNombres=i;
        this.setTitle("Poker");
        ajustarConfiguracionInicial();
        agregarComponentes(this.getContentPane());
        eventos();
    }
    //constructor para dos jugadores
    public VentanaPrincipal(String pNombre, String sNombre, int cantidad) {
        nombre1=pNombre;
        nombre2=sNombre;
        cantNombres=cantidad;
        this.setTitle("Poker");
        ajustarConfiguracionInicial();
        agregarComponentes(this.getContentPane());
        eventos();
    }
    //constructor para tres jugadores
    public VentanaPrincipal(String pNombre, String sNombre, String tNombre, int cantidad) {
        nombre1=pNombre;
        nombre2=sNombre;
        nombre3=tNombre;
        cantNombres=cantidad;
        this.setTitle("Poker");
        ajustarConfiguracionInicial();
        agregarComponentes(this.getContentPane());
        eventos();
    }
    //constructor para cuatro jugadores
    public VentanaPrincipal(String pNombre, String sNombre, String tNombre, String cNombre, int cantidad) {
        nombre1=pNombre;
        nombre2=sNombre;
        nombre3=tNombre;
        nombre4=cNombre;
        cantNombres=cantidad;
        this.setTitle("Poker");
        ajustarConfiguracionInicial();
        agregarComponentes(this.getContentPane());
        eventos();
    }
    //ajusta la configuracion de la ventana
    private void ajustarConfiguracionInicial() {
        if (cantNombres==1){
        this.setSize(500,530); //(x,y) 
        }
        if(cantNombres==2){
        this.setSize(550,530); //(x,y) 
        }
        if(cantNombres==3){
        this.setSize(800,530); //(x,y) 
        }
        if (cantNombres==4){
        this.setSize(1000,530);
        } //(x,y)
        this.setLocationRelativeTo(null);//pone ventana en el centro
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); //para cerrar la aplicacion
        this.setResizable(false);//permite modificar el tamaÃ±o de la ventana, false no, true si
        //evento cierre de ventana 
        this.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                cerrarAplicacion();
            }

        });

    }
    //cierra la aplciacion
    public void cerrarAplicacion() {

        if (JOptionPane.showConfirmDialog(this, "Desea cerrar la aplicacion?",
                "Confirmar",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }

    }
    //vuelve a escribir los jugadores para que no se pierdan los datos
    private void leerPersonas(String nombreArchivo){
        File file = new File(nombreArchivo);    
        Document documentoXML = UtilidadesXML.crearXMLDocumento(file);
        Node raiz = documentoXML.getDocumentElement();
        control.leerXML(raiz);
    }
    //inicia el juego
    public void iniciar() {
    control.registrar(this);
    control.cargar();
    control.cargarFichas();
    setVisible(true);
    leerPersonas("Registro.xml");
    btnApuestaJ1.setEnabled(false);
    btnApuestaJ2.setEnabled(false);
    btnApuestaJ3.setEnabled(false);
    btnApuestaJ4.setEnabled(false);
    }
    
    //metodos para agregar
    //setea imagenes y numeros de las cartas
    public void simbolosyNumeros(){
    //cartas
    simboloA1=new JLabel();
    simboloA2=new JLabel();
    simboloB1=new JLabel();
    simboloB2=new JLabel();
    simboloC1=new JLabel();
    simboloC2=new JLabel();
    simboloD1=new JLabel();
    simboloD2=new JLabel();
    simboloJ1=new JLabel();
    simboloJ2=new JLabel();
    simboloJ3=new JLabel();
    simboloJ4=new JLabel();
    simboloJ5=new JLabel();
    simboloCasa1=new JLabel();
    simboloCasa2=new JLabel();
    fichasJ1=new JLabel("10000");
    fichasJ2=new JLabel("10000");
    fichasJ3=new JLabel("10000");
    fichasJ4=new JLabel("10000");
    fichasCasa=new JLabel(String.valueOf(casaFichas));
    
    apuestaJ1=new JLabel(" ");
    apuestaJ2=new JLabel(" ");
    apuestaJ3=new JLabel(" ");
    apuestaJ4=new JLabel(" ");
    apuestaCasa=new JLabel(" ");
    campoApuestaJ1=new JTextField(5);
    campoApuestaJ2=new JTextField(5);
    campoApuestaJ3=new JTextField(5);
    campoApuestaJ4=new JTextField(5);
    
    simboloA1.setIcon(new ImageIcon(getClass().getResource("../imagen/poker.jpg")));
    simboloA2.setIcon(new ImageIcon(getClass().getResource("../imagen/poker.jpg")));
    simboloB1.setIcon(new ImageIcon(getClass().getResource("../imagen/poker.jpg")));
    simboloB2.setIcon(new ImageIcon(getClass().getResource("../imagen/poker.jpg")));
    simboloC1.setIcon(new ImageIcon(getClass().getResource("../imagen/poker.jpg")));
    simboloC2.setIcon(new ImageIcon(getClass().getResource("../imagen/poker.jpg")));
    simboloD1.setIcon(new ImageIcon(getClass().getResource("../imagen/poker.jpg")));
    simboloD2.setIcon(new ImageIcon(getClass().getResource("../imagen/poker.jpg")));
    simboloJ1.setIcon(new ImageIcon(getClass().getResource("../imagen/poker.jpg")));
    simboloJ2.setIcon(new ImageIcon(getClass().getResource("../imagen/poker.jpg")));
    simboloJ3.setIcon(new ImageIcon(getClass().getResource("../imagen/poker.jpg")));
    simboloJ4.setIcon(new ImageIcon(getClass().getResource("../imagen/poker.jpg")));
    simboloJ5.setIcon(new ImageIcon(getClass().getResource("../imagen/poker.jpg")));
    simboloCasa1.setIcon(new ImageIcon(getClass().getResource("../imagen/poker.jpg")));
    simboloCasa2.setIcon(new ImageIcon(getClass().getResource("../imagen/poker.jpg")));
    
    //numeros
    numeroA1=new JLabel(" ");
    numeroA2=new JLabel(" ");
    numeroB1=new JLabel(" ");
    numeroB2=new JLabel(" ");
    numeroC1=new JLabel(" ");
    numeroC2=new JLabel(" ");
    numeroD1=new JLabel(" ");
    numeroD2=new JLabel(" ");
    numeroJ1=new JLabel(" ");
    numeroJ2=new JLabel(" ");
    numeroJ3=new JLabel(" ");
    numeroJ4=new JLabel(" ");
    numeroJ5=new JLabel(" ");
    numeroCasa1=new JLabel(" ");
    numeroCasa2=new JLabel(" ");
    pot=new JLabel(" ");
    tiempo=new JLabel("0:0");
    }
    //inicializa los paneles principales del juego
    public void panelesPrincipales(){
     //PANEL PRINCIPAL
    panelPrincipal=new JPanel();
    panelPrincipal.setLayout(new BorderLayout());
    panelPrincipal.setBackground(colorJuego);
    
    //PANEL QUE CONTIENE LAS CARTAS DE LOS JUGADORES
    panelJugadores= new JPanel();
    panelJugadores.setBackground(colorJuego);
    //PANEL QUE CONTIENE LAS CARTAS DEL JUEGO
    panelJuego= new JPanel();
    panelJuego.setBackground(colorJuego);
    
    //CONTIENE LAS CARTAS DE LA CASA
    panelCasa= new JPanel();
    panelCasa.setBackground(colorJuego);
    
    }
    //crea las cartas del juego
    public void cartas(){
      //CARTAS JUGADORES
      //JUGADOR1
    panelJug1=new JPanel();
    panelJug1.setBorder(BorderFactory.createTitledBorder(nombre1));
    panelJug1.setBackground(colorJuego); 
    cartaA=new JPanel();
    cartaA.setLayout(new BorderLayout());
    cartaA.setBorder(BorderFactory.createTitledBorder(""));
    cartaA.setBackground(Color.white);
    cartaA1=new JPanel();
    cartaA1.setLayout(new BorderLayout());
    cartaA1.setBorder(BorderFactory.createTitledBorder(""));
    cartaA1.setBackground(Color.white);
    
    //JUGADOR2
    panelJug2=new JPanel();
    panelJug2.setBorder(BorderFactory.createTitledBorder(nombre2));
    panelJug2.setBackground(colorJuego);
    cartaB=new JPanel();
    cartaB.setLayout(new BorderLayout());
    cartaB.setBorder(BorderFactory.createTitledBorder(""));
    cartaB.setBackground(Color.white);
    cartaB1=new JPanel();
    cartaB1.setLayout(new BorderLayout());
    cartaB1.setBorder(BorderFactory.createTitledBorder(""));
    cartaB1.setBackground(Color.white);
    
    //JUGADOR3
    panelJug3=new JPanel();
    panelJug3.setBorder(BorderFactory.createTitledBorder(nombre3));
    panelJug3.setBackground(colorJuego);
    cartaC=new JPanel();
    cartaC.setLayout(new BorderLayout());
    cartaC.setBorder(BorderFactory.createTitledBorder(""));
    cartaC.setBackground(Color.white);
    cartaC1=new JPanel();
    cartaC1.setLayout(new BorderLayout());
    cartaC1.setBorder(BorderFactory.createTitledBorder(""));
    cartaC1.setBackground(Color.white);
    
    //JUGADOR4
    panelJug4=new JPanel();
    panelJug4.setBorder(BorderFactory.createTitledBorder(nombre4));
    panelJug4.setBackground(colorJuego);
    cartaD=new JPanel();
    cartaD.setLayout(new BorderLayout());
    cartaD.setBorder(BorderFactory.createTitledBorder(""));
    cartaD.setBackground(Color.white);
    cartaD1=new JPanel();
    cartaD1.setLayout(new BorderLayout());
    cartaD1.setBorder(BorderFactory.createTitledBorder(""));
    cartaD1.setBackground(Color.white);
    
    //CARTAS DEL JUEGO
    panelJuegoCartas=new JPanel();
    panelJuegoCartas.setBorder(BorderFactory.createTitledBorder("JUEGO"));
    panelJuegoCartas.setBackground(colorJuego);
    
    cartaJuego1=new JPanel();
    cartaJuego1.setLayout(new BorderLayout());
    cartaJuego1.setBorder(BorderFactory.createTitledBorder(""));
    cartaJuego1.setBackground(Color.white);
    cartaJuego2=new JPanel();
    cartaJuego2.setLayout(new BorderLayout());
    cartaJuego2.setBorder(BorderFactory.createTitledBorder(""));
    cartaJuego2.setBackground(Color.white);
    cartaJuego3=new JPanel();
    cartaJuego3.setLayout(new BorderLayout());
    cartaJuego3.setBorder(BorderFactory.createTitledBorder(""));
    cartaJuego3.setBackground(Color.white);
    cartaJuego4=new JPanel();
    cartaJuego4.setLayout(new BorderLayout());
    cartaJuego4.setBorder(BorderFactory.createTitledBorder(""));
    cartaJuego4.setBackground(Color.white);
    cartaJuego5=new JPanel();
    cartaJuego5.setLayout(new BorderLayout());
    cartaJuego5.setBorder(BorderFactory.createTitledBorder(""));
    cartaJuego5.setBackground(Color.white);
    
    //CARTAS DE LA CASA
    panelCartasCasa=new JPanel();
    panelCartasCasa.setBorder(BorderFactory.createTitledBorder("CASA"));
    panelCartasCasa.setBackground(colorJuego);
    cartaCasa1=new JPanel();
    cartaCasa1.setLayout(new BorderLayout());
    cartaCasa1.setBorder(BorderFactory.createTitledBorder(""));
    cartaCasa1.setBackground(Color.white);
    cartaCasa2=new JPanel();
    cartaCasa2.setLayout(new BorderLayout());
    cartaCasa2.setBorder(BorderFactory.createTitledBorder(""));
    cartaCasa2.setBackground(Color.white);
  
    }
    //coloca las cartas del juego
    public void posCartas(){
    
    //SE AGREGAN LOS COMPONENTES
    
    //JUGADOR1
    cartaA.add(numeroA1,BorderLayout.PAGE_START);
    cartaA.add(simboloA1,BorderLayout.CENTER); 
    cartaA1.add(numeroA2,BorderLayout.PAGE_START);
    cartaA1.add(simboloA2,BorderLayout.CENTER);
    //JUGADOOR2
    cartaB.add(numeroB1,BorderLayout.PAGE_START);
    cartaB.add(simboloB1,BorderLayout.CENTER); 
    cartaB1.add(numeroB2,BorderLayout.PAGE_START);
    cartaB1.add(simboloB2,BorderLayout.CENTER);
    //JUAGDOR3
    cartaC.add(numeroC1,BorderLayout.PAGE_START);
    cartaC.add(simboloC1,BorderLayout.CENTER); 
    cartaC1.add(numeroC2,BorderLayout.PAGE_START);
    cartaC1.add(simboloC2,BorderLayout.CENTER);
    //JUGADOR4
    cartaD.add(numeroD1,BorderLayout.PAGE_START);
    cartaD.add(simboloD1,BorderLayout.CENTER); 
    cartaD1.add(numeroD2,BorderLayout.PAGE_START);
    cartaD1.add(simboloD2,BorderLayout.CENTER);
   
    //CARTASJUEGO
    cartaJuego1.add(numeroJ1,BorderLayout.PAGE_START);
    cartaJuego1.add(simboloJ1,BorderLayout.CENTER); 
    cartaJuego2.add(numeroJ2,BorderLayout.PAGE_START);
    cartaJuego2.add(simboloJ2,BorderLayout.CENTER);
    cartaJuego3.add(numeroJ3,BorderLayout.PAGE_START);
    cartaJuego3.add(simboloJ3,BorderLayout.CENTER); 
    cartaJuego4.add(numeroJ4,BorderLayout.PAGE_START);
    cartaJuego4.add(simboloJ4,BorderLayout.CENTER);
    cartaJuego5.add(numeroJ5,BorderLayout.PAGE_START);
    cartaJuego5.add(simboloJ5,BorderLayout.CENTER);
    //CARTAS CASA
    cartaCasa1.add(numeroCasa1,BorderLayout.PAGE_START);
    cartaCasa1.add(simboloCasa1,BorderLayout.CENTER); 
    cartaCasa2.add(numeroCasa2,BorderLayout.PAGE_START);
    cartaCasa2.add(simboloCasa2,BorderLayout.CENTER);
    // SE AGREGA TODO A LOS PANELES PRINCIPALES PARA DARLE LA UBICACION EN PANTALLA
    panelJug1.add(cartaA);
    panelJug1.add(cartaA1);
    panelJug2.add(cartaB);
    panelJug2.add(cartaB1);
    panelJug3.add(cartaC);
    panelJug3.add(cartaC1);
    panelJug4.add(cartaD);
    panelJug4.add(cartaD1);
    
    panelJuegoCartas.add(cartaJuego1);
    panelJuegoCartas.add(cartaJuego2);
    panelJuegoCartas.add(cartaJuego3);
    panelJuegoCartas.add(cartaJuego4);
    panelJuegoCartas.add(cartaJuego5);
    
    panelCartasCasa.add(cartaCasa1);
    panelCartasCasa.add(cartaCasa2);
    
    }
    //paneles de las apuestas
    public void apuestas(){
    Insets margen=new Insets(0,0,0,0);
    panelApuestaJ1=new JPanel();
    panelApuestaJ1.setLayout(new GridBagLayout());
    panelApuestaJ1.setBorder(BorderFactory.createTitledBorder(""));
    panelApuestaJ1.setBackground(colorJuego);
    
    GridBagConstraints gbc=new GridBagConstraints();
    //arriba izquierda abajo derecha
    gbc.insets =new Insets(4,8,4,8);
        
        gbc.gridx=0;
        gbc.gridy=0;
        panelApuestaJ1.add(new JLabel("Fichas"),gbc);
        
        gbc.gridx=0;
        gbc.gridy=1;
        panelApuestaJ1.add(fichasJ1,gbc);
   
        gbc.gridx=0;
        gbc.gridy=2;
        btnApuestaJ1=new JButton("Apuesta");
        btnApuestaJ1.setMargin(margen);
        panelApuestaJ1.add(btnApuestaJ1,gbc);
        
        gbc.gridx=0;
        gbc.gridy=3;
        panelApuestaJ1.add(apuestaJ1,gbc);
   
        gbc.gridx=0;
        gbc.gridy=4;
        
        panelApuestaJ1.add(campoApuestaJ1,gbc);

    panelApuestaJ2=new JPanel();
    panelApuestaJ2.setLayout(new GridBagLayout());
    panelApuestaJ2.setBorder(BorderFactory.createTitledBorder(""));
    panelApuestaJ2.setBackground(colorJuego);
    
    GridBagConstraints gbc1=new GridBagConstraints();
    //arriba izquierda abajo derecha
    gbc1.insets =new Insets(4,8,4,8);
        
        gbc1.gridx=0;
        gbc1.gridy=0;
        panelApuestaJ2.add(new JLabel("Fichas"),gbc1);
        
        gbc1.gridx=0;
        gbc1.gridy=1;
        panelApuestaJ2.add(fichasJ2,gbc1);
   
        gbc1.gridx=0;
        gbc1.gridy=2;
        btnApuestaJ2=new JButton("Apuesta");
        btnApuestaJ2.setMargin(margen);
        panelApuestaJ2.add(btnApuestaJ2,gbc1);

        gbc.gridx=0;
        gbc.gridy=3;
        panelApuestaJ2.add(apuestaJ2,gbc);
   
        gbc1.gridx=0;
        gbc1.gridy=4;
        panelApuestaJ2.add(campoApuestaJ2,gbc1);

    panelApuestaJ3=new JPanel();
    panelApuestaJ3.setLayout(new GridBagLayout());
    panelApuestaJ3.setBorder(BorderFactory.createTitledBorder(""));
    panelApuestaJ3.setBackground(colorJuego);
    
    GridBagConstraints gbc2=new GridBagConstraints();
    //arriba izquierda abajo derecha
     gbc2.insets =new Insets(4,8,4,8);
        
        gbc2.gridx=0;
        gbc2.gridy=0;
        panelApuestaJ3.add(new JLabel("Fichas"),gbc2);
        
        gbc2.gridx=0;
        gbc2.gridy=1;
        panelApuestaJ3.add(fichasJ3,gbc2);
   
        gbc2.gridx=0;
        gbc2.gridy=2;
        btnApuestaJ3=new JButton("Apuesta");
        btnApuestaJ3.setMargin(margen);
        panelApuestaJ3.add(btnApuestaJ3,gbc2);

        gbc.gridx=0;
        gbc.gridy=3;
        panelApuestaJ3.add(apuestaJ3,gbc);
   
        
        gbc2.gridx=0;
        gbc2.gridy=4;
        panelApuestaJ3.add(campoApuestaJ3,gbc2);

    panelApuestaJ4=new JPanel();
    panelApuestaJ4.setLayout(new GridBagLayout());
    panelApuestaJ4.setBorder(BorderFactory.createTitledBorder(""));
    panelApuestaJ4.setBackground(colorJuego);
    
    GridBagConstraints gbc3=new GridBagConstraints();
    //arriba izquierda abajo derecha
     gbc3.insets =new Insets(4,8,4,8);
        
        gbc3.gridx=0;
        gbc3.gridy=0;
        panelApuestaJ4.add(new JLabel("Fichas"),gbc3);
        
        gbc3.gridx=0;
        gbc3.gridy=1;
        panelApuestaJ4.add(fichasJ4,gbc3);
   
        gbc3.gridx=0;
        gbc3.gridy=2;
        btnApuestaJ4=new JButton("Apuesta");
        btnApuestaJ4.setMargin(margen);
        panelApuestaJ4.add(btnApuestaJ4,gbc3);

        gbc.gridx=0;
        gbc.gridy=3;
        panelApuestaJ4.add(apuestaJ4,gbc);
   
        
        gbc3.gridx=0;
        gbc3.gridy=4;
        panelApuestaJ4.add(campoApuestaJ4,gbc3);

        
    panelIniciar=new JPanel();
    panelIniciar.setLayout(new GridBagLayout());
    panelIniciar.setBorder(BorderFactory.createTitledBorder(""));
    panelIniciar.setBackground(colorJuego);
    
    GridBagConstraints gbc4=new GridBagConstraints();
    //arriba izquierda abajo derecha
     gbc4.insets =new Insets(4,8,4,8);
        
        gbc4.gridx=0;
        gbc4.gridy=0;
        mostrar=new JButton("mostrar");
        panelIniciar.add(mostrar,gbc4);
   
        gbc4.gridx=0;
        gbc4.gridy=1;
        
        panelIniciar.add(new JLabel  ("   POT   "),gbc4);
        
        gbc4.gridx=0;
        gbc4.gridy=2;
        
        panelIniciar.add(pot,gbc4);

        gbc4.gridx=0;
        gbc4.gridy=4;
        panelIniciar.add(tiempo,gbc4);
    
    panelApuestasCasa=new JPanel();
    panelApuestasCasa.setLayout(new GridBagLayout());
    panelApuestasCasa.setBorder(BorderFactory.createTitledBorder(""));
    panelApuestasCasa.setBackground(colorJuego);
    
    GridBagConstraints gbc5=new GridBagConstraints();
    //arriba izquierda abajo derecha
     gbc5.insets =new Insets(4,8,4,8);
        
        gbc5.gridx=0;
        gbc5.gridy=0;
        panelApuestasCasa.add(new JLabel("Fichas"),gbc5);
        
        gbc5.gridx=0;
        gbc5.gridy=1;
        panelApuestasCasa.add(fichasCasa,gbc5);
   
        gbc5.gridx=0;
        gbc5.gridy=2;
        panelApuestasCasa.add(new JLabel("Apuesta"),gbc5);

        gbc5.gridx=0;
        gbc5.gridy=3;
        panelApuestasCasa.add(apuestaCasa,gbc5);

    }
    //jugador en pantalla
    public void cantJugadores(){
    
    //VALIDACION PARA SABER CUANTOS JUGADORES TIENE QUE DIBUJAR EN PANTALLA
    if (cantNombres==1){
    panelJug1.add(panelApuestaJ1);
    panelJugadores.add(panelJug1);}
    if (cantNombres==2){
    panelJug1.add(panelApuestaJ1);
    panelJug2.add(panelApuestaJ2);
    panelJugadores.add(panelJug2);
    panelJugadores.add(panelJug1);
    }
    if (cantNombres==3){
    panelJug1.add(panelApuestaJ1);
    panelJug2.add(panelApuestaJ2);
    panelJug3.add(panelApuestaJ3);
    panelJugadores.add(panelJug3);
    panelJugadores.add(panelJug2);
    panelJugadores.add(panelJug1);}
    if (cantNombres==4){
    panelJug1.add(panelApuestaJ1);
    panelJug2.add(panelApuestaJ2);
    panelJug3.add(panelApuestaJ3);
    panelJug4.add(panelApuestaJ4);
    panelJugadores.add(panelJug4);
    panelJugadores.add(panelJug3);
    panelJugadores.add(panelJug2);
    panelJugadores.add(panelJug1);}
    
    }
    //se agregan los paneles principales al contenedor
    private void agregarComponentes(Container c) {
    simbolosyNumeros();
    panelesPrincipales();
    cartas();
    posCartas();
    apuestas();
    cantJugadores();

    panelJuegoCartas.add(panelIniciar);
    panelJuego.add(panelJuegoCartas);
    panelCartasCasa.add(panelApuestasCasa);
    panelCasa.add(panelCartasCasa);

    //se agregan los componentes al panel principal
    panelPrincipal.add(panelCasa,BorderLayout.PAGE_START); 
    panelPrincipal.add(panelJugadores,BorderLayout.PAGE_END); 
    panelPrincipal.add(panelJuego,BorderLayout.CENTER);
    c.add(panelPrincipal, BorderLayout.CENTER);
  
    }
    //metodo que muestra las cartas ocultas en cada ronda
    public void cartaOculta(int p){
    if(p==1){
    simboloJ2.setIcon(new ImageIcon(getClass().getResource(simboloCO2)));
    numeroJ2.setText(numeroCO2); 
    }
    if(p==2){
    simboloJ1.setIcon(new ImageIcon(getClass().getResource(simboloCO1)));
    numeroJ1.setText(numeroCO1); 
    }
    }
    //metodo que muestra todas las cartas al mismo tiempo asi el jugador
    //puede verificar el juego
    public void todasLasCartas(){
            simboloA1.setIcon(new ImageIcon(getClass().getResource(auxA1)));
            numeroA1.setText(auxNA1);
            simboloA2.setIcon(new ImageIcon(getClass().getResource(auxA2)));
            numeroA2.setText(auxNA2);
            simboloB1.setIcon(new ImageIcon(getClass().getResource(auxB1)));
            numeroB1.setText(auxNB1);
            simboloB2.setIcon(new ImageIcon(getClass().getResource(auxB2)));
            numeroB2.setText(auxNB2);
            simboloC1.setIcon(new ImageIcon(getClass().getResource(auxC1)));
            numeroC1.setText(auxNC1);
            simboloC2.setIcon(new ImageIcon(getClass().getResource(auxC2)));
            numeroC2.setText(auxNC2);
            simboloD1.setIcon(new ImageIcon(getClass().getResource(auxD1)));
            numeroD1.setText(auxND1);
            simboloD2.setIcon(new ImageIcon(getClass().getResource(auxD2)));
            numeroD2.setText(auxND2);
            simboloCasa1.setIcon(new ImageIcon(getClass().getResource(auxCasa1)));
            numeroCasa1.setText(auxNCasa1);
            simboloCasa2.setIcon(new ImageIcon(getClass().getResource(auxCasa2)));
            numeroCasa2.setText(auxNCasa2);         
    }
    //setea las cartas para que no sean visibles y comenzar la siguiente ronda
    public void siguienteRonda(){
            try {
            Thread.sleep(4000);
            } catch (InterruptedException ex) {}
        
            String numero=" "; 
            String direccion="../imagen/poker.jpg";
            simboloA1.setIcon(new ImageIcon(getClass().getResource(direccion)));
            numeroA1.setText(numero);
            simboloA2.setIcon(new ImageIcon(getClass().getResource(direccion)));
            numeroA2.setText(numero);
            simboloB1.setIcon(new ImageIcon(getClass().getResource(direccion)));
            numeroB1.setText(numero);
            simboloB2.setIcon(new ImageIcon(getClass().getResource(direccion)));
            numeroB2.setText(numero);
            simboloC1.setIcon(new ImageIcon(getClass().getResource(direccion)));
            numeroC1.setText(numero);
            simboloC2.setIcon(new ImageIcon(getClass().getResource(direccion)));
            numeroC2.setText(numero);
            simboloD1.setIcon(new ImageIcon(getClass().getResource(direccion)));
            numeroD1.setText(numero);
            simboloD2.setIcon(new ImageIcon(getClass().getResource(direccion)));
            numeroD2.setText(numero);
            simboloCasa1.setIcon(new ImageIcon(getClass().getResource(direccion)));
            numeroCasa1.setText(numero);
            simboloCasa2.setIcon(new ImageIcon(getClass().getResource(direccion)));
            numeroCasa2.setText(numero);
            simboloJ1.setIcon(new ImageIcon(getClass().getResource(direccion)));
            numeroJ1.setText(numero);
            simboloJ2.setIcon(new ImageIcon(getClass().getResource(direccion)));
            numeroJ2.setText(numero);
            simboloJ3.setIcon(new ImageIcon(getClass().getResource(direccion)));
            numeroJ3.setText(numero);
            simboloJ4.setIcon(new ImageIcon(getClass().getResource(direccion)));
            numeroJ4.setText(numero);
            simboloJ5.setIcon(new ImageIcon(getClass().getResource(direccion)));
            numeroJ5.setText(numero); 
    }
    //metodo que suma el monto del pot al ganador, recibe como parametro el pot
    public void nuevoFondo(int ganador){
    if(ganador==1){
    control.devuelveFondo(1,-auxPot);
    }
    if(ganador==2){
    control.devuelveFondo(2,-auxPot);
    }
    if(ganador==3){
    control.devuelveFondo(3,-auxPot);
    }
    if(ganador==4){
     control.devuelveFondo(4,-auxPot);
    }
    if(ganador==5){
     fichasCasa.setText(String.valueOf(casaFichas+auxPot));
    }
    
    }
    //metodo que continee los eventos de los botones del juego
    public void eventos(){
    mostrar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            if(banderaJuego==2){
            cartaOculta(2);
            todasLasCartas();
            control.ganador(cantNombres);
            }
            if(banderaJuego==1){
            cartaOculta(1);
            btnApuestaJ1.setEnabled(true);
            simboloA1.setIcon(new ImageIcon(getClass().getResource(auxA1)));
            numeroA1.setText(auxNA1); 
            simboloA2.setIcon(new ImageIcon(getClass().getResource(auxA2)));
            numeroA2.setText(auxNA2);
            banderaJuego++;
            }
            if(banderaJuego==0){
            for(int i=0;i<15;i++){
            control.devuelveCarta(i);
            }
            iniciarThread();
            btnApuestaJ1.setEnabled(true);
            simboloA1.setIcon(new ImageIcon(getClass().getResource(auxA1)));
            numeroA1.setText(auxNA1); 
            simboloA2.setIcon(new ImageIcon(getClass().getResource(auxA2)));
            numeroA2.setText(auxNA2);
            banderaJuego++;
            }
            if(banderaJuego==-1){
            bandera=14;
            banderaJuego=0;
            control.cargar();
            }
            
           
            }
            
        });
   btnApuestaJ1.addActionListener(new ActionListener() {
        
            @Override
            public void actionPerformed(ActionEvent e) {
            String numero="  "; 
            String direccion="../imagen/poker.jpg";
            fondoJugador=0;
            control.devuelveFondo(1, Integer.parseInt(campoApuestaJ1.getText()));
            auxPot=auxPot+Integer.parseInt(campoApuestaJ1.getText());
            pot.setText(String.valueOf(auxPot));
            campoApuestaJ1.setText("");
            simboloA1.setIcon(new ImageIcon(getClass().getResource(direccion)));
            numeroA1.setText(numero);
            
            simboloA2.setIcon(new ImageIcon(getClass().getResource(direccion)));
            numeroA2.setText(numero);
     
            simboloB1.setIcon(new ImageIcon(getClass().getResource(auxB1)));
            numeroB1.setText(auxNB1);
            
            simboloB2.setIcon(new ImageIcon(getClass().getResource(auxB2)));
            numeroB2.setText(auxNB2);
     
            btnApuestaJ1.setEnabled(false);
            btnApuestaJ2.setEnabled(true);
            btnApuestaJ3.setEnabled(false);
            btnApuestaJ4.setEnabled(false);
            casaFichas=casaFichas-400;
            apuestaCasa.setText("400");
            fichasCasa.setText(String.valueOf(casaFichas));
            auxPot=auxPot+400; 
            pot.setText(String.valueOf(auxPot));
            
            }
        });
    
     
   btnApuestaJ2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            String numero="  "; 
            String direccion="../imagen/poker.jpg";
            fondoJugador=1;
            control.devuelveFondo(2, Integer.parseInt(campoApuestaJ2.getText()));
            auxPot=auxPot+Integer.parseInt(campoApuestaJ2.getText());
            pot.setText(String.valueOf(auxPot));
            campoApuestaJ2.setText("");
            
            simboloB1.setIcon(new ImageIcon(getClass().getResource(direccion)));
            numeroB1.setText(numero);
            
            simboloB2.setIcon(new ImageIcon(getClass().getResource(direccion)));
            numeroB2.setText(numero);
     
            simboloC1.setIcon(new ImageIcon(getClass().getResource(auxC1)));
            numeroC1.setText(auxNC1);
            
            simboloC2.setIcon(new ImageIcon(getClass().getResource(auxC2)));
            numeroC2.setText(auxNC2);
     
            btnApuestaJ1.setEnabled(false);
            btnApuestaJ2.setEnabled(false);
            btnApuestaJ3.setEnabled(true);
            btnApuestaJ4.setEnabled(false);
            
            }
        });
    
     
   btnApuestaJ3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            String numero="  "; 
            String direccion="../imagen/poker.jpg";
            fondoJugador=2;
            control.devuelveFondo(3, Integer.parseInt(campoApuestaJ3.getText()));
            auxPot=auxPot+Integer.parseInt(campoApuestaJ3.getText());
            pot.setText(String.valueOf(auxPot));
            campoApuestaJ3.setText("");
            
            simboloC1.setIcon(new ImageIcon(getClass().getResource(direccion)));
            numeroC1.setText(numero);
            
            simboloC2.setIcon(new ImageIcon(getClass().getResource(direccion)));
            numeroC2.setText(numero);
     
            simboloD1.setIcon(new ImageIcon(getClass().getResource(auxD1)));
            numeroD1.setText(auxND1);
            
            simboloD2.setIcon(new ImageIcon(getClass().getResource(auxD2)));
            numeroD2.setText(auxND2);
            
            btnApuestaJ1.setEnabled(false);
            btnApuestaJ2.setEnabled(false);
            btnApuestaJ3.setEnabled(false);
            btnApuestaJ4.setEnabled(true);
            
            }
        });
    
     
   btnApuestaJ4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            String numero="  "; 
            String direccion="../imagen/poker.jpg";
            fondoJugador=3;
            control.devuelveFondo(4, Integer.parseInt(campoApuestaJ4.getText()));
            auxPot=auxPot+Integer.parseInt(campoApuestaJ4.getText());
            pot.setText(String.valueOf(auxPot)); 
            campoApuestaJ4.setText("");
            
            simboloD1.setIcon(new ImageIcon(getClass().getResource(direccion)));
            numeroD1.setText(numero);
            
            simboloD2.setIcon(new ImageIcon(getClass().getResource(direccion)));
            numeroD2.setText(numero);
            
            btnApuestaJ1.setEnabled(false);
            btnApuestaJ2.setEnabled(false);
            btnApuestaJ3.setEnabled(false);
            btnApuestaJ4.setEnabled(false);
            
            }
        });
     
     } 
    //metodo que guarda las cartas, recibe como parametro la carta
    public void muestra(int p){
     String numero=String.valueOf(p); 
     String direccion="../imagen/poker.jpg";
     
     
     if(p<11){
     direccion="../imagen/Corazones.jpg";
     }
     if(p>=12 &&p<20){
     numero=String.valueOf(numero.charAt(1));
     direccion="../imagen/Trebol.jpg";
     }
     if(p==20){
     numero="10";
     direccion="../imagen/Trebol.jpg";
     }
     if(p>=22 &&p<30){
     numero=String.valueOf(numero.charAt(1));
     direccion="../imagen/Brillos.jpg";
     }
     if(p==30){
     numero="10";
     direccion="../imagen/Brillos.jpg";
     }
     if(p>=32 &&p<40){
     numero=String.valueOf(numero.charAt(1));
     direccion="../imagen/Espadas.jpg";
     }
     if(p==40){
     numero="10";    
     direccion="../imagen/Espadas.jpg";
     }
     if(p>=50){
     if(String.valueOf(numero.charAt(1)).equals("0")){
     direccion="../imagen/Corazones.jpg";   
     }
     if(String.valueOf(numero.charAt(1)).equals("1")){
     direccion="../imagen/Trebol.jpg";    
     }
     if(String.valueOf(numero.charAt(1)).equals("2")){
     direccion="../imagen/Brillos.jpg";
     }
     if(String.valueOf(numero.charAt(1)).equals("3")){
     direccion="../imagen/Espadas.jpg";    
     }     
     if(String.valueOf(numero.charAt(0)).equals("5")){
     numero="K";    
     }
     if(String.valueOf(numero.charAt(0)).equals("6")){
     numero="J";    
     }
     if(String.valueOf(numero.charAt(0)).equals("7")){
     numero="Q";    
     }
     if(String.valueOf(numero.charAt(0)).equals("8")){
     numero="A";    
     }
     
     }
     
     
     if(bandera==0){
     auxD2=direccion;
     auxND2=numero;
     }
     if(bandera==1){
     auxD1=direccion;
     auxND1=numero;
     bandera--;
     }
     if(bandera==2){
     auxC2=direccion;
     auxNC2=numero;
     bandera--;
     }
     if(bandera==3){
     auxC1=direccion;
     auxNC1=numero;
     bandera--;
     }
     if(bandera==4){
     auxB2=direccion;
     auxNB2=numero;
     bandera--;
     }
     if(bandera==5){
     auxB1=direccion;
     auxNB1=numero;
     bandera--;
     }
     if(bandera==6){
     auxA2=direccion;
     auxNA2=numero;
     bandera--;
     }
     if(bandera==7){
     auxA1=direccion;
     auxNA1=numero;
     bandera--;
     }
     if(bandera==8){
     auxCasa2=direccion;
     auxNCasa2=numero;
     bandera--;
     }
     if(bandera==9){
     auxCasa1=direccion;
     auxNCasa1=numero;
     bandera--;
     }
     if(bandera==10){
     simboloCO1=direccion;
     numeroCO1=numero;
     bandera--;
     }
     if(bandera==11){
     simboloCO2=direccion;
     numeroCO2=numero;
     bandera--;
     }
     if(bandera==12){
     simboloJ3.setIcon(new ImageIcon(getClass().getResource(direccion)));
     numeroJ3.setText(numero);
     bandera--;
     }
     if(bandera==13){
     simboloJ4.setIcon(new ImageIcon(getClass().getResource(direccion)));
     numeroJ4.setText(numero);
     bandera--;
     }
     if(bandera==14){
     simboloJ5.setIcon(new ImageIcon(getClass().getResource(direccion)));
     numeroJ5.setText(numero);
     bandera--;
     }
     
     
     }
 
    @Override
    public void update(Observable modelo, Object evento) {
        if (evento instanceof Integer){
        int prueba=(Integer)evento;
        muestra(prueba);
        }
        
        if (evento instanceof String){
        String prueba=(String)evento;
        
        if(prueba=="ganaCasa"||prueba=="ganaJ1" ||prueba=="ganaJ2" ||prueba=="ganaJ3" || prueba=="ganaJ4" || prueba=="empate")   
        {
         
         if(prueba=="ganaCasa"){
          JOptionPane.showMessageDialog(null,"La Casa ha ganado");
          nuevoFondo(5);
          Jugadores xml=new Jugadores("Casa", String.valueOf(ObtenerMinutos()), String.valueOf(ObtenerSegundos()));
          control.agregar(xml);
         }
         if(prueba=="ganaJ1"){
          JOptionPane.showMessageDialog(null,nombre1+" ha ganado");
          nuevoFondo(1);
          Jugadores xml=new Jugadores(nombre1, String.valueOf(ObtenerMinutos()), String.valueOf(ObtenerSegundos()));
          control.agregar(xml);
        
         }
         if(prueba=="ganaJ2"){
          JOptionPane.showMessageDialog(null,nombre2+" ha ganado");
          nuevoFondo(2);
          Jugadores xml=new Jugadores(nombre2, String.valueOf(ObtenerMinutos()), String.valueOf(ObtenerSegundos()));
          control.agregar(xml);
        
         }
         if(prueba=="ganaJ3"){
          JOptionPane.showMessageDialog(null,nombre3+" ha ganado");
          nuevoFondo(3);
          Jugadores xml=new Jugadores(nombre3, String.valueOf(ObtenerMinutos()), String.valueOf(ObtenerSegundos()));
          control.agregar(xml);
        
         }
         if(prueba=="ganaJ4"){
          JOptionPane.showMessageDialog(null,nombre4+" ha ganado");
          nuevoFondo(4);
          Jugadores xml=new Jugadores(nombre4, String.valueOf(ObtenerMinutos()), String.valueOf(ObtenerSegundos()));
          control.agregar(xml);
        
         }
         if(prueba=="empate"){
          JOptionPane.showMessageDialog(null,"Juego Empatado");
         }
         
         siguienteRonda();
         repaint(); 
         banderaJuego=-1;
         auxPot=0;
         pot.setText("");
         reiniciarThread();
         } 
         else if(prueba!="Se ha actualizado"){
         if(fondoJugador==3){
         fichasJ4.setText(prueba);
         }
         if(fondoJugador==2){
         fichasJ3.setText(prueba);
         }
         if(fondoJugador==1){
         fichasJ2.setText(prueba);
         }
         if(fondoJugador==0){
         fichasJ1.setText(prueba);
        }
        }
        }
    }
    //inicia el thread del tiempo
    public void iniciarThread(){
     juego = true;
     if(hiloObjetos == null)
     hiloObjetos = new Thread(this);
     if(hiloObjetos != null)
     hiloObjetos.start();
    }
    //run del tiempo
    @Override
    public void run() {
        while (juego){
            try{
              //tiempo
            
              if (segundos != 59){
                segundos = aumentaSegundos();
            }else{
                segundos = 0;
                ReseteaSegundos();
                if (minutos != 59){
                    minutos = aumentaMinutos();
                }else{
                    minutos = 0;
                    ReseteaMinutos();
                }
            }
             repaint();
             Thread.sleep(600);
            }catch(InterruptedException ex)
            {
                System.out.print("Ocurrio un error.... :(");}
        }
    }
    //reiniciar el tiempo
    public void reiniciarThread(){
    ReseteaMinutos();
    ReseteaSegundos();
    hiloObjetos = null;
    juego = false;
    repaint();
    }
    //Metodo que aumenta los segundos
    public synchronized int aumentaSegundos(){
       segundos++;
       tiempo.setText(String.valueOf(minutos)+":"+String.valueOf(segundos));
       return segundos;
    }
    //Metodo que aumenta los minutos
    public synchronized int aumentaMinutos(){
        minutos++;
        tiempo.setText(String.valueOf(minutos)+":"+String.valueOf(segundos));
       
        return minutos;
    }
    //Resetea los valores de los segundos
    public void ReseteaSegundos(){
        tiempo.setText(String.valueOf(minutos)+":"+"0");
        segundos = 0;
    }
    //Resetea los valores de los minutos
    public void ReseteaMinutos(){
        tiempo.setText("0"+":"+String.valueOf(segundos));
        minutos = 0;
    }
    //devuelve los segundos
    public synchronized int ObtenerSegundos(){
        return segundos;
    }
    //devuelve los minutos
    public synchronized int ObtenerMinutos(){
        return minutos;
    }
    //pregunta si el tiempo sigue en curso
    public synchronized void Seguir(){
        continuar = true;
    }
    //detiene el tiempo
    public synchronized void Detener(){
        continuar = false;
    }
    //devuelve el curso del tiempo
    public synchronized boolean IsSeguir(){
        return continuar;
    }
    
    // atributos 
    //A primer jugador, B segundo, C tercero y D cuarto
    //J simbolos de las cartas del juego
    private JPanel panelPrincipal, panelJugadores,panelJuego,panelJuegoCartas,
    panelCasa,panelCartasCasa,panelJug1 ,panelJug2, panelJug3,panelJug4,cartaA,
    cartaA1, cartaB, cartaB1, cartaC, cartaC1, cartaD, cartaD1,cartaJuego1,
    cartaJuego2,cartaJuego3,cartaJuego4,cartaJuego5,cartaCasa1,cartaCasa2, 
    panelApuestaJ1, panelApuestaJ2,panelApuestaJ3,panelApuestaJ4
    ,panelApuestasCasa, panelIniciar;
    //label de los simbolos de las cartas
    private JLabel simboloA1, simboloA2, simboloB1, simboloB2,
    simboloC1, simboloC2,simboloD1, simboloD2,
    simboloJ1,simboloJ2,simboloJ3,simboloJ4,simboloJ5,
    simboloCasa1,simboloCasa2;
    //label de los numeros de las cartas.
    private JLabel numeroA1,numeroA2, numeroB1,numeroB2, numeroC1,numeroC2, 
    numeroD1,numeroD2,
    numeroJ1,numeroJ2,numeroJ3,numeroJ4,numeroJ5,
    numeroCasa1,numeroCasa2,pot;
    //label fichas
    private JLabel fichasJ1,fichasJ2,fichasJ3,fichasJ4, fichasCasa,
    apuestaJ1,apuestaJ2,apuestaJ3,apuestaJ4,apuestaCasa;
    private JLabel tiempo;
    //campos apuestas
    private JTextField campoApuestaJ1,campoApuestaJ2,campoApuestaJ3,campoApuestaJ4;
    //botones
    private JButton btnApuestaJ1,btnApuestaJ2,btnApuestaJ3,btnApuestaJ4,mostrar;
    
    String nombre1,nombre2,nombre3,nombre4;
    int cantNombres;
    private String simboloCO2,simboloCO1,auxA1,auxA2,auxB1,auxB2,auxC1,auxC2,
    auxD1,auxD2,auxCasa1,auxCasa2;
    private String numeroCO2,numeroCO1,auxNA1,auxNA2,auxNB1,auxNB2,auxNC1,auxNC2
    ,auxND1,auxND2,auxNCasa1,auxNCasa2;
    
    public final static Color colorJuego = new Color(38,138,44);
    Control control=new Control();
    private int bandera=14;
    private int fondoJugador=0;
    private int auxPot=0;
    private int banderaJuego=0;
    private int casaFichas=100000;
    private Thread hiloObjetos;
    private int segundos;
    private int minutos;
    private boolean continuar = true;
    private boolean juego= true;
    
}