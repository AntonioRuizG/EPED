
/**
 * Write a description of class Pueba here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pueba
{
    private QueueIF<Cliente> cola;
    int n;
    
    public Pueba()
    {
        cola = new PriorityQueue<Cliente>(new ComparatorCliente());
        
    }
    
    public void insertar(int num)
    {
        cola.add(new Cliente(n++,new Tarta(1),num));
    }
    
    public void imprimir()
    {
        IteratorIF<Cliente> it = cola.getIterator();
        while(it.hasNext()){
            Cliente c = it.getNext();
            System.out.println(c.getPaciencia()+" "+c.getIdentificador());
            
        }
            
        it.reset();
    }
    
}
