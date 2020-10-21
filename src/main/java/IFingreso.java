
import java.awt.Color;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import sun.nio.cs.ext.IBM1097;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ericd
 */
public class IFingreso extends javax.swing.JFrame {

    /**
     * Creates new form IFingreso
     */
    
    
    
    
    public static boolean valorRol;
    public static String cuenta;
 
    public IFingreso() {
        
        File theDir = new File("C:\\MEIA");
        if (!theDir.exists()) theDir.mkdirs();
        File theDir2 = new File("C:\\MEIA\\Fotografias");
        if (!theDir2.exists()) theDir2.mkdirs();
        
        File crearUsuario = new File("C:\\MEIA\\usuario.txt");
        File crearBitacora = new File("C:\\MEIA\\bitacora_backup.txt");
        File crearDescUsuario = new File("C:\\MEIA\\desc_usuario.txt");
        File crearDescBitacora = new File("C:\\MEIA\\desc_bitacora_backup.txt");
        File crearCuentaBitacora = new File("C:\\MEIA\\bitacora_contactos.txt");
        File crearContactosFile = new File("C:\\MEIA\\contactos.txt");
        File crearLista = new File("C:\\MEIA\\lista.txt");
        File crearListaBitacora = new File("C:\\MEIA\\bitacora_lista.txt");
        try 
        {
            crearBitacora.createNewFile();
            crearUsuario.createNewFile();
            crearDescUsuario.createNewFile();
            crearDescBitacora.createNewFile();
            crearCuentaBitacora.createNewFile();
            crearContactosFile.createNewFile();
            crearLista.createNewFile();
            crearListaBitacora.createNewFile();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(IFingreso.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        setUndecorated(true);
        initComponents();
        getContentPane().setBackground(Color.white);      
        ImageIcon imIc= new ImageIcon("src/main/java/Imagenes/btnSalir.gif");
        btnSalir.setIcon(imIc);
        
           ImageIcon imIc1 = new ImageIcon("src/main/java/Imagenes/logo.jpg");
            Image ajustarImg = imIc1.getImage();
            Image ajustarTamaño = ajustarImg.getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH);

            logo.setIcon(new ImageIcon(ajustarTamaño));
        
       // this.setContentPane(new JLabel(new ImageIcon("C:\\MEIA\\btnSalir.gif")));
        
        File dir = new File("C:\\MEIA");
        String patron="(Rol)(\\:)(	| |)*(\\d)";
        Pattern rol = Pattern.compile(patron);
        File[] matches = dir.listFiles(new FilenameFilter()
        {
         public boolean accept(File dir, String name)
        {
         return name.startsWith("usuario") && name.endsWith(".txt");
        }
          
        });
        
        if(matches.length==0)
        {
            //NO HAY ARCHIVOS, PRIMER USUARIO ADMIN
            JOptionPane.showMessageDialog(null, "sin archivos");
             controlesAct(false);
        }
        else
        {
            try 
            {
         //HAY ARCHIVOS,VERIFICAR SI EXISTE UN ADMIN
             List<String> lineas;
             lineas = Files.readAllLines(Path.of("C:\\MEIA\\usuario.txt"));
             
             for (int i = 0; i < lineas.size(); i++) 
             {

		   Matcher m = rol.matcher(lineas.get(i));
                 
                   if(m.find())
               
                   {
                       //JOptionPane.showMessageDialog(null, lineas.get(i));
                     if(m.group(4).contains("1"))
                     {
                     //Encontro un rol de admin
                     //JOptionPane.showMessageDialog(null, "Admin encontrado");
                     valorRol=true;
                     controlesAct(true);
                     break;
                     }
                     else
                     {
                         //no son admi   
                         controlesAct(false);
                     } 
                   }
                 else
                   {
                     //No hay admins
                     controlesAct(false);
                   }
             }
             } 
             catch (IOException ex) 
             {
                        Logger.getLogger(IFingreso.class.getName()).log(Level.SEVERE, null, ex);
             }
            
        }
           if(valorRol==false)
                        {
                         JOptionPane.showMessageDialog(null, "Debe existir una cuenta de administrador!");
                         controlesAct(false);
                        }
           
    }
    
    public void controlesAct(boolean accion)
    {
        txtContraseña.setEnabled(accion);
        txtUsuario.setEnabled(accion);
        entrar.setEnabled(accion);
        valorRol=accion;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtContraseña = new javax.swing.JPasswordField();
        crearCuenta = new javax.swing.JButton();
        entrar = new javax.swing.JButton();
        btnSalir = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();

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

        jLabel1.setFont(new java.awt.Font("Museo 300", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ingrese su usuario y contraseña");

        jLabel2.setFont(new java.awt.Font("Museo 300", 0, 18)); // NOI18N
        jLabel2.setText("Usuario");

        txtUsuario.setFont(new java.awt.Font("Museo 300", 0, 18)); // NOI18N
        txtUsuario.setName(""); // NOI18N

        jLabel3.setFont(new java.awt.Font("Museo 300", 0, 18)); // NOI18N
        jLabel3.setText("Contraseña");

        txtContraseña.setFont(new java.awt.Font("Museo 300", 0, 18)); // NOI18N
        txtContraseña.setText("jPasswordField1");
        txtContraseña.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtContraseñaFocusLost(evt);
            }
        });

        crearCuenta.setFont(new java.awt.Font("Museo 300", 0, 14)); // NOI18N
        crearCuenta.setText("Crear Cuenta");
        crearCuenta.setBorder(null);
        crearCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearCuentaActionPerformed(evt);
            }
        });

        entrar.setBackground(new java.awt.Color(102, 204, 255));
        entrar.setFont(new java.awt.Font("Museo 300", 0, 36)); // NOI18N
        entrar.setForeground(new java.awt.Color(255, 255, 255));
        entrar.setText("Ingresar");
        entrar.setBorder(null);
        entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrarActionPerformed(evt);
            }
        });

        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.setDoubleBuffered(true);
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalirMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(crearCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtUsuario)
                    .addComponent(txtContraseña, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE))
                .addContainerGap(166, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(216, 216, 216)
                .addComponent(entrar, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addComponent(entrar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(crearCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void crearCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearCuentaActionPerformed
        // TODO add your handling code here:
        
           Registro rgstr= new Registro(valorRol,cuenta);
           rgstr.setVisible(true);
           rgstr.pack();
           rgstr.setDefaultCloseOperation(EXIT_ON_CLOSE);
           this.dispose();
                
    }//GEN-LAST:event_crearCuentaActionPerformed
int xx,xy;

    private void entrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrarActionPerformed
        // TODO add your handling code here:
        String patronUsuario="(Usuario)(\\:)(	| |)*(.+)(\\|)(N)";
        cifrar();
        String patronContraseña="(Contraseña)(\\:)(	| |)*(.+)(\\|)(R)"; 
        String patronEstatus="(Estatus)(\\:)(	| |)*(.+)";
        String patronRol="(Rol)(\\:)(	| |)*(.+)(\\|)(F)";
        Pattern adminRol = Pattern.compile(patronRol);
        Pattern rolContraseña = Pattern.compile(patronContraseña);
        Pattern rol = Pattern.compile(patronUsuario);
        Pattern rolE = Pattern.compile(patronEstatus);
        try {
                List<String> lineas;
                lineas = Files.readAllLines(Path.of("C:\\MEIA\\usuario.txt"));
                for (int i = 0; i < lineas.size(); i++)
                {
                    Matcher m = rol.matcher(lineas.get(i));
                    Matcher m10 = rolE.matcher(lineas.get(i));
                    if(m.find())
                    {
                        if(m.group(4).equals(txtUsuario.getText()))
                        {
                            //Usuario  existe
                            if(m10.find())
                            {
                                if(m10.group(4).contains("0"))
                                {
                                    JOptionPane.showMessageDialog(null, "Usuario deshabilitado");   
                                    return;
                                }
                            }
                            Matcher m2 = rolContraseña.matcher(lineas.get(i));
                            if(m2.find())
                            {                       
                                if(m2.group(4).equals(password))
                                {
                                    Matcher m3 = adminRol.matcher(lineas.get(i));
                                    if(m3.find())
                                    {
                                        //contraseña coinciden
                                        if(m3.group(4).equals("1"))
                                        {
                                            cuenta=txtUsuario.getText();
                                         valorRol=true;
                                            //  JOptionPane.showMessageDialog(null,valorRol);
                                           lFAdmin administrar = new lFAdmin(cuenta,valorRol);
                                           administrar.setVisible(true);
                                           administrar.pack();
                                           administrar.setDefaultCloseOperation(EXIT_ON_CLOSE);
                                           
                                           this.dispose();
                                           return;
                                        }
                                        else
                                        {   
                                           valorRol=false;
                                           cuenta=txtUsuario.getText();
                                           IFEstandar estandar = new IFEstandar(cuenta);
                                           estandar.setVisible(true);
                                           estandar.pack();
                                           estandar.setDefaultCloseOperation(EXIT_ON_CLOSE);
                                           this.dispose();
                                           
                                           return;
                                        }   
                                    }
                                }
                                else
                                {
                                    //contraseña no coinciden
                              
                                    JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
                                    return;
                                }
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null, "No se encontro la contraseña");
                            }
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
                 JOptionPane.showMessageDialog(null, "Este usuario no existe");
        }
            
        catch (IOException ex)    
        {
                Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        
        
        
        
        
    }//GEN-LAST:event_entrarActionPerformed

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

    private void btnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnSalirMouseClicked

    private void txtContraseñaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtContraseñaFocusLost
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtContraseñaFocusLost
     
    
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
    
    private void cifrar() {                                        
    // TODO add your handling code here:    
       password=String.valueOf(txtContraseña.getPassword());
        try {
            cifrado=cifra(password);
             password="";
                   for(int i = 0; i < cifrado.length; i++)
                   {
                       password += cifrado[i];
                   }
        } 
        catch (Exception ex) {
            Logger.getLogger(IFingreso.class.getName()).log(Level.SEVERE, null, ex);
        }
                  
        
      //  rContra.setText(result);
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
            java.util.logging.Logger.getLogger(IFingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IFingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IFingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IFingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() 
        {
        new IFingreso().setVisible(true);
  
        
            }
        });
    }
    
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnSalir;
    private javax.swing.JButton crearCuenta;
    private javax.swing.JButton entrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel logo;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
