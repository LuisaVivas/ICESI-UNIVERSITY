/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: taquilla
 * Autores: Kelvin Guerrero, Carlos Vega, Luis Ricardo Ruiz y Rafael Mu�oz Lattion - 11-mar-2013
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.taquilla.test;

import junit.framework.TestCase;
import uniandes.cupi2.taquilla.mundo.Persona;
import uniandes.cupi2.taquilla.mundo.Silla;
import uniandes.cupi2.taquilla.mundo.Taquilla;

/**
 * Pruebas para la clase Silla
 */
public class SillaTest extends TestCase {

	// -------------------------------------------------------------
	// Atributos
	// -------------------------------------------------------------

	/**
	 * La instancia de la clase a probar
	 */
	private Silla silla;

	/**
	 * El nombre de la persona
	 */
	private int numeroSilla;

	/**
	 * La c�dula de la persona
	 */
	private String localidadSilla;

	// -------------------------------------------------------------
	// M�todos
	// -------------------------------------------------------------

	/**
	 * Configuraci�n del escenario
	 */
	public void setupEscenario1() {
		numeroSilla = (int) (Math.random() * 100);
		localidadSilla = Taquilla.LOCALIDAD_OCCIDENTAL;
		silla = new Silla(numeroSilla, localidadSilla);
	}

	/**
	 * Prueba el constructor y los getters de la clase Persona
	 */
	public void testSilla() {
		setupEscenario1();

		assertEquals("El n�mero de la silla deber�a ser el mismo", silla.darNumero(), numeroSilla);
		assertEquals("La localidad de la silla deber�a ser la mismo", silla.darLocalidad(), Taquilla.LOCALIDAD_OCCIDENTAL);
		assertNull("El comprador de la silla no debe estar asignado", silla.darComprador());
	}

	/**
	 * Prueba del m�todo estaAsignada M�todos a probar: estaAsignada,
	 * asignarSilla Caso 1: En caso de que la silla no est� asignada Caso 2: En
	 * caso de que la silla haya sido asignada
	 */
	public void testEstaAsignada() {
		setupEscenario1();

		// Caso 1.
		assertFalse("La silla no deber�a estar asignada", silla.estaAsignada());

		// Caso 2.
		try {
			silla.asignarSilla("Juan P�rez", "123456789");
			assertTrue("La silla ha sido asignada", silla.estaAsignada());
		} catch (Exception e) {
			fail("No deber�a lanzar excepci�n");
		}
	}

	/**
	 * Prueba del m�todo asignarSilla<br>
	 * M�todos a probar: asignarSilla, estaAsignada<br>
	 * Caso 1: En caso de que la silla no est� asignada
	 */
	public void testAsignarSilla1() {
		setupEscenario1();

		// Caso 1.
		try {
			silla.asignarSilla("Juan P�rez", "123456789");
			assertTrue("La silla ha sido asignada", silla.estaAsignada());
		} catch (Exception e) {
			fail("No deber�a lanzar excepci�n");
		}
	}

	/**
	 * Prueba del m�todo asignarSilla<br>
	 * M�todos a probar: asignarSilla, estaAsignada<br>
	 * Caso 1: En caso de que la silla est� asignada, y lance la excepci�n
	 * correctamente
	 */
	public void testAsignarSilla2() {
		setupEscenario1();

		// Caso 1.
		try {
			silla.asignarSilla("Juan P�rez", "123456789");
			assertTrue("La silla ha sido asignada", silla.estaAsignada());

			silla.asignarSilla("Juanita P�rez", "234567890");
			fail("La silla no debi� ser asignada");
		} catch (Exception e) {
			// Se deber�a lanzar esta excepci�n
		}
	}

	/**
	 * Prueba del m�todo darComprador<br>
	 * M�todos a probar: darComprador, asignarSilla<br>
	 */
	public void testDarComprador() {
		setupEscenario1();
		
		// Caso 1.
		try {
			
			assertNull("La silla no debe tener un comprador", silla.darComprador());

			String nombre = "Juan P�rez";
			String cedula = "123456789";
			silla.asignarSilla(nombre, cedula);
			
			Persona comprador = silla.darComprador();
			assertNotNull("La silla debe tener un comprador", comprador);
			assertEquals("El comprador debe tener el mismo nombre", nombre, comprador.darNombre());
			assertEquals("El comprador debe tener la misma c�dula", cedula, comprador.darCedula());
			
		} catch (Exception e) {
			fail("No deber�a lanzar excepci�n");
		}
	}
}