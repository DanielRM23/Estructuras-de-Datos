public class Tiempo {
  public static void main(String[] args) {
    long t0 = System.nanoTime();

    Clase_seis.eliminarRepetidos(Arreglos.arr25);

    long t1 = System.nanoTime();
    Arreglos.printArray(Arreglos.arr25);

    System.out.println("\nEl tiempo en nanosegundos es:");
    System.out.println(t1 - t0);
  }
}
