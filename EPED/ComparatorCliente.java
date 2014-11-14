
/**
 * Write a description of class ComparatorCliente here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ComparatorCliente implements ComparatorIF<Cliente>
{
    /**
    * Compara dos elementos para indicar si el primero es
    * menor, igual o mayor que el segundo elemento.
    * @param e1 el primer elemento.
    * @param e2 el segundo elemento.
    * @return el orden de los elementos.
    */
    public int compare (Cliente e1, Cliente e2)
    {
        if (e1.getPaciencia() < e2.getPaciencia())
            return ComparatorIF.LESS;
        
        if (e1.getPaciencia() > e2.getPaciencia())
            return ComparatorIF.GREATER;
            
        return ComparatorIF.EQUAL;
    }
    
    /**
    * Indica si un elemento es menor que otro.
    * @param e1 el primer elemento.
    * @param e2 el segundo elemento.
    * @return true si un elemento es menor que otro.
    */
    public boolean isLess (Cliente e1, Cliente e2)
    {
        return compare(e1, e2) < 0;
    }
    
    /**
    * Indica si un elemento es igual que otro.
    * @param e1 el primer elemento.
    * @param e2 el segundo elemento.
    * @return true si un elemento es igual que otro.
    */
    public boolean isEqual (Cliente e1, Cliente e2)
    {
        return compare(e1, e2) == 0;
    }
    
    /**
    * Indica si un elemento es mayor que otro.
    * @param e1 el primer elemento.
    * @param e2 el segundo elemento.
    * @return true si un elemento es mayor que otro.
    */
    public boolean isGreater (Cliente e1, Cliente e2)
    {
        return compare(e1, e2) > 0;
    }
}
