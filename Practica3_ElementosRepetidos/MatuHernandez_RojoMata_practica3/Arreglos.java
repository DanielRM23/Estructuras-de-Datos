
public class Arreglos {
  static public int[] arr5 = { -1, 3, 3, 3, 3 };
  static public int[] arr10 = { 2, 7, 7, 8, 8, 11, 11, 16, 16, 18 };
  static public int[] arr15 = { 2, 2, 3, 5, 5, 7, 9, 9, 10, 10, 12, 12, 14, 17, 17 };
  static public int[] arr20 = { 0, 0, 0, 0, 0, 1, 2, 3, 3, 3, 5, 5, 6, 7, 8, 8, 8, 8, 8, 9, 10 };
  static public int[] arr25 = { 1, 2, 2, 2, 2, 3, 3, 3, 4, 5, 5, 6, 6, 7, 7, 8, 9, 9, 10, 10, 11, 11, 12,
      13, 14, 15, 16, 17, 18, 19, 20, 20, 21, 21, 21, 21, 21, 23, 23, 23, 23, 23, 24, 25 };

  /**
   * Imprime un arreglo
   * 
   * @param arr el arreglo a imprimir
   */
  public static void printArray(int[] arr) {
    System.out.print("[");
    for (int i = 0; i < arr.length - 1; i++)
      System.out.printf("%d,", arr[i]);
    System.out.printf("%d]\n", arr[arr.length - 1]);
  }
}