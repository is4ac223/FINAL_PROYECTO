/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import org.jvnet.substance.SubstanceLookAndFeel;

/**
 *
 * @author Usuario iTC
 */
public class frmPrincipal extends javax.swing.JFrame {

        /**
         * Creates new form frmPrincipal
         */
        public frmPrincipal() {
                initComponents();
                panelImage2.setIcon(new ImageIcon("src/fotos/uwu.jpeg"));
                jMenu4.setVisible(false);
        }

        /**
         * This method is called from within the constructor to initialize the
         * form. WARNING: Do NOT modify this code. The content of this method is
         * always regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jMenu1 = new javax.swing.JMenu();
                jMenu2 = new javax.swing.JMenu();
                panelImage2 = new org.edisoncor.gui.panel.PanelImage();
                jMenuBar1 = new javax.swing.JMenuBar();
                jMenu3 = new javax.swing.JMenu();
                jMenuItem1 = new javax.swing.JMenuItem();
                jMenuItem2 = new javax.swing.JMenuItem();
                jMenu4 = new javax.swing.JMenu();

                jMenu1.setText("jMenu1");

                jMenu2.setText("jMenu2");

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                javax.swing.GroupLayout panelImage2Layout = new javax.swing.GroupLayout(panelImage2);
                panelImage2.setLayout(panelImage2Layout);
                panelImage2Layout.setHorizontalGroup(
                        panelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 400, Short.MAX_VALUE)
                );
                panelImage2Layout.setVerticalGroup(
                        panelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 280, Short.MAX_VALUE)
                );

                getContentPane().add(panelImage2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 280));

                jMenu3.setText("File");

                jMenuItem1.setText("Pozo");
                jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jMenuItem1ActionPerformed(evt);
                        }
                });
                jMenu3.add(jMenuItem1);

                jMenuItem2.setText("Mapas y grafos");
                jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jMenuItem2ActionPerformed(evt);
                        }
                });
                jMenu3.add(jMenuItem2);

                jMenuBar1.add(jMenu3);

                jMenu4.setText("Edit");
                jMenuBar1.add(jMenu4);

                setJMenuBar(jMenuBar1);

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
                try {
                        new frmPozo().setVisible(true);
                } catch (Exception ex) {
                        Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
        }//GEN-LAST:event_jMenuItem1ActionPerformed

        private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
                new frmGrafo().setVisible(true);
        }//GEN-LAST:event_jMenuItem2ActionPerformed

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
                        java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
                //</editor-fold>
                //</editor-fold>

                /* Create and display the form */
                java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                setDefaultLookAndFeelDecorated(true);
                                SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.EmeraldDuskSkin");
                                new frmPrincipal().setVisible(true);
                        }
                });
        }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JMenu jMenu1;
        private javax.swing.JMenu jMenu2;
        private javax.swing.JMenu jMenu3;
        private javax.swing.JMenu jMenu4;
        private javax.swing.JMenuBar jMenuBar1;
        private javax.swing.JMenuItem jMenuItem1;
        private javax.swing.JMenuItem jMenuItem2;
        private org.edisoncor.gui.panel.PanelImage panelImage2;
        // End of variables declaration//GEN-END:variables
}
