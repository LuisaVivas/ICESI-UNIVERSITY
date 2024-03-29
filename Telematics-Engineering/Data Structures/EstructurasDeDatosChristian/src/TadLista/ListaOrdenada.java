package TadLista;

public class ListaOrdenada<T extends Comparable<T>> implements ILista<T> {
	
	// ----------------------------------------------------------------------------
	// ATRIBUTOS
	// ----------------------------------------------------------------------------

	private int longitud;

	private boolean ascendente;

	private NodoOrdenado<T> primero;

	// ----------------------------------------------------------------------------
	// CONSTRUCTOR
	// ----------------------------------------------------------------------------
	/**
	 * Metodo constructor que crea una instancia de la clase Lista Ordenada de
	 * longitud 0 y orde pasado por parametro
	 * 
	 * @param boolean ascendente true si se quiere orden de menor a mayor y
	 *        false si se quiere de mayor a menor
	 */
	public ListaOrdenada(boolean ascendente) {

		this.longitud = 0;
		this.ascendente = ascendente;
		this.primero = new NodoOrdenado<T>(null);

	}

	// ----------------------------------------------------------------------------
	// METODOS
	// ----------------------------------------------------------------------------

	/**
	 * Metodo que agrega una nuevo elemento generico a la lista de forma
	 * ordenada
	 * 
	 * pre: <b/>valor=!null<br>
	 * pos: la lista tiene un nuevo elemento
	 * 
	 * @param valor
	 *            elemento nuevo que se agregar� a la lista
	 * */
	@Override
	public void agregar(T contenido) {

		NodoOrdenado<T> nuevo = new NodoOrdenado<T>(contenido);

		NodoOrdenado<T> actual;
		for (actual = primero; actual.getSiguiente() != null
				&& comparar(actual.getSiguiente(), nuevo) <= 0; actual = actual
				.getSiguiente()) {
		}
		
		nuevo.setSiguiente(actual.getSiguiente());
		actual.setSiguiente(nuevo);
		longitud++;
	}

	/**
	 * Metodo que agrega una nuevo elemento generico a la lista de forma
	 * ordenada
	 * 
	 * pre: <b/>valor=!null<br>
	 * pos: la lista tiene un nuevo elemento
	 * 
	 * @param valor
	 *            elemento nuevo que se agregar� a la lista
	 * @param int pos, al ser lista ordenada no se tiene en cuenta este
	 *        parametro
	 * */
	@Override
	public void agregar(int pos, T contenido) throws Exception {
		agregar(contenido);
	}

	/**
	 * Metodo que compara dos nodos ordenados, verifica si la lista es
	 * ascendente o no, y en base a eso devuelve el orden de comparacion
	 * 
	 * @param actual
	 *            nodo a comparar
	 * @param nuevo
	 *            nodo con el cual comparar actual
	 * @return si la lista es ascendente num<0 si actual es menor que nuevo, num>0 si actual es mayor a nuevo. 
	 * 		   si la lista es descendente num>0 si actual es menor que nuevo, num<0 si actual es mayor a nuevo 
	 *         0 es ambos casos si actual es igual a nuevo
	 */
	public int comparar(NodoOrdenado<T> actual, NodoOrdenado<T> nuevo) {

		int comparacion = actual.comparar(nuevo);

		if (!isAscendente()) {
			comparacion = -comparacion;
		}

		return comparacion;

	}

	/**
	 * Metodo que elimina el elemento en la posicion pasada por parametro
	 * 
	 * pre: <b/>longitud>pos>=0<br>
	 * pre: <b/>lista!=null<br>
	 * pos: la lista tiene elemento menos
	 * 
	 * 
	 * @param pos
	 *            posicion del elemento a agregar
	 * @throws Exception
	 *             si no existen elementos en la lista si la posicion no es
	 *             igual a longitud , el rango valido va de 0 a longitud-1 si la
	 *             posicion por parametro es negativa
	 * */
	@Override
	public void eliminar(int pos) throws Exception {

		if (esVacia()) {
			throw new Exception("Error, no hay elementos en la lista");
		}

		if (pos < 0 || pos >= longitud) {
			throw new Exception("Error, posicion invalido");
		}

		NodoOrdenado<T> actual = primero;
		for (int i = 0; i<pos && actual.getSiguiente() != null; i++) {
			actual = actual.getSiguiente();
		}

		actual.setSiguiente(actual.getSiguiente().getSiguiente());
		longitud--;
	}

	/**
	 * Metodo que retorna un elemento de la lista
	 * 
	 * pre: <b/>pos>=0<br>
	 * pre: <b/longitud>pos<br>
	 * pre: <b/>lista!=null<br>
	 * 
	 * @param pos
	 *            posicion del elemento a retornar
	 * @return T elemento en la posicion indicada o null si no lo encuentra
	 * */
	@Override
	public T darElemento(int pos) {

		T elemento = null;

		if (pos >= 0 && pos < longitud) {

			NodoOrdenado<T> actual = primero;
			for (int i = 0; (i <= pos) && (actual.getSiguiente() != null); i++) {
				actual = actual.getSiguiente();
			}

			elemento = actual.getContenido();
		}

		return elemento;
	}

	/**
	 * Metodo que retorna la longitud de la lista
	 * 
	 * @return int longitud de la lista
	 * */
	@Override
	public int darLongitud() {
		// TODO Auto-generated method stub
		return longitud;
	}

	/**
	 * Metodo que retorna si la lista esta vacia
	 * 
	 * @return boolean true si esta vacia, false si no.
	 * */
	@Override
	public boolean esVacia() {
		// TODO Auto-generated method stub
		return (longitud == 0);
	}

	/**
	 * Metodo que escribe en consola los elementos internos
	 * */
	@Override
	public void print() {

		NodoOrdenado<T> actual = primero.getSiguiente();

		for (int i = 0; i < longitud; i++) {
			System.out.println(actual.getContenido().toString());
			actual = actual.getSiguiente();
		}

	}

	/**
	 * Metodo que describe si la lista es ascendente o descendente
	 * 
	 * @return true si es ascendente, false de lo contrario
	 * */
	public boolean isAscendente() {
		return ascendente;
	}
	
	/**
	 * Metodo que reinicia la lista
	 * 
	 * pos: la lista queda limpia de elementos
	 * */
	public void limpiar(){
		this.longitud = 0;
		this.primero = new NodoOrdenado<T>(null);
	}

}
