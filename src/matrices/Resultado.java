package matrices;

public class Resultado {
double[][] resul;
String [][] resulfraccion;
String pasos;

public Resultado(double[][] resul, String pasos, String[][] enfraccion) {
	this.resul = resul;
	this.pasos = pasos;
	this.resulfraccion=enfraccion;
}

public void masPasos(String pasos) {
	this.pasos=this.pasos+pasos;
}

public double[][] getResul() {
	return resul;
}

public void setResul(double[][] resul) {
	this.resul = resul;
}

public String getPasos() {
	return pasos;
}

public void setPasos(String pasos) {
	this.pasos = pasos;
}

public String[][] getResulFraccion() {
	return resulfraccion;
}

public void setResulFraccion(String[][] resul) {
	this.resulfraccion = resul;
}

public String ResultadoFracion(Resultado matriz) {
	String resul[][] = new String[matriz.resul.length][matriz.resul[0].length];
	for (int i=0; i<matriz.resul.length; i++) {
		for (int j=0; i<matriz.resul[0].length; i++) {
		resul[i][j] = (MatricesMetodos.aFraccion(Math.round(matriz.resul[i][j]*100d)/100d));
		}
	}
	return MatricesMetodos.imprimirMatrizString(resul);
}

public String[][] ResultadoFracionM(Resultado matriz) {
	String resul[][] = new String[matriz.resul.length][matriz.resul[0].length];
	for (int i=0; i<matriz.resul.length; i++) {
		for (int j=0; j<matriz.resul[0].length; j++) {
		resul[i][j] = (MatricesMetodos.aFraccion(Math.round(matriz.resul[i][j]*100d)/100d));
		}
	}
	return resul;
}




}
