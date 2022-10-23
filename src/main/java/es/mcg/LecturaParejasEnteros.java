package es.mcg;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.StringTokenizer;

public class LecturaParejasEnteros {
    public static void main(String[] args) {
        File file = null;
        FileInputStream fileInputStream = null;
        DataInputStream dataInputStream = null;

        try 
        {
            file = new File("myData.txt");
            fileInputStream = new FileInputStream(file);
            dataInputStream = new DataInputStream(fileInputStream);
            int lectura;
            String numeros;
            lectura = dataInputStream.readInt();
            numeros = Integer.toString(lectura);
            StringTokenizer token = new StringTokenizer(numeros);
            System.out.println(token.nextElement());
            while(token.hasMoreElements())
            {
                lectura = dataInputStream.readInt();
                numeros = Integer.toString(lectura);
                System.out.println(token.nextElement());
            }
        } 
        catch (IOException ioException) 
        {
            ioException.printStackTrace();
        }
        finally
        {
            if(dataInputStream != null)
            {
                try 
                {
                    dataInputStream.close();    
                } 
                catch (IOException ioException) 
                {
                    ioException.printStackTrace();
                }
            }
            if(fileInputStream != null)
            {
                try 
                {
                    fileInputStream.close();    
                } 
                catch (IOException ioException) 
                {
                    ioException.printStackTrace();
                }
            }
        }
    }
}
