public class calculadora{

    // Atributos de la calculadora 
    boolean esCientifica; 
    String marca; 
    int precio; 
    String modelo; 

    // Método constructor
    public calculadora(boolean esCientifica, String marca, int precio, String modelo){
        this.esCientifica = esCientifica; 
        this.marca = marca;
        this.precio = precio;
        this.modelo = modelo; 

    }

    // Representación en cadena de un objeto 
    public String toString(){
        return modelo;
    }

    // Función que suma dos números dados
    public int sumar(int x, int y){
        return x + y ;
    }   

    // Función que proporciona el factorial de un número dado 
    public int fact(int n){
        if(n==0){
            return 1;
        }
        else if(n > 0){
            return n*fact(n-1);
        }
        // Esto es para que el programa no se rompa
        return 0;
    }

    // Otro método para calcular el factorial
    public fact2(int n){
        int f = 1; 
        for(int i = n; i > 0; i--){
            f *= i; 
        }
        return f; 
    }   

}