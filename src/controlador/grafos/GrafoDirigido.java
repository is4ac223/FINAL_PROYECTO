/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.grafos;

import controlador.grafos.exception.VerticeException;
import controlador.listas.DynamicList;

/**
 *
 * @author sebastian
 */
public class GrafoDirigido extends Grafo {

        private Integer num_vertice;
        private Integer num_aristas;
        private DynamicList<Adycencia> listaAdycencias[];

        public GrafoDirigido(Integer num_vertices) {
                this.num_vertice = num_vertices;
                this.num_aristas = 0;
                listaAdycencias = new DynamicList[num_vertices + 1];
                for (int i = 1; i <= this.num_vertice; i++) {
                        listaAdycencias[i] = new DynamicList<>();
                }
        }

        @Override
        public Integer num_vertice() {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                return num_vertice;
        }

        @Override
        public Integer num_aristas() {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                return num_aristas;
        }

        @Override
        public Boolean existe_arista(Integer v1, Integer v2) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                Boolean band = false;
                if (v1.intValue() <= num_vertice && v2.intValue() <= num_vertice) {
                        DynamicList<Adycencia> listaA = listaAdycencias[v1];
                        for (int i = 0; i < listaA.getLength(); i++) {
                                Adycencia a = listaA.getInfo(i);
                                if (a.getDestino().intValue() == v2.intValue()) {
                                        band = true;
                                        break;
                                }
                        }
                } else {
                        throw new VerticeException();
                }
                return band;
        }

        @Override
        public Double peso_arista(Integer v1, Integer v2) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                Double peso = Double.NaN;
                if (existe_arista(v1, v2)) {
                        DynamicList<Adycencia> listaA = listaAdycencias[v1];
                        for (int i = 0; i < listaA.getLength(); i++) {
                                Adycencia a = listaA.getInfo(i);
                                if (a.getDestino().intValue() == v2.intValue()) {
                                        peso = a.getPeso();
                                        break;
                                }
                        }
                }
                return peso;
        }

        @Override
        public void insertar_arista(Integer v1, Integer v2, Double peso) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                if (v1.intValue() <= num_vertice && v2.intValue() <= num_vertice) {
                        if (!existe_arista(v1, v2)) {
                                num_aristas++;
                                listaAdycencias[v1].add(new Adycencia(v2, peso));
                        }
                } else {
                        throw new VerticeException();
                }
        }

        @Override
        public void insertar_arista(Integer v1, Integer v2) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                insertar_arista(v1, v2, Double.NaN);
        }

        @Override
        public DynamicList<Adycencia> adycentes(Integer v1) {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                return listaAdycencias[v1];
        }

        public void setNum_aristas(Integer num_aristas) {
                this.num_aristas = num_aristas;
        }

        public void setListaAdycencias(DynamicList<Adycencia>[] listaAdycencias) {
                this.listaAdycencias = listaAdycencias;
        }

        public DynamicList<Adycencia>[] getListaAdycencias() {
                return listaAdycencias;
        }

        public static void main(String[] args) {
                Grafo f = new GrafoDirigido(6);
                System.out.println(f);
                try {
                        f.insertar_arista(1, 3, 50.0);
                        f.insertar_arista(4, 5, 10.0);
                        System.out.println(f);

                } catch (Exception ex) {
                        System.out.println("Error " + ex);
                }

        }
}
