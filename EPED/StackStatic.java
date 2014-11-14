
/**
 * Write a description of class StackStatic here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StackStatic<T> implements StackIF<T>
{
    private Object[] elements;
    private int top;
    private int capacity;

    /**
     * Constructor for objects of class StackStatic
     */
    public StackStatic(int capacity)
    {
        this.capacity = capacity;
        top = -1;
        elements = new Object[capacity];
    }
    
    
    /**
    * Devuelve la cima de la pila.
    * @return la cima de la pila.
    */
   @SuppressWarnings("unchecked")
    public T getTop ()
    {
        if (isEmpty()) 
            return null;
            
        return (T)elements[top];
    }
    
    /**
    * Inserta un elemento a la pila.
    * @param element El elemento a ser añadido.
    * @return la pila incluyendo el elemento.
    */
    public StackIF<T> push (T element)
    {
        if (!isFull())
            elements[++top] = element;
            
        return this;
    }
    
    /**
    * Extrae de la pila el elemento en la cima.
    * @return la pila excluyendo la cabeza.
    */
    public StackIF<T> pop ()
    {
        if (!isEmpty())
            top--;
        
        return this;
    }
    
    /**
    * Devuelve cierto si la pila esta vacia.
    * @return cierto si la pila esta vacia.
    */
    public boolean isEmpty ()
    {
        return top == -1;
    }
    
    /**
    * Devuelve cierto si la pila esta llena.
    * @return cierto si la pila esta llena.
    */
    public boolean isFull()
    {
        return top == capacity -1;
    }
    
    /**
    * Devuelve el numero de elementos de la pila.
    * @return el numero de elementos de la pila.
    */
    public int getLength ()
    {
        return top +1;
    }
    
    /**
    * Devuelve cierto si la pila contiene el elemento.
    * @param element El elemento buscado.
    * @return cierto si la pila contiene el elemento.
    */
    public boolean contains (T element)
    {
        return true;
    }
    
    /**
    * Devuelve un iterador para la pila.
    * @return un iterador para la pila.
    */
    public IteratorIF<T> getIterator ()
    {
        return null;
    }
    
}
