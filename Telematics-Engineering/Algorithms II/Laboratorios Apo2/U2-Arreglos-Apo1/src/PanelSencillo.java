import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class PanelSencillo extends JPanel{

	
	/** Se sobreescribe el m�todo paintComponent para realizar un dibujo */ 
	public void paintComponent(Graphics gr�fico) { 
	super.paintComponent(gr�fico); 
	gr�fico.drawRect(20,20,150,50); 
	gr�fico.setColor(Color.blue); 
	Font a = new Font("Serif",Font.BOLD,14);
	gr�fico.setFont(a); 
	gr�fico.drawString("H O L A",70,50); 
	
	//lineas
	gr�fico.drawLine(1, 1, 60, 60);
	
//	drawChars(char[ ], int, int, int, int): Este m�todo, en lugar de recibir una cadena como par�metro, 
//	recibe un arreglo de caracteres. En los siguientes par�metros se indica cu�l es el primer car�cter 
//	en el arreglo a dibujar y el n�mero de caracteres, a partir de este, que se dibujan. Los �ltimos 
//	valores equivalen a las coordenadas x,y a partir de las cuales se dibujan los caracteres. 

	//rectangulo redondeado
	gr�fico.drawRoundRect (5, 7, 111, 111, 10, 10);
	
	//rectangulo 3d
	gr�fico.draw3DRect(20, 20, 30, 30, false);
	gr�fico.fill3DRect(20,20,70,50,true);
	
	//camabia backgroud
	this.setBackground(Color.lightGray);
	
	//poligonos
	int[] valoresX = {40,50,70,50,40,30,10,30}; 
	int[] valoresY= {10,30,40,50,70,50,40,30};
	gr�fico.drawPolygon(valoresX,valoresY,valoresX.length); 
	
	int[] coordX = {80,60,60,70,100}; 
	int[] coordY = {90,70,60,60,80}; 
	gr�fico.drawPolyline(coordX,coordY,5); 
	
	Polygon pol�gono = new Polygon(); 
	pol�gono.addPoint(10,10); 
	pol�gono.addPoint(10,30); 
	pol�gono.addPoint(20,20); 
	gr�fico.drawPolygon(pol�gono); 
	
	//imagenes
	
	
		Toolkit ambiente = Toolkit.getDefaultToolkit(); 
		Image im�gen = ambiente.getImage(""); 
		gr�fico.drawImage(im�gen,20,20,this); 
	



	} 
	public static void main(String[] args) { 
	JFrame ventana = new JFrame("Panel Sencillo"); 
	ventana.setSize(200,150); 
	// Adiciona el lienzo que tiene el m�todo paint sobreescrito 
	ventana.getContentPane().add(new PanelSencillo()); 
	/* Al hacer visible el frame el ambiente de ejecuci�n llamar� al m�todo paint de todos los 
	componentes */ 
	ventana.setVisible(true); 
	} 


}
