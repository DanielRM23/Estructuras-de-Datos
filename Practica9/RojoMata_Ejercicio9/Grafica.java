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
        public Vertice(String identificador, T elemento) {
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
        public void modificarIdentificador(String nuevoIdentificador) {
            this.identificador = nuevoIdentificador;
        }

        /**
         * Modifica el elemento asociado al vértice.
         *
         * @param nuevoElemento Nuevo elemento asociado al vértice.
         */
        public void modificarElemento(T nuevoElemento) {
            this.elemento = nuevoElemento;
        }

        /**
         * Modifica el estado de visitado del vértice.
         *
         * @param nuevoVisitado Nuevo estado de visitado del vértice.
         */
        public void modificarVisitado(boolean nuevoVisitado) {
            this.visitado = nuevoVisitado;
        }

        /**
         * Devuelve una representación en cadena del vértice en el formato
         * "<identificador, elemento, visitado>".
         *
         * @return Representación en cadena del vértice.
         */
        @Override
        public String toString() {
            return "<" +
                    this.identificador +
                    ", " +
                    this.elemento.toString() +
                    ", " +
                    Boolean.toString(this.visitado) +
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
        public Arista(String u, String v) {
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
        public void modificarU(String nuevoU) {
            this.u = nuevoU;
        }

        /**
         * Modifica el identificador del segundo vértice de la arista.
         *
         * @param nuevoV Nuevo identificador del segundo vértice.
         */
        public void modificarV(String nuevoV) {
            this.v = nuevoV;
        }

        /**
         * Devuelve una representación en cadena de la arista en el formato "uv".
         *
         * @return Representación en cadena de la arista.
         */
        @Override
        public String toString() {
            return this.u + this.v;
        }

    }

    private LinkedList<Vertice> vertices;
    private LinkedList<Arista> aristas;
    private int orden;
    private int tamano;

    /**
     * Constructor de la clase Grafica. Inicializa una nueva gráfica vacía sin
     * vértices
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
    public boolean buscarVertice(String identificador) {
        boolean encontrado = false;
        for (Vertice v : this.vertices) {
            if (v.darIdentificador().equals(identificador)) {
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
    public boolean buscarArista(String u, String v) {
        boolean encontrada = false;
        for (Arista e : this.aristas) {
            if ((e.darU().equals(u) && e.darV().equals(v)) || (e.darU().equals(v) && e.darV().equals(u))) {
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
    public void insertarVertice(String identificador, T elemento) throws Exception {
        if (this.buscarVertice(identificador)) {
            throw new Exception("El vertice ya existe.");
        } else {
            Vertice nuevoVertice = new Vertice(identificador, elemento);
            this.vertices.add(nuevoVertice);
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
    public void insertarArista(String u, String v) throws Exception {
        if (this.buscarArista(u, v)) {
            throw new Exception("La arista ya existe.");
        } else {
            if (!this.buscarVertice(u) || !this.buscarVertice(v)) {
                throw new Exception("Uno de los vertices indicados no existe.");
            } else {
                Arista nuevaArista = new Arista(u, v);
                this.aristas.add(nuevaArista);
                this.tamano++;
            }
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
     * Elimina el vértice con el identificador especificado de la gráfica, así como
     * todas las aristas que inciden en él.
     *
     * @param identificador Identificador del vértice que se desea eliminar.
     * @throws Exception Si el vértice con el identificador especificado no se
     *                   encuentra en la gráfica, se lanza una excepción con un
     *                   mensaje indicando el error.
     */
    public void eliminarVertice(String identificador) throws Exception {
        // Busco el vértice
        Vertice verticeAEliminar = null;
        for (Vertice vertice : vertices) {
            if (vertice.darIdentificador().equalsIgnoreCase(identificador)) {
                verticeAEliminar = vertice;
                break;
            }
        }
        // Si encuentro el vértice con el identificador dado
        if (verticeAEliminar != null) {
            // Creo una nueva lista de aristas sin las que inciden en el vértice a eliminar
            LinkedList<Arista> nuevasAristas = new LinkedList<>();
            for (Arista arista : aristas) {
                if (!arista.darU().equalsIgnoreCase(identificador) && !arista.darV().equalsIgnoreCase(identificador)) {
                    nuevasAristas.add(arista);
                }
            }
            // Actualizo la lista de aristas y remuevo el vértice de la lista de vértices
            aristas = nuevasAristas;
            vertices.remove(verticeAEliminar);
        } else {
            // No encontré el vértice en la gráfica
            throw new Exception("No se encontró el vértice");
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
    public void eliminarArista(String u, String v) throws Exception {
        // Buscar la arista
        Arista aristaAEliminar = null;
        for (Arista arista : this.aristas) {
            if ((arista.darU().equalsIgnoreCase(u) && arista.darV().equalsIgnoreCase(v)) ||
                    (arista.darU().equalsIgnoreCase(v) && arista.darV().equalsIgnoreCase(u))) {
                aristaAEliminar = arista;
                break;
            }
        }
        // Si encuentro la arista, la elimino
        if (aristaAEliminar != null) {
            this.aristas.remove(aristaAEliminar);
            this.tamano--; // Decremento el tamaño de la gráfica
        } else {
            throw new Exception("No se encontró la arista");
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
    public LinkedList<String> darVecindad(String identificador) throws Exception {
        LinkedList<String> vecinos = new LinkedList<>();
        // Busco el vértice
        if (buscarVertice(identificador)) {
            // Para las aristas de la gráfica, veo si inciden en el vérticeActual
            for (Arista arista : aristas) {
                if (arista.darU().equals(identificador) || arista.darV().equals(identificador)) {
                    // Si la arista incide en el vértice, agrego el otro extremo a la lista de
                    // vecinos
                    String vecino = arista.darU().equals(identificador) ? arista.darV() : arista.darU();
                    vecinos.add(vecino);
                }
            }
        } else {
            // No encontré el vértice en la gráfica
            throw new Exception("No se encontró el vértice");
        }
        // Devuelvo los vecinos
        return vecinos;
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
    public int darGrado(String identificador) throws Exception {
        // Busco el vértice
        if (buscarVertice(identificador)) {
            // Obtengo la vecindad del vértice y retorno el tamaño de la lista, que
            // representa el grado
            LinkedList<String> vecindad = darVecindad(identificador);
            return vecindad.size();
        } else {
            // No encontré el vértice en la gráfica
            throw new Exception("No se encontró el vértice");
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
    public Vertice darVertice(String identificador) throws Exception {
        // Busco el vértice
        if (buscarVertice(identificador)) {
            // Encontré el vértice en la gráfica y lo devuelvo
            Vertice verticeBuscado = null;
            for (int i = 0; i < this.vertices.size(); i++) {
                if (this.vertices.get(i).darIdentificador().equalsIgnoreCase(identificador)) {
                    verticeBuscado = this.vertices.get(i);
                    break;
                }
            }
            return verticeBuscado;
        } else {
            throw new Exception("No se encontró el vértice");
        }
    }

    /**
     * Verifica si existen una arista entre los vértices con los identificadores u y
     * v.
     *
     * @param u Identificador del primer vértice.
     * @param v Identificador del segundo vértice.
     * @return true si existe una arista entre los vértices con los identificadores
     *         u y v, false en caso contrario.
     */
    public static boolean sonVecinos(String identificador1, String identificador2, Grafica grafica) {
        return grafica.buscarArista(identificador1, identificador2);
    }

    /**
     * Devuelve la matriz de adyacencias de la gráfica.
     *
     * @param grafica Instancia de la clase Grafica que contiene los vértices y
     *                aristas.
     * @return Matriz de adyacencias de la gráfica.
     */
    public static int[][] regresaMatrizAdyacencias(Grafica grafica) {
        LinkedList<Grafica.Vertice> vertices = grafica.darVertices();
        int nVertices = vertices.size();
        int[][] matriz = new int[nVertices][nVertices];

        for (int i = 0; i < nVertices; i++) {
            for (int j = 0; j < nVertices; j++) {
                if (sonVecinos(vertices.get(i).darIdentificador(), vertices.get(j).darIdentificador(), grafica)) {
                    matriz[i][j] = 1;
                } else {
                    matriz[i][j] = 0;
                }
            }
        }
        return matriz;
    }

}
