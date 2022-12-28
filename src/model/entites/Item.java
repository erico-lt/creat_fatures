package model.entites;

import model.enums.ItemTypes;

public abstract class Item {
    private String name;
    private String model;
    private double price;
    private ItemTypes type;

    public Item(){        
    }

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

}
