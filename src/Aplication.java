import model.entites.Clients;
import model.entites.Store;
import model.entites.client.PessoaFisica;
import model.services.PaypalService;

/*import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entites.Contract;
import model.entites.Installment;
import model.services.MethodOfPayment;
import model.services.PaypalService;*/

public class Aplication {
    public static void main(String[] args){
        
        //Codigo para teste
        Clients cliente = new PessoaFisica(676); 
        Clients cliente2 = new PessoaFisica(20);
        Clients cliente3= new PessoaFisica(67);
        Store store = new Store("Mercearia", new PaypalService());
        store.addClients(cliente);
        store.addClients(cliente2);
        store.addClients(cliente3);
        for(Clients x: store.getClients()) {
            System.out.println(x.toString());
        }
        
        
        /*Stock stock = new Stock("Stock #1");              
        
        Item tv = new Bike("Tv plasma", "Samsung", 700.00, ItemTypes.TV);
        Item skate = new Bike("Skate", "advanced", 100.00, ItemTypes.SKATE);
        
        stock.addItem(tv, 553, 2);
        stock.addItem(skate, 552, 0);

        PurchaseOrder order = new PurchaseOrder(null, 22, 22);
        order.addItem(skate);
        order.addItem(tv);         

        for(Item item: stock.getList()) {
            System.out.println(item.toString());
            System.out.println();
        }
       
        System.out.println(order.getValueOrder());
        
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);
        DateTimeFormatter stf = DateTimeFormatter.ofPattern("dd/MM/yyyy");        
        
        System.out.println("Entre com os dados do contrato");
        System.out.print("Numero: ");
        int contractNumber = input.nextInt();
        input.nextLine();
        System.out.print("Data (dd/MM/yyyy): ");
        LocalDate date = LocalDate.parse(input.nextLine(), stf);
        System.out.print("Valor do contrato: ");
        double valueContract = input.nextDouble();
        System.out.print("Entre com a quantidade de parcelas: ");
        int installmentQuantity = input.nextInt();
        Contract contract = new Contract(contractNumber, date, valueContract);
        MethodOfPayment service = new MethodOfPayment(new PaypalService());
        
        service.processContract(contract, installmentQuantity);
        
        for(Installment x: contract.getListInstallment()) {
            System.out.println(x.toString());
        }
        input.close();*/
    }
}
