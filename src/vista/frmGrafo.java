/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import controlador.PozoDao;
import controlador.grafos.PaintGraph;
import controlador.listas.DynamicList;
import controlador.util.Utiles;
import java.time.Duration;
import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Pozo;
import vista.arreglos.tablas.ModeloTablaAdyacenciaPozo;
import vista.utilidades.UtilesVistaPozo;

/**
 *
 * @author Usuario iTC
 */
public class frmGrafo extends javax.swing.JFrame {

        private PozoDao pd = new PozoDao();
        private ModeloTablaAdyacenciaPozo mtea = new ModeloTablaAdyacenciaPozo();
        private double tiempomedido;

        /**
         * Creates new form frmGrafoEscuela
         */
        public frmGrafo() {
                initComponents();
                limpiar();
        }

        private void cargarTabla() throws Exception {
                mtea.setGrafo(pd.getGrafo());
                mtea.fireTableDataChanged();
                tblTabla.setModel(mtea);
                tblTabla.updateUI();
        }

        private void guardarGrafo() {
                try {
                        int i = JOptionPane.showConfirmDialog(null, "Esta seguro de guardar", "Advertencia", JOptionPane.OK_CANCEL_OPTION);
                        if (i == JOptionPane.OK_OPTION) {
                                if (pd.getGrafo() != null) {
                                        pd.guardarGrafo();
                                        JOptionPane.showMessageDialog(null, "Grafo guardado", "ERROR",
                                                JOptionPane.INFORMATION_MESSAGE);
                                } else {
                                        JOptionPane.showMessageDialog(null, "No se puede guardar grafo vacio", "ERROR",
                                                JOptionPane.ERROR_MESSAGE);
                                }
                        }
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR",
                                JOptionPane.ERROR_MESSAGE);
                }
        }

        private void load() throws Exception {
                int i = JOptionPane.showConfirmDialog(null, "Esta seguro de cargar", "Advertencia", JOptionPane.OK_CANCEL_OPTION);
                if (i == JOptionPane.OK_OPTION) {
                        pd.loadGraph();
                        limpiar();
                        JOptionPane.showMessageDialog(null, "Grafo cargado", "ERROR",
                                JOptionPane.INFORMATION_MESSAGE);
                }
        }

        private void adyacencia() {
                try {
                        Integer origen = cbxOrigen.getSelectedIndex();
                        Integer destino = cbxDestino.getSelectedIndex();
                        if (origen.intValue() == destino.intValue()) {
                                JOptionPane.showMessageDialog(null, "Elige pozos diferentes", "ERROR",
                                        JOptionPane.ERROR_MESSAGE);
                        } else {
                                System.out.println(pd.getListPozos().getInfo(origen));
                                System.out.println(pd.getListPozos().getInfo(destino));
                                Double dist = UtilesVistaPozo.calcularDistanciaEscuelas(pd.getListPozos().getInfo(origen), pd.getListPozos().getInfo(destino));
                                dist = Utiles.redondear(dist);
                                pd.getGrafo().insertEdgeE(pd.getListPozos().getInfo(origen), pd.getListPozos().getInfo(destino), dist);
                        }
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR",
                                JOptionPane.ERROR_MESSAGE);
                }
        }

        private void adyacenciaAleatoria() {
                try {
                        int totalPozos = pd.getListPozos().getLength();

                        for (int i = 0; i < totalPozos; i++) {
                                Integer origen, destino;
                                do {
                                        origen = (int) (Math.random() * totalPozos);
                                        destino = (int) (Math.random() * totalPozos);
                                } while (origen.equals(destino));

                                System.out.println("Adyacencia " + (i + 1) + ":");
                                System.out.println(pd.getListPozos().getInfo(origen));
                                System.out.println(pd.getListPozos().getInfo(destino));

                                Double dist = UtilesVistaPozo.calcularDistanciaEscuelas(pd.getListPozos().getInfo(origen), pd.getListPozos().getInfo(destino));
                                dist = Utiles.redondear(dist);

                                pd.getGrafo().insertEdgeE(pd.getListPozos().getInfo(origen), pd.getListPozos().getInfo(destino), dist);
                        }
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                }
        }

        private void limpiar() {
                try {
                        UtilesVistaPozo.cargarComboEscuela(cbxOrigen);
                        UtilesVistaPozo.cargarComboEscuela(cbxDestino);
                        UtilesVistaPozo.cargarComboEscuela(cbxOrigenRecorrido);
                        cargarTabla();
                } catch (Exception e) {
                }
        }

        private void mostrarGrafo() throws Exception {
                PaintGraph p = new PaintGraph();
                String url = "src/d3/grafo.html";
                p.updateFileLabel(pd.getGrafo());
                Utiles.abrirNavegadorPredeterminadorWindows(url);
        }

        private void mostrarMapa() throws Exception {
                String url = "src/mapas/index.html";
                UtilesVistaPozo.crearMapaEscuela(pd.getGrafo());
                Utiles.abrirNavegadorPredeterminadorWindows(url);
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
                btnGrafo = new org.edisoncor.gui.button.ButtonAero();
                btnGuardar = new org.edisoncor.gui.button.ButtonAero();
                labelRound1 = new org.edisoncor.gui.label.LabelRound();
                jLabel1 = new javax.swing.JLabel();
                jLabel2 = new javax.swing.JLabel();
                cbxDestino = new javax.swing.JComboBox<>();
                cbxOrigen = new javax.swing.JComboBox<>();
                btnMapa = new org.edisoncor.gui.button.ButtonAero();
                panelRect1 = new org.edisoncor.gui.panel.PanelRect();
                jScrollPane1 = new javax.swing.JScrollPane();
                tblTabla = new javax.swing.JTable();
                btnAdyacencia = new org.edisoncor.gui.button.ButtonAero();
                btnCargar = new org.edisoncor.gui.button.ButtonAero();
                btnRecorridoFord = new javax.swing.JButton();
                btnRecorridoFloyd = new javax.swing.JButton();
                btnRecorridoAnchura = new javax.swing.JButton();
                btnRecorridoProfundidad = new javax.swing.JButton();
                jLabel3 = new javax.swing.JLabel();
                cbxOrigenRecorrido = new javax.swing.JComboBox<>();
                jScrollPane2 = new javax.swing.JScrollPane();
                txtARecorr = new javax.swing.JTextArea();
                btnAleatorio = new org.edisoncor.gui.button.ButtonAero();

                setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

                jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                btnGrafo.setBackground(new java.awt.Color(0, 102, 102));
                btnGrafo.setText("Grafo");
                btnGrafo.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnGrafoActionPerformed(evt);
                        }
                });
                jPanel1.add(btnGrafo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, -1, -1));

                btnGuardar.setBackground(new java.awt.Color(0, 102, 102));
                btnGuardar.setText("Guardar");
                btnGuardar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnGuardarActionPerformed(evt);
                        }
                });
                jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 530, -1, -1));

                labelRound1.setText("ADYACENCIAS");
                jPanel1.add(labelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 360, 40));

                jLabel1.setText("Destino:");
                jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

                jLabel2.setText("Origen:");
                jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

                cbxDestino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
                jPanel1.add(cbxDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 240, -1));

                cbxOrigen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
                jPanel1.add(cbxOrigen, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 240, -1));

                btnMapa.setBackground(new java.awt.Color(0, 102, 102));
                btnMapa.setText("Mapa");
                btnMapa.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnMapaActionPerformed(evt);
                        }
                });
                jPanel1.add(btnMapa, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, -1, -1));

                panelRect1.setLayout(null);

                tblTabla.setModel(new javax.swing.table.DefaultTableModel(
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
                jScrollPane1.setViewportView(tblTabla);

                panelRect1.add(jScrollPane1);
                jScrollPane1.setBounds(10, 10, 550, 330);

                jPanel1.add(panelRect1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 570, 350));

                btnAdyacencia.setBackground(new java.awt.Color(0, 102, 102));
                btnAdyacencia.setText("Adyacencia");
                btnAdyacencia.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnAdyacenciaActionPerformed(evt);
                        }
                });
                jPanel1.add(btnAdyacencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

                btnCargar.setBackground(new java.awt.Color(0, 102, 102));
                btnCargar.setText("Cargar");
                btnCargar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnCargarActionPerformed(evt);
                        }
                });
                jPanel1.add(btnCargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 530, -1, -1));

                btnRecorridoFord.setText("Ford");
                btnRecorridoFord.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnRecorridoFordActionPerformed(evt);
                        }
                });
                jPanel1.add(btnRecorridoFord, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 350, -1, -1));

                btnRecorridoFloyd.setText("Floyd");
                btnRecorridoFloyd.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnRecorridoFloydActionPerformed(evt);
                        }
                });
                jPanel1.add(btnRecorridoFloyd, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 350, -1, -1));

                btnRecorridoAnchura.setText("Anchura");
                btnRecorridoAnchura.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnRecorridoAnchuraActionPerformed(evt);
                        }
                });
                jPanel1.add(btnRecorridoAnchura, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 350, -1, -1));

                btnRecorridoProfundidad.setText("Profundidad");
                btnRecorridoProfundidad.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnRecorridoProfundidadActionPerformed(evt);
                        }
                });
                jPanel1.add(btnRecorridoProfundidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 350, -1, -1));

                jLabel3.setText("Origen:");
                jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 440, -1, -1));

                cbxOrigenRecorrido.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
                jPanel1.add(cbxOrigenRecorrido, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 440, 240, -1));

                txtARecorr.setColumns(20);
                txtARecorr.setRows(5);
                jScrollPane2.setViewportView(txtARecorr);

                jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 480, 300));

                btnAleatorio.setBackground(new java.awt.Color(0, 102, 102));
                btnAleatorio.setText("Aleatorio");
                btnAleatorio.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnAleatorioActionPerformed(evt);
                        }
                });
                jPanel1.add(btnAleatorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, -1, -1));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1083, Short.MAX_VALUE)
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
                );

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
                guardarGrafo();
        }//GEN-LAST:event_btnGuardarActionPerformed

        private void btnGrafoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrafoActionPerformed
                try {
                        mostrarGrafo();
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR",
                                JOptionPane.ERROR_MESSAGE);
                }
        }//GEN-LAST:event_btnGrafoActionPerformed

        private void btnMapaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMapaActionPerformed
                try {
                        mostrarMapa();
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR",
                                JOptionPane.ERROR_MESSAGE);
                }
        }//GEN-LAST:event_btnMapaActionPerformed

        private void btnAdyacenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdyacenciaActionPerformed
                try {
                        adyacencia();
                        limpiar();
                } catch (Exception e) {
                }
        }//GEN-LAST:event_btnAdyacenciaActionPerformed

        private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarActionPerformed
                try {
                        load();
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR",
                                JOptionPane.ERROR_MESSAGE);
                }
        }//GEN-LAST:event_btnCargarActionPerformed

        private void btnRecorridoFloydActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecorridoFloydActionPerformed
                try {
                        Pozo pozoSeleccionado = pd.getListPozos().getInfo(cbxOrigenRecorrido.getSelectedIndex());
                        if (pozoSeleccionado == null) {
                                JOptionPane.showMessageDialog(this, "Por favor, seleccione un vértice de origen.", "Selección de Vértice", JOptionPane.WARNING_MESSAGE);
                                return; 
                        }
                        Instant start = Instant.now();
                        String t = pd.getGrafo().floydWarshall();
                        txtARecorr.setText(t);
                        Instant end = Instant.now();
                        Duration duration = Duration.between(start, end);
                        tiempomedido = (double) duration.toMillis();
                        JOptionPane.showMessageDialog(null, tiempomedido + " milisegundos");
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Error: No se encuentra el vértice seleccionado.", "Error de Vértice", JOptionPane.ERROR_MESSAGE);
                }
        }//GEN-LAST:event_btnRecorridoFloydActionPerformed

        private void btnRecorridoFordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecorridoFordActionPerformed
                try {
                        Pozo pozoSeleccionado = pd.getListPozos().getInfo(cbxOrigenRecorrido.getSelectedIndex());
                        if (pozoSeleccionado == null) {
                                JOptionPane.showMessageDialog(this, "Por favor, seleccione un vértice de origen.", "Selección de Vértice", JOptionPane.WARNING_MESSAGE);
                                return;
                        }
                        Instant start = Instant.now();
                        String t = pd.getGrafo().bellmanFord(pozoSeleccionado);
                        txtARecorr.setText(t);
                        Instant end = Instant.now();
                        Duration duration = Duration.between(start, end);
                        tiempomedido = (double) duration.toMillis();
                        JOptionPane.showMessageDialog(null, tiempomedido + " milisegundos");
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Error: No se encuentra el vértice seleccionado.", "Error de Vértice", JOptionPane.ERROR_MESSAGE);
                }
        }//GEN-LAST:event_btnRecorridoFordActionPerformed

        private void btnRecorridoProfundidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecorridoProfundidadActionPerformed
                try {
                        Pozo pozoSeleccionado = pd.getListPozos().getInfo(cbxOrigenRecorrido.getSelectedIndex());
                        if (pozoSeleccionado == null) {
                                JOptionPane.showMessageDialog(this, "Por favor, seleccione un vértice de origen.", "Selección de Vértice", JOptionPane.WARNING_MESSAGE);
                                return; 
                        }
                        Instant start = Instant.now();
                        String t = pd.getGrafo().profunidad(pozoSeleccionado);
                        txtARecorr.setText(t);
                        Instant end = Instant.now();
                        Duration duration = Duration.between(start, end);
                        tiempomedido = (double) duration.toMillis();
                        JOptionPane.showMessageDialog(null, tiempomedido + " milisegundos");
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Error: No se encuentra el vértice seleccionado.", "Error de Vértice", JOptionPane.ERROR_MESSAGE);
                }
        }//GEN-LAST:event_btnRecorridoProfundidadActionPerformed

        private void btnRecorridoAnchuraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecorridoAnchuraActionPerformed
                try {
                        Pozo pozoSeleccionado = pd.getListPozos().getInfo(cbxOrigenRecorrido.getSelectedIndex());
                        if (pozoSeleccionado == null) {
                                JOptionPane.showMessageDialog(this, "Por favor, seleccione un vértice de origen.", "Selección de Vértice", JOptionPane.WARNING_MESSAGE);
                                return;
                        }
                        Instant start = Instant.now();
                        String t = pd.getGrafo().bfs(pozoSeleccionado);
                        txtARecorr.setText(t);
                        Instant end = Instant.now();
                        Duration duration = Duration.between(start, end);
                        tiempomedido = (double) duration.toMillis();
                        JOptionPane.showMessageDialog(null, tiempomedido + " milisegundos");
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Error: No se encuentra el vértice seleccionado.", "Error de Vértice", JOptionPane.ERROR_MESSAGE);
                }
        }//GEN-LAST:event_btnRecorridoAnchuraActionPerformed

        private void btnAleatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAleatorioActionPerformed
                adyacenciaAleatoria();
                limpiar();
        }//GEN-LAST:event_btnAleatorioActionPerformed

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
                        java.util.logging.Logger.getLogger(frmGrafo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(frmGrafo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(frmGrafo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(frmGrafo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
                //</editor-fold>
                //</editor-fold>
                //</editor-fold>
                //</editor-fold>

                /* Create and display the form */
                java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                new frmGrafo().setVisible(true);
                        }
                });
        }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private org.edisoncor.gui.button.ButtonAero btnAdyacencia;
        private org.edisoncor.gui.button.ButtonAero btnAleatorio;
        private org.edisoncor.gui.button.ButtonAero btnCargar;
        private org.edisoncor.gui.button.ButtonAero btnGrafo;
        private org.edisoncor.gui.button.ButtonAero btnGuardar;
        private org.edisoncor.gui.button.ButtonAero btnMapa;
        private javax.swing.JButton btnRecorridoAnchura;
        private javax.swing.JButton btnRecorridoFloyd;
        private javax.swing.JButton btnRecorridoFord;
        private javax.swing.JButton btnRecorridoProfundidad;
        private javax.swing.JComboBox<String> cbxDestino;
        private javax.swing.JComboBox<String> cbxOrigen;
        private javax.swing.JComboBox<String> cbxOrigenRecorrido;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JScrollPane jScrollPane2;
        private org.edisoncor.gui.label.LabelRound labelRound1;
        private org.edisoncor.gui.panel.PanelRect panelRect1;
        private javax.swing.JTable tblTabla;
        private javax.swing.JTextArea txtARecorr;
        // End of variables declaration//GEN-END:variables
}
