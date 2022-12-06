package co.edu.unbosque.model;

import java.util.ArrayList;

/**
 * The type Tablero.
 */
public class Tablero {
	
	private Liebre[][] campoliebre;
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
	 * Mejor camino.
	 *
	 * @param camino1 the camino 1
	 */
	public void mejorCamino (ArrayList<Liebre> camino1) {
		if (camino1 != null && !camino1.isEmpty() ) {
			camino=camino1;
		}
	
		
	}

	/**
	 * Mostrar caminos string.
	 *
	 * @return the string
	 */
	public String mostrarCaminos() {
		String camino1 = "";
		camino1 += "Minimo de saltos: " + (camino.size() - 1);
		for (Liebre c : camino) {
			camino1 += "\n" + c;
		}
		return camino1;

	}


	

}