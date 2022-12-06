package co.edu.unbosque.model;


/**
 * Assembler class that allows you to block and integrate the classes 
 * that resolve a given exercise of the {@link co.edu.unbosque.model}.
 * 
 * @author Hernan Alvarado
 * @author Kevin Pinzon
 * @author Eduardo Bocanegra
 * @since 2022
 * @version 1.0
 */
public class Model {
	

	/**
	 * The type Salto liebre.
	 */
	private SaltoLiebre saltoLiebre;
	
	/**
	 * The type Solitario chino.
	 */
	private SolitarioChino solitario;
	
	/**
	 * Manage the process to obtain the optimal menu that a 
	 * given user requires. required by a given user
	 */
	private Nutricionista nutricionista;

    /**
     * Instantiates a new Model.
     */
    public Model() {
		saltoLiebre = new SaltoLiebre();
		solitario = new SolitarioChino();
		nutricionista = new Nutricionista();

	}

    /**
     * Leer matriz liebre string.
     *
     * @param matrix the matrix
     * @return the string
     */
    public String leerMatrizLiebre(String matrix[][]) {
		StringBuilder builder = new StringBuilder();
		for (int i = 1; i < (matrix.length - 1); i++) {
			for (int j = 1; j < (matrix.length - 1); j++) {
				builder.append("[" + matrix[i][j] + "]");
			}
			builder.append("\n");
		}
		return builder.toString();
	}

    /**
     * Leer matriz string.
     *
     * @param matrix the matrix
     * @return the string
     */
    public String leerMatriz(String matrix[][]) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < (matrix.length); i++) {
			for (int j = 0; j < (matrix.length); j++) {
				builder.append("[" + matrix[i][j] + "]");

			}
			builder.append("\n");
		}
		return builder.toString();
	}

    /**
     * Gets salto liebre.
     *
     * @return the salto liebre
     */
    public SaltoLiebre getSaltoLiebre() {
		return saltoLiebre;
	}

    /**
     * Sets salto liebre.
     *
     * @param saltoLiebre the salto liebre
     */
    public void setSaltoLiebre(SaltoLiebre saltoLiebre) {
		this.saltoLiebre = saltoLiebre;
	}

    /**
     * Gets solitario.
     *
     * @return the solitario
     */
    public SolitarioChino getSolitario() {
		return solitario;
	}

    /**
     * Sets solitario.
     *
     * @param solitario the solitario
     */
    public void setSolitario(SolitarioChino solitario) {
		this.solitario = solitario;
	}

    /**
     * Gets nutricionista.
     *
     * @return the nutricionista
     */
    public Nutricionista getNutricionista() {
		return nutricionista;
	}

    /**
     * Sets nutricionista.
     *
     * @param nutricionista the nutricionista
     */
    public void setNutricionista(Nutricionista nutricionista) {
		this.nutricionista = nutricionista;
	}
}