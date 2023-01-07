package model.entites;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Installment {
    private LocalDate dueDate;
    private double amount;
    private Long cnpj;
    DateTimeFormatter stf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    public Installment(LocalDate dueDate, double amount, Long cnpj) {
        this.setDueDate(dueDate);
        this.setAmount(amount);
        this.setCnpj(cnpj);
    }
    
    public Installment(LocalDate dueDate, double amount) {
        this.setDueDate(dueDate);
        this.setAmount(amount);         
    } 

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Long getCnpj() {
        return cnpj;
    }

    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString(){
        return  this.getDueDate().format(stf) + " - " + String.format("%.2f",this.getAmount());
    }  
}