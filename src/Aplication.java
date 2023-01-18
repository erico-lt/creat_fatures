import java.util.Locale;
import java.util.Scanner;

import model.entites.Clients;
import model.entites.Store;
import model.entites.client.PessoaFisica;
import model.entites.intens.UI;
import model.services.MethodOfPayment;
import model.services.PaypalService;

public class Aplication {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);
        MethodOfPayment servicePayment = new MethodOfPayment(new PaypalService());
        Store store = new Store("Sport e Lazer");  
        store.items();   
        Clients cliente = new PessoaFisica(423, "Erico");
        store.addClients(cliente); 
        while(true) {
            try {
                UI.initialLogin(store, input);
            }
            catch(RuntimeException e) {
                System.out.println(e.getMessage());
                input.nextLine();
            }
        }
        
    }
}
