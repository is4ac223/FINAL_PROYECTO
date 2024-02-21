/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.grafos;

import controlador.listas.DynamicList;
import java.io.FileWriter;


/**
 *
 * @author Usuario iTC
 */
public class PaintGraph {
        String URL = "src/d3/grafo.js";

        public void updateFile(Grafo graph) throws Exception {
                StringBuilder nodesStringBuilder = new StringBuilder();
                StringBuilder edgesStringBuilder = new StringBuilder();

                try {
                        for (int i = 1; i <= graph.num_vertice(); i++) {
                                nodesStringBuilder.append("{ id: ").append(i).append(", label: \"Node ").append(i).append("\" },\n");
                                DynamicList<Adycencia> listaA = graph.adycentes(i);
                                for (int j = 0; j < listaA.getLength(); j++) {
                                        Adycencia a = listaA.getInfo(j);
                                        edgesStringBuilder.append("{ from: ").append(i)
                                                .append(", to: ").append(a.getDestino())
                                                .append(", label: \"").append(a.getPeso()).append("\" },\n");
                                }
                        }
                } catch (Exception e) {
                        System.out.println("Error: " + e);
                }

                // Eliminar la coma final de las cadenas de nodos y aristas
                if (nodesStringBuilder.length() > 0) {
                        nodesStringBuilder.setLength(nodesStringBuilder.length() - 2);
                }
                if (edgesStringBuilder.length() > 0) {
                        edgesStringBuilder.setLength(edgesStringBuilder.length() - 2);
                }

                String paint = "var nodes = new vis.DataSet([\n" + nodesStringBuilder.toString() + "]);\n\n"
                        + "var edges = new vis.DataSet([\n" + edgesStringBuilder.toString() + "]);\n\n"
                        + "var container = document.getElementById(\"mynetwork\");\n"
                        + "var data = {\n"
                        + "  nodes: nodes,\n"
                        + "  edges: edges,\n"
                        + "};\n"
                        + "var options = {};\n"
                        + "var network = new vis.Network(container, data, options);";

                FileWriter load = new FileWriter(URL);
                load.write(paint);
                load.close();
        }
        
        public void updateFileLabel(GrafoEtiquetadoDirigido graph) throws Exception {
                StringBuilder nodesStringBuilder = new StringBuilder();
                StringBuilder edgesStringBuilder = new StringBuilder();

                try {
                        for (int i = 1; i <= graph.num_vertice(); i++) {
                                nodesStringBuilder.append("{ id: ").append(i).append(", label: \" ").append(graph.getLabelE(i)).append(" ").append("\" },\n");
                                DynamicList<Adycencia> listaA = graph.adycentes(i);
                                for (int j = 0; j < listaA.getLength(); j++) {
                                        Adycencia a = listaA.getInfo(j);
                                        edgesStringBuilder.append("{ from: ").append(i)
                                                .append(", to: ").append(a.getDestino())
                                                .append(", label: \"").append(a.getPeso()).append("\" },\n");
                                }
                        }
                } catch (Exception e) {
                        System.out.println("Error: " + e);
                }

                String paint = "var nodes = new vis.DataSet([\n" + nodesStringBuilder.toString() + "]);\n\n"
                        + "var edges = new vis.DataSet([\n" + edgesStringBuilder.toString() + "]);\n\n"
                        + "var container = document.getElementById(\"mynetwork\");\n"
                        + "var data = {\n"
                        + "  nodes: nodes,\n"
                        + "  edges: edges,\n"
                        + "};\n"
                        + "var options = {};\n"
                        + "var network = new vis.Network(container, data, options);";

                FileWriter load = new FileWriter(URL);
                load.write(paint);
                load.close();
        }
}
