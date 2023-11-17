public class Tiempo_Busqueda_Secuencial {
  public static void main(String[] Holaaaaa) {

    Practica5 hola = new Practica5();

    long t0, t1;
    t0 = System.nanoTime();
    hola.busquedaSecuencial(hola.a1, 29);
    t1 = System.nanoTime();
    System.out.println("\nEl tiempo en nanosegundos es:");
    System.out.println(t1 - t0);

    long t2, t3;
    t2 = System.nanoTime();
    hola.busquedaSecuencial(hola.a2, 22);
    t3 = System.nanoTime();
    System.out.println("\nEl tiempo en nanosegundos es:");
    System.out.println(t3 - t2);

    long t4, t5;
    t4 = System.nanoTime();
    hola.busquedaSecuencial(hola.a3, 27);
    t5 = System.nanoTime();
    System.out.println("\nEl tiempo en nanosegundos es:");
    System.out.println(t5 - t4);

    long t6, t7;
    t6 = System.nanoTime();
    hola.busquedaSecuencial(hola.a4, 28);
    t7 = System.nanoTime();
    System.out.println("\nEl tiempo en nanosegundos es:");
    System.out.println(t7 - t6);

    long t8, t9;
    t8 = System.nanoTime();
    hola.busquedaSecuencial(hola.a5, 35);
    t9 = System.nanoTime();
    System.out.println("\nEl tiempo en nanosegundos es:");
    System.out.println(t9 - t8);

    long t10, t11;
    t10 = System.nanoTime();
    hola.busquedaSecuencial(hola.a6, 29);
    t11 = System.nanoTime();
    System.out.println("\nEl tiempo en nanosegundos es:");
    System.out.println(t11 - t10);

    long t12, t13;
    t12 = System.nanoTime();
    hola.busquedaSecuencial(hola.a7, 33);
    t13 = System.nanoTime();
    System.out.println("\nEl tiempo en nanosegundos es:");
    System.out.println(t13 - t12);

    long t14, t15;
    t14 = System.nanoTime();
    hola.busquedaSecuencial(hola.a8, 32);
    t15 = System.nanoTime();
    System.out.println("\nEl tiempo en nanosegundos es:");
    System.out.println(t15 - t14);

    long t16, t17;
    t16 = System.nanoTime();
    hola.busquedaSecuencial(hola.a9, 45);
    t17 = System.nanoTime();
    System.out.println("\nEl tiempo en nanosegundos es:");
    System.out.println(t17 - t16);

    long t18, t19;
    t18 = System.nanoTime();
    hola.busquedaSecuencial(hola.a10, 72);
    t19 = System.nanoTime();
    System.out.println("\nEl tiempo en nanosegundos es:");
    System.out.println(t1 - t0);

  }
}
