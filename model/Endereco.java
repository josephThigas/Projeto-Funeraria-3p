package model;

public class Endereco {
    private String bairro;
    private String estado;
    private String cep;
    private String rua;
    private String numero;
    private String cidade;

    public Endereco(String bairro, String estado, String cep, String rua, String numero, String cidade) {
        this.bairro = bairro;
        this.estado = estado;
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
    }

    public String getBairro() { return bairro; }
    public void setBairro(String bairro) { this.bairro = bairro; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }
    public String getRua() { return rua; }
    public void setRua(String rua) { this.rua = rua; }
    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }
    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }
}
