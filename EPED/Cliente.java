
/**
 * Write a description of class Cliente here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cliente
{
    private int identificador;
    private int paciencia;
    private Tarta pedido;
    
    public Cliente(int identificador, Tarta pedido, int paciencia)
    {
        this.identificador = identificador;
        this.paciencia = paciencia;
        this.pedido = pedido;
    }
    
    public int getIdentificador()
    {
        return identificador;
    }
    
    public int getPaciencia()
    {
        return paciencia;
    }
    
    public boolean tienePaciencia()
    {
        return paciencia >= 0;
    }
    
    public void esperar(int unidadesDeTiempo)
    {
        paciencia -= unidadesDeTiempo;
    }
    
    public Tarta getPedido()
    {
        return pedido;
    }
}
