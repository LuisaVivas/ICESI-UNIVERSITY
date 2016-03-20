package mundo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import sun.security.x509.IPAddressName;

public class UrnaVotacion {
	
	//Atributos del Mundo del Cliente
	private String codigoUltimoVoto;
	private String nombreUltimoVoto;
	private String partidoUltimoVoto;
	
	private boolean ultimoVotoExitoso;
	
	
	public UrnaVotacion() throws IOException{
		codigoUltimoVoto  = "";
		nombreUltimoVoto  = "";
		partidoUltimoVoto = "";
		ultimoVotoExitoso = false;
		
	}
	
	public String darUltimaVotacion(){
		String ultimaVotacion;
		
		if(ultimoVotoExitoso){
			ultimaVotacion = "C�digo: "+codigoUltimoVoto+", Nombre: "+nombreUltimoVoto+", Partido: "+partidoUltimoVoto;
		}else{
			ultimaVotacion = "El �ltimo intento de voto no fue exitoso. Quiz� el c�digo del candidato no exist�a.";
		}
		
		return ultimaVotacion;
	}
	
	public void votar(String codigoCandidato) throws IOException{
		

		
		
		
	}
	
	
}
