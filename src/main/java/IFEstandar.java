
import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.plaf.metal.MetalIconFactory;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public  class IFEstandar extends javax.swing.JFrame {

   static String cuenta;
   static boolean valorRol;
   static String cuentaMod; 
   String pathFotografia;
   int maximaReorganizacion;
   int xx,xy;
   DefaultListModel listaTodosLosContactos = new DefaultListModel();
   DefaultListModel listaContactosOcultar = new DefaultListModel();
   DefaultListModel listaContactosMostrar = new DefaultListModel();
   
   DefaultListModel listaTodasLasListas = new DefaultListModel();
   DefaultListModel listaListasOcultar = new DefaultListModel();
   DefaultListModel listaListasMostrar = new DefaultListModel();
     
    Map<Object, ImageIcon> icons = new HashMap<>();
    
    Map<Object, Icon> numerosMap = new HashMap<>();
    
    public IFEstandar(String usuario) {
       
        
        
        setUndecorated(true);
        initComponents();
        
        
        getContentPane().setBackground(Color.white);    
 
        
        cuenta="Nueva";
        
        lblBienvenido.setText("Bienvenido usuario "+cuenta);
        
        ImageIcon imIc3= new ImageIcon("src/main/java/Imagenes/btnAgregar.gif");
        btnBuscar.setIcon(imIc3);
        
       
        
         
        ImageIcon imIc4= new ImageIcon("src/main/java/Imagenes/btnModificar.gif");
        btnMod.setIcon(imIc4);
        
        ImageIcon imIc5= new ImageIcon("src/main/java/Imagenes/btnSalir.gif");
        btnSalir.setIcon(imIc5);
        
        mostrarContactos();
        mostrarListas();
        String patron="(Usuario)(\\:)(	| |)*(.+)(\\|)(N)";
        String patronPathFoto="(Path_Fotografia)(\\:)(	| |)*(.+)(\\|)(E)";
        Pattern rol = Pattern.compile(patron);
        Pattern rolPath = Pattern.compile(patronPathFoto);
        maximaReorganizacion=Max();
        
        
        
        
        
        
        
        try
        {
                List<String> lineas;
                lineas = Files.readAllLines(Path.of("C:\\MEIA\\usuario.txt"));
                for (int i = 0; i < lineas.size(); i++)
                {
                    Matcher m = rol.matcher(lineas.get(i));
                    Matcher m9 = rolPath.matcher(lineas.get(i));
                    
                    if(m.find()&&m9.find())
                    {   
                        if(m.group(4).contains(cuenta))
                        {
                            pathFotografia=m9.group(4);
                            ImageIcon imIc= new ImageIcon(pathFotografia);
                            Image ajustarImg = imIc.getImage();
                            Image ajustarTamaño= ajustarImg.getScaledInstance(Foto.getWidth(),Foto.getHeight(), Image.SCALE_SMOOTH);
                            Foto.setIcon(new ImageIcon(ajustarTamaño));
                            return;   
                        }
                    }
                }
        }   
        catch (IOException ex)    
        {
                Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
                 JOptionPane.showMessageDialog(null, ":D");
        }
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblBienvenido = new javax.swing.JLabel();
        btnMod = new javax.swing.JLabel();
        Foto = new javax.swing.JLabel();
        btnSalir = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        lblBienvenido.setFont(new java.awt.Font("Museo 300", 0, 36)); // NOI18N
        lblBienvenido.setText("Bienvenido");
        lblBienvenido.setToolTipText("");

        btnMod.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnMod.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModMouseClicked(evt);
            }
        });

        Foto.setFont(new java.awt.Font("Museo 300", 0, 18)); // NOI18N
        Foto.setForeground(new java.awt.Color(0, 204, 255));
        Foto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Foto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnSalir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.setDoubleBuffered(true);
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalirMouseClicked(evt);
            }
        });

        btnBuscar.setFont(new java.awt.Font("Museo 300", 0, 18)); // NOI18N
        btnBuscar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarMouseClicked(evt);
            }
        });

        jList1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jList1.setFont(new java.awt.Font("Museo 300", 0, 24)); // NOI18N
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jList1MousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jList2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jList2.setFont(new java.awt.Font("Museo 300", 0, 24)); // NOI18N
        jList2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jList2MouseMoved(evt);
            }
        });
        jList2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jList2MousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(jList2);

        jLabel1.setFont(new java.awt.Font("Museo 300", 0, 14)); // NOI18N
        jLabel1.setText("Listas");

        jLabel2.setFont(new java.awt.Font("Museo 300", 0, 14)); // NOI18N
        jLabel2.setText("Contactos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblBienvenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnMod, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 5, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(202, 202, 202)
                        .addComponent(jLabel2)
                        .addGap(92, 92, 92)))
                .addComponent(Foto, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Foto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblBienvenido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnMod, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane2))))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnModMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModMouseClicked
        // TODO add your handling code here:
        ModAdmin1.getObj(cuenta,false).setVisible(true);
    }//GEN-LAST:event_btnModMouseClicked

    private void btnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseClicked
        // TODO add your handling code here:
          IFingreso Ifingreso=new IFingreso();
               Ifingreso.setVisible(true);
               Ifingreso.pack();
               Ifingreso.setLocationRelativeTo(null);
               dispose();
    }//GEN-LAST:event_btnSalirMouseClicked

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        // TODO add your handling code here:
             int x=evt.getXOnScreen();
        int y=evt.getYOnScreen();
        
        setLocation(x-xx,y-xy);
    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // TODO add your handling code here:
            xx=evt.getX();
        xy=evt.getY();
    }//GEN-LAST:event_formMousePressed

   
    private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseClicked
        
        JTextField usuarioBuscarField = new JTextField(30);
        usuarioBuscarField.setPreferredSize(new java.awt.Dimension(30, 50));
        JPanel myPanel = new JPanel(); 
        myPanel.add(new JLabel("Usuario:"));
        myPanel.add(usuarioBuscarField);
        int result = JOptionPane.showConfirmDialog(null, myPanel,"Agregar cuenta", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION)
        {
         String patronUsuario="(Usuario)(\\:)(	| |)*(.+)(\\|)(N)";
        Pattern rol = Pattern.compile(patronUsuario);
        String patronEstatus="(Estatus)(\\:)(	| |)*(.+)";  
        Pattern rolE = Pattern.compile(patronEstatus);
        
        try {
            List<String> lineas;
            lineas = Files.readAllLines(Path.of("C:\\MEIA\\usuario.txt"));
            for (int i = 0; i < lineas.size(); i++)
            {
                Matcher m = rol.matcher(lineas.get(i));
                Matcher m10 = rolE.matcher(lineas.get(i));
                if(m.find()&&m10.find())
                {
                    if(m.group(4).equals(usuarioBuscarField.getText()))
                    {
                        //Usuario  existe
                        //JOptionPane.showMessageDialog(null, "Usuario existe");
                        if(m10.group(4).contains("0"))
                        {
                            JOptionPane.showMessageDialog(null, "Este usuario esta deshabilitado, no puedes agregarlo");
                            return;
                        }
                        Object[] options = { "Agregar", "Cancelar" };
                        int dialogResult =JOptionPane.showOptionDialog(null, "¿Agregar contacto?", "Agregar contacto",JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,options, options[0]);
                        if(dialogResult == 0)
                        {
                            if(usuarioBuscarField.getText().equals(cuenta))
                            {
                                JOptionPane.showMessageDialog(null, "No estas sol@! busca contactos :')");
                                return;
                            }
                            if(buscarContacto(usuarioBuscarField.getText()))
                            {
                               agregarContacto(usuarioBuscarField.getText(),1);
                               return;
                            }
                            else
                            {
                                return;
                            }
                        } 
                        else 
                        {
                         //pues no   System.out.println("No");
                             return;
                        } 
                       
                    }
                    else
                    {
                        //El usuario no existe :D
                        //  JOptionPane.showMessageDialog(null, "Este usuario no existe");
                    }
                }
                else
                {
                    //No hay usuarios

                }
            }
        }
        catch (IOException ex)
        {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        }
        
        
       
    }//GEN-LAST:event_btnBuscarMouseClicked

    private void jList1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MousePressed
        jList1.setSelectedIndex(jList1.locationToIndex(evt.getPoint()));
        JPopupMenu menu = new JPopupMenu();        
        JPopupMenu menuListas = new JPopupMenu();
        jList1.setSelectedIndex(jList1.getSelectedIndex());
        Color azulColor = new Color(51,153,255);
        jList1.setSelectionBackground(azulColor);
        JMenuItem borrarContactoItem = new JMenuItem("Borrar contacto");
        JMenuItem agregarConntacItem = new JMenuItem("Agregar contacto");
        JMenu agregarALista = new JMenu("Agregar a una lista");
        JMenuItem NuevaLista = new JMenuItem("Agregar nueva lista");
        
        try
        {
                String patronUsuario="(Usuario)(\\:)(	| |)*(.+)(\\|)(C)";
                Pattern usuarioPattern = Pattern.compile(patronUsuario);
                String patronEstatus="(Estatus)(\\:)(	| |)*(.+)";
                Pattern rolE = Pattern.compile(patronEstatus);
                String contactoString="(Contacto)(\\:)(	| |)*(.+)(\\|)(F)";
                Pattern contacPattern = Pattern.compile(contactoString);
              
                List<String> lineasBitacoraList,lineasList;
                lineasList=Files.readAllLines(Path.of("C:\\MEIA\\contactos.txt"));
                lineasBitacoraList = Files.readAllLines(Path.of("C:\\MEIA\\bitacora_contactos.txt"));
                
                for (int i = 0; i < lineasBitacoraList.size(); i++)
                {   
                    Matcher m1 = contacPattern.matcher(lineasBitacoraList.get(i));
                    Matcher m10 = rolE.matcher(lineasBitacoraList.get(i));
                    Matcher m = usuarioPattern.matcher(lineasBitacoraList.get(i));
                    if(m10.find()&&m1.find()&&m.find())
                    {
                        if(m.group(4).equals(cuenta))
                        {
                        if(m1.group(4).equals(jList1.getSelectedValue()))
                        {
                            if(m10.group(4).contains("1"))
                            {
                                menu.add(borrarContactoItem);
                                agregarALista.add(NuevaLista);
                                menu.add(agregarALista);
                            }
                            else
                            {
                                menu.add(agregarConntacItem);
                            }
                        }
                        }
                    }
                }
                for (int i = 0; i < lineasList.size(); i++)
                {   
                    Matcher m1 = contacPattern.matcher(lineasList.get(i));
                    Matcher m10 = rolE.matcher(lineasList.get(i));
                    Matcher m = usuarioPattern.matcher(lineasList.get(i));
                    if(m10.find()&&m1.find()&&m.find())
                    {
                        if(m.group(4).equals(cuenta))
                        {
                        if(m1.group(4).equals(jList1.getSelectedValue()))
                        {
                            if(m10.group(4).contains("1"))
                            {
                                menu.add(borrarContactoItem);
                                agregarALista.add(NuevaLista);
                                menu.add(agregarALista);
                            }
                            else
                            {
                                menu.add(agregarConntacItem);
                            }
                        }
                        }
                    }
                }
            }
         catch(IOException exception)       
         {
         }
        agregarConntacItem.addActionListener((ActionEvent e) -> {
            String patronUsuario="(Usuario)(\\:)(	| |)*(.+)(\\|)(N)";
            String patronEstatus="(Estatus)(\\:)(	| |)*(.+)";   
            Pattern rol = Pattern.compile(patronUsuario);
            Pattern rolE = Pattern.compile(patronEstatus);
            try
            {
                List<String> lineas;
                lineas = Files.readAllLines(Path.of("C:\\MEIA\\usuario.txt"));
                for (int i = 0; i < lineas.size(); i++)
                {
                    Matcher m = rol.matcher(lineas.get(i));
                    Matcher m10 = rolE.matcher(lineas.get(i));
                    if(m.find())
                    {
                        if(m.group(4).equals(jList1.getSelectedValue()))
                        {
                            //Usuario  existe
                            if(m10.find())
                            {
                                if(m10.group(4).contains("0"))
                                {
                                    JOptionPane.showMessageDialog(null, "Usuario deshabilitado, no puedes agregar de nuevo a este contacto");   
                                    return;
                                }
                            }
                        }
                    }
                }
            }
            catch(IOException exception)
            {
            }
            
            Object[] options = { "Agregar", "Cancelar" };
            int dialogResult =JOptionPane.showOptionDialog(null, "¿Seguro que quiere agregar de nuevo a "+jList1.getSelectedValue()+"?", "Agregar contacto",JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,options, options[0]);
            if(dialogResult == 0)
            {
                JOptionPane.showMessageDialog(null, "Contacto reestablecido");
                borrarContactos(jList1.getSelectedValue(),1);
                mostrarContactos();
            }
           
        });
        //
        borrarContactoItem.addActionListener((ActionEvent e) -> {
            Object[] options = { "Borrar", "Cancelar" };
            int dialogResult =JOptionPane.showOptionDialog(null, "¿Seguro que quiere borrar a "+jList1.getSelectedValue()+" de contactos?", "Borrar contacto",JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,options, options[0]);   
            if(dialogResult == 0)
            {
                JOptionPane.showMessageDialog(null, "Contacto borrado");
                borrarContactos(jList1.getSelectedValue(),0);
                mostrarContactos();
            }
            else
            {
                //pues no   System.out.println("No");
                return;
            }
        });
        //LISTAS
        obtenerLista(agregarALista);
        
        NuevaLista.addActionListener((ActionEvent e) -> {    
            JTextField nombreListaField = new JTextField(30);
            JTextField descripcionListaField = new JTextField(30);
            descripcionListaField.setPreferredSize(new java.awt.Dimension(30, 70));
            
            
            JPanel myPanel = new JPanel();
            myPanel.add(new JLabel("Nombre de la lista:"));
            myPanel.add(nombreListaField);
            myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
            myPanel.add(new JLabel("Descripcion:"));
            myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
            myPanel.add(descripcionListaField);
            int result = JOptionPane.showConfirmDialog(null, myPanel,"Ingrese los datos de la nueva lista", JOptionPane.OK_CANCEL_OPTION);
            
            if (result == JOptionPane.OK_OPTION)
            {
                if(nombreListaField.getText().length()<3||nombreListaField.getText().length()>30)
                {
                    JOptionPane.showMessageDialog(null, "El nombre de la lista debe ser mayor a 3 caracteres y menor a 30");
                    return;
                }
                if(nombreListaField.getText().contains("|"))
                {
                    JOptionPane.showMessageDialog(null, "El nombre de la lista no puede contener | ");
                    return;
                }
                if(descripcionListaField.getText().length()<1||descripcionListaField.getText().length()>40)
                {
                    JOptionPane.showMessageDialog(null, "La descripcion no puede estar vacia y no debe ser mayor a 40");
                    return;
                }
                if(descripcionListaField.getText().contains("|"))
                {
                    JOptionPane.showMessageDialog(null, "La descripcion no puede contener | ");
                    return;
                }
                
                if(buscarEnLista(nombreListaField.getText()))
                {
                    //Nueva lista
                    agregarLista(nombreListaField.getText(), descripcionListaField.getText(), 1, 1);
                    
                    //Lista-usuario
                    
                }
                else
                {
                    //Ya existe, agregar en esa lista
                    
                }
                
            }
             
        });
        
        menu.show(jList1, evt.getPoint().x, evt.getPoint().y);     
        
    }//GEN-LAST:event_jList1MousePressed

    private void jList2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList2MousePressed
        jList2.setSelectedIndex(jList2.locationToIndex(evt.getPoint()));
        JPopupMenu menu = new JPopupMenu();
        jList2.setSelectedIndex(jList2.getSelectedIndex());
        Color azulColor = new Color(51,153,255);
        jList2.setSelectionBackground(azulColor);
        JMenuItem borrarLista = new JMenuItem("Borrar Lista");
        JMenuItem agregarLista = new JMenuItem("Activar Lista");
        
        try
        {
                String patronUsuario="(Usuario)(\\:)(	| |)*(.+)(\\|)(F)";
                Pattern usuarioPattern = Pattern.compile(patronUsuario);
                String patronEstatus="(Estatus)(\\:)(	| |)*(.+)";
                Pattern rolE = Pattern.compile(patronEstatus);
                String contactoString="(Nombre Lista)(\\:)(	| |)*(.+)(\\|)(U)";
                Pattern contacPattern = Pattern.compile(contactoString);
              
                List<String> lineasBitacoraList,lineasList;
                lineasList=Files.readAllLines(Path.of("C:\\MEIA\\lista.txt"));
                lineasBitacoraList = Files.readAllLines(Path.of("C:\\MEIA\\bitacora_lista.txt"));
                
                for (int i = 0; i < lineasBitacoraList.size(); i++)
                {   
                    Matcher m1 = contacPattern.matcher(lineasBitacoraList.get(i));
                    Matcher m10 = rolE.matcher(lineasBitacoraList.get(i));
                    Matcher m = usuarioPattern.matcher(lineasBitacoraList.get(i));
                    if(m10.find()&&m1.find()&&m.find())
                    {
                        if(m.group(4).equals(cuenta))
                        {
                        if(m1.group(4).equals(jList2.getSelectedValue()))
                        {
                            if(m10.group(4).contains("1"))
                            {
                                menu.add(borrarLista);
                            }
                            else
                            {
                                menu.add(agregarLista);
                            }
                        }
                        }
                    }
                }
                for (int i = 0; i < lineasList.size(); i++)
                {   
                    Matcher m1 = contacPattern.matcher(lineasList.get(i));
                    Matcher m10 = rolE.matcher(lineasList.get(i));
                    Matcher m = usuarioPattern.matcher(lineasList.get(i));
                    if(m10.find()&&m1.find()&&m.find())
                    {
                        if(m.group(4).equals(cuenta))
                        {
                        if(m1.group(4).equals(jList2.getSelectedValue()))
                        {
                            if(m10.group(4).contains("1"))
                            {
                                menu.add(borrarLista);
                            }
                            else
                            {
                                menu.add(agregarLista);
                            }
                        }
                        }
                    }
                }
            }
         catch(IOException exception)       
         {
         }
        
         borrarLista.addActionListener((ActionEvent e) -> {
            Object[] options = { "Borrar", "Cancelar" };
            int dialogResult =JOptionPane.showOptionDialog(null, "¿Seguro que quiere borrar la lista "+jList2.getSelectedValue()+"?", "Borrar Lista",JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,options, options[0]);   
            if(dialogResult == 0)
            {
                JOptionPane.showMessageDialog(null, "Lista borrada");
                borrarLista(jList2.getSelectedValue(), 0);
                mostrarListas();
            }
        });
        
        
      
         agregarLista.addActionListener((ActionEvent e) -> {            
            Object[] options = { "Agregar", "Cancelar" };
            int dialogResult =JOptionPane.showOptionDialog(null, "¿Seguro que quiere reestablecer la lista "+jList2.getSelectedValue()+"?", "Reestablecer Lista",JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,options, options[0]);
            if(dialogResult == 0)
            {
                JOptionPane.showMessageDialog(null, "Lista reestablecida");
                borrarLista(jList2.getSelectedValue(),1);
                mostrarListas();
            }
           
        });
        
        
        
        
        
         menu.show(jList2, evt.getPoint().x, evt.getPoint().y);     
    }//GEN-LAST:event_jList2MousePressed

    private void jList2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList2MouseMoved
        // TODO add your handling code here:
        jList2.setToolTipText(getToolTipText(evt));
    }//GEN-LAST:event_jList2MouseMoved
   
    
     public String getToolTipText(MouseEvent me) 
     {        
        String usuarioString="(Usuario)(\\:)(	| |)*(.+)(\\|)(F)";
        Pattern usuarioPattern = Pattern.compile(usuarioString);
        
        String descripcionString="(Descripcion)(\\:)(	| |)*(.+)(\\|)(N)";
        Pattern descripcionPattern = Pattern.compile(descripcionString);
        
        String listaString="(Nombre Lista)(\\:)(	| |)*(.+)(\\|)(U)";
        Pattern listaPattern = Pattern.compile(listaString);
        
        String patronEstatus="(Estatus)(\\:)(	| |)*(.+)"; 
        Pattern rolE = Pattern.compile(patronEstatus);
           
        int index = jList2.locationToIndex(me.getPoint());
        
        try 
         {
             List<String> lineas,lineasBitacora;
             lineas = Files.readAllLines(Path.of("C:\\MEIA\\lista.txt"));
             lineasBitacora = Files.readAllLines(Path.of("C:\\MEIA\\bitacora_lista.txt"));
             for (int i = 0; i < lineas.size(); i++)
             {
              Matcher m = usuarioPattern.matcher(lineas.get(i));
              Matcher m1 = listaPattern.matcher(lineas.get(i));
              Matcher m2 = descripcionPattern.matcher(lineas.get(i));
              Matcher m3 = rolE.matcher(lineas.get(i));
                if(m.find()&&m1.find()&&m2.find()&&m3.find())
                {
                    if(m.group(4).equals(cuenta))
                    {
                        
                        if(m1.group(4).equals((String) jList2.getModel().getElementAt(index)))
                        {
                        if(m3.group(4).contains("1"))
                        {
                            return m2.group(4);
                        }
                         else
                        {
                            return "Lista deshabilitada";
                        }
                        }
                        
                    }
                }
             }
             for (int i = 0; i < lineasBitacora.size(); i++)
             {
                 Matcher m = usuarioPattern.matcher(lineasBitacora.get(i));
                 Matcher m1 = listaPattern.matcher(lineasBitacora.get(i));
                 Matcher m2 = descripcionPattern.matcher(lineasBitacora.get(i));
                 Matcher m3 = rolE.matcher(lineasBitacora.get(i));
                 if(m.find()&&m1.find()&&m2.find()&&m3.find())
                 {
                     if(m.group(4).equals(cuenta))
                     {
                         if(m1.group(4).equals((String) jList2.getModel().getElementAt(index)))
                         {
                             if(m3.group(4).contains("1"))
                             {
                                 return m2.group(4);
                             }
                             else
                             {
                                 return "Lista deshabilitada";
                             }
                         }
                     }
                 }
             }
         }
         catch (IOException ex)
         {
             Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
         }  
            
            return null;
     }
    
    
    public int cantidadUsuarios(String nombreLista)
    {
        String patronUsuario="(Usuario)(\\:)(	| |)*(.+)(\\|)(F)";
        Pattern rolUsuario = Pattern.compile(patronUsuario);
        
        String patronListas="(Nombre Lista)(\\:)(	| |)*(.+)(\\|)(U)";   
        Pattern listaPattern = Pattern.compile(patronListas);
        
        String numeroUsuariosString="(Numero Usuarios)(\\:)(	| |)*(.+)(\\|)(E)";   
        Pattern numeroUPattern = Pattern.compile(numeroUsuariosString);
        
        int cantidadUsuarios=0;
        
         try 
         {
             List<String> lineas,lineasBitacora;
             lineas = Files.readAllLines(Path.of("C:\\MEIA\\lista.txt"));
             lineasBitacora = Files.readAllLines(Path.of("C:\\MEIA\\bitacora_lista.txt"));
             for (int i = 0; i < lineas.size(); i++)
             {
              Matcher m = rolUsuario.matcher(lineas.get(i));
              Matcher m1 = listaPattern.matcher(lineas.get(i));
              Matcher m2 = numeroUPattern.matcher(lineas.get(i));
              
                if(m.find()&&m1.find()&&m2.find())
                {
                    if(m.group(4).equals(cuenta))
                    {
                        if(m1.group(4).equals(nombreLista))
                        {
                         cantidadUsuarios+=Integer.parseInt(m2.group(4));
                        }
                    }
                }
             }
             for (int i = 0; i < lineasBitacora.size(); i++)
             {
                 Matcher m = rolUsuario.matcher(lineasBitacora.get(i));
                 Matcher m1 = listaPattern.matcher(lineasBitacora.get(i));
                 Matcher m2 = numeroUPattern.matcher(lineasBitacora.get(i));
                 if(m.find()&&m1.find()&&m2.find())
                 {
                     if(m.group(4).equals(cuenta))
                     {
                         if(m1.group(4).equals(nombreLista))
                         {
                             cantidadUsuarios+=Integer.parseInt(m2.group(4));
                         }
                     }
                 }
             }
         }
         catch (IOException ex)
         {
             Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
         }
        return cantidadUsuarios;
    }
    
    
    
    public int Max()
    {
        String patronDesc="(Max reorganizacion)(\\:)(	| |)*(\\d*)";
        Pattern maxReorganizacion = Pattern.compile(patronDesc);
        try 
        {
             List<String> lineas = Files.readAllLines(Path.of("C:\\MEIA\\desc_usuario.txt"));
             if(lineas.isEmpty())
             {
                 return 3;
             }
             Matcher m = maxReorganizacion.matcher(lineas.get(lineas.size()-1));    
             if(m.find())  
             {
                 return Integer.parseInt(m.group(4));   
             }
             else
             {
                 return 3;   
             }
        } 
        catch (IOException ex) 
        {
    
        }
        return 3;
    }
     public void mostrarContactos()
    {
         String patronUsuario="(Usuario)(\\:)(	| |)*(.+)(\\|)(C)";
         Pattern rolUsuario = Pattern.compile(patronUsuario);
         
         String patronContacto="(Contacto)(\\:)(	| |)*(.+)(\\|)(F)";
         Pattern rolContacto = Pattern.compile(patronContacto);  
         
         String patronEstatus="(Estatus)(\\:)(	| |)*(.+)";
         Pattern rolE = Pattern.compile(patronEstatus);
        
         listaTodosLosContactos.clear();
         listaContactosOcultar.clear();
         listaContactosMostrar.clear();
         List<String> lineas,lineasBitacora;
         try 
         {
           lineas = Files.readAllLines(Path.of("C:\\MEIA\\contactos.txt"));
           lineasBitacora = Files.readAllLines(Path.of("C:\\MEIA\\bitacora_contactos.txt"));
           
           if(lineas.isEmpty()&&lineasBitacora.isEmpty())
           {
               //No tiene contactos, no existen contactos
           }
           else
           {
               for (int i = 0; i < lineas.size(); i++)
               {
                   Matcher m = rolUsuario.matcher(lineas.get(i));
                   Matcher m1 = rolContacto.matcher(lineas.get(i));
                   Matcher estadMatcher = rolE.matcher(lineas.get(i));
                   if(m.find()&&m1.find()&&estadMatcher.find())
                   {
                       if(m.group(4).equals(cuenta))
                       {
                           if(estadMatcher.group(4).contains("1"))
                           {
                               listaContactosMostrar.addElement(m1.group(4));
                           }
                           else
                           {
                               listaContactosOcultar.addElement(m1.group(4));
                           }
                       }
                   }
               }
               for (int i = 0; i < lineasBitacora.size(); i++)
               {  
                   Matcher m2 = rolUsuario.matcher(lineasBitacora.get(i));
                   Matcher m3 = rolContacto.matcher(lineasBitacora.get(i));
                   Matcher estadMatcher = rolE.matcher(lineasBitacora.get(i));
                   if(m2.find()&&m3.find()&&estadMatcher.find())
                   {
                       if(m2.group(4).equals(cuenta))
                       {        
                         if(estadMatcher.group(4).contains("1"))
                           {
                           
                               listaContactosMostrar.addElement(m3.group(4));
                           }
                           else
                           {
                               listaContactosOcultar.addElement(m3.group(4));
                           }
                       }
                   }
               }
                listaContactosMostrar=new Globales().ordenarListaContactos(listaContactosMostrar); 
                listaContactosOcultar=new Globales().ordenarListaContactos(listaContactosOcultar);
               for (int i = 0; i < listaContactosMostrar.size(); i++) 
                {
                    listaTodosLosContactos.addElement(listaContactosMostrar.getElementAt(i));
                }
                for (int i = 0; i < listaContactosOcultar.size(); i++) 
                {
                    listaTodosLosContactos.addElement(listaContactosOcultar.getElementAt(i));
                }
                
                
                jList1.setModel(listaTodosLosContactos);         
                
                for (int i = 0; i < jList1.getModel().getSize(); i++) 
                {
                    for (int j = 0; j < listaContactosOcultar.size(); j++)
                    {
                       if(jList1.getModel().getElementAt(i).equals(listaContactosOcultar.getElementAt(j)))
                       {
                        ImageIcon iconoIcon= new ImageIcon("src/main/java/Imagenes/desconectado.png");
                        Image ajustarImgI = iconoIcon.getImage();                   
                        Image ajustarTamañoI= ajustarImgI.getScaledInstance(30,30, Image.SCALE_SMOOTH);
                        icons.put(jList1.getModel().getElementAt(i), new ImageIcon(ajustarTamañoI));
                        jList1.setCellRenderer(new RenderDeIconos(icons));
                       }
                    }
                    for (int j = 0; j < listaContactosMostrar.size(); j++)
                    {
                        if(jList1.getModel().getElementAt(i).equals(listaContactosMostrar.getElementAt(j)))   
                        {
                          String ubicacion="C:\\MEIA\\Fotografias\\"+jList1.getModel().getElementAt(i)+".jpg";
                          File f = new File(ubicacion);
                          if(!(f.exists() && !f.isDirectory())) 
                          {
                              ubicacion="C:\\MEIA\\Fotografias\\"+jList1.getModel().getElementAt(i)+".png";
                          }
                        ImageIcon iconoIcon= new ImageIcon(ubicacion);
                        Image ajustarImgI = iconoIcon.getImage();                   
                        Image ajustarTamañoI= ajustarImgI.getScaledInstance(30,30, Image.SCALE_SMOOTH);
                        icons.put(jList1.getModel().getElementAt(i), new ImageIcon(ajustarTamañoI));
                        jList1.setCellRenderer(new RenderDeIconos(icons));
                        }
                    }
                }
         }
         }
         catch (IOException ex)
         {
           Logger.getLogger(IFEstandar.class.getName()).log(Level.SEVERE, null, ex);
         }
           
    }
      public void mostrarListas()
    {
         String patronUsuario="(Usuario)(\\:)(	| |)*(.+)(\\|)(F)";
         Pattern rolUsuario = Pattern.compile(patronUsuario);
         
         String patronListas="(Nombre Lista)(\\:)(	| |)*(.+)(\\|)(U)";
         Pattern listaPattern = Pattern.compile(patronListas);
         
         
         String patronEstatus="(Estatus)(\\:)(	| |)*(.+)";
         Pattern rolE = Pattern.compile(patronEstatus);
        
         listaTodasLasListas.clear();
         listaListasOcultar.clear();
         listaListasMostrar.clear();
         List<String> lineas,lineasBitacora;
         try 
         {
           lineas = Files.readAllLines(Path.of("C:\\MEIA\\lista.txt"));
           lineasBitacora = Files.readAllLines(Path.of("C:\\MEIA\\bitacora_lista.txt"));
           
           if(lineas.isEmpty()&&lineasBitacora.isEmpty())
           {
               //No tiene contactos, no existen contactos
           }
           else
           {
               for (int i = 0; i < lineas.size(); i++)
               {
                   Matcher m = rolUsuario.matcher(lineas.get(i));
                   Matcher m1 = listaPattern.matcher(lineas.get(i));
                   Matcher estadMatcher = rolE.matcher(lineas.get(i));
                   if(m.find()&&estadMatcher.find()&&m1.find())
                   {
                       if(m.group(4).equals(cuenta))
                       {
                           if(estadMatcher.group(4).contains("1"))
                           {
                               listaListasMostrar.addElement(m1.group(4));
                           }
                           else
                           {
                               listaListasOcultar.addElement(m1.group(4));
                           }
                       }
                   }
               }
               for (int i = 0; i < lineasBitacora.size(); i++)
               {  
                   Matcher m2 = rolUsuario.matcher(lineasBitacora.get(i));
                   Matcher m3 = listaPattern.matcher(lineasBitacora.get(i));
                   Matcher estadMatcher = rolE.matcher(lineasBitacora.get(i));
                   if(m2.find()&&m3.find()&&estadMatcher.find())
                   {
                       if(m2.group(4).equals(cuenta))
                       {        
                         if(estadMatcher.group(4).contains("1"))
                           {
                           
                               listaListasMostrar.addElement(m3.group(4));
                           }
                           else
                           {
                               listaListasOcultar.addElement(m3.group(4));
                           }
                       }
                   }
               }
               
                listaListasMostrar=new Globales().ordenarListaContactos(listaListasMostrar); 
                listaListasOcultar=new Globales().ordenarListaContactos(listaListasOcultar);
               for (int i = 0; i < listaListasMostrar.size(); i++) 
                {
                    listaTodasLasListas.addElement(listaListasMostrar.getElementAt(i));
                }
                for (int i = 0; i < listaListasOcultar.size(); i++) 
                {
                    listaTodasLasListas.addElement(listaListasOcultar.getElementAt(i));
                }
                
                
                jList2.setModel(listaTodasLasListas);
                
                for (int i = 0; i < jList2.getModel().getSize(); i++) 
                {
                    for (int j = 0; j < listaListasOcultar.size(); j++)
                    {
                       if(jList2.getModel().getElementAt(i).equals(listaListasOcultar.getElementAt(j)))
                       {
                        Image ajustarImgI =  ImageIO.read(new File("src/main/java/Imagenes/desconectado.png"));
                        Image ajustarTamañoI= ajustarImgI.getScaledInstance(30,30, Image.SCALE_SMOOTH);
                        ImageIcon icon = new ImageIcon(ajustarTamañoI);
                        numerosMap.put(jList2.getModel().getElementAt(i),icon);
                        jList2.setCellRenderer(new RenderNumeros(numerosMap));
                       }
                    } 
                    for (int j = 0; j < listaListasMostrar.size(); j++)
                    {
                        if(jList2.getModel().getElementAt(i).equals(listaListasMostrar.getElementAt(j)))   
                        {
                            if(cantidadUsuarios(jList2.getModel().getElementAt(i))>9)
                            {
                                numerosMap.put(jList2.getModel().getElementAt(i), new DynamicIcon(cantidadUsuarios(jList2.getModel().getElementAt(i))+" "));
                                jList2.setCellRenderer(new RenderNumeros(numerosMap));
                            }
                            else
                            {
                                numerosMap.put(jList2.getModel().getElementAt(i), new DynamicIcon(cantidadUsuarios(jList2.getModel().getElementAt(i))+"  "));
                                jList2.setCellRenderer(new RenderNumeros(numerosMap));
                            }
                        }
                    }
                   
                }
                
                
           }
         }
         catch (IOException ex)
         {
           Logger.getLogger(IFEstandar.class.getName()).log(Level.SEVERE, null, ex);
         }
           
         
         
    }
    public boolean buscarContacto(String contactoB)
    {
        String usuarioString="(Usuario)(\\:)(	| |)*(.+)(\\|)(C)";
        Pattern usuarioPattern = Pattern.compile(usuarioString);
        String contactoString="(Contacto)(\\:)(	| |)*(.+)(\\|)(F)";
        Pattern contacPattern = Pattern.compile(contactoString);
         try 
         {
             List<String> lineas,lineasBitacora;
             lineas = Files.readAllLines(Path.of("C:\\MEIA\\contactos.txt"));
             lineasBitacora = Files.readAllLines(Path.of("C:\\MEIA\\bitacora_contactos.txt"));
             for (int i = 0; i < lineas.size(); i++)
             {
              Matcher m = usuarioPattern.matcher(lineas.get(i));
              Matcher m1 = contacPattern.matcher(lineas.get(i));
                if(m.find()&&m1.find())
                {
                    if(m.group(4).equals(cuenta))
                    {
                        if(m1.group(4).equals(contactoB))
                        {
                         JOptionPane.showMessageDialog(null, "Ya tienes a "+contactoB+" como contacto");
                         return false;
                        }
                    }
                }   
             }
             for (int i = 0; i < lineasBitacora.size(); i++)
             {
              Matcher m = usuarioPattern.matcher(lineasBitacora.get(i));
              Matcher m1 = contacPattern.matcher(lineasBitacora.get(i));
              if(m.find()&&m1.find())  
              {
                  if(m.group(4).equals(cuenta))
                  {
                      if(m1.group(4).equals(contactoB))   
                      {
                         JOptionPane.showMessageDialog(null, "Ya tienes a "+contactoB+" como contacto");
                         return false;
                      }
                  }
              }   
             }
         }
           
         catch (IOException ex)
         {
             Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
         }
         return true;
    }
    
    public void borrarContactos(String contactoB,int operacion)
    {
        String usuarioString="(Usuario)(\\:)(	| |)*(.+)(\\|)(C)";
        Pattern usuarioPattern = Pattern.compile(usuarioString);
        String contactoString="(Contacto)(\\:)(	| |)*(.+)(\\|)(F)";
        Pattern contacPattern = Pattern.compile(contactoString);
         try 
         {
             List<String> lineas,lineasBitacora;
             lineas = Files.readAllLines(Path.of("C:\\MEIA\\contactos.txt"));
             lineasBitacora = Files.readAllLines(Path.of("C:\\MEIA\\bitacora_contactos.txt"));
             for (int i = 0; i < lineas.size(); i++)
             {
              Matcher m = usuarioPattern.matcher(lineas.get(i));
              Matcher m1 = contacPattern.matcher(lineas.get(i));
                if(m.find()&&m1.find())
                {
                    if(m.group(4).equals(cuenta))
                    {
                        if(m1.group(4).equals(contactoB))
                        {
                         lineas.remove(i);
                         Path out = Paths.get("C:\\MEIA\\contactos.txt");
              Files.write(out,lineas); 
              Iterator<String> i2It = lineas.iterator();
              while (i2It.hasNext())
              {
                  String line = i2It.next();
                  if (line.trim().isEmpty())
                      i2It.remove();       
              }              
              Files.write(Path.of("C:\\MEIA\\contactos.txt"), lineas);
                         agregarContacto(contactoB, operacion);
                        }
                    }
                }   
             }
             for (int i = 0; i < lineasBitacora.size(); i++)
             {
                 Matcher m = usuarioPattern.matcher(lineasBitacora.get(i));
                 Matcher m1 = contacPattern.matcher(lineasBitacora.get(i));
                 if(m.find()&&m1.find())
                 {
                     if(m.group(4).equals(cuenta))
                     {
                         if(m1.group(4).equals(contactoB))
                         {
                             lineasBitacora.remove(i);
                             Path out1 = Paths.get("C:\\MEIA\\bitacora_contactos.txt");                
                             Files.write(out1,lineasBitacora);
                             Iterator<String> it = lineasBitacora.iterator();
                             while (it.hasNext())
                             {
                                 String line = it.next();
                                 if (line.trim().isEmpty())
                                     it.remove();
                             }
                             Files.write(Path.of("C:\\MEIA\\bitacora_contactos.txt"), lineasBitacora);
                             agregarContacto(contactoB, operacion);
                      
                         }
                     }
                 }
             }
         }
         catch (IOException ex)
         {
             Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    public void borrarLista(String nombreLista,int operacion)
    {
        String usuarioString="(Usuario)(\\:)(	| |)*(.+)(\\|)(F)";
        Pattern usuarioPattern = Pattern.compile(usuarioString);
        
        String descripcionString="(Descripcion)(\\:)(	| |)*(.+)(\\|)(N)";
        Pattern descripcionPattern = Pattern.compile(descripcionString);
        
        String listaString="(Nombre Lista)(\\:)(	| |)*(.+)(\\|)(U)";
        Pattern listaPattern = Pattern.compile(listaString);
         try 
         {
             List<String> lineas,lineasBitacora;
             lineas = Files.readAllLines(Path.of("C:\\MEIA\\lista.txt"));
             lineasBitacora = Files.readAllLines(Path.of("C:\\MEIA\\bitacora_lista.txt"));
             for (int i = 0; i < lineas.size(); i++)
             {
              Matcher m = usuarioPattern.matcher(lineas.get(i));
              Matcher m1 = listaPattern.matcher(lineas.get(i));
              Matcher m2 = descripcionPattern.matcher(lineas.get(i));
                if(m.find()&&m1.find()&&m2.find())
                {
                    if(m.group(4).equals(cuenta))
                    {
                        if(m1.group(4).equals(nombreLista))
                        {
                         lineas.remove(i);
                         Path out = Paths.get("C:\\MEIA\\lista.txt");
                         Files.write(out,lineas);
                         Iterator<String> i2It = lineas.iterator();
                         while (i2It.hasNext())
                         {
                             String line = i2It.next();
                             if (line.trim().isEmpty())
                                 i2It.remove();
                         }
                         Files.write(Path.of("C:\\MEIA\\lista.txt"), lineas);
                         agregarLista(nombreLista, m2.group(4), operacion, cantidadUsuarios(nombreLista));
                        
                        }
                    }
                }
             }
             for (int i = 0; i < lineasBitacora.size(); i++)
             {
                 Matcher m = usuarioPattern.matcher(lineasBitacora.get(i));
                 Matcher m1 = listaPattern.matcher(lineasBitacora.get(i));
                 Matcher m2 = descripcionPattern.matcher(lineasBitacora.get(i));
                 if(m.find()&&m1.find()&&m2.find())
                 {
                     if(m.group(4).equals(cuenta))
                     {
                         if(m1.group(4).equals(nombreLista))
                         {
                             lineasBitacora.remove(i);
                             Path out1 = Paths.get("C:\\MEIA\\bitacora_lista.txt");                
                             Files.write(out1,lineasBitacora);
                             Iterator<String> it = lineasBitacora.iterator();
                             while (it.hasNext())
                             {
                                 String line = it.next();
                                 if (line.trim().isEmpty())
                                     it.remove();
                             }
                             Files.write(Path.of("C:\\MEIA\\bitacora_lista.txt"), lineasBitacora);
                            agregarLista(nombreLista, m2.group(4), operacion, cantidadUsuarios(nombreLista));
                         }
                     }
                 }
             }
         }
         catch (IOException ex)
         {
             Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    public void agregarContacto(String contactoN,int operacion)
    {
        String patron="(Estatus)(\\:)(	| |)*(\\d)";
        Pattern estatus = Pattern.compile(patron);
        
        Path p = Paths.get("C:\\MEIA\\bitacora_contactos.txt");
        
        String jfecha = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
        String s = System.lineSeparator() + "Usuario:"+cuenta+"|"+ "Contacto:"+contactoN+"|"
                 + "Fecha de transaccion:"+jfecha+"|"+ "Usuario transaccion:"+cuenta+"|"+ "Estatus:"+operacion;
        
        try (BufferedWriter writer = Files.newBufferedWriter(p, StandardOpenOption.APPEND))   
        {
               writer.write(s);
               writer.close();
        }
         
        catch (IOException ioe) 
        {
               System.err.format("IOException: %s%n", ioe);
        }
        int cantidadCuentas=0;
        int cantidadActivos=0;
        int cantidadInactivos=0;
        try 
        {
            List<String> lineas = Files.readAllLines(Path.of("C:\\MEIA\\bitacora_contactos.txt"));
            for (int i = 0; i < lineas.size(); i++)
            {
                Matcher m = estatus.matcher(lineas.get(i));
                if(m.find())
                {
                    cantidadCuentas++;
                    if(m.group(4).contains("1"))
                    {
                     //Esta activo
                        cantidadActivos++;
                    }   
                    else   
                    {
                      //No esta activo
                        cantidadInactivos++;
                    }
                }   
            }   
            
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex); 
            JOptionPane.showMessageDialog(null,"Ocurrio un error" );
            return;
        }  
        
        /////////////////////////////////////////////////////////////////////////
        try 
            {
               
         //HAY ARCHIVOS,VERIFICAR SI EXISTE UN ADMIN
             String nombresimbolicoString;
             
             if (operacion==1)             
             {
                 nombresimbolicoString="crear contacto";  
             }
             else
             {
                 nombresimbolicoString="borrar contacto";
             }
             List<String> lineas;
             lineas = Files.readAllLines(Path.of("C:\\MEIA\\bitacora_contactos.txt"));
             lineas.set(0, "Nombre simbolico:"+nombresimbolicoString+"|"+"Fecha Creacion:"+jfecha+"|"+"Usuario Creacion:"+
                     cuenta+"|"+"# Registros:"+cantidadCuentas+"|"+"Registros Activos:"+cantidadActivos+"|"+
                             "Registros Inactivos:"+cantidadInactivos+"|"+"Max reorganizacion:"+maximaReorganizacion);
                
             Path out = Paths.get("C:\\MEIA\\bitacora_contactos.txt");
             Files.write(out,lineas);
             
                      
             lineas = Files.readAllLines(Path.of("C:\\MEIA\\bitacora_contactos.txt"));
             Iterator<String> i = lineas.iterator();
             while (i.hasNext())
             {
                 String line = i.next();
                 if (line.trim().isEmpty())
                     i.remove();       
             }
             Files.write(Path.of("C:\\MEIA\\bitacora_contactos.txt"), lineas);             
             
             }
             catch (IOException ex) 
             {
                        Logger.getLogger(IFingreso.class.getName()).log(Level.SEVERE, null, ex);
             }
        
        
        if(cantidadCuentas>=maximaReorganizacion)
        {
            //JOptionPane.showMessageDialog(null,"Cantidad de cuentas:"+cantidadCuentas );
            try
            {
         
                String patronEstatus="(Estatus)(\\:)(	| |)*(.+)";
                Pattern rolE = Pattern.compile(patronEstatus);
                List<String> lineas;
                lineas = Files.readAllLines(Path.of("C:\\MEIA\\bitacora_contactos.txt"));
                List<String> cuentasList = new ArrayList<String>();
                for (int i = 0; i < lineas.size(); i++)
                {   
                    Matcher m10 = rolE.matcher(lineas.get(i));
                    if(m10.find())
                    {
                        cuentasList.add(lineas.get(i));
                        lineas.remove(i);
                        i=0;
                    }
                }
                Path out = Paths.get("C:\\MEIA\\bitacora_contactos.txt");   
                Files.write(out,lineas);
                
                             
                lineas = Files.readAllLines(Path.of("C:\\MEIA\\bitacora_contactos.txt"));             
                Iterator<String> i = lineas.iterator();
                while (i.hasNext())
                {
                 String line = i.next();
                 if (line.trim().isEmpty())
                     i.remove();
                }
             Files.write(Path.of("C:\\MEIA\\bitacora_contactos.txt"), lineas);   
                
                p = Paths.get("C:\\MEIA\\contactos.txt");
        
        
                try (BufferedWriter writer = Files.newBufferedWriter(p, StandardOpenOption.APPEND))
                {
                    for(String str: cuentasList) 
                    {
                        writer.write(System.lineSeparator()+str);
                    }
                }
                lineas = Files.readAllLines(Path.of("C:\\MEIA\\contactos.txt"));             
                Iterator<String> i2It = lineas.iterator();
                while (i2It.hasNext())
                {
                 String line = i2It.next();
                 if (line.trim().isEmpty())
                     i2It.remove();
                }
             Files.write(Path.of("C:\\MEIA\\contactos.txt"), lineas);  
                
             }
             catch (IOException ex) 
             {
                        Logger.getLogger(IFingreso.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
        mostrarContactos();
    }
    public boolean buscarEnLista(String nombreLista)
    {
        String nombreListaString="(Nombre Lista)(\\:)(	| |)*(.+)(\\|)(U)";
        Pattern listaPattern = Pattern.compile(nombreListaString);
        String usuario="(Usuario)(\\:)(	| |)*(.+)(\\|)(F)";
        Pattern usuarioPattern = Pattern.compile(usuario);
         try 
         {
             List<String> lineas,lineasBitacora;
             lineas = Files.readAllLines(Path.of("C:\\MEIA\\lista.txt"));
             lineasBitacora = Files.readAllLines(Path.of("C:\\MEIA\\bitacora_lista.txt"));
             for (int i = 0; i < lineas.size(); i++)
             {
              Matcher m = listaPattern.matcher(lineas.get(i));
              Matcher m1 = usuarioPattern.matcher(lineas.get(i));
                if(m.find()&&m1.find())
                {
                    if(m.group(4).equals(nombreLista))
                    {
                        if(m1.group(4).equals(cuenta))
                        {
                         JOptionPane.showMessageDialog(null, "Ya tienes una lista llamada "+nombreLista);
                         return false;
                        }
                    }
                }   
             }
             for (int i = 0; i < lineasBitacora.size(); i++)
             {
              Matcher m = listaPattern.matcher(lineasBitacora.get(i));
              Matcher m1 = usuarioPattern.matcher(lineasBitacora.get(i));
              if(m.find()&&m1.find())  
              {
                  if(m.group(4).equals(nombreLista))
                  {
                      if(m1.group(4).equals(cuenta))   
                      {
                         JOptionPane.showMessageDialog(null, "Ya tienes una lista llamada "+nombreLista);
                         return false;
                      }
                  }
              }   
             }
         }
           
         catch (IOException ex)
         {
             Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
         }
         return true;
    }
    
    public void obtenerLista(JMenu menu)
    {
        String patronEstatus="(Estatus)(\\:)(	| |)*(.+)";
        Pattern rolE = Pattern.compile(patronEstatus);
        String nombreListaString="(Nombre Lista)(\\:)(	| |)*(.+)(\\|)(U)";
        Pattern listaPattern = Pattern.compile(nombreListaString);
        String usuario="(Usuario)(\\:)(	| |)*(.+)(\\|)(F)";
        Pattern usuarioPattern = Pattern.compile(usuario);
         try 
         {
             List<String> lineas,lineasBitacora;
             lineas = Files.readAllLines(Path.of("C:\\MEIA\\lista.txt"));
             lineasBitacora = Files.readAllLines(Path.of("C:\\MEIA\\bitacora_lista.txt"));
             for (int i = 0; i < lineas.size(); i++)
             {
              Matcher m = rolE.matcher(lineas.get(i));
              Matcher m1 = usuarioPattern.matcher(lineas.get(i));
              Matcher m2 = listaPattern.matcher(lineas.get(i));
              
                if(m.find()&&m1.find()&&m2.find())
                {
                    if(m1.group(4).equals(cuenta))
                    {
                        if(m.group(4).contains("1"))
                        {
                         menu.add(new JMenuItem(new AccionesEnLasListas(m2.group(4))));
                        }
                    }
                }   
             }
             for (int i = 0; i < lineasBitacora.size(); i++)
             {
              Matcher m = rolE.matcher(lineasBitacora.get(i));
              Matcher m1 = usuarioPattern.matcher(lineasBitacora.get(i));            
              Matcher m2 = listaPattern.matcher(lineasBitacora.get(i));
             
              if(m.find()&&m1.find()&&m2.find())
              {  
                  if(m1.group(4).equals(cuenta))
                  {
                      if(m.group(4).contains("1"))   
                      {
                         menu.add(new JMenuItem(new AccionesEnLasListas(m2.group(4))));
                      }
                  }
              }   
             }
         }
           
         catch (IOException ex)
         {
             Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
         }
       
    }
    
    public void agregarLista(String nombreListaString,String descripcionString,int operacion,int numeroUsuarios)
    {
        String patron="(Estatus)(\\:)(	| |)*(\\d)";
        Pattern estatus = Pattern.compile(patron);
        
        Path p = Paths.get("C:\\MEIA\\bitacora_lista.txt");
        
        String jfecha = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
        String s = System.lineSeparator() + "Nombre Lista:"+nombreListaString+"|"+ "Usuario:"+cuenta+"|"
                 + "Fecha Creacion:"+jfecha+"|"+ "Descripcion:"+descripcionString+"|"+"Numero Usuarios:"+numeroUsuarios+"|"+ "Estatus:"+operacion;
        
        try (BufferedWriter writer = Files.newBufferedWriter(p, StandardOpenOption.APPEND))   
        {
               writer.write(s);
               writer.close();
        }
         
        catch (IOException ioe) 
        {
               System.err.format("IOException: %s%n", ioe);
        }
        int cantidadCuentas=0;
        int cantidadActivos=0;
        int cantidadInactivos=0;
        try 
        {
            List<String> lineas = Files.readAllLines(Path.of("C:\\MEIA\\bitacora_lista.txt"));
            for (int i = 0; i < lineas.size(); i++)
            {
                Matcher m = estatus.matcher(lineas.get(i));
                if(m.find())
                {
                    cantidadCuentas++;
                    if(m.group(4).contains("1"))
                    {
                     //Esta activo
                        cantidadActivos++;
                    }   
                    else   
                    {
                      //No esta activo
                        cantidadInactivos++;
                    }
                }   
            }   
            
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex); 
            JOptionPane.showMessageDialog(null,"Ocurrio un error" );
            return;
        }  
        
        /////////////////////////////////////////////////////////////////////////
        try 
            {
               
         //HAY ARCHIVOS,VERIFICAR SI EXISTE UN ADMIN
             String nombresimbolicoString;
             
             if (operacion==1)             
             {
                 nombresimbolicoString="Crear lista";  
             }
             else
             {
                 nombresimbolicoString="Borrar lista";
             }
             List<String> lineas;
             lineas = Files.readAllLines(Path.of("C:\\MEIA\\bitacora_lista.txt"));
             lineas.set(0, "Nombre simbolico:"+nombresimbolicoString+"|"+"Fecha Creacion:"+jfecha+"|"+"Usuario Creacion:"+
                     cuenta+"|"+"# Registros:"+cantidadCuentas+"|"+"Registros Activos:"+cantidadActivos+"|"+
                             "Registros Inactivos:"+cantidadInactivos+"|"+"Max reorganizacion:"+maximaReorganizacion);
                
             Path out = Paths.get("C:\\MEIA\\bitacora_lista.txt");
             Files.write(out,lineas);
             
             lineas = Files.readAllLines(Path.of("C:\\MEIA\\bitacora_lista.txt"));
             Iterator<String> i = lineas.iterator();
             while (i.hasNext())
             {
                 String line = i.next();
                 if (line.trim().isEmpty())
                     i.remove();       
             }
             Files.write(Path.of("C:\\MEIA\\bitacora_lista.txt"), lineas);             
             
             }
             catch (IOException ex) 
             {
                        Logger.getLogger(IFingreso.class.getName()).log(Level.SEVERE, null, ex);
             }
        
        
        if(cantidadCuentas>=maximaReorganizacion)
        {
            //JOptionPane.showMessageDialog(null,"Cantidad de cuentas:"+cantidadCuentas );
            try
            {
                String patronEstatus="(Estatus)(\\:)(	| |)*(.+)";
                Pattern rolE = Pattern.compile(patronEstatus);
                List<String> lineas;
                lineas = Files.readAllLines(Path.of("C:\\MEIA\\bitacora_lista.txt"));
                List<String> cuentasList = new ArrayList<String>();
                for (int i = 0; i < lineas.size(); i++)
                {   
                    Matcher m10 = rolE.matcher(lineas.get(i));
                    if(m10.find())
                    {
                        cuentasList.add(lineas.get(i));
                        lineas.remove(i);
                        i=0;
                    }
                }
                Path out = Paths.get("C:\\MEIA\\bitacora_lista.txt");   
                Files.write(out,lineas);
                
                lineas = Files.readAllLines(Path.of("C:\\MEIA\\bitacora_lista.txt"));             
                Iterator<String> i = lineas.iterator();
                while (i.hasNext())
                {
                 String line = i.next();
                 if (line.trim().isEmpty())
                     i.remove();
                }
                
                Files.write(Path.of("C:\\MEIA\\bitacora_lista.txt"), lineas); 
                p = Paths.get("C:\\MEIA\\lista.txt");
        
        
                try (BufferedWriter writer = Files.newBufferedWriter(p, StandardOpenOption.APPEND))
                {
                    for(String str: cuentasList) 
                    {
                        writer.write(System.lineSeparator()+str);
                    }
                }
                lineas = Files.readAllLines(Path.of("C:\\MEIA\\lista.txt"));             
                Iterator<String> i2It = lineas.iterator();
                while (i2It.hasNext())
                {
                 String line = i2It.next();
                 if (line.trim().isEmpty())
                     i2It.remove();
                }
             Files.write(Path.of("C:\\MEIA\\lista.txt"), lineas);  
                
             }
             catch (IOException ex) 
             {
                        Logger.getLogger(IFingreso.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
       mostrarListas();
    }


    private class AccionesEnLasListas extends AbstractAction {
        public AccionesEnLasListas(String name) {
            super(name);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            //System.out.println("Menu item: " + e.getActionCommand());
            Object[] options = { "Agregar", "Cancelar" };                        
            int dialogResult =JOptionPane.showOptionDialog(null, "¿Agregar "+jList1.getSelectedValue()+" a la lista "+e.getActionCommand()+"?", "Agregar contacto a lista",JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,options, options[0]);
            if(dialogResult == 0)
            {
                //Si
                JOptionPane.showMessageDialog(null, "Agregado");
                //codigo 
            }
            else
            {
                
            }
                       
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IFEstandar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IFEstandar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IFEstandar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IFEstandar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new IFEstandar(IFingreso.cuenta).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Foto;
    private javax.swing.JLabel btnBuscar;
    private javax.swing.JLabel btnMod;
    private javax.swing.JLabel btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblBienvenido;
    // End of variables declaration//GEN-END:variables
}