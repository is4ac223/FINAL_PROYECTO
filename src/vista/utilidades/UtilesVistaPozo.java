/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.utilidades;

import controlador.PozoDao;
import controlador.grafos.GrafoEtiquetadoDirigido;
import controlador.listas.DynamicList;
import controlador.listas.exception.EmptyException;
import controlador.util.Utiles;
import java.io.FileWriter;
import javax.swing.JComboBox;
import modelo.Pozo;

/**
 *
 * @author Usuario iTC
 */
public class UtilesVistaPozo {

        public static void crearMapaEscuela(GrafoEtiquetadoDirigido<Pozo> ge) throws Exception {
                String maps = "var osmUrl = 'https://tile.openstreetmap.org/{z}/{x}/{y}.png',\n"
                        + "        osmAttrib = '&copy; <a href=\"https://www.openstreetmap.org/copyright\">OpenStreetMap</a> contributors',\n"
                        + "        osm = L.tileLayer(osmUrl, {maxZoom: 15, attribution: osmAttrib});\n"
                        + "\n"
                        + "var map = L.map('map').setView([-4.036, -79.201], 15);\n"
                        + "\n"
                        + "L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {\n"
                        + "    attribution: '&copy; <a href=\"https://www.openstreetmap.org/copyright\">OpenStreetMap</a> contributors'\n"
                        + "}).addTo(map);";
                for (int i = 1; i <= ge.num_vertice(); i++) {
                        Pozo ec = ge.getLabelE(i);
                        maps += "L.marker([" + ec.getCoordenada().getLatitud() + ", " + ec.getCoordenada().getLongitud() + "]).addTo(map)" + "\n";
                        maps += ".bindPopup('" + ec.getNombre() + ".')" + "\n";
                        maps += " " + "\n";
                }
                FileWriter file = new FileWriter("src/mapas/mapa.js");
                file.write(maps);
                file.close();
        }
        
        public static void cargarComboEscuela(JComboBox cbx) throws EmptyException {
                cbx.removeAllItems();
                DynamicList<Pozo> list = new PozoDao().getListPozos();
                for (Integer i = 0; i < list.getLength(); i++) {
                        cbx.addItem(list.getInfo(i));
                }
        }
        
        public static Double calcularDistanciaEscuelas(Pozo o, Pozo d){
                Double dist = Utiles.coordGpsToKm(o.getCoordenada().getLatitud(),
                        o.getCoordenada().getLongitud(),
                        d.getCoordenada().getLatitud(),
                        d.getCoordenada().getLongitud());
                return dist;
        }
}
