package model;

public class Cliente extends PessoaBase {
    private int codCliente;
    private String cpf;
    private String cep;
    private String telefone;

    public Cliente(String nome, String cpf, String cep, String telefone) {
        super(nome);
        this.cpf = cpf;
        this.cep = cep;
        this.telefone = telefone;
    }
    public Cliente(int codCliente, String nome, String cpf, String cep, String telefone) {
        super(nome);
        this.codCliente = codCliente;
        this.cpf = cpf;
        this.cep = cep;
        this.telefone = telefone;
    }

    public int getCodCliente() { return codCliente; }
    public void setCodCliente(int codCliente) { this.codCliente = codCliente; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
}
