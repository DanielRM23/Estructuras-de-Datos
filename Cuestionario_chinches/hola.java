class Persona {
    String nombre;

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Persona: " + nombre;
    }
}

class Coche {
    String modelo;

    public Coche(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Coche: " + modelo;
    }
}

public class hola {
    public static void main(String[] args) {
        Object[] arreglo = new Object[5];
        arreglo[0] = new Persona("jose");
        arreglo[3] = new Coche("Mustang");

        for (int i = 0; i < arreglo.length; i++) {
            System.out.println(arreglo[i]);
        }
    }
}
