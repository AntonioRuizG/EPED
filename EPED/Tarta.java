
/**
 * Write a description of class Tarta here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tarta
{
    
    private int tipoTarta;
    
    public Tarta(int tipoTarta)
    {
        this.tipoTarta = tipoTarta;
    }
    
    public int getTipoTarta()
    {
        return tipoTarta;
    }
    
    public boolean equals(Tarta t)
    {
        return tipoTarta == t.tipoTarta;
    }
}
