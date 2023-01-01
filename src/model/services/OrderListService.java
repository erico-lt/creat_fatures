package model.services;

import java.util.List;

public class OrderListService {
    
    public <T extends Comparable<? super T>> List<T> orderList(List<T> list) {
        if(list.isEmpty()) {
            throw new NullPointerException("Erro this is empty");
        }
        T first = list.get(0);
        for(T item : list) {            
            if(first.compareTo(item) > 0 ) {
                
            }                                  
        }

        return list;
    }
}
