package TadPila;

public interface IPila<T>{
	
	
	/**
	 * Metodo que inserta un elemento en el tope de la pila 
	 * 
	 * pre: la lista debe existir. logitud>=0
	 * pos: la pila tiene un nuevo elemento
	 * 
	 * @param contenido del nodo a insertar en el tope
	 */
	public void push(T contenido); 
	
	/**
	 * Metodo que eliminia el elemento en el tope de la pila
	 * 
	 * pre: la pila debe existir. Longitud>0
	 * pos: la pila tiene un elemento menos longitud = longitud -1
	 * 
	 * @return T elemento eliminado de la pila
	 * @throws Exception cuando se intenta eliminar un elemento y la longitud = 0
	 */
	public T pop() throws Exception;
	
	
	/**
	 * Metodo que retorna el elemento en el tope de la pila
	 * 
	 * pre: la pila debe existir. Longitud>0
	 * 
	 * @return T el elemento del tope
	 */
	public T peek();
	
	/**
	 * Metodo que informa si la pila esta vacia
	 * 
	 * pre: la pila debe existir
	 * 
	 * @return true pila tiene al menos un elemento, false de lo contrario
	 */
	public boolean isEmpty();
	
	/**
	 * Metodo que elimina el contenido de la pila
	 * 
	 * pre: la pila debe existir
	 * pos: la pila queda limpia de elementos
	 */
	public void clear();
	

}