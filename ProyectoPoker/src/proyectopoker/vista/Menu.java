/*Descripcion de la clase:
La clase menu es la primera ventana con la que el usuario interactua. Se encargar de darle la facilidad al usuario de escoger
la cantidad de jugadores y le permite guardar sus nombres y les da acceso a iniciar la partida.
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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Menu extends JFrame implements ActionListener{
     public Menu() {
        this.setTitle("Poker");
        ajustarConfiguracionInicial();
        agregarComponentes(this.getContentPane());
    }

    private void ajustarConfiguracionInicial() {
        this.setSize(900, 400); //(x,y)
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

    public void cerrarAplicacion() {

        if (JOptionPane.showConfirmDialog(this, "Desea cerrar la aplicacion?",
                "Confirmar",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }

    }

    public void mostrar() {
        this.setVisible(true);
        
    }

    public void iniciar() {
        mostrar();
    }
    
    private void agregarComponentes(Container c) {
    Insets margen=new Insets(0,0,0,0);
    
    //JCombobox
    cantJugadores=new JComboBox(vecJugadores); 
    //botones
    jugar=new JButton();
    jugar.setIcon(new ImageIcon(getClass().getResource("../imagen/jugar.png")));
    jugar.setMargin(margen);
    aux=new JButton();
    
    //labels
    fondoMenu=new JLabel();
    lbJugadores=new JLabel("Cantidad de Jugadores: ");
    lbJugadores.setForeground(Color.white);
    nombreJugador=new JLabel("  Nombre o nombres:    ");
    nombreJugador.setForeground(Color.white);
    fondoMenu.setIcon(new ImageIcon(getClass().getResource("../imagen/fondo2.png")));
    //JTextfield
    campoJ1=new JTextField();
    campoJ1.setBackground(Color.red);
    campoJ2=new JTextField();
    campoJ2.setBackground(Color.gray);
    campoJ3=new JTextField();
    campoJ3.setBackground(Color.red);
    campoJ4=new JTextField();
    campoJ4.setBackground(Color.gray);
    
    //eventos
    cantJugadores.addItemListener( new ItemListener() {
             @Override
            public void itemStateChanged(ItemEvent e) {
             if ( e.getStateChange() == ItemEvent.SELECTED )
                guardaCantJugador=cantJugadores.getSelectedIndex();
                guardaNomJugador=new String[guardaCantJugador];
                
             if (guardaCantJugador==1){
                campoJ1.setBackground(Color.white);
                }
             if (guardaCantJugador==2){
                campoJ1.setBackground(Color.white); 
                campoJ2.setBackground(Color.white);
                }
             if (guardaCantJugador==3){
                campoJ1.setBackground(Color.white);
                campoJ2.setBackground(Color.white);
                campoJ3.setBackground(Color.white);
                }   
             if (guardaCantJugador==4){
                campoJ1.setBackground(Color.white);
                campoJ2.setBackground(Color.white);
                campoJ3.setBackground(Color.white);
                campoJ4.setBackground(Color.white);
                }
            }
         }
         );
    
    //paneles
    //panel principal
    panelPrincipal=new JPanel();
    panelPrincipal.setLayout(new BorderLayout());
    panelPrincipal.setBackground(Color.black);
    
    panelMenuPrincipal=new JPanel();
    panelMenuPrincipal.setBackground(Color.black);
    
    //panel Opciones
    panelOpciones=new JPanel();
    panelOpciones.setBackground(Color.black);
    
    panelTF=new JPanel();
    panelTF.setLayout(new GridBagLayout());
    panelTF.setBackground(Color.black);
    GridBagConstraints gbc=new GridBagConstraints ();
    gbc.fill=GridBagConstraints.HORIZONTAL; //forma horizontal 
    
    gbc.gridx=0; //x columna
    gbc.gridy=0; //y fila
    panelTF.add(new JLabel("                           "),gbc);

    gbc.gridx=0; //x columna
    gbc.gridy=1; //y fila
    panelTF.add(campoJ1,gbc);

    gbc.gridx=0; //x columna
    gbc.gridy=2; //y fila
    panelTF.add(campoJ2,gbc);

    gbc.gridx=0; //x columna
    gbc.gridy=3; //y fila
    panelTF.add(campoJ3,gbc);

    gbc.gridx=0; //x columna
    gbc.gridy=4; //y fila
    panelTF.add(campoJ4,gbc);
    
    gbc.gridx=0; //x columna
    gbc.gridy=5; //y fila
    panelTF.add(new JLabel("                          "),gbc);
    
    //panelOpciones
    panelOpciones.add(lbJugadores);
    panelOpciones.add(cantJugadores);
    panelOpciones.add(nombreJugador);
    panelOpciones.add(panelTF);
    panelOpciones.add(new JLabel("        "));
    panelOpciones.add(jugar);
    //panelMenuPrincipal
    panelMenuPrincipal.add(new JLabel("        "));
    panelMenuPrincipal.add(fondoMenu);
    //panel principal
    panelPrincipal.add(panelMenuPrincipal,BorderLayout.CENTER); 
    panelPrincipal.add(panelOpciones,BorderLayout.PAGE_END); 
    
    c.add(panelPrincipal);
    
    aux.addActionListener(this);
    jugar.addActionListener(this);
    
    }

    // atributos 
    private JPanel panelPrincipal,panelOpciones,panelTF
    ,panelMenuPrincipal;
    private JButton aux,jugar;
    private JLabel fondoMenu,lbJugadores, nombreJugador;
    private JComboBox cantJugadores;
    private JTextField campoJ1,campoJ2,campoJ3,campoJ4;
    
    String [] vecJugadores ={" ","1","2","3","4"};
    String [] guardaNomJugador;
    String nombre1, nombre2, nombre3, nombre4;
    int guardaCantJugador;
     
    @Override
    public void actionPerformed(ActionEvent e) {
    aux=(JButton)e.getSource();
    if (aux.equals(jugar)){
    llenaVector();
    this.setVisible(false);
    iniciaVentana();
    }
    }
    
    public void llenaVector(){
    int largo=guardaCantJugador;
    if(largo==1){
    guardaNomJugador[0]=campoJ1.getText();
    nombre1=campoJ1.getText();
    }
    if(largo==2){
    guardaNomJugador[0]=campoJ1.getText();
    guardaNomJugador[1]=campoJ2.getText();
    nombre1=campoJ1.getText();
    nombre2=campoJ2.getText();
    
    }
    if(largo==3){
    guardaNomJugador[0]=campoJ1.getText();
    guardaNomJugador[1]=campoJ2.getText();
    guardaNomJugador[2]=campoJ3.getText();
    nombre1=campoJ1.getText();
    nombre2=campoJ2.getText();
    nombre3=campoJ3.getText();
    
    }
    if(largo==4){
    guardaNomJugador[0]=campoJ1.getText();
    guardaNomJugador[1]=campoJ2.getText();
    guardaNomJugador[2]=campoJ3.getText();
    guardaNomJugador[3]=campoJ4.getText();
    nombre1=campoJ1.getText();
    nombre2=campoJ2.getText();
    nombre3=campoJ3.getText();
    nombre4=campoJ4.getText();
    }
    }
    
    public void iniciaVentana(){
    if (guardaCantJugador==1){
    VentanaPrincipal ventana=new VentanaPrincipal(nombre1,guardaCantJugador);
    ventana.iniciar();
    }
    if (guardaCantJugador==2){
    VentanaPrincipal ventana1=new VentanaPrincipal(nombre1,nombre2,guardaCantJugador);
    ventana1.iniciar();
    }
    if (guardaCantJugador==3){
    VentanaPrincipal ventana2=new VentanaPrincipal(nombre1,nombre2,nombre3,guardaCantJugador);
    ventana2.iniciar();
    }
    if (guardaCantJugador==4){
    VentanaPrincipal ventana3=new VentanaPrincipal(nombre1,nombre2,nombre3,nombre4,guardaCantJugador);
    ventana3.iniciar();
    }
    
    }
}
