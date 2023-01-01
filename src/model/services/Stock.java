package model.services;

import java.util.ArrayList;
import java.util.List;

import model.entites.Item;

public class Stock {
    private String name;    
    private List<Item> list = new ArrayList<>();
   
    private OrderListService orderList;    

    public Stock(String name) {
        this.setName(name);
    } 

    public void addItem(Item item, int cod_Product, int quant_Stock) {        
        item.setCod_Product(cod_Product);
        item.setQuant(quant_Stock);
        list.add(item);          
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }    

    public List<Item> getList() {
        return list;
    } 
    
    public void setList(List<Item> list) {
        this.list = list;
    }

    public OrderListService getOrderList() {
        return orderList;
    }
}