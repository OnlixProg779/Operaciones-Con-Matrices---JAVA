package controladorAlg;
//(y+1)*(x+1)*cos(x^2+2*x)

import metodos.Base;

import java.util.TreeMap;

public class RungeKutta extends Base {

	public RungeKutta() {
		this.espaciado = 0;
		this.decimales = 5;
	}

	public TreeMap<String, Double> orden4(Funcion funcion, double x0, double y0, double h, int i) {
		TreeMap<String, Double> coleccion = new TreeMap<String, Double>();
		String enviar = "";
		Double enviarResultado = 0.00;
		double F1 = funcion.evaluar(x0, y0);
		double F2 = funcion.evaluar(x0 + 0.5 * h, y0 + 0.5 * h * F1);
		double F3 = funcion.evaluar(x0 + 0.5 * h, y0 + 0.5 * h * F2);
		double F4 = funcion.evaluar(x0 + h, y0 + h * F3);

		enviar = enviar + ("f(" + x0 + " , " + y0 + "):" + funcion.toString() + "\n");
		enviar = enviar + ("k1= ");
		enviar = enviar + (+F1 + "\n");
		enviar = enviar + ("\n");

		enviar = enviar + ("x,y = (" + x0 + "+ 0.5 *" + h + " , " + y0 + "+ 0.5 *" + h + "* k1" + ")\n");
		enviar = enviar + ("x,y = (" + x0 + "+ 0.5 *" + h + " , " + y0 + "+ 0.5 *" + h + "*" + F1 + ")\n");
		enviar = enviar + ("f(" + (x0 + 0.5 * h) + " , " + (y0 + 0.5 * h * F1) + "):" + funcion.toString() + "\n");
		enviar = enviar + ("k2= ");
		enviar = enviar + (+F2 + "\n");
		enviar = enviar + ("\n");

		enviar = enviar + ("x,y = (" + x0 + "+ 0.5 *" + h + " , " + y0 + "+ 0.5 *" + h + "* k2" + ")\n");
		enviar = enviar + ("x,y = (" + x0 + "+ 0.5 *" + h + " , " + y0 + "+ 0.5 *" + h + "*" + F2 + ")\n");
		enviar = enviar + ("f(" + (x0 + 0.5 * h) + " , " + (y0 + 0.5 * h * F2) + "):" + funcion.toString() + "\n");
		enviar = enviar + ("k3= ");
		enviar = enviar + (+F3) + "\n";
		enviar = enviar + ("\n");

		enviar = enviar + ("x,y = (" + x0 + "+" + h + " , " + y0 + "+" + h + "* k3" + ")\n");
		enviar = enviar + ("x,y = (" + x0 + "+" + h + " , " + y0 + "+" + h + "*" + F3 + ")\n");
		enviar = enviar + ("f(" + (x0 + h) + " , " + (y0 + h * F3) + "):" + funcion.toString() + "\n");
		enviar = enviar + ("k4= ");
		enviar = enviar + (+F4 + "\n");
		enviar = enviar + ("\n");

		enviar = enviar + ("y" + (i + 1) + " = " + this.redondear(y0) + " + (" + this.redondear(h) + " * ("
				+ this.redondear(F1) + " + 2 * (" + this.redondear(F2) + " + " + this.redondear(F3) + ") + "
				+ this.redondear(F4) + ")) / 6 = " + this.redondear(y0 + (h * (F1 + 2 * (F2 + F3) + F4)) / 6) + "\n");

		enviarResultado = y0 + (h * (F1 + 2 * (F2 + F3) + F4)) / 6.0;

		coleccion.put(enviar, enviarResultado);
		return coleccion;
	}

	public String evaluar(Funcion funcion, double x0, double y0, double xn, int n) {

		TreeMap<String, Double> coleccion = null;

		String enviar = "";

		double[] Y = new double[n + 1];
		double[] X = new double[n + 1];

		this.inicializar(X, x0);
		double h = (xn - x0) / n;
		Y[0] = y0;
		X[0] = x0;
		for (int i = 0; i < n; i++) {
			enviar = enviar + ("\n\nIteración=" + (i + 1) + "\n");

			coleccion = this.orden4(funcion, x0, y0, h, i);

			y0 = coleccion.lastEntry().getValue();

			enviar += coleccion.lastKey();

			x0 += h;
			X[i + 1] = x0;
			Y[i + 1] = y0;
		}

		enviar = enviar + ("\n");
		enviar = enviar + ("Resultado:\n");
		enviar = enviar + this.reportarcoordenadas(X, Y);

		return enviar;
	}

}
