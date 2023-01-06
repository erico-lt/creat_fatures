package model.entites.client;

public class Clients {
    private String name;
    private String telephone;
    private String email;
    private String[] address = new String[4];    

    public Clients(String name, String telephone, String email, String[] address) {
        this.setName(name);
        this.setTelephone(telephone);
        this.setEmail(email);
        this.setAddress(address);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String[] getAddress() {
        return address;
    }

    public void setAddress(String[] address) {
        for(int cont = 0; cont < this.getAddress().length - 1; cont++) {
            this.address[cont] = address[cont];
        }
    }

}
