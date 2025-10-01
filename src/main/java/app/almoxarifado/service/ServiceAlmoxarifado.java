package app.almoxarifado.service;

import app.almoxarifado.dao.FornecedorDAO;
import app.almoxarifado.dao.MaterialDAO;
import app.almoxarifado.model.Fornecedor;
import app.almoxarifado.model.Material;
import app.almoxarifado.view.UserIF;

import java.sql.SQLException;
import java.util.List;

import static app.almoxarifado.view.UserIF.input;

public class ServiceAlmoxarifado {

    public static void fluxoPricipal (int opcaoMenu) throws SQLException {

        switch (opcaoMenu){
            case 1 -> {
                var fornecedor = UserIF.cadastrarFornecedor();

                if(!fornecedor.getNome().isEmpty() && !fornecedor.getCnpj().isEmpty()){
                    if(fornecedor.getCnpj().length() == 14 ){
                        FornecedorDAO.cadastrarFornecedor(fornecedor);
                    } else {
                        System.out.println("CNPJ inválido!!!");
                    }
                } else {
                    System.out.println("O Nome ou CNPJ não pode estar vazio");
                }
            }

            case 2 -> {
                var material = UserIF.cadastrarMaterial();
                if(!material.getNome().isEmpty()){
                    if(material.getEstoque() >= 0 ){
                        MaterialDAO.cadastrarMaterial(material);
                    }
                }
            }

            case 3 -> {
                int idFornecedor = UserIF.registrarNotaEntrada();
                List<Material> materiais = MaterialDAO.listarMaterial();
                materiais.forEach((System.out::println));
                System.out.println("Insira o ID do material para registrar na nota: ");
                int idMaterial = input.nextInt();
            }
        }
    }
}
