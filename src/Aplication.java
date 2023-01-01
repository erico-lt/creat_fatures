import model.entites.Item;
import model.entites.intens.Bike;
import model.enums.ItemTypes;
import model.services.Stock;

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
        
        Stock stock = new Stock("Stock #1");
        
        Item bike = new Bike("Bike", "Rover", 500.00, ItemTypes.BIKE);
        Item tv = new Bike("Tv plasma", "Samsung", 700.00, ItemTypes.TV);
        Item skate = new Bike("Ball", "cup wolrd", 100.00, ItemTypes.BALL);
        stock.addItem(bike, 554, 25);
        stock.addItem(tv, 553, 25);
        stock.addItem(skate, 552, 25);

        for(Item item: stock.getList()) {
            System.out.println(item.toString());
            System.out.println();
        }
        
        
        /*Locale.setDefault(Locale.US);
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
