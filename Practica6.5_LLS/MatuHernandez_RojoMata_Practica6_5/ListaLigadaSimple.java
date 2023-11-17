import java.util.Iterator;

/**
 * Implementación de una lista enlazada simple genérica.
 *
 * @param <T> El tipo de elementos almacenados en la lista.
 */
public class ListaLigadaSimple<T> implements Coleccion<T> {

    /**
     * Clase interna que representa un nodo en la lista enlazada simple.
     */
    private class Nodo {
        /**
         * Elemento almacenado en el nodo.
         */
        public T elemento;

        /**
         * Apuntador al siguiente nodo en la lista.
         */
        public Nodo siguiente;

        /**
         * Crea un nuevo nodo con el elemento proporcionado.
         *
         * @param elemento El elemento a almacenar en el nodo.
         */
        public Nodo(T elemento) {
            this.elemento = elemento;
            this.siguiente = null;
        }

        /**
         * Devuelve el elemento del nodo.
         *
         */
        public T darElemento(){
            return this.elemento;
        }

        /**
         * Devuelve el siguiente del nodo.
         *
         */
        public Nodo darSiguiente(){
            return this.siguiente;
        }

        /**
         * Modifica el elemento del nodo.
         *
         * @param elemento El elemento a almacenar en el nodo.
         */
        public void modificaElemeto(T elem){
            this.elemento = elem;
        }

        /**
         * Modifica el elemento del nodo.
         *
         * @param sig nodo a cambiar.
         */
        public void modificaSiguiente(Nodo sig){
            this.siguiente = sig;
        }
    }

    /**
     * Un iterador para recorrer la lista enlazada simple.
     */
    private class IteradorListaSimple implements Iterator<T> {
        /**
         * El nodo siguiente al que se moverá el iterador.
         */
        private Nodo iteradorLista;

        /**
         * Crea un nuevo iterador y lo inicializa en el primer nodo de la lista.
         */
        public IteradorListaSimple() {
            iteradorLista = new Nodo(null);
            iteradorLista.siguiente = cabeza;
        }

        /**
         * Verifica si hay un siguiente elemento en la lista.
         *
         * @return true si hay un siguiente elemento, false de lo contrario.
         */
        public boolean hasNext() {
            return iteradorLista.siguiente != null;
        }

        /**
         * Obtiene el siguiente elemento en la lista y mueve el iterador al siguiente nodo.
         *
         * @return El siguiente elemento en la lista.
         */
        public T next() {
            iteradorLista = iteradorLista.siguiente;
            return iteradorLista.elemento;
        }
    }

    // Atributos de la clase principal
    private Nodo cabeza;
    private Nodo rabo;
    private int longitud;

    /**
     * Constructor de la lista enlazada simple.
     */
    public ListaLigadaSimple() {
        cabeza = null;
        rabo = null;
        longitud = 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<T> iterator() {
        return new IteradorListaSimple();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void insertar(T elemento) throws IllegalArgumentException {
        if (elemento == null){
            throw new IllegalArgumentException("El elemento no puede ser nulo");
        }

        Nodo nodoAgregado = new Nodo(elemento);
        Nodo cabezaAnterior = this.cabeza;
        nodoAgregado.siguiente = cabezaAnterior;
        this.cabeza = nodoAgregado;
        this.longitud ++;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T acceder(int i) throws IllegalArgumentException {
        if(this.longitud <= i || i < 0){
            throw new IllegalArgumentException("Índice no válido");
        }

        Nodo nodoActual = this.cabeza;
        for(int j = 0; j < i; j++){
            nodoActual = nodoActual.siguiente;
        }

        return nodoActual.elemento;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean buscar(T elemento) {
        Nodo nodoActual = this.cabeza;

        while (nodoActual != null) {
            if (nodoActual.elemento.equals(elemento)) {
                return true;
            }
            nodoActual = nodoActual.siguiente;
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void eliminar(int i) {
        if (i < 0 || i >= this.longitud ) {
            throw new IllegalArgumentException("Índice inválido");
        }

        Nodo nodoActual = this.cabeza;
        Nodo nodoAnterior = null;

        for (int j = 0; j < i; j++) {
            nodoAnterior = nodoActual;
            nodoActual = nodoActual.siguiente;
        }

        if (nodoAnterior == null) {
            // Si el nodo a eliminar es la cabeza
            this.cabeza = nodoActual.siguiente;
        } else {
            nodoAnterior.siguiente = nodoActual.siguiente;
            if (nodoActual.siguiente == null) {
                // Si el nodo a eliminar es el rabo
                this.rabo = nodoAnterior;
            }
        }

        this.longitud--;
    }


    public int darLongitud() {
        return this.longitud;
    }

    /**
     * Obtiene el primer nodo de la lista.
     *
     * @return El primer nodo de la lista.
     */
    public Nodo darCabeza() {
        return this.cabeza;
    }

    /**
     * Obtiene el elemento almacenado en el primer nodo de la lista.
     *
     * @return El elemento almacenado en el primer nodo de la lista.
     */
    public T darCabezaElemento() {
        return this.cabeza.elemento;
    }

    /**
     * Obtiene el último nodo de la lista.
     *
     * @return El último nodo de la lista.
     */
    public Nodo getRabo() {
        return this.rabo;
    }

    /**
     * Obtiene el elemento almacenado en el último nodo de la lista.
     *
     * @return El elemento almacenado en el último nodo de la lista.
     */
    public T getRaboElemento() {
        return this.rabo.elemento;
    }
}
