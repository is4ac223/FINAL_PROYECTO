package controlador.dao;

import com.thoughtworks.xstream.XStream;
import controlador.listas.DynamicList;
import java.io.FileReader;
import java.io.FileWriter;

public class DaoImplement<T> implements DaoInterface<T>{
        private Class<T> clazz;
        private XStream conection;
        private String URL;

        public DaoImplement(Class<T> clazz) {
                this.clazz = clazz;
                conection = Bridge.getConection();
                URL = Bridge.URL+clazz.getSimpleName()+".json";
        }

        @Override
        public Boolean persist(T dato) {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                DynamicList<T> ld = all();
                ld.add(dato);
                try {
                        conection.toXML(ld, new FileWriter(URL));
                        return true;
                } catch (Exception e) {
                        return false;
                }
        }

        @Override
        public Boolean merge(T dato, Integer index) {
                try {
                        DynamicList<T> list = all();
                        list.merge(dato, index);
                        conection.toXML(list, new FileWriter(URL));
                        return true;
                } catch (Exception e) {
            return false;
                }
        }

        @Override
        public DynamicList<T> all() {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                DynamicList<T> dl = new DynamicList();
                try {
                        dl = (DynamicList)conection.fromXML(new FileReader(URL));
                } catch (Exception e) {
                }
                return dl;
        }

        @Override
        public T get(Integer id) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }      

        public XStream getConection() {
                return conection;
        }

        
}
