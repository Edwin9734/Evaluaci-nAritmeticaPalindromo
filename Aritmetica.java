package org.example.evaluacion;


import org.example.Pilas.PilaLineal;


public class Aritmetica {

    

    // Aqui evaluamos una expreción aritmetica
    public static int evaluar(String expresion) throws Exception {
        //declaramos dos pilas una para operandos y otra para operadores

        PilaLineal operandos = new PilaLineal();
        PilaLineal operadores = new PilaLineal();
        int resultado = 0; // declaramos la variable que almacenará el resultado de la evaluación
        int operando1, operando2; // declaramos las variables para almacenar los operandos
        char operador; // Declara la variable para el signo del operador
        int i = 0; // Índice para recorrer la expresión

        // Aca iteramos la expresión caracter por caracter
        while (i < expresion.length()){
            // Si el caracter es un espacio en blanco se salta a la siguiente iteración
            if (expresion.charAt(i) == ' '){
                i++;
            }
            // si el caracter es  [+, -, *, /] se añade a la pila
            else if (expresion.charAt(i) == '+' || expresion.charAt(i) == '-' || expresion.charAt(i) == '*' || expresion.charAt(i) == '/'){
                operadores.insertar(expresion.charAt(i));
                i++;
            }
                //Si no es un espacio o un operador, se agrega a la pila de operandos
            else {
                String numero = "";
                while (i < expresion.length() && expresion.charAt(i) != ' ' && expresion.charAt(i) != '+' && expresion.charAt(i) != '-' && expresion.charAt(i) != '*' && expresion.charAt(i) != '/'){
                    numero += expresion.charAt(i);
                    i++;
                }
                operandos.insertar(Integer.parseInt(numero));
            }
        }
        //se realiza una lectura y ejecucion de los datos apilados
        while (!operadores.pilaVacia()){
            try {
                operando2 = (int) operandos.quitar();
                operando1 = (int) operandos.quitar();
                operador = (char) operadores.quitar();
                switch (operador){
                    // Se realiza la operación correspondiente según el operador
                    case '+':
                        resultado = operando1 + operando2;
                        break;
                    case '-':
                        resultado = operando1 - operando2;
                        break;
                    case '*':
                        resultado = operando1 * operando2;
                        break;
                    case '/':
                        resultado = operando1 / operando2;
                        break;
                }
                // Se agrega el resultado de la operación a la pila de operandos para su posterior evaluación
                operandos.insertar(resultado);
            }
                //hace una excepción por si hay algun error
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        // Retorna el resultado
        return resultado;
    }
    
    }




