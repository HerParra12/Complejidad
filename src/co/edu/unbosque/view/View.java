package co.edu.unbosque.view;
/**
 * The import that allows us to use an joptionpane
 */
import javax.swing.JOptionPane;

/**
 * The class that shows all the visual asspects to the user.
 * @author Kevin Pinzon
 * @author Hernan Alvarado
 * @author Jorge Yate
 * @author Johan Ayala
 */
public class View {
	/**
	 * Variable that will help to validate the inputs of the messages
	 */
	private int select;
	/**
	 * Instantiates a new View.
	 */
	public View() {
		select=-1;
	}

	/**
	 * This method reads and validate the input of an int value
	 *
	 * @param mensaje The message that will be showed to the user
	 * @return the The value that the user registered at the input, type int
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
	 * This method reads and validate the input of an double value
	 *
	 * @param mensaje The message that will be showed to the user
	 * @return The value that the user registered at the input, type double
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
	 * This method shows to the user any type of message, through an joptionpane
	 *
	 * @param mensaje The message that will be showed
	 */
	public void mostrarmensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}

	/**
	 * This method reads and validate the input of an string value
	 *
	 * @param instruccion The message that will be showed to the usern
	 * @return The string that the user registered
	 */
	public String leerDatoString(String instruccion) {
		String respuesta = "";
		respuesta = JOptionPane.showInputDialog(instruccion);
		return respuesta;
	}

	/**
	 * This method shows and validates the initial menu.
	 *
	 * @return The option (validated) that the user selected
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