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

import java.util.ArrayList;

/**
 * Carrito de compra de libros. Va guardando los libros que el cliente quiere comprar.
 */
public class CarroCompras
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /** Lista de los �tem de compra que se van a�adiendo al carro */


    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea un carro de compra vac�o (sin libros solicitados).
     */


    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Nombre: buscarItemCompraLibro
     * Retorna si existe un �tem de compra donde est� el libro con el ISBN dado.
     * @param isbnBuscado ISBN del libro buscado.
     * @return �tem de compra del libro o null si no lo encuentra.
     */
   


    /**
     * Nombre: adicionarCompra
     * Adiciona un nuevo �tem al carro de la compras si el libro ya no estaba en �l, o adiciona la cantidad si el libro ya est� incluido en otra compra. <br>
     * <b>post: </b> Si el libro no est� en el carro de compras, se adiciona el libro y la cantidad de ejemplares o si ya existe se incrementa la cantidad de ejemplares a
     * comprar. <br>
     * @param libro Libro a comprar. libro != null.
     * @param cantidad Cantidad de libros a comprar. cantidad >= 0.
     */



    /**
     * Nombre: borrarItemCompra
     * Borra un �tem del carro de la compra. <br>
     * <b>post: </b> Se elimina el �tem de compra dado. <br>
     * @param unItem �tem a buscar y eliminar. unItem != null.
     */
    




    /**
     * Nombre: darListaCompra
     * Retorna la lista de los �tem de compra.
     * @return Lista de los �tem de compra.
     */



    /**
     * Nombre: calcularValorTotalCompra
     * Calcula el total de la compra que lleva el carrito.
     * @return Total de la compra.
     */


    /**
     * Nombre: obtenerLibroCompradoMasBarato
     * Obtiene el libro del carro de compras m�s barato
     * @return un Libro.
     */
    
}