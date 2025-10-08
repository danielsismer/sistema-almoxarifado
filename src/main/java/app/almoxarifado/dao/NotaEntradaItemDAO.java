package app.almoxarifado.dao;

import app.almoxarifado.model.NotaEntradaItem;
import app.almoxarifado.util.ConexaoDB;
import com.mysql.cj.protocol.a.CompressedInputStream;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NotaEntradaItemDAO {

    public static void insert (NotaEntradaItem nI ) throws SQLException {
        String query = """
                INSERT INTO NotaEntradaItem (idNotaEntrada, idMaterial, quantidade) VALUES (?, ?, ?);
                """;
        try(Connection conn = ConexaoDB.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setInt(1, nI.getId());
            stmt.setInt(2, nI.getIdMaterial());
            stmt.setDouble(3, nI.getQuantidade());
            stmt.executeUpdate();
            System.out.println("Sucesso!!!");
        }
    }
}
