public class Prueba {

    public static void main(String[] Holaaaa) {

        // Se generan los arreglos con los cuales se crean los conjuntos
        int[] elementos = new int[] { 1, 2, 3, 4, 5 };
        int[] elementos2 = new int[] { 2, 3, 6, 10 };

        // Se definen los dos conjuntos
        Conjunto A = new Conjunto(elementos);
        Conjunto B = new Conjunto(elementos2);

        // Se comprueban los métodos correspondientes
        System.out.println(A.esVacio());
        System.out.println(A.pertenencia(0));
        System.out.println(A.subConjunto(B));
        System.out.println(A.diferencia(B));
        System.out.println(A.union(B));
        System.out.println(A.interseccion(B));
    }
}