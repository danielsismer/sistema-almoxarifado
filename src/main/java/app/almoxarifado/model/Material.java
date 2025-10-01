package app.almoxarifado.model;

public class Material {

    private int id;
    private String nome;
    private String unidade;
    private double estoque;

    public Material(int id, String nome, String unidade, double estoque) {
        this.id = id;
        this.nome = nome;
        this.unidade = unidade;
        this.estoque = estoque;
    }

    public Material(String nome, String unidade, double estoque) {
        this.nome = nome;
        this.unidade = unidade;
        this.estoque = estoque;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getUnidade() {
        return unidade;
    }

    public double getEstoque() {
        return estoque;
    }

    public String toString (){
        return "ID: " + id + " - Nome: " + nome + " - Unidade: " + unidade + " - Estoque: " + estoque;
    }
}
