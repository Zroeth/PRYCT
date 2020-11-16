
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
    public String cuenta;
    private static GestionarA instance = null;

    public static GestionarA getInstance() {
        if (instance == null) {
            instance = new GestionarA();
        }

        return instance;
    }

    public GestionarA() {
        ListaMensajes = new ArrayList<Mensaje>();
        cuenta = "";
    }

    public void Agregar(Mensaje nuevomjs) {

        // mensaje.setNo_registro();
        File archivo = new File("C:\\MEIA\\arbol.dat");
        try {
            FileOutputStream bin = new FileOutputStream(archivo, Boolean.TRUE);
            ObjectOutputStream bina = new ObjectOutputStream(bin);
//            for (Mensaje mjs : ListaMensajes) {
//                bina.writeObject(mjs);
//            }
            bina.writeObject(nuevomjs);
            bina.close();
            bin.close();

        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }

    }

    public void Agregartxt(Mensaje nuevomjs) {

        Path p = Paths.get("C:\\\\MEIA\\\\arbolB.txt");

        try (
                 BufferedWriter writer = Files.newBufferedWriter(p, StandardOpenOption.APPEND)) {
//            for (Mensaje mjs : ListaMensajes) {
//                writer.write(mjs.toString());
//            }
            writer.write(nuevomjs.toString());
            JOptionPane.showMessageDialog(null, "Mensaje Enviado");
            writer.close();
        } catch (IOException ioe) {
            System.err.format("IOException: %s%n", ioe);
        }

    }

    public void leerTxt() {
        try {
            FileReader fr = new FileReader("C:\\\\MEIA\\\\arbolB.txt");
            BufferedReader br = new BufferedReader(fr);
            String cadena;

            while ((cadena = br.readLine()) != null) {
                try {

                    cadena = br.readLine();
                    if (cadena.isBlank() == false && cadena.isEmpty() == false) {
                        Mensaje mjs = new Mensaje();
                        String[] token = cadena.split("|");
                        String[] data = token[0].split(": ");
                        if (data[1].isBlank() == false && data[1].isEmpty() == false) {
                            mjs.setNo_registro(Integer.parseInt(data[1]));
                        }
                        data = token[1].split(": ");
                        if (data[1].isBlank() == false && data[1].isEmpty() == false) {
                            mjs.setIzq(Integer.parseInt(data[1]));
                        }
                        data = token[2].split(": ");
                        if (data[1].isBlank() == false && data[1].isEmpty() == false) {
                            mjs.setDer(Integer.parseInt(data[1]));
                        }
                        data = token[3].split(": ");
                        mjs.setEmisor(data[1]);
                        data = token[4].split(": ");
                        mjs.setReceptor(data[1]);
                        data = token[5].split(": ");
                        mjs.setAsunto(data[1]);
                        data = token[6].split(": ");
                        mjs.setMensaje(data[1]);
                        data = token[7].split(": ");
                        mjs.setAdjunto(data[1]);
                        data = token[8].split(": ");
                        if (data[1].isBlank() == false && data[1].isEmpty() == false) {
                            mjs.setEstatus(Integer.parseInt(data[1]));
                        }
                        ListaMensajes.add(mjs);
                    }
                } catch (Exception e) {
//                    System.console().(e.getMessage());
                }
            }
            br.close();
            fr.close();

        } catch (Exception e) {

        }
    }

    public void leer() {
        File archivo = new File("C:\\MEIA\\arbol.dat");
        try {
            FileInputStream lbin = new FileInputStream(archivo);
            ObjectInputStream lbina = new ObjectInputStream(lbin);
            while (lbin.available() > 0) {
                Mensaje mensaje = (Mensaje) lbina.readObject();
                System.out.println(mensaje.toString());
                ListaMensajes.add(mensaje);
            }
            lbina.close();
            lbin.close();
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
