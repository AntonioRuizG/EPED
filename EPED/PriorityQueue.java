
/**
 * Write a description of class PriorityQueue here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PriorityQueue<T> implements QueueIF<T>
{
    private Nodo<T> primero;
    private int numElementos;
    private ComparatorIF<T> comparator;
    
    public PriorityQueue(ComparatorIF<T> comparator)
    {
        this.comparator = comparator;
        primero = new Nodo<T>(null,null);
    }
    
    public PriorityQueue(PriorityQueue<T> cola, ComparatorIF<T> comparator)
    {
        this(comparator);
        if (cola != null){
            Nodo<T> puntero = cola.primero;
            while(puntero.siguiente!=null){
                puntero=puntero.siguiente;
                add(puntero.dato);
            }
        }
    }
    
    /**
    * Devuelve la cabeza de la cola.
    * @return la cabeza de la cola.
    */
    public T getFirst ()
    {
        if(isEmpty())
            return null;
        
        return primero.siguiente.dato;
    }
    
    /**
    * Inserta un nuevo elemento a la cola.
    * @param element El elemento a añadir.
    * @return la cola incluyendo el elemento.
    */
    public QueueIF<T> add (T element)
    {
        if (element != null){
            Nodo<T> puntero = primero.siguiente;
            Nodo<T> anterior = primero;
            while(puntero != null && !comparator.isLess(element,puntero.dato)){
                anterior = puntero;
                puntero = puntero.siguiente;
            }
            Nodo<T> nuevo = new Nodo<T>(element, puntero);
            anterior.siguiente = nuevo;
            numElementos++;
        }
        
        return this;
    }
    
    /**
    * Borra la cabeza de la cola.
    * la cola excluyendo la cabeza.
    */
    public QueueIF<T> remove ()
    {
        if(!isEmpty()){
            primero = primero.siguiente;
            numElementos--;
        }
        return this;
    }
    
    /**
    * Devuelve cierto si la cola esta vacia.
    * @return cierto si la cola esta vacia.
    */
    public boolean isEmpty ()
    {
        return numElementos == 0;
    }
    
    /**
    * Devuelve cierto si la cola esta llena.
    * @return cierto si la cola esta llena.
    */
    public boolean isFull()
    {
        return false;
    }
    
    /**
    * Devuelve el numero de elementos de la cola.
    * @return el numero de elementos de la cola.
    */
    public int getLength ()
    {
        return 0;
    }
    
    /**
    * Devuelve cierto si la cola contiene el elemento.
    * @param element El elemento buscado.
    * @return cierto si la cola contiene el elemento.
    */
    public boolean contains (T element)
    {
        return false;
    }
    
    /**
    * Devuelve un iterador para la cola.
    * @return un iterador para la cola.
    */
    public IteratorIF<T> getIterator ()
    {
        QueueIF<T> handler = new PriorityQueue<T>(this,comparator);
        return new QueueIterator<T>(handler);
    }
    
    private class Nodo<T>
    {
        private T dato;
        private Nodo<T> siguiente;
        
        public Nodo(T dato, Nodo<T> siguiente)
        {
            this.dato = dato;
            this.siguiente = siguiente;
        }
        
    }
}
