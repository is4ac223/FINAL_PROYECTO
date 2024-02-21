/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.grafos;

import controlador.listas.DynamicList;

/**
 *
 * @author sebastian
 */
public abstract class Grafo {
        //--- G = {v,e}

        public abstract Integer num_vertice();

        public abstract Integer num_aristas();
        //v1  ---- v2

        public abstract Boolean existe_arista(Integer v1, Integer v2) throws Exception;

        public abstract Double peso_arista(Integer v1, Integer v2) throws Exception;

        public abstract void insertar_arista(Integer v1, Integer v2, Double peso) throws Exception;

        public abstract void insertar_arista(Integer v1, Integer v2) throws Exception;

        public abstract DynamicList<Adycencia> adycentes(Integer v1);
        //V1 ---- nro de adycentes?
        //G = 20V
        //MA = 20 X 20 ---> grafos grandes 

        @Override
        public String toString() {
                StringBuilder grafo = new StringBuilder("GRAFO").append("\n");
                try {
                        for (int i = 1; i <= num_vertice(); i++) {
                                grafo.append("V").append(i).append("\n");
                                DynamicList<Adycencia> list = adycentes(i);
                                for (int j = 0; j < list.getLength(); j++) {
                                        Adycencia a = list.getInfo(j);
                                        grafo.append("ady ").append(a.getDestino()).append(" peso ").append(a.getPeso()).append("\n");
                                }
                        }
                } catch (Exception e) {
                }
                return grafo.toString(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        }

}
