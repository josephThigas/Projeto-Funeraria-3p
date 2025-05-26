package interfaces;

import model.Falecido;
import java.sql.SQLException;
import java.util.List;

public interface IFalecidoRepository {
    void inserir(Falecido falecido) throws SQLException;
    void atualizar(Falecido falecido) throws SQLException;
    void remover(int codFalecido) throws SQLException;
    List<Falecido> listar() throws SQLException;
}
