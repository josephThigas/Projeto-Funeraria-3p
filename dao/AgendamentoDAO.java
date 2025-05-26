package dao;

import model.Agendamento;
import util.ConnectionFactory;
import java.sql.*;
import java.util.*;
import interfaces.IAgendamentoRepository;

public class AgendamentoDAO implements IAgendamentoRepository {
    public void inserir(Agendamento agendamento) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        String sql = "INSERT INTO agendamento (cod_agendamento, dataAgendamento, hora, cod_funcionario) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, agendamento.getCodAgendamento());
        stmt.setDate(2, agendamento.getDataAgendamento());
        stmt.setInt(3, agendamento.getHora());
        stmt.setInt(4, agendamento.getCodFuncionario());
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }

    public void atualizar(Agendamento agendamento) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        String sql = "UPDATE agendamento SET dataAgendamento=?, hora=?, cod_funcionario=? WHERE cod_agendamento=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setDate(1, agendamento.getDataAgendamento());
        stmt.setInt(2, agendamento.getHora());
        stmt.setInt(3, agendamento.getCodFuncionario());
        stmt.setInt(4, agendamento.getCodAgendamento());
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }

    public void remover(int codAgendamento) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        String sql = "DELETE FROM agendamento WHERE cod_agendamento=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, codAgendamento);
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }

    public List<Agendamento> listar() throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM agendamento";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        List<Agendamento> lista = new ArrayList<>();
        while (rs.next()) {
            lista.add(new Agendamento(
                rs.getInt("cod_agendamento"),
                rs.getDate("dataAgendamento"),
                rs.getInt("hora"),
                rs.getInt("cod_funcionario")
            ));
        }
        rs.close();
        stmt.close();
        conn.close();
        return lista;
    }
}
