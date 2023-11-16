public class Ejercicio7 {

    /**
     * Realiza una operación aritmética entre dos operandos.
     *
     * @param operador  El operador aritmético a realizar.
     * @param operando1 El primer operando.
     * @param operando2 El segundo operando.
     * @return El resultado de la operación.
     */
    public int RealizarOperacion(char operador, int operando1, int operando2) {
        int resultado = 0;

        switch (operador) {
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
                if (operando2 != 0) {
                    resultado = operando1 / operando2;
                } else {
                    System.out.println("Error: División por cero.");
                }
                break;
            default:
                System.out.println("Error: Operador no válido.");
                break;
        }

        return resultado;
    }

    /**
     * Evalúa una expresión aritmética dada en forma de caracteres.
     *
     * @param E La expresión aritmética a evaluar.
     * @return El resultado de la evaluación.
     * @throws Exception Si la expresión no es válida.
     */
    public int EvaluarExpresionAritmetica(char[] E) throws Exception {

        int n = E.length;
        Pila<Integer> PilaOperandos = new Pila<>();
        char[] Digitos = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };

        for (int i = 0; i < n; i++) {
            if (contieneElemento(Digitos, E[i])) {
                int valorNumerico = Character.getNumericValue(E[i]);
                PilaOperandos.apilar(valorNumerico);
            } else {
                int operando2 = PilaOperandos.darElementoCima();
                PilaOperandos.desapilar();
                int operando1 = PilaOperandos.darElementoCima();
                PilaOperandos.desapilar();
                int resultado = RealizarOperacion(E[i], operando1, operando2);
                PilaOperandos.apilar(resultado);
            }
        }

        return PilaOperandos.darElementoCima();
    }

    
    /**
     * Verifica si un carácter específico está presente en un arreglo de caracteres.
     *
     * @param arreglo  El arreglo de caracteres en el que se buscará el elemento.
     * @param elemento El carácter que se está buscando en el arreglo.
     * @return true si el carácter está presente en el arreglo, false en caso
     *         contrario.
     */
    public static boolean contieneElemento(char[] arreglo, char elemento) {
        for (char valor : arreglo) {
            if (valor == elemento) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] hola) {

        Ejercicio7 prueba = new Ejercicio7();

        try {
            char[] E = { '7', '8', '+', '3', '2', '+', '/' };

            System.out.print("\nEl arreglo de caracteres introducido es: \n");
            System.out.print("[");
            for (int i = 0; i < E.length; i++) {
                System.out.print(E[i]);
                if (i < E.length - 1) {
                    System.out.print(", ");
                }
            }

            System.out.print("]\n");
            int resultado = prueba.EvaluarExpresionAritmetica(E);
            System.out.println("El resultado de la operación es: ");
            System.out.println(resultado);

        } catch (Exception e) {
            System.out.println("Excepción: " + e.getMessage());
        }
    }
}