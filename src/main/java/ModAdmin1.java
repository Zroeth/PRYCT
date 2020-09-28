
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Zer0
 */
public class ModAdmin1 extends javax.swing.JFrame {

    public boolean rol;
    public String cuentaC;
    public String usuarioMod;
    /**
     * Creates new form Registro
     */
   
    
    String usuarioModTemp;
    int lineaBorrar;
    
        private ModAdmin1(boolean rol, String cuenta,String Usuariomod) {
        //JOptionPane.showMessageDialog(null, rol);
        setUndecorated(true);
        initComponents();
        getContentPane().setBackground(Color.white);
         
     
        
        ImageIcon imIc3= new ImageIcon("src/main/java/Imagenes/btnFoto.png");
        Foto.setIcon(imIc3);
        
        ImageIcon imIc= new ImageIcon("src/main/java/Imagenes/btnCancelar.gif");
        btnSalir1.setIcon(imIc);
        
        ImageIcon imIc2= new ImageIcon("src/main/java/Imagenes/btnGuardar.gif");
        btnCrear.setIcon(imIc2);
       
        
        cuentaC=cuenta;
        
       
        
        usuarioMod=Usuariomod;
      
       camposHabilitados(rol);
        
        
        
        String patronUsuario="(Usuario)(\\:)(	| |)*(.+)(\\|)(N)";
        String patronNombre="(Nombre)(\\:)(	| |)*(.+)(\\|)(A)";
        String patronApellido="(Apellido)(\\:)(	| |)*(.+)(\\|)(Con)";
        String patronContraseña="(Contraseña)(\\:)(	| |)*(.+)(\\|)(R)";
        String patronRol="(Rol)(\\:)(	| |)*(.+)(\\|)(F)";
        String patronFechaDN="(Fecha de nacimiento)(\\:)(	| |)*(.+)(\\|)(C)";
        String patronCorreo="(Correo alterno)(\\:)(	| |)*(.+)(\\|)(T)";
        String patronTelefono="(Telefono)(\\:)(	| |)*(.+)(\\|)(P)";
        String patronPathFoto="(Path_Fotografia)(\\:)(	| |)*(.+)(\\|)(E)";
        String patronEstatus="(Estatus)(\\:)(	| |)*(.+)";
        
        
        Pattern rolU = Pattern.compile(patronUsuario);
        Pattern rolN = Pattern.compile(patronNombre);
        Pattern rolA = Pattern.compile(patronApellido);
        Pattern rolC = Pattern.compile(patronContraseña);
        Pattern rolR = Pattern.compile(patronRol);
        Pattern rolF = Pattern.compile(patronFechaDN);
        Pattern rolCrr = Pattern.compile(patronCorreo);
        Pattern rolTel = Pattern.compile(patronTelefono);
        Pattern rolPath = Pattern.compile(patronPathFoto);
        Pattern rolE = Pattern.compile(patronEstatus);
        
        
        
        
        
        try {
                List<String> lineas;
                lineas = Files.readAllLines(Path.of("C:\\MEIA\\usuario.txt"));
                for (int i = 0; i < lineas.size(); i++)
                {
                    Matcher m = rolU.matcher(lineas.get(i));
                    Matcher m2 = rolN.matcher(lineas.get(i));
                    Matcher m3 = rolA.matcher(lineas.get(i));
                    Matcher m4 = rolC.matcher(lineas.get(i));
                    Matcher m5 = rolR.matcher(lineas.get(i));
                    Matcher m6 = rolF.matcher(lineas.get(i));
                    Matcher m7 = rolCrr.matcher(lineas.get(i));
                    Matcher m8 = rolTel.matcher(lineas.get(i));
                    Matcher m9 = rolPath.matcher(lineas.get(i));
                    Matcher m10 = rolE.matcher(lineas.get(i));
                    
                    if(m.find()&&m2.find()&&m3.find()&&m4.find()&&m5.find()&&m6.find()&&m7.find()&&m8.find()&&m9.find()&&m10.find())
                    {   
                        if(m.group(4).equals(Usuariomod))
                        {
                            //Usuario  existe
                            txtNombre.setText(m2.group(4));
                            usuarioModTemp=lineas.get(i);
                            txtApellido.setText(m3.group(4));
                            //txtContraseña.setText(m4.group(4));
                            if(m5.group(4).contains("1"))
                            {
                                opRol.setSelected(true);
                                
                            }
                            else
                            {
                                opRol.setSelected(false);
                            }
                            try
                            
                            {Date date2;
                                //JOptionPane.showMessageDialog(null, fecha);
                                date2 = new SimpleDateFormat("dd/MM/yyyy").parse(m6.group(4));
                                jDateChooser1.setDate(date2);
                            } 
                            catch (ParseException ex) 
                            {
                                Logger.getLogger(RegistroAdmin.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            txtCorreo.setText(m7.group(4));
                            txtTelefono.setText(m8.group(4));
                            pathFotografia=m9.group(4);
                            
                            
                             ImageIcon imIc4= new ImageIcon(pathFotografia);
        Image ajustarImg = imIc4.getImage();
        Image ajustarTamaño= ajustarImg.getScaledInstance(Foto.getWidth(),Foto.getHeight(), Image.SCALE_SMOOTH);
        
        Foto.setIcon(new ImageIcon(ajustarTamaño));
       
                            
                            
                            if(m10.group(4).contains("1"))
                            {
                                opEstatus.setSelected(true);
                                
                            }
                            else
                            {
                                opEstatus.setSelected(false);
                            }
                            lineaBorrar=i;
                       
        
         
                           
                        }
                    }
                
                }
                    Path out = Paths.get("C:\\MEIA\\usuario.txt");
                    Files.write(out,lineas);
        }
        catch (IOException ex)    
        {
                Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        
        
        
        
        
        
        
        
        
        
    }
    
    
    
    void camposHabilitados(boolean rol)
    {
      //opRol.setEnabled(rol);
        txtUsuario.setText(usuarioMod);
        txtUsuario.setEnabled(false);
       // JOptionPane.showMessageDialog(null, rol);
        txtNombre.setEnabled(false);
        txtApellido.setEnabled(false);
        opRol.setEnabled(rol);
        
    }
    
    
    
    private static ModAdmin1 obj=null;
    
    public static ModAdmin1 getObj(String cuentaMod,boolean rolE){
        
        
        
        if(obj==null){
            
                obj=new ModAdmin1(rolE,IFingreso.cuenta,cuentaMod); 
                
            
           
        }return obj=new ModAdmin1(rolE,IFingreso.cuenta,cuentaMod);
    }
    
    public void opciones()
    {
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        opRol = new javax.swing.JCheckBox();
        Foto = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        opEstatus = new javax.swing.JCheckBox();
        btnCrear = new javax.swing.JLabel();
        btnSalir1 = new javax.swing.JLabel();
        txtContraseña = new javax.swing.JPasswordField();

        jPasswordField1.setText("jPasswordField1");

        jPasswordField2.setText("jPasswordField2");

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

        jLabel2.setFont(new java.awt.Font("Museo 300", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 204, 255));
        jLabel2.setText("Nombre");

        jLabel3.setFont(new java.awt.Font("Museo 300", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 204, 255));
        jLabel3.setText("Usuario");

        jLabel4.setFont(new java.awt.Font("Museo 300", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 204, 255));
        jLabel4.setText("Contraseña");

        jLabel5.setFont(new java.awt.Font("Museo 300", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 204, 255));
        jLabel5.setText("Rol");

        jLabel6.setFont(new java.awt.Font("Museo 300", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 204, 255));
        jLabel6.setText("Apellido");

        jLabel7.setFont(new java.awt.Font("Museo 300", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 204, 255));
        jLabel7.setText("Fecha de nacimiento");

        jLabel8.setFont(new java.awt.Font("Museo 300", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 204, 255));
        jLabel8.setText("Correo");

        jLabel9.setFont(new java.awt.Font("Museo 300", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 204, 255));
        jLabel9.setText("Telefono");

        txtUsuario.setFont(new java.awt.Font("Museo 300", 0, 18)); // NOI18N
        txtUsuario.setMinimumSize(new java.awt.Dimension(7, 26));
        txtUsuario.setPreferredSize(new java.awt.Dimension(7, 32));
        txtUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUsuarioFocusLost(evt);
            }
        });

        txtApellido.setFont(new java.awt.Font("Museo 300", 0, 18)); // NOI18N
        txtApellido.setMinimumSize(new java.awt.Dimension(7, 26));
        txtApellido.setPreferredSize(new java.awt.Dimension(7, 32));
        txtApellido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtApellidoFocusLost(evt);
            }
        });

        txtNombre.setFont(new java.awt.Font("Museo 300", 0, 18)); // NOI18N
        txtNombre.setMinimumSize(new java.awt.Dimension(7, 26));
        txtNombre.setPreferredSize(new java.awt.Dimension(7, 32));
        txtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombreFocusLost(evt);
            }
        });

        txtCorreo.setFont(new java.awt.Font("Museo 300", 0, 18)); // NOI18N
        txtCorreo.setMinimumSize(new java.awt.Dimension(7, 26));
        txtCorreo.setPreferredSize(new java.awt.Dimension(7, 32));
        txtCorreo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCorreoFocusLost(evt);
            }
        });

        txtTelefono.setFont(new java.awt.Font("Museo 300", 0, 18)); // NOI18N
        txtTelefono.setMinimumSize(new java.awt.Dimension(7, 26));
        txtTelefono.setPreferredSize(new java.awt.Dimension(7, 32));
        txtTelefono.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTelefonoFocusLost(evt);
            }
        });

        jDateChooser1.setFont(new java.awt.Font("Museo 300", 0, 18)); // NOI18N
        jDateChooser1.setPreferredSize(new java.awt.Dimension(64, 32));

        opRol.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        opRol.setAlignmentX(0.5F);
        opRol.setBorder(null);
        opRol.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        opRol.setIconTextGap(5);
        opRol.setMaximumSize(new java.awt.Dimension(18, 13));
        opRol.setMinimumSize(new java.awt.Dimension(18, 13));
        opRol.setPreferredSize(new java.awt.Dimension(18, 13));
        opRol.setRolloverEnabled(false);

        Foto.setFont(new java.awt.Font("Museo 300", 0, 18)); // NOI18N
        Foto.setForeground(new java.awt.Color(0, 204, 255));
        Foto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Foto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FotoMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                FotoMousePressed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Museo 300", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 204, 255));
        jLabel11.setText("Estatus");

        opEstatus.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        opEstatus.setSelected(true);
        opEstatus.setAlignmentX(0.5F);
        opEstatus.setBorder(null);
        opEstatus.setBorderPainted(true);
        opEstatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        opEstatus.setIconTextGap(5);
        opEstatus.setMaximumSize(new java.awt.Dimension(18, 13));
        opEstatus.setMinimumSize(new java.awt.Dimension(18, 13));
        opEstatus.setPreferredSize(new java.awt.Dimension(18, 13));
        opEstatus.setRolloverEnabled(false);

        btnCrear.setFont(new java.awt.Font("Museo 300", 0, 18)); // NOI18N
        btnCrear.setForeground(new java.awt.Color(0, 204, 255));
        btnCrear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCrear.setDoubleBuffered(true);
        btnCrear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCrearMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnCrearMousePressed(evt);
            }
        });

        btnSalir1.setFont(new java.awt.Font("Museo 300", 0, 18)); // NOI18N
        btnSalir1.setForeground(new java.awt.Color(0, 204, 255));
        btnSalir1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir1.setDoubleBuffered(true);
        btnSalir1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalir1MouseClicked(evt);
            }
        });

        txtContraseña.setFont(new java.awt.Font("Museo 300", 0, 18)); // NOI18N
        txtContraseña.setMinimumSize(new java.awt.Dimension(7, 26));
        txtContraseña.setPreferredSize(new java.awt.Dimension(7, 35));
        txtContraseña.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtContraseñaFocusLost(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtApellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCorreo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(opRol, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(opEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(202, 202, 202)
                                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(btnCrear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(91, 91, 91)
                        .addComponent(btnSalir1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(Foto, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addComponent(opEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(opRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSalir1, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                            .addComponent(btnCrear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 11, Short.MAX_VALUE))
                    .addComponent(Foto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private static String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
        return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }
    private void txtUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsuarioFocusLost
        // TODO add your handling code here:
        //
        
        if(Verificar(txtUsuario, 20,1)==false)
        {
            return;
        }
         if(VerificarUsuario()==false)
         {
             return;
         }
      
    }//GEN-LAST:event_txtUsuarioFocusLost

    private void txtNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusLost
        // TODO add your handling code here:
         
         Verificar(txtNombre,30,4);
       
         
    }//GEN-LAST:event_txtNombreFocusLost

    private void txtApellidoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtApellidoFocusLost
        // TODO add your handling code here:
       Verificar(txtApellido,30,4);
    }//GEN-LAST:event_txtApellidoFocusLost

    public boolean Verificar(JTextField txt,int maximo,int minimo)
    {
         if(txt.getText().contains("|"))
           {
            JOptionPane.showMessageDialog(null, "Este campo no puede contener |");
            txt.requestFocus();
            return false;
            }
           if(txt.getText().contains(" ")|txt.getText().contains("	"))
           {
               JOptionPane.showMessageDialog(null,"No puede tener espacios en blanco");
               txtContraseña.requestFocus();
               return false;
           }
         if(txt.getText().length()>maximo)
         {
            JOptionPane.showMessageDialog(null, "Este campo no puede ser mayor a "+maximo);
            txt.requestFocus();
             return false;
         }
         else if(txt.getText().length()< minimo)
         {
             JOptionPane.showMessageDialog(null, "Este campo no puede ser menor a "+minimo);
            txt.requestFocus();
            return false;
         }
         
         return true;
    }
    
     public boolean VerificarUsuario()
    {
        String patron="(Usuario)(\\:)(	| |)*(.+)(\\|)(N)";
        Pattern rol = Pattern.compile(patron);
        try {
                List<String> lineas;
                lineas = Files.readAllLines(Path.of("C:\\MEIA\\usuario.txt"));
                for (int i = 0; i < lineas.size(); i++)
                {
                    Matcher m = rol.matcher(lineas.get(i));
                    if(m.find())
                    {   
                        if(m.group(4).contains(txtUsuario.getText()))
                        {
                     //Usuario ya existe
                     JOptionPane.showMessageDialog(null, "El nombre de usuario ya existe");
                     txtUsuario.requestFocus();
                     return false;
                        }
                        else
                        {
                         //El usuario no existe :D
                            
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
      return true;
    }
    private void txtCorreoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCorreoFocusLost
        // TODO add your handling code here:
        Verificar(txtCorreo, 40,4);
    }//GEN-LAST:event_txtCorreoFocusLost

    private void txtTelefonoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelefonoFocusLost
        // TODO add your handling code here:
         Verificar(txtTelefono, 20,8);
         String patron="^(\\d)+$";
         Pattern rol = Pattern.compile(patron);
         
         Matcher m = rol.matcher(txtTelefono.getText());
                    if(!m.find())
                    {
                     JOptionPane.showMessageDialog(null, "Numero invalido");
                     txtTelefono.requestFocus();
                     return;
                    }
                    else
                    {
                     //Numero correct 
                        
                    }
    }//GEN-LAST:event_txtTelefonoFocusLost

    private void txtContraseñaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtContraseñaFocusLost
        // TODO add your handling code here:
        
           if(!Verificar(txtContraseña,30,5))
           {
               return;
           }
           
           if(VerificarContraseña())
           {
               //JOptionPane.showMessageDialog(null,password );
               try 
               {  
                   password=String.valueOf(txtContraseña.getPassword());
                   cifrado=cifra(password);
                   password="";
                   for(int i = 0; i < cifrado.length; i++)
                   {
                       password += cifrado[i];
                   }
               } 
               catch (Exception e) 
               {
                   
               }
             
           }
       

           //JOptionPane.showMessageDialog(null,myPass );
    }//GEN-LAST:event_txtContraseñaFocusLost

    
    private void desc_Usuario()
    {
        String patron="(Estatus)(\\:)(	| |)*(\\d)";
        Pattern estatus = Pattern.compile(patron);
        List<String> lineas;
        try 
        {
            lineas = Files.readAllLines(Path.of("C:\\MEIA\\usuario.txt"));
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null,"Ocurrio un error" );
            return;
        }
        
        int cantidadCuentas=0;
        int cantidadActivos=0;
        int cantidadInactivos=0;
        
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
                 else
                   {
                   }
         }
        
        Path p = Paths.get("C:\\\\MEIA\\\\desc_usuario.txt");
        
       
        //en modificacion solo se cambiaria las partes que dicen modificacion y los campos que se modifiquen
        
      
       String jfecha = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
       String s = System.lineSeparator() + "Nombre Simbolico:"+txtUsuario.getText()+"|"+ "Fecha Creacion:"+jfecha+"|"+"|"
                 + "Usuario Creacion:"+cuentaC+"|"+"|"+ "Fecha Modificacion:"+jfecha+"|"+"|"+ "Usuario Modificacion:"+cuentaC+"|"
                 +"|"+ "# Registros:"+cantidadCuentas+"|"+ "Registros Activos:"+cantidadActivos+"|"+ "Registros Inactivos:"+cantidadInactivos+"|"
                 + "Max reorganizacion:"+1;
           
           
           try (BufferedWriter writer = Files.newBufferedWriter(p, StandardOpenOption.APPEND)) 
           {
               writer.write(s);
               writer.close();
           } 
           catch (IOException ioe) 
           {
               System.err.format("IOException: %s%n", ioe);
           }
       }
    
    
    
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // TODO add your handling code here:
         xx=evt.getX();
        xy=evt.getY();
    }//GEN-LAST:event_formMousePressed
int xx,xy;
    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        // TODO add your handling code here:
         int x=evt.getXOnScreen();
        int y=evt.getYOnScreen();
        
        setLocation(x-xx,y-xy);
    }//GEN-LAST:event_formMouseDragged

    void limpiar()
    {
         txtUsuario.setText("");
         txtNombre.setText("");
          txtApellido.setText("");
           txtContraseña.setText("");
            jDateChooser1.setCalendar(null);
             txtCorreo.setText("");
              txtTelefono.setText("");
              Foto.setIcon(null);
              pathFotografia=null;
    }
    
    
    private void FotoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FotoMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_FotoMousePressed

    private void FotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FotoMouseClicked
        // TODO add your handling code here:
           JFileChooser escogerImagen = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Formatos","jpg","png","jpeg");
        escogerImagen.setFileFilter(filtro);
        int seleccionado=escogerImagen.showOpenDialog(this);
        if(seleccionado==JFileChooser.APPROVE_OPTION)
        {
        File archivo=escogerImagen.getSelectedFile();
        String obtener = archivo.getAbsolutePath();
        //JOptionPane.showMessageDialog(null, obtener);
        ImageIcon imIc= new ImageIcon(obtener);
        Image ajustarImg = imIc.getImage();
        Image ajustarTamaño= ajustarImg.getScaledInstance(Foto.getWidth(),Foto.getHeight(), Image.SCALE_SMOOTH);
        
        Foto.setIcon(new ImageIcon(ajustarTamaño));
        
           
        try 
        {
            if(Verificar(txtUsuario, 20,1)==false)
            {
                return;
            }
            if(VerificarUsuario()==false)
            {
                return;
            }
                
                ImageIO.write(ImageIO.read(archivo),(getFileExtension(archivo)),new File("C:\\MEIA\\Fotografias\\" + txtUsuario.getText()+"."+getFileExtension(archivo)));
                pathFotografia= "C:\\MEIA\\Fotografias\\"+ txtUsuario.getText()+"."+getFileExtension(archivo);
        } 
         
        catch (IOException ex) 
        {
                Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        }
        
    }//GEN-LAST:event_FotoMouseClicked

    private void btnCrearMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCrearMousePressed

    private void btnCrearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearMouseClicked
        // TODO add your handling code here:
        // TODO add your handling code here:
        
       
      
               
        
        
        
        
        
        
        if(password==null)
        {
            JOptionPane.showMessageDialog(null,"Ingrese una nueva Contraseña" );
            return;
        }
        
        Date fecha= jDateChooser1.getDate();
        String jfecha;
        try
        {
            jfecha=DateFormat.getDateInstance().format(fecha);
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"Fecha incorrecta!" );
            jDateChooser1.requestFocus();
            return;
        }
        if(pathFotografia==null)
        {
            JOptionPane.showMessageDialog(null,"Debe agregar una foto de perfil!" );
            return;
        }
                List<String> lineas;
        try {
            lineas = Files.readAllLines(Path.of("C:\\MEIA\\usuario.txt"));
            lineas.set(lineaBorrar, "");
            
           // JOptionPane.showMessageDialog(null,"Se borro el dato" );
              Iterator<String> i = lineas.iterator();
    
              while (i.hasNext())
              {
        String line = i.next();
        if (line.trim().isEmpty())
            i.remove();
              }
              Files.write(Path.of("C:\\MEIA\\usuario.txt"), lineas);
              
        }
        catch (IOException ex) 
        {
            Logger.getLogger(ModAdmin1.class.getName()).log(Level.SEVERE, null, ex);
        }
                

        if(txtNombre.getText().isEmpty()||txtApellido.getText().isEmpty()||txtCorreo.getText().isEmpty()||txtTelefono.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Llene todos los campos" );
            return;
        }
        else
        {
            //"C:\\MEIA\\usuario.txt"
            Path p = Paths.get("C:\\\\MEIA\\\\usuario.txt");
            int opRolValor;
            int opEstatusValor;
            if(opRol.isSelected())
            {
                opRolValor=1;
            }
            else
            {
                opRolValor=0;
            }

            if(opEstatus.isSelected())
            {
                opEstatusValor=1;
            }
            else
            {
                opEstatusValor=0;
            }
            String s = System.lineSeparator() + "Usuario:"+txtUsuario.getText()+"|"+"Nombre:"+txtNombre.getText()+
            "|"+"Apellido:"+txtApellido.getText()+"|"+"Contraseña:"+password+"|"+"Rol:"+opRolValor+"|"+"Fecha de nacimiento:"+jfecha+
            "|"+"Correo alterno:"+txtCorreo.getText()+"|"+"Telefono:"+txtTelefono.getText()+"|"+"Path_Fotografia:"+pathFotografia+"|"+"Estatus:"+opEstatusValor;

            try (BufferedWriter writer = Files.newBufferedWriter(p, StandardOpenOption.APPEND))
            {
                   
                writer.write(s);
                 writer.close();
                 
                lineas = Files.readAllLines(Path.of("C:\\MEIA\\usuario.txt"));
                Iterator<String> i = lineas.iterator();
    
              while (i.hasNext())
              {
             String line = i.next();
              if (line.trim().isEmpty())
            i.remove();
              }
              Files.write(Path.of("C:\\MEIA\\usuario.txt"), lineas);
                
                
             
                JOptionPane.showMessageDialog(null,"Usuario Modificado!" );
               
            }
            catch (IOException ioe)
            {
                System.err.format("IOException: %s%n", ioe);
            }
            desc_Usuario();
            limpiar();
            dispose();
        }

    }//GEN-LAST:event_btnCrearMouseClicked

    private void btnSalir1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalir1MouseClicked
        // TODO add your handling code here:
        limpiar();
        dispose();
    }//GEN-LAST:event_btnSalir1MouseClicked

    public boolean VerificarContraseña()
    {
           String myPass=String.valueOf(txtContraseña.getPassword());

           if(myPass.contains(" ")|myPass.contains("	"))
           {
               JOptionPane.showMessageDialog(null,"No puede tener espacios en blanco");
               txtContraseña.requestFocus();
               return false;
           }
           if(!myPass.matches(".*\\d.*"))
           {
               JOptionPane.showMessageDialog(null,"Debe tener almenos un numero");
               txtContraseña.requestFocus();
               return false;
           }
           if(!myPass.matches(".*[A-Z].*"))
           {
               JOptionPane.showMessageDialog(null,"Debe tener almenos una letra mayuscula");
               txtContraseña.requestFocus();
               return false;
           }
           if(!myPass.matches(".*[a-z].*"))
           {
               JOptionPane.showMessageDialog(null,"Debe tener almenos una letra minuscula");
               txtContraseña.requestFocus();
               return false;
           }
           return true;
    }
    
    byte[] cifrado = null;
    String pathFotografia;
    String password;
    public byte[] cifra(String sinCifrar) throws Exception {
            final byte[] bytes = sinCifrar.getBytes("UTF-8");
            final Cipher aes = obtieneCipher(true);
            final byte[] cifrado = aes.doFinal(bytes);
            return cifrado;
    }

    public String descifra(byte[] cifrado) throws Exception {
            final Cipher aes = obtieneCipher(false);
            final byte[] bytes = aes.doFinal(cifrado);
            final String sinCifrar = new String(bytes, "UTF-8");
            return sinCifrar;
    }
    
    private Cipher obtieneCipher(boolean paraCifrar) throws Exception {
	final String frase = "FraseLargaConDiferentesLetrasNumerosYCaracteresEspeciales_áÁéÉíÍóÓúÚüÜñÑ1234567890!#%$&()=%NO_USAR_ESTA_FRASE!";
	final MessageDigest digest = MessageDigest.getInstance("SHA");
	digest.update(frase.getBytes("UTF-8"));
	final SecretKeySpec key = new SecretKeySpec(digest.digest(), 0, 16, "AES");

	final Cipher aes = Cipher.getInstance("AES/ECB/PKCS5Padding");
	if (paraCifrar) {
		aes.init(Cipher.ENCRYPT_MODE, key);
	} else {
		aes.init(Cipher.DECRYPT_MODE, key);
	}

	return aes;
}
    
    private void bContraActionPerformed(java.awt.event.ActionEvent evt) {                                        
    // TODO add your handling code here:    
        String result = txtContraseña.getText();
       // cifrado = cifra(result); 
        result = null;
        for(int i = 0; i < cifrado.length; i++)
        {
            result += cifrado[i];
        }
        
      //  rContra.setText(result);
    }                                       

    private void dContraActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
     //  rdContra.setText(descifra(cifrado));
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
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
           
            public void run() {
                
                new ModAdmin1(IFingreso.valorRol,IFingreso.cuenta,lFAdmin.cuentaMod).setVisible(true);
                
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Foto;
    private javax.swing.JLabel btnCrear;
    private javax.swing.JLabel btnSalir1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JCheckBox opEstatus;
    private javax.swing.JCheckBox opRol;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
