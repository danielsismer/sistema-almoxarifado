package app.almoxarifado.view;

import app.almoxarifado.model.Fornecedor;
import app.almoxarifado.model.Material;

import java.util.Scanner;

public class UserIF {

    public static Scanner input = new Scanner(System.in);

    public static int menuPrincipal(){
        System.out.print("""
                -------------------------------------------
                | Bem vindo ao Sistema de Almoxarifado!!! |
                -------------------------------------------
                | 1- Cadastrar Fornecedor                 |
                | 2- Cadastrar Material                   |
                | 3- Registrar Nota de Entrada            |
                | 4- Criar Requisição de Material         |
                | 5- Atender Requisição                   |
                | 6- Cancelar Requisição                  |
                -------------------------------------------
                Escolha:
                """);
        return input.nextInt();
    }

    public static Fornecedor cadastrarFornecedor(){
        System.out.println("""
                 -------------------------------------------
                |           Cadastrar Fornecedor          |
                -------------------------------------------
                """);
        System.out.print("Insira o Nome do Fornecedor: ");
        String nome = input.nextLine();
        System.out.println("Insira o CNPJ do Fornecedor: ");
        String cnpj = input.nextLine();
        return new Fornecedor(nome, cnpj);
    }

    public static Material cadastrarMaterial (){
        System.out.println("""
                 -------------------------------------------
                |           Cadastrar Material             |
                -------------------------------------------
                """);
        System.out.println("Insira o Nome do Material: ");
        String nome = input.nextLine();
        System.out.println("Insira a Unidade de Medida do Material: ");
        String unidade = input.nextLine();
        System.out.println("Insira o Estoque do Material: ");
        double estoque = input.nextDouble();
        input.nextLine();
        return new Material(nome, unidade, estoque);
    }

    public static int registrarNotaEntrada(){
        System.out.println("""
                 -------------------------------------------
                |           Cadastrar Material             |
                -------------------------------------------
                """);
        System.out.println("Insira o ID do Fornecedor: ");
        return input.nextInt();
    }


}
