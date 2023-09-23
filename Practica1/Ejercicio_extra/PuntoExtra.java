public class PuntoExtra {

  // Constructor vacío
  public PuntoExtra() {}

  // Con este método se calcula el área de cada cosos que ingresa en el arreglo figuras
  public double[] Areas(Figuras[] figuras) {
      // Se define un arreglo en el cual se guardan las áreas de las figuras
      double[] areas_finales = new double[figuras.length];
      // Se calcula el área de cada coso
      for (int i = 0; i < figuras.length; i++) {
          // Se guarda el área en el arreglo vacío 
          areas_finales[i] = figuras[i].area();
      }
      // Se regresa el área de los cosos en el arreglo
      return areas_finales;
  }


  public static void main(String[] args) {

      //  Se definen las figuras
      Figuras triangulo = new Figuras(3, 2, 1);
      Figuras cuadrado = new Figuras(4, 1, 1);
      // Esto es un circulo, por simplicidad; base = radio
      Figuras circulo = new Figuras(0, 1, 0);

      // Se guardan las figuras anteriores en un array
      Figuras[] figs = new Figuras[]{triangulo, cuadrado, circulo};

      PuntoExtra prueba = new PuntoExtra();

      // Aquí están las áreas de los cosos
      double[] areas = prueba.Areas(figs);

      // Imprimir las áreas calculadas
      System.out.println("Las áreas de las figuras son: ");
      for (double area : areas) {
          System.out.println(area);
      }
  }
}
