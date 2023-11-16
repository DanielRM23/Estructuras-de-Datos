import java.util.Arrays;
import java.util.LinkedList;

/**
 * Clase de prueba para la generación y manipulación de una gráfica, así como la
 * representación de su matriz de adyacencia.
 */
public class PruebaMatriz {

  /**
   * Crea una representación en forma de cadena de la matriz de adyacencia de la
   * gráfica.
   *
   * @param verticesM Lista de identificadores de los vértices en la gráfica.
   * @param matriz    Matriz de adyacencia de la gráfica.
   * @return Cadena que representa la matriz de adyacencia.
   */
  public static String imprimeMatriz(LinkedList<String> verticesM, int[][] matriz) {
    String matAux = "";
    for (String ver : verticesM) {
      matAux = matAux + "     " + ver;
    }
    for (int i = 0; i < verticesM.size(); i++) {
      matAux = matAux + "\n" + verticesM.get(i);
      for (int j = 0; j < verticesM.size(); j++) {
        matAux = matAux + "  [ " + matriz[i][j] + " ]";
      }
    }
    return matAux;
  }

  /**
   * Método principal para ejecutar las pruebas en la gráfica y la generación de
   * la matriz de adyacencia.
   *
   * @param args Argumentos de línea de comandos (no se utilizan).
   */
  public static void main(String[] args) {
    // LinkedList<String> lista = new LinkedList<String>();
    // lista.add("v1");
    // lista.add("v2");
    // lista.add("v3");
    // lista.add("v4");
    // lista.add("v5");
    // int[][] mat = { { 0, 0, 0, 0, 0 }, { 1, 1, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 0,
    // 1, 0, 1, 0 }, { 0, 0, 0, 0, 0 } };
    // System.out.println(imprimeMatriz(lista, mat));

    Grafica<Integer> g = new Grafica<>();

    try {
      // Insertar vértices y aristas en la gráfica
      // Insertar 10 vértices en la gráfica
      for (int i = 1; i <= 10; i++) {
        String vertice = "v" + i;
        int valor = i * 2; // Valor arbitrario para el vérticePráctica
        g.insertarVertice(vertice, valor);
      }

      // Insertar aristas entre los vértices
      g.insertarArista("v1", "v3");
      g.insertarArista("v1", "v5");
      g.insertarArista("v2", "v3");
      g.insertarArista("v2", "v4");
      g.insertarArista("v4", "v3");
      g.insertarArista("v5", "v2");
      g.insertarArista("v6", "v8");
      g.insertarArista("v6", "v10");
      g.insertarArista("v7", "v9");
      g.insertarArista("v8", "v10");

      // Imprimir información inicial de la gráfica
      System.out.println("G := (V, E), donde");
      PruebaGrafica.imprimirGrafica(g);

      // Probar darVecindad
      String identificador1 = "v1";
      String identificador2 = "v2";

      // Probar sonVecinos
      System.out.println(Grafica.sonVecinos(identificador1, identificador2, g));

      // Probar regresaMatrizAdyacencias
      int[][] matriz = Grafica.regresaMatrizAdyacencias(g);
      System.out.println("\n\n Matriz de Adyacencias: \n");
      System.out.print(imprimeMatriz(
          new LinkedList<>(Arrays.asList("v1", "v2", "v3", "v4", "v5", "v6", "v7", "v8", "v9", "v10")), matriz));

    } catch (Exception error) {
      // Capturar y mostrar cualquier excepción lanzada durante las operaciones en la
      // gráfica
      System.out.println(error);
    }
  }
}
