public class Prueba {

    public static void main(String[] args) {
        Cola<Integer> cola = new Cola<>();

        try {
            System.out.println("La cola está vacía: " + cola.esVacia());
            cola.encolar(1);
            cola.encolar(2);
            cola.encolar(3);
            System.out.println("El incio de la cola es: " + cola.darElementoInicio());
            System.out.println("La cola está vacía: " + cola.esVacia());
            System.out.println("La longitud de la cola es: " + cola.darLongitud());

            cola.desencolar();
            System.out.println("Desencolado un elemento.");
            System.out.println("El inicio de la cola es: " + cola.darElementoInicio());
            System.out.println("La longitud de la cola es: " + cola.darLongitud());
        } catch (Exception e) {
            System.out.println("Excepción: " + e.getMessage());
        }
    }
}
