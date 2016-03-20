package utilArboles;

public interface IAbb<T, K extends Comparable<K>> {
	
	
	 /**
     * Inserta un nuevo elemento en el �rbol.
     * 
     * @param T contenido:contenido a insertar, K key: la llave de busqueda 
     * @throws ElementoExisteException Si el elemento a insertar ya se encuentra en el �rbol
     */
	public void add(T contenido, K key) throws Exception;
	
	
	 /**
     * Eliminar un elemento del �rbol.
     * 
     * @param key: llave del elemento  a eliminar del �rbol.
     * @throws ElementoNoExisteException Si el elemento a eliminar no es encontrado en el �rbol.
     */
	public void remove(K key) throws Exception;
	

	/**
	 * Busca el elemento cuyo key viene dado como par�metro, en el �rbol cuya
	 * ra�z es el nodo actual. <br>
	 * <b>pre:</b> modelo!=null. <br>
	 * <b>post:</b> Se retorn� el elemento que cumple con el modelo o null si no
	 * encuentra ninguno.
	 * 
	 * @param modelo
	 *            Modelo del elemento que se va a buscar
	 * @return Elemento que cumple con el modelo o null si no encuentra ninguno
	 */
	public T search(K key);

	// PESO
	/**
	 * Retorna el n�mero de elementos del �rbol.
	 * 
	 * @return El n�mero de elementos del �rbol.
	 */
	public int getWeight();

	// ALTURA
	/**
	 * Retorna la altura del �rbol.
	 * 
	 * @return La altura del �rbol.
	 */
	public int getHeight();

}
