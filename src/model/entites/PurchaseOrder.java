package model.entites;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.exception.PurchaseException;
import model.services.ServicesPurchaseOrder;

public class PurchaseOrder {
    private LocalDate date;
    private double valueOrder;
    private Integer requestNumber;
    private Integer cod_Client;

    private List<Item> requestList = new ArrayList<>();
    private List<Installment> listInstallment = new ArrayList<>();
    private ServicesPurchaseOrder servicesPurchaseOrder = new ServicesPurchaseOrder();

    public PurchaseOrder(LocalDate date, Integer requestNumber, Integer cod_Client) {
        this.setDate(date);
        this.setRequestNumber(requestNumber);
        this.setCod_Client(cod_Client);
    }

    public void addItemForSale(Item item) {
        if (servicesPurchaseOrder.codPorductExist(this.getRequestList(), item)) {
            this.getRequestList().add(item);
        } else {
            throw new PurchaseException("ERRO: produto já existente");
        }
        this.setValueOrder(this.getValueOrder() + servicesPurchaseOrder.valueOrder(item));
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

    public Integer getRequestNumber() {
        return requestNumber;
    }

    public void setRequestNumber(Integer requestNumber) {
        this.requestNumber = requestNumber;
    }

    public Integer getCod_Client() {
        return cod_Client;
    }

    public void setCod_Client(Integer cod_Client) {
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