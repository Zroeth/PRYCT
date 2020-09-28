
import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
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

    public class CopiaArchivo extends javax.swing.JFrame{
    JFileChooser seleccionar = new JFileChooser();
    File archivo;
    FileInputStream entrada;
    FileOutputStream salida;
    
    
    public CopiaArchivo(){
   //    setUndecorated(true);
     setUndecorated(true);
    initComponents();
     getContentPane().setBackground(Color.white);
     
      ImageIcon imIc4= new ImageIcon("src/main/java/Imagenes/btnArchivo.gif");
      btnArchivo.setIcon(imIc4);
        
      ImageIcon imIc5= new ImageIcon("src/main/java/Imagenes/btnGuardarB.gif");
      btnGuardar.setIcon(imIc5);
    
      ImageIcon imIc6= new ImageIcon("src/main/java/Imagenes/btnSalir.gif");
      btnSalir.setIcon(imIc6);
    
      
    }
    private static CopiaArchivo obj=null;
    
    public static CopiaArchivo getObj()
    {
        if(obj==null){
            obj=new CopiaArchivo();
        }
        return obj;
    }
    
    
     
    public String AbrirArchivo(File Archivo){
         String ruta = "C:\\\\MEIA\\\\usuario.txt";
            Path fuente = Paths.get(ruta);
            String datos= "usuario.txt";
            try{
            entrada=new FileInputStream(Archivo);
            int asc;
            while((asc=entrada.read())!=-1){
                char caracter=(char)asc;
                datos+=caracter;
            }}
            
            
            catch(Exception e){
    }
            return datos;
    }
    public String GuardarArchivo(File Archivo,String datos){
    String mensaje=null;
    try{
        salida=new FileOutputStream(archivo);
        byte[] bytxt=datos.getBytes();
        salida.write(bytxt);
        mensaje="Mensaje Guardado";
    }catch(Exception e){}
    return mensaje;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtarea = new javax.swing.JTextArea();
        btnArchivo = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JLabel();
        btnSalir = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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

        txtarea.setColumns(20);
        txtarea.setFont(new java.awt.Font("Museo 300", 0, 18)); // NOI18N
        txtarea.setRows(5);
        jScrollPane1.setViewportView(txtarea);

        btnArchivo.setFont(new java.awt.Font("Museo 300", 0, 18)); // NOI18N
        btnArchivo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnArchivo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnArchivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnArchivoMouseClicked(evt);
            }
        });

        btnGuardar.setFont(new java.awt.Font("Museo 300", 0, 18)); // NOI18N
        btnGuardar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Museo 300", 0, 18)); // NOI18N
        btnSalir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalirMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 402, Short.MAX_VALUE)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                    .addComponent(btnArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                .addGap(17, 17, 17))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnArchivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnArchivoMouseClicked
        // TODO add your handling code here:
         if(seleccionar.showDialog(null,"Abrir")==JFileChooser.APPROVE_OPTION){
        archivo=seleccionar.getSelectedFile();
        if(archivo.canRead()){
        
        }if(archivo.getName().endsWith("txt")){
        String datos=AbrirArchivo(archivo);
        txtarea.setText(datos);
            
        }else{
            JOptionPane.showMessageDialog(null, "Archivo no compatible");
        }
        }
    }//GEN-LAST:event_btnArchivoMouseClicked

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
        // TODO add your handling code here:
                // TODO add your handling code here:
      if(seleccionar.showDialog(null,"Guardar")== JFileChooser.APPROVE_OPTION){
      archivo=seleccionar.getSelectedFile();
      if(archivo.getName().endsWith("txt")){
      String datos =txtarea.getText();
     
      String mensaje=GuardarArchivo(archivo,datos);
      
       File ObtenerRutaAbs = archivo.getAbsoluteFile();
            String Obtener = ObtenerRutaAbs.getPath();
      Date objDate = new Date(); 
       Path p = Paths.get("C:\\\\MEIA\\\\bitacora_backup.txt");
           
 String s = System.lineSeparator() + "Ruta Absoluta:"+Obtener+"|"+"Nombre:"+"|"+"Fecha_Transacción"+objDate;
        try (BufferedWriter writer = Files.newBufferedWriter(p, StandardOpenOption.APPEND)) 
           {
               writer.write(s);
               JOptionPane.showMessageDialog(null,"Bitacora Creada" );
               writer.close();
           } 
           catch (IOException ioe) 
           {
               System.err.format("IOException: %s%n", ioe);
           }
      if(mensaje!=null){
      JOptionPane.showMessageDialog(null, mensaje);
      }else{
      JOptionPane.showMessageDialog(null, "Archivo no compatible");
      }
      }else{
      JOptionPane.showMessageDialog(null, "Guardar documento de texto");
      }
      }
   
    }//GEN-LAST:event_btnGuardarMouseClicked

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // TODO add your handling code here:
               xx=evt.getX();
        xy=evt.getY();
    }//GEN-LAST:event_formMousePressed
int xx,xy;
    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
      int x=evt.getXOnScreen();
        int y=evt.getYOnScreen();
        
        setLocation(x-xx,y-xy);        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseDragged

    private void btnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnSalirMouseClicked
    
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
            java.util.logging.Logger.getLogger(CopiaArchivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CopiaArchivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CopiaArchivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CopiaArchivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CopiaArchivo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnArchivo;
    private javax.swing.JLabel btnGuardar;
    private javax.swing.JLabel btnSalir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtarea;
    // End of variables declaration//GEN-END:variables
}
