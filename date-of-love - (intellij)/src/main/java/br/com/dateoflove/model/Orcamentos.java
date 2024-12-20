package br.com.dateoflove.model;

import java.util.Date;

public class Orcamentos {
    private int idOrcamento;
    private int idUsuario;
    private Date dataOrcamento;
    private String status;
    private String observacao;
    private String observacaoOrcador;
    private String nomeOrcador;
    private double valorTotal;
    private boolean aprovado;
    private boolean cancelado;
    private String local;
    private String tipoCerimonia;
    private String formaPagamento;
    private Double valorEstimado;
    private String comentarioAdicional;
    private int qtdConvidados;


    private Date dataCasamento;

    public Orcamentos() {
        super();
    }

    public Orcamentos(int idOrcamento, int idUsuario, Date dataOrcamento, String status, String observacao,
                      String observacaoOrcador, String nomeOrcador, double valorTotal, Double valorMedio,
                      boolean aprovado, boolean cancelado, String local, String tipoCerimonia,
                      String formaPagamento, Double valorEstimado, String observacaoGeral,
                      String comentarioAdicional, int qtdConvidados, Date dataCasamento) {
        this.idOrcamento = idOrcamento;
        this.idUsuario = idUsuario;
        this.dataOrcamento = dataOrcamento;
        this.status = status;
        this.observacao = observacao;
        this.observacaoOrcador = observacaoOrcador;
        this.nomeOrcador = nomeOrcador;
        this.valorTotal = valorTotal;
        this.aprovado = aprovado;
        this.cancelado = cancelado;
        this.local = local;
        this.tipoCerimonia = tipoCerimonia;
        this.formaPagamento = formaPagamento;
        this.valorEstimado = valorEstimado;
        this.comentarioAdicional = comentarioAdicional;
        this.qtdConvidados = qtdConvidados;
        this.dataCasamento = dataCasamento;
    }

    // Getters e setters para o campo dataCasamento
    public java.sql.Date getDataCasamento() {
        return (java.sql.Date) dataCasamento;
    }

    public void setDataCasamento(Date dataCasamento) {
        this.dataCasamento = dataCasamento;
    }

    // Outros getters e setters
    public int getIdOrcamento() {
        return idOrcamento;
    }

    public void setIdOrcamento(int idOrcamento) {
        this.idOrcamento = idOrcamento;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getDataOrcamento() {
        return dataOrcamento;
    }

    public void setDataOrcamento(Date dataOrcamento) {
        this.dataOrcamento = dataOrcamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getObservacaoOrcador() {
        return observacaoOrcador;
    }

    public void setObservacaoOrcador(String observacaoOrcador) {
        this.observacaoOrcador = observacaoOrcador;
    }

    public String getNomeOrcador() {
        return nomeOrcador;
    }

    public void setNomeOrcador(String nomeOrcador) {
        this.nomeOrcador = nomeOrcador;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public boolean isAprovado() {
        return aprovado;
    }

    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }

    public boolean isCancelado() {
        return cancelado;
    }

    public void setCancelado(boolean cancelado) {
        this.cancelado = cancelado;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getTipoCerimonia() {
        return tipoCerimonia;
    }

    public void setTipoCerimonia(String tipoCerimonia) {
        this.tipoCerimonia = tipoCerimonia;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Double getValorEstimado() {
        return valorEstimado;
    }

    public void setValorEstimado(Double valorEstimado) {
        this.valorEstimado = valorEstimado;
    }

    public String getComentarioAdicional() {
        return comentarioAdicional;
    }

    public void setComentarioAdicional(String comentarioAdicional) {
        this.comentarioAdicional = comentarioAdicional;
    }

    public int getQtdConvidados() {
        return qtdConvidados;
    }

    public void setQtdConvidados(int qtdConvidados) {
        this.qtdConvidados = qtdConvidados;
    }
}
