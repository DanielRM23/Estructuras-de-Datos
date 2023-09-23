
public class Clase_seis {
  public static void main(String[] Holaaaaaaa) {

    // Ejemplo, puedes borrarlo
    Arreglos.printArray(Arreglos.arr5);
    System.out.println("El arreglo sin elememtos repetidos es: ");
    Arreglos.printArray(eliminarRepetidos(Arreglos.arr5));
    System.out.println(" ");

    Arreglos.printArray(Arreglos.arr10);
    System.out.println("El arreglo sin elememtos repetidos es: ");
    Arreglos.printArray(eliminarRepetidos(Arreglos.arr10));
    System.out.println(" ");

    Arreglos.printArray(Arreglos.arr15);
    System.out.println("El arreglo sin elememtos repetidos es: ");
    Arreglos.printArray(eliminarRepetidos(Arreglos.arr15));
    System.out.println(" ");

    Arreglos.printArray(Arreglos.arr20);
    System.out.println("El arreglo sin elememtos repetidos es: ");
    Arreglos.printArray(eliminarRepetidos(Arreglos.arr20));
    System.out.println(" ");

    Arreglos.printArray(Arreglos.arr25);
    System.out.println("El arreglo sin elememtos repetidos es: ");
    Arreglos.printArray(eliminarRepetidos(Arreglos.arr25));
    System.out.println(" ");

  }

  /**
   * Se ingresa un arreglo ordenado de manera creciente de valores enteros
   * 
   * @param arregloConRepetidos
   * @return Un arreglo A sin elementos repetidos
   */
  public static int[] eliminarRepetidos(int[] arregloConRepetidos) {

    int tamañoSinRepetidos = 1;

    for (int i = 1; i < arregloConRepetidos.length; i++) {
      if (arregloConRepetidos[i] != arregloConRepetidos[i - 1]) {
        tamañoSinRepetidos++;
      }
    }

    // Se crea un nuevo arreglo sin elementos repetidos
    int[] arregloSinRepetidos = new int[tamañoSinRepetidos];
    arregloSinRepetidos[0] = arregloConRepetidos[0];

    int j = 1;

    for (int i = 1; i < arregloConRepetidos.length; i++) {
      if (arregloConRepetidos[i] != arregloConRepetidos[i - 1]) {
        arregloSinRepetidos[j] = arregloConRepetidos[i];
        j++;
      }
    }

    return arregloSinRepetidos;
  }

}
