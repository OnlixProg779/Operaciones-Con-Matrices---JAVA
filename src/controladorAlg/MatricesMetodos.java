package controladorAlg;

import java.text.DecimalFormat;

import javax.swing.JTextField;

public class MatricesMetodos {
	/**
	 * ESTE METODO SIRVE PARA PASAR LOS DATOS DE UN JTEXTFIEL BIDIMENCIONAL A UNA
	 * MATRIZ BIDIMENCIONAL DOUBLE
	 * 
	 * @param matriz
	 * @param a
	 * @param b
	 * @return
	 */
	public static double[][] insertarEnMatriz(JTextField[][] matriz, int a, int b) {
		double matrizA[][] = new double[a][b];
		int cont = 0;
		while (cont < matriz.length) {

			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j < matriz[0].length; j++) {

					matrizA[i][j] = Double.parseDouble(matriz[i][j].getText());
					cont++;
				}
			}

		}

		return matrizA;
	}

	/**
	 * ESTE METODO ES PARA PASAR LOS DATOS DE UN VECTOR JTEXTFIELD A UN VECTOR
	 * DOUBLE
	 * 
	 * @param matriz
	 * @param a
	 * @return
	 */

	public static double[] insertarEnMatrizUni(JTextField[] matriz, int a) {
		double matrizA[] = new double[a];
		int cont = 0;
		while (cont < matriz.length) {

			for (int i = 0; i < matriz.length; i++) {

				matrizA[i] = Double.parseDouble(matriz[i].getText());
				cont++;

			}

		}

		return matrizA;
	}

	/**
	 * ESTE METODO ES PARA COMBINAR LA MATRIZ DE INCCOGNITAS Y LA RESULTANTE, ESTO
	 * PARA PODER ITERAR EN ELLAS COMO UNA SOLA.
	 * 
	 * @param matriz
	 * @param matrizB
	 * @return
	 */
	public static double[][] combinarEnMatrices(double[][] matriz, double[] matrizB) {
		int filasA, columnasA;

		filasA = matriz.length;
		columnasA = (matriz[0].length) + 1;
		double matrizA[][] = new double[filasA][columnasA];
		int cont = 0;
		int cont2 = 0;
		while (cont < matriz.length) {

			for (int i = 0; i < matriz.length; i++) {
				// cont2=0;
				for (int j = 0; j < columnasA; j++) {

					if (j < matriz[0].length) {

						matrizA[i][j] = matriz[i][j];
					} else {
						matrizA[i][j] = matrizB[cont2];
						cont2++;
					}
					cont++;
				}
			}

		}

		return matrizA;
	}

	/**
	 * ESTE METODO ES PARA ALMACENAR MATRICES EN UN SOLO STRING, LISTO PARA IMPRIMIR
	 * EN PANTALLA
	 * 
	 * @param matriz
	 * @param matriz2
	 * @param matriz3
	 * @param signo
	 * @return
	 */
	public static String almacenarMatrizEnString3(double[][] matriz, double[][] matriz2, double[][] matriz3,
			char signo) {
		String escrito = "";
		int filas = 0, columnas = 0, filasm1 = 0, filasm2 = 0, filasm3 = 0, columnasm1 = 0, columnasm2 = 0,
				columnasm3 = 0;
		if (matriz != null) {
			filasm1 = matriz.length;
			columnasm1 = matriz[0].length;
		}
		if (matriz2 != null) {
			filasm2 = matriz2.length;
			columnasm2 = matriz2[0].length;
		}
		if (matriz3 != null) {
			filasm3 = matriz3.length;
			columnasm3 = matriz3[0].length;
		}

		int[] numerofilas = { filasm1, filasm2, filasm3 };
		int[] numerocolumnas = { columnasm1, columnasm2, columnasm3 };
		filas = NumeroMayor(numerofilas);
		columnas = NumeroMayor(numerocolumnas);

		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				try {
					escrito = escrito + String.valueOf((matriz[i][j])) + "\t";
				} catch (IndexOutOfBoundsException e) {
					escrito = escrito + "\t";
				}
			}
			if (matriz2 != null) {
				if (i == filas / 2)
					escrito = escrito + signo + " \t";
				else
					escrito = escrito + "\t";

				for (int j = 0; j < columnas; j++) {
					try {
						escrito = escrito + String.valueOf((matriz2[i][j])) + "\t";
					} catch (IndexOutOfBoundsException e) {
						escrito = escrito + "\t";
					}
				}
			}
			if (matriz3 != null) {
				if (i == filas / 2)
					escrito = escrito + " = " + "\t";
				else
					escrito = escrito + "\t";
				for (int j = 0; j < columnas; j++) {
					try {
						escrito = escrito + String.valueOf((matriz3[i][j])) + "\t";
					} catch (IndexOutOfBoundsException e) {
						escrito = escrito + "\t";
					}
				}
			}
			escrito = escrito + ("\n");
		}
		return escrito;
	}

	public static int NumeroMayor(int[] numeros) {
		return OrdenarBurbuja(numeros, false, numeros.length - 1);
	}

	static int OrdenarBurbuja(int[] vector, boolean Ordenado, int n) {
		int aux;
		if (!Ordenado) {
			Ordenado = true;
			for (int i = 0; i < n; i++) {
				if (vector[i] > vector[i + 1]) {
					aux = vector[i];
					vector[i] = vector[i + 1];
					vector[i + 1] = aux;
					Ordenado = false;
				}
			}
			return OrdenarBurbuja(vector, Ordenado, n);
		} else {
			return vector[n];
		}
	}

	/**
	 * @param matriz
	 * @param var
	 * @coment recibe la matriz con los datos ingresados la variable matriz[][]
	 *         "var" es el numero de incognitas que va a encontrar.
	 */
	public static String GaussJordan(double[][] matriz, int var, boolean pase) {
		String escrito = "";
		int piv = 0;
		for (int a = 0; a < var; a++) {

			pivote(matriz, piv, var);

			escrito = escrito + ("\tRenglon " + (a + 1) + " entre el pivote" + "\n");
			escrito = escrito + muestramatriz(matriz, var, pase);

			escrito = escrito + ("\n");

			escrito = escrito + ("\tHaciendo ceros" + "\n");
			hacerceros(matriz, piv, var);

			escrito = escrito + muestramatriz(matriz, var, pase);
			escrito = escrito + ("\n");
			piv++;
		}
		escrito = escrito + "Resultado:" + "\n\n";
		for (int x = 0; x < var; x++) {
			if (pase == true) {
				escrito = escrito + ("La variable X" + (x + 1) + " es: "
						+ aFraccion(Math.round(matriz[x][var] * 100d) / 100d) + "\n");
			} else {
				escrito = escrito
						+ ("La variable X" + (x + 1) + " es: " + Math.round(matriz[x][var] * 100d) / 100d + "\n");
			}

		}
		return escrito;
	}

	static String muestramatriz(double matriz[][], int var, boolean pase) {
		DecimalFormat df = new DecimalFormat("#0.00");
		// Math.round(number * 100d) / 100d)
		String escrito = "";
		for (int x = 0; x < var; x++) {
			for (int y = 0; y < (var + 1); y++) {
				if (y == 0) {
					escrito += ("| ");
				}
				if (pase == true) {
					escrito += (aFraccion(Math.round(matriz[x][y] * 100d) / 100d) + "\t");
				} else {
					escrito += (df.format(matriz[x][y]) + "    ");
				}
				if (y < var && y > var - 2) {
					escrito += (" |");
				}
			}
			escrito += ("\n");
		}
		return escrito;

	}

	static void hacerceros(double matriz[][], int piv, int var) {
		for (int x = 0; x < var; x++) {
			if (x != piv) {
				double c = matriz[x][piv];
				for (int z = 0; z < (var + 1); z++) {
					matriz[x][z] = ((-1 * c) * matriz[piv][z]) + matriz[x][z];
				}
			}
		}
	}

	static void hacercerosMatrizIde(double matriz[][], int piv, int var) {
		for (int x = 0; x < var; x++) {
			if (x != piv) {
				double c = matriz[x][piv];
				for (int z = 0; z < (var + matriz.length); z++) {
					matriz[x][z] = ((-1 * c) * matriz[piv][z]) + matriz[x][z];
				}
			}
		}
	}
	// metodo que calcule la determinante

	public static double Determinante(int i, double[][] matriz, String resul) {
		if (matriz.length == 2) {
			double deter = matriz[0][0] * matriz[1][1] - matriz[0][1] * matriz[1][0];
			return deter;
		} else {
			double deter = 0;
			for (int j = 0; j < matriz.length; j++) {
				double[][] temp = SubMatriz(i, j, matriz);
				double auxDeter = Determinante(0, temp, resul);
				double cofactor = Math.pow(-1, i + j) * matriz[i][j] * auxDeter;
				if (temp.length > 2) {
					System.out.println("Menor(" + (i + 1) + "," + (j + 1) + ")");
					imprimirMatriz(temp);
					System.out.println("Determinante = " + auxDeter);
					System.out.println("Cofactor = " + cofactor);
					System.out.println("");
				}
				deter = deter + cofactor;

			}
			return deter;
		}
	}

	// metodo para calcular la adjunta de una matrzi

	public static double[][] AdjuntaMatriz(double[][] matriz) {
		// double[][] imprimirPasos = null;
		double[][] tempAdjunta = new double[matriz.length][matriz.length];

		for (int i = 0; i < tempAdjunta.length; i++) {
			for (int j = 0; j < tempAdjunta.length; j++) {
				double[][] temp = SubMatriz(i, j, matriz);
				double determ = Determinante(0, temp, "");
				double cofactor = Math.pow(-1, i + j);
				double elementoAdjunto = cofactor * determ;
				tempAdjunta[i][j] = elementoAdjunto;
				// se imprime cada paso
				System.out.println("Menor (" + (i + 1) + "," + (j + 1) + ")");
				imprimirMatriz(temp);
				System.out.println("Determinante = " + determ);
				System.out.println("Cofactor = " + elementoAdjunto + "\n");
			}
		}
		return tempAdjunta;
	}

	public static double[][] TransponerMatrizDou(double[][] matriz)

	{

		double[][] tempTranspuesta = new double[matriz.length][matriz.length];

		for (int i = 0; i < tempTranspuesta.length; i++) {
			for (int j = 0; j < tempTranspuesta.length; j++) {

				tempTranspuesta[i][j] = (matriz[j][i]);

			}

		}

		return tempTranspuesta;

	}

	public static double[][] InversaMatriz(double[][] matriz, boolean pase) {
		double determinate = Determinante(0, matriz, ""); // calculando la determinate
		double[][] MatAdjunta = AdjuntaMatriz(matriz);
		double[][] MatTrans = TransponerMatrizDou(MatAdjunta);
		double[][] MatInversa = new double[matriz.length][matriz.length];

		if (determinate == 0) {
			System.out.println("No existe inversa de la matriz");
		} else {
			for (int i = 0; i < MatTrans.length; i++) {
				for (int j = 0; j < MatTrans.length; j++) {
					MatInversa[i][j] = MatTrans[i][j] / determinate;
				}
			}
		}
		return MatInversa;

	}

	public static String aFraccion(double num) {

		String suma = "";
		String suma2 = "";
		String numero3 = "";
		double numero4 = 0;
		int numero5 = 0;
		double numero6 = 0;
		int numerador = 0;
		int denominador = 0;
		int i = 0;
		String resultado = "";

		String numero = String.valueOf(num);

		int p = 0;
		numero3 = numero.substring(numero.indexOf(".") + 1, numero.length());

		numero4 = Double.valueOf(numero).doubleValue();

		for (int f = 0; f < numero3.length(); f++) {
			suma += "0";
		}
		suma2 = 1 + suma;

		numero5 = Integer.parseInt(suma2);

		numero6 = numero4 * numero5;
		i = (int) numero6;

		while (p <= 3) {
			for (int f = 1; f <= 7; f++) {
				if (i % f == 0 && numero5 % f == 0) {
					i = i / f;
					numero5 = numero5 / f;
					numerador = i;
					denominador = numero5;

				}
			}
			p++;
		}
		if (denominador == 1) {
			resultado = String.valueOf(numerador);
			return resultado;
		} else {

			resultado = numerador + "/" + denominador;
			return resultado;
		}
	}

	static void pivote(double matriz[][], int piv, int var) {
		double temp = 0.0;
		temp = matriz[piv][piv];
		for (int y = 0; y < (var + 1); y++) {

			matriz[piv][y] = matriz[piv][y] / temp;
		}
	}

	/**
	 * CON ESTE METODO SE PUEDE ALMACENAR EN UN SOLO STRNG TODA UNA MATRIZ DE STRING
	 * 
	 * @param matriz
	 * @return
	 */
	public static String imprimirMatrizString(String[][] matriz) {
		String escrito = "";
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				escrito = escrito + (matriz[i][j] + "\t");

			}
			escrito = escrito + "\n";
		}
		return escrito;
	}

	/**
	 * ESTE METODO CREA UNA MATRIZ IDENTIDAD
	 * 
	 * @param matriz
	 * @return
	 */
	public static double[][] formatoIdentidad(double[][] matriz) {
		int filas = matriz.length;
		int columnas = matriz[0].length;
		double[][] resul = new double[filas][columnas * 2];

		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				resul[i][j] = matriz[i][j];
			}
		}
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				if (i == j)
					resul[i][j + columnas] = 1;
				else
					resul[i][j + columnas] = 0;
			}
		}
		return resul;
	}

	/**
	 * 
	 * @param matriz
	 * @return
	 */
	public static Resultado InversaMatrizCofactores(double[][] matriz) {
		String pasos;
		Resultado resultado = new Resultado(null, "", null);
		double determinante = determinante(0, matriz, "", resultado); // calculando la determinate
		resultado.setPasos("");
		if (determinante == 0) {
			resultado.setPasos("El determinante es cero, por lo tanto no es posible encontrar su Inversa \n");
			return resultado;
		} else {
			pasos = "Su determinante es " + determinante + "\n" + "Calculando la Adjunta de la matriz: \n";
			resultado.masPasos(pasos);
			double[][] MatAdjunta = adjuntaMatriz(matriz, resultado);
			pasos = "Luego se transpone su matriz \n";
			resultado.masPasos(pasos);
			double[][] MatTrans = transponerMatriz(MatAdjunta, resultado);
			pasos = "Multiplicamos 1/" + determinante
					+ " por la matriz transpuesta, dando como resultado la matriz Inversa\n";
			resultado.masPasos(pasos);
			double[][] MatInversa = new double[matriz.length][matriz.length];
			for (int i = 0; i < MatTrans.length; i++) {
				for (int j = 0; j < MatTrans.length; j++) {
					MatInversa[i][j] = MatTrans[i][j] / determinante;
				}
			}
			resultado.setResul(MatInversa);
			resultado.masPasos(imprimirMatriz(MatInversa));
			return resultado;
		}
	}

	public static double determinante(int i, double[][] matriz, String resul, Resultado resultado) {
		String pasos = "";
		if (matriz.length == 2) {
			double deter = matriz[0][0] * matriz[1][1] - matriz[0][1] * matriz[1][0];
			return deter;
		} else {
			double deter = 0;
			for (int j = 0; j < matriz.length; j++) {
				double[][] temp = SubMatriz(i, j, matriz);
				double auxDeter = determinante(0, temp, resul, resultado);
				double cofactor = Math.pow(-1, i + j) * matriz[i][j] * auxDeter;
				if (temp.length == matriz.length) {
					pasos = pasos + ("\n Menor(" + (i + 1) + "," + (j + 1) + ")\n");
					pasos = pasos + imprimirMatriz(temp) + "\n";
					pasos = pasos + ("Determinante = " + auxDeter + "\n");
					pasos = pasos + ("Cofactor = " + cofactor + "\n");
					resultado.masPasos(pasos);
				}
				deter = deter + cofactor;
			}
			resultado.setResul(matriz);
			return deter;
		}
	}

	public static double[][] adjuntaMatriz(double[][] matriz, Resultado resultado) {
		// double[][] imprimirPasos = null;
		double[][] tempAdjunta = new double[matriz.length][matriz.length];
		String pasos = "";
		for (int i = 0; i < tempAdjunta.length; i++) {
			for (int j = 0; j < tempAdjunta.length; j++) {
				double[][] temp = SubMatriz(i, j, matriz);
				double determ = determinante(0, temp, "", resultado);
				double cofactor = Math.pow(-1, i + j);
				double elementoAdjunto = cofactor * determ;
				tempAdjunta[i][j] = elementoAdjunto;
				// se imprime cada paso
				pasos = pasos + ("Menor (" + (i + 1) + "," + (j + 1) + ")") + "\n";
				pasos = pasos + imprimirMatriz(temp) + "\n";
				pasos = pasos + ("Determinante = " + determ + "\n");
				pasos = pasos + ("Cofactor = " + elementoAdjunto + "\n");
			}
		}
		pasos = pasos + "La matriz Adjunta es: \n" + imprimirMatriz(tempAdjunta);
		resultado.masPasos(pasos);
		return tempAdjunta;
	}

	public static double[][] transponerMatriz(double[][] matriz, Resultado resultado)

	{
		double[][] tempTranspuesta = new double[matriz.length][matriz.length];

		for (int i = 0; i < tempTranspuesta.length; i++) {
			for (int j = 0; j < tempTranspuesta.length; j++) {
				tempTranspuesta[i][j] = matriz[j][i];
			}
		}
		resultado.masPasos("La matriz Transpuesta es = \n" + imprimirMatriz(tempTranspuesta));
		return tempTranspuesta;

	}

	/**
	 * 
	 * @param matriz
	 *            Recibe la matriz que va a imprimir
	 */
	public static String imprimirMatriz(double[][] matriz) {
		DecimalFormat df = new DecimalFormat("#0.00");
		String pasos = "";
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				pasos = pasos + df.format(matriz[i][j]) + "\t";
			}
			pasos = pasos + "\n";
		}
		return pasos;

	}

	/**
	 * calaculo de submatriz eliminado i, j
	 * 
	 * @param i
	 * @param j
	 * @param matriz
	 * @return
	 */
	private static double[][] SubMatriz(int i, int j, double[][] matriz) {

		double[][] temp = new double[matriz.length - 1][matriz.length - 1];

		int count1 = 0;
		int count2 = 0;

		for (int k = 0; k < matriz.length; k++) {
			if (k != i) {
				count2 = 0;
				for (int l = 0; l < matriz.length; l++) {
					if (l != j) {
						temp[count1][count2] = matriz[k][l];

						count2++;
					}

				}

				count1++;
			}

		}

		return temp;

	}

	static String muestramatrizIde(double matriz[][], int var) {
		DecimalFormat df = new DecimalFormat("#0.00");
		String resul = "\n";
		for (int x = 0; x < var; x++) {
			for (int y = 0; y < (var + matriz.length); y++) {
				if (y == 0) {
					resul += ("| ");
				}
				resul += ("  " + df.format(matriz[x][y]));
				if (y < var && y > var - 2) {
					resul += (" |");
				}

			}
			resul += ("\n");
		}
		return resul;
	}

	public static void inversaPorMatrizIdentidad(double[][] matriz, int var, Resultado resultado) {
		int piv = 0;
		resultado.masPasos("Matriz: \n");
		resultado.masPasos(muestramatrizIde(matriz, var) + "\n");
		resultado.masPasos("\n");
		for (int a = 0; a < var; a++) {
			pivoteIdentidad(matriz, piv, var);

			resultado.masPasos("\tRenglon " + (a + 1) + " entre el pivote\n");
			resultado.masPasos(muestramatrizIde(matriz, var));

			resultado.masPasos("\n");

			resultado.masPasos("\tHaciendo ceros\n");
			hacercerosMatrizIde(matriz, piv, var);
			resultado.masPasos(muestramatrizIde(matriz, var) + "\n");
			resultado.masPasos("\n");
			piv++;
		}
		resultado.masPasos("Matriz:\n");
		resultado.masPasos(muestramatrizIde(matriz, var));
	}

	static void pivoteIdentidad(double matriz[][], int piv, int var) {
		double temp = 0.0;
		temp = matriz[piv][piv];
		for (int y = 0; y < (var + matriz.length); y++) {

			matriz[piv][y] = matriz[piv][y] / temp;
		}
	}

	/**
	 * CONVIERTE UN VECTOR A UNA MATRIZ BIDIMENSIONAL
	 * 
	 * @param vector
	 * @return
	 */
	public static double[][] transformarVectorAarray(double[] vector) {
		double[][] array = new double[vector.length][1];

		for (int i = 0; i < vector.length; i++) {
			array[i][0] = vector[i];
		}

		return array;
	}

	public static String[][] multiplicarDosMatrices(double[][] a, double[][] b, boolean pase) {

		double sum;
		String c[][] = new String[a.length][b[0].length];

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				sum = 0;
				for (int k = 0; k < a[0].length; k++) {
					sum += a[i][k] * b[k][j];
				}
				if (pase == true) {
					c[i][j] = aFraccion((Math.round(sum * 100d) / 100d));
				} else {
					c[i][j] = String.valueOf((Math.round(sum * 100d) / 100d));
				}

			}
		}
		return c;

	}

	public static String almacenarMatrizEnString3(String[][] matriz, char signo) {
		String escrito = "";
		int filas = 0, columnas = 0, filasm1 = 0, filasm2 = 0, filasm3 = 0, columnasm1 = 0, columnasm2 = 0,
				columnasm3 = 0;
		if (matriz != null) {
			filasm1 = matriz.length;
			columnasm1 = matriz[0].length;
		}

		int[] numerofilas = { filasm1, filasm2, filasm3 };
		int[] numerocolumnas = { columnasm1, columnasm2, columnasm3 };
		filas = NumeroMayor(numerofilas);
		columnas = NumeroMayor(numerocolumnas);

		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				try {
					escrito = escrito + String.valueOf((matriz[i][j])) + "\t";
				} catch (IndexOutOfBoundsException e) {
					escrito = escrito + "\t";
				}
			}

			escrito = escrito + ("\n");
		}
		return escrito;
	}

	public static String pasosMultiplicar(double[][] a, double[][] b, boolean pase) {
		int i, j;
		String pasos = "";

		for (i = 0; i < a.length; i++) {

			for (int k = 0; k < b[0].length; k++) {

				for (j = 0; j < b.length; j++) {

					if (j == 0) {
						pasos = pasos + "|    ";
					}
					if (pase == true) {
						pasos = pasos + String
								.valueOf("(" + aFraccion(a[i][j]) + ")" + " x " + "(" + aFraccion(b[j][k]) + ")");
					} else {
						pasos = pasos + String.valueOf("(" + (a[i][j]) + ")" + " x " + "(" + (b[j][k]) + ")");
					}

					if (j != b.length - 1) {
						pasos = pasos + "  +  ";
					}

				}

				pasos = pasos + "\t|                  ";
			}
			pasos = pasos + "\n";
		}
		return pasos;
	}

}
