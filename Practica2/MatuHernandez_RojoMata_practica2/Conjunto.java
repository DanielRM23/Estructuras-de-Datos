import java.util.*;

public class Conjunto {

  int[] elementos;

  /*
   * Metodo constructor
   * 
   * @param int[] elementos
   * Recibe un arreglo de enteros
   */
  public Conjunto(int[] elementos2) {
    if (elementos2.length == 0) {
      this.elementos = elementos2;
    } else {
      List<Integer> listaSinRepetidos = new ArrayList<>();
      for (int x : elementos2) {
        if (!listaSinRepetidos.contains(x)) {
          listaSinRepetidos.add(x);
        }
      }
      List<Integer> listaSinNeg = new ArrayList<>();
      for (int z : listaSinRepetidos) {
        if (z > 0) {
          listaSinNeg.add(z);
        }
      }
      int[] elementosAux = new int[listaSinNeg.size()];
      int cont = 0;
      for (int y : listaSinNeg) {
        elementosAux[cont] = y;
        cont++;
      }
      this.elementos = elementosAux;
    }
  }

  /*
   * Metodo esVacio: verifica si el arreglo dado es vacio o tiene elementos
   * devuelve true si el arreglo es vacio y false si tiene elementos
   * 
   * @return boolean
   */
  public boolean esVacio() {
    // Aqui va tu codigo
    if (this.elementos.length == 0) {
      return true;
    } else {
      return false;
    }
  }

  /*
   * metodo pertenencia: determina si x se encuentra en el arreglo
   * 
   * @param x
   * recibe un entero llamado x
   * 
   * @return boolean
   * devuelve true si x si se encuentra en el arreglo y false si no lo está
   */
  public boolean pertenencia(int x) {
    // Aqui va tu codigo
    for (int i = 0; i < this.elementos.length; i++) {
      if (this.elementos[i] == x) {
        return true;
      }
    }
    return false;
  }

  /*
   * Método subConjunto: verifica si un conjunto pertenece a otro
   * 
   * @param Conjunto c
   * 
   * @return boolean
   * Devuelve true si "this" pertenece a "c"
   */
  public boolean subConjunto(Conjunto c) {
    // Aqui va tu codigo
    int cardinalidad_1 = c.elementos.length;
    int cardinalidad_2 = this.elementos.length;

    if (cardinalidad_2 <= cardinalidad_1) {
      for (int i = 0; i < cardinalidad_2; i++) {
        this.pertenencia(i);
      }
      return true;
    } else {
      return false;
    }

  }

  /*
   * Metodo diferencia: encuentra la diferencia de los conjuntos
   * 
   * @param conjunto c
   * 
   * @return conjunto
   * Devuelve el conjunto cuyos elementos son los valores que pertenecen a 'this'
   * pero no pertenecen a 'c'
   */

  public Conjunto diferencia(Conjunto c) {
    // Aqui va tu codigo
    int[] conjunto_prueba = new int[this.elementos.length];
    int tamanio = 0;

    for (int elemento : this.elementos) {
      if (!c.pertenencia(elemento)) {
        conjunto_prueba[tamanio] = elemento;
        tamanio++;
      }
    }

    int[] conjunto_diferencia = new int[tamanio];
    for (int i = 0; i < tamanio; i++) {
      conjunto_diferencia[i] = conjunto_prueba[i];
    }

    return new Conjunto(conjunto_diferencia);
  }

  /*
   * Metodo union: une dos conjuntos
   * 
   * @param Conjunto c
   * 
   * @return conjunto
   * Devuelve el conjunto cuyos elementos son la unión de 'this' con 'c'
   */
  public Conjunto union(Conjunto c) {
    // Aqui va tu codigo
    int tamanio_1 = c.elementos.length;
    int tamanio_2 = this.elementos.length;
    int tamanio = tamanio_1 + tamanio_2;

    int[] conjunto_union = new int[tamanio];

    // Copia los elementos del primer conjunto al conjunto_union
    for (int i = 0; i < tamanio_1; i++) {
      conjunto_union[i] = c.elementos[i];
    }

    // Copia los elementos del segundo conjunto al conjunto_union
    for (int i = tamanio_1; i < tamanio; i++) {
      conjunto_union[i] = this.elementos[i - tamanio_1];
    }

    return new Conjunto(conjunto_union);

  }

  /*
   * metodo interseccion: Dice que elementos de los conjuntos pertenecen a ambos
   * 
   * @param Conjunto c
   * 
   * @return Conjunto
   * Devuelve el conjunto cuyos elementos pertenecen a 'this' y a 'c'
   */
  public Conjunto interseccion(Conjunto c) {
    // Aqui va tu codigo
    int[] conjunto_prueba = new int[this.elementos.length];
    int tamanio = 0;

    for (int elemento : this.elementos) {
      if (c.pertenencia(elemento)) {
        conjunto_prueba[tamanio] = elemento;
        tamanio++;
      }
    }

    int[] conjunto_final = new int[tamanio];
    for (int i = 0; i < tamanio; i++) {
      conjunto_final[i] = conjunto_prueba[i];
    }
    return new Conjunto(conjunto_final);
  }

  /*
   * metodo toString
   * 
   * @return string
   * Devuelve el conjunto
   */
  public String toString() {
    String s = "{";
    for (int i = 0; i < this.elementos.length; i++) {
      if (i == 0) {
        s = s + this.elementos[i];
      } else {
        s = s + "," + this.elementos[i];
      }
    }
    s = s + "}";
    return s;
  }

}
