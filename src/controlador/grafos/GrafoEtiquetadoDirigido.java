/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.grafos;

import controlador.grafos.exception.LabelEdgeException;
import controlador.grafos.exception.VerticeException;
import controlador.listas.DynamicList;
import controlador.listas.exception.EmptyException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author Usuario iTC
 * @param <E>
 */
public class GrafoEtiquetadoDirigido<E> extends GrafoDirigido {

        protected E[] labels;
        // ---> labels 1;
        // ---> labels 2;
        protected HashMap<E, Integer> dirVertices;
        private Class<E> clazz;

        public GrafoEtiquetadoDirigido(Integer num_vertices, Class clazz) {
                super(num_vertices);
                this.clazz = clazz;
                labels = (E[]) Array.newInstance(clazz, num_vertices + 1);
                dirVertices = new HashMap<>(num_vertices);
        }

        /*
    
         */
        public Integer getVerticeE(E label) throws Exception {
                Integer aux = dirVertices.get(label);
                if (aux != null) {
                        return dirVertices.get(label);
                } else {
                        throw new VerticeException("No se encuentra vertice");
                }
        }

        public E getLabelE(Integer v) throws Exception {
                if (v <= num_vertice()) {
                        return labels[v];
                } else {
                        throw new VerticeException("No se encuentra vertice");
                }
        }

        public Boolean isEdgeE(E o, E d) throws Exception {
                if (isAllLabelsGraph()) {
                        return existe_arista(getVerticeE(o), getVerticeE(d));
                } else {
                        throw new LabelEdgeException();
                }
        }

        public void insertEdgeE(E o, E d, Double weight) throws Exception {
                if (isAllLabelsGraph()) {
                        insertar_arista(getVerticeE(o), getVerticeE(d), weight);
                } else {
                        throw new LabelEdgeException();
                }
        }

        public DynamicList<Adycencia> adjacents(E label) throws Exception {
                if (isAllLabelsGraph()) {
                        return adycentes(getVerticeE(label));
                } else {
                        throw new LabelEdgeException();
                }
        }

        public void labelVertice(Integer v, E label) {
                labels[v] = label;
                dirVertices.put(label, v);
        }

        public Boolean isAllLabelsGraph() {
                Boolean band = true;
                for (int i = 1; i < labels.length; i++) {
                        if (labels[i] == null) {
                                band = false;
                                break;
                        }
                }
                return band;
        }

        public String bellmanFord(E source) throws Exception {
                int V = num_vertice();
                double[] dist = new double[V + 1];
                Arrays.fill(dist, Double.MAX_VALUE);
                dist[getVerticeE(source)] = 0;
                StringBuilder result = new StringBuilder();

                for (int i = 1; i < V; i++) {
                        for (int j = 1; j <= V; j++) {
                                DynamicList<Adycencia> adyacentes = adycentes(j);
                                for (int k = 0; k < adyacentes.getLength(); k++) {
                                        Adycencia ady = adyacentes.getInfo(k);
                                        int u = j;
                                        int v = ady.getDestino();
                                        double weight = ady.getPeso();
                                        if (dist[u] != Double.MAX_VALUE && dist[u] + weight < dist[v]) {
                                                dist[v] = dist[u] + weight;
                                        }
                                }
                        }
                }
                for (int i = 1; i <= V; i++) {
                        if (dist[i] == Double.MAX_VALUE) {
                                result.append("Distancia de ").append(source).append(" a ").append(getLabelE(i)).append(" es: No hay conexión\n");
                        } else {
                                result.append("Distancia de ").append(source).append(" a ").append(getLabelE(i)).append(" es ").append(dist[i]).append("\n");
                        }
                }
                return result.toString();
        }

        
        public String floydWarshall() throws EmptyException {
                int V = num_vertice();
                double[][] dist = new double[V + 1][V + 1];
                StringBuilder result = new StringBuilder();

                for (double[] row : dist) {
                        Arrays.fill(row, Double.MAX_VALUE);
                }
                for (int i = 1; i <= V; i++) {
                        dist[i][i] = 0;
                }
                for (int i = 1; i <= V; i++) {
                        DynamicList<Adycencia> adyacentes = adycentes(i);
                        for (int j = 0; j < adyacentes.getLength(); j++) {
                                Adycencia ady = adyacentes.getInfo(j);
                                dist[i][ady.getDestino()] = ady.getPeso();
                        }
                }

                for (int k = 1; k <= V; k++) {
                        for (int i = 1; i <= V; i++) {
                                for (int j = 1; j <= V; j++) {
                                        if (dist[i][k] + dist[k][j] < dist[i][j]) {
                                                dist[i][j] = dist[i][k] + dist[k][j];
                                        }
                                }
                        }
                }

                for (int i = 1; i <= V; i++) {
                        for (int j = 1; j <= V; j++) {
                                if (dist[i][j] == Double.MAX_VALUE) {
                                        result.append("INF ");
                                } else {
                                        result.append(dist[i][j]).append(" ");
                                }
                        }
                        result.append("\n");
                }
                return result.toString();
        }

        public String profunidad(E source) throws Exception {
                boolean visited[] = new boolean[num_vertice() + 1];
                StringBuilder result = new StringBuilder();
                dfsUtil(getVerticeE(source), visited, result);
                return result.toString();
        }

        private void dfsUtil(int v, boolean visited[], StringBuilder result) throws Exception {
                visited[v] = true;
                result.append(getLabelE(v)).append(" ");

                DynamicList<Adycencia> adyacentes = adycentes(v);
                for (int i = 0; i < adyacentes.getLength(); i++) {
                        int n = adyacentes.getInfo(i).getDestino();
                        if (!visited[n]) {
                                dfsUtil(n, visited, result);
                        }
                }
        }

        public String bfs(E source) throws Exception {
                boolean[] visited = new boolean[num_vertice() + 1];
                DynamicList<Integer> toVisit = new DynamicList<>();
                StringBuilder result = new StringBuilder();

                int sourceIndex = getVerticeE(source);
                toVisit.add(sourceIndex); 

                while (!toVisit.isEmty()) {
                        int v = toVisit.getInfo(0); 
                        toVisit.extract(0); 

                        if (!visited[v]) {
                                visited[v] = true;
                                result.append(getLabelE(v)).append(" ");

                                DynamicList<Adycencia> adyacentes = adycentes(v);
                                for (int i = 0; i < adyacentes.getLength(); i++) {
                                        int n = adyacentes.getInfo(i).getDestino();
                                        if (!visited[n]) {
                                                toVisit.add(n); 
                                        }
                                }
                        }
                }
                return result.toString();
        }

        @Override
        public String toString() {
                StringBuilder grafo = new StringBuilder("GRAFO").append("\n");
                try {
                        for (int i = 1; i <= num_vertice(); i++) {
                                grafo.append("[").append(i).append("] = ").append(getLabelE(i)).append("\n");
                                DynamicList<Adycencia> list = adycentes(i);
                                for (int j = 0; j < list.getLength(); j++) {
                                        Adycencia a = list.getInfo(j);
                                        grafo.append("ady [").append(a.getDestino()).append("]").append(getLabelE(a.getDestino())).append(" peso ").append(a.getPeso()).append("\n");
                                }
                        }
                } catch (Exception e) {
                        System.out.println("Error " + e);
                }
                return grafo.toString();
        }

        public static void main(String[] args) {
                try {
                        GrafoEtiquetadoDirigido<String> ged = new GrafoEtiquetadoDirigido(6, String.class);
                        ged.labelVertice(1, "Coso1");
                        ged.labelVertice(2, "Coso2");
                        ged.labelVertice(3, "Coso3");
                        ged.labelVertice(4, "Coso4");
                        ged.labelVertice(5, "Coso5");
                        ged.labelVertice(6, "Coso6");
                        ged.insertEdgeE("Coso1", "Coso2", 50.0);
                        ged.insertEdgeE("Coso2", "Coso3", 40.0);
                        ged.insertEdgeE("Coso3", "Coso4", 40.0);
                        ged.insertEdgeE("Coso1", "Coso4", 20.0);
                        ged.insertEdgeE("Coso4", "Coso5", 30.0);
                        ged.insertEdgeE("Coso5", "Coso6", 90.0);
                        System.out.println(ged.toString());
                        PaintGraph p = new PaintGraph();
                        p.updateFileLabel(ged);
                        System.out.println("ALSFLASLASs");
                        System.out.println(ged.bellmanFord("Coso2"));
                        System.out.println("=======================");
                        System.out.println(ged.bfs("Coso1"));
                        System.out.println(ged.profunidad("Coso1"));
                } catch (Exception e) {
                }
        }
}
