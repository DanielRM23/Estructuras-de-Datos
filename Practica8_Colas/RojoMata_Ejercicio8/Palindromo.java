/**
 * Clase para implementar y probar el algoritmo EsPalindromo.
 */
public class Palindromo {

    public static void main(String[] args) {
        String w1 = "anitalavalatina";
        String w2 = "romaniseconocesinoriniseconocesinamor";
        // Aplica tu algoritmo a las siguientes entradas:
        char[] p1 = w1.toCharArray();
        char[] p2 = w2.toCharArray();

        try {
            System.out.println(esPalindromo(p1));
            System.out.println(esPalindromo(p2));
        } catch (Exception e) {
            System.out.println("Excepción: " + e.getMessage());
        }
    }

    /**
     * Verifica si una cadena de caracteres es un palíndromo.
     *
     * @param p Un array de caracteres que representa la cadena a verificar.
     * @return true si la cadena es un palíndromo, false en caso contrario.
     */
    public static boolean esPalindromo(char[] p) throws Exception {
        Pila<Character> reversa = new Pila<>();
        Cola<Character> original = new Cola<>();
        int n = p.length;

        for (int i = 0; i < n; i++) {
            reversa.apilar(p[i]);
            original.encolar(p[i]);
        }

        while (!reversa.esVacia()) {
            char cima = reversa.darElementoCima();
            char inicio = original.darElementoInicio();
            if (cima == inicio) {
                reversa.desapilar();
                original.desencolar();
            } else {
                return false;
            }
        }
        return true;
    }

}
