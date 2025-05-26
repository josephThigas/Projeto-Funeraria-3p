package model;

public class Funcionario extends PessoaBase {
    private int codFuncionario;

    public Funcionario(int codFuncionario, String nome) {
        super(nome);
        this.codFuncionario = codFuncionario;
    }

    public int getCodFuncionario() { return codFuncionario; }
    public void setCodFuncionario(int codFuncionario) { this.codFuncionario = codFuncionario; }
}
