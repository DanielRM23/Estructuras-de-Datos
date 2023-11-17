public class ejercicio4{

    /**
     * Regresa la mediana de un arreglo
     * @param arreglo1 Arreglo de enteros no necesariamente ordenado
     * @param arreglo2 Arreglo de enteros no necesariamente ordenado
     * @return Alguno de los dos elementos que se encuentran a la mitad del arreglo
     */
    public static int mediana(int[] arreglo1, int[] arreglo2){
        int[] arreglo_dimension_2n = Practica_cuatro.arreglo_2n(ejercicio4.bubbleSort(arreglo1), ejercicio4.bubbleSort(arreglo2));
        int longitud = arreglo_dimension_2n.length;
        return arreglo_dimension_2n[longitud/2];
    }


    /**
     * Método bubble sort; ordena los elementos de un arreglo en forma creciente
     * @param arr
     * @return arreglo ordenado
     */
    public static int[] bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Intercambiar arr[j] y arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }

        return arr;
    }

    /**
   * Imprime un arreglo
   *
   * @param arr el arreglo a imprimir
   */
  public static void printArray(int[] arr) {
    if (arr.length == 0){
      System.out.println("[]");
    }
    System.out.print("[");
    for (int i = 0; i < arr.length - 1; i++){
      System.out.printf("%d,", arr[i]);
    }
    System.out.printf("%d]\n", arr[arr.length - 1]);
  }





    public static void main(String[] args) {
        ejercicio4 hola = new ejercicio4();
        
        System.out.println("Arreglo 1");
        int[] arreglo1 = Arreglos.a5;
        printArray(arreglo1);

        System.out.println("\nArreglo 2");
        int[] arreglo2 = Arreglos.b5;
        printArray(arreglo2);

        System.out.println("\nArreglo ordenado de tamaño 2n:");
        printArray(Practica_cuatro.arreglo_2n(arreglo1, arreglo2));

        System.out.println("\nLa mediana es:");
        System.out.println(hola.mediana(arreglo1, arreglo2));
    
    }
}