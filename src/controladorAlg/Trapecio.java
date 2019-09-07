package controladorAlg;

import metodos.Base;

public class Trapecio extends Base {

    public Trapecio() {
        this.espaciado = 0;
        this.decimales = 10;
    }

    public String evaluar(Funcion funcion, double a, double b, double n) {
        
        String men = "";
        String mens = "";
        double delta = 0;
        double x = 0;
        double ant = 0;
        delta = (b-a)/n;
        
        men = men + ("\t\tDELTA: " + "(" + b + " - " + a + " / " + n + " ) = " + delta + "\n");
        
        for (int i = 0; i <= n; i++) {
            if(i == 0){
                x = x + a;
                men = men + ("\tx" + i + " = " + x + "\n");
            }else{
                x = x + delta;
                men = men + ("\tx" + i + " = " + ant + " + "+ delta +" = "+ x + "\n");
            }
            mens = mens + ("\tf("+i+")" + " = "+funcion.evaluar(i) + "\n");
            ant = x;
        }
         men = men + mens;
        

        double resultado = ((b - a) / (2*n)) * (funcion.evaluar(a) + funcion.evaluar(b));
        
        men = men + ("\n");
        men = men + ("Resultado:\n");
        men = men +("f(x)" +" = " + "( (" + b + " - " + a +" ) " + " / (2" + n + " ) )" + " ( " + funcion.evaluar(a) + " + " +funcion.evaluar(b) + " ) = " + resultado + " U/c");

      
      
        return men;

    }

}
