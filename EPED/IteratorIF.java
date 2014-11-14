public interface IteratorIF<T>
{
    /**
    * Devuelve el siguiente elemento de la iteracion.
    * @return el siguiente elemento de la iteracion.
    */
    public T getNext ();
    /**
    * Devuelve el siguiente elemento de la iteracion.
    * @return el siguiente elemento de la iteracion.
    */
    public boolean hasNext ();
    /**
    * Restablece el iterador para volver al inicio.
    */
    public void reset ();
}