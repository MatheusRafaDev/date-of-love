package br.com.dateoflove.model;
import java.util.Date;

public class Casamento {
    private int idCasamento;
    private int idUsuario;
    private Date dataCasamento;
    private String localidade;
    private int numeroConvidados;
    private String estiloFesta;

    public Casamento(int idCasamento, int idUsuario, Date dataCasamento, String localidade, int numeroConvidados, String estiloFesta) {
        this.idCasamento = idCasamento;
        this.idUsuario = idUsuario;
        this.dataCasamento = dataCasamento;
        this.localidade = localidade;
        this.numeroConvidados = numeroConvidados;
        this.estiloFesta = estiloFesta;
    }

    public Casamento(){
        super();
    }

    public int getIdCasamento() {
        return idCasamento;
    }

    public void setIdCasamento(int idCasamento) {
        this.idCasamento = idCasamento;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getDataCasamento() {
        return dataCasamento;
    }

    public void setDataCasamento(Date dataCasamento) {
        this.dataCasamento = dataCasamento;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public int getNumeroConvidados() {
        return numeroConvidados;
    }

    public void setNumeroConvidados(int numeroConvidados) {
        this.numeroConvidados = numeroConvidados;
    }

    public String getEstiloFesta() {
        return estiloFesta;
    }

    public void setEstiloFesta(String estiloFesta) {
        this.estiloFesta = estiloFesta;
    }
}
