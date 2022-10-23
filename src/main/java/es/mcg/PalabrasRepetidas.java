package es.mcg;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class PalabrasRepetidas {
    public static void main(String[] args) {
        File file = null;
        FileOutputStream fileOutputStream = null;
        DataOutputStream dataOutputStream = null;
        ArrayList<String> palabras = null;

        try 
        {
            file = new File("textData.txt");
            if(!file.exists())
            {
                file.createNewFile();
            }
            fileOutputStream = new FileOutputStream(file);
            dataOutputStream = new DataOutputStream(fileOutputStream);

            String texto = "Java es un lenguaje de programacion orientado a objetos desarrollado por Oracle. Este lenguaje se puede programar en diferentes IDEs, como por ejemplo: NetBeans, Eclipse IDE, Visual Studio Code, Intellij IDEA, etc.";
            texto = texto.replaceAll("[\\.\\,\\:]", " ");
            dataOutputStream.writeUTF(texto);
            StringTokenizer stTexto = new StringTokenizer(texto);
            palabras = new ArrayList<String>();
            while(stTexto.hasMoreTokens())
            {
                System.out.println(stTexto.nextToken());
                palabras.add(stTexto.nextToken());
            }
            HashMap<String, Integer> frecuenciaPalabras = new HashMap<String, Integer>();
            for(String palabra : palabras)
            {
                if(frecuenciaPalabras.containsKey(palabra))
                {
                    frecuenciaPalabras.put(palabra, frecuenciaPalabras.get(palabra) + 1);
                }
                else
                {
                    frecuenciaPalabras.put(palabra, 1);
                }
            }
            for(HashMap.Entry<String, Integer> entry : frecuenciaPalabras.entrySet())
            {
                System.out.println("La palabra '"+entry.getKey()+"' repite "+entry.getValue()+" veces");
            }
        } 
        catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
