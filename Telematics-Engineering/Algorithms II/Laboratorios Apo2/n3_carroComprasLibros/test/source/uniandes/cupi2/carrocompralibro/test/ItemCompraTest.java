/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n
 * Licenciado bajo el esquema Academic Free License version 2.1
 *
 * Proyecto Cupi2
 * Ejercicio: Carro de Compras Libros
 * Autor inicial: Katalina Marcos
 * Modificaci�n: Jorge Jim�nez - Junio 2005
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.carrocompralibro.test;

import junit.framework.TestCase;
import uniandes.cupi2.carrocompralibro.mundo.ItemCompra;
import uniandes.cupi2.carrocompralibro.mundo.Libro;

/**
 * Clase de pruebas para el �tem de compra
 */
public class ItemCompraTest extends TestCase
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Libro 1 para pruebas
     */
    private Libro libro1;

    /**
     * Libro 2 para pruebas
     */
    private Libro libro2;

    /**
     * �tem de compras 1 para pruebas
     */
    private ItemCompra item1;

    /**
     * �tem de compras 2 para pruebas
     */
    private ItemCompra item2;

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Configuraci�n inicial para las pruebas escenario 1
     */
    private void setupEscenario1( )
    {
        String titulo, isbn;
        int precio, cantidad1, cantidad2;

        // Crea el primer libro para pruebas
        titulo = "Titulo 1";
        isbn = "ISBN 1";
        precio = 1000;
        libro1 = new Libro( titulo, isbn, precio );

        // Crea el segundo libro para pruebas
        titulo = "Titulo 2";
        isbn = "ISBN 2";
        precio = 2000;
        libro2 = new Libro( titulo, isbn, precio );

        // Crea un �tem de compra
        cantidad1 = 2;
        item1 = new ItemCompra( libro1, cantidad1 );

        // Crea otro �tem de compra
        cantidad2 = 3;
        item2 = new ItemCompra( libro2, cantidad2 );

    }

    /**
     * Configuraci�n inicial para las pruebas escenario 2
     */
    private void setupEscenario2( )
    {
        String titulo, isbn;
        int precio, cantidad1, cantidad2;

        // Crea el primer libro para pruebas
        titulo = "Titulo 3";
        isbn = "ISBN 3";
        precio = 10000;
        libro1 = new Libro( titulo, isbn, precio );

        // Crea el segundo libro para pruebas
        titulo = "Titulo 4";
        isbn = "ISBN 4";
        precio = 20000;
        libro2 = new Libro( titulo, isbn, precio );

        // Crea un �tem de compra
        cantidad1 = 20;
        item1 = new ItemCompra( libro1, cantidad1 );

        // Crea otro �tem de compra
        cantidad2 = 30;
        item2 = new ItemCompra( libro2, cantidad2 );

    }

    /**
     * Configuraci�n inicial para las pruebas escenario 3
     */
    private void setupEscenario3( )
    {
        String titulo, isbn;
        int precio, cantidad1, cantidad2;

        // Obtiene los datos de prueba

        // Crea el primer libro para pruebas
        titulo = "Titulo 5";
        isbn = "ISBN 5";
        precio = 10;
        libro1 = new Libro( titulo, isbn, precio );

        // Crea el segundo libro para pruebas
        titulo = "Titulo 6";
        isbn = "ISBN 6";
        precio = 20;
        libro2 = new Libro( titulo, isbn, precio );

        // Crea un �tem de compra
        cantidad1 = 1;
        item1 = new ItemCompra( libro1, cantidad1 );

        // Crea otro �tem de compra
        cantidad2 = 2;
        item2 = new ItemCompra( libro2, cantidad2 );

    }

    /**
     * Verifica La creaci�n de un �tem de compra
     */
    public void testCreaItemCompra( )
    {
        setupEscenario1( );
        int cantidad = 2;

        // Verifica las cantidades
        assertEquals( cantidad, item1.darCantidadSolicitada( ) );

        // Verifica los libros
        assertTrue( item1.darLibro( ).igualALibro( libro1.darISBN( ) ) );

    }

    /**
     * Verifica que la igualdad de dos �tem sea correcta, comparando al libro consigo mismo
     */
    public void testItemsIguales( )
    {
        setupEscenario2( );
        assertTrue( item1.igualAItem( item1 ) );
    }

    /**
     * Verifica la desigualdad de dos �tem de compra
     */
    public void testItemsDiferentes( )
    {
        setupEscenario3( );
        assertFalse( item1.igualAItem( item2 ) );
    }

    /**
     * Verifica el cambio correcto de cantidad del �tem
     */
    public void testCambioCantidadItem( )
    {
        setupEscenario1( );
        int cantidad = 4;
        item2.cambiarCantidadSolicitada( cantidad );
        assertEquals( cantidad, item2.darCantidadSolicitada( ) );
    }

    /**
     * Verifica el c�lculo correcto del subtotal
     */
    public void testCalculoSubtotal( )
    {
        setupEscenario2( );
        int cantidad = 20;
        int precio = 10000;

        assertEquals( cantidad * precio, item1.calcularSubtotalItem( ) );
    }

    /**
     * Verifica el ISBN del Libro
     */
    public void testISBNItem( )
    {
        setupEscenario1( );
        // Verifica los ISBN de los libros
        assertEquals( item1.darIsbnItem( ), libro1.darISBN( ) );
    }

    /**
     * Verifica la igualdad de los Libros
     */
    public void testLibro( )
    {
        setupEscenario2( );
        // Verifica los ISBN de los libros
        assertEquals( item2.darLibro( ), libro2 );
    }

}