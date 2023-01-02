package model.services;

import java.time.LocalDate;
import java.util.List;

import model.entites.Item;

public class ServicesPurchaseOrder {
    private LocalDate date;
    private double valueOrder;
    private int requestNumber;
    private int cod_Client;

    public ServicesPurchaseOrder(LocalDate date, int requestNumber, int cod_Client) {
        this.setDate(date);
        this.setRequestNumber(requestNumber);
        this.setCod_Client(cod_Client);
    } 

    public boolean codPorductExist(List<Item> itens, Item item) {     
        if(itens.isEmpty()) {
            throw new NullPointerException("ERRO: this list is empty");
        }   
        for(Item x: itens) {
            if(x.getCod_Product() == item.getCod_Product()) {
                return true;
            }
        }         
        return false;
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
}
