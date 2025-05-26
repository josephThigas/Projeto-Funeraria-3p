package dao;

import util.ConnectionFactory;
import java.sql.*;

public class AutenticacaoDAO {
    public boolean autenticar(int codFuncionario, String nome) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM funcionario WHERE cod_funcionario=? AND nome=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, codFuncionario);
        stmt.setString(2, nome);
        ResultSet rs = stmt.executeQuery();
        boolean autenticado = rs.next();
        rs.close();
        stmt.close();
        conn.close();
        return autenticado;
    }
}
