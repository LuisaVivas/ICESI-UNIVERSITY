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

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Formulario para agregar un libro al cat�logo
 */
public class DialogoAgregarLibro extends JDialog
{
    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------
    /**
     * Panel de Botones
     */
    private PanelBotonesAgregar panelBotones;

    /**
     * Etiqueta T�tulo
     */
    private JLabel etiquetaTitulo;

    /**
     * Campo del t�tulo
     */
    private JTextField txtTitulo;

    /**
     * Etiqueta ISBN
     */
    private JLabel etiquetaIsbn;

    /**
     * Campo del ISBN
     */
    private JTextField txtIsbn;

    /**
     * Etiqueta Precio
     */
    private JLabel etiquetaPrecio;

    /**
     * Campo del precio
     */
    private JTextField txtPrecio;

    /**
     * Interfaz padre del di�logo
     */
    private InterfazTiendaLibros ventanaPrincipal;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea el formulario de adici�n de libros.
     * @param principal Ventana principal. principal != null.
     */
    public DialogoAgregarLibro( InterfazTiendaLibros principal )
    {
        ventanaPrincipal = principal;

        setLayout( new GridLayout( 1, 4 ) );
        setPreferredSize( new Dimension( 350, 100 ) );

        //T�tulo
        JPanel panelTitulo = new JPanel( );
        etiquetaTitulo = new JLabel( "T�tulo " );
        etiquetaTitulo.setPreferredSize( new Dimension( 100, 20 ) );
        txtTitulo = new JTextField( );
        txtTitulo.setPreferredSize( new Dimension( 100, 20 ) );
        txtTitulo.setColumns( 15 );
        panelTitulo.setLayout( new GridLayout( 3, 0 ) );
        panelTitulo.setPreferredSize( new Dimension( 200, 15 ) );
        panelTitulo.add( etiquetaTitulo );
        panelTitulo.add( txtTitulo );
        add( panelTitulo );

        //ISBN
        JPanel panelIsbn = new JPanel( );
        etiquetaIsbn = new JLabel( "ISBN " );
        etiquetaIsbn.setPreferredSize( new Dimension( 100, 20 ) );
        txtIsbn = new JTextField( );
        txtIsbn.setPreferredSize( new Dimension( 100, 20 ) );
        txtIsbn.setColumns( 15 );
        panelIsbn.setLayout( new GridLayout( 3, 0 ) );
        panelIsbn.setPreferredSize( new Dimension( 200, 15 ) );
        panelIsbn.add( etiquetaIsbn );
        panelIsbn.add( txtIsbn );
        add( panelIsbn );

        //Precio
        JPanel panelPrecio = new JPanel( );
        etiquetaPrecio = new JLabel( "Precio " );
        etiquetaPrecio.setPreferredSize( new Dimension( 100, 20 ) );
        txtPrecio = new JTextField( );
        txtPrecio.setPreferredSize( new Dimension( 100, 20 ) );
        txtPrecio.setColumns( 15 );
        panelPrecio.setLayout( new GridLayout( 3, 0 ) );
        panelPrecio.setPreferredSize( new Dimension( 200, 15 ) );
        panelPrecio.add( etiquetaPrecio );
        panelPrecio.add( txtPrecio );
        add( panelPrecio );

        // Adiciona los botones
        panelBotones = new PanelBotonesAgregar( this );
        add( panelBotones );

        setTitle( "Adicionar libro al cat�logo" );
        pack( );
        setResizable( false );
        setDefaultCloseOperation( DISPOSE_ON_CLOSE );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Acciones a ejecutar cuando se oprime el bot�n aceptar
     */
    public void accionAlAceptar( )
    {
        String titulo, isbn, precio;
        titulo = txtTitulo.getText( );
        isbn = txtIsbn.getText( );
        precio = txtPrecio.getText( );
        int precioLibro;

        if( titulo == null || titulo.equals( "" ) )
        {
            JOptionPane.showMessageDialog( this, "El t�tulo no puede ser vac�o", "Adicionar un libro", JOptionPane.ERROR_MESSAGE );
            return;
        }

        if( isbn == null || isbn.equals( "" ) )
        {
            JOptionPane.showMessageDialog( this, "El ISBN no puede ser vac�o", "Adicionar un libro", JOptionPane.ERROR_MESSAGE );
            return;
        }

        if( ventanaPrincipal.existeLibro( isbn ) )
        {
            JOptionPane.showMessageDialog( this, "Ya existe un libro con el mismo ISBN", "Adicionar un libro", JOptionPane.ERROR_MESSAGE );
            return;
        }

        try
        {
            precioLibro = Integer.parseInt( precio );
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, "El precio no es un valor v�lido", "Adicionar un libro", JOptionPane.ERROR_MESSAGE );
            return;
        }

        if( precioLibro <= 0 )
        {
            JOptionPane.showMessageDialog( this, "El precio debe ser mayor a cero", "Adicionar un libro", JOptionPane.ERROR_MESSAGE );
            return;
        }
        ventanaPrincipal.adicionarLibroCatalogo( titulo, isbn, precioLibro );
        txtTitulo.setText( "" );
        txtIsbn.setText( "" );
        txtPrecio.setText( "" );
        dispose( );

    }

    /**
     * Acciones a ejecutar cuando se oprime el bot�n cancelar
     */
    public void accionAlCancelar( )
    {
        txtTitulo.setText( "" );
        txtIsbn.setText( "" );
        txtPrecio.setText( "" );
        dispose( );
    }
}