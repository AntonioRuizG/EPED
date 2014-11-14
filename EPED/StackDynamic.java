
/**
 * Write a description of class StackDinamic here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StackDynamic<T> implements StackIF<T>
{
    private Nodo<T> cima;
    private int numElementos;
    /**
     * Crea una pila vacia.
     */
    public StackDynamic()
    {
        cima = null;
        numElementos = 0;
    }
    
    /**
     * Crea una pila a partir de otra pila.
     */
    public StackDynamic(StackIF<T> stack)
    {
        this();
        if (stack != null)
            if (!stack.isEmpty()){
                StackIF<T> aux = new StackDynamic<T>();
                while (!stack.isEmpty ()){
                    aux.push(stack.getTop());
                    stack.pop();
                }
                while(!aux.isEmpty()){
                    T elem = aux.getTop();
                    push(elem);
                    stack.push(elem);
                    aux.pop();
                }
        }
    }
    
    /**
     * Crea una pila a partir de una lista
     */
    
    /**
    * Devuelve la cima de la pila.
    * @return la cima de la pila.
    */
    public T getTop ()
    {
        if (isEmpty())
            return null;
            
        return cima.dato;
    }
    
    /**
    * Inserta un elemento a la pida.
    * @param element El elemento a ser añadido.
    * @return la pila incluyendo el elemento.
    */
    public StackIF<T> push (T element)
    {
        Nodo<T> nuevo = new Nodo<T>(element,cima);
        cima = nuevo;
        numElementos++;
        return this;
    }
    
    /**
    * Extrae de la pila el elemento en la cima.
    * @return la pila excluyendo la cabeza.
    */
    public StackIF<T> pop ()
    {
        if (!isEmpty()){
            cima = cima.siguiente;
            numElementos--;
        }
        
        return this;
    }
    
    /**
    * Devuelve cierto si la pila esta vacia.
    * @return cierto si la pila esta vacia.
    */
    public boolean isEmpty ()
    {
        return numElementos == 0;
    }
    
    /**
    * Devuelve cierto si la pila esta llena.
    * @return cierto si la pila esta llena.
    */
    public boolean isFull()
    {
        return false;
    }
    
    /**
    * Devuelve el numero de elementos de la pila.
    * @return el numero de elementos de la pila.
    */
    public int getLength ()
    {
        return numElementos;
    }
    
    /**
    * Devuelve cierto si la pila contiene el elemento.
    * @param element El elemento buscado.
    * @return cierto si la pila contiene el elemento.
    */
    public boolean contains (T element)
    {
        Nodo<T> cursor = cima;
        while (cursor != null){
            if (cursor.dato.equals(element))
                return true;
            cursor = cursor.siguiente;
        }
        return false;
    }
    
    /**
    * Devuelve un iterador para la pila.
    * @return un iterador para la pila.
    */
    public IteratorIF<T> getIterator ()
    {
        StackIF<T> handler = new StackDynamic<T>(this);
        return new StackIterator<T>(handler);
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
