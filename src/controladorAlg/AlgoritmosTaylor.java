package controladorAlg;

import java.util.Scanner;

import org.lsmp.djep.djep.DJep;
import org.nfunk.jep.Node;

public class AlgoritmosTaylor {

public static String taylor(String funcion, int termino, int a){
		
		String men2="";
		String men3="";
		String respuesta = "";
		int contador = 0;
	    String derivada = "";
	    
	    String[] arreglo= new String[termino];
	    respuesta = "DATOS\n\tFunción: "+funcion+"\n";
	    respuesta = respuesta + "\tN° Derivadas: "+ termino+"\n";
	    respuesta = respuesta + "\tValor de 'a': "+ a+"\n\n DERIVADAS \n";
	    while (contador < termino) {
	        
	        if (contador == 0) {
	            derivada = funcion;
	            derivada = Derivar(derivada);
	            arreglo[contador] = derivada;
	            respuesta = respuesta + ("\t"+(contador+1)+"° Derivada "+ ": \t" +derivada);
	            
	           // System.out.println(""+arreglo[contador]);
	        } else {
	            derivada = Derivar(derivada);
	            arreglo[contador] = derivada;

	            respuesta = respuesta + ("\n\t"+(contador+1)+"° Derivada:\t " +derivada);
	        }
	        contador++;
	    }	
	    
	    respuesta = respuesta + "\n\n TERMINOS:";
		
			for(int i=0; i < termino; i++){
				
				men2= men2 + " + [("+ Imprimir(arreglo,i) +")/"+ (i+1) + "!]" +"*(x-"+ a+ ")^" + (i+1);
				if(i==0) {
				respuesta = respuesta + "\n\t"+(i+1)+": " +funcion;
				}
				respuesta = respuesta + "\n\t"+(i+1)+": " + "[("+ Imprimir(arreglo,i) +")/"+ (i+1) + "!]" +"*(x-"+ a+ ")^" + (i+1);
				
			//	men3= men3 + " 	
			}
			
			//respuesta= respuesta + "\n" + funcion + men2 + "\n" +detectorDeTerminos(funcion, a) +men3;
		
			

		    respuesta = respuesta + "\n\n REEMPLAZAMOS:";
			
				for(int i=0; i < termino; i++){
					
					men3= men3 + " + [("+ detectorDeTerminos(Imprimir(arreglo,i),a) +")/"+ (i+1) + "!]" +"*(x-"+ a+ ")^" + (i+1);
					if(i==0) {
					respuesta = respuesta + "\n\t"+(i+1)+": " +detectorDeTerminos(funcion, a);
					}
					respuesta = respuesta + "\n\t"+(i+1)+": " + "[("+ detectorDeTerminos(Imprimir(arreglo,i),a) +")/"+ (i+1) + "!]" +"*(x-"+ a+ ")^" + (i+1);
					
				//		
				}
				
				//respuesta= respuesta + "\n" + funcion + men2 + "\n" +detectorDeTerminos(funcion, a) +men3;
			
				respuesta = respuesta + "\n\n FINALMENTE CREAMOS LA SERIE:\n";
				respuesta = respuesta + detectorDeTerminos(funcion, a)+ men3;
			
			return respuesta;
		
	}
	
    
public static String Imprimir(String[] derivadas,int numero){
    for(int i=0;i<derivadas.length;i++)
    {
        if(i==numero) {
        	return " "+derivadas[i];
        }
        }
    return "";
}

public static String detectorDeTerminos(String funcion, double valorDeX) {
    String cadenaDeFuncion, funcionSeparada = "";

    int numeroDeCaracteres = funcion.length();
    for (int i = 0; i < numeroDeCaracteres; i++) {
        
    	cadenaDeFuncion = funcion.substring(i, i+1);
        
        if (cadenaDeFuncion.equals("x")) {
        	
            funcionSeparada = funcionSeparada + valorDeX;
            
        } else {
        	
            funcionSeparada = funcionSeparada + cadenaDeFuncion;
        
        }
    }
    return funcionSeparada;
}

public static String Derivar(String funcion) {
    String derivada = "";
    funcion = funcion.replace("raíz", "sqrt");
    DJep derivar = new DJep();
    derivar.addStandardFunctions();
    derivar.addStandardConstants();
    derivar.addComplex();
    derivar.setAllowUndeclared(true);
    derivar.setAllowAssignment(true);
    derivar.setImplicitMul(true); //permite 2x en vez de 2*x
    derivar.addStandardDiffRules();

    try {
        Node node = derivar.parse(funcion);
        Node diff = derivar.differentiate(node, "x");
        Node sim = derivar.simplify(diff);
        derivada = derivar.toString(sim);
    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
    }
    //System.out.println(simplificarX(derivada));
    return simplificarX(derivada);
}

private static String simplificarX(String result) {
	result = result.replace("+-", "-");
	result = result.replace(".0", "");
	
    result = result.replace("x*x*x*x*x", "(x^5)");
    result = result.replace("x*x*x*x", "(x^4)");
    result = result.replace("x*x*x", "(x^3)");
    result = result.replace("x*x", "(x^2)");
    
    result = result.replace("x^2*x^2*x^2*x^2*x^2", "(x^10)");
    result = result.replace("x^2*x^2*x^2*x^2", "(x^8)");
    result = result.replace("x^2*x^2*x^2", "(x^6)");
    result = result.replace("x^2*x^2", "(x^4)");
    
    result = result.replace("x^2.0*x^2.0*x^2.0*x^2.0*x^2.0", "(x^10)");
    result = result.replace("x^2.0*x^2.0*x^2.0*x^2.0", "(x^8)");
    result = result.replace("x^2.0*x^2.0*x^2.0", "(x^6)");
    result = result.replace("x^2.0*x^2.0", "(x^4)");
    
    
    
    result = result.replace("x^3*x^3*x^3*x^3*x^3", "(x^15)");
    result = result.replace("x^3*x^3*x^3*x^3", "(x^12)");
    result = result.replace("x^3*x^3*x^3", "(x^9)");
    result = result.replace("x^3*x^3", "(x^6)");
    
    result = result.replace("x^3.0*x^3.0*x^3.0*x^3.0*x^3.0", "(x^15)");
    result = result.replace("x^3.0*x^3.0*x^3.0*x^3.0", "(x^12)");
    result = result.replace("x^3.0*x^3.0*x^3.0", "(x^9)");
    result = result.replace("x^3.0*x^3.0", "(x^6)");
    
    
    
    
    result = result.replace("x^4*x^4*x^4*x^4*x^4", "(x^20)");
    result = result.replace("x^4*x^4*x^4*x^4", "(x^16)");
    result = result.replace("x^4*x^4*x^4", "(x^12)");
    result = result.replace("x^4*x^4", "(x^8)");
    
    result = result.replace("x^4.0*x^4.0*x^4.0*x^4.0*x^4.0", "(x^20)");
    result = result.replace("x^4.0*x^4.0*x^4.0*x^4.0", "(x^16)");
    result = result.replace("x^4.0*x^4.0*x^4.0", "(x^12)");
    result = result.replace("x^4.0*x^4.0", "(x^8)");
    
    
    
    result = result.replace("x^5*x^5*x^5*x^5*x^5", "(x^25)");
    result = result.replace("x^5*x^5*x^5*x^5", "(x^20)");
    result = result.replace("x^5*x^5*x^5", "(x^15)");
    result = result.replace("x^5*x^5", "(x^10)");
    
    result = result.replace("x^5.0*x^5.0*x^5.0*x^5.0*x^5.0", "(x^25)");
    result = result.replace("x^5.0*x^5.0*x^5.0*x^5.0", "(x^20)");
    result = result.replace("x^5.0*x^5.0*x^5.0", "(x^15)");
    result = result.replace("x^5.0*x^5.0", "(x^10)");
    
    
    
    
    result = result.replace("x^6*x^6*x^6*x^6*x^6", "(x^30)");
    result = result.replace("x^6*x^6*x^6*x^6", "(x^24)");
    result = result.replace("x^6*x^6*x^6", "(x^18)");
    result = result.replace("x^6*x^6", "(x^12)");
    
    result = result.replace("x^6.0*x^6.0*x^6.0*x^6.0*x^6.0", "(x^30)");
    result = result.replace("x^6.0*x^6.0*x^6.0*x^6.0", "(x^24)");
    result = result.replace("x^6.0*x^6.0*x^6.0", "(x^18)");
    result = result.replace("x^6.0*x^6.0", "(x^12)");
    
    
    
    
    result = result.replace("x^7.0*x^7.0*x^7.0*x^7.0*x^7.0", "(x^35)");
    result = result.replace("x^7.0*x^7.0*x^7.0*x^7.0", "(x^28)");
    result = result.replace("x^7.0*x^7.0*x^7.0", "(x^21)");
    result = result.replace("x^7.0*x^7.0", "(x^14)");
    
    result = result.replace("x^7*x^7*x^7*x^7*x^7", "(x^35)");
    result = result.replace("x^7*x^7*x^7*x^7", "(x^28)");
    result = result.replace("x^7*x^7*x^7", "(x^21)");
    result = result.replace("x^7*x^7", "(x^14)");
    
    
    
    
    result = result.replace("x^8*x^8*x^8*x^8*x^8", "(x^40)");
    result = result.replace("x^8*x^8*x^8*x^8", "(x^32)");
    result = result.replace("x^8*x^8*x^8", "(x^24)");
    result = result.replace("x^8*x^8", "(x^16)");
    
    result = result.replace("x^8.0*x^8.0*x^8.0*x^8.0*x^8.0", "(x^40)");
    result = result.replace("x^8.0*x^8.0*x^8.0*x^8.0", "(x^32)");
    result = result.replace("x^8.0*x^8.0*x^8.0", "(x^24)");
    result = result.replace("x^8.0*x^8.0", "(x^16)");
    
    
    
    
    result = result.replace("x^9*x^9*x^9*x^9*x^9", "(x^45)");
    result = result.replace("x^9*x^9*x^9*x^9", "(x^36)");
    result = result.replace("x^9*x^9*x^9", "(x^27)");
    result = result.replace("x^9*x^9", "(x^18)");
    
    result = result.replace("x^9.0*x^9.0*x^9.0*x^9.0*x^9.0", "(x^45)");
    result = result.replace("x^9.0*x^9.0*x^9.0*x^9.0", "(x^36)");
    result = result.replace("x^9.0*x^9.0*x^9.0", "(x^27)");
    result = result.replace("x^9.0*x^9.0", "(x^18)");
    
    
    //result = result.replace("((x-2y)(x-2y))", "(x-2y)^2");
    return result;
}

static int factorial(int x) {
    if (x == 0) {
        return 1;
    } else {
        return x * factorial(x - 1);
    }

}
}
