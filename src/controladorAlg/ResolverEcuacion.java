/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladorAlg;


public class ResolverEcuacion {
    private int i;
    public double resolverFuncion(String funcion, double fx) {
        
        double  numero = 0, letra = 0;
        int signo = 0;
        double respuesta = 0;
        String[] ecuacion = separarFuncion(funcion);        
        i=0;        
        for (i = 0; i < ecuacion.length; i++) {            
            // se verifica si es un numero o letra
            if (esNumero(ecuacion[i]) == true) {
                signo = 1;                
                respuesta=resolverfraccion(ecuacion, fx, numero, signo, respuesta);
                if (i >= ecuacion.length) {
                    return respuesta;
                } 
            } else {
                if ((ecuacion.length - i) >= 1) {
                    
                    if (esTrigonometrica(ecuacion[i]+ecuacion[i+1])==true) {
                        signo=1;
                        if (i == 0) {                            
                            respuesta = resolverTrigonometricas(ecuacion[i], ecuacion, fx, numero, signo, respuesta);
                            if (i+1 >= ecuacion.length) {
                                return respuesta;
                            }
                        } else {
                            double fic=0;
                            respuesta = respuesta * resolverTrigonometricas(ecuacion[i], ecuacion, fx, numero, signo, fic);
                            if (i+1 >= ecuacion.length) {
                                return respuesta;
                            }
                        }
                    }
                    if (esLogaritmo(ecuacion[i] + ecuacion[i + 1])) {
                        signo=1;
                        if (i == 0) {
                            respuesta = resolverLogaritmo(ecuacion[i], ecuacion, fx, numero, signo, respuesta);
                            if (i+1 >= ecuacion.length) {
                                return respuesta;
                            }
                        } else {
                            double fic=0;
                            respuesta = respuesta * resolverLogaritmo(ecuacion[i], ecuacion, fx, numero, signo, fic);
                            if (i+1 >= ecuacion.length) {
                                return respuesta;
                            }
                        }

                    }
                }
                
                if (esLetra(ecuacion[i]) == true) {
                    
                    signo = 1;
                    if (i==0) {
                        respuesta = respuesta + (signo * resolverLetraExponente(ecuacion, fx));
                        if (i >= ecuacion.length) {
                            return respuesta;
                        } 
                    }else{
                        respuesta = respuesta * (signo * resolverLetraExponente(ecuacion, fx));
                        if (i >= ecuacion.length) {
                            return respuesta;
                        } 
                    }                    
                }                
            }
            // se verifica si el valor es signo negativo
            if (ecuacion[i].equals("-")) {
                signo = -1;
                i++;
                // se verifica si es un numero
                if (esNumero(ecuacion[i]) == true) {
                    respuesta=resolverfraccion(ecuacion, fx, numero, signo, respuesta);
                    if (i >= ecuacion.length) {
                        return respuesta;
                    }
                } else {
                    if (esLetra(ecuacion[i]) == true) {
                        letra = fx;
                        signo = -1;
                        respuesta = respuesta + (signo * resolverLetraExponente(ecuacion, letra));
                        if (i >= ecuacion.length) {
                            return respuesta;
                        }   
                    }
                    if (esTrigonometrica(ecuacion[i] + ecuacion[i + 1]) == true) {
                        respuesta = resolverTrigonometricas(ecuacion[i], ecuacion, fx, numero, signo, respuesta);
                        if (i >= ecuacion.length) {
                            return respuesta;
                        }
                    }
                    if (esLogaritmo(ecuacion[i] + ecuacion[i+1])) {
                        respuesta = resolverTrigonometricas(ecuacion[i], ecuacion, fx, numero, signo, respuesta);
                        if (i >= ecuacion.length) {
                            return respuesta;
                        }
                    }
                }
            }
            // se verifica si el valor es signo positivo
            if (ecuacion[i].equals("+")) {
                signo = 1;
                i++;
                // se verifica si es un numero
                if (esNumero(ecuacion[i]) == true) {                    
                    respuesta=resolverfraccion(ecuacion, fx, numero, signo, respuesta);
                    if (i >= ecuacion.length) {
                        return respuesta;
                    }
                } else {
                    if (esLetra(ecuacion[i]) == true) {
                        letra = fx;
                        signo = 1;
                        respuesta = respuesta + (signo * resolverLetraExponente(ecuacion, letra));
                        if (i >= ecuacion.length) {
                            return respuesta;
                        }
                    }
                    if (esTrigonometrica(ecuacion[i] + ecuacion[i + 1]) == true) {
                        respuesta = resolverTrigonometricas(ecuacion[i], ecuacion, fx, numero, signo, respuesta);
                        if (i >= ecuacion.length) {
                            return respuesta;
                        }
                    }
                    if (esLogaritmo(ecuacion[i] + ecuacion[i+1])) {
                        respuesta = resolverTrigonometricas(ecuacion[i], ecuacion, fx, numero, signo, respuesta);
                        if (i >= ecuacion.length) {
                            return respuesta;
                        }
                    }
                }
            }
        }
        return respuesta;
    }

    private String[] separarFuncion(String formula) {
        String[] datos = formula.split("");
        return datos;

    }

    private boolean esNumero(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException n) {
            return false;
        }
    }

    private boolean esLetra(String valor) {
        char letra = valor.charAt(0);
        int dato = (int) letra;
        if (dato >= 65 && dato <= 122) {
            return true;
        } else {
            return false;
        }
    }
    private double resolverLetraExponente(String[] ecuacion, double constante){   
        i++;                    
        boolean verificar;
        // Se verifica si ya no existen mas valores 
        if (i >= ecuacion.length) {
            return constante;
        }
        // severifica si tiene un exponente la letra
        if (ecuacion[i].equals("^")) {
            i++;
            verificar = true;
            String losNumeros2 = "";
            // Verifica cuantos numeros existen en cada lugar
            while (verificar == true) {
                if (esNumero(ecuacion[i]) == true) {
                    losNumeros2 = losNumeros2 + ecuacion[i];
                    i++;
                    if (i >= ecuacion.length) {
                            verificar = false;
                        }
                } else {
                    i--;
                    verificar = false;
                }
            }                    
            int exponente = Integer.parseInt(losNumeros2);
            constante = (double) Math.pow(constante, exponente);
        } else {
            i--;
        }
        // Se obtiene la respuesta del primer valor                     
        return constante;
    }
    
    private double resolverfraccion(String[] ecuacion, double constante, double numero,int signo, double respuesta ){        
        boolean verificar = true;
        String losNumeros = "";
        // Verifica cuantos numeros existen en cada lugar( Unidad- Decena- Centena )
        while (verificar == true) {
            if (esNumero(ecuacion[i]) == true) {
                losNumeros = losNumeros + ecuacion[i];
                i++;
                if (i >= ecuacion.length) {
                    return respuesta;
                }                
                
            } else {
                if (i >= ecuacion.length) {
                    return respuesta;
                }
                verificar = false;
            }
        }
        numero = Integer.parseInt(losNumeros);
        // Se verifica si ya no existen mas valores 
        if (i >= ecuacion.length) {
            return respuesta + (signo * numero);
        }
        if ((ecuacion.length - i) >= 2) {
            if (esTrigonometrica(ecuacion[i] + ecuacion[i + 1]) == true) {
                respuesta = signo * numero * resolverTrigonometricas(ecuacion[i], ecuacion, constante, numero, signo, respuesta);
                if (i >= ecuacion.length) {
                    return respuesta;
                }
            }
            if (esLogaritmo(ecuacion[i] + ecuacion[i + 1]) == true) {
                respuesta = signo * numero * resolverLogaritmo(ecuacion[i], ecuacion, constante, numero, signo, respuesta);
                if (i >= ecuacion.length) {
                    return respuesta;
                }
            }
        }       
        //se verifica si es una letra o signo
        if (esLetra(ecuacion[i]) == true) {            
            respuesta = respuesta + (signo * numero * resolverLetraExponente(ecuacion, constante));
            if (i >= ecuacion.length) {
                return respuesta;
            }
            if ((ecuacion.length - i) >= 1) {
                if (esTrigonometrica(ecuacion[i] + ecuacion[i + 1]) == true) {
                    respuesta = signo * numero * resolverLetraExponente(ecuacion, constante)* resolverTrigonometricas(ecuacion[i], ecuacion, constante, numero, signo, respuesta);

                    if (i >= ecuacion.length) {
                        return respuesta;
                    }
                }
                if (esLogaritmo(ecuacion[i] + ecuacion[i + 1]) == true) {
                    respuesta = signo * numero * resolverLogaritmo(ecuacion[i], ecuacion, constante, numero, signo, respuesta);
                    if (i >= ecuacion.length) {
                        return respuesta;
                    }
                }
            }
        } else {
            if (esSigno(ecuacion[i])) {
                respuesta = respuesta + (signo * numero);
                i--;
                
            }
            
        }
        
    return respuesta;
                
    }
    private boolean esTrigonometrica(String tri){
        if (tri.equals("si") || tri.equals("co") || tri.equals("ta")) {
            return true;
        }else{
            return false;
        }      
    }
    private boolean esSigno(String signo){
        if (signo.equals("+") || signo.equals("-")) {
            return true;
        }
        else
            return false;
    }
    private double resolverTrigonometricas(String tri, String[] ecuacion, double costante, double numero,int signo, double respuesta){
        i=i+4;        
        if (esNumero(ecuacion[i])) {
            respuesta= resolverfraccion(ecuacion, costante, numero, signo, respuesta);
            i++;
            if (tri.equals("s")) {
                double angulo = respuesta * Math.PI/180.0;
                return Math.sin(angulo);
            }
            if (tri.equals("c")) {
                double angulo = respuesta * Math.PI/180.0;
                return Math.cos(angulo);
            }
            if (tri.equals("t")) {
                double angulo = respuesta * Math.PI/180.0;
                return Math.tan(angulo);
            }  
        }
        else{
            
            if (esLetra(tri) == true) {                      
                respuesta = respuesta + (signo * resolverLetraExponente(ecuacion, costante));
                i++;
                if (tri.equals("s")) {
                    double angulo = respuesta * Math.PI/180.0;
                    return Math.sin(angulo);
                }
                if (tri.equals("c")) {
                    double angulo = respuesta * Math.PI/180.0;
                    return Math.cos(angulo);
                }
                if (tri.equals("t")) {
                    double angulo = respuesta * Math.PI/180.0;
                    return Math.tan(angulo);
                }
            }
        }
        return 0;
    }
    
    private boolean esLogaritmo(String loga){
        if (loga.equals("lo")) {
            return true;
        }else{
            return false;   
        }        
    }
    private double resolverLogaritmo (String lo, String[] ecuacion, double costante, double numero,int signo, double respuesta){
        
        i=i+4;
        if (esNumero(lo)) {
            respuesta= resolverfraccion(ecuacion, costante, numero, signo, respuesta);
            i++;
            return Math.log(respuesta);
        }
        else{
            if (esLetra(ecuacion[i]) == true) {                      
                respuesta = respuesta + (signo * resolverLetraExponente(ecuacion, costante));
                i++;
                return Math.log(respuesta);
            }
        }
        return 0;
    }
}
