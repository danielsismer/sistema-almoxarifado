package app.almoxarifado.model;

public class NotaEntradaItem {

    private int id;
    private int idMaterial;
    private double quantidade;

    public NotaEntradaItem(int id, int idMaterial, double quantidade) {
        this.id = id;
        this.idMaterial = idMaterial;
        this.quantidade = quantidade;
    }

    public NotaEntradaItem(int idMaterial, double quantidade) {
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
