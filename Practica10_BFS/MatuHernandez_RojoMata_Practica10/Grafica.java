import java.util.LinkedList;

public class Grafica<T> {

    public class Vertice {
        public String identificador;
        public T elemento;
        public boolean visitado;

        /**
         * Constructor de la clase Vertice. Crea un nuevo vértice con el identificador y
         * elemento dados.
         *
         * @param identificador Identificador del vértice.
         * @param elemento      Elemento asociado al vértice.
         */        
        public Vertice( String identificador, T elemento ) {
            this.identificador = identificador;
            this.elemento = elemento;
        }

        /**
         * Devuelve el identificador del vértice.
         *
         * @return Identificador del vértice.
         */        
        public String darIdentificador() {
            return this.identificador;
        }
        
        /**
         * Devuelve el elemento asociado al vértice.
         *
         * @return Elemento asociado al vértice.
         */
        public T darElemento() {
            return this.elemento;
        }
        
        /**
         * Devuelve el estado de visitado del vértice.
         *
         * @return true si el vértice ha sido visitado, false en caso contrario.
         */
        public boolean darVisitado() {
            return this.visitado;
        }
        
        /**
         * Modifica el identificador del vértice.
         *
         * @param nuevoIdentificador Nuevo identificador del vértice.
         */
        public void modificarIdentificador( String nuevoIdentificador ) {
            this.identificador = nuevoIdentificador;
        }
        
        /**
         * Modifica el elemento asociado al vértice.
         *
         * @param nuevoElemento Nuevo elemento asociado al vértice.
         */
        public void modificarElemento( T nuevoElemento ) {
            this.elemento = nuevoElemento;
        }
        
        /**
         * Modifica el estado de visitado del vértice.
         *
         * @param nuevoVisitado Nuevo estado de visitado del vértice.
         */
        public void modificarVisitado( boolean nuevoVisitado ) {
            this.visitado = nuevoVisitado;
        }
        
        /**
         * Devuelve una representación en cadena del vértice en el formato
         * "<identificador, elemento, visitado>".
         *
         * @return Representación en cadena del vértice.
         */
        public String toString() {
            return "<" + 
                    this.identificador +
                    ", " +
                    this.elemento.toString() +
                    ", " +
                    Boolean.toString( this.visitado ) +
                    ">";
        }
    }
    
    public class Arista {
        public String u;
        public String v;
        
        /**
         * Constructor de la clase Arista. Crea una nueva arista con los vértices dados.
         *
         * @param u Identificador del primer vértice de la arista.
         * @param v Identificador del segundo vértice de la arista.
         */
        public Arista( String u, String v ) {
            this.u = u;
            this.v = v;
        }
        
        /**
         * Devuelve el identificador del primer vértice de la arista.
         *
         * @return Identificador del primer vértice.
         */
        public String darU() {
            return this.u;
        }
        
        /**
         * Devuelve el identificador del segundo vértice de la arista.
         *
         * @return Identificador del segundo vértice.
         */
        public String darV() {
            return this.v;
        }
        
        /**
         * Modifica el identificador del primer vértice de la arista.
         *
         * @param nuevoU Nuevo identificador del primer vértice.
         */
        public void modificarU ( String nuevoU ) {
            this.u = u;
        }
        
        /**
         * Modifica el identificador del segundo vértice de la arista.
         *
         * @param nuevoV Nuevo identificador del segundo vértice.
         */
        public void modificarV ( String nuevoV ) {
            this.v = v;
        }
        
        /**
         * Devuelve una representación en cadena de la arista en el formato "uv".
         *
         * @return Representación en cadena de la arista.
         */
        public String toString() {
            return this.u + this.v;
        }
    }
    
    private LinkedList<Vertice> vertices;
    private LinkedList<Arista> aristas;
    private int orden;
    private int tamano;
    
    /**
     * Constructor de la clase Grafica. Inicializa una nueva gráfica vacía sin vértices
     * ni aristas.
     */
    public Grafica() {
        this.vertices = new LinkedList<Vertice>();
        this.aristas = new LinkedList<Arista>();
        this.orden = 0;
        this.tamano = 0;
    }
    
    /**
     * Verifica si existe un vértice con el identificador dado en la gráfica.
     *
     * @param identificador Identificador del vértice a buscar.
     * @return true si existe un vértice con el identificador dado, false en caso
     *         contrario.
     */
    public boolean buscarVertice( String identificador ) {
        boolean encontrado = false;
        for( Vertice v : this.vertices ) {
            if( v.darIdentificador().equals( identificador ) ) {
                encontrado = true;
                break;
            }
        }
        return encontrado;
    }
    
    /**
     * Verifica si existe una arista entre los vértices con los identificadores u y
     * v.
     *
     * @param u Identificador del primer vértice.
     * @param v Identificador del segundo vértice.
     * @return true si existe una arista entre los vértices con los identificadores
     *         u y v, false en caso contrario.
     */
    public boolean buscarArista( String u, String v ) {
        boolean encontrada = false;
        for( Arista e : this.aristas ) {
            if( ( e.darU().equals( u ) && e.darV().equals( v ) ) || ( e.darU().equals( v ) && e.darV().equals( u ) ) ) {
                encontrada = true;
                break;
            }
        }
        return encontrada;
    }
    
    /**
     * Inserta un nuevo vértice con el identificador y elemento especificados en la
     * gráfica.
     *
     * @param identificador Identificador del nuevo vértice.
     * @param elemento      Elemento asociado al nuevo vértice.
     * @throws Exception Si el vértice con el identificador dado ya existe en la
     *                   gráfica, se lanza una excepción con un mensaje indicando el
     *                   error.
     */
    public void insertarVertice( String identificador, T elemento ) throws Exception {
        if( this.buscarVertice( identificador ) ) {
            throw new Exception( "El vertice ya existe." );
        }
        else {
            Vertice nuevoVertice = new Vertice( identificador, elemento );
            this.vertices.add( nuevoVertice );
            this.orden++;
        }
    }
    
    /**
     * Inserta una nueva arista entre los vértices con los identificadores u y v en
     * la gráfica.
     *
     * @param u Identificador del primer vértice de la arista.
     * @param v Identificador del segundo vértice de la arista.
     * @throws Exception Si la arista ya existe en la gráfica o alguno de los
     *                   vértices indicados no se encuentra en la gráfica, se lanza
     *                   una excepción con un mensaje indicando el error.
     */
    public void insertarArista( String u, String v ) throws Exception {
        if( this.buscarArista( u, v ) ) {
            throw new Exception( "La arista ya existe." );
        }
        else {
            if( !this.buscarVertice( u ) || !this.buscarVertice( v ) ) {
                throw new Exception( "Uno de los vertices indicados no existe." );
            }
            else {
                Arista nuevaArista = new Arista( u, v );
                this.aristas.add( nuevaArista );
                this.tamano++;
            }
        }
    }
    
    /**
     * Elimina el vértice con el identificador especificado de la gráfica, así como
     * todas las aristas que inciden en él.
     *
     * @param identificador Identificador del vértice que se desea eliminar.
     * @throws Exception Si el vértice con el identificador especificado no se
     *                   encuentra en la gráfica, se lanza una excepción con un
     *                   mensaje indicando el error.
     */
    public void eliminarVertice( String identificador ) throws Exception {
        if( this.buscarVertice( identificador ) == false ) {
            throw new Exception( "El vertice no existe." );
        }
        else {
            int i = 0;
            for( Vertice v : this.vertices ) {
                if( v.darIdentificador().equals( identificador ) ) {
                    break;
                }
                else {
                    i++;
                }
            }
            LinkedList<String> vecinos = this.darVecindad( identificador );
            this.vertices.remove( i );
            this.orden--;
            for( String v : vecinos ) {
                this.eliminarArista( identificador, v );
            }
        }
    }
    
    /**
     * Elimina la arista especificada por los identificadores de sus extremos de la
     * gráfica.
     *
     * @param u Identificador del primer vértice que forma la arista.
     * @param v Identificador del segundo vértice que forma la arista.
     * @throws Exception Si la arista especificada no se encuentra en la gráfica, se
     *                   lanza una excepción con un mensaje indicando el error.
     */
    public void eliminarArista( String u, String v ) throws Exception {
        if( this.buscarArista( u, v ) == false ) {
            throw new Exception( "La arista no existe." );
        }
        else {
            int i = 0;
            for( Arista e : this.aristas ) {
                if( ( e.darU().equals( u ) && e.darV().equals( v ) ) || ( e.darU().equals( v ) && e.darV().equals( u ) ) ) {
                    break;
                }
                else {
                    i++;
                }
            }
            this.aristas.remove( i );
            this.tamano--;
        }
    }
    
    /**
     * Busca un vértice en la gráfica utilizando su identificador.
     *
     * @param identificador El identificador del vértice que se desea buscar.
     * @return El vértice con el identificador especificado si se encuentra en la
     *         gráfica, o null si no se encuentra.
     * @throws Exception Si no se encuentra el vértice en la gráfica, se lanza una
     *                   excepción con un mensaje indicando el error.
     */
    public Vertice darVertice( String identificador ) throws Exception {
        if( this.buscarVertice( identificador ) == false ) {
            throw new Exception( "El vertice no existe." );
        }
        else {
            Vertice u = null;
            for( Vertice v : this.vertices ) {
                if( v.darIdentificador().equals( identificador ) ) {
                    u = v;
                    break;
                }
            }
            return u;
        }
    }
    
    /**
     * Obtiene la vecindad del vértice especificado en la gráfica. La vecindad de un
     * vértice son todos los vértices que están conectados a él por una arista.
     *
     * @param identificador El identificador del vértice del cual se desea conocer
     *                      la vecindad.
     * @return Una lista enlazada que contiene los identificadores de los vértices
     *         vecinos al vértice especificado.
     * @throws Exception Si el vértice con el identificador especificado no se
     *                   encuentra en la gráfica, se lanza una excepción con un
     *                   mensaje indicando el error.
     */
    public LinkedList<String> darVecindad( String identificador ) throws Exception {
        if( this.buscarVertice( identificador ) == false ) {
            throw new Exception( "El vertice NO existe." );
        }
        else {
            LinkedList<String> vecindad = new LinkedList<String>();
            for( Arista e : this.aristas ) {
                if( e.darU().equals( identificador ) || e.darV().equals( identificador ) ) {
                    if( e.darU().equals( identificador ) ) {
                        vecindad.add( e.darV() );
                    }
                    else {
                        vecindad.add( e.darU() );
                    }
                }
            }
            return vecindad;
        }
    }
    
    /**
     * Calcula el grado del vértice especificado en la gráfica. El grado de un
     * vértice es el número de aristas incidentes a él.
     *
     * @param identificador El identificador del vértice del cual se desea conocer
     *                      el grado.
     * @return El grado del vértice especificado.
     * @throws Exception Si el vértice con el identificador especificado no se
     *                   encuentra en la gráfica, se lanza una excepción con un
     *                   mensaje indicando el error.
     */
    public int darGrado( String identificador ) throws Exception {
        if( this.buscarVertice( identificador ) == false ) {
            throw new Exception( "El vertice no existe." );
        }
        else {
            LinkedList<String> vecindad = this.darVecindad( identificador );
            return vecindad.size();
        }
    }
    
    /**
     * Obtiene una lista enlazada que contiene todos los vértices presentes en la
     * gráfica.
     *
     * @return Una lista enlazada que contiene los vértices de la gráfica.
     */
    public LinkedList<Vertice> darVertices() {
        return this.vertices;
    }
    
    /**
     * Obtiene una lista enlazada que contiene todas las aristas presentes en la
     * gráfica.
     *
     * @return Una lista enlazada que contiene las aristas de la gráfica.
     */
    public LinkedList<Arista> darAristas() {
        return this.aristas;
    }
    
    /**
     * Obtiene el número total de vértices en la gráfica.
     *
     * @return El número total de vértices en la gráfica.
     */
    public int darOrden() {
        return this.orden;
    }
    
    /**
     * Obtiene el número total de aristas en la gráfica.
     *
     * @return El número total de aristas en la gráfica.
     */
    public int darTamano() {
        return this.tamano;
    }
    
    /**
     * Verifica si dos vertices son vecinos, es decir, si tienen una arista en comun.
     * @param u
     * @param v
     * @return
     */
    public boolean sonVecinos( String u, String v ) {
        return this.buscarArista( u, v );
    }
    
    /**
     * Obtiene el elemento asociado a un vértice dado su identificador.
     *
     * @param identificador Identificador del vértice.
     * @return Elemento asociado al vértice.
     * @throws Exception Si el vértice no existe en el grafo.
     */
    public T darElementoVertice( String identificador ) throws Exception {
        if( this.buscarVertice( identificador ) == false ) {
            throw new Exception( "El vertice no existe." );
        }
        else {
            Vertice v = this.darVertice( identificador );
            return v.darElemento();
        }
    }
    
    /**
     * Indica si un vértice dado ha sido visitado.
     *
     * @param identificador Identificador del vértice.
     * @return true si el vértice ha sido visitado, false en caso contrario.
     * @throws Exception Si el vértice no existe en el grafo.
     */
    public boolean darVisitadoVertice( String identificador ) throws Exception {
        if( this.buscarVertice( identificador ) == false ) {
            throw new Exception( "El vertice no existe." );
        }
        else {
            Vertice v = this.darVertice( identificador );
            return v.darVisitado();
        }
    }
    
    /**
     * Modifica el estado de visitado de un vértice.
     *
     * @param identificador   Identificador del vértice.
     * @param nuevoVisitado   Nuevo estado de visitado.
     * @throws Exception      Si el vértice no existe en el grafo.
     */
    public void modificarVisitadoVertice( String identificador, boolean nuevoVisitado ) throws Exception {
        if( this.buscarVertice( identificador ) == false ) {
            throw new Exception( "El vertice no existe." );
        }
        else {
            Vertice v = this.darVertice( identificador );
            v.modificarVisitado( nuevoVisitado );
        }
    }
    
    /**
     * Implementa el algoritmo de búsqueda en amplitud (BFS) a partir de un vértice dado.
     *
     * @param s Identificador del vértice de inicio.
     * @throws Exception Si el vértice de inicio no existe en el grafo.
     */
    public void algoritmoBFS(String s) throws Exception {
        // Verificar si el vértice de inicio existe
        Vertice inicio = darVertice(s);
        if (inicio == null) {
            throw new Exception("El vértice de inicio no existe en el grafo.");
        }

        // Inicializar todos los vértices como no visitados
        for (Vertice coso : this.vertices) {
            coso.modificarVisitado(false);
        }

        Cola<String> colaVisitados = new Cola<>();
        colaVisitados.encolar(s);
        inicio.modificarVisitado(true); // Marcar el vértice de inicio como visitado

        while (!colaVisitados.esVacia()) {
            String u = colaVisitados.darElementoInicio();
            colaVisitados.desencolar();
            LinkedList<String> adj_u = darVecindad(u);

            for (String v : adj_u) { // Mejor uso del bucle for-each
                Vertice w = darVertice(v);
                if (!w.darVisitado()) {
                    colaVisitados.encolar(v);
                    w.modificarVisitado(true); // Marcar al vértice como visitado cuando se encola
                }
            }
        }
    }
}
