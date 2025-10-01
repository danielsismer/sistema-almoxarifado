package app.almoxarifado.dao;

import app.almoxarifado.model.Material;
import app.almoxarifado.util.ConexaoDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MaterialDAO {

    public static void cadastrarMaterial(Material m ) throws SQLException {
        String query = """
                INSERT INTO Material (nome, unidade, estoque) VALUES (?, ?, ?);
                """;
        try(Connection conn = ConexaoDB.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setString(1, m.getNome());
            stmt.setString(2, m.getUnidade());
            stmt.setDouble(3, m.getEstoque());
            stmt.executeUpdate();
            System.out.println("Material Cadastrado com Sucesso!!!");
        } catch(SQLIntegrityConstraintViolationException e ){
            System.out.println("Erro ao Cadastrar! Já existe um Fornecedor com esse CNPJ");
        }
    }

    public static List<Material> listarMaterial() throws SQLException{
        List<Material> materiais = new ArrayList<>();
        String query = """
                SELECT
                id
                , nome
                , unidade
                , estoque
                FROM 
                Material
                WHERE 1 = 1;
                """;
        try(Connection conn = ConexaoDB.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)){
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String unidade = rs.getString("unidade");
                double estoque = rs.getDouble("estoque");
                materiais.add(new Material(id, nome, unidade, estoque));
            }
        }
        return materiais;
    }
}
