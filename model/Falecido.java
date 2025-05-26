package model;

public class Falecido {
    private int codFalecido;
    private String nome;
    private java.sql.Date dataFalecimento;
    private int codCliente;

    public Falecido(int codFalecido, String nome, java.sql.Date dataFalecimento, int codCliente) {
        this.codFalecido = codFalecido;
        this.nome = nome;
        this.dataFalecimento = dataFalecimento;
        this.codCliente = codCliente;
    }

    public int getCodFalecido() { return codFalecido; }
    public void setCodFalecido(int codFalecido) { this.codFalecido = codFalecido; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public java.sql.Date getDataFalecimento() { return dataFalecimento; }
    public void setDataFalecimento(java.sql.Date dataFalecimento) { this.dataFalecimento = dataFalecimento; }
    public int getCodCliente() { return codCliente; }
    public void setCodCliente(int codCliente) { this.codCliente = codCliente; }
}
