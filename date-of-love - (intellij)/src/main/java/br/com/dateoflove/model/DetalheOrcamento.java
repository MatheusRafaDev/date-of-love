package br.com.dateoflove.model;

public class DetalheOrcamento {
    private int idDetalheOrcamento;
    private int idOrcamento;
    private int idServico;
    private int quantidade;
    private double precoEditavel;
    private String observacaoServico;
    private boolean completo;
    private boolean incluso;

    public DetalheOrcamento() {
    }

    public DetalheOrcamento(int idDetalheOrcamento, int idOrcamento, int idServico, int quantidade, double precoEditavel, String observacaoServico, boolean completo,boolean incluso) {
        this.idDetalheOrcamento = idDetalheOrcamento;
        this.idOrcamento = idOrcamento;
        this.idServico = idServico;
        this.quantidade = quantidade;
        this.precoEditavel = precoEditavel;
        this.observacaoServico = observacaoServico;
        this.completo = completo;
        this.incluso = incluso;
    }

    public int getIdDetalheOrcamento() {
        return idDetalheOrcamento;
    }

    public void setIdDetalheOrcamento(int idDetalheOrcamento) {
        this.idDetalheOrcamento = idDetalheOrcamento;
    }

    public int getIdOrcamento() {
        return idOrcamento;
    }

    public void setIdOrcamento(int idOrcamento) {
        this.idOrcamento = idOrcamento;
    }

    public int getIdServico() {
        return idServico;
    }

    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoEditavel() {
        return precoEditavel;
    }

    public void setPrecoEditavel(double precoEditavel) {
        this.precoEditavel = precoEditavel;
    }

    public String getObservacaoServico() {
        return observacaoServico;
    }

    public void setObservacaoServico(String observacaoServico) {
        this.observacaoServico = observacaoServico;
    }

    public boolean isCompleto() {
        return completo;
    }

    public void setCompleto(boolean completo) {
        this.completo = completo;
    }

    public boolean isIncluso() {
        return incluso;
    }

    public void setIncluso(boolean incluso) {
        this.incluso = incluso;
    }

    public boolean isEditavel() {
        return !completo;
    }
}
