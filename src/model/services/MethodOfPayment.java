package model.services;

import java.time.LocalDate;

import model.entites.Contract;
import model.entites.Installment;
import model.interfaces.OlinePaymentService;

public class MethodOfPayment {
    
    private OlinePaymentService olinePaymentService;

    public MethodOfPayment(OlinePaymentService olinePaymentService) {        
        this.setOlinePaymentService(olinePaymentService);
    }

    public void processContract(Contract contract, int months) {        
        double valuePerMonth = contract.getTotalValue() / months;

        for(int cont = 1; cont <= months; cont ++) {
            LocalDate nextDueDate = contract.getDate().plusMonths(cont);
           
            double interest = this.getOlinePaymentService().interest(valuePerMonth, cont);
            double fee = this.getOlinePaymentService().paymentFee(valuePerMonth + interest);
            double totalvalue = valuePerMonth + fee + interest; 
           
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