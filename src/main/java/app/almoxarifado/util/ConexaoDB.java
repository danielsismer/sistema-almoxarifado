package app.almoxarifado.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {

    private static final String URL = "jdbc:mysql://localhost:3306/gerenciador_almoxarifado";
    private static final String USER = "root";
    private static final String PASSWORD = "mysqlPW";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[] args) {
        try{
            conectar();
            System.out.println("Conexão estabelecida com sucesso!!!");
        } catch (SQLException e) {
            System.out.println("Falha na Conexão!!!");
        }
    }
}
