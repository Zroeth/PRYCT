



import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Cathy
 */
public class Mensajeria extends javax.swing.JFrame {

    /**
     * Creates new form Mensajeria
     */
    public Mensajeria() {
        initComponents();
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
        CuerpoMsj = new javax.swing.JTextArea();
        LabelMensaje = new javax.swing.JLabel();
        LabelAsunto = new javax.swing.JLabel();
        EscribirCorreo = new javax.swing.JLabel();
        Adjuntar = new javax.swing.JButton();
        Enviar = new javax.swing.JButton();
        NombreArchivo = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ArchivoAdjunto = new javax.swing.JTextPane();
        btnCancelar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        AsuntoT = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setForeground(java.awt.Color.white);

        CuerpoMsj.setColumns(20);
        CuerpoMsj.setRows(5);
        jScrollPane1.setViewportView(CuerpoMsj);

        LabelMensaje.setFont(new java.awt.Font("Copperplate Gothic Bold", 2, 14)); // NOI18N
        LabelMensaje.setText("Mensaje");

        LabelAsunto.setFont(new java.awt.Font("Copperplate Gothic Bold", 2, 14)); // NOI18N
        LabelAsunto.setText("Asunto");

        EscribirCorreo.setFont(new java.awt.Font("Copperplate Gothic Bold", 2, 14)); // NOI18N
        EscribirCorreo.setText("Escribir Correo");

        Adjuntar.setBackground(new java.awt.Color(204, 0, 51));
        Adjuntar.setText("Adjuntar");
        Adjuntar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdjuntarActionPerformed(evt);
            }
        });

        Enviar.setBackground(new java.awt.Color(204, 0, 0));
        Enviar.setText("Enviar");
        Enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnviarActionPerformed(evt);
            }
        });

        jScrollPane3.setViewportView(ArchivoAdjunto);

        javax.swing.GroupLayout NombreArchivoLayout = new javax.swing.GroupLayout(NombreArchivo);
        NombreArchivo.setLayout(NombreArchivoLayout);
        NombreArchivoLayout.setHorizontalGroup(
            NombreArchivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NombreArchivoLayout.createSequentialGroup()
                .addContainerGap(175, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        NombreArchivoLayout.setVerticalGroup(
            NombreArchivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NombreArchivoLayout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnCancelar.setBackground(new java.awt.Color(204, 0, 51));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        AsuntoT.setColumns(20);
        AsuntoT.setRows(5);
        jScrollPane2.setViewportView(AsuntoT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Adjuntar)
                .addGap(18, 18, 18)
                .addComponent(Enviar)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar)
                .addGap(28, 28, 28))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(EscribirCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(LabelMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(NombreArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2))))
                .addContainerGap(79, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(LabelAsunto, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(444, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(EscribirCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(NombreArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Adjuntar)
                    .addComponent(Enviar)
                    .addComponent(btnCancelar))
                .addGap(27, 27, 27))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(124, 124, 124)
                    .addComponent(LabelAsunto, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(285, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void AdjuntarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdjuntarActionPerformed
        // TODO add your handling code here:
        
        AdjuntarArchivo AdjuntarA= new AdjuntarArchivo();
        AdjuntarA.setVisible(true);
        
    }//GEN-LAST:event_AdjuntarActionPerformed
 String Asunto, Mensaje;
    private void EnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnviarActionPerformed
       VistaMensaje vistaM = new VistaMensaje();
       String asunrecibido = AsuntoT.getText();
       VistaMensaje.AsuntoRecibido.setText(asunrecibido);
       String Msjrecibido = CuerpoMsj.getText();
       VistaMensaje.MensajeRecibido.setText(Msjrecibido);
       AdjuntarArchivo Adj=new AdjuntarArchivo();
       String msj=ArchivoAdjunto.getText();
       String msjAd = Adj.ArchivoSel.getText();
       VistaMensaje.AdjuntoRecibido.setText(msj+msjAd);
       vistaM.setVisible(true);
        dispose();
    }//GEN-LAST:event_EnviarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

   
     
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
            java.util.logging.Logger.getLogger(Mensajeria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mensajeria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mensajeria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mensajeria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mensajeria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Adjuntar;
    public static javax.swing.JTextPane ArchivoAdjunto;
    private javax.swing.JTextArea AsuntoT;
    private javax.swing.JTextArea CuerpoMsj;
    private javax.swing.JButton Enviar;
    private javax.swing.JLabel EscribirCorreo;
    private javax.swing.JLabel LabelAsunto;
    private javax.swing.JLabel LabelMensaje;
    private javax.swing.JPanel NombreArchivo;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
