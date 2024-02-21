package controlador.dao;

import controlador.listas.DynamicList;

public interface DaoInterface<T> {
        public Boolean persist(T dato);
        public Boolean merge(T dato, Integer index);
        public DynamicList<T> all();
        public T get(Integer id);
}
