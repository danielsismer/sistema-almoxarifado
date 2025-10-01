package app.almoxarifado.dao;

import app.almoxarifado.model.Fornecedor;
import app.almoxarifado.util.ConexaoDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDAO {

    public static boolean verificarDuplicidade() throws SQLException {
        String query = """
                SELECT COUNT(1)
                , nome
                , cnpj
                FROM Fornecedor
                WHERE 1=1
                """;
        List<Fornecedor> fornecedorList = new ArrayList<>();
        try(Connection conn = ConexaoDB.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){
            ResultSet rs = stmt.executeQuery();

            while(rs.next() && rs.getRow() < 1 ){
                String nome = rs.getString("nome");
                String cnpj = rs.getString("cnpj");
                fornecedorList.add(new Fornecedor(nome,cnpj));
            }
        } catch(SQLException e ) {
            System.out.println("erro");
        }

        if (fornecedorList.size() > 1 ){
            return true;
        }

        return false;
    }

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
}
