package model.services;

import java.util.List;

import model.entites.Item;

public class ServicesPurchaseOrder { 

    public boolean codPorductExist(List<Item> itens, Item item) {     
        for(Item x: itens) {
            if(x.getCod_Product() == item.getCod_Product()) {
                return true;
            }
        }         
        return false;
    }

    public double valueOrder(Item item) {
        return item.getPrice() * item.getQuant();
    }
}
