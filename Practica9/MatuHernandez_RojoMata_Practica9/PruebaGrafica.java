import java.util.LinkedList;

/**
 * Clase de prueba. Permite probar y demostrar el
 * funcionamiento de la implementación de una gráfica con vértices y aristas.
 */
public class PruebaGrafica {

    /**
     * Método principal para ejecutar las pruebas en la gráfica.
     *
     * @param args Argumentos de línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        // Crear una nueva gráfica
        Grafica g = new Grafica();

        try {
            // Insertar vértices y aristas en la gráfica
            g.insertarVertice("v1", 5);
            g.insertarVertice("v2", 7);
            g.insertarVertice("v3", 9);
            g.insertarVertice("v4", 2);
            g.insertarVertice("v5", 0);
            g.insertarArista("v1", "v3");
            g.insertarArista("v1", "v5");
            g.insertarArista("v2", "v3");
            g.insertarArista("v2", "v4");
            g.insertarArista("v4", "v3");
            g.insertarArista("v5", "v2");

            // Imprimir información inicial de la gráfica
            System.out.println("G := (V, E), donde");
            imprimirGrafica(g);

            // Probar darVecindad
            String identificador = "v1";
            LinkedList<String> vecindad = g.darVecindad(identificador);
            System.out.println("Vecindad de " + identificador + ": " + vecindad);

            // Probar darGrado
            int grado = g.darGrado(identificador);
            System.out.println("Grado de " + identificador + ": " + grado);

            // Obtener y mostrar información del vértice
            System.out.println("Vértice " + identificador + ": " + g.darVertice(identificador));

            // Eliminar vértice y arista
            String verticeAEliminar = "v1";
            g.eliminarVertice(verticeAEliminar);
            String u = "v2";
            String v = "v3";
            g.eliminarArista(u, v);

            // Imprimir información después de eliminar vértice y arista
            System.out
                    .println("\nGráfica después de eliminar el vértice " + verticeAEliminar + " y la arista " + u + v);
            imprimirGrafica(g);

        } catch (Exception error) {
            // Capturar y mostrar cualquier excepción lanzada durante las operaciones en la
            // gráfica
            System.out.println(error);
        }
    }

    /**
     * Imprime la representación en cadena de una gráfica dada, mostrando sus
     * vértices y aristas.
     *
     * @param grafica Gráfica que se desea imprimir.
     */
    public static void imprimirGrafica(Grafica<Integer> grafica) {
        LinkedList<Grafica<Integer>.Vertice> vertices = grafica.darVertices();
        LinkedList<Grafica<Integer>.Arista> aristas = grafica.darAristas();
        int orden = grafica.darOrden();
        int tamano = grafica.darTamano();

        System.out.print("V := { ");
        int i = 1;
        for (Grafica<Integer>.Vertice v : vertices) {
            if (i != orden) {
                System.out.print(v.toString() + ", ");
                i++;
            } else {
                System.out.println(v.toString() + " }");
            }
        }

        System.out.print("E := { ");
        int j = 1;
        for (Grafica<Integer>.Arista e : aristas) {
            if (j != tamano) {
                System.out.print(e.toString() + ", ");
                j++;
            } else {
                System.out.println(e.toString() + " }");
            }
        }
    }
}
