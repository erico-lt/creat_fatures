package model.entites.client;

public class PessoaFisica extends Clients{
    private Long cpf;
    private Long rg; 

    public PessoaFisica(String name, String telephone, String email, String[] address, Long cpf, Long rg) {
        super(name, telephone, email, address);     
        this.setCpf(cpf);
        this.setRg(rg);   
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public Long getRg() {
        return rg;
    }

    public void setRg(Long rg) {
        this.rg = rg;
    }

}
