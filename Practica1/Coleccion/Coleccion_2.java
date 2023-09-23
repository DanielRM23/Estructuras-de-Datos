
// Esto define la interfaz que se requiere con el tipo de dato genérico T.
public interface Coleccion<T> {

    // Método insertar: Inserta un elemento a la colección
    void insertar(T elemento);
    // Método eliminar: Elimina un elemento de la colección
    void eliminar(T elemento);
    // Método acceder: Accede a un elemento dada su posición
    T acceder(T elemento);
    // Método buscar: Determina si un elemento está o no en la colección 
    boolean buscar(T elemento);  
    
    // Se definen dos métodos extras.
    // tamanio: Devuelve el tamaño de la estructura
    /**
     * tamnio
     * regesa el rmno
     * @param T elemento el elemento a buscar
     * @return el tamano
     */
    int tamanio();
    // estaVacia: Nos dice si la estructura está vacia o no
    boolean estaVacia(); 
}
