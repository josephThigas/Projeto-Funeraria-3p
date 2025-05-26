package interfaces;

import model.Funcionario;
import java.sql.SQLException;
import java.util.List;

public interface IFuncionarioRepository {
    void inserir(Funcionario funcionario) throws SQLException;
    void atualizar(Funcionario funcionario) throws SQLException;
    void remover(int codFuncionario) throws SQLException;
    List<Funcionario> listar() throws SQLException;
}
