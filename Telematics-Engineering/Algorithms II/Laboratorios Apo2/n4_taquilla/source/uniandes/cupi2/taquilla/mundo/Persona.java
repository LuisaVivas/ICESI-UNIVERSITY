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

package uniandes.cupi2.taquilla.mundo;

/**
 * Representa una persona
 */
public class Persona {

	//-------------------------------------------------------------
	// Atributos
	//-------------------------------------------------------------
			
	/**
	 * Nombre de la persona
	 */
	private String nombre;
	
	/**
	 * C�dula de la persona
	 */
	private String cedula;
	
	//-------------------------------------------------------------
	// Constructor
	//-------------------------------------------------------------
	/**
	 * Crea una persona con los valores que recibe por par�metro
	 * @param pNombre Nombre de la persona - pNombre != null && pNombre != ""
	 * @param pCedula C�dula de la persona - pCedula != null && pCedula != ""
	 */
	public Persona(String pNombre, String pCedula) {
		nombre = pNombre;
		cedula = pCedula;
	}
	//-------------------------------------------------------------
	// M�todos
	//-------------------------------------------------------------
		
	/**
	 * M�todo encargado de dar el nombre de una persona
	 * @return nombre de una persona
	 */
	public String darNombre()
	{
		return nombre;
	}
	
	/**
	 * M�todo encargado de dar la c�dula de una persona
	 * @return c�dula de una persona
	 */
	public String darCedula()
	{
		return cedula;
	}
}
