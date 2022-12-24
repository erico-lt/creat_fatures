package model.services;

import java.time.LocalDate;

import model.entites.Contract;
import model.entites.Installment;

public class ContractService {
    
    private OlinePaymentService olinePaymentService;

    public ContractService(OlinePaymentService olinePaymentService) {        
        this.setOlinePaymentService(olinePaymentService);
    }

    public void processContract(Contract contract, int months) {
        LocalDate nextDueDate = contract.getDate();
        double valuePerMonth = contract.getTotalValue() / months;

        for(int cont = 1; cont <= months; cont ++) {
            nextDueDate = nextDueDate.plusDays(30);
            double valueWithTaxForMonth = this.getOlinePaymentService().interest(valuePerMonth, cont);
            double taxOfPayment = this.getOlinePaymentService().paymentFee(valuePerMonth + valueWithTaxForMonth);
            double totalvalue = valuePerMonth + taxOfPayment + valueWithTaxForMonth; 
            contract.addContract(new Installment(nextDueDate, totalvalue));
        }        
    }

    public OlinePaymentService getOlinePaymentService() {
        return olinePaymentService;
    }

    public void setOlinePaymentService(OlinePaymentService olinePaymentService) {
        this.olinePaymentService = olinePaymentService;
    }

}