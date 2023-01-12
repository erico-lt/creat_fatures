package model.services;

import java.util.List;

import model.entites.Item;
import model.entites.intens.Ball;
import model.enums.ItemTypes; 

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

    public Item verificItem(ItemTypes type, String model, Double price){        
        if(type.equals(ItemTypes.BALL)) {
            return new Ball(model, price, ItemTypes.BALL);
        }
        return null;
    }
}
