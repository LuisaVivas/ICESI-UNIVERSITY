package TadColaPrioridad;


public class NodoPrioridad<T> implements INodoPrioridad<T> {

	private T contenido;
	private int prioridad;
	private NodoPrioridad<T> siguiente;
	private NodoPrioridad<T> anterior;

	
	
public NodoPrioridad(int prioridad, T contenido) {
		
		this.contenido = contenido;
		this.prioridad = prioridad;
		siguiente = null;
		anterior= null;
		
	}
	


	public T getContenido() {
		return contenido;
	}
	
	
	public void setContenido(T contenido) {
		this.contenido = contenido;
	
	}
	
	public int getPrioridad() {
		return prioridad;
	}
	
	
	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}
	
	
	public NodoPrioridad<T> getSiguiente() {
		return siguiente;
	}
	
	
	public void setSiguiente(NodoPrioridad<T> siguiente) {
		this.siguiente = siguiente;
	}
	
	
	public NodoPrioridad<T> getAnterior() {
		return anterior;
	}
	
	
	public void setAnterior(NodoPrioridad<T> anterior) {
		this.anterior = anterior;
	}








	



	
	
	
}
