package co.edu.unbosque.model;
/**
 * Este import nos sirve para utilizar un arraylist
 */
import java.util.ArrayList;

/**
 * Esta clase es que llena el tablero con y lo va guardando
 * @author Kevin Pinzon
 * @author Hernan Alvarado
 * @author Jorge Yate
 * @author Johan Ayala
 */
public class Tablero {
	/**
	 * Variable campoliebre es de tipo liebre[][] es cual es la posicion de la liebre
	 */
	private Liebre[][] campoliebre;
	/**
	 * Variable es la que nos guarda el camino de la liebre
	 */
	private ArrayList<Liebre> camino;

	/**
	 * Get campoliebre liebre [ ] [ ].
	 *
	 * @return the liebre [ ] [ ]
	 */
	public Liebre[][] getCampoliebre() {
		return campoliebre;
	}

	/**
	 * Sets campoliebre.
	 *
	 * @param campoliebre the campoliebre
	 */
	public void setCampoliebre(Liebre[][] campoliebre) {
		this.campoliebre = campoliebre;
	}

	/**
	 * Gets camino.
	 *
	 * @return the camino
	 */
	public ArrayList<Liebre> getCamino() {
		return camino;
	}

	/**
	 * Sets camino.
	 *
	 * @param camino the camino
	 */
	public void setCamino(ArrayList<Liebre> camino) {
		this.camino = camino;
	}

	/**
	 * Instantiates a new Tablero.
	 *
	 * @param campoliebre the campoliebre
	 */
	public Tablero(Liebre[][] campoliebre) {
	
		this.campoliebre = campoliebre;
	     camino = new ArrayList<>();
	}

	/**
	 * Limitartableto boolean.
	 *
	 * @param x the x
	 * @param y the y
	 * @return the boolean
	 */
	public boolean limitartableto(int x, int y) {
		
		return (x > 0 && x < (campoliebre.length - 1)) && (y > 0 && y < (campoliebre[0].length-1));
	}

	/**
	 * Posicion liebre liebre.
	 *
	 * @param x the x
	 * @param y the y
	 * @return the liebre
	 */
	public Liebre posicionLiebre(int x ,int y) {
		if (limitartableto(x,y)) {
			return campoliebre[x][y];
		}
		return null;
	}

	/**
	 * Este metodo nos guardar el mejor camino posible
	 *
	 * @param camino1 the camino 1
	 */
	public void mejorCamino (ArrayList<Liebre> camino1) {
		if (camino1 != null && !camino1.isEmpty() ) {
			camino=camino1;
		}
	
		
	}
}