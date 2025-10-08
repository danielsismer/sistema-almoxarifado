package app.almoxarifado.model;

import java.sql.Date;

public class Requisicao {

    private int id;
    private String setor;
    private Date dataSolicitacao;
    private String status;

    public Requisicao(int id, String setor, Date dataSolicitacao, String status) {
        this.id = id;
        this.setor = setor;
        this.dataSolicitacao = dataSolicitacao;
        this.status = status;
    }

    public Requisicao(String setor) {
        this.setor = setor;
    }

    public String getStatus() {
        return status;
    }

    public Date getDataSolicitacao() {
        return dataSolicitacao;
    }

    public String getSetor() {
        return setor;
    }

    public int getId() {
        return id;
    }
}
