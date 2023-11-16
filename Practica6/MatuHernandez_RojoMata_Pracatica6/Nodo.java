/*
 * Clase que representa un nodo de una lista
 * ligada.
 */
public class Nodo<T> {

    private T elemento;
    private Nodo<T> siguiente;

    /**
     * Construye un nodo
     * con un objeto
     *
     * @param e El contenido del nodo.
     */
    public Nodo(T e) {
        elemento = e;
        siguiente = null;
    }

    /**
     * Construye un nodo con un objeto
     * y una referencia al siguiente nodo.
     *
     * @param e El contenido del nodo.
     * @param sig Referencia al siguiente.
     */
    public Nodo(T e, Nodo<T> sig) {
        elemento = e;
        siguiente = sig;
    }

    /**
     * Establece el nuevo contenido del nodo
     *
     * @param nvo El objeto nuevo.
     */
    public void modificarElemento(T nvo) {
        elemento = nvo;
    }

    /**
     * Devuelve el contenido del nodo.
     *
     * @return El contenido.
     */
    public T darElemento() {
        return elemento;
    }

    /**
     * Establece una nueva referencia al
     * nodo siguiente.
     *
     * @param sig La referencia nueva
     * al siguiente nodo.
     */
    public void modificarSiguiente(Nodo<T> sig) {
        siguiente = sig;
    }

    /**
     * Devuelve la referencia al siguiente
     * nodo.
     *
     * @return La referencia al siguiente nodo.
     */
    public Nodo<T> darSiguiente() {
        return siguiente;
    }

    
    // Ejemplo de la implementación de un nodo con elemento 1
    public static void main(String[] args) {
        // Crear una instancia de Nodo con un entero (por ejemplo, 1)
        Nodo<Integer> nodo = new Nodo<>(1);
        System.out.println(nodo.darElemento());
    }
    
}

