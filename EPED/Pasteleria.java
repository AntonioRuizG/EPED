
/**
 * Write a description of class Pasteleria here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pasteleria
{
    //las tartas que hay apiladas en la maquina
    private static StackIF<Tarta> maquina;
    
    //los mostradores para poner tartas
    private static QueueIF<StackIF<Tarta>> mostradores;
    
    //los clientes que hay esperando en el local
    private static QueueIF<Cliente> local;
    
    //el precio de las tartas
    private static int precioTarta;
    
    //nº de tipos de tarta diferentes n
    private static int numTartasDiferentes;
    
    private static LectorArchivo lectorArchivo;
    
    private static double totalRecaudado;
    
    private static int tartaActual;
    
    /**
     * Main
     */
    public static void main(String [] args)
    {
        lectorArchivo = new LectorArchivo();
        if (args.length == 0)
            lectorArchivo.cargarArchivo("../jornada_laboral.tsv");
        else
            lectorArchivo.cargarArchivo(args[0]);
            tartaActual = 1;
        comenzarJornada();
    }
    
    private static void comenzarJornada()
    {
        precioTarta = lectorArchivo.precioTarta();
        numTartasDiferentes = lectorArchivo.numTartas();
        local = new PriorityQueue<Cliente>(new ComparatorCliente());
        
        //crea la maquina y los mostradores
        maquina = new StackStatic<Tarta>(numTartasDiferentes-1);
        mostradores = new PriorityQueue<StackIF<Tarta>>(new StackComparator<Tarta>());
        for(int i=0; i<numTartasDiferentes-1;i++)
            mostradores.add(new StackStatic<Tarta>(numTartasDiferentes-1));
        
        //entran al local los 2*n+1 primeros clientes
        for (int i = 0; i<2*numTartasDiferentes+1; i++)
            local.add(lectorArchivo.nextCliente());
        
        while (!local.isEmpty()){
            atenderCliente(local.getFirst());
        }
        System.out.println(totalRecaudado);
    }
    
    private static void atenderCliente(Cliente C)
    {
        if (C.getIdentificador()==16)
            C.getPedido();
            
        Tarta T = C.getPedido();
        
        /*FASE1: Recorrer máquina y mostradores. Si la tarta situada arriba del
        todo de la máquina o algún mostrador es del tipo pedido, se le entrega al
        cliente automáticamente en tiempo cero*/
        
        if(!maquina.isEmpty() && maquina.getTop().equals(T)){
            maquina.pop();
            entregarPedido(C);
            return;
        }
        if(buscarEnMostradores(T)){
            entregarPedido(C);
            return;
        }
        
        /*FASE2: Recorrer tartas de la máquina hasta encontrar una del tipo pedido
        por el cliente*/
        while(moverTarta()){
            C.esperar(1);
        /* Si el cliente mantiene la paciencia y se encuentra una tarta del tipo
        que pide, se le entrega el pedido*/
            if(C.tienePaciencia()){
                if(!maquina.isEmpty() && maquina.getTop().equals(T)){
                    maquina.pop();
                    entregarPedido(C);
                    return;
                }
            }
            /* Si al cliente se le agota la paciencia, sale del local y entra otro
            nuevo cliente*/
            else{
                nuevoCliente();
                return;
            }
        }
        /* FASE3: Fabricar tartas mientras que el cliente mantenga la paciencia, y
        entregarle el pedido si alguna de las tartas fabricadas se corresponde con
        la del pedido*/
        boolean sale_cliente=false;
        while(C.tienePaciencia() && !sale_cliente){
            if(fabricarTarta(C.getPaciencia())){
                C.esperar(2);
                if(maquina.getTop().equals(T)){
                    if(C.tienePaciencia()){
                        maquina.pop();
                        entregarPedido(C);
                        return;
                    }
                }
            }
            else{
                sale_cliente=true;
            }
        }
        /*Si al cliente se le agoto la paciencia, sale del local y entra uno
        nuevo*/
        nuevoCliente ();
        return;
    }
    
    private static boolean fabricarTarta(int pCliente)
    {
        if(!maquina.isFull() && pCliente > 0){
            maquina.push(new Tarta(tartaActual++));
            if (tartaActual > numTartasDiferentes)
                tartaActual=1;
                
            return true;
        }
        return false;
    }
    
    private static boolean buscarEnMostradores(Tarta T)
    {
        boolean encontrado = false;
        if (!mostradores.isEmpty()){
        
            StackIF<Tarta> mostrador = mostradores.getFirst();
            mostradores.remove();
            if (!mostrador.isEmpty() && mostrador.getTop().equals(T)){
                
                mostrador.pop(); //entrega la tarta
                mostradores.add(mostrador); //añade el mostrador en su orden
                return true;
            }
            
            encontrado = buscarEnMostradores(T);
            mostradores.add(mostrador);  //añade el mostrador a la vuelta de la recursion
        }
        return encontrado;
    }
    
    private static void entregarPedido(Cliente C)
    {
        System.out.println("Cliente nº: " + C.getIdentificador()+
                               ", con paciencia: "+ C.getPaciencia() +
                               ", ha pedido la tarta: " + C.getPedido().getTipoTarta());
        double propina = (double)C.getPaciencia()/(double)numTartasDiferentes;
        totalRecaudado += precioTarta + propina;
        System.out.print(" paga: "+(precioTarta+propina)+"\n");
        nuevoCliente();
    }
    
    private static boolean moverTarta()
    {
        Tarta tartaAMover = maquina.getTop();
        StackIF<Tarta> mostradorMasVacio = mostradores.getFirst();
        if(tartaAMover != null){
            if (!mostradorMasVacio.isFull()){
                mostradores.remove();
                mostradorMasVacio.push(tartaAMover);
                mostradores.add(mostradorMasVacio);
                maquina.pop();
                
                return true;
            }
        }
        return false;
    }
    
    private static void nuevoCliente()
    {
        local.remove();
        local.add(lectorArchivo.nextCliente());
    }
    
    private void informe()
    {
        System.out.println("XXXXXXXX");
        System.out.println("Tartas en maquina: "+maquina.getLength());
        
        System.out.println("Tartas en maquina: "+maquina.getLength());
        
    }
}
