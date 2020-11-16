
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

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

        Path p = Paths.get("C:\\\\MEIA\\\\arbolB.txt");

        for (Mensaje mjs : ListaMensajes) {

            try ( BufferedWriter writer = Files.newBufferedWriter(p, StandardOpenOption.APPEND)) {
                writer.write(mjs.toString());
                JOptionPane.showMessageDialog(null, "Mensaje Enviado");
                writer.close();
            } catch (IOException ioe) {
                System.err.format("IOException: %s%n", ioe);
            }
        }
    }

    public ArrayList<String> leerTxt(String cuenta) {
        ArrayList<String> lista = new ArrayList<String>();
        try {
            FileReader fr = new FileReader("C:\\\\MEIA\\\\arbolB.txt");
            BufferedReader br = new BufferedReader(fr);
            String cadena;

            while ((cadena = br.readLine()) != null) {
                try {

                    cadena = br.readLine();
                    lista.add(cadena);

                } catch (Exception e) {
                }
            }

        } catch (Exception e) {

        }
        return lista;
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
            if (mjs.getReceptor() != null && mjs.getReceptor().equalsIgnoreCase(cuenta)) {
                mensajesReceptor.add(mjs);
            }

        }
        return mensajesReceptor;

    }
}
