package co.edu.unbosque.model;

/**
 * The import that allows us to use the arraylists 
 */
import java.util.ArrayList;

/**
 * The class that defines the jump of the hare
 * 
 * @author Kevin Pinzon
 * @author Hernan Alvarado
 * @author Jorge Yate
 * @author Johan Ayala
 */
public class SaltoLiebre {

	/**
	 * Variable of the class Liebre.
	 */
	private Liebre liebre;
	/**
	 * Variable of the class Tablero
	 */
	private Tablero tablero;
	/**
	 * Variable that will help to show the matriz
	 */
	private String[][] campo1;

	/**
	 * The empty constructor of the class
	 */
	public SaltoLiebre() {
	}

	/**
	 * The constructor that initialize the variables of the class
	 *
	 * @param liebre  The class liebre
	 * @param tablero The class tablero
	 * @param campo1  The variable campo 1
	 */
	public SaltoLiebre(Liebre liebre, Tablero tablero, String[][] campo1) {
		super();
		this.liebre = liebre;
		this.tablero = tablero;
		this.campo1 = campo1;
	}

	/**
	 * This method stuffed the final matriz that will be showed to the user
	 *
	 * @param f   the number of rows
	 * @param c   the number of columns
	 * @param ic  the initial position of the hare at the row
	 * @param iff the initial position of the hare column
	 * @param fc  the final position of the hare at the row
	 * @param ff  the final position of the hare at the column
	 * @return The matrix stuffed
	 */
	public String[][] rellenarMatriz(int f, int c, int ic, int iff, int fc, int ff) {

		campo1 = new String[f][c];

		for (int i = 0; i < campo1.length; i++) {
			for (int j = 0; j < campo1.length; j++) {

				campo1[i][j] = "X";

			}

			campo1[ic][iff] = "L";
			campo1[fc][ff] = "D";

		}

		return campo1;
	}

	/**
	 * This method verifies if a box is free
	 *
	 * @param The last box type liebre
	 * @param The last box type liebre
	 * @return The result if the box is free
	 */
	public boolean casillalibre(Liebre c, Liebre z) {
		if (z != null && !z.isLiebrepasado()) {
			return true;
		}
		return false;
	}

	/**
	 * This method does the respective branch and pruning to solve the exercise
	 *
	 * @param tablero  The board of the hare
	 * @param actual   The actual box selected
	 * @param camino1  The ways taken by the hare
	 * @param p        The quantity of ways p
	 * @param q        The quantity of ways q
	 * @param antes    The position of the last movement
	 * @param direcion The direction where the hare will go
	 */
	public void ramaYpoda(Tablero tablero, Liebre actual, ArrayList<Liebre> camino1, int p, int q, int antes,
			String direcion) {
		if (actual.isTermino()) {
			tablero.mejorCamino((ArrayList<Liebre>) camino1.clone());
		} else {
			if (p != 0 && direcion.equals("q")) {
				p--;
				int[][] descripcion = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
				caminoPosibles(tablero, actual, camino1, p, q, antes, "p", descripcion);
			}
			if (q != 0 && direcion.equals("p")) {
				q--;
				if (antes == 0 || antes == 2) {

					int[][] descripcion = { { 0, 1 }, { 0, -1 } };
					caminoPosibles(tablero, actual, camino1, p, q, antes, "q", descripcion);
				} else {

					int[][] descripcion = { { -1, 0 }, { 1, 0 } };
					caminoPosibles(tablero, actual, camino1, p, q, antes, "q", descripcion);
				}
			}
		}
	}

	/**
	 * This method defines the possible ways that the hare can take
	 *
	 * @param tablero The board of the hare
	 * @param actual  The actual box selected
	 * @param camino  The ways taken by the hare
	 * @param p       The quantity of ways p
	 * @param q       The quantity of ways q
	 * @param antes   The position of the last movement
	 * @param saber   The direction that the program is analyzing
	 * @param salto   The jump that the hare will do
	 */
	public void caminoPosibles(Tablero tablero, Liebre actual, ArrayList<Liebre> camino, int p, int q, int antes,
			String saber, int[][] salto) {
		Liebre z;
		int x;
		int y;
		for (int i = 0; i < salto.length; i++) {
			x = actual.getX() + salto[i][0];
			y = actual.getY() + salto[i][1];
			z = tablero.posicionLiebre(x, y);
			if (casillalibre(actual, z)) {
				camino.add(z);
				actual.setLiebrepasado(true);
				ramaYpoda(tablero, z, camino, p, q, i, saber);
				actual.setLiebrepasado(false);
				camino.remove(z);
			}
		}
	}

	/**
	 * This method moves the hare to the next position
	 *
	 * @param f            the number of rows
	 * @param c            the number of columns
	 * @param libreiniciof the initial position of the hare at the row
	 * @param libreinicioc the initial position of the hare column
	 * @param librefinalf  the final position of the hare at the row
	 * @param librefinalc  the final position of the hare at the column
	 * @param p            The quantity of ways p
	 * @param q            The quantity of ways q
	 * @return An arraylist that saves the movements of the hare
	 */
	public ArrayList<Liebre> siguienteMovimiento(int f, int c, int libreiniciof, int libreinicioc, int librefinalf,
			int librefinalc, int p, int q) {
		Liebre[][] campo = new Liebre[f + 2][c + 2];
		for (int i = 1; i < (campo.length - 1); i++) {
			for (int j = 1; j < (campo.length - 1); j++) {
				campo[i][j] = new Liebre(i, j);
			}
		}
		campo[librefinalf][librefinalc].setTermino(true);
		ArrayList<Liebre> camino = new ArrayList<>();
		int pCamino = p;
		int qCaminos = q;
		int anterior = 0;
		Tablero trayectoria = new Tablero(campo);
		camino.add(campo[libreiniciof][libreinicioc]);
		ramaYpoda(trayectoria, campo[libreiniciof][libreinicioc], camino, pCamino, qCaminos, anterior, "q");
		return trayectoria.getCamino();
	}

	/**
	 * This method sends the final matrix of the route that the hare took, to show it to the user
	 *
	 * @param f            the number of rows of the matrix
	 * @param c            the number of columns of the matrix
	 * @param libreiniciof the initial position of the hare at the row
	 * @param libreinicioc the initial position of the hare column
	 * @param librefinalf  the final position of the hare at the row
	 * @param librefinalc  the final position of the hare at the column
	 * @param p            The quantity of ways at p
	 * @param q            The quantity of ways at q
	 * @return An Array that saves the view of the route of the hare
	 */
	public ArrayList<String[][]> Solucion(int f, int c, int libreiniciof, int libreinicioc, int librefinalf,
			int librefinalc, int p, int q) {
		ArrayList<Liebre> lp = siguienteMovimiento(f, c, libreiniciof, libreinicioc, librefinalf, librefinalc, p, q);
		ArrayList<String[][]> camino = new ArrayList<String[][]>();
		for (int i = 0; i < lp.size(); i++) {
			camino.add(rellenarMatriz(f + 2, c + 2, lp.get(i).getX(), lp.get(i).getY(), librefinalf, librefinalc));

		}
		return camino;
	}

	/**
	 * Gets liebre.
	 *
	 * @return the liebre
	 */
	public Liebre getLiebre() {
		return liebre;
	}

	/**
	 * Sets liebre.
	 *
	 * @param liebre the liebre
	 */
	public void setLiebre(Liebre liebre) {
		this.liebre = liebre;
	}

	/**
	 * Gets tablero.
	 *
	 * @return the tablero
	 */
	public Tablero getTablero() {
		return tablero;
	}

	/**
	 * Sets tablero.
	 *
	 * @param tablero the tablero
	 */
	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}

	/**
	 * Get campo 1 string [ ] [ ].
	 *
	 * @return the string [ ] [ ]
	 */
	public String[][] getCampo1() {
		return campo1;
	}

	/**
	 * Sets campo 1.
	 *
	 * @param campo1 the campo 1
	 */
	public void setCampo1(String[][] campo1) {
		this.campo1 = campo1;
	}

}
