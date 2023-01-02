package model.entites.intens;

import model.entites.Item;
import model.enums.ItemTypes;

public class Bike extends Item{

    public Bike(String name, String model, double price, ItemTypes type) {
        super(name, model, price, type);           
    }

    @Override
    public int compareTo(Item item) {        
        return this.getName().compareTo(item.getName());
    }
    
}
