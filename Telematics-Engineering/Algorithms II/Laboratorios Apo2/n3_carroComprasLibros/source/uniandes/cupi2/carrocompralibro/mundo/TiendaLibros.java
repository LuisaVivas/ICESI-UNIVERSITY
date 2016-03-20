/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n
 * Licenciado bajo el esquema Academic Free License version 2.1
 *
 * Proyecto Cupi2
 * Ejercicio: Carro de Compras Libros
 * Autor inicial: Katalina Marcos
 * Autor: Jorge Jim�nez- Junio 2005
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.carrocompralibro.mundo;

import java.util.*;

/**
 * Tienda de venta de libros
 */
public class TiendaLibros
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Cat�logo o lista de libros
     */
    private ArrayList catalogo;

    /**
     * Carro de compras de los libros
     */
    private CarroCompras carrito;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    /**
     * Crea la tienda de libros con el cat�logo de libros vac�o
     */
    public TiendaLibros( )
    {
        catalogo = new ArrayList( );
        carrito = new CarroCompras( );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Adiciona un nuevo libro al cat�logo de la tienda. <br>
     * <b>post: </b> Se agreg� un libro al cat�logo.
     * @param nuevoLibro Nuevo libro del cat�logo. nuevoLibro != null.
     */
    public void adicionarLibroCatalogo( Libro nuevoLibro )
    {
        // Verifica que el libro no se haya ingresado antes
        Libro libro = buscarLibro( nuevoLibro.darISBN( ) );
        // S�lo a�ade el libro si no existe ya
        if( libro == null )
            catalogo.add( nuevoLibro );
    }

    /**
     * Crea una nueva compra. <br>
     * <b>post: </b> Se cre� un nuevo carrito de compras sin �tem de compra.
     */
    public void crearNuevaCompra( )
    {
        carrito = new CarroCompras( );
    }

    /**
     * Retorna el cat�logo de la tienda. <br>
     * @return El cat�logo de la tienda.
     */
    public ArrayList darCatalogo( )
    {
        return catalogo;
    }

    /**
     * Retorna el carro de compras.
     * @return El carro de compras.
     */
    public CarroCompras darCarritoCompras( )
    {
        return carrito;
    }

    /**
     * Retorna si existe un libro del cat�logo de la tienda con el ISBN dado.
     * @param isbn ISBN del libro que se quiere buscar en el cat�logo.
     * @return libro Libro encontrado en el catalogo o null si no existe.
     */
    public Libro buscarLibro( String isbn )
    {
        int indice = 0;
        int totalLibros = catalogo.size( );
        Libro libroEncontrado = null;
        boolean encontrado = false;
        while( indice < totalLibros && !encontrado )
        {
            libroEncontrado = ( Libro )catalogo.get( indice );
            if( libroEncontrado.igualALibro( isbn ) )
                encontrado = true;
            indice++;
        }
        if( encontrado )
            return libroEncontrado;
        else
            return null;
    }

    // -----------------------------------------------------------------
    // Puntos de Extensi�n
    // -----------------------------------------------------------------

    /**
     * M�todo 1 de extensi�n al ejemplo
     * @return respuesta
     * Debe colocar en este metodo el nombre del libro del carro
     * de compras m�s barato
     */

    public String metodo1( )
    {
        return "Respuesta 1";
    }

    /**
     * M�todo 2 de extensi�n al ejemplo
     * @return respuesta
     */
    public String metodo2( )
    {
        return "Respuesta 2";
    }

}