public class Tiempo {
  public static void main(String[] args) {
    
    ejercicioExtra hola = new ejercicioExtra(){};

    int valor = 2048;
    
    long t0 = System.nanoTime();

    hola.fibonacci_iterativo(valor);

    long t1 = System.nanoTime();

    //System.out.println("\nEl tiempo en nanosegundos para " + valor + " es: ");
    System.out.println(valor);
    System.out.println(t1 - t0);
  }
}
