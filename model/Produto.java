package model;

public class Produto {
    private int codProduto;
    private String nome;
    private double preco;

    public Produto(int codProduto, String nome, double preco) {
        this.codProduto = codProduto;
        this.nome = nome;
        this.preco = preco;
    }

    public int getCodProduto() { return codProduto; }
    public void setCodProduto(int codProduto) { this.codProduto = codProduto; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }
}
