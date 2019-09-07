package ejecutar;

import java.util.Map;
import java.util.TreeMap;

import controladorAlg.Funcion;
import controladorAlg.RungeKutta;

public class Pruebas {

	public static void main(String[] args) {

		// (y+1)*(x+1)*cos(x^2+2*x) x = 0; y = 4; xn = 2

		final RungeKutta metodo = new RungeKutta();

		double x0 = 2;
		double y0 = 4;
		double xn = 4;

		int n = 4;
		String mostrar = "";
		Funcion funcion = new Funcion("0.1*sqrt(y)+0.4*x^2");
		
		 boolean fraccion = false;
	        int decimales = 8;

	        metodo.fraccion = fraccion;
	        metodo.decimales = decimales;

		mostrar += ("\n");
		mostrar += ("Funcion: [" + funcion.toString() + "]\n");

		mostrar += ("x0: " + x0 + "\n");
		mostrar += ("y0: " + y0 + "\n");
		mostrar += ("xn: " + xn + "\n");
		mostrar += (" n: " + n + "\n");

		mostrar += (metodo.evaluar(funcion, x0, y0, xn, n));

		System.out.println(mostrar);

	}
}
