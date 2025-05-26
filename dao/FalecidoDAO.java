package dao;

import model.Falecido;
import util.ConnectionFactory;
import java.sql.*;
import java.util.*;
import interfaces.IFalecidoRepository;

public class FalecidoDAO implements IFalecidoRepository {
    public void inserir(Falecido falecido) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        String sql = "INSERT INTO falecido (cod_falecido, nome, dataFalecimento, cod_cliente) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, falecido.getCodFalecido());
        stmt.setString(2, falecido.getNome());
        stmt.setDate(3, falecido.getDataFalecimento());
        stmt.setInt(4, falecido.getCodCliente());
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }

    public void atualizar(Falecido falecido) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        String sql = "UPDATE falecido SET nome=?, dataFalecimento=?, cod_cliente=? WHERE cod_falecido=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, falecido.getNome());
        stmt.setDate(2, falecido.getDataFalecimento());
        stmt.setInt(3, falecido.getCodCliente());
        stmt.setInt(4, falecido.getCodFalecido());
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }

    public void remover(int codFalecido) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        String sql = "DELETE FROM falecido WHERE cod_falecido=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, codFalecido);
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }

    public List<Falecido> listar() throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM falecido";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        List<Falecido> lista = new ArrayList<>();
        while (rs.next()) {
            lista.add(new Falecido(
                rs.getInt("cod_falecido"),
                rs.getString("nome"),
                rs.getDate("dataFalecimento"),
                rs.getInt("cod_cliente")
            ));
        }
        rs.close();
        stmt.close();
        conn.close();
        return lista;
    }
}
