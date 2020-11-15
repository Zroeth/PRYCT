
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

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

    public List<Mensaje> ListaMensajes;
    private static GestionarA instance = null;

    public static GestionarA getInstance() {
        if (instance == null) {
            instance = new GestionarA();
        }

        return instance;
    }

    public GestionarA() {
        ListaMensajes = new ArrayList<Mensaje>();
    }

    public void Agregar() {

        // mensaje.setNo_registro();
        File archivo = new File("C:\\MEIA\\arbol.dat");
        try {
            FileOutputStream bin = new FileOutputStream(archivo);
            ObjectOutputStream bina = new ObjectOutputStream(bin);
            for (Mensaje mjs : ListaMensajes) {
                bina.writeObject(mjs);
            }
            bina.close();
            bin.close();

        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }

    }
    public void Agregartxt() {

        // mensaje.setNo_registro();
        File archivo = new File("C:\\MEIA\\arbol.txt");
        
        try {
            FileOutputStream bin = new FileOutputStream(archivo);
            ObjectOutputStream bina = new ObjectOutputStream(bin);
            for (Mensaje mjs : ListaMensajes) {
                bina.writeChars(mjs.toString());
            }
            bina.close();
            bin.close();

        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }

    }

    public void leer() {
        File archivo = new File("C:\\MEIA\\arbol.dat");
        try {
            FileInputStream lbin = new FileInputStream(archivo);
            ObjectInputStream lbina;
            while (lbin.available() > 0) {
                lbina = new ObjectInputStream(lbin);
                Mensaje mensaje = (Mensaje) lbina.readObject();
                System.out.println(mensaje.toString());
                GestionarA.getInstance().ListaMensajes.add(mensaje);
            }
        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }

    }

    public ArrayList<Mensaje> obtenerMensajesEmisor(String cuenta) {
        ArrayList<Mensaje> mensajesEmisor = new ArrayList<Mensaje>();
        for (Mensaje mjs : ListaMensajes) {
            if (mjs.getEmisor() != null && mjs.getEmisor().equalsIgnoreCase(cuenta)) {
                mensajesEmisor.add(mjs);
            }

        }
        return mensajesEmisor;

    }
        public ArrayList<Mensaje> obtenerMensajesReceptor(String cuenta) {
        ArrayList<Mensaje> mensajesReceptor = new ArrayList<Mensaje>();
        for (Mensaje mjs : ListaMensajes) {
            if (mjs.getEmisor() != null && mjs.getReceptor().equalsIgnoreCase(cuenta)) {
                mensajesReceptor.add(mjs);
            }

        }
        return mensajesReceptor;

    }
}
