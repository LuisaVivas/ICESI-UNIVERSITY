package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import vista.MiVentana;
import vista.MiVentanaJuego;
import modelo.Operaciones;

public class Ejecutable {

	/**
	 * @param args
	 */

	// El control debe tener instancias del modelo y de la vista
	public static Operaciones modeloOperaciones;
	public static MiVentana vistaMiVentana;
	public static MiVentanaJuego vistaMiVentanaJuego;

	public static void main(String[] args) {
		// Inicializo los objetos
		modeloOperaciones = new Operaciones();
		vistaMiVentana = new MiVentana();

		// Adiciono los listeners a la ventana principal
		escuchaBotonJugar();
		escuchaMiVentana();

		// Hago visible la ventana principal
		vistaMiVentana.setVisible(true);

	}

	// Todos los m�todos que empiezan con "escucha" definen los listeners de la
	// interfaz gr�fica
	public static void escuchaMiVentana() {
		vistaMiVentana.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}

		});
	}

	public static void escuchaMiVentanaJuego() {
		vistaMiVentanaJuego.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub

				vistaMiVentana.setVisible(true);
			}
		});
	}

	public static void escuchaBotonJugar() {
		vistaMiVentana.getBotonJugar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String nombre = vistaMiVentana.getCampoTextoNombre().getText();
				modeloOperaciones.definirJugador(nombre);

				// Inicializa la ventana del juego
				vistaMiVentanaJuego = new MiVentanaJuego();
				// Completa la informaci�n para la primera operaci�n antes de
				// mostrar la ventana al usuario.
				vistaMiVentanaJuego.getNumUno().setText(
						"" + modeloOperaciones.getNumeroUno());
				vistaMiVentanaJuego.getNumDos().setText(
						"" + modeloOperaciones.getNumeroDos());
				if (modeloOperaciones.isSuma()) {
					vistaMiVentanaJuego.getEtiqOperaci�n().setText("+");
				} else {
					vistaMiVentanaJuego.getEtiqOperaci�n().setText("-");
				}
				// Se hace la llamada a los m�todos que adicionan los listeners.
				escuchaMiVentanaJuego();
				escuchaBotonVerificarYNuevaOpera();
				vistaMiVentana.setVisible(false);
				vistaMiVentanaJuego.setVisible(true);

			}
		});
	}

	public static void escuchaBotonVerificarYNuevaOpera() {
		vistaMiVentanaJuego.getBotonVerificarYNuevaOpera().addActionListener(
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// Se verifica el resultado que escribio el usuario
						// contra el resultado correcto
						int resultado = Integer.parseInt(vistaMiVentanaJuego
								.getCampoTextoResultado().getText());
						boolean acerto = modeloOperaciones
								.validarResultado(resultado);
						String mensaje = "";
						if (acerto) {
							mensaje = "Es correcto. Su puntaje ha subido a: ";
						} else {
							mensaje = "Es incorrecto. Su puntaje ha bajado a: ";
						}
						JOptionPane.showMessageDialog(null, mensaje
								+ modeloOperaciones.getUsuarioActual()
										.getPuntajeAcum(), "Suma Y Resta",
								JOptionPane.INFORMATION_MESSAGE);
						// Genera una nueva operaci�n y actualiza los campos de
						// la ventana juego
						modeloOperaciones.generarOperaci�n();
						vistaMiVentanaJuego.getNumUno().setText(
								"" + modeloOperaciones.getNumeroUno());
						vistaMiVentanaJuego.getNumDos().setText(
								"" + modeloOperaciones.getNumeroDos());
						if (modeloOperaciones.isSuma()) {
							vistaMiVentanaJuego.getEtiqOperaci�n().setText("+");
						} else {
							vistaMiVentanaJuego.getEtiqOperaci�n().setText("-");
						}
						vistaMiVentanaJuego.getCampoTextoResultado()
								.setText("");
					}
				});

	}
}
