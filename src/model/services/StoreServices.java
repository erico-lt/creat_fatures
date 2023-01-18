package model.services;

import java.util.List;

import model.entites.Clients;
import model.entites.Item;
import model.entites.PurchaseOrder;
import model.entites.Store;
import model.entites.intens.Ball;
import model.entites.intens.Bike;
import model.entites.intens.Pen;
import model.entites.intens.Skate;
import model.entites.intens.Tv;
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

    public Clients clientExist(String name, Integer cod_Client, Store store) {
        for(Clients client: store.getClients()) {
            if(client.getCodCliente().compareTo(cod_Client) == 0 && client.getName().toUpperCase().equals(name)) {
                return client;
            }
        }
        return null;
    }

    public void itemsForSale(Store store) {
        for(Item item: store.getStock().getList()) {
            System.out.println(item.toString());            
        }
    }

    public void addItensInStock(Store store) {
        store.addItemInStock(ItemTypes.BALL, "Cup", 20.50, 01, 50);
        store.addItemInStock(ItemTypes.BIKE, "Monark", 3000.00, 02, 200);
        store.addItemInStock(ItemTypes.PEN, "Faber Castel", 1.50, 03, 3200);
        store.addItemInStock(ItemTypes.SKATE, "Ace Trucks", 400.00, 04, 500);
        store.addItemInStock(ItemTypes.TV, "Samsung", 2500.00, 05, 500);                
    }

    public Item verificItemOfAdd(ItemTypes type, String model, Double price){        
        if(type.equals(ItemTypes.BALL)) {
            return new Ball(model, price, ItemTypes.BALL);
        }else if(type.equals(ItemTypes.BIKE)) {
            return new Bike(model, price, ItemTypes.BIKE);
        }else if(type.equals(ItemTypes.PEN)) {
            return new Pen(model, price, ItemTypes.PEN);
        }else if(type.equals(ItemTypes.SKATE)) {
            return new Skate(model, price, ItemTypes.SKATE);
        }else if(type.equals(ItemTypes.TV)) {
            return new Tv(model, price, ItemTypes.TV);
        }
        return null;
    }        

    public Integer checkRequestNumber(Store store, Clients client) {
        int requestNumber = 0;
        for(PurchaseOrder x: store.getPurchaseOrder()) {
            if(x.getCod_Client() == client.getCodCliente()) {
                requestNumber =  x.getCod_Client() + 1;
            } 
            if(requestNumber != 0) {
                return requestNumber;
            }
        }
        return 1;
    }
}
