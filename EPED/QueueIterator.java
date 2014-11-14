public class QueueIterator<T> implements IteratorIF<T>
{
    private QueueIF<T> handler;
    private QueueIF<T> restart;
    
    public QueueIterator(QueueIF<T> handler)
    {
        this.handler = handler;
        this.restart = handler;
    }
    
    /**
    * Devuelve el siguiente elemento de la iteracion.
    * @return el siguiente elemento de la iteracion.
    */
    public T getNext ()
    {
        T next = handler.getFirst();
        handler = handler.remove();
        return next;
    }
    
    /**
    * Devuelve el siguiente elemento de la iteracion.
    * @return el siguiente elemento de la iteracion.
    */
    public boolean hasNext ()
    {
        return !handler.isEmpty();
    }
    /**
    * Restablece el iterador para volver al inicio.
    */
    public void reset ()
    {
        handler=restart;
    }
}