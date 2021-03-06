
import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.*;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ericd
 */
public class lFAdmin extends javax.swing.JFrame {

    /**
     * Creates new form lFAdmin
     */
    
   static String cuenta;
   static boolean valorRol;
   static String cuentaMod;
     String pathFotografia;
    
    public lFAdmin(String usuario,boolean rol) {
        
        setUndecorated(true);
        initComponents();
        getContentPane().setBackground(Color.white);      
        
        ImageIcon imIc3= new ImageIcon("src/main/java/Imagenes/btnBuscar.gif");
        btnBuscar.setIcon(imIc3);
        
        ImageIcon imIc4= new ImageIcon("src/main/java/Imagenes/btnModificar.gif");
        btnMod.setIcon(imIc4);
        
         ImageIcon imIc5= new ImageIcon("src/main/java/Imagenes/btnSalir.gif");
        btnSalir.setIcon(imIc5);
        
             ImageIcon imIc6= new ImageIcon("src/main/java/Imagenes/btnBackUp.gif");
        btnBackup.setIcon(imIc6);
        cuenta=usuario;
        valorRol=!rol;
        lblBienvenido.setText("Bienvenido administrador "+cuenta);
        txtMaxReo.setText(String.valueOf(Max()));
         String patron="(Usuario)(\\:)(	| |)*(.+)(\\|)(N)";
        String patronPathFoto="(Path_Fotografia)(\\:)(	| |)*(.+)(\\|)(E)";
        
        Pattern rolUse = Pattern.compile(patron);
        Pattern rolPath = Pattern.compile(patronPathFoto);
         try {
                List<String> lineas;
                lineas = Files.readAllLines(Path.of("C:\\MEIA\\usuario.txt"));
                
                for (int i = 0; i < lineas.size(); i++)
                {
                    Matcher m = rolUse.matcher(lineas.get(i));
                    Matcher m9 = rolPath.matcher(lineas.get(i));
                    
                    if(m.find()&&m9.find())
                    {   
                        if(m.group(4).contains(cuenta))
                        {
                     //Usuario ya existe
                            pathFotografia=m9.group(4);
                               ImageIcon imIc= new ImageIcon(pathFotografia);
        Image ajustarImg = imIc.getImage();
        Image ajustarTamaño= ajustarImg.getScaledInstance(Foto.getWidth(),Foto.getHeight(), Image.SCALE_SMOOTH);
        
        Foto.setIcon(new ImageIcon(ajustarTamaño));
        
                            return;
                            
                            
                        }
                        else
                        {
                         //El usuario no existe :D
                            
                        }
                    }
                    else
                    {
                     //No hay usuarios     
                      //   JOptionPane.showMessageDialog(null, "Aun estando vacio no deberia dar rpblema :c");
                       
                    }
                }
        }
            
        catch (IOException ex)    
        {
                Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
                 JOptionPane.showMessageDialog(null, ":D");
        }
    }
    
    
    
     public int Max()
    {
        String patronDesc="(Max reorganizacion)(\\:)(	| |)*(\\d*)";
        Pattern maxReorganizacion = Pattern.compile(patronDesc);
        try 
        {
             List<String> lineas = Files.readAllLines(Path.of("C:\\MEIA\\desc_usuario.txt"));
                 Matcher m = maxReorganizacion.matcher(lineas.get(lineas.size()-1));
                 if(m.find())
                {
                    return Integer.parseInt(m.group(4));
                }
                 else
                 {
                     return 1;
                 }
           
        } 
        catch (IOException ex) 
        {
    
        }
    

        return 1;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        crearCuenta = new javax.swing.JButton();
        lblBienvenido = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JLabel();
        btnMod = new javax.swing.JLabel();
        btnSalir = new javax.swing.JLabel();
        Foto = new javax.swing.JLabel();
        btnBackup = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtMaxReo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(890, 707));
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

        crearCuenta.setBackground(new java.awt.Color(0, 153, 153));
        crearCuenta.setFont(new java.awt.Font("Museo 300", 0, 18)); // NOI18N
        crearCuenta.setForeground(new java.awt.Color(255, 255, 255));
        crearCuenta.setText("Crear nueva cuenta");
        crearCuenta.setBorder(null);
        crearCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearCuentaActionPerformed(evt);
            }
        });

        lblBienvenido.setFont(new java.awt.Font("Museo 300", 0, 24)); // NOI18N
        lblBienvenido.setText("Bienvenido");
        lblBienvenido.setToolTipText("");

        txtUsuario.setFont(new java.awt.Font("Museo 300", 0, 18)); // NOI18N
        txtUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsuario.setText("Buscar Usuario");
        txtUsuario.setToolTipText("");
        txtUsuario.setName(""); // NOI18N
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
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

        btnMod.setFont(new java.awt.Font("Museo 300", 0, 18)); // NOI18N
        btnMod.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnMod.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMod.setEnabled(false);
        btnMod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModMouseClicked(evt);
            }
        });

        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.setDoubleBuffered(true);
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalirMouseClicked(evt);
            }
        });

        Foto.setFont(new java.awt.Font("Museo 300", 0, 18)); // NOI18N
        Foto.setForeground(new java.awt.Color(0, 204, 255));
        Foto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnBackup.setFont(new java.awt.Font("Museo 300", 0, 18)); // NOI18N
        btnBackup.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnBackup.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBackup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBackupMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Museo 300", 0, 18)); // NOI18N
        jLabel1.setText("Máxima Reorganización:");

        txtMaxReo.setFont(new java.awt.Font("Museo 300", 0, 18)); // NOI18N
        txtMaxReo.setMinimumSize(new java.awt.Dimension(7, 26));
        txtMaxReo.setPreferredSize(new java.awt.Dimension(7, 32));
        txtMaxReo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMaxReoFocusLost(evt);
            }
        });
        txtMaxReo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMaxReoKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBienvenido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(crearCuenta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(180, 180, 180))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnMod, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnBackup, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(28, 28, 28)
                                .addComponent(txtMaxReo, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Foto, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblBienvenido)
                                .addGap(18, 18, 18)
                                .addComponent(crearCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnBackup, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnMod, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(193, 193, 193)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtMaxReo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(120, 120, 120)
                        .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Foto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

  
 RegistroAdmin crear;
  
    private void crearCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearCuentaActionPerformed
        // TODO add your handling code here
    
        crear.getObj(null).setVisible(true);

    }//GEN-LAST:event_crearCuentaActionPerformed
    
    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        // TODO add your handling code here:
          int x=evt.getXOnScreen();
        int y=evt.getYOnScreen();
        
        setLocation(x-xx,y-xy);
    }//GEN-LAST:event_formMouseDragged
int xx,xy;
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // TODO add your handling code here:
            xx=evt.getX();
        xy=evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseClicked
        // TODO add your handling code here:
                // TODO add your handling code here:
        String patronUsuario="(Usuario)(\\:)(	| |)*(.+)(\\|)(N)";
        Pattern rol = Pattern.compile(patronUsuario);
        btnMod.requestFocus();
        try {
                List<String> lineas;
                lineas = Files.readAllLines(Path.of("C:\\MEIA\\usuario.txt"));
                for (int i = 0; i < lineas.size(); i++)
                {
                    Matcher m = rol.matcher(lineas.get(i));
                    
                    if(m.find())
                    {
                        
                        if(m.group(4).equals(txtUsuario.getText()))
                        {
                            //Usuario  existe
                            //JOptionPane.showMessageDialog(null, "Usuario existe");
                            txtUsuario.setEnabled(false);
                            btnMod.setEnabled(true);
                           return;
                        }
                        else
                        {
                         //El usuario no existe :D  
                          //  JOptionPane.showMessageDialog(null, "Este usuario no existe");
                           txtUsuario.setEnabled(true);
                            btnMod.setEnabled(false);
                           
                        }
                    }
                    else
                    {
                     //No hay usuarios     
                       
                    }
                }
                 JOptionPane.showMessageDialog(null, "Este usuario no existe");
                  txtUsuario.setEnabled(true);
                    btnMod.setEnabled(false);
        }
            
        catch (IOException ex)    
        {
                Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        
    }//GEN-LAST:event_btnBuscarMouseClicked

    private void btnModMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModMouseClicked
        // TODO add your handling code here:
                // TODO add your handling code here:
        txtUsuario.setEnabled(true);
       
        cuentaMod=txtUsuario.getText();
        txtUsuario.setText("");
        ModAdmin1.getObj(cuentaMod,true).setVisible(true);

        btnMod.setEnabled(false);
    }//GEN-LAST:event_btnModMouseClicked

    private void btnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseClicked
        // TODO add your handling code here:
        IFingreso Ifingreso=new IFingreso();
        Ifingreso.setVisible(true);
        Ifingreso.pack();
        Ifingreso.setLocationRelativeTo(null);
        dispose();
    }//GEN-LAST:event_btnSalirMouseClicked

    private void btnBackupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackupMouseClicked
        // TODO add your handling code here:
         CopiaArchivo.getObj().setVisible(true);
                
        
    }//GEN-LAST:event_btnBackupMouseClicked

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void txtMaxReoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMaxReoFocusLost

    }//GEN-LAST:event_txtMaxReoFocusLost

    private void txtMaxReoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaxReoKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) 
        {
              // TODO add your handling code here:
        String patron="^(\\d)+$";
        Pattern rol = Pattern.compile(patron);

        Matcher m = rol.matcher(txtMaxReo.getText());
        if(!m.find())
        {
            JOptionPane.showMessageDialog(null, "Numero invalido");
            txtMaxReo.requestFocus();
            return;
        }
        else
        {
        String patron2="(Estatus)(\\:)(	| |)*(\\d)";
        Pattern estatus = Pattern.compile(patron2);
       
        int cantidadCuentas=0;
        int cantidadActivos=0;
        int cantidadInactivos=0;
        int maxReor=0;
        try 
        {
            List<String> lineas = Files.readAllLines(Path.of("C:\\MEIA\\usuario.txt"));
            for (int i = 0; i < lineas.size(); i++)
            {
                Matcher m2 = estatus.matcher(lineas.get(i));
                if(m2.find())
                {
                    cantidadCuentas++;
                    if(m2.group(4).contains("1"))
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
        
            
            
            
            //Numero correct
            String jfecha = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
            String s = System.lineSeparator() + "Nombre Simbolico:"+"Reorganizacion"+"|"+ "Fecha Creacion:"+jfecha+"|"+"|"
                 + "Usuario Creacion:"+"null"+"|"+"|"+ "Fecha Modificacion:"+jfecha+"|"+"|"+ "Usuario Modificacion:"+"Reorganizacion"+"|"
                 +"|"+ "# Registros:"+cantidadCuentas+"|"+ "Registros Activos:"+cantidadActivos+"|"+ "Registros Inactivos:"+cantidadInactivos+"|"
                 + "Max reorganizacion:"+txtMaxReo.getText();
            
            Path p = Paths.get("C:\\\\MEIA\\\\desc_usuario.txt");
           
           try (BufferedWriter writer = Files.newBufferedWriter(p, StandardOpenOption.APPEND)) 
           {
               writer.write(s);
               JOptionPane.showMessageDialog(null,"Reorganizacion cambiada a:"+ txtMaxReo.getText() );
               writer.close();
           } 
           catch (IOException ioe) 
           {
               System.err.format("IOException: %s%n", ioe);
           }
        }
      
        }
    }//GEN-LAST:event_txtMaxReoKeyPressed

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
            java.util.logging.Logger.getLogger(lFAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(lFAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(lFAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(lFAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new lFAdmin(IFingreso.cuenta,IFingreso.valorRol).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Foto;
    private javax.swing.JLabel btnBackup;
    private javax.swing.JLabel btnBuscar;
    private javax.swing.JLabel btnMod;
    private javax.swing.JLabel btnSalir;
    private javax.swing.JButton crearCuenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblBienvenido;
    private javax.swing.JTextField txtMaxReo;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
