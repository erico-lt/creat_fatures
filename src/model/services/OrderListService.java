package model.services;

import java.util.List;

public class OrderListService {
    
    public <T extends Comparable<? super T>> List<T> orderList(List<T> list) {
        if(list.isEmpty()) {
            throw new NullPointerException("Erro this is empty");
        }
        T first = list.get(0);
        for(T item : list) {
            for(int cont = 0; cont < list.size() - 1; cont ++) {
                if(first.compareTo(item) > 0 ) {
                    T aux = item;
                    list.add(cont, first);
                    first = aux;
                }
            }                      
        }

        return list;
    }
}
