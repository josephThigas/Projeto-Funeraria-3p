package dao;

import model.Funcionario;
import util.ConnectionFactory;
import java.sql.*;
import java.util.*;
import interfaces.IFuncionarioRepository;

public class FuncionarioDAO implements IFuncionarioRepository {
    public void inserir(Funcionario funcionario) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        String sql = "INSERT INTO funcionario (cod_funcionario, nome) VALUES (?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, funcionario.getCodFuncionario());
        stmt.setString(2, funcionario.getNome());
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }

    public void atualizar(Funcionario funcionario) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        String sql = "UPDATE funcionario SET nome=? WHERE cod_funcionario=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, funcionario.getNome());
        stmt.setInt(2, funcionario.getCodFuncionario());
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }

    public void remover(int codFuncionario) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        String sql = "DELETE FROM funcionario WHERE cod_funcionario=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, codFuncionario);
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }

    public List<Funcionario> listar() throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM funcionario";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        List<Funcionario> lista = new ArrayList<>();
        while (rs.next()) {
            lista.add(new Funcionario(rs.getInt("cod_funcionario"), rs.getString("nome")));
        }
        rs.close();
        stmt.close();
        conn.close();
        return lista;
    }
}
