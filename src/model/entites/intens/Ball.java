package model.entites.intens;

import model.entites.Item;
import model.enums.ItemTypes;

public class Ball extends Item{

    public Ball(String name, String model, double price, ItemTypes type) {
        super(name, model, price, type);       
    }

    @Override
    public int compareTo(Item pessoa) {        
        return this.getName().compareTo(pessoa.getName());
    }
    
}
