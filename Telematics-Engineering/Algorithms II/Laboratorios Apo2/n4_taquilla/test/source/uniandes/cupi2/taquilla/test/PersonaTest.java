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

import junit.framework.*;
import uniandes.cupi2.taquilla.mundo.*;

/**
 * Pruebas para la clase Persona
 */
public class PersonaTest extends TestCase {

	// -------------------------------------------------------------
	// Atributos
	// -------------------------------------------------------------

	/**
	 * La instancia de la clase a probar
	 */
	private Persona persona;

	/**
	 * El nombre de la persona
	 */
	private String nombrePersona;

	/**
	 * La c�dula de la persona
	 */
	private String cedulaPersona;

	// -------------------------------------------------------------
	// M�todos
	// -------------------------------------------------------------

	/**
	 * Configuraci�n del escenario
	 */
	public void setupEscenario1() {
		nombrePersona = "Nombre Persona";
		cedulaPersona = "23423534656";
		persona = new Persona(nombrePersona, cedulaPersona);
	}

	/**
	 * Prueba el constructor y los getters de la clase Persona
	 */
	public void testPersona() {
		setupEscenario1();

		assertEquals("El nombre deber�a ser el mismo", persona.darNombre(), nombrePersona);
		assertEquals("La c�dula deber�a ser la mismo", persona.darCedula(), cedulaPersona);
	}
}