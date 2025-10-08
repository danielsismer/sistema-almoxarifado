package app.almoxarifado.service;

import app.almoxarifado.dao.*;
import app.almoxarifado.model.Material;
import app.almoxarifado.model.NotaEntrada;
import app.almoxarifado.model.NotaEntradaItem;
import app.almoxarifado.model.RequisicaoItem;
import app.almoxarifado.view.UserIF;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.List;

import static app.almoxarifado.view.UserIF.input;

public class ServiceAlmoxarifado {

    public static void fluxoPricipal(int opcaoMenu) throws SQLException {

        switch (opcaoMenu) {
            case 1 -> {
                var fornecedor = UserIF.cadastrarFornecedor();

                if (!fornecedor.getNome().isEmpty() && !fornecedor.getCnpj().isEmpty()) {
                    if (fornecedor.getCnpj().length() == 14) {
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
                if (!material.getNome().isEmpty()) {
                    if (material.getEstoque() >= 0) {
                        MaterialDAO.cadastrarMaterial(material);
                    }
                }
            }

            case 3 -> {
                boolean continuar = true;
                while (continuar) {
                    int idFornecedor = UserIF.registrarNotaEntrada();
                    var fornecedores = FornecedorDAO.select();
                    boolean verificarFornecedor = VerificarValidacao.verificarFornecedorExistente(idFornecedor, fornecedores);
                    if (verificarFornecedor) {
                        List<Material> materiais = MaterialDAO.listarMaterial();
                        materiais.forEach((System.out::println));
                        System.out.println("Insira o ID do material para registrar na nota: ");
                        int idMaterial = input.nextInt();
                        boolean verificarMaterial = VerificarValidacao.verificarMaterialExistente(idMaterial, materiais);
                        if (verificarMaterial) {
                            System.out.println("Insira a quantidade desejada: ");
                            int quantidade = input.nextInt();
                            input.nextLine();
                            boolean verificarEstoqueMaterial = VerificarValidacao.verificarQuantidadeMaterial(quantidade, idMaterial, materiais);
                            if (verificarEstoqueMaterial) {
                                int idGerado = NotaEntradaDAO.insert(new NotaEntrada(idFornecedor));
                                NotaEntradaItemDAO.insert(new NotaEntradaItem(idGerado, idMaterial, quantidade));
                            } else {
                                System.out.println("Quantidade inserida não aceitada!!!");
                            }
                        } else {
                            System.out.println("Material Inexistente!!!");
                        }
                    } else {
                        System.out.println("Fornecedor Inexistente!!!");
                    }

                    System.out.println("Deseja Registrar mais uma nota? (Sim / Não) ");
                    String resposta = input.nextLine();
                    if (resposta.equalsIgnoreCase("sim")) {
                        // sa
                    } else {
                        continuar = false;
                    }

                    int continuarComOutraNota = UserIF.opcoesRegistrarNota();
                    input.nextLine();

                    if (continuarComOutraNota == 1) {
                        System.out.println("Insira o ID do Material: ");
                        int id_Material = input.nextInt();
                        input.nextLine();
                        System.out.println("Insira a quantidade desejada: ");
                        int quantidade = input.nextInt();
                        input.nextLine();
                        NotaEntradaDAO.insert(new NotaEntrada(idFornecedor));
                        NotaEntradaItemDAO.insert(new NotaEntradaItem(id_Material, quantidade));
                    } else {
                        System.out.println("Insira o ID do Fornecedor: ");
                        int id_Fornecedor = input.nextInt();
                        input.nextLine();
                        System.out.println("Insira o ID do Material: ");
                        int id_Material = input.nextInt();
                        input.nextLine();
                        System.out.println("Insira a quantidade desejada: ");
                        int quantidade = input.nextInt();
                        input.nextLine();
                        NotaEntradaDAO.insert(new NotaEntrada(id_Fornecedor));
                        NotaEntradaItemDAO.insert(new NotaEntradaItem(id_Material, quantidade));
                    }
                }

            }

            case 4 -> {
                var requisicao = UserIF.registrarRequisicao();
                if (requisicao.getSetor() != null) {
                    List<Material> materiais = MaterialDAO.listarMaterial();
                    materiais.forEach((System.out::println));
                    System.out.println("Insira o ID do Material: ");
                    int idMaterial = input.nextInt();
                    input.nextLine();
                    boolean verificarMaterial = VerificarValidacao.verificarMaterialExistente(idMaterial, materiais);
                    if (verificarMaterial) {
                        System.out.println("Insira a quantidade desejada: ");
                        int quantidade = input.nextInt();
                        input.nextLine();
                        boolean verificarEstoqueMaterial = VerificarValidacao.verificarQuantidadeMaterial(quantidade, idMaterial, materiais);
                        if (verificarEstoqueMaterial) {
                            int idGerado = RequisicaoDAO.insert(requisicao);
                            System.out.println("Requisição registrada com sucesso!!!");
                            RequisicaoItemDAO.insert(new RequisicaoItem(idGerado, idMaterial, quantidade));
                        } else {
                            System.out.println("Quantidade não autorizada!!!");
                        }
                    } else {
                        System.out.println("Material Inexistente!!!");
                    }
                } else {
                    System.out.println("O nome do Setor não Pode estar Vazio!!!");
                }
            }
        }
    }
}
