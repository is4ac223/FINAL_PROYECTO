/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.arreglos.tablas;


import controlador.grafos.GrafoEtiquetadoDirigido;
import controlador.util.Utiles;
import javax.swing.table.AbstractTableModel;
import modelo.Pozo;

/**
 *
 * @author Usuario iTC
 */
public class ModeloTablaAdyacenciaPozo extends AbstractTableModel {

        private GrafoEtiquetadoDirigido<Pozo> grafo;

        public GrafoEtiquetadoDirigido getGrafo() {
                return grafo;
        }

        public void setGrafo(GrafoEtiquetadoDirigido grafo) {
                this.grafo = grafo;
        }

        @Override
        public int getRowCount() {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                return grafo.num_vertice();
        }

        @Override
        public int getColumnCount() {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                if (grafo == null) {
                        return 1;
                } else {
                        return grafo.num_vertice() + 1;
                }
        }
        
        

        @Override
        public Object getValueAt(int i, int il) {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                try {
                        if(il == 0){
                                return grafo.getLabelE(i + 1).toString();
                        } else {
                                Pozo o = grafo.getLabelE(i + 1);
                                Pozo d = grafo.getLabelE(il);
                                if(grafo.isEdgeE(o, d)){
                                        return Utiles.redondear(grafo.peso_arista(i+1, il));
                                }
                        }
                } catch (Exception e) {
                }
                return null;
        }

        @Override
        public String getColumnName(int column) {
                //return super.getColumnName(column); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
                if (column == 0) {
                        return "Pozos";
                } else {
                        try {
                                return grafo.getLabelE(column).toString();
                        } catch (Exception e) {
                                return " ";
                        }
                }
        }

}
