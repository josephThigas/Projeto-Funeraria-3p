package dao;

import model.Produto;
import util.ConnectionFactory;
import java.sql.*;
import java.util.*;
import interfaces.IProdutoRepository;

public class ProdutoDAO implements IProdutoRepository {
    public void inserir(Produto produto) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        String sql = "INSERT INTO produto (cod_produto, nome, preco) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, produto.getCodProduto());
        stmt.setString(2, produto.getNome());
        stmt.setDouble(3, produto.getPreco());
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }

    public void atualizar(Produto produto) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        String sql = "UPDATE produto SET nome=?, preco=? WHERE cod_produto=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, produto.getNome());
        stmt.setDouble(2, produto.getPreco());
        stmt.setInt(3, produto.getCodProduto());
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }

    public void remover(int codProduto) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        String sql = "DELETE FROM produto WHERE cod_produto=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, codProduto);
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }

    public List<Produto> listar() throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM produto";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        List<Produto> lista = new ArrayList<>();
        while (rs.next()) {
            lista.add(new Produto(
                rs.getInt("cod_produto"),
                rs.getString("nome"),
                rs.getDouble("preco")
            ));
        }
        rs.close();
        stmt.close();
        conn.close();
        return lista;
    }
}
