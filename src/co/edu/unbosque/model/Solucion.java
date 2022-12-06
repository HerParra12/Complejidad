package co.edu.unbosque.model;

/**
 * Esta clase es la que muestra solucion y ademas implementa la clase salto
 * @author Kevin Pinzon
 * @author Hernan Alvarado
 * @author Jorge Yate
 * @author Johan Ayala
 */
public class Solucion {
	

	/**
	 * Variable s es de tipo salto la cual nos dice su origen y demas
	 */
	private Salto[] s;

	/**
	 * Get s salto [ ].
	 *
	 * @return the salto [ ]
	 */
	public Salto[] getS() {
		return s;
	}

	/**
	 * Sets s.
	 *
	 * @param s the s
	 */
	public void setS(Salto[] s) {
		this.s = s;
	}

	/**
	 * Instantiates a new Solucion.
	 *
	 * @param s the s
	 */
	public Solucion(Salto[] s) {
		super();
		this.s = s;
	}
}
