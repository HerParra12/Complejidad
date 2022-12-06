package co.edu.unbosque.model;
/**
 * Esta clase es la que muestra soluciona el problema del solitatrio chino
 * @author Kevin Pinzon
 * @author Hernan Alvarado
 * @author Jorge Yate
 * @author Johan Ayala
 */
public class SolitarioChino {
	/**
	 * Variable es los movimeinto maximos de la solucion
	 */
	private int m =37;
	/**
	 * Variable es el tama�o de la matirz
	 */
	private int n=7;
	/**
	 * Instantiates a new Solitario chino.
	 */
	public SolitarioChino() {}
	/**
	 * Solucion.
	 *
	 * @param tablero the tablero
	 */
	public void solucion(String[][] tablero) {
		
	}
	/**
	 * Crear tablero una matriz de String la cual es la que nos crea el tablero
	 * ocidental
	 *
	 * @return Retorna el tablero de juego y con las fichas como oupado 
	 */
	public String[][] crearTablero() {
		String[][] tablero = new String[7][7];
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {

				tablero[i][j] = "ocupado";
			}
		}
		for (int k = 0; k < 2; k++) {
			tablero[0][k] = "   ";
			tablero[1][k] = "   ";
			tablero[5][k] = "   ";
			tablero[6][k] = "   ";
		}
		for (int p = 5; p < tablero.length; p++) {
			tablero[0][p] = "   ";
			tablero[1][p] = "   ";
			tablero[5][p] = "   ";
			tablero[6][p] = "   ";
		}
		return tablero;
	}

	/**Este metodo pone la el campo libre el dual se va comenzar el juego
	 * 
	 *
	 * @param fila    the fila
	 * @param columna the columna
	 * @return Nos devuelve la matriz per ocon el capo escogido como libre
	 */
	public String[][] posicionarFicha(int fila, int columna) {
		String[][] tablero = new String[7][7];
		tablero = crearTablero();
		tablero[fila][columna] = "libre";
		return tablero;
	}

	/**
	 * Este metodo nos imprime el tablero inicial 
	 *
	 * @param tablero the recive un string[][] el cual es el tablero inicial
	 */
	public void imprimirTablero(String[][] tablero) {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {

				System.out.print(tablero[i][j] + " | ");
			}
			System.out.println();
		}
	}
	/**Este metodo pone  el campo como la solucion que se quiere llegar 
	 * 
	 *
	 * @param fila    the fila en la que se termina la ficha
	 * @param columna the columna en la que se termina la columna
	 * @return Nos devuelve la matriz pero con el campo solucion al que se busca llegar
	 */
	public String[][] posicionarFicha2(int fila, int columna) {
		String[][] tablero = new String[7][7];
		tablero = crearTablero2();


		tablero[fila][columna] = "ocupado";
		return tablero;
	}
	/**
	 * Crear tablero 2 el cual es el tablero solucion el cual se quiere llegar
	 *
	 * @return the string [ ][] el cual es el tablero al que se busca llegar
	 */
	public String[][] crearTablero2() {
		String[][] tablero = new String[7][7];
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {

				tablero[i][j] = "libre";
			}
		}

		for (int k = 0; k < 2; k++) {
			tablero[0][k] = "   ";
			tablero[1][k] = "   ";
			tablero[5][k] = "   ";
			tablero[6][k] = "   ";
		}

		for (int p = 5; p < tablero.length; p++) {
			tablero[0][p] = "   ";
			tablero[1][p] = "   ";
			tablero[5][p] = "   ";
			tablero[6][p] = "   ";
		}
		return tablero;
	}
	/**
	 * Este metodo imprime el campo solucion.
	 *
	 * @param tablero recive un String [][] el cual va ser el tablero ya solucionado
	 */
	public void imprimirTablero2(String[][] tablero) {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {

				System.out.print(tablero[i][j] + " | ");
			}
			System.out.println();
		}

	}
	/**
	 * Este metodo es el que se encarga del backtracking y busca la solucion al llegar
	 *
	 * @param k          the  es la posicion que se comienza en x
	 * @param y          the es la posicion que se comienza en y
	 * @param t          the es el tablero del cual se va inicar el metodo
	 * @param encontrado the es el metodo que nos dice si la ficha esta o no 
	 * @param sol        the solucion a la cual que queremos llegar
	 * @return the solucion la cual es el metodo que nos devuelve los caminos que este tomo.
	 */
	public Solucion continental (int k,int y,String[][]t,boolean encontrado,Solucion sol ) {
		int i;
		int j;
		t=posicionarFicha(k, y);
		if (fin(k,y,t)){
			encontrado=true;
		}
		else {
			for ( i = 1; i < n; i++) {
				for ( j = 1; j < n; j++) {
                    if (valido(i,j,1,t,encontrado)) {
                    	
                    	sol.getS()[k].getOrigen().setX(i);
                    	sol.getS()[k].getOrigen().setY(j);
                    	sol.getS()[k].getDestine().setX(i);
                    	sol.getS()[k].getDestine().setY(j-2);
                    	sol.getS()[k].getComida().setX(i);
                      	sol.getS()[k].getComida().setY(j-1);
                      return	continental(k, y,t, encontrado, sol);
                    }
                    
                     if (valido(i,j,2,t,encontrado)) {
                    	
                    	sol.getS()[k].getOrigen().setX(i);
                    	sol.getS()[k].getOrigen().setY(j);
                    	sol.getS()[k].getDestine().setX(i-2);
                    	sol.getS()[k].getDestine().setX(j);
                    	sol.getS()[k].getComida().setX(i-1);
                      	sol.getS()[k].getComida().setX(j);
                  
                     return 	continental(k,y, t, encontrado, sol);
                    }
                     
                     if (valido(i,j,3,t,encontrado)) {
                     	
                     	sol.getS()[k].getOrigen().setX(i);
                     	sol.getS()[k].getOrigen().setY(j);
                     	sol.getS()[k].getDestine().setX(i);
                     	sol.getS()[k].getDestine().setX(j+2);
                     	sol.getS()[k].getComida().setX(i);
                       	sol.getS()[k].getComida().setX(j+1);
                       
                      return 	continental(k,y, t, encontrado, sol);
                     }
                     
                     if (valido(i,j,4,t,encontrado)) {
                     	
                     	sol.getS()[k].getOrigen().setX(i);
                     	sol.getS()[k].getOrigen().setY(j);
                     	sol.getS()[k].getDestine().setX(i+2);
                     	sol.getS()[k].getDestine().setX(j);
                     	sol.getS()[k].getComida().setX(i+1);
                       	sol.getS()[k].getComida().setX(j);
                    
                       	return continental(k,y, t, encontrado, sol);
                     }
					
				}
				}
		
		}
		return sol;
		
		
	}
	
	/**
	 * Este metodo es el que se encarga del backtracking y busca la solucion al llegar
	 *
	 * @param i         the  es la posicion que se esta queirendo eliminar en x
	 * @param j          the es la posicion que se esta queirendo eliminar en y
	 * @param mov          the es el movieminto que se quiere hacer con la ficha
	 * @param t           the es el tablero si saber si la ficha cumple con la condiciones
	 * @param encontrado        the es para saber si se encontro la ficha en el tablero
	 * @return the boolean un boolean que nos permite saber si el movieminto es valido o no .
	 */


	private boolean valido(int i, int j, int mov, String[][] t, boolean encontrado) {
		if (mov==1) {
			
			return (j-1>0)&&(t[i][j].equals("ocupado")&&t[i][j-1].equals("ocupado")
					&&(j-2>0)&&(t[i][j-2].equals("libre"))&& !encontrado);
		}	else if (mov==2) {
			
			return (i-1>0)&&(t[i-2][j].equals("ocupado")&&t[i][j-1].equals("ocupado")
					&&(i-2>0)&&(t[i-2][j].equals("libre"))&& !encontrado);
		}
		
        else if (mov==3) {
			
			return (j+1<8)&&(t[i][j+1].equals("ocupado")&&t[i][j].equals("ocupado")
					&&(j+2<8)&&(t[i][j+2].equals("libre"))&& !encontrado);
		}
		
      else if (mov==4) {
			
			return (i+1<8)&&(t[i+1][j].equals("ocupado")&&t[i][j].equals("ocupado")
					&&(i+2<8)&&(t[i+2][j].equals("libre"))&& !encontrado);
		}
		
		return false;
		
	
	}

	/**
	 * Fin boolean.
	 *
	 * @param k          the  es la posicion que se inical  en x
	 * @param y          the es la posicion que se inical en y
	 * @param tablero    the es el tablero del cual se va inicar el metodo
	 * @return the boolean este metodo nos permite saber si solo hay una ficha
	 * y que este eb donde comenzo
	 */
	public boolean fin(int k ,int y, String[][] tablero) {
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(!tablero[i][j].equals("libre")) {
					return false;
					
				}else {
					if (!tablero[k][y].equals("ocupada")) {
						return false ;
					}
				}
				
			}
		}
		return true;
	}
}