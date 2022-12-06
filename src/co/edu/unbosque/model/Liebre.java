package co.edu.unbosque.model;

/**
 * Saves the data performed by the free, whether its positioning 
 * between the row x column, its current status current state.
 * 
 * @author Hernan Alvarado
 * @author Kevin Pinzon
 * @author Eduardo Bocanegra
 * @author Johan Ayala
 * @since 2022
 * @version 1.0
 */
public class Liebre {

	/**
	 * Indice de la fila en la que se encuentra.
	 */
	private int x;
	
	/**
	 * Determina si el proceso fue realizados exitosamente o no.
	 */
	private boolean termino;
	
	/**
	 * Indice de la columa en la que se encuentra.
	 */
	private int y;
	
	/**
	 * Determina si una determinada posicion ya se ha tenido en cuenta.
	 */
	private boolean liebrepasado;

    /**
     * Gets x.
     *
     * @return the x
     */
    public int getX() {
		return x;
	}

    /**
     * Sets x.
     *
     * @param x the x
     */
    public void setX(int x) {
		this.x = x;
	}

    /**
     * Is termino boolean.
     *
     * @return the boolean
     */
    public boolean isTermino() {
		return termino;
	}

    /**
     * Sets termino.
     *
     * @param termino the termino
     */
    public void setTermino(boolean termino) {
		this.termino = termino;
	}

    /**
     * Gets y.
     *
     * @return the y
     */
    public int getY() {
		return y;
	}

    /**
     * Sets y.
     *
     * @param y the y
     */
    public void setY(int y) {
		this.y = y;
	}

    /**
     * Is liebrepasado boolean.
     *
     * @return the boolean
     */
    public boolean isLiebrepasado() {
		return liebrepasado;
	}

    /**
     * Sets liebrepasado.
     *
     * @param liebrepasado the liebrepasado
     */
    public void setLiebrepasado(boolean liebrepasado) {
		this.liebrepasado = liebrepasado;
	}

	@Override
	public String toString() {
		return "Liebre [x=" + x + ", y=" + y + "]";
	}

    /**
     * Instantiates a new Liebre.
     *
     * @param x the x
     * @param y the y
     */
    public Liebre(int x, int y) {
		this.x = x;
		this.y = y;
		this.liebrepasado = false;
		this.termino = false;
	}
}