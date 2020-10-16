
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListCellRenderer;
import javax.swing.table.DefaultTableCellRenderer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Zer0
 */
public class Globales {
    
    public void Ordenar()
    {
        String patronEstatus="(Estatus)(\\:)(	| |)*(.+)";  
        Pattern rolE = Pattern.compile(patronEstatus);
        try 
            {
         //HAY ARCHIVOS,VERIFICAR SI EXISTE UN ADMIN
             List<String> lineas;
             lineas = Files.readAllLines(Path.of("C:\\MEIA\\usuario.txt"));
             List<String> activos = new ArrayList<String>();
             List<String> inactivos = new ArrayList<String>();
          
              for (int i = 0; i < lineas.size(); i++)
                {
  
                    Matcher m10 = rolE.matcher(lineas.get(i));
                    
                     if(m10.find())
                    {   
                        if(m10.group(4).contains("1"))
                        {
                         activos.add(lineas.get(i));
                         java.util.Collections.sort(activos);
                        
                        }
                        else
                        {
                            inactivos.add(lineas.get(i));
                            java.util.Collections.sort(inactivos);
                        }
                    
                    }
                }
              
                     
                     lineas = Stream.concat(activos.stream(), inactivos.stream()).collect(Collectors.toList());
                     Path out = Paths.get("C:\\MEIA\\usuario.txt");
                     Files.write(out,lineas);
                     
                      lineas = Files.readAllLines(Path.of("C:\\MEIA\\usuario.txt"));
                      Iterator<String> i = lineas.iterator();
                      while (i.hasNext())
                      {
                          String line = i.next();
                          if (line.trim().isEmpty())
                              i.remove();
                      }
                      Files.write(Path.of("C:\\MEIA\\usuario.txt"), lineas);
             
             
                // JOptionPane.showMessageDialog(null,"Ordenado" );
                 
             }
             catch (IOException ex) 
             {
                        Logger.getLogger(IFingreso.class.getName()).log(Level.SEVERE, null, ex);
             }
    }
    public void OrdenarContactos()
    {
        String patronEstatus="(Estatus)(\\:)(	| |)*(.+)";  
        Pattern rolE = Pattern.compile(patronEstatus);
        try 
            {
         //HAY ARCHIVOS,VERIFICAR SI EXISTE UN ADMIN
             List<String> lineas;
             lineas = Files.readAllLines(Path.of("C:\\MEIA\\contactos.txt"));
             List<String> activos = new ArrayList<String>();
             List<String> inactivos = new ArrayList<String>();
          
              for (int i = 0; i < lineas.size(); i++)
                {
  
                    Matcher m10 = rolE.matcher(lineas.get(i));
                    
                     if(m10.find())
                    {   
                        if(m10.group(4).contains("1"))
                        {
                         activos.add(lineas.get(i));
                         java.util.Collections.sort(activos);
                        
                        }
                        else
                        {
                            inactivos.add(lineas.get(i));
                            java.util.Collections.sort(inactivos);
                        }
                    
                    }
                }
              
                     
                    
              lineas = Stream.concat(activos.stream(), inactivos.stream()).collect(Collectors.toList());
              Path out = Paths.get("C:\\MEIA\\contactos.txt");
              Files.write(out,lineas);

              lineas = Files.readAllLines(Path.of("C:\\MEIA\\contactos.txt"));
              Iterator<String> i = lineas.iterator();
              while (i.hasNext())
              {
                  String line = i.next();
                  if (line.trim().isEmpty())
                      i.remove();
              }
              Files.write(Path.of("C:\\MEIA\\contactos.txt"), lineas);
              
                // JOptionPane.showMessageDialog(null,"Ordenado" );
                 
             }
             catch (IOException ex) 
             {
                        Logger.getLogger(IFingreso.class.getName()).log(Level.SEVERE, null, ex);
             }
        
    }
}
