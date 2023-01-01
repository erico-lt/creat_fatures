package model.entites;

import model.enums.ItemTypes;

public abstract class Item implements Comparable<Item>{
    private String name;
    private String model;
    private double price;
    private int quant;
    private int cod_Product;
    private ItemTypes type;
  
    public Item(String name, String model, double price, ItemTypes type) {        
        this.setName(name);
        this.setModel(model);
        this.setPrice(price);
        this.setType(type);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    
    }    
    public void setPrice(double price) {
        this.price = price;
    }

    public ItemTypes getType() {
        return type;
    }

    public void setType(ItemTypes type) {
        this.type = type;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public int getCod_Product() {
        return cod_Product;
    }

    public void setCod_Product(int cod_Product) {
        this.cod_Product = cod_Product;
    }

}
