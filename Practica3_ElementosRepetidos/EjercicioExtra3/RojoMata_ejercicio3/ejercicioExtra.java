public class ejercicioExtra{

    /*
     * Función factorial iterativa
     */
    public int factorial_iterativo(int n) {
        if (n < 0) {
            System.out.println("Ingresa un valor positivo");
            return -1;
        } else if (n == 0) {
            System.out.println("El factorial de " + n + " es: 1");
            return 1;
        } else {
            int fact = 1;
            for (int i = 1; i <= n; i++) {
                fact *= i;
            }
            System.out.println("El factorial de " + n + " es: " + fact + "\n");
            return fact;
        }
    }
    
    /*
     * Secuencia de fibonacci iterativa
     */
    public int[] fibonacci_iterativo(int n) {
        int[] arreglo = new int[n + 1]; // Inicializa el arreglo con tamaño n+1
        if (n < 2) {
            if (n == 0) {
                arreglo[0] = 0;
            } else {
                arreglo[0] = 0;
                arreglo[1] = 1;
            }
        } else {
            arreglo[0] = 0;
            arreglo[1] = 1;
            for (int i = 2; i < n + 1; i++) { // Cambia i <= n a i < n + 1
                arreglo[i] = arreglo[i - 1] + arreglo[i - 2];
            }
        }
        return arreglo;
    }
    

    /*
     * Método que imprime los elementos de un array
     */
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length - 1; i++)
          System.out.printf("%d,", arr[i]);
        System.out.printf("%d]\n", arr[arr.length - 1]);
      }



    public static void main(String[] Holaaaaaa) {

        ejercicioExtra hola = new ejercicioExtra(){};

        int[] numeros = {8, 32, 128, 512, 2048};

        // Se ejecuta la función factorial para todos los cosos del arreglo numeros
        for (int i : numeros) {
            hola.factorial_iterativo(i);
        }

        // Se ejecuta fibonacci para todos los cosos del arreglo numeros
        for (int i : numeros) {
            printArray(hola.fibonacci_iterativo(i));
        }

    }

}