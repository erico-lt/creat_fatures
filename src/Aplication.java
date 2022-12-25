import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entites.Contract;
import model.entites.Installment;
import model.services.ContractService;
import model.services.PaypalService;

public class Aplication {
    public static void main(String[] args){
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
        ContractService service = new ContractService(new PaypalService());
        
        service.processContract(contract, installmentQuantity);
        
        for(Installment x: contract.getListInstallment()) {
            System.out.println(x.toString());
        }
        input.close();
    }
}
