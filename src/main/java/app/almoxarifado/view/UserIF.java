package app.almoxarifado.view;

import app.almoxarifado.model.Fornecedor;
import app.almoxarifado.model.Material;
import app.almoxarifado.model.Requisicao;

import java.util.Scanner;

public class UserIF {

    public static Scanner input = new Scanner(System.in);

    public static int menuPrincipal() {
        System.out.println("-------------------------------------------");
        System.out.println("| Bem vindo ao Sistema de Almoxarifado!!! |");
        System.out.println("-------------------------------------------");
        System.out.println("| 1- Cadastrar Fornecedor                 |");
        System.out.println("| 2- Cadastrar Material                   |");
        System.out.println("| 3- Registrar Nota de Entrada            |");
        System.out.println("| 4- Criar Requisição de Material         |");
        System.out.println("| 5- Atender Requisição                   |");
        System.out.println("| 6- Cancelar Requisição                  |");
        System.out.println("-------------------------------------------");
        System.out.print("Escolha: ");
        return input.nextInt();
    }

    public static Fornecedor cadastrarFornecedor() {
        System.out.println("-------------------------------------------");
        System.out.println("|           Cadastrar Fornecedor          |");
        System.out.println("-------------------------------------------");
        System.out.print("Insira o Nome do Fornecedor: ");
        String nome = input.nextLine();
        System.out.print("Insira o CNPJ do Fornecedor: ");
        String cnpj = input.nextLine();
        return new Fornecedor(nome, cnpj);
    }

    public static Material cadastrarMaterial() {
        System.out.println("-------------------------------------------");
        System.out.println("|           Cadastrar Material             |");
        System.out.println("-------------------------------------------");
        System.out.print("Insira o Nome do Material: ");
        String nome = input.nextLine();
        System.out.print("Insira a Unidade de Medida do Material: ");
        String unidade = input.nextLine();
        System.out.print("Insira o Estoque do Material: ");
        double estoque = input.nextDouble();
        input.nextLine();  // Consome a quebra de linha pendente
        return new Material(nome, unidade, estoque);
    }

    public static int registrarNotaEntrada() {
        System.out.println("-------------------------------------------");
        System.out.println("|           Registrar Nota de Entrada      |");
        System.out.println("-------------------------------------------");
        System.out.print("Insira o ID do Fornecedor: ");
        return input.nextInt();
    }

    public static int opcoesRegistrarNota() {
        System.out.println("-------------------------------------------------------");
        System.out.println("|          Registrar Outra Nota de Entrada             |");
        System.out.println("------------------------------------------------------");
        System.out.println("1- Registrar outro Material ao Mesmo Fornecedor");
        System.out.println("2- Registrar outro Material à Outro Fornecedor ");
        System.out.println("Escolha: ");
        return input.nextInt();
    }

    /*4️⃣Criar Requisição de Material

        Fluxo de execução:
        ● Menu exibe a opção Criar Requisição de Material.

        Solicitar ao usuário:
        ● Setor requisitante
        ● Lista de materiais a serem requisitados com suas quantidades

        Validações:
        ● Verificar se a quantidade solicitada não ultrapassa o estoque disponível
        ● Setor e materiais obrigatórios

    */

    public static Requisicao registrarRequisicao(){
        System.out.println("-------------------------------------------------------");
        System.out.println("|           Registrar uma Requisição                   |");
        System.out.println("-------------------------------------------------------");
        System.out.println("Insira o setor: ");
        String setor = input.nextLine();

        return new Requisicao(setor);
    }

}
