package interfaz;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import mundo.UrnaVotacion;

@SuppressWarnings("serial")
public class InterfazUrnaVotacion extends JFrame{
	
	private UrnaVotacion miUrnaVotacion;
	
	private PanelUltimaVotacion panelUltimaVotacion;
	private PanelVotacion panelVotacion;
	
	//Atributos de la conexi�n con sockets
		public final static String SERVIDOR  = ""; //puede ser un nombre de dominio o una IP
		public final static int PUERTO       = -1;
		
		private Socket canal;
		private PrintWriter escrituraEnElCanal;
		private BufferedReader lecturaDelCanal;	
		
		//Constantes asociadas con el protocolo de comunicaci�n entre cliente/servidor
		public final static String VOTAR               = "VOTAR";
		public final static String VOTO_EXITOSO        = "VOTO_EXITOSO";
		public final static String CANDIDATO_NO_EXISTE = "CANDIDATO_NO_EXISTE";
		public final static String FINALIZAR_CONEXION  = "FINALIZAR_CONEXION";
		
	
	public InterfazUrnaVotacion(){
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Cliente :: Urna de Votaci�n");
		setLayout(new BorderLayout());
		
		try{
			miUrnaVotacion = new UrnaVotacion();
		}catch(IOException excep){
			JOptionPane.showMessageDialog(this, "El cliente no puede iniciar.\n\nPosible Causa:\n"+excep.getMessage());
		}
		
		panelUltimaVotacion = new PanelUltimaVotacion();
		panelVotacion = new PanelVotacion(this);
		
		add(panelUltimaVotacion, BorderLayout.NORTH);		
		add(panelVotacion, BorderLayout.CENTER);	
		
		
		//Inicializar par�metros de comunicaci�n
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//__________________________________________________________________________
		
		pack();
	}
	
	public void votar(){
		String codigoCandidatoElegido = panelVotacion.darCodigoCandidatoElegido();

		String infoVotacion = "";
		
		try{
		//Implementar el protocolo de comunicaci�n para la votaci�n
			
			
			
			
			
			
			panelUltimaVotacion.refrescarInfoVotacion(infoVotacion);
		
		}catch(Exception ex){
			
			infoVotacion = "Se produjo un error en la transmisi�n del voto virtual.";
			panelUltimaVotacion.refrescarInfoVotacion(infoVotacion);
			
		}
		
		pack();
	}
public void cerrarConexion(){
		
		escrituraEnElCanal.println(FINALIZAR_CONEXION);

	}	
	public void dispose(){
		cerrarConexion();
		
		JOptionPane.showMessageDialog(this, "Se ha cerrado toda posible conexi�n con un servidor.\n\nEl programa terminar�.");
		System.exit(0);
	}

	public static void main(String[] args){
		new InterfazUrnaVotacion().setVisible(true);
	}
}
