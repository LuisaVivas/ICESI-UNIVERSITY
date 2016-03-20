package mundo;

/**
 * Entidad que modela un sitio tur�stico
 * @author Juan Manuel Reyes G., Universidad Icesi, Cali-Colombia
 */
public class Sitio {
	
    //-----------------------------------------------------------------
    // Constantes
    //-----------------------------------------------------------------
    /**
     * Constante para modelar la caracter�stica de tipo de sitio CULTURAL
     */
	public final static String CULTURAL   = "CULTURAL"; 

	/**
     * Constante para modelar la caracter�stica de tipo de sitio ESCENARIOS
     */
	public final static String ESCENARIOS = "ESCENARIOS"; 

	/**
     * Constante para modelar la caracter�stica de tipo de sitio COMERCIAL
     */
	public final static String COMERCIAL  = "COMERCIAL";

	/**
     * Constante para modelar la caracter�stica de tipo de sitio de INTER�S
     */
	public final static String INTERES    = "INTERES";
	
    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------
	/**
	 * El nombre del sitio tur�stico
	 */
	private String nombre;

	/**
	 * El nombre del archivo de la imagen del sitio
	 */
	private String nombreImagen;

	/**
	 * El tipo de sitio (si es CULTURAL, ESCENARIOS, etc)
	 */
	private String tipoSitio;

	/**
	 * El a�o en que fue construido el sitio
	 */
	private int anhoConstruccion;

	/**
	 * La direccion del sitio dentro de la ciudad
	 */
	private String direccion;

	/**
	 * La calificacion asignada al sitio de acuerdo con su importancia y su popularidad
	 */
	private int calificacion;
	
    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Crea un sitio con la informaci�n b�sica.
     * @param elNombre es el nombre del nuevo sitio
     * @param elNombreImagen es el nombre del archivo de la imagen del nuevo sitio
     * @param elTipoSitio es el tipo de sitio del nuevo sitio
     * @param elAnhoConstruccion es el a�o en que fue construido el nuevo sitio
     */
	public Sitio(String elNombre, String elNombreImagen, String elTipoSitio, int elAnhoConstruccion, String laDireccion) {
		nombre = elNombre;
		nombreImagen = elNombreImagen;
		tipoSitio = elTipoSitio;
		anhoConstruccion = elAnhoConstruccion;
		direccion = laDireccion;
		calificacion = 0;
	}
	
    //-----------------------------------------------------------------
    // M�todos
    //-----------------------------------------------------------------

    /**
     * Retorna el nombre del sitio.
     * @return nombre
     */
	public String darNombre() {
		return nombre;
	}
	
    /**
     * Modifica el nombre del sitio por el indicado en el par�metro
     * @param elNombre es el nuevo nombre del sitio
     */
	public void cambiarNombre(String elNombre) {
		nombre = elNombre;
	}
	
    /**
     * Retorna el tipo de sitio.
     * @return tipoSitio
     */
	public String darTipoSitio() {
		return tipoSitio;
	}
	
    /**
     * Modifica el tipo de sitio por el indicado en el par�metro
     * @param elTipoSitio es el nuevo tipo de sitio
     */
	public void cambiarTipoSitio(String elTipoSitio) {
		tipoSitio = elTipoSitio;
	}
	
    /**
     * Retorna el a�o de construcci�n del sitio.
     * @return anhoConstruccion
     */
	public int darAnhoConstruccion() {
		return anhoConstruccion;
	}
	
    /**
     * Modifica el a�o de construcci�n por el indicado en el par�metro
     * @param elAnhoConstruccion es el nuevo a�o que se desea asignar
     */
	public void cambiarAnhoConstruccion(int elAnhoConstruccion) {
		anhoConstruccion = elAnhoConstruccion;
	}
	
    /**
     * Retorna la direcci�n del sitio.
     * @return direccion
     */
	public String darDireccion() {
		return direccion;
	}
	
    /**
     * Modifica la direcci�n por la indicada en el par�metro
     * @param laDireccion es la nueva direcci�n del sitio
     */
	public void cambiarDireccion(String laDireccion) {
		direccion = laDireccion;
	}

    /**
     * Retorna el nombre de la imagen del sitio.
     * @return nombreImagen
     */
	public String darNombreImagen() {
		return nombreImagen;
	}

    /**
     * Modifica el el nombre de la imagen por el indicado en el par�metro
     * @param elNombreImagen es el nuevo nombre del archivo de imagen del sitio
     */
	public void cambiarNombreImagen(String elNombreImagen) {
		nombreImagen = elNombreImagen;
	}

    /**
     * Retorna la calificaci�n del sitio.
     * @return calificacion
     */
	public int darCalificacion() {
		return calificacion;
	}

    /**
     * Modifica la calificaci�n por la indicada en el par�metro
     * @param laCalificacion es la nueva calificaci�n del sitio
     */
	public void cambiarCalificacion(int laCalificacion) {
		calificacion = laCalificacion;
	}
}
