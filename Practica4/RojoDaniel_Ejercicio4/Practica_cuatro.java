
public class Practica_cuatro {

  /**
   * Concatena dos arreglos ordenados
   * @param arreglo1
   * @param arreglo2
   * @return arreglo ordenado de longitud 2n
   */
  public static int[] arreglo_2n(int[] arreglo1, int[] arreglo2) {
    int longitud = arreglo1.length;

    int[] arreglo_auxiliar = new int[2 * longitud];

    int i = 0;
    int j = 0;

    while (i < longitud && j < longitud) {
        if (arreglo1[i] <= arreglo2[j]) {
            arreglo_auxiliar[i + j] = arreglo1[i];
            i++;
        } else {
            arreglo_auxiliar[i + j] = arreglo2[j];
            j++;
        }
    }

    // Copiar cualquier elemento restante de arreglo1, si los hay
    while (i < longitud) {
        arreglo_auxiliar[i + j] = arreglo1[i];
        i++;
    }

    // Copiar cualquier elemento restante de arreglo2, si los hay
    while (j < longitud) {
        arreglo_auxiliar[i + j] = arreglo2[j];
        j++;
    }

    return arreglo_auxiliar;
  }

}
