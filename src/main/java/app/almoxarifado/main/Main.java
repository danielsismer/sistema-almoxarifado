package app.almoxarifado.main;

import app.almoxarifado.service.ServiceAlmoxarifado;
import app.almoxarifado.view.UserIF;

import java.sql.SQLException;

import static app.almoxarifado.view.UserIF.input;

public class Main {
    public static void main(String[] args) throws SQLException {

        while(true){
            int opcaoMenu = UserIF.menuPrincipal();
            input.nextLine();
            ServiceAlmoxarifado.fluxoPricipal(opcaoMenu);
        }
    }
}