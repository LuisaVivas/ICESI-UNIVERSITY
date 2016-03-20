/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n
 * Licenciado bajo el esquema Academic Free License version 2.1
 *
 * Proyecto Cupi2
 * Ejercicio: Carro de Compras Libros
 * Autor inicial: Katalina Marcos
 * Modificaci�n: Jorge Jim�nez- Junio 2005
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.carrocompralibro.interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Panel que organiza los campos de datos del libro
 */
public class PanelBotonesAgregar extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------
    /**
     * Bot�n Aceptar
     */
    private JButton botonAceptar;

    /**
     * Bot�n Cancelar
     */
    private JButton botonCancelar;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana del di�logo
     */
    private DialogoAgregarLibro ventana;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    /**
     * Crea el Panel donde se colocar�n los botones.
     * @param unaVentana Ventana del di�logo. unaVentana != null.
     */
    public PanelBotonesAgregar( DialogoAgregarLibro unaVentana )
    {

        ventana = unaVentana;
        setPreferredSize( new Dimension( 200, 100 ) );
        setLayout( new FlowLayout( ) );

        // Aceptar
        botonAceptar = new JButton( );
        botonAceptar.setPreferredSize( new Dimension( 80, 25 ) );
        inicializarBotones( botonAceptar, "Aceptar", "ACEPTAR", Color.black );
        add( botonAceptar );

        // Cancelar
        botonCancelar = new JButton( );
        botonCancelar.setPreferredSize( new Dimension( 80, 25 ) );
        inicializarBotones( botonCancelar, "Cancelar", "CANCELAR", Color.black );
        add( botonCancelar );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------
    /**
     * Define las propiedades para un bot�n.
     * @param boton Bot�n al cual se le definen las propiedades. boton !=null.
     * @param etiqueta Texto de presentaci�n del bot�n. etiqueta != null.
     * @param comando Acci�n asociada al bot�n. comando != null
     * @param colorTexto Color del texto del bot�n. colorTexto != null.
     */
    private void inicializarBotones( JButton boton, String etiqueta, String comando, Color colorTexto )
    {
        boton.setText( etiqueta );
        boton.setFocusable( false );
        boton.setActionCommand( comando );
        boton.addActionListener( this );
        boton.setForeground( colorTexto );
        boton.setDefaultCapable( false );
    }

    /**
     * Respuesta a los eventos ejecutados por el usuario.
     * @param evento Evento generado por el usuario. evento != null.
     */
    public void actionPerformed( ActionEvent evento )
    {
        String actionCommand = evento.getActionCommand( );

        // Bot�n Aceptar
        if( actionCommand.equals( "ACEPTAR" ) )
        {
            ventana.accionAlAceptar( );
        }
        // Bot�n Cancelar
        if( actionCommand.equals( "CANCELAR" ) )
        {
            ventana.accionAlCancelar( );
        }
    }
}