package app.almoxarifado.model;

import org.w3c.dom.CDATASection;

import java.time.LocalDate;

public class NotaEntrada {

    private int id;
    private int id_fornecedor;
    private LocalDate data_Entrada;

    public NotaEntrada(int id, int id_fornecedor) {
        this.id = id;
        this.id_fornecedor = id_fornecedor;
        this.data_Entrada = LocalDate.now();
    }

    public NotaEntrada(int id_fornecedor) {
        this.id_fornecedor = id_fornecedor;
        this.data_Entrada = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public int getId_fornecedor() {
        return id_fornecedor;
    }

    public LocalDate getData_Entrada() {
        return data_Entrada;
    }
}
