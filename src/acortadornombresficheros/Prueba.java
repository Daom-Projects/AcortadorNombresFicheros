/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acortadornombresficheros;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author grani
 */
public class Prueba {
    
    public static List<String> fullArchivos = new ArrayList<String>();
    
    public static void main(String[] args) {
        String Ruta = "D:\\Data Cloud\\Dropbox";
        File fileRuta = new File(Ruta);
        fullList(fileRuta);
        listarArchivos();
    }
    
    public static void fullList(File ActDir) {
        File[] listOfFiles = ActDir.listFiles();
        for (File file : listOfFiles) {
            if (file.isFile()) {
                fullArchivos.add("Archivo: "+file.getAbsolutePath());
            }else if(file.isDirectory()){
                fullList(file);
            }
        }
    }
    
    public static void listarArchivos() {
        PrintWriter writer;        
        try {
            writer = new PrintWriter("D:\\grani\\Desktop\\resultado.txt", "UTF-8");
            for (String Archivo : fullArchivos) {
                if(Archivo.length() > 255){
                    writer.println(Archivo);
                }
            }
            writer.close();
            System.out.println("Proceso Finalizado");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
