package model.entites;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PurchaseOrder {
    private LocalDate date;
    private double valueOrder;
    private int requestNumber;
    private int cod_Client;

    private List<Item> requestList = new ArrayList<>();
    private List<Installment> listInstallment = new ArrayList<>();

    public PurchaseOrder(LocalDate date, int requestNumber, int cod_Client) {
        this.setDate(date);
        this.setRequestNumber(requestNumber);
        this.setCod_Client(cod_Client);
    } 

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getValueOrder() {
        return valueOrder;
    }

    private void setValueOrder(double valueOrder) {
        this.valueOrder = valueOrder;
    }

    public int getRequestNumber() {
        return requestNumber;
    }

    public void setRequestNumber(int requestNumber) {
        this.requestNumber = requestNumber;
    }

    public int getCod_Client() {
        return cod_Client;
    }

    public void setCod_Client(int cod_Client) {
        this.cod_Client = cod_Client;
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