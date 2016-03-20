/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: taquilla
 * Autores: Kelvin Guerrero, Carlos Vega, Luis Ricardo Ruiz y Rafael Mu�oz Lattion- 11-mar-2013
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.taquilla.interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Di�logo para agregar un nuevo socio
 */
public class DialogoAgregarSocio extends JDialog implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Comando para aceptar
     */
    private final static String ACEPTAR = "Aceptar";

    /**
     * Comando para cancelar
     */
    private final static String CANCELAR = "Cancelar";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicaci�n
     */
    private InterfazTaquilla principal;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Campo de texto para el nombre del socio
     */
    private JTextField txtNombre;

    /**
     * Campo de texto para la c�dula del socio
     */
    private JTextField txtCedula;
    
    /**
     * Bot�n para aceptar
     */
    private JButton butAceptar;

    /**
     * Bot�n para cancelar
     */
    private JButton butCancelar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el di�logo para agregar un socio con una referencia a la ventana principal de la aplicaci�n. <br>
     * <b>post: </b> Construy� el panel e principal == ventana.<br>
     * @param ventana Referencia a la ventana principal. ventana != null.
     */
    public DialogoAgregarSocio( InterfazTaquilla ventana )
    {
        principal = ventana;

        setLayout( new GridLayout( 3, 2, 5, 5 ) );
        setTitle( "Agregar Socio" );
        setSize( 400, 125 );
        setResizable( false );
        setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        setModal( true );
        setLocationRelativeTo( ventana );

        JLabel labNombre = new JLabel( "Nombre:" );
        add( labNombre );

        txtNombre = new JTextField( );
        add( txtNombre );
        
        JLabel labCedula = new JLabel( "C�dula:" );
        add( labCedula );

        txtCedula = new JTextField( );
        add( txtCedula );

        butAceptar = new JButton( ACEPTAR );
        butAceptar.setActionCommand( ACEPTAR );
        butAceptar.addActionListener( this );
        add( butAceptar );

        butCancelar = new JButton( CANCELAR );
        butCancelar.setActionCommand( CANCELAR );
        butCancelar.addActionListener( this );
        add( butCancelar );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Manejo de los eventos de los botones
     * @param e Acci�n que gener� el evento.
     */
    public void actionPerformed( ActionEvent e )
    {
        String comando = e.getActionCommand( );

        if( comando.equals( ACEPTAR ) )
        {
            String nombre = txtNombre.getText( ).trim( );
            String cedula = txtCedula.getText( ).trim( );

            if( !nombre.equals( "" ) && !cedula.equals( "" ) )
            {
                principal.agregarSocio( nombre, cedula );
                dispose( );
            }
            else
            {
                JOptionPane.showMessageDialog( principal, "Debe especificar el nombre y la c�dula del socio", "Informaci�n", JOptionPane.INFORMATION_MESSAGE );
            }
        }
        else if( comando.equals( CANCELAR ) )
        {
            dispose( );
        }
    }
}
