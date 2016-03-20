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

package uniandes.cupi2.carrocompralibro.mundo;

/**
 * Libro de la tienda de libros
 */
public class Libro
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /** T�tulo del libro */
    private String titulo;

    /** ISBN del libro */
    private String isbn;

    /** Precio del libro */
    private int precio;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    /**
     * Crea el libro con su informaci�n b�sica: t�tulo, ISBN y precio.
     * @param unTitulo T�tulo del libro. unTitulo!= null.
     * @param unISBN ISBN del libro. unISBN != null.
     * @param unPrecio Precio del libro. unPrecio >= 0.
     */
    public Libro( String unTitulo, String unISBN, int unPrecio )
    {
        titulo = unTitulo;
        isbn = unISBN;
        precio = unPrecio;
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna el t�tulo del libro.
     * @return T�tulo del libro.
     */
    public String darTitulo( )
    {
        return titulo;
    }

    /**
     * Retorna el c�digo ISBN del libro.
     * @return ISBN del libro.
     */
    public String darISBN( )
    {
        return isbn;
    }

    /**
     * Retorna el precio del libro.
     * @return Precio del libro.
     */
    public int darPrecio( )
    {
        return precio;
    }

    /**
     * Indica si este libro es igual a otro.
     * @param otroIsbn ISBN del otro libro con el que se compara este. otroISBN != null.
     * @return true si son dos libros iguales, false en caso contrario.
     */
    public boolean igualALibro( String otroIsbn )
    {
        boolean iguales = isbn.equals( otroIsbn );
        return iguales;
    }

}