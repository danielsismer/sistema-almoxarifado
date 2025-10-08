package app.almoxarifado.dao;

import app.almoxarifado.model.Fornecedor;
import app.almoxarifado.util.ConexaoDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FornecedorDAO {

    public static void cadastrarFornecedor(Fornecedor fornecedor) throws SQLException{
        String query = """
                INSERT INTO Fornecedor (nome, cnpj) VALUES (?, ?);
                """;
        try(Connection conn = ConexaoDB.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setString(1, fornecedor.getNome().trim());
            stmt.setString(2, fornecedor.getCnpj());
            stmt.executeUpdate();
            System.out.println("Fornecedor Cadastrado com Sucesso!!!");
        } catch(SQLIntegrityConstraintViolationException e ){
            System.out.println("Erro ao Cadastrar! Já existe um Fornecedor com esse CNPJ");
        }
    }

    public static List<Fornecedor> select() throws SQLException{
        List<Fornecedor> fornecedores = new ArrayList<>();
        String query = """
                SELECT id
                , nome
                , cnpj
                FROM Fornecedor
                WHERE 1 = 1;
                """;
        try(Connection conn = ConexaoDB.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)){
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String cnpj = rs.getString("cnpj");
                fornecedores.add(new Fornecedor(id, nome, cnpj));
            }
        }
        return fornecedores;
    }
}
