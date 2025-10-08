package app.almoxarifado.dao;

import app.almoxarifado.model.NotaEntrada;
import app.almoxarifado.util.ConexaoDB;

import java.sql.*;

public class NotaEntradaDAO {

    public static int insert(NotaEntrada n) {
        String query = """
            INSERT INTO NotaEntrada (idFornecedor) VALUES (?);
            """;

        try (Connection conn = ConexaoDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, n.getId_fornecedor());
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    int idGerado = rs.getInt(1);
                    System.out.println("Nota de Entrada registrada com Sucesso! ID: " + idGerado);
                    return idGerado;
                } else {
                    throw new SQLException("Falha ao obter o ID gerado.");
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir Nota de Entrada", e);
        }
    }


}
