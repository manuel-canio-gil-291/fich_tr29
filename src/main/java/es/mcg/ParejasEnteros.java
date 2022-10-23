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
            String entrada1, entrada2;
            int salida1, salida2;
            System.out.println("Para cerrar el programa, escriba INTRO");
            do{
                System.out.println("Introduce un numero entero");
                entrada1 = sc.nextLine();
                if(entrada1.equals("INTRO"))
                {
                    System.out.println("Ha finalizado el programa");
                    cerrarFlujos(fileOutputStream, dataOutputStream);
                    System.exit(0);
                }
                System.out.println("Introduce otro numero entero");
                entrada2 = sc.nextLine();
                if(entrada2.equals("INTRO"))
                {
                    System.out.println("Ha finalizado el programa");
                    cerrarFlujos(fileOutputStream, dataOutputStream);
                    System.exit(0);
                }
                if(entrada1.equals(entrada2))
                {
                    salida1 = Integer.parseInt(entrada1);
                    salida2 = Integer.parseInt(entrada2);
                    if(Integer.MAX_VALUE > salida1 || Integer.MAX_VALUE > salida2)
                    {
                        dataOutputStream.writeInt(salida1);
                        dataOutputStream.writeInt(salida2);
                        dataOutputStream.writeUTF("\n");
                    }
                    else
                    {
                        System.err.println("ERROR. Valor del numero excedido");
                    }
                }
                else
                {
                    System.err.println("ERROR. No son parejas");
                }
            }while(!entrada1.equals("INTRO") || !entrada2.equals("INTRO"));
            //String entrada;
            //int salida;
            //System.out.println("Introduzca un entero. INTRO para cerrar el programa");
            //entrada = sc.nextLine();
            //while(!entrada.equals("INTRO"))
            //{
            //    salida = Integer.parseInt(entrada);
            //    if(Integer.MAX_VALUE < salida)
            //    {
            //        dataOutputStream.writeInt(salida);
            //    }
            //    entrada = sc.nextLine();
            //}
        } 
        catch (IOException ioException) 
        {
            ioException.printStackTrace();
        }
    }

    private static void cerrarFlujos(FileOutputStream fileOutputStream, DataOutputStream dataOutputStream){
                if(dataOutputStream != null)
                {
                    try 
                    {
                        dataOutputStream.flush();
                        dataOutputStream.close();
                    } 
                    catch (IOException ioException) 
                    {
                        ioException.printStackTrace();
                    }
                }
                if(fileOutputStream != null)
                {
                    try 
                    {
                        fileOutputStream.close();
                    }
                    catch (IOException ioException) 
                    {
                        ioException.printStackTrace();
                    }
                }
        
    }
}
