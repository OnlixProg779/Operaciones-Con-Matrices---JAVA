/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladorAlg;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;


public class Retrasadas {
    public static String cadena;
    
    public void primeraDerivada(String funcion, double x, double h) {             
        ResolverEcuacion op = new ResolverEcuacion();             
        double fx=  (op.resolverFuncion(funcion, x));
        fx=new BigDecimal(fx).setScale(4, RoundingMode.HALF_EVEN).doubleValue();        
        double fxh =( op.resolverFuncion(funcion, (x - h)));
        fxh=new BigDecimal(fxh).setScale(4, RoundingMode.HALF_EVEN).doubleValue();        
        double respuesta= ( ((fx - fxh) / (h)));
        respuesta= new BigDecimal(respuesta).setScale(4, RoundingMode.HALF_EVEN).doubleValue();
        cadena=cadena + "\n"
                + "f' = (f(x) - f(x - h)) / (h) \n"
                + "f' = (f(" + x + ") - f(" + x +" - " + h + ")) / (" + h + ") \n\n"
                + "\t\t* Funcion Final * \n"
                + "f(x) = " + fx + "\n"
                + "f(x-h) = " + fxh + "\n\n"
                + "\t\t* Reemplazamos *\n"
                + "f' = ((" + fx + ") - (" + (fxh)+"))/" +" ("+ h +")"+"\n"
                + "\"R:  " +  respuesta + "\n\n\n";
    }        
    public void segundaDerivada(String funcion, double x, double h) {        
        ResolverEcuacion op = new ResolverEcuacion();     
        double fx= ( op.resolverFuncion(funcion, x));
        fx=new BigDecimal(fx).setScale(4, RoundingMode.HALF_EVEN).doubleValue();
        double fxh = ( op.resolverFuncion(funcion, (x - h)));   
        fxh = new BigDecimal(fxh).setScale(4, RoundingMode.HALF_EVEN).doubleValue();
        double fx2h = ( op.resolverFuncion(funcion, (x - (2*h))));  
        fx2h = new BigDecimal(fx2h).setScale(4, RoundingMode.HALF_EVEN).doubleValue();
        double respuesta= (fx2h - (2*fxh) + fx ) / (Math.pow(h, 2));
        respuesta = new BigDecimal(respuesta).setScale(4, RoundingMode.HALF_EVEN).doubleValue();
        cadena=cadena +   "\n"
                + "f' = ( f(x - 2h) - 2f(x - h) + f(x)) / (h^2) \n"
                + "f' = ( f(" + x + "- 2" + h +") - 2f(" + x +" - " + h + ") + f(" + x + ")) / (" + h + "^2) \n\n"
                + "\t\t* Funcion Final * \n"
                + "f(x-2h) = " + fx2h + "\n"                
                + "f(x-h) = " + fxh + "\n"
                + "f(x) = " + fx + "\n"
                + "\t\t* Reemplazamos *\n\n"
                + "f' = ((" + (fx2h) + ") - (" + (fxh) + ") + (" + fx + "))/" +" ("+ new BigDecimal(Math.pow(h, 2)).setScale(4, RoundingMode.HALF_EVEN).doubleValue() +")"+"\n"
                + "\"R:  " +  respuesta + "\n\n\n";
    }
    
    public void terceraDerivada(String funcion, double x, double h) {
        
        ResolverEcuacion op = new ResolverEcuacion();     
        double fx=  op.resolverFuncion(funcion, x);        
        fx= new BigDecimal(fx).setScale(4, RoundingMode.HALF_EVEN).doubleValue();
        double fxh =  op.resolverFuncion(funcion, (x - h));   
        fxh = new BigDecimal(fxh).setScale(4, RoundingMode.HALF_EVEN).doubleValue();
        double fx2h = op.resolverFuncion(funcion, (x - (2*h)));   
        fx2h = new BigDecimal(fx2h).setScale(4, RoundingMode.HALF_EVEN).doubleValue();
        double fx3h = op.resolverFuncion(funcion, (x - (3*h)));   
        fx3h = new BigDecimal(fx3h).setScale(4, RoundingMode.HALF_EVEN).doubleValue();
        double respuesta= ( - fx3h + (3*fx2h) - (3*fxh) + fx ) / (Math.pow(h, 3));
        respuesta = new BigDecimal(respuesta).setScale(4, RoundingMode.HALF_EVEN).doubleValue();
        cadena=cadena +   "\n"
                + "f' = (- f(x - 3h) + 3f(x - 2h) - 3f(x - h) + f(x)) / (h^3) \n"
                + "f' = (- f(" + x + "- 3" + h +")" + " + 3f(" + x + "- 2" + h +") - 3f(" + x +" - " + h + ") + f(" + x + ")) / (" + h + "^3) \n\n"
                + "\t\t* Funcion Final * \n"
                + "f(x-3h) = " + fx3h + "\n"
                + "f(x-2h) = " + fx2h + "\n"                
                + "f(x-h) = " + fxh + "\n"
                + "f(x) = " + fx + "\n\n"
                + "\t\t* Reemplazamos *\n"
                + "f' = (( - " + (fx3h) + ") + (" + (fx2h) + ") - (" + (fxh) + ") + (" + fx + "))/" +" ("+ new BigDecimal((Math.pow(h, 3))).setScale(4, RoundingMode.HALF_EVEN).doubleValue() +")"+"\n"
                + "\"R:  " +  respuesta + "\n\n\n";
    }
    
    
}
