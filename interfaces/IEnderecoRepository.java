package interfaces;

import model.Endereco;
import java.sql.SQLException;
import java.util.List;

public interface IEnderecoRepository {
    void inserir(Endereco endereco) throws SQLException;
    void atualizar(Endereco endereco) throws SQLException;
    void remover(String cep) throws SQLException;
    List<Endereco> listar() throws SQLException;
}
