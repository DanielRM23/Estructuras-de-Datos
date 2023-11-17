public class Practica5{

  //Arreglos para probar los metodos
  int[] a1 = {3,7,12,16,29};
  int[] a2 = {1,6,7,9,12,14,18,19,20,22};
  int[] a3 = {0,2,4,5,7,9,11,12,13,15,16,17,18,22,27};
  int[] a4 = {2,3,4,6,7,8,11,12,13,14,15,17,18,20,21,22,24,25,27,28};
  int[] a5 = {0,1,2,4,5,6,8,9,11,13,14,16,17,18,19,21,22,24,25,27,28,29,29,30,35};
  int[] a6 = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29};
  int[] a7 = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,30,31,33};
  int[] a8 = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,30,30,30,30,30,30,31,32};
  int[] a9 = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,42,42,43,44,45};
  int[] a10 = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,45,47,50,51,60,72};
  
  /*
    Aqui van tus metodos
  */

   /**
   * Metodo que implementa el algoritmo de busqueda secuencial
   * @param A
   * @param x, -1
   * @return el indice donde se encuentra x, en caso de no estar devuelve -1
   */  
  public static int busquedaSecuencial(int[] A, int x) {
    int n = A.length;
    for (int i = 0; i < n; i++) {
        if (x == A[i]) {
            return i;
        }
    }
    return -1;
  }
  
  /**
   * Método que implementa el algoritmo Busqueda Binaria
   * @param A Arreglo de números enteros 
   * @param x Número a buscar
   * @param s Índice inicial
   * @param t Índice final
   * @param n Longitud del arreglo 
   * @return el índice en donde se encuentra x, en caso de no estar devuelve -1
   */
  public int bb(int[] A, int x, int s, int t, int n) {
    if (n < 2) {
      if (x == A[s]) {
          return s;
      } else {
          return -1;
      }
    } 
    else {
      int mid = (s + t) / 2;
      if (x <= A[mid]) {
          return bb(A, x, s, mid, mid - s + 1);
      } else {
          return bb(A, x, mid + 1, t, t - mid);
      }
    }
  }

/**
 * Implementa el algoritmo bb
 * @param A arreglo de longitud n
 * @param x elemento a buscar
 * @return
 */
public int BusquedaBinaria(int[] A, int x) {
    int s = 0; 
    int t = A.length - 1;
    int n = A.length;
    int resultado = bb(A, x, s, t, n);
    return resultado; 
}

  /**
   * Ejecuta los algoritmos vistos en clase para probar las búsquedas con los arrglos dados
   * @param Holaaaaa
   */
  public static void main(String[] Holaaaaa){

    Practica5 hola = new Practica5();
    System.out.println("Programa los metodos solicitados");

    // Resultados para Busqueda Secuencial
    System.out.println("\nBusqueda Secuencial \n"); 
    System.out.println(busquedaSecuencial(hola.a1,29));
    System.out.println(busquedaSecuencial(hola.a2,22));
    System.out.println(busquedaSecuencial(hola.a3,27));
    System.out.println(busquedaSecuencial(hola.a4,28));
    System.out.println(busquedaSecuencial(hola.a5,35));
    System.out.println(busquedaSecuencial(hola.a6,29));
    System.out.println(busquedaSecuencial(hola.a7,33));
    System.out.println(busquedaSecuencial(hola.a8,32));
    System.out.println(busquedaSecuencial(hola.a9,45));
    System.out.println(busquedaSecuencial(hola.a10,72));

    // Resultados para Busqueda Binaria
    System.out.println("\nBusqueda Binaria \n"); 
    System.out.println(hola.BusquedaBinaria(hola.a1, hola.a1[hola.a1.length-1]));
    System.out.println(hola.BusquedaBinaria(hola.a2, hola.a2[hola.a2.length-1]));
    System.out.println(hola.BusquedaBinaria(hola.a3, hola.a3[hola.a3.length-1]));
    System.out.println(hola.BusquedaBinaria(hola.a4, hola.a4[hola.a4.length-1]));
    System.out.println(hola.BusquedaBinaria(hola.a5, hola.a5[hola.a5.length-1]));
    System.out.println(hola.BusquedaBinaria(hola.a6, hola.a6[hola.a6.length-1]));
    System.out.println(hola.BusquedaBinaria(hola.a7, hola.a7[hola.a7.length-1]));
    System.out.println(hola.BusquedaBinaria(hola.a8, hola.a8[hola.a8.length-1]));
    System.out.println(hola.BusquedaBinaria(hola.a9, hola.a9[hola.a9.length-1]));
    System.out.println(hola.BusquedaBinaria(hola.a10, hola.a10[hola.a10.length-1]));

  }
}
