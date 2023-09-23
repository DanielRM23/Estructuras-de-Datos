public interface Colección<T> {

  /**
  * Insertar
  *Agrega un elemento
  *@param elemento
  */
  void Insertar (T elemento);

  /**
  * Eliminar
  * Elimina un elemento
  *@param elemento
  */
  void Eliminar (T elemento);

  /**
  * Acceder 
  *devuelve un elemento a partir de su posición
  *@Param elemento 
  *@return T 
  */
  T Acceder (T elemento);

  /** 
  * Buscar
  *devuelve true o flase dependiendo de si el elemento está o no
  *@Param elemento 
  *@return boolean
  */
  boolean Buscar (T elemento);
  
  /**
  *Tamanio
  *devuelve el tamaño de la colección
  *@return int
  */
  int Tamanio ();

  /*
  *Esvacio
  *devuelve true si la colección es vacia y false si tiene elementos
  *@return boolean
  */
  boolean Esvacio ();

}