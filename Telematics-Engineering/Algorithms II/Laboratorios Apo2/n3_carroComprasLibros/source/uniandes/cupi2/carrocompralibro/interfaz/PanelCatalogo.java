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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import uniandes.cupi2.carrocompralibro.mundo.Libro;
import uniandes.cupi2.carrocompralibro.mundo.TiendaLibros;

/**
 * Panel para el manejo del Cat�logo
 */
public class PanelCatalogo extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    private static final String AGREGAR_CARRO = "AGREGAR_CARRO";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * Modelo de la tabla del cat�logo
     */
    private TablaModeloCatalogo catalogo;

    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    /**
     * Tabla del cat�logo
     */
    private JTable tablaCatalogo;

    /**
     * Barra de desplazamiento
     */
    private JScrollPane desplazamientoPanel;

    /**
     * Instancia del la clase principal de la interfaz
     */
    private InterfazTiendaLibros ventanaPrincipal;

    /**
     * Bot�n Comprar Libro
     */
    private JButton botonComprarLibro;

    /**
     * Etiqueta t�tulo
     */
    private JLabel etiquetaCantidad;

    /**
     * Campo del t�tulo
     */
    private JTextField txtCantidad;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea el panel que maneja el cat�logo.
     * @param interfaz Interfaz principal. interfaz != null.
     * @param tienda Tienda de libros a desplegar. tienda != null.
     */

    public PanelCatalogo( InterfazTiendaLibros interfaz, TiendaLibros tienda )
    {
        ventanaPrincipal = interfaz;

        setLayout( new BorderLayout( ) );
        setBorder( new EmptyBorder( 5, 1, 5, 1 ) );
        setBorder( BorderFactory.createTitledBorder( "Detalle del cat�logo" ) );

        // Crea la tabla para el cat�logo
        catalogo = new TablaModeloCatalogo( tienda );
        tablaCatalogo = new JTable( catalogo );
        tablaCatalogo.setPreferredScrollableViewportSize( new Dimension( 480, 100 ) );

        desplazamientoPanel = new JScrollPane( tablaCatalogo );
        add( desplazamientoPanel, BorderLayout.CENTER );

        //Bot�n de compra y cantidad
        JPanel panelCompra = new JPanel( );
        panelCompra.setLayout( new FlowLayout( ) );
        panelCompra.setPreferredSize( new Dimension( 200, 50 ) );

        //Cantidad
        JPanel panelCantidad = new JPanel( );
        etiquetaCantidad = new JLabel( "Cantidad " );
        etiquetaCantidad.setPreferredSize( new Dimension( 100, 20 ) );
        txtCantidad = new JTextField( );
        txtCantidad.setPreferredSize( new Dimension( 100, 20 ) );
        txtCantidad.setColumns( 15 );
        txtCantidad.setPreferredSize( new Dimension( 100, 20 ) );
        panelCantidad.setLayout( new GridLayout( 3, 0 ) );
        panelCantidad.setPreferredSize( new Dimension( 80, 50 ) );
        panelCantidad.add( etiquetaCantidad );
        panelCantidad.add( txtCantidad );
        panelCompra.add( panelCantidad );

        botonComprarLibro = new JButton( );
        inicializarBotones( botonComprarLibro, "Comprar", PanelCatalogo.AGREGAR_CARRO, Color.black, "Agregar libro al carro de compras" );
        panelCompra.add( botonComprarLibro );
        add( panelCompra, BorderLayout.SOUTH );

    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Actualiza la informaci�n que se despliega en el cat�logo
     */
    public void actualizarCatalogo( )
    {
        catalogo.fireTableDataChanged( );
    }

    /**
     * Define las propiedades para un bot�n.
     * @param boton Bot�n al cual se le definen las propiedades. boton != null.
     * @param etiqueta Texto de presentaci�n del bot�n. etiqueta != null.
     * @param comando Acci�n asociada al bot�n. comando != null.
     * @param colorTexto Color del texto de presentaci�n. colorTexto != null.
     * @param ayuda Texto ayuda del bot�n. ayuda != null.
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
     * Respuestas a los eventos ejecutados por el usuario.
     * @param evento Evento generado por el usuario. evento !=null.
     */
    public void actionPerformed( ActionEvent evento )
    {
        String actionCommand = evento.getActionCommand( );

        if( actionCommand.equals( PanelCatalogo.AGREGAR_CARRO ) )
        {
            //Saca la cantidad
            int cantidad;
            try
            {
                cantidad = Integer.parseInt( txtCantidad.getText( ) );
                if( cantidad <= 0 )
                {
                    JOptionPane.showMessageDialog( this, "La cantidad debe ser mayor a cero", "Compra de libro", JOptionPane.ERROR_MESSAGE );
                    return;
                }
            }
            catch( Exception exception )
            {
                JOptionPane.showMessageDialog( this, "Debe ingresar un n�mero", "Compra de libro", JOptionPane.ERROR_MESSAGE );
                return;
            }

            //Saca el libro
            Libro libro;
            try
            {
                libro = ( Libro )tablaCatalogo.getValueAt( tablaCatalogo.getSelectedRow( ), -1 );
            }
            catch( Exception e )
            {
                JOptionPane.showMessageDialog( this, "Debe seleccionar un libro v�lido", "Compra de libro", JOptionPane.ERROR_MESSAGE );
                return;
            }

            //Delega el llamado
            ventanaPrincipal.adicionarCompra( libro, cantidad );
        }

    }
}