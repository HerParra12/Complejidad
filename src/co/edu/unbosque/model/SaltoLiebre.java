package co.edu.unbosque.model;

import java.util.ArrayList;

/**
 * The type Salto liebre.
 */
public class SaltoLiebre {

	private Liebre liebre;
	private Tablero tablero;
	private String[][] campo1;

	/**
	 * Instantiates a new Salto liebre.
	 */
	public SaltoLiebre() {
	}

	/**
	 * Instantiates a new Salto liebre.
	 *
	 * @param liebre  the liebre
	 * @param tablero the tablero
	 * @param campo1  the campo 1
	 */
	public SaltoLiebre(Liebre liebre, Tablero tablero, String[][] campo1) {
		super();
		this.liebre = liebre;
		this.tablero = tablero;
		this.campo1 = campo1;
	}

	/**
	 * Rellenar matriz string [ ] [ ].
	 *
	 * @param f   the f
	 * @param c   the c
	 * @param ic  the ic
	 * @param iff the iff
	 * @param fc  the fc
	 * @param ff  the ff
	 * @return the string [ ] [ ]
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
	 * Casillalibre boolean.
	 *
	 * @param c the c
	 * @param z the z
	 * @return the boolean
	 */
	public boolean casillalibre(Liebre c, Liebre z) {

		if (z != null && !z.isLiebrepasado()) {
			return true;
		}
		return false;
	}

	/**
	 * Rama ypoda.
	 *
	 * @param tablero  the tablero
	 * @param actual   the actual
	 * @param camino1  the camino 1
	 * @param p        the p
	 * @param q        the q
	 * @param antes    the antes
	 * @param direcion the direcion
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
	 * Camino posibles.
	 *
	 * @param tablero the tablero
	 * @param actual  the actual
	 * @param camino  the camino
	 * @param p       the p
	 * @param q       the q
	 * @param antes   the antes
	 * @param saber   the saber
	 * @param salto   the salto
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
	 * Siguiente movimiento array list.
	 *
	 * @param f            the f
	 * @param c            the c
	 * @param libreiniciof the libreiniciof
	 * @param libreinicioc the libreinicioc
	 * @param librefinalf  the librefinalf
	 * @param librefinalc  the librefinalc
	 * @param p            the p
	 * @param q            the q
	 * @return the array list
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
	 * Solucion array list.
	 *
	 * @param f            the f
	 * @param c            the c
	 * @param libreiniciof the libreiniciof
	 * @param libreinicioc the libreinicioc
	 * @param librefinalf  the librefinalf
	 * @param librefinalc  the librefinalc
	 * @param p            the p
	 * @param q            the q
	 * @return the array list
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
