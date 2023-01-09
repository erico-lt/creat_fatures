package model.entites.intens;

import model.entites.Item;
import model.enums.ItemTypes;

public class Tv extends Item{

    public Tv(String model, Double price, ItemTypes type) {
        super(model, price, type);       
    }    
    
    @Override
    public int compareTo(Item item) {        
        return this.getName().compareTo(item.getName());
    }
}
