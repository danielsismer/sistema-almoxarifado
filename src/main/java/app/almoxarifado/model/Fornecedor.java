package app.almoxarifado.model;

public class Fornecedor {

    private int id;
    private String nome;
    private String cnpj;

    public Fornecedor(int id, String nome, String cnpj) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
    }

    public Fornecedor(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String toString(){
        return "ID: " + id + " - Nome: " + nome + " - CNPJ: " + cnpj;
    }
}
