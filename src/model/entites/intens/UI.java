package model.entites.intens;

import java.util.Scanner;

import model.entites.Clients;
import model.entites.Store;
import model.entites.client.PessoaFisica;
import model.entites.client.PessoaJuridica;
import model.exception.StoreException;
import model.services.MethodOfPayment;

public class UI {

    public static void initialLogin(Store store, Scanner input) {
        System.out.println(store.toString());
        System.out.println("[1] login");
        System.out.println("[2] for register");
        int option = input.nextInt();
        input.nextLine();
        if (option == 1) {
            System.out.print("Type your name: ");
            String nameClient = input.nextLine();
            System.out.print("Type client code: ");
            Integer cod_Client = input.nextInt();
            Clients client = store.clientExist(nameClient, cod_Client);
            firstPage(store, input, client);
        } else {
            System.out.println("[1] for person fisic");
            System.out.println("[2] for person juridic");
            int optionPerson = input.nextInt();
            input.nextLine();
            System.out.print("Type your name: ");
            String name = input.nextLine();
            System.out.print("Telephone: ");
            String telephone = input.nextLine();
            System.out.print("Email: ");
            String email = input.nextLine();
            System.out.print("Address -> (street,district,city,state): ");
            String[] address = input.nextLine().split(",");
            System.out.print("Cod client: ");
            Integer cod_Client = input.nextInt();
            if (optionPerson == 1) {
                System.out.print("CPF: ");
                Long cpf = input.nextLong();
                System.out.print("RG: ");
                Long rg = input.nextLong();
                store.addClients(new PessoaFisica(name, telephone, email, address, cpf, rg, cod_Client));
            } else {
                System.out.print("CNPJ: ");
                Long cnpj = input.nextLong();
                System.out.print("State Inscription: ");
                Long stateInsc = input.nextLong();
                store.addClients(new PessoaJuridica(name, telephone, email, address, cnpj, stateInsc, cod_Client));
            }
        }
    }

    public static void firstPage(Store store, Scanner input, Clients cliente) {
        System.out.println(store.toString());
        System.out.println();
        System.out.println("MENU");
        System.out.println("[1] Purchase");
        System.out.println("[2] View Order");
        System.out.println("[3] for process of payment");
        int opcao = input.nextInt();
        input.nextLine();
        purchaseOrOrder(opcao, store, input, cliente);
    }

    public static void purchaseOrOrder(int opcao, Store store, Scanner input, Clients client) {
        if (opcao < 1 || opcao > 3) {
            throw new StoreException("[ERRO] is invalid the option select");
        } else {
            switch (opcao) {
                case 1:
                    System.out.println("Items for sale");
                    System.out.println("_____________________");
                    char resp;
                    do {
                        store.itemsForSale();
                        System.out.println();
                        System.out.println("Select the name and quantity");
                        System.out.print("Name item: ");
                        String nameItemforSale = input.nextLine().toUpperCase();
                        System.out.print("quantity:");
                        int quantity = input.nextInt();

                        store.checkHaveOrder(nameItemforSale, quantity, client);

                        System.out.print("Do you want to place more orders? [S/N] ");
                        resp = input.next().charAt(0);
                        input.nextLine();
                        System.out.println();
                    } while (resp != 'n' && resp != 'N');
                    break;
                case 2:
                    System.out.println("Itens in you order");
                    store.viewItenOfClient(client);
                    break;
                case 3:
                    MethodOfPayment paymentService = new MethodOfPayment(store.getOlinePaymentService()); 
                    System.out.println("PROCESS PAYMENT");
                    System.out.println("_____________________");
                    System.out.print("How many months do you want to pay? ");
                    int months = input.nextInt();
                    System.out.print("Pills type you CPF or CNPJ: ");
                    Long cpforCnpj = input.nextLong();
                    System.out.print("Your inscrission state case juric person: ");
                    Long insState = input.nextLong();
                    if(client instanceof PessoaFisica) {                                                    
                        paymentService.processContract(store.CheckOrderForPayment(client.getCodCliente()), months, cpforCnpj);
                    } else {
                        paymentService.processContract(store.CheckOrderForPayment(client.getCodCliente()), months, cpforCnpj, insState);
                    }
                    store.installmentOfClients(client.getCodCliente());
                    break;
            }
        }
    }

    // codigo para reuso para administrador da loja
    /*
     * public static void storeOptions(Store store, Scanner input) {
     * System.out.println(store.toString());
     * System.out.println();
     * System.out.println("#OPTIONS#");
     * System.out.println("[1] For add new Item");
     * System.out.println("[2] For remove Item");
     * int opcao = input.nextInt();
     * input.nextLine();
     * itensForAddOrRemove(opcao, store, input);
     * }
     * 
     * public static void itensForAddOrRemove(int opcao, Store store, Scanner input)
     * {
     * if(opcao < 1 || opcao >= 3){
     * throw new StoreException("[ERRO] is invalid the option select");
     * }else {
     * switch(opcao) {
     * case 1:
     * System.out.println("Select the Item for be added");
     * System.out.println("________________________________");
     * System.out.print("[Ball]-[Bike]-[Pen]-[Skate]-[Tv]: ");
     * String itemType = input.next().toUpperCase();
     * input.nextLine();
     * System.out.print("What model of item " + itemType + ":");
     * String model = input.nextLine();
     * System.out.print("What price of item " + itemType + ":");
     * Double price = input.nextDouble();
     * System.out.print("What code of Item " + itemType + ":");
     * Integer codProduct = input.nextInt();
     * input.nextLine();
     * System.out.print("What quantity of item " + itemType + ":");
     * Integer quantity = input.nextInt();
     * store.addItemInStock(ItemTypes.valueOf(itemType), model, price, codProduct,
     * quantity);
     * case 2:
     * }
     * }
     * }
     */
}
