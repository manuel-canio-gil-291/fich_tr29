package es.mcg;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ParejasEnteros {
    public static void main(String[] args) {
        File file = null;
        FileOutputStream fileOutputStream = null;
        DataOutputStream dataOutputStream = null;
        Scanner sc = new Scanner(System.in);

        try 
        {
            file = new File("myData.txt");
            if(!file.exists())
            {
                file.createNewFile();
            }
            fileOutputStream = new FileOutputStream(file);
            dataOutputStream = new DataOutputStream(fileOutputStream);
            String entrada;
            int salida;
            System.out.println("Introduzca un entero. INTRO para cerrar el programa");
            entrada = sc.nextLine();
            while(!entrada.equals("INTRO"))
            {
                salida = Integer.parseInt(entrada);
                if(Integer.MAX_VALUE < salida)
                {
                    dataOutputStream.writeInt(salida);
                }
                entrada = sc.nextLine();
            }
        } 
        catch (IOException ioException) 
        {
            ioException.printStackTrace();
        }
    }
}
