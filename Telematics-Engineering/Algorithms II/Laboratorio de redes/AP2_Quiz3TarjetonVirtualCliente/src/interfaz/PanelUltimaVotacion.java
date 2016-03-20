package interfaz;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class PanelUltimaVotacion extends JPanel{
	private JLabel labInfoVotacion;
	
	public PanelUltimaVotacion(){
		setBorder(new TitledBorder("Ultima Votaci�n"));
		setLayout(new BorderLayout());
		
		labInfoVotacion = new JLabel("No se ha realizado ning�na votaci�n a�n.");
		
		add(labInfoVotacion);
	}
	
	public void refrescarInfoVotacion(String infoVotacion){
		labInfoVotacion.setText(infoVotacion);
	}
}
