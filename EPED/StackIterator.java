
/**
 * Write a description of class StackIterator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StackIterator<T> implements IteratorIF<T>
{
    StackIF<T> handler;
    StackIF<T> restart;
    
    public StackIterator(StackIF<T> handler)
    {
        this.handler = handler;
        this.restart = new StackDynamic<T> (handler);
    }
    
    /**
     * Devuelve el siguiente elemento de la iteracion.
     * @return el siguiente elemento de la iteracion.
     */
    public T getNext()
    {
        T elem = handler.getTop();
        handler.pop();
        return elem;
    }
    
    /**
     * Devuelve cierto si aun quedan elementos sin visitar en la iteracion.
     * @return cierto si existen elementos sin visitar en la iteracion
     */
    public boolean hasNext()
    {
        return !handler.isEmpty();
    }
    
    /**
     * Restablece el iterador al comienzo.
     */
    public void reset()
    {
        handler = new StackDynamic<T>(restart);
    }
    
}
