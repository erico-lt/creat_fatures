package model.services;

import java.util.List; 

public class StoreServices {
    
    public <T extends Comparable <? super T>> boolean clientExist(List<T> listClients, T client) {
        if (listClients.isEmpty()) {
            return false;
        }        
        for(T item: listClients) {
            if(item.compareTo(client) == 0) {
                return true;
            }
        }

        return false;
    }
}
