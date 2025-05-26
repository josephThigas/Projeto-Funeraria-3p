package interfaces;

import model.Atendente;
import java.sql.SQLException;
import java.util.List;

public interface IAtendenteRepository {
    void inserir(Atendente atendente) throws SQLException;
    void atualizar(Atendente atendente) throws SQLException;
    void remover(int codFuncionario) throws SQLException;
    List<Atendente> listar() throws SQLException;
}
