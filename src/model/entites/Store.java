package model.entites;

import java.util.ArrayList;
import java.util.List;

import model.enums.ItemTypes;
import model.exception.StoreException;
import model.services.StoreServices;

public class Store {
    private String name;
    
    private List<Clients> clients = new ArrayList<Clients>();
    private Stock stock = new Stock("Stock #1");
    private List<PurchaseOrder> PurchaseOrder = new ArrayList<PurchaseOrder>();
    private StoreServices storeServices = new StoreServices();
    
    public Store(String name) {
        this.setName(name);         
    }

    public void addClients(Clients client) {
        if(storeServices.clientExist(this.getClients(), client)) {
            throw new StoreException("Erro cliente já esxiste tente outro");
        }else {
            this.getClients().add(client);
        }
    }

    public void addItemInStock(ItemTypes type, String model, Double price, Integer codProduct, Integer quantity) {
        Item item = this.storeServices.verificItem(type, model, price);
        stock.addItem(item, codProduct, quantity);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }  

    public List<Clients> getClients() {
        return clients;
    }  

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public List<PurchaseOrder> getPurchaseOrder() {
        return PurchaseOrder;
    }  

    @Override 
    public String toString() {
        return this.getName();
    }
}
