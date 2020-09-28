
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
    initComponents();
     getContentPane().setBackground(Color.white);
    
    
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

        Archivo = new javax.swing.JButton();
        Backup = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtarea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Archivo.setFont(new java.awt.Font("Museo 300", 0, 18)); // NOI18N
        Archivo.setText("Archivo");
        Archivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ArchivoActionPerformed(evt);
            }
        });

        Backup.setFont(new java.awt.Font("Museo 300", 0, 18)); // NOI18N
        Backup.setText("Guardar Copia");
        Backup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackupActionPerformed(evt);
            }
        });

        txtarea.setColumns(20);
        txtarea.setFont(new java.awt.Font("Museo 300", 0, 18)); // NOI18N
        txtarea.setRows(5);
        jScrollPane1.setViewportView(txtarea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Archivo, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 258, Short.MAX_VALUE)
                        .addComponent(Backup, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Backup, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(Archivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ArchivoActionPerformed
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
        
    }//GEN-LAST:event_ArchivoActionPerformed

    private void BackupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackupActionPerformed
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
   
    
    }//GEN-LAST:event_BackupActionPerformed
    
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
    private javax.swing.JButton Archivo;
    private javax.swing.JButton Backup;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtarea;
    // End of variables declaration//GEN-END:variables
}

