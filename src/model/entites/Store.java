package model.entites;

import java.time.LocalDate;
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
        if (storeServices.clientExist(this.getClients(), client)) {
            throw new StoreException("Erro cliente já esxiste tente outro");
        } else {
            this.getClients().add(client);
        }
    }

    public Clients clientExist(String name, Integer cod_Client) {
        Clients client = this.storeServices.clientExist(name.toUpperCase(), cod_Client, this);
        if (client != null) {
            return client;
        } else {
            throw new StoreException("[ERRO] cliente not exsist.");
        }
    }

    public void items() {
        this.storeServices.addItensInStock(this);
    }

    public void itemsForSale() {
        this.storeServices.itemsForSale(this);
    }

    public void addItemInStock(ItemTypes type, String model, Double price, Integer codProduct, Integer quantity) {
        Item item = this.storeServices.verificItemOfAdd(type, model, price);
        stock.addItem(item, codProduct, quantity);
    }

    public void checkHaveOrder(String nameItem, int quant, Clients client) {
        if (!nameItem.equals("BALL") && !nameItem.equals("BIKE") && !nameItem.equals("PEN") && !nameItem.equals("SKATE") && !nameItem.equals("TV")) {
            throw new StoreException("[ERRO] check name of item");
        }
        Item itemForPurchaseOrder = this.getStock().checkItemForSale(nameItem, quant);
        if (itemForPurchaseOrder != null) {
            storeServices.checkHaveOrderClient(this, client, itemForPurchaseOrder);            
        }
    }

    public void viewItenOfClient(Clients client) {
        if(!this.storeServices.clientExist(this.getClients(), client)) {
            throw new StoreException("[ERRO] client not exist");
        }          
        this.storeServices.viewItensOfClient(client.getCodCliente(), this);
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
