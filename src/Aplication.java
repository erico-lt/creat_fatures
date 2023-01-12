import java.util.Scanner;

import model.entites.Item;
import model.entites.Store;
import model.entites.intens.UI;
import model.services.MethodOfPayment;
import model.services.PaypalService;

public class Aplication {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        MethodOfPayment servicePayment = new MethodOfPayment(new PaypalService());
        Store store = new Store("Sport e Lazer");         
        while(true) {
            try {
                UI.storeOptions(store, input);
                for(Item x: store.getStock().getList()) {
                    System.out.println(x.toString());
                }
            }
            catch(RuntimeException e) {
                System.out.println(e.getMessage());
                input.nextLine();
            }
        }
        
    }
}
