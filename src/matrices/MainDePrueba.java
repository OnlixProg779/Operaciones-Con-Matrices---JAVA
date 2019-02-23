/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package matrices;
import matrices.MatricesMetodos;
/**
 *
 * @author 2012
 */
public class MainDePrueba {

	/**
	 * @param args
	 *            the command line arguments
	 */

		
		public static void main(String[] args) {
			
			double[][] matriz = { { 25.2,2.12,-1,1,0,0 }, { 3.14,4.16,4,0,1,0 }, { 5,2,6,0,0,1 } };
			double[][] matriz2 = { { 0.6666666,2.3,3.6 }, { 2.6,3.9,3.2 } };
			

			
		String [][] x = fraccion(matriz2);
		    
		 System.out.println(MatricesMetodos.imprimirMatrizString(x));
						
				
		}
		
		static String fraccion(double num) {

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
			
		//	Fraccion resul = new Fraccion(numerador, denominador);
			if (denominador == 1) {
				
				resultado = String.valueOf(numerador);
				return resultado;
			} else {

				resultado = numerador + "/" + denominador;
				return resultado;
			}
		}
		
		static String[][] fraccion(double[][] numero) {
			
			int filasA = numero.length;
			int columnasA = numero[0].length;
			String[][] escrito = new String[filasA][columnasA];

			for (int g = 0; g < numero.length; g++) {
				for (int j = 0; j < numero.length; j++) {
					escrito[g][j] = fraccion(((numero[g][j])));

				}
				System.out.println("");
			}
			return escrito;

		}


	}


