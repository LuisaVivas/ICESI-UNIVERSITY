package Modelo;

public class Fecha {

	
	private String dia;
	private String mes;
	private String a�o;
	private Cita[] citas;
	
	public Fecha(String nDia,String nMes, String nA�o){
		
		dia = nDia;
		mes = nMes;
		a�o = nA�o;
		citas = new Cita[15];
		String fecha = dia+"-"+mes+"-"+a�o;
		for(int i=0;i<citas.length;i++){
			citas[i] = new Cita(fecha,i);
			
		}
		
	}
	
	public void cancelarCita(int num){
		
		citas[num].desocupar();
		
	}
	
	public void crearCita(Paciente p, int num){
		
		if(!(citas[num].estaOcuapada())){
			
			citas[num].ocupar(p);
		}
		
	}
	
	public String[] darDisponibilidad(){
		
		String[] estados = new String[15];
		String ocu = "No disponible";
		String des = "Disponible";
		
		for(int i =0; i< citas.length;i++){
			
			if(citas[i].estaOcuapada()){
				estados[i]=ocu;
			}
			else{
				estados[i]=des;
			}
		}
		
		return estados;
		
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getA�o() {
		return a�o;
	}

	public void setA�o(String a�o) {
		this.a�o = a�o;
	}

	public Cita[] getCitas() {
		return citas;
	}

	public void setCitas(Cita[] citas) {
		this.citas = citas;
	}
	
	
	
	
}
