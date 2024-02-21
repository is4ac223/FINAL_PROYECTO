/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.dao.DaoImplement;
import controlador.grafos.GrafoEtiquetadoDirigido;
import controlador.listas.DynamicList;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import modelo.Pozo;

/**
 *
 * @author Usuario iTC
 */
public class PozoDao extends DaoImplement<Pozo>{
        
        private GrafoEtiquetadoDirigido<Pozo> grafo;
        private DynamicList<Pozo> listPozos = new DynamicList<>();
        private Pozo pozo = new Pozo();

        public PozoDao() {
                super(Pozo.class);
        }

        public GrafoEtiquetadoDirigido<Pozo> getGrafo() throws Exception{
                if (grafo == null) {
                        DynamicList<Pozo> list = getListPozos();
                        if (!list.isEmty()) {
                                grafo = new GrafoEtiquetadoDirigido<>(getListPozos().getLength(), Pozo.class);
                                for (int i = 0; i < list.getLength(); i++) {
                                        grafo.labelVertice(i + 1, getListPozos().getInfo(i));
                                }
                        }
                }
                return grafo;
        }

        public void setGrafo(GrafoEtiquetadoDirigido<Pozo> grafo) {
                this.grafo = grafo;
        }

        public DynamicList<Pozo> getListPozos() {
                if (listPozos.isEmty()) {
                        listPozos = all();
                }
                return listPozos;
        }

        public void setListPozos(DynamicList<Pozo> listPozos) {
                this.listPozos = listPozos;
        }

        public Pozo getPozo() {
                if (pozo == null) {
                        pozo = new Pozo();
                }
                return pozo;
        }

        public void setPozo(Pozo pozo) {
                this.pozo = pozo;
        }
        
        public Boolean persist() {
                pozo.setId(all().getLength() + 1);
                return persist(pozo);
        }

        public void guardarGrafo() throws Exception {
                getConection().toXML(grafo, new FileWriter("files/grafo.json"));
        }

        public void loadGraph() throws FileNotFoundException, Exception {
                grafo = (GrafoEtiquetadoDirigido<Pozo>) getConection().fromXML(new FileReader("files/grafo.json"));
                //listPozos.reset();
                for (int i = 0; i <= grafo.num_vertice(); i++) {
                        listPozos.add((Pozo) grafo.getLabelE(i));
                }
        }
}
