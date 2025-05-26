package model;

public class Administrador extends Funcionario {
    private String areaVisualizacao;

    public Administrador(int codFuncionario, String nome, String areaVisualizacao) {
        super(codFuncionario, nome);
        this.areaVisualizacao = areaVisualizacao;
    }

    public String getAreaVisualizacao() { return areaVisualizacao; }
    public void setAreaVisualizacao(String areaVisualizacao) { this.areaVisualizacao = areaVisualizacao; }
}
