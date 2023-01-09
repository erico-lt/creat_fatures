package model.entites.intens;

import java.util.Scanner;

import model.entites.Store;
import model.exception.StoreException;

public class UI {
    
    public static void storeOptions(Store store, Scanner input) {
        System.out.println(store.toString());
        System.out.println();
        System.out.println("#OPTIONS#");
        System.out.println("[1] For add new Item");
        System.out.println("[2] For remove Item");
        int opcao = input.nextInt();
        input.nextLine();
        itensForAddOrRemove(opcao, store, input);        
    }

    public static void itensForAddOrRemove(int opcao, Store store, Scanner input) {        
        if(opcao < 1 || opcao >= 3){
            throw new StoreException("[ERRO] is invalid the option select");
        }else {
            switch(opcao) {
                case 1:
                    System.out.println("Select the Item for be added");
                    System.out.println("________________________________");
                    System.out.print("[Ball]-[Bike]-[Pen]-[Skate]-[Tv]: ");
                    String itemType = input.next();
                    input.nextLine();
                    System.out.print("What model of item " + itemType + ":");
                    String model = input.nextLine();
                    System.out.print("What price of item " + itemType + ":");
                    Double price = input.nextDouble();
                    System.out.print("What code of Item " + itemType + ":");  
                    Integer codProduct = input.nextInt();
                    input.nextLine();
                    System.out.print("What quantity of item " + itemType + ":");
                    Integer quantity = input.nextInt();  
                    store.addItemInStock(itemType, model, price, codProduct, quantity);              
                case 2:    
            }
        }        
    }
}
