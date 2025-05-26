package interfaces;

import model.Agendamento;
import java.sql.SQLException;
import java.util.List;

public interface IAgendamentoRepository {
    void inserir(Agendamento agendamento) throws SQLException;
    void atualizar(Agendamento agendamento) throws SQLException;
    void remover(int codAgendamento) throws SQLException;
    List<Agendamento> listar() throws SQLException;
}
