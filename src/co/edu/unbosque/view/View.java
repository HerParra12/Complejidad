package co.edu.unbosque.view;

import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * The type View.
 */
public class View {
	
	private int select;


	/**
	 * Instantiates a new View.
	 */
	public View() {
	
		select=-1;
		
	}

	/**
	 * Leer dato int.
	 *
	 * @param mensaje the mensaje
	 * @return the int
	 */
	public  int leerDato(String mensaje) {
		int respuesta=0;
		try {
			
		
		String instruccion=JOptionPane.showInputDialog(mensaje);
		respuesta=Integer.parseInt(instruccion);
	
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Digite un numero");
			respuesta =leerDato(mensaje);
			
		}
		return respuesta;
	}

	/**
	 * Leerdo double.
	 *
	 * @param mensaje the mensaje
	 * @return the double
	 */
	public double leerdo(String mensaje) {
		double respuesta=0;
		try {
		
		String instruccion=JOptionPane.showInputDialog(mensaje);
		respuesta=Double.parseDouble(instruccion);
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Digite un numero");
			respuesta =leerdo(mensaje);}
		return respuesta;
	}

	/**
	 * Mostrarmensaje.
	 *
	 * @param mensaje the mensaje
	 */
	public void mostrarmensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}

	/**
	 * Leer dato string string.
	 *
	 * @param instruccion the instruccion
	 * @return the string
	 */
	public String leerDatoString(String instruccion) {
		String respuesta = "";
		respuesta = JOptionPane.showInputDialog(instruccion);
		return respuesta;
	}

	/**
	 * Leer dato menu int.
	 *
	 * @return the int
	 */
	public int leerDatoMenu() {
		int respuesta =0;
		try {
	
		String mensaje = JOptionPane.showInputDialog("Digite que ejercicio quiere hacer:"
				+"\n1. Nutricionista"
				+"\n2. Solitario continental"
				+"\n3. Salto liebre"
				
			
				+"\n0. Salir");
		respuesta = Integer.parseInt(mensaje);
	
		}catch (Exception e){
			JOptionPane.showMessageDialog(null, "Digite de nuevo una opcion valida");
			respuesta=leerDatoMenu();
		
			
			
		}
		return respuesta;
		
	}

	/**
	 * Gets select.
	 *
	 * @return the select
	 */
	public int getSelect() {
		return select;
	}

	/**
	 * Sets select.
	 *
	 * @param select the select
	 */
	public void setSelect(int select) {
		this.select = select;
	}
}