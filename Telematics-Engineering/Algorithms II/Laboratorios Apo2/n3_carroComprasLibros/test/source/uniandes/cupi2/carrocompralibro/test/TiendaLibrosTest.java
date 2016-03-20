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

import java.util.ArrayList;

import junit.framework.TestCase;
import uniandes.cupi2.carrocompralibro.mundo.CarroCompras;
import uniandes.cupi2.carrocompralibro.mundo.ItemCompra;
import uniandes.cupi2.carrocompralibro.mundo.Libro;
import uniandes.cupi2.carrocompralibro.mundo.TiendaLibros;

/**
 * Clase de pruebas para la tienda de libros
 */
public class TiendaLibrosTest extends TestCase
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Un libro de pruebas
     */
    private Libro libro1;

    /**
     * Segundo libro de pruebas
     */
    private Libro libro2;

    /**
     * Tienda de Libros
     */
    private TiendaLibros tienda;

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Configuraci�n inicial para las pruebas escenario 1
     */
    private void setupEscenario1( )
    {
        String titulo, isbn;
        int precio, cantidad;
        CarroCompras carro;

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

        // Adiciona los libros al cat�logo
        tienda = new TiendaLibros( );
        tienda.adicionarLibroCatalogo( libro1 );
        tienda.adicionarLibroCatalogo( libro2 );

        // Inicializa el carro de compras
        carro = tienda.darCarritoCompras( );
        cantidad = 1;
        carro.adicionarCompra( libro1, cantidad );
    }

    /**
     * Configuraci�n inicial para las pruebas escenario 2.
     */
    private void setupEscenario2( )
    {
        String titulo, isbn;
        int precio, cantidad;
        CarroCompras carro;

        // Crea el primer libro para pruebas
        titulo = "Titulo 3";
        isbn = "ISBN 3";
        precio = 10;
        libro1 = new Libro( titulo, isbn, precio );

        // Crea el segundo libro para pruebas
        titulo = "Titulo 4";
        isbn = "ISBN 4";
        precio = 20;
        libro2 = new Libro( titulo, isbn, precio );

        // Adiciona los libros al cat�logo
        tienda = new TiendaLibros( );
        tienda.adicionarLibroCatalogo( libro1 );
        tienda.adicionarLibroCatalogo( libro2 );

        // Inicializa el carro de compras
        carro = tienda.darCarritoCompras( );
        cantidad = 2;
        carro.adicionarCompra( libro1, cantidad );
    }

    /**
     * Configuraci�n inicial para las pruebas escenario 3
     */
    private void setupEscenario3( )
    {
        String titulo, isbn;
        int precio, cantidad;
        CarroCompras carro;
        // Obtiene los datos de prueba

        // Crea el primer libro para pruebas
        titulo = "Titulo 5";
        isbn = "ISBN 5";
        precio = 100;
        libro1 = new Libro( titulo, isbn, precio );

        // Crea el segundo libro para pruebas
        titulo = "Titulo 6";
        isbn = "ISBN 6";
        precio = 200;
        libro2 = new Libro( titulo, isbn, precio );

        // Adiciona los libros al catalogo
        tienda = new TiendaLibros( );
        tienda.adicionarLibroCatalogo( libro1 );
        tienda.adicionarLibroCatalogo( libro2 );

        // Inicializa el carro de compras
        carro = tienda.darCarritoCompras( );
        cantidad = 3;
        carro.adicionarCompra( libro1, cantidad );
    }

    /**
     * Verifica la adici�n de y obtenci�n de libros del cat�logo
     */
    public void testAdicionaLibroCatalogo( )
    {
        setupEscenario1( );
        Libro libroObtenido;
        libroObtenido = tienda.buscarLibro( libro1.darISBN( ) );
        assertTrue( "Adici�n libro", libroObtenido.igualALibro( libro1.darISBN( ) ) );
        assertEquals( "ISBN adici�n libro", libroObtenido.darISBN( ), libro1.darISBN( ) );
        assertEquals( "Titulo adici�n libro", libroObtenido.darTitulo( ), libro1.darTitulo( ) );
        assertEquals( "Precio adici�n libro", libroObtenido.darPrecio( ), libro1.darPrecio( ) );
    }

    /**
     * Verifica que al adicionar un libro que ya existe no lo adicione
     */
    public void testAdicionaLibroExiste( )
    {
        setupEscenario2( );
        int numeroLibrosAntes, numeroLibrosDespues;

        numeroLibrosAntes = tienda.darCatalogo( ).size( );
        tienda.adicionarLibroCatalogo( libro1 );
        numeroLibrosDespues = tienda.darCatalogo( ).size( );

        assertEquals( "Adici�n libro existe", numeroLibrosAntes, numeroLibrosDespues );
    }

    /**
     * Verifica la obtenci�n del cat�logo
     */
    public void testObtenerCatalogo( )
    {
        setupEscenario3( );
        Libro libro;
        ArrayList catalogo = tienda.darCatalogo( );

        // Verifica el primer libro
        libro = ( Libro )catalogo.get( 0 );
        assertTrue( libro.igualALibro( libro1.darISBN( ) ) );

        // Verifica el segundo libro
        libro = ( Libro )catalogo.get( 1 );
        assertTrue( libro.igualALibro( libro2.darISBN( ) ) );
    }

    /**
     * Verifica la obtenci�n del carrito de compras
     */
    public void testObtenerCarro( )
    {
        setupEscenario1( );
        CarroCompras carro = tienda.darCarritoCompras( );
        ItemCompra item = carro.buscarItemCompraLibro( libro1.darISBN( ) );
        assertTrue( libro1.igualALibro( item.darLibro( ).darISBN( ) ) );
    }

    /**
     * Verifica que al inicializa la compra el carro quede vac�o
     */
    public void testNuevaCompra( )
    {
        setupEscenario2( );
        tienda.crearNuevaCompra( );
        CarroCompras carro = tienda.darCarritoCompras( );
        assertEquals( 0, carro.darListaCompra( ).size( ) );
    }

    /**
     * Verifica que el libro insertado est�
     */
    public void testBuscarLibro( )
    {
        setupEscenario3( );
        CarroCompras carro = tienda.darCarritoCompras( );
        ItemCompra item = carro.buscarItemCompraLibro( libro1.darISBN( ) );
        Libro libro = item.darLibro( );
        assertEquals( libro, tienda.buscarLibro( libro.darISBN( ) ) );
    }

}