package model.services;

import java.time.LocalDate;
import java.util.List;

import model.entites.Clients;
import model.entites.Installment;
import model.entites.Item;
import model.entites.PurchaseOrder;
import model.entites.Store;
import model.entites.intens.Ball;
import model.entites.intens.Bike;
import model.entites.intens.Pen;
import model.entites.intens.Skate;
import model.entites.intens.Tv;
import model.enums.ItemTypes;
import model.exception.StoreException;

public class StoreServices {

    public <T extends Comparable<? super T>> boolean clientExist(List<T> listClients, T client) {
        if (listClients.isEmpty()) {
            return false;
        }
        for (T item : listClients) {
            if (item.compareTo(client) == 0) {
                return true;
            }
        }

        return false;
    }

    public Clients clientExist(String name, Integer cod_Client, Store store) {
        for (Clients client : store.getClients()) {
            if (client.getCodCliente().compareTo(cod_Client) == 0 && client.getName().toUpperCase().equals(name)) {
                return client;
            }
        }
        return null;
    }

    public void itemsForSale(Store store) {
        for (Item item : store.getStock().getList()) {
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

    public Item verificItemOfAdd(ItemTypes type, String model, Double price) {
        if (type.equals(ItemTypes.BALL)) {
            return new Ball(model, price, ItemTypes.BALL);
        } else if (type.equals(ItemTypes.BIKE)) {
            return new Bike(model, price, ItemTypes.BIKE);
        } else if (type.equals(ItemTypes.PEN)) {
            return new Pen(model, price, ItemTypes.PEN);
        } else if (type.equals(ItemTypes.SKATE)) {
            return new Skate(model, price, ItemTypes.SKATE);
        } else if (type.equals(ItemTypes.TV)) {
            return new Tv(model, price, ItemTypes.TV);
        }
        return null;
    }

    public void checkHaveOrderClient(Store store, Clients client, Item item) {        
        if (store.getPurchaseOrder().isEmpty()) {
            store.getPurchaseOrder().add(new PurchaseOrder(LocalDate.now(), 0, client.getCodCliente()));
            store.getPurchaseOrder().get(0).addItemForSale(item);
        } else if (this.purchaseOrOrderExist(client.getCodCliente(), store)) {
            for (PurchaseOrder x : store.getPurchaseOrder()) {
                if (x.getCod_Client() == client.getCodCliente()) {
                    x.addItemForSale(item);
                }
            }
        } else {
            store.getPurchaseOrder().add(
                new PurchaseOrder(LocalDate.now(), store.getPurchaseOrder().size() + 1, client.getCodCliente()));
            this.checkHaveOrderClient(store, client, item);
        }
    }

    public PurchaseOrder ReturnOrderForPayment(Integer cod_Client, Store store) {
        if (!this.purchaseOrOrderExist(cod_Client, store)) {
            throw new StoreException("[ERRO] order not exist");
        }

        for (PurchaseOrder x : store.getPurchaseOrder()) {
            if (x.getCod_Client() == cod_Client) {
                return x;
            }
        }

        return null;
    }

    public boolean purchaseOrOrderExist(Integer cod_Client, Store store) {
        for (PurchaseOrder x : store.getPurchaseOrder()) {
            if (x.getCod_Client().equals(cod_Client)) {
                return true;
            }
        }
        return false;
    }

    public void viewItensOfClient(Integer cod_Cliente, Store store) {
        if (!this.purchaseOrOrderExist(cod_Cliente, store)) {
            throw new StoreException("[ERRO] order not find, verific your dices");
        }
        for (PurchaseOrder x : store.getPurchaseOrder()) {
            if (x.getCod_Client().equals(cod_Cliente)) {
                System.out.println("Cod Client: " + x.getCod_Client());
                System.out.println("Value order: " + x.getValueOrder());
                for (Item item : x.getRequestList()) {
                    System.out.println(item.toString());
                    System.out.println();
                }
            }
        }
    }

    public void viewFaturesOfClient(Integer cod_Cliente, Store store) {
        if (!this.purchaseOrOrderExist(cod_Cliente, store)) {
            throw new StoreException("[ERRO] order not find, verific your dices");
        }
        for (PurchaseOrder x : store.getPurchaseOrder()) {
            if (x.getCod_Client().equals(cod_Cliente)) {
                System.out.println("Cod Client: " + x.getCod_Client());
                System.out.println("FATURES: " + x.getValueOrder());
                for (Installment installment : x.getListInstallment()) {
                    System.out.println(installment.toString());
                    System.out.println();
                }
            }
        }
    }
}
