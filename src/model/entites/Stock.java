package model.entites;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Stock {
    private String name;    
    private List<Item> list = new ArrayList<>();   
    

    public Stock(String name) {
        this.setName(name);
    } 

    public void addItem(Item item, Integer cod_Product, Integer quant_Stock) {        
        item.setCod_Product(cod_Product);
        item.setQuant(quant_Stock);
        list.add(item);   
        Collections.sort(list);
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
  
}