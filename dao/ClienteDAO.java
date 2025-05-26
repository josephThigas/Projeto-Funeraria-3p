package dao;

import model.Cliente;
import util.ConnectionFactory;
import java.sql.*;
import java.util.*;
import interfaces.IClienteRepository;

public class ClienteDAO implements IClienteRepository {
    public void inserir(Cliente cliente) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        String sql = "INSERT INTO cliente (nome, CPF, cep, telefone) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, cliente.getNome());
        stmt.setString(2, cliente.getCpf());
        stmt.setString(3, cliente.getCep());
        stmt.setString(4, cliente.getTelefone());
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }

    public void atualizar(Cliente cliente) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        String sql = "UPDATE cliente SET nome=?, CPF=?, cep=?, telefone=? WHERE cod_cliente=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, cliente.getNome());
        stmt.setString(2, cliente.getCpf());
        stmt.setString(3, cliente.getCep());
        stmt.setString(4, cliente.getTelefone());
        stmt.setInt(5, cliente.getCodCliente());
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }

    public void remover(int codCliente) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        String sql = "DELETE FROM cliente WHERE cod_cliente=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, codCliente);
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }

    public List<Cliente> listar() throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM cliente";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        List<Cliente> lista = new ArrayList<>();
        while (rs.next()) {
            lista.add(new Cliente(
                rs.getInt("cod_cliente"),
                rs.getString("nome"),
                rs.getString("CPF"),
                rs.getString("cep"),
                rs.getString("telefone")
            ));
        }
        rs.close();
        stmt.close();
        conn.close();
        return lista;
    }
}
