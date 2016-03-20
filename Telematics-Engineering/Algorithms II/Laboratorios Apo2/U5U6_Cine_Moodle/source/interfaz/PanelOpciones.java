/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * $Id$ 
 * Universidad de los Andes (Bogot� - Colombia) 
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 * 
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n4_cine
 * Autor: Pablo Barvo - Sep 19, 2005
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package interfaz;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

/**
 * Panel de manejo de extensiones
 */
public class PanelOpciones extends JPanel implements ActionListener
{
    //-----------------------------------------------------------------
    // Constantes
    //-----------------------------------------------------------------

  
	public final static String CARGAR_SALA = "CARGAR_SALA";
	public final static String SILLA_GANADORA = "SILLA";


    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Ventana principal de la aplicaci�n
     */
    private InterfazCine ventana;

    //-----------------------------------------------------------------
    // Atributos de interfaz
    //-----------------------------------------------------------------

    /**
     * Bot�n Opci�n 1
     */
    private JButton btnCargar;

    /**
     * Bot�n Opci�n 2
     */
    private JButton btnOpcion2;

    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Constructor del panel
     * @param laVentana Ventana principal
     */
    public PanelOpciones( InterfazCine laVentana )
    {
        ventana = laVentana;

        setBorder( new TitledBorder( "Opciones" ) );
        setLayout( new GridLayout( 1, 2 ) );

        //Bot�n opci�n 1
        btnCargar = new JButton( "Cargar Sala" );
        btnCargar.setActionCommand(CARGAR_SALA);
        btnCargar.addActionListener(this);

        add( btnCargar );

        //Bot�n opci�n 2
        btnOpcion2 = new JButton( "Silla Ganadora" );
        btnOpcion2.setActionCommand(SILLA_GANADORA);
        btnOpcion2.addActionListener(this);

        add( btnOpcion2 );
    }

    //-----------------------------------------------------------------
    // M�todos
    //-----------------------------------------------------------------

    /**
     * Manejo de los eventos de los botones
     * @param e Acci�n que gener� el evento.
     */
    public void actionPerformed( ActionEvent e )
    {	
    	String comando = e.getActionCommand();
    	String sillaGanadora = ventana.darSillaGanadora();
    	
    	if(comando.equals(CARGAR_SALA)){
    		ventana.cargarDeArchivo();
    	}else if(comando.equals(SILLA_GANADORA)){
    		 JOptionPane.showMessageDialog(this, "La Silla ganadora es: "+sillaGanadora);
    	}
    	

    }
}
