package app.almoxarifado.dao;

import app.almoxarifado.model.RequisicaoItem;
import app.almoxarifado.util.ConexaoDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequisicaoItemDAO {

    public static void insert(RequisicaoItem r ){
        String query = """
                INSERT INTO RequisicaoItem (idRequisicao, idMaterial, quantidade) VALUES (?, ?, ? );
                """;

        try (Connection conn = ConexaoDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setInt(1, r.getId());
            stmt.setInt(2, r.getIdMaterial());
            stmt.setDouble(3, r.getQuantidade());
            stmt.executeUpdate();
            System.out.println("Requisição de Item criada com Sucesso!!!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
