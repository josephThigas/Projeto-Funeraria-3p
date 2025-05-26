package model;

import java.sql.Date;

public class Agendamento {
    private int codAgendamento;
    private Date dataAgendamento;
    private int hora;
    private int codFuncionario;

    public Agendamento(int codAgendamento, Date dataAgendamento, int hora, int codFuncionario) {
        this.codAgendamento = codAgendamento;
        this.dataAgendamento = dataAgendamento;
        this.hora = hora;
        this.codFuncionario = codFuncionario;
    }

    public int getCodAgendamento() { return codAgendamento; }
    public void setCodAgendamento(int codAgendamento) { this.codAgendamento = codAgendamento; }
    public Date getDataAgendamento() { return dataAgendamento; }
    public void setDataAgendamento(Date dataAgendamento) { this.dataAgendamento = dataAgendamento; }
    public int getHora() { return hora; }
    public void setHora(int hora) { this.hora = hora; }
    public int getCodFuncionario() { return codFuncionario; }
    public void setCodFuncionario(int codFuncionario) { this.codFuncionario = codFuncionario; }
}
