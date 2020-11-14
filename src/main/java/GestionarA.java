
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cathy
 */
public class GestionarA {
    
    File archivo = new File("C:\\MEIA\\arbol.dat"); 
    public  void Agregar(){  
    Mensaje mensaje= new Mensaje();
   // mensaje.setNo_registro();
   
    try{
    FileOutputStream bin=new FileOutputStream(archivo,true);
    ObjectOutputStream bina=new ObjectOutputStream(bin);
    bina.writeObject(mensaje);
    bina.close();
    bin.close();
    
    
    }catch(Exception e){
        System.out.println("Error");
        e.printStackTrace();
    }
    
    }
    public void leer(){
    try{
        FileInputStream lbin=new FileInputStream(archivo);
        ObjectInputStream lbina;
        while(lbin.available()>0){
        lbina=new ObjectInputStream(lbin);
        Mensaje mensaje=(Mensaje) lbina.readObject();
        System.out.println(mensaje);
        }
    }catch(Exception e){
    System.out.println("Error");
    e.printStackTrace();
    }
    
    }
    /* List<Mensaje> msj= new ArrayList();
    public void AgregarDatos(Mensaje Mjs){
     msj.add(Mjs);
     
}
    public void mostrarArray(){
    for(int i=0;i<msj.size();i++){
     JOptionPane.showMessageDialog(null,msj.get(i));
    } 
    }
    public void eliminar(int i){
    msj.remove(i);
    }*/
}
