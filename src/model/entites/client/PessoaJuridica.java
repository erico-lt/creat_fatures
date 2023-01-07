package model.entites.client;

public class PessoaJuridica extends Clients{
    private Long cnpj;
    private Long inscEstadual;

    public PessoaJuridica(String name, String telephone, String email, String[] address, Long cnpj, Long inscEstadual) {
        super(name, telephone, email, address);
        this.setCnpj(cnpj);
        this.setInscEstadual(inscEstadual);        
    }

    public Long getCnpj() {
        return cnpj;
    }

    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
    }

    public Long getInscEstadual() {
        return inscEstadual;
    }

    public void setInscEstadual(Long inscEstadual) {
        this.inscEstadual = inscEstadual;
    }

}
