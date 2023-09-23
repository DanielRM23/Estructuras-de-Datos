public class Tiempo {
  public static void main(String[] args) {
    
    int[] a = Arreglos.a25;
    int[] b = Arreglos.b25; 


    long t0 = System.nanoTime();

    Practica_cuatro.arreglo_2n(a, b);

    long t1 = System.nanoTime();

    Arreglos.printArray(Practica_cuatro.arreglo_2n(a, b));

    System.out.println("\nEl tiempo en nanosegundos es:");
    System.out.println(t1 - t0);
  }
}
