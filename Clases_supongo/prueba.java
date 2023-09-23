public class prueba{

    public static void main(String[] args) {
     
        calculadora calcu = new calculadora(false, "esta es la marca", 0, "este es el modelo");
        System.out.println(calcu.sumar(0, 0));
        System.out.println(calcu.fact2(5));
    }
}