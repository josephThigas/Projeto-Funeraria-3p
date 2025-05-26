package interfaces;

import model.Produto;
import java.sql.SQLException;
import java.util.List;

public interface IProdutoRepository {
    void inserir(Produto produto) throws SQLException;
    void atualizar(Produto produto) throws SQLException;
    void remover(int codProduto) throws SQLException;
    List<Produto> listar() throws SQLException;
}
