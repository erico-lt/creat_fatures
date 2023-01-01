package model.services;

import java.util.ArrayList;
import java.util.List;

import model.entites.Item;

public class Stock {
    private String name;
    private int cod_Product;
    private int quant_in_Stock;    

    private List<Item> list = new ArrayList<>();

    public Stock(String name) {
        this.setName(name);
    } 

    public void addItem(Item item, int cod_Product, int quant_Stock) {        
        this.setCod_Product(cod_Product);
        this.setQuant_in_Stock(quant_Stock);
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

    public int getCod_Product() {
        return cod_Product;
    }

    public void setCod_Product(int cod_Product) {
        this.cod_Product = cod_Product;
    }

    public int getQuant_in_Stock() {
        return quant_in_Stock;
    }

    public void setQuant_in_Stock(int quant_in_Stock) {
        this.quant_in_Stock = quant_in_Stock;
    }     
    

}