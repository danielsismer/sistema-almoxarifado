package app.almoxarifado.model;

public class RequisicaoItem {

    private int id;
    private int idMaterial;
    private double quantidade;

    public RequisicaoItem(int id, int idMaterial, double quantidade) {
        this.id = id;
        this.idMaterial = idMaterial;
        this.quantidade = quantidade;
    }

    public RequisicaoItem(int idMaterial, double quantidade) {
        this.idMaterial = idMaterial;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public int getIdMaterial() {
        return idMaterial;
    }

    public double getQuantidade() {
        return quantidade;
    }
}
