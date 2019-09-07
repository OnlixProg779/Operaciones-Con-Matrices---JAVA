package controladorAlg;

import java.text.DecimalFormat;

public class Centradas {
	
	
	
	
	 public  String nuevaFuncion(String funcion, int posicion, double total) {
	        int aux = 0;
	        String nuevoAnterior = "", auxNuevoAnterior = "", s, nuevoSiguiente = "", nuevo2;        
	        for (int i = posicion - 1; i >= 0; i--) {
	            s = funcion.charAt(i) + "";
	            if (s.equals("^") || s.equals("*") || s.equals("/") || s.equals("+") || s.equals("-")) {
	                aux = 10;
	            }
	            if (aux == 10) {
	                nuevoAnterior = nuevoAnterior + s;
	            }
	        }        
	        aux = 0;
	        for (int i = nuevoAnterior.length() - 1; i >= 0; i--) {
	            s = nuevoAnterior.charAt(i) + "";
	            auxNuevoAnterior = auxNuevoAnterior + s;
	        }        
	        for (int i = posicion + 1; i < funcion.length(); i++) {
	            s = funcion.charAt(i) + "";
	            if (s.equals("^") || s.equals("*") || s.equals("/") || s.equals("+") || s.equals("-")) {
	                aux = 10;
	            }
	            if (aux == 10) {
	                nuevoSiguiente = nuevoSiguiente + s;
	            }
	        }
	        String tot = total + "", l = tot.charAt(0) + "";
	        int a=0;
	        for (int i = 0; i < funcion.length(); i++) {
	            s = funcion.charAt(i) + "";
	            if (s.equals("^") || s.equals("*") || s.equals("/") || s.equals("+") || s.equals("-")) {
	               a=a+1; 
	            }
	        }
	        try {
	            if (l.equals("-")&& a>1) {
	            auxNuevoAnterior = auxNuevoAnterior.substring(0, auxNuevoAnterior.length() - 1);            
	        }
	        } catch (Exception e) {
	        }
	        
	        nuevo2 = auxNuevoAnterior + total + nuevoSiguiente;
	        return nuevo2;
	    }

	    public  String remplazarX(String funcion, double x) {
	        String q = "", nuevaFuncion = "";
	// remplazamos el valor de x en la funcion
	        for (int i = 0; i < funcion.length(); i++) {
	            q = funcion.charAt(i) + "";
	            if (q.equals("x") || q.equals("X")) {
	                nuevaFuncion = nuevaFuncion + x;
	            } else {
	                nuevaFuncion = nuevaFuncion + q;
	            }
	        }        
	        return nuevaFuncion;
	    }
	     String aux = "";

	    public  double cogerNumeroAnterior(String funcion, int a) {
	        String nuevo = "", s;
	        String nuevo2 = "";
	        for (int i = a - 1; i >= 0; i--) {
	            s = funcion.charAt(i) + "";
	            if (esNumeric(s) || s.equals(".")) {
	                nuevo = nuevo + s;
	            } else {
	                i = -1;
	            }
	        }
	        for (int i = nuevo.length() - 1; i >= 0; i--) {
	            s = nuevo.charAt(i) + "";
	            nuevo2 = nuevo2 + s;
	        }
	        return Double.parseDouble(nuevo2);
	    }

	    public  double cogerNumeroSiguiente(String funcion, int a) {
	        String nuevo = "", s;
	        for (int i = a + 1; i < funcion.length(); i++) {
	            s = funcion.charAt(i) + "";
	            if (esNumeric(s) || s.equals(".")) {
	                nuevo = nuevo + s;
	            } else {
	                i = funcion.length() + 1;
	            }
	        }
	        return Double.parseDouble(nuevo);
	    }

	    public  double resolver_funcion(String funcion) {
	        double total = 0;
	        String nuevaFuncion2 = "", a;
	        aux = funcion;
	        double antes = 0, siguiente = 0;
	        for (int i = 0; i < aux.length(); i++) {
	            a = aux.charAt(i) + "";
	            if (a.equals("^")) {
	                antes = cogerNumeroAnterior(aux, i);
	                siguiente = cogerNumeroSiguiente(aux, i);
	                total = Double.parseDouble(controlarDecimales(potencia(antes, siguiente),13));                
	                aux = nuevaFuncion(aux, i, total);                
	                i = 0;                
	            }                     
	        }

	        for (int i = 0; i < aux.length(); i++) {
	            a = aux.charAt(i) + "";
	            if (a.equals("*")) {
	                antes = cogerNumeroAnterior(aux, i);
	                siguiente = cogerNumeroSiguiente(aux, i);
	                total = Double.parseDouble(controlarDecimales(multiplicacion(antes, siguiente),13));                
	                aux = nuevaFuncion(aux, i, total);                
	                i = 0;
	            }                        
	        }
	        for (int i = 0; i < aux.length(); i++) {
	            a = aux.charAt(i) + "";
	            if (a.equals("/")) {
	                antes = cogerNumeroAnterior(aux, i);
	                siguiente = cogerNumeroSiguiente(aux, i);
	                total = Double.parseDouble(controlarDecimales(division(antes, siguiente),13));                
	                aux = nuevaFuncion(aux, i, total);                
	                i = 0;
	            }                        
	        }
	        for (int i = 0; i < aux.length(); i++) {
	            a = aux.charAt(i) + "";
	            if (a.equals("-")) {
	                antes = cogerNumeroAnterior(aux, i);
	                siguiente = cogerNumeroSiguiente(aux, i);
	                total = Double.parseDouble(controlarDecimales(resta(antes, siguiente),13));                
	                aux = nuevaFuncion(aux, i, total);                
	                i = 0;
	            }                        
	        }
	        for (int i = 0; i < aux.length(); i++) {
	            a = aux.charAt(i) + "";
	            if (a.equals("+")) {
	                antes = cogerNumeroAnterior(aux, i);
	                siguiente = cogerNumeroSiguiente(aux, i);
	                total = Double.parseDouble(controlarDecimales(suma(antes, siguiente),5));                
	                aux = nuevaFuncion(aux, i, total);                
	                i = 0;
	            }                        
	        }
	        return total;
	    }

	    public  double suma(double a, double b) {
	        return a + b;
	    }

	    public  double resta(double a, double b) {
	        return a - b;
	    }

	    public  double multiplicacion(double a, double b) {
	        return a * b;
	    }

	    public  double division(double a, double b) {
	        return a / b;
	    }

	    public  double potencia(double a, double b) {
	        return Math.pow(a, b);
	    }

	    public  String mostar(String funcion, double x, double h) {
	        
	        String mostrar = "";
	        mostrar += "\n ********************* FUNCIÓN ********************* \n";
	        mostrar+= funcion;
	        mostrar += "\n\n *****************************************************\n\n ";
	        mostrar += "\n Usando el proceso de dos puntos:: ";
	        mostrar += "\n DE 2 PUNTOS: ";        
	        
	        mostrar += "\n\nf'(xn)= (1/2h)*(-3f(x)+4f(x+h)-f(x+2h))\n";
	        mostrar += "\n R(1): " + formulasCentradas1(funcion, h, x);   
	        
	        
	        mostrar += "\n\nf'(xn)=(1/h^2)*(f(x-h)-2f(x)+f(x+h))\n";
	        mostrar += "\n R(2): " + formulasCentradas2(funcion, h, x);
	        
	        
	        mostrar += "\n\nf'(xn)=(1/8h^3)*(-f(x-2h)+2f(x-h)-2f(x+h)+f(x+2h))\n";
	        mostrar += "\n R(3): " + formulasCentradas3(funcion, h, x);
	       
	        
	        
	        mostrar += "\n\n *****************************************************\n\n ";
	        mostrar += "\n Usando el proceso de tres puntos: ";
	       
	        
	        
	        mostrar += "\n\nf'(xn)=(1/12h)*(f(x-2h)-8f(x-h)+8f(x+h)-f(x+2h)\n";	
	        mostrar += "\n R(1): = " + formulasCentradas1_2(funcion, h, x);
	       
	        mostrar += "\n\nf'(xn)=(1/12h^2)*(-f(x-2h)+16f(x-h)-30f(x)+16f(x+h)-f(x+2h)\n";
	        
	        mostrar += "\n R(2): " + formulasCentradas2_2(funcion, h, x);
	        
	        mostrar += "\n\nf'(xn)=(1/8h^3)*(f(x-3h)-8f(x-2h)+13f(x-h)-13f(x+h)+8f(x+2h)-f(x+3h)\n";
	        mostrar += "\n R(3): " + formulasCentradas3_2(funcion, h, x);
	        return mostrar;
	    }

	    // COMPROBACION DE NUMERICO 
	    public  boolean esNumeric(String sms) {
	        boolean verificar = false;

	        try {
	            Double.parseDouble(sms);
	            verificar = true;
	        } catch (Exception e) {
	        }
	        return verificar;
	    }

	    // REMPLAZO EN UNA FUNCION LA VARIABLE X
	    public  double resultadoFuncion(double[][] funcion, double x) {
	        double resultado = 0;

	        for (int a = 0; a < funcion.length; a++) {
	            resultado = resultado + (funcion[a][0] * Math.pow(x, funcion[a][1]));
	        }
	        return resultado;
	    }
	public  double resolver_funcion(String funcion, double x) {
	    return resolver_funcion(remplazarX(funcion, x));
	}
	    // FORMULAS CENTRALES CON 2 PUNTOS
	    public  double formulasCentradas1(String funcion, double h, double x) {
	        double resultado = 0;        
	        resultado = ( resolver_funcion(funcion, (x+h))- resolver_funcion(funcion, (x-h)) / (2 * h));        
	        return resultado;
	    }

	    public  double formulasCentradas2(String funcion, double h, double x) {
	        double resultado = 0;
	        resultado = (resolver_funcion(funcion, (x - h)) - 2 * resolver_funcion(funcion, x)
	                + resolver_funcion(funcion, x + h)) / (Math.pow(h, 2));
	        return resultado;
	    }

	    public  double formulasCentradas3(String funcion, double h, double x) {
	        double resultado = 0;
	        resultado = (-resolver_funcion(funcion, (x - (2 * h))) + 2 * resolver_funcion(funcion,
	                (x - h)) - 2 * resolver_funcion(funcion, x + h) + resolver_funcion(funcion,
	                (x + (2 * h)))) / (8 * Math.pow(h, 3));
	        return resultado;
	    }

	    // FORMULAS CENTRALES CON 3 PUNTOS
	    public  double formulasCentradas1_2(String funcion, double h, double x) {
	        double resultado = 0;
	        resultado = ((resolver_funcion(funcion, x - (2 * h)) - 8 * resolver_funcion(funcion, x - h)
	                + 8 * resolver_funcion(funcion, x + h) - resolver_funcion(funcion, x + (2 * h))) / (12 * h));
	        return resultado;
	    }

	    public  double formulasCentradas2_2(String funcion, double h, double x) {
	        double resultado = 0;
	        resultado = ((-resolver_funcion(funcion, x - (2 * h)) + 16 * resolver_funcion(funcion, x - h)
	                - 30 * resolver_funcion(funcion, x) + 16 * resolver_funcion(funcion, x + h)
	                - resolver_funcion(funcion, x + (2 * h))) / (12 * Math.pow(h, 2)));
	        return resultado;
	    }

	    public  double formulasCentradas3_2(String funcion, double h, double x) {
	        double resultado = 0;
	        resultado = ((resolver_funcion(funcion, x - (3 * h)) - 8 * resolver_funcion(funcion, x - (2 * h))
	                + 13 * resolver_funcion(funcion, x - h) - 13 * resolver_funcion(funcion, x + h)
	                + 8 * resolver_funcion(funcion, x + (2 * h)) - resolver_funcion(funcion, x + (3 * h))) / (8 * Math.pow(h, 3)));
	        return resultado;
	    }
	    private  String controlarDecimales(double numDecimal, int cantidad) {
	        String m="#.";
	        for(int i=0;i<cantidad;i++){
	            m=m+"0";
	        }
	        DecimalFormat df = new DecimalFormat(m);        
	        String deci = df.format(numDecimal);
	        String str = String.valueOf(numDecimal);
	        String[] vector = deci.split(",");
	        String decimales;
	        try {
	            decimales = str.substring(str.indexOf('.') + 1);
	        } catch (Exception e) {
	            decimales = str.substring(str.indexOf(',') + 1);
	        }
	        if (decimales.length() > cantidad) {
	            if (vector[0].equals("")) {
	                str = "0" + df.format(numDecimal);
	                try {
	                    vector = str.split(",");
	                    numDecimal = Double.parseDouble(vector[0] + "." + vector[1]);
	                } catch (Exception e) {
	                    return numDecimal + "";
	                }
	                return numDecimal + "";
	            }
	            if (esNumeric(vector[0]) == false) {
	                if (Double.parseDouble(numDecimal + "") < 0) {
	                    str = "-0" + df.format((-1 * numDecimal));
	                    try {
	                        vector = str.split(",");
	                        numDecimal = Double.parseDouble(vector[0] + "." + vector[1]);
	                    } catch (Exception e) {
	                        return numDecimal + "";
	                    }
	                    return numDecimal + "";
	                } else {
	                    str = "0" + df.format((numDecimal));
	                    try {
	                        vector = str.split(",");
	                        numDecimal = Double.parseDouble(vector[0] + "." + vector[1]);
	                    } catch (Exception e) {
	                        return numDecimal + "";
	                    }
	                    return numDecimal + "";
	                }
	            } else {
	                if (decimales.length() > cantidad) {
	                    str = df.format(numDecimal);
	                    try {
	                        vector = str.split(",");
	                        numDecimal = Double.parseDouble(vector[0] + "." + vector[1]);
	                    } catch (Exception e) {
	                        return numDecimal + "";
	                    }
	                    return numDecimal + "";
	                }
	                return numDecimal + "";
	            }
	        }
	        return numDecimal + "";
	    }
}
