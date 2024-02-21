/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.grafos;

import controlador.grafos.exception.VerticeException;
import controlador.util.Utiles;

/**
 *
 * @author sebastian
 */
public class GrafoNoDirigido extends GrafoDirigido {

        public GrafoNoDirigido(Integer num_vertices) {
                super(num_vertices);
        }

        @Override
        public void insertar_arista(Integer v1, Integer v2, Double peso) throws Exception {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                if (v1.intValue() <= num_vertice() && v2.intValue() <= num_vertice()) {
                        if (!existe_arista(v1, v2)) {
                                setNum_aristas(num_aristas() + 1);
                                getListaAdycencias()[v1].add(new Adycencia(v2, peso));
                                getListaAdycencias()[v2].add(new Adycencia(v1, peso));
                                //num_aristas++;                
                                //listaAdycencias[v1].add(new Adycencia(v2, peso));
                        }
                } else {
                        throw new VerticeException();
                }
        }

        public static void main(String[] args) {
                Grafo f = new GrafoNoDirigido(13);
                System.out.println(f);
                try {
                        f.insertar_arista(1, 2, 50.0);
                        f.insertar_arista(1, 3, 50.0);
                        f.insertar_arista(4, 3, 50.0);
                        f.insertar_arista(4, 2, 50.0);
                        f.insertar_arista(4, 5, 50.0);
                        f.insertar_arista(3, 5, 50.0);
                        f.insertar_arista(4, 6, 50.0);
                        f.insertar_arista(7, 5, 50.0);
                        f.insertar_arista(7, 6, 50.0);
                        f.insertar_arista(3, 8, 50.0);
                        f.insertar_arista(5, 9, 50.0);
                        f.insertar_arista(10, 8, 50.0);
                        f.insertar_arista(11, 9, 50.0);
                        f.insertar_arista(11, 10, 50.0);
                        f.insertar_arista(11, 12, 50.0);
                        f.insertar_arista(10, 12, 50.0);
                        f.insertar_arista(13, 12, 50.0);
                        System.out.println(f);
                        PaintGraph p = new PaintGraph();
                        p.updateFile(f);
                        Utiles.abrirNavegadorPredeterminadorWindows("d3/grafo.html");
                } catch (Exception ex) {
                        System.out.println("Error " + ex);
                }
        }
}
