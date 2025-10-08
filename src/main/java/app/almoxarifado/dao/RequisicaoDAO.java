package app.almoxarifado.dao;

import app.almoxarifado.model.Requisicao;
import app.almoxarifado.util.ConexaoDB;

import java.sql.*;

public class RequisicaoDAO {

    public static int insert (Requisicao r) throws SQLException {
        String query = """
                INSERT INTO Requisicao(setor) VALUES (?);
                """;

        try(Connection conn = ConexaoDB.conectar();
            PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
            stmt.setString(1, r.getSetor());
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    int idGerado = rs.getInt(1);
                    System.out.println("Nota de Entrada registrada com Sucesso! ID: " + idGerado);
                    return idGerado;
                } else {
                    throw new SQLException("Falha ao obter o ID");
                }
            }
        }

    }
}
