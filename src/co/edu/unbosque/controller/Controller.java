package co.edu.unbosque.controller;
/**
 * The import that allows us to use the arraylists 
 */
import java.util.ArrayList;

import co.edu.unbosque.model.Liebre;
import co.edu.unbosque.model.Model;
import co.edu.unbosque.model.SaltoLiebre;
import co.edu.unbosque.model.SolitarioChino;
import co.edu.unbosque.view.View;

/**
 * The class that joins the model with the view. Besides, it validates the inputs
 * 
 * @author Kevin Pinzon
 * @author Hernan Alvarado
 * @author Jorge Yate
 * @author Johan Ayala
 */
public class Controller {
	/**
	 * Variable of the class View
	 */
	private View vista;
	/**
	 * Variable of the class Model
	 */
	private Model modelo;
	/**
	 * The constructor of the class. Instantiates the Controlled and its attributes
	 */
	public Controller() {
		vista = new View();
		modelo = new Model();
		funcionar();
	}

	/**
	 * The method where the model and the view are joined, it shows the step by step of the software
	 */
	public void funcionar() {

		while (vista.getSelect() != 0) {
			int numeroMenu = vista.leerDatoMenu();
			vista.setSelect(numeroMenu);

			switch (vista.getSelect()) {
			case 1:

				String repetir;
				do {
					repetir = vista.leerDatoString("Ingresa la cantidad de platos");
				} while (!repetir.matches("^[0-9]+$"));
				int size = Integer.parseInt(repetir);
				int numeros[] = new int[size];
				for (int i = 0; i < size; i++) 
					numeros[i] = Math.abs(vista.leerDato("Ingresa la cantidad de calorias del plato " + (i + 1)));
				int caloriasMinimas;
				do {
					caloriasMinimas = Math.abs(vista.leerDato("Ingresa la cantidad de calorias minimas"));
				}while(caloriasMinimas < 1);
				vista.mostrarmensaje(modelo.getNutricionista().optimoMenu(numeros, caloriasMinimas));
				break;
				
			case 2:
				vista.mostrarmensaje("Tablero Inicial\n" + modelo.leerMatriz(modelo.getSolitario().crearTablero()));
				modelo.getSolitario().crearTablero();
				int filaSolitario = vista.leerDato("Seleccione la fila donde desea colocar el espacio vacio");
				int columnaSolitario = vista.leerDato("Seleccione la columna donde desea el espacio vacio");

				if (filaSolitario < 0 || columnaSolitario < 0 || filaSolitario > 6 || columnaSolitario > 6) {

					vista.mostrarmensaje("El espacio vacio debe encontrarse en las dimensiones del tablero");

				} else {

					if ((filaSolitario == 0 || filaSolitario == 1 || filaSolitario == 5 || filaSolitario == 6)
							&& (columnaSolitario == 0 || columnaSolitario == 1 || columnaSolitario == 5
									|| columnaSolitario == 6)) {
						vista.mostrarmensaje("No puede ingresar un espacio en blanco en dicha casilla\n"
								+ "Tenga en cuenta las caracteristicas del tablero");

					} else {
						vista.mostrarmensaje(modelo
								.leerMatriz(modelo.getSolitario().posicionarFicha(filaSolitario, columnaSolitario)));
						vista.mostrarmensaje(modelo
								.leerMatriz(modelo.getSolitario().posicionarFicha2(filaSolitario, columnaSolitario)));

					}
				}
				break;
			case 3:
				int fila = vista.leerDato("Digite el número de las filas");
				int columna = vista.leerDato("Digite el número de las columnas");
				int x = vista.leerDato("Digite el X inicial");
				int y = vista.leerDato(" Digite el Y inicial");
				int xfinal = vista.leerDato("Digite el X final");
				int yfinal = vista.leerDato("Digite el y final");
				int caminop = vista.leerDato("Digite el p");
				int caminoq = vista.leerDato("Digite el q");

				if (xfinal > fila || yfinal > columna || x > fila || y > fila) {
					vista.mostrarmensaje(
							"Ni el origne ni el destino pueden tener valores mayores a la dimensión del tablero");
				} else {
					if (fila < 0 || columna < 0 || x < 0 || y < 0 || xfinal < 0 || yfinal < 0 || caminop < 0
							|| caminoq < 0) {

						vista.mostrarmensaje("Debe ingresar un número valido para cada uno de los campos");
					} else {

						ArrayList<String[][]> siguienteMovimiento = modelo.getSaltoLiebre().Solucion(fila, columna, y,
								x, xfinal, yfinal, caminop, caminoq);

						if (!siguienteMovimiento.isEmpty()) {
							vista.mostrarmensaje("El total de caminos mas corto fue " + (siguienteMovimiento.size()-1));
						for (int i = 0; i < siguienteMovimiento.size(); i++) {

							vista.mostrarmensaje("Movimiento Salto Liebre " + (i) + "\n"
									+ modelo.leerMatrizLiebre(siguienteMovimiento.get(i)));

						}}else {
							vista.mostrarmensaje("No es posible llegar el destino");
						}
					}
				}
				vista.mostrarmensaje("Se termino");

				break;

			case 0:

				break;
			default:

				break;
			}
		}

	}

}
