public class Figuras {

    // Atributos de los cosos
    int lados;
    double base;
    double altura;

    // Constructor
    Figuras(int lados, double base, double altura) {
        this.lados = lados;
        this.base = base;
        this.altura = altura;
    }

    // Métodos get
    public int get_lados() {
        return lados;
    }
    public double get_altura() {
        return altura;
    }
    public double get_base() {
        return base;
    }

    // Método que calcula algunas áreas de ciertas figuras
    public double area() {
        // Triangulo
        if (lados == 3) {
            double area = (base * altura) / 2;
            return area;
        // Cuadrado
        } else if (lados == 4) {
            double area = base * altura;
            return area;
        // Circulo
        } else if (lados == 0) {
            double area = 3.1416 * (base * base);
            return area;
        }
        return -1; // Valor de retorno por defecto o manejo de caso no válido
    }
}
