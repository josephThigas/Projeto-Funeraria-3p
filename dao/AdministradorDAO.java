package dao;

import model.Administrador;
import util.ConnectionFactory;
import java.sql.*;
import java.util.*;
import interfaces.IAdministradorRepository;

public class AdministradorDAO implements IAdministradorRepository {
    public void inserir(Administrador administrador) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        String sql = "INSERT INTO administrador (cod_funcionario, areaVisualização) VALUES (?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, administrador.getCodFuncionario());
        stmt.setString(2, administrador.getAreaVisualizacao());
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }

    public void atualizar(Administrador administrador) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        String sql = "UPDATE administrador SET areaVisualização=? WHERE cod_funcionario=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, administrador.getAreaVisualizacao());
        stmt.setInt(2, administrador.getCodFuncionario());
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }

    public void remover(int codFuncionario) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        String sql = "DELETE FROM administrador WHERE cod_funcionario=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, codFuncionario);
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }

    public List<Administrador> listar() throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM administrador";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        List<Administrador> lista = new ArrayList<>();
        while (rs.next()) {
            lista.add(new Administrador(
                rs.getInt("cod_funcionario"),
                "",
                rs.getString("areaVisualização")
            ));
        }
        rs.close();
        stmt.close();
        conn.close();
        return lista;
    }
}
