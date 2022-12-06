package co.edu.unbosque.model;

/**
 * The class to give the jump of the empty space
 * @author Kevin Pinzon
 * @author Hernan Alvarado
 * @author Jorge Yate
 * @author Johan Ayala
 */
public class Salto {
	/**
	 * Variable that defines the initial position
	 */
	private Par origen;
	/**
	 * Variable that defines the final position of the empty space
	 */
	private Par destine;
	/**
	 * Variable that defines the token that will be eaten
	 */
	private Par comida;

	/**
	 * Gets origen.
	 *
	 * @return the origen
	 */
	public Par getOrigen() {
		return origen;
	}

	/**
	 * Sets origen.
	 *
	 * @param origen the origen
	 */
	public void setOrigen(Par origen) {
		this.origen = origen;
	}

	/**
	 * Gets destine.
	 *
	 * @return the destine
	 */
	public Par getDestine() {
		return destine;
	}

	/**
	 * Sets destine.
	 *
	 * @param destine the destine
	 */
	public void setDestine(Par destine) {
		this.destine = destine;
	}

	/**
	 * Gets comida.
	 *
	 * @return the comida
	 */
	public Par getComida() {
		return comida;
	}

	/**
	 * Sets comida.
	 *
	 * @param comida the comida
	 */
	public void setComida(Par comida) {
		this.comida = comida;
	}

}
