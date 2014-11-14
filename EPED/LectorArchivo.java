import java.io.FileReader;
import java.io.BufferedReader;


/**
 * Write a description of class archivo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LectorArchivo
{
    BufferedReader buffer;
    
    int numTartas;
    int precioTartas;
    
    public void cargarArchivo(String archivo)
    {
        try{
            FileReader fileReader = new FileReader(archivo);
            buffer = new BufferedReader(fileReader);

        }
        catch(Exception e){
            System.out.println("No se encontro el archivo: " + archivo);
        }
    
    numTartas = proximaLinea()[0];
    precioTartas = proximaLinea()[0];
    }
    
    private int[] proximaLinea()
    {
        char[] charArray;
        String linea = null;
        try{
            linea = buffer.readLine();          
        }
        catch(Exception e){}
        
        if (linea==null)
            return null;
            
        charArray = linea.toCharArray();
        int num[] = new int[charArray.length];
        for (int i=0,j=0; i<charArray.length;i++ ){
            if (charArray[i] == '\t')j++;
            else{
                num[j] *= 10;
                num[j] += charArray[i]-48;
            }
        }

        return num;
    }
    
    public int numTartas()
    {
        return numTartas;
    }
    
    public int precioTarta()
    {
        return precioTartas;
    }
    
    public Cliente nextCliente()
    {
        int[] nums = proximaLinea();
        if (nums == null)
            return null;
        
        return new Cliente(nums[0],new Tarta(nums[1]),nums[2]);
    }
}
