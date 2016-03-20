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
 * �tem del carrito de compras. El �tem indica el libro y la cantidad que se desea comprar del mismo.
 */
public class ItemCompra
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Libro que es el �tem de la compra
     */
    private Libro libro;

    /**
     * Cantidad del libro a comprar
     */
    private int cantidad;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea un �tem de compra con el libro a comprar y la cantidad deseada.
     * @param unLibro Libro que se va a comprar. unLibro != null.
     * @param unaCantidad Cantidad de libros a comprar. unaCantidad != null.
     */
    public ItemCompra( Libro unLibro, int unaCantidad )
    {
        libro = unLibro;
        cantidad = unaCantidad;
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna el libro solicitado como �tem de compra.
     * @return libro Libro a comprar. libro != null.
     */
    public Libro darLibro( )
    {
        return libro;
    }

    /**
     * Retorna el ISBN del libro que es el �tem de compra.
     * @return ISBN del libro del �tem de compra.
     */
    public String darIsbnItem( )
    {
        return libro.darISBN( );
    }

    /**
     * Retorna la cantidad solicitada de libros.
     * @return cantidad solicitada.
     */
    public int darCantidadSolicitada( )
    {
        return cantidad;
    }

    /**
     * Cambia la cantidad de libros solicitados en la compra. <br>
     * <b>post: </b> Se actualiza el �tem de compra con la nueva cantidad. <br>
     * @param nuevaCantidad Nueva cantidad de libros a comprar. nuevaCantidad > 0.
     */
    public void cambiarCantidadSolicitada( int nuevaCantidad )
    {
        cantidad = nuevaCantidad;
    }

    /**
     * Indica si este �tem de compra es igual a otro.
     * @param otroItem El otro �tem con el �ste que se va a comparar. otroItem != null.
     * @return true si son el mismo �tem de compra, false en caso contrario.
     */
    public boolean igualAItem( ItemCompra otroItem )
    {
        boolean iguales = libro.igualALibro( otroItem.darIsbnItem( ) );
        return iguales;
    }

    /**
     * Retorna el subtotal o valor de compra del �tem. Depende del precio y la cantidad de libros.
     * @return subtotal Cantidad calculada del valor del �tem de compra. subtotal > 0.
     */
    public int calcularSubtotalItem( )
    {
        int subtotal = libro.darPrecio( ) * cantidad;
        return subtotal;
    }
}