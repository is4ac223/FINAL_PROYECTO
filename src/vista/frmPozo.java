/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import controlador.PozoDao;
import controlador.util.Utiles;
import java.io.File;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import vista.arreglos.tablas.ModeloTablaPozo;

/**
 *
 * @author Usuario iTC
 */
public class frmPozo extends javax.swing.JFrame {

        private File foto1;
        private File foto2;
        private PozoDao pd = new PozoDao();
        private ModeloTablaPozo mtea = new ModeloTablaPozo();

        /**
         * Creates new form VistaMapa
         */
        public frmPozo() throws Exception {
                initComponents();
                cargarTabla();
        }
        
        private void cargarTabla() throws Exception {
                mtea.setGrafo(pd.getGrafo());
                mtea.fireTableDataChanged();
                tblPozos.setModel(mtea);
                tblPozos.updateUI();
        }

        private File cargarImagen() throws Exception {
                File obj = null;
                JFileChooser chooser = new JFileChooser();
                chooser.setAcceptAllFileFilterUsed(false);
                FileNameExtensionFilter filter
                        = new FileNameExtensionFilter("Imagenes", "jpg", "png", "jpeg");
                chooser.addChoosableFileFilter(filter);
                Integer resp = chooser.showOpenDialog(this);
                if (resp == JFileChooser.APPROVE_OPTION) {
                        obj = chooser.getSelectedFile();
                }
                return obj;
        }
        
        private void limpiar() {
                txtNombre.setText(" ");
                txtFoto1.setText(" ");
                txtLatitud.setText(" ");
                txtLongitud.setText(" ");
                txtFoto2.setText(" ");
        }
        
        private Boolean validar(){
                return((!txtNombre.getText().trim().isEmpty() && !txtFoto1.getText().trim().isEmpty()
                        && !txtLatitud.getText().trim().isEmpty() && !txtLongitud.getText().trim().isEmpty())
                        && !txtFoto2.getText().trim().isEmpty() && Utiles.validarTexto(txtNombre.getText())
                        && Utiles.validarDouble(txtLatitud.getText()) && Utiles.validarDouble(txtLongitud.getText()));
        }

        private void guardar() throws Exception {
                if (validar()) {
                        String auxEscudo = UUID.randomUUID().toString();
                        String auxPortada = UUID.randomUUID().toString();
                        pd.getPozo().setNombre(txtNombre.getText().trim());
                        pd.getPozo().getCoordenada().setLatitud(Double.valueOf(txtLatitud.getText().trim()));
                        pd.getPozo().getCoordenada().setLongitud(Double.valueOf(txtLongitud.getText().trim()));
                        String auxE = "foto"+ auxPortada + "." + Utiles.extension(foto1.getName());
                        String auxP = "foto" + auxEscudo + "." + Utiles.extension(foto2.getName());
                        pd.getPozo().setFoto1(auxE);
                        pd.getPozo().setFoto2(auxP);
                        Utiles.copiarArchivo(foto1, new File(auxE));
                        Utiles.copiarArchivo(foto2, new File(auxP));
                        if (pd.persist()) {
                                JOptionPane.showMessageDialog(null, "Datos guardados", "Ok",
                                        JOptionPane.INFORMATION_MESSAGE);
                                limpiar();
                                pd.setListPozos(null);
                                cargarTabla();
                        } else {
                                JOptionPane.showMessageDialog(null, "No se pudo guardar, hubo un error", "ERROR",
                                        JOptionPane.ERROR_MESSAGE);
                        }
                } else {
                        JOptionPane.showMessageDialog(null, "Falta llenar campos", "Error", JOptionPane.ERROR_MESSAGE);
                } 
        }

        /**
         * This method is called from within the constructor to initialize the
         * form. WARNING: Do NOT modify this code. The content of this method is
         * always regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jPanel1 = new javax.swing.JPanel();
                jPanel2 = new javax.swing.JPanel();
                jLabel1 = new javax.swing.JLabel();
                txtNombre = new javax.swing.JTextField();
                jLabel2 = new javax.swing.JLabel();
                txtLatitud = new javax.swing.JTextField();
                jLabel3 = new javax.swing.JLabel();
                txtLongitud = new javax.swing.JTextField();
                jLabel4 = new javax.swing.JLabel();
                txtFoto1 = new javax.swing.JTextField();
                btnCargaFoto1 = new javax.swing.JButton();
                jLabel5 = new javax.swing.JLabel();
                txtFoto2 = new javax.swing.JTextField();
                btnCargarFoto2 = new javax.swing.JButton();
                btnGuardar = new javax.swing.JButton();
                jScrollPane1 = new javax.swing.JScrollPane();
                tblPozos = new javax.swing.JTable();

                setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

                jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

                jPanel2.setBorder(new javax.swing.border.MatteBorder(null));

                jLabel1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
                jLabel1.setText("Nombre:");

                jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
                jLabel2.setText("Latitud:");

                jLabel3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
                jLabel3.setText("Longitud:");

                jLabel4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
                jLabel4.setText("Foto 1:");

                txtFoto1.setEnabled(false);
                txtFoto1.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                txtFoto1MouseClicked(evt);
                        }
                });

                btnCargaFoto1.setText("Cargar");
                btnCargaFoto1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnCargaFoto1ActionPerformed(evt);
                        }
                });

                jLabel5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
                jLabel5.setText("Foto 2:");

                txtFoto2.setEnabled(false);
                txtFoto2.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                txtFoto2MouseClicked(evt);
                        }
                });

                btnCargarFoto2.setText("Cargar");
                btnCargarFoto2.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnCargarFoto2ActionPerformed(evt);
                        }
                });

                btnGuardar.setText("Guardar");
                btnGuardar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnGuardarActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
                jPanel2.setLayout(jPanel2Layout);
                jPanel2Layout.setHorizontalGroup(
                        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtFoto1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnCargaFoto1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtFoto2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnCargarFoto2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                        .addComponent(jLabel3)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(txtLongitud))
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                        .addComponent(jLabel2)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(txtLatitud, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21))
                );
                jPanel2Layout.setVerticalGroup(
                        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2)
                                        .addComponent(txtLatitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(txtLongitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4)
                                        .addComponent(txtFoto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnCargaFoto1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(txtFoto2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnCargarFoto2)
                                        .addComponent(btnGuardar))
                                .addContainerGap(20, Short.MAX_VALUE))
                );

                tblPozos.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                                {null, null, null, null},
                                {null, null, null, null},
                                {null, null, null, null},
                                {null, null, null, null}
                        },
                        new String [] {
                                "Title 1", "Title 2", "Title 3", "Title 4"
                        }
                ));
                jScrollPane1.setViewportView(tblPozos);

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane1))
                                .addContainerGap())
                );
                jPanel1Layout.setVerticalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                );

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
                try {
                        guardar();
                        cargarTabla();
                } catch (Exception ex) {
                        Logger.getLogger(frmPozo.class.getName()).log(Level.SEVERE, null, ex);
                }
        }//GEN-LAST:event_btnGuardarActionPerformed

        private void btnCargarFoto2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarFoto2ActionPerformed
                try {
                        foto2 = cargarImagen();
                        if (foto2 != null) {
                                txtFoto2.setText(foto2  .getAbsolutePath());
                        }
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", HEIGHT);
                }
        }//GEN-LAST:event_btnCargarFoto2ActionPerformed

        private void btnCargaFoto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargaFoto1ActionPerformed
                try {
                        foto1 = cargarImagen();
                        if (foto1 != null) {
                                txtFoto1.setText(foto1.getAbsolutePath());
                        }
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", HEIGHT);
                }
        }//GEN-LAST:event_btnCargaFoto1ActionPerformed

        private void txtFoto1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFoto1MouseClicked
                if (evt.getClickCount() > 2) {
                        new frmImagen(null, true, foto1).setVisible(true);
                }
        }//GEN-LAST:event_txtFoto1MouseClicked

        private void txtFoto2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFoto2MouseClicked
                if (evt.getClickCount() > 2) {
                        new frmImagen(null, true, foto2).setVisible(true);
                }
        }//GEN-LAST:event_txtFoto2MouseClicked

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
                        java.util.logging.Logger.getLogger(frmPozo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(frmPozo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(frmPozo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(frmPozo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
                //</editor-fold>
                //</editor-fold>
                //</editor-fold>
                //</editor-fold>
                //</editor-fold>
                //</editor-fold>
                //</editor-fold>
                //</editor-fold>

                /* Create and display the form */
                java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                try {
                                        new frmPozo().setVisible(true);
                                } catch (Exception ex) {
                                        Logger.getLogger(frmPozo.class.getName()).log(Level.SEVERE, null, ex);
                                }
                        }
                });
        }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton btnCargaFoto1;
        private javax.swing.JButton btnCargarFoto2;
        private javax.swing.JButton btnGuardar;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JLabel jLabel5;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JPanel jPanel2;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JTable tblPozos;
        private javax.swing.JTextField txtFoto1;
        private javax.swing.JTextField txtFoto2;
        private javax.swing.JTextField txtLatitud;
        private javax.swing.JTextField txtLongitud;
        private javax.swing.JTextField txtNombre;
        // End of variables declaration//GEN-END:variables
}