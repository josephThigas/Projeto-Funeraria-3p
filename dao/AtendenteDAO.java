package dao;

import model.Atendente;
import util.ConnectionFactory;
import java.sql.*;
import java.util.*;
import interfaces.IAtendenteRepository;

public class AtendenteDAO implements IAtendenteRepository {
    public void inserir(Atendente atendente) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        String sql = "INSERT INTO atendente (cod_funcionario, nivelAcesso) VALUES (?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, atendente.getCodFuncionario());
        stmt.setInt(2, atendente.getNivelAcesso());
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }

    public void atualizar(Atendente atendente) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        String sql = "UPDATE atendente SET nivelAcesso=? WHERE cod_funcionario=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, atendente.getNivelAcesso());
        stmt.setInt(2, atendente.getCodFuncionario());
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }

    public void remover(int codFuncionario) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        String sql = "DELETE FROM atendente WHERE cod_funcionario=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, codFuncionario);
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }

    public List<Atendente> listar() throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM atendente";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        List<Atendente> lista = new ArrayList<>();
        while (rs.next()) {
            lista.add(new Atendente(
                rs.getInt("cod_funcionario"),
                "",
                rs.getInt("nivelAcesso")
            ));
        }
        rs.close();
        stmt.close();
        conn.close();
        return lista;
    }
}
