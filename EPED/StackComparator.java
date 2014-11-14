
/**
 * Write a description of class StackComparator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StackComparator<T> implements ComparatorIF<StackIF<T>>
{
    /**
    * Compara dos elementos para indicar si el primero es
    * menor, igual o mayor que el segundo elemento.
    * @param e1 el primer elemento.
    * @param e2 el segundo elemento.
    * @return el orden de los elementos.
    */
    public int compare (StackIF e1, StackIF e2)
    {
        if (e1.getLength() < e2.getLength())
            return ComparatorIF.LESS;
        
        if (e1.getLength() > e2.getLength())
            return ComparatorIF.GREATER;
            
        return ComparatorIF.EQUAL;
    }
    
    /**
    * Indica si un elemento es menor que otro.
    * @param e1 el primer elemento.
    * @param e2 el segundo elemento.
    * @return true si un elemento es menor que otro.
    */
    public boolean isLess (StackIF e1, StackIF e2)
    {
        return compare(e1, e2) < 0;
    }
    
    /**
    * Indica si un elemento es igual que otro.
    * @param e1 el primer elemento.
    * @param e2 el segundo elemento.
    * @return true si un elemento es igual que otro.
    */
    public boolean isEqual (StackIF e1, StackIF e2)
    {
        return compare(e1, e2) == 0;
    }
    
    /**
    * Indica si un elemento es mayor que otro.
    * @param e1 el primer elemento.
    * @param e2 el segundo elemento.
    * @return true si un elemento es mayor que otro.
    */
    public boolean isGreater (StackIF e1, StackIF e2)
    {
        return compare(e1, e2) > 0;
    }
}
