package interfaces;

import model.Administrador;
import java.sql.SQLException;
import java.util.List;

public interface IAdministradorRepository {
    void inserir(Administrador administrador) throws SQLException;
    void atualizar(Administrador administrador) throws SQLException;
    void remover(int codFuncionario) throws SQLException;
    List<Administrador> listar() throws SQLException;
}
