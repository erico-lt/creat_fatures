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
        
        LocalDate date = LocalDate.parse("20/09/2022", stf);
        Contract contract = new Contract(8028, date, 600.00);
        ContractService service = new ContractService(new PaypalService());
        
        service.processContract(contract, 3);
        for(Installment x: contract.getListInstallment()) {
            System.out.println(x.toString());
        }

        input.close();
    }
}
