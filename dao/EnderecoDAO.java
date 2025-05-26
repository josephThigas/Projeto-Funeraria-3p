package dao;

import model.Endereco;
import interfaces.IEnderecoRepository;
import util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EnderecoDAO implements IEnderecoRepository {
    public void inserir(Endereco endereco) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        String sql = "INSERT INTO endereco (cep, bairro, estado, rua, numero, cidade) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, endereco.getCep());
        stmt.setString(2, endereco.getBairro());
        stmt.setString(3, endereco.getEstado());
        stmt.setString(4, endereco.getRua());
        stmt.setString(5, endereco.getNumero());
        stmt.setString(6, endereco.getCidade());
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }

    public void atualizar(Endereco endereco) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        String sql = "UPDATE endereco SET bairro=?, estado=?, rua=?, numero=?, cidade=? WHERE cep=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, endereco.getBairro());
        stmt.setString(2, endereco.getEstado());
        stmt.setString(3, endereco.getRua());
        stmt.setString(4, endereco.getNumero());
        stmt.setString(5, endereco.getCidade());
        stmt.setString(6, endereco.getCep());
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }

    public void remover(String cep) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        String sql = "DELETE FROM endereco WHERE cep=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, cep);
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }

    public List<Endereco> listar() throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM endereco";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        List<Endereco> lista = new ArrayList<>();
        while (rs.next()) {
            lista.add(new Endereco(
                rs.getString("bairro"),
                rs.getString("estado"),
                rs.getString("cep"),
                rs.getString("rua"),
                rs.getString("numero"),
                rs.getString("cidade")
            ));
        }
        rs.close();
        stmt.close();
        conn.close();
        return lista;
    }
}
