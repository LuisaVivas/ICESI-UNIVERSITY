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

import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.table.AbstractTableModel;

import uniandes.cupi2.carrocompralibro.mundo.Libro;
import uniandes.cupi2.carrocompralibro.mundo.TiendaLibros;

/**
 * Modelo de datos del cat�logo para el despliegue en tablas
 */
public class TablaModeloCatalogo extends AbstractTableModel
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * T�tulos de columnas
     */
    private String[] nombresColumnas;

    /**
     * Tienda de libros
     */
    private TiendaLibros tienda;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea el modelo del cat�logo a partir de la tienda.
     * @param unaTienda Tienda de libros. unaTienda != null.
     */
    public TablaModeloCatalogo( TiendaLibros unaTienda )
    {
        super( );
        tienda = unaTienda;
        String[] nombresColumnasAux = { "ISBN", "T�tulo", "Precio" };
        nombresColumnas = nombresColumnasAux;
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Sobrecarga el m�todo de Table Model y retorna el n�mero de filas para ajustar la tabla de libros.
     * @return n�mero de filas.
     */
    public int getRowCount( )
    {
        return tienda.darCatalogo( ).size( );
    }

    /**
     * Sobrecarga el m�todo de Table Model y retorna el n�mero de columnas para ajustar la tabla de Libros.
     * @return n�mero de columnas.
     */
    public int getColumnCount( )
    {
        return nombresColumnas.length;
    }

    /**
     * Sobrecarga el m�todo de Table Model y retorna el objeto de la casilla indicada.
     * @param rowIndex �ndice de la fila. rowIndex >= 0.
     * @param columnIndex �ndice de la columna. columnIndex >= -1.
     * @return dato de la celda. Si columnIndex es -1 retorna el libro completo.
     */
    public Object getValueAt( int rowIndex, int columnIndex )
    {
        Object datoLibro = null;
        Object[] catalogo = tienda.darCatalogo( ).toArray( );
        Libro libro = ( Libro )catalogo[ rowIndex ];

        if( columnIndex == -1 )
            datoLibro = libro;
        else if( columnIndex == 0 )
            datoLibro = libro.darISBN( );
        else if( columnIndex == 1 )
            datoLibro = libro.darTitulo( );
        else if( columnIndex == 2 )
            datoLibro = formatearValor( libro.darPrecio( ) );

        return datoLibro;
    }

    /**
     * Sobrecarga el m�todo de Table Model y retorna el nombre de la columna.
     * @param col Columna de la cual se quiere saber el nombre. col >= 0.
     * @return nombre de la columna
     */
    public String getColumnName( int col )
    {
        return nombresColumnas[ col ];
    }

    /**
     * Sobrecarga el m�todo de Table Model y dice si la celda se puede editar.
     * @param fila �ndice de la fila. fila >= 0.
     * @param col �ndice de la columna. col >=0 .
     * @return true si se puede editar, false en caso contrario.
     */
    public boolean isCellEditable( int fila, int col )
    {
        return false;
    }

    /**
     * Formatea un valor num�rico para presentar en la interfaz.
     * @param valor Valor num�rico a ser formateado.
     * @return cadena con el valor formateado con puntos y signos.
     */
    private String formatearValor( int valor )
    {
        DecimalFormat df = ( DecimalFormat )NumberFormat.getInstance( );
        df.applyPattern( "$ ###,###.##" );
        df.setMinimumFractionDigits( 2 );
        return df.format( valor );
    }

}