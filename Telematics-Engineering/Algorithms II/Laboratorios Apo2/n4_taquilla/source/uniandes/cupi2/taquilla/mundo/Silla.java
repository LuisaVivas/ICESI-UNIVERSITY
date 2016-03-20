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
 * Clase que representa una silla  
 */
public class Silla
{


    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * El n�mero de la Silla
     */
    private int numero;

    /**
     * La localidad de la Silla
     */
    private String localidad;

    /**
     * El comprador de la silla
     */
    private Persona comprador;
    
    
    // -------------------------------------------------------------
    // M�todos
    // -------------------------------------------------------------

    /**
     * Construye una Silla con la informaci�n dada <br>
     * <b> post: </b> se inicializa n�mero y localidad de la Silla <br>
     * @param pNumero N�mero de la silla - pNumero >= 0 
     * @param pLocalidad Localidad de la silla - pLocalidad != null && pLocalidad != ""
     */
    public Silla( int pNumero, String pLocalidad )
    {
        numero = pNumero;
        localidad = pLocalidad;
    }

    /**
     * Informa el n�mero de la silla
     * @return el n�mero de la silla
     */
    public int darNumero( )
    {
        return numero;
    }
    
    /**
     * Retorna el comprador de la silla
     * @return El comprador de la silla, null en caso que la silla no tenga un comprador asignado
     */
    public Persona darComprador()
    {
    	return comprador;
    }


    /**
     * Informa la localidad de la silla
     * @return La localidad de la silla
     */
    public String darLocalidad( )
    {
        return localidad;
    }

    /**
     * Informa si la silla esta asignada a un comprador
     * @return true en caso de que este asignada, false en caso contrario
     */
    public boolean estaAsignada( )
    {
        
    	if(comprador == null){
    		return true;
    	}
    	return false;
    }
    
    /**
     * Asigna la silla a una persona <br>
     * <b> post: </b> Se le asigno una persona al comprador <br>
     * @param pNombreComprador Nombre del comprador de una silla - pNombreComprador != null && pNombreComprador != ""
     * @param pCedulaComprador C�dula del comprador de una silla - pCedulaComprador != null && pCedulaComprador != ""
     * @throws Exception En caso de que ya se encuentre asignada la silla a un comprador
     */
    public void asignarSilla( String pNombreComprador, String pCedulaComprador ) throws Exception
    {
        
    	if(comprador == null){
    		comprador = new Persona(pNombreComprador, pCedulaComprador);
    	}else{
    		throw new Exception("La silla se encuentra asignada");
    	}
    }
}