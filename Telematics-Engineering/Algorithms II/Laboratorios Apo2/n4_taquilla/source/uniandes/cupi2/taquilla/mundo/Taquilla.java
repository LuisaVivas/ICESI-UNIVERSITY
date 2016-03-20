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

import java.util.ArrayList;

/**
 * Clase que representa la taquilla de un equipo de f�tbol
 */
public class Taquilla
{
    // -------------------------------------------------------------
    // Constantes
    // -------------------------------------------------------------

    /**
     * Constante que representa el descuento que recibe un socio 
     */
    public final static double DESCUENTO_SOCIO = 0.7;

    /**
     * Constante que representa la Localidad Norte
     */
    public static final String LOCALIDAD_NORTE = "Localidad Norte";

    /**
     * Constante que representa la Localidad Occidental
     */
    public static final String LOCALIDAD_OCCIDENTAL = "Localidad Occidental";

    /**
     * Constante que representa la Localidad Oriental
     */
    public static final String LOCALIDAD_ORIENTAL = "Localidad Oriental";
    
    /**
     * Constante que representa la Localidad Sur
     */
    public static final String LOCALIDAD_SUR = "Localidad Sur";
    
    /**
     * Constante que representa el precio de una silla en la Localidad Norte
     */
    public static final double PRECIO_NORTE = 227000;

    /**
     * Constante que representa el precio de una silla en la Localidad Occidental
     */
    public static final double PRECIO_OCCIDENTAL = 504000;

    /**
     * Constante que representa el precio de una silla en la Localidad Oriental
     */
    public static final double PRECIO_ORIENTAL = 252000;

    /**
     * Constante que representa el precio de una silla en la Localidad Sur
     */
    public static final double PRECIO_SUR = 126000;
    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * El nombre del equipo
     */
    private String nombreEquipo;

    /**
     * Contendedora variable que representa los socios del equipo
     */
    private ArrayList socios;

    /**
     * Contendedora variable que representa los partidos que va a jugar el equipo
     */
    private ArrayList partidos;

    // -------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------

    /**
     * M�todo constructor de la clase taquilla
     * <b> post: </b> Se inicializ� el vector de socios<br>
     *                Se inicializ� el vector de partidos<br>
     *                Se inicializ� el nombre del equipo<br>
     * @param pNombre Nombre del equipo - pNombre != null && pNombre != ""
     */
    public Taquilla( String pNombre )
    {
        nombreEquipo = pNombre;
        socios = new ArrayList();
        partidos = new ArrayList();
    }

    // -------------------------------------------------------------
    // M�todos
    // -------------------------------------------------------------

    /**
     * Devuelve el nombre del equipo
     * @return El nombre del equipo
     */
    public String darNombreEquipo( )
    {
        return nombreEquipo;
    }

    /**
     * Devuelve los socios del equipo
     * @return Lista de socios
     */
    public ArrayList darSocios( )
    {
        return socios;
    }

    /**
     * Devuelve los partidos del equipo
     * @return Lista de partidos
     */
    public ArrayList darPartidos( )
    {
        return partidos;
    }

    /**
     * M�todo encargado de buscar un partido dado el rival, el torneo y la fecha del partido <br>
     * <b> pre: </b> La lista de partidos se encuentra inicializada <br>
     * @param pRival Rival contra el que se juega - pRival != "" && pRival != null
     * @param pTorneo Nombre del torneo en el que se jugara el partido - pTorneo != null && ( pTorneo == Partido.TORNEO_LIGA || pTorneo == Partido.TORNEO_COPA || pTorneo == Partido.TORNEO_SUPER_LIGA )<br>
     * @param pFechaPartido Fecha en la que se jugara el partido - pFechaPartido != "" && pFechaPartido != null
     * @return vPartidoRta El partido con la informaci�n dada, en caso de no existir se retorna null.
     */
    public Partido buscarPartido( String pRival, String pTorneo, String pFechaPartido )
    {
    	Partido partido = null;
    	boolean termino = false;
    	for(int i=0; i<partidos.size() && !termino; i++){
    		partido = (Partido) partidos.get(i);
    		if(partido.darRival().equals(pRival) && partido.darTorneo().equals(pTorneo) && partido.darFechaPartido().equals(pFechaPartido)){
    			termino =true;
    		}
    	}

    	return partido;
    }

    /**
     * M�todo encargado de buscar un socio del Equipo
     * <b> pre: </b> La lista de socios se encuentra inicializada <br>
     * @param pCedula C�dula del Socio - pCedula != "" && pCedula != null
     * @return true en caso de encontrar el socio con la c�dula dada, false en caso contrario
     */
    public boolean existeSocio( String pCedula)
    {
    	Persona socio =null;
    	for(int i = 0; i< socios.size(); i++){
    		socio = (Persona) socios.get(i);
    		if(socio.darCedula().equals(pCedula)){
    			return true;
    		}
    	}
    	return false;
    }

    
    //TODO Escriba el contrato del m�todo, teniendo en cuenta la implementaci�n.
    public void agregarSocio( String pNombre, String pCedula ) throws Exception
    {
        boolean vEsxisteSocio = existeSocio( pCedula );
        if( !vEsxisteSocio )
        {
            Persona vPersona = new Persona( pNombre, pCedula );
            socios.add( vPersona );
        }
        else
        {
            throw new Exception( "Ya existe el socio " + pNombre + " con n�mero de cedula:" + pCedula );
        }
    }

    /**
     * M�todo encargado de agregar un partido <br>
     * <b> pre: </b> La lista de partidos se encuentra inicializada <br>
     * <b> post: </b> Se agrego un nuevo partido a la lista<br>
     * @param pRival Rival contra el que se juega - pRival != "" && pRival != null
     * @param pTorneo Nombre del torneo en el que se jugara el partido - pTorneo != null && ( pTorneo == Partido.TORNEO_LIGA || pTorneo == Partido.TORNEO_COPA || pTorneo == Partido.TORNEO_SUPER_LIGA )<br>
     * @param pFechaPartido Fecha en la que se jugara el partido - pFechaPartido != "" && pFechaPartido != null
     * <b> post: </b> Se agrego un partido dentro del arreglo de los partidos<br>
     * @throws Exception En caso de existir un partido en la fecha dada por par�metro
     */
    public void agregarPartido( String pRival, String pTorneo, String pFechaPartido ) throws Exception
    {
        Partido existePartido = buscarPartido(pRival, pTorneo, pFechaPartido);
        if(existePartido == null){
        	existePartido = new Partido(pRival, pTorneo, pFechaPartido);
        	partidos.add(existePartido);
        }else{
        	throw new Exception("El partido, en la fecha dada ya existe");
        }
        

    }

    /**
     * M�todo encargado de vender una silla teniendo en cuenta una localidad, el numero de silla que llega por par�metro y la informaci�n de un partido<br>
     * Si el comprador es socio del equipo, se le vende la silla con descuento de socio. <br>
     * <b> pre: </b> La lista de partidos se encuentra inicializada <br>
     *               La lista de socios se encuentra inicializada <br>
     * <b> post: </b> La silla fue vendida<br>
     * @param pNumeroSilla Numero de la silla que se quiere vender - pNumeroSilla >= 0
     * @param pLocalidad Localidad de la silla que se quiere vender - pLocalidad != "" && pLocalidad != null
     * @param pNombreComprador Nombre del comprador de la silla - pNombreComprador != "" && pNombreComprador != null
     * @param pCedulaComprador C�dula del comprador de la silla - pCedulaComprador != "" && pCedulaComprador != null
     * @param pRival Rival contra el que se juega - pRival != "" && pRival != null
     * @param pTorneo Nombre del torneo en el que se jugara el partido - pTorneo != null && ( pTorneo == Partido.TORNEO_LIGA || pTorneo == Partido.TORNEO_COPA || pTorneo == Partido.TORNEO_SUPER_LIGA )<br>
     * @param pFechaPartido Fecha del partido - pFechaPartido != null && pFechaPartido != ""
     * @return costoVenta El costo de la venta de la Silla
     * @throws Exception    Env�a excepci�n en caso de que el partido no exista
     * 						Si no existe la silla en la localidad dada con el n�mero dado para el partido
     *                   	En caso que la silla ya se encuentre asignada
     */
    public double venderSilla( int pNumeroSilla, String pLocalidad, String pNombreComprador, String pCedulaComprador, String pRival, String pTorneo, String pFechaPartido ) throws Exception
    {
        //TODO Completar seg�n la documentaci�n del m�todo
    }

    /**
     * M�todo encargado de vender la primera silla que se encuentre disponible teniendo en cuenta una localidad llega por par�metro y la informaci�n del partido <br>
     * Si el comprador es socio del equipo, se le vende la silla con descuento de socio.
     * <b> pre: </b> La lista de partidos se encuentra inicializada <br>
     *               La lista de socios se encuentra inicializada <br> 
     * <b> post: </b> Se silla fue vendida<br>
     * @param pLocalidad Localidad de la silla que se quiere vender - pLocalidad != "" && pLocalidad != null
     * @param pNombreComprador Nombre del comprador de la silla - pNombreComprador != "" && pNombreComprador != null
     * @param pCedulaComprador C�dula del comprador de la silla - pCedulaComprador != "" && pCedulaComprador != null
     * @param pRival Rival contra el que se juega - pRival != "" && pRival != null
     * @param pTorneo Nombre del torneo en el que se jugara el partido - pTorneo != null && ( pTorneo == Partido.TORNEO_LIGA || pTorneo == Partido.TORNEO_COPA || pTorneo == Partido.TORNEO_SUPER_LIGA )<br>
     * @param pFechaPartido Fecha del partido - pFechaPartido != null && pFechaPartido != ""
     * @return costoVenta El costo de la venta de la Silla
     * @throws Exception Env�a excepci�n en caso de no encontrar el partido.    
     * 		   Env�a excepci�n en caso de no encontrar ninguna silla disponible
     *                      
     */
    public double venderSillaAutomatica( String pLocalidad, String pNombreComprador, String pCedulaComprador, String pRival, String pTorneo, String pFechaPartido ) throws Exception
    {
        //TODO Completar seg�n la documentaci�n del m�todo
    }
    

    //TODO Cree la documentaci�n e Implemente el m�todo darTotalIngresos
    //Responsabilidad del m�todo: Calcula el valor total de ingresos de todos los partidos
    
    /**
     * Elimina un partido dado el nombre del rival, del torneo y la fecha. No se puede eliminar un partido que tiene boletas vendidas.<br>
     * <b> pre: </b> La lista de partidos se encuentra inicializada <br>
     * <b> post: </b> Se elimin� el partido de la lista<br>
     * @param pRival Rival contra el que se juega - pRival != "" && pRival != null
     * @param pTorneo Nombre del torneo en el que se jugara el partido - pTorneo != null && ( pTorneo == Partido.TORNEO_LIGA || pTorneo == Partido.TORNEO_COPA || pTorneo == Partido.TORNEO_SUPER_LIGA )<br>
     * @param pFechaPartido Fecha del partido - pFecha != "" && pFecha != null
     * @throws Exception    Se env�a excepci�n cuando se intenta eliminar un partido con boletas vendidas.
     *                      Se env�a excepci�n cuando no se encuentra el partido a eliminar.
     */
    public void eliminarPartido( String pRival, String pTorneo, String pFechaPartido ) throws Exception
    {
        //TODO Completar seg�n la documentaci�n del m�todo
    }

    // -----------------------------------------------------------------
    // Puntos de Extensi�n
    // -----------------------------------------------------------------

    
    /**
     * M�todo para la extensi�n 1
     * @return respuesta1
     */
    public String metodo1( )
    {
        return "Respuesta 1";
    }

    /**
     * M�todo para la extensi�n 2
     * @return respuesta2
     */
    public String metodo2( )
    {
        return "Respuesta 2";
    }

}