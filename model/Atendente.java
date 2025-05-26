package model;

public class Atendente extends Funcionario {
    private int nivelAcesso;

    public Atendente(int codFuncionario, String nome, int nivelAcesso) {
        super(codFuncionario, nome);
        this.nivelAcesso = nivelAcesso;
    }

    public int getNivelAcesso() { return nivelAcesso; }
    public void setNivelAcesso(int nivelAcesso) { this.nivelAcesso = nivelAcesso; }
}
