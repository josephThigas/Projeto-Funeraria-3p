package model;

// Classe abstrata exemplo, não afeta o banco nem as entidades já existentes
public abstract class PessoaBase {
    private String nome;

    public PessoaBase(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
