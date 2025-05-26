package interfaces;

import model.Cliente;
import java.sql.SQLException;
import java.util.List;

public interface IClienteRepository {
    void inserir(Cliente cliente) throws SQLException;
    void atualizar(Cliente cliente) throws SQLException;
    void remover(int codCliente) throws SQLException;
    List<Cliente> listar() throws SQLException;
}
