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
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * Panel que organiza los botones del cat�logo
 */
public class PanelBotonesCatalogo extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    private static final String OPCION_1 = "OPCION_1";
    private static final String OPCION_2 = "OPCION_2";
    private static final String AGREGAR_LIBRO = "AGREGAR_LIBRO";

    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Bot�n extensi�n 1
     */
    private JButton botonOpcion1;

    /**
     * Bot�n extensi�n 2
     */
    private JButton botonOpcion2;
    /**
     * Bot�n Agregar Libro
     */
    private JButton botonAgregarLibro;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Instancia del la clase principal de la interfaz
     */

    private InterfazTiendaLibros ventanaPrincipal;
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea el panel de operaciones.
     * @param principal Ventana principal. principal != null.
     */
    public PanelBotonesCatalogo( InterfazTiendaLibros principal )
    {
        setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
        setLayout( new GridLayout( 1, 3, 8, 1 ) );
        ventanaPrincipal = principal;

        botonAgregarLibro = new JButton( );
        inicializarBotones( botonAgregarLibro, "Adicionar libro", PanelBotonesCatalogo.AGREGAR_LIBRO, Color.black, "Adicionar un nuevo libro al cat�logo" );
        add( botonAgregarLibro );

        botonOpcion1 = new JButton( );
        inicializarBotones( botonOpcion1, "Opci�n 1", PanelBotonesCatalogo.OPCION_1, Color.black, "Opcion 1" );
        add( botonOpcion1 );

        botonOpcion2 = new JButton( );
        inicializarBotones( botonOpcion2, "Opci�n 2", PanelBotonesCatalogo.OPCION_2, Color.black, "Opcion 2" );
        add( botonOpcion2 );

    }

    /**
     * Define las propiedades para un bot�n.
     * @param boton Bot�n al cual se le definen las propiedades. boton !=null.
     * @param etiqueta Texto de presentaci�n del bot�n. etiqueta != null.
     * @param comando Acci�n asociada al bot�n. comando != null
     * @param colorTexto Color del texto del bot�n. colorTexto != null.
     * @param ayuda Texto de ayuda del bot�n. ayuda != null.
     */
    private void inicializarBotones( JButton boton, String etiqueta, String comando, Color colorTexto, String ayuda )
    {
        boton.setText( etiqueta );
        boton.setFocusable( false );
        boton.setActionCommand( comando );
        boton.addActionListener( this );
        boton.setForeground( colorTexto );
        boton.setToolTipText( ayuda );
        boton.setDefaultCapable( false );
    }

    /**
     * Atiende los eventos del usuario.
     * @param evento Evento generado por el usuario. evento != null.
     */
    public void actionPerformed( ActionEvent evento )
    {
        String actionCommand = evento.getActionCommand( );

        // Bot�n Agregar Libro
        if( actionCommand.equals( PanelBotonesCatalogo.AGREGAR_LIBRO ) )
        {
            ventanaPrincipal.agregarLibro( );
        }
        // Bot�n opci�n 1
        else if( actionCommand.equals( PanelBotonesCatalogo.OPCION_1 ) )
        {
            ventanaPrincipal.reqFuncOpcion1( );
        }
        // Bot�n opci�n 2
        else if( actionCommand.equals( PanelBotonesCatalogo.OPCION_2 ) )
        {
            ventanaPrincipal.reqFuncOpcion2( );
        }
    }
}