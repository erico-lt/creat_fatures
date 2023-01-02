package model.entites;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.services.ServicesPurchaseOrder;

public class PurchaseOrder extends ServicesPurchaseOrder {  
    private List<Item> requestList = new ArrayList<>();
    private List<Installment> listInstallment = new ArrayList<>();

    public PurchaseOrder(LocalDate date, int requestNumber, int cod_Client) {
        super(date, requestNumber, cod_Client);
    } 

    public void addItem(Item item) {
        if (!codPorductExist(this.getRequestList(), item)) {
            this.getRequestList().add(item);
        }
    }

    public List<Item> getRequestList() {
        return requestList;
    }

    public List<Installment> getListInstallment() {
        return listInstallment;
    }

    public void setListInstallment(Installment Installment) {
        this.listInstallment.add(Installment);
    }

}