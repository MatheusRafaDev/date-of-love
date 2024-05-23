package br.com.dateoflove.model;

import java.util.Date;

public class Orcamentos {
    private int idOrcamento;
    private int idUsuario;
    private int idCasamento;
    private Date dataOrcamento;
    private String status;
    private String observacao;
    private String observacaoOrcador;
    private String nomeOrcador;
    private double valorTotal;
    private boolean aprovado;
    private Double valorOrcado;
    private boolean cancelado;

    private double valorService1;
    private double valorService2;
    private double valorService3;
    private double valorService4;
    private double valorService5;

    public Orcamentos() {
        super();
    }

    public Orcamentos(int idOrcamento, int idUsuario, int idCasamento, Date dataOrcamento, String status, String observacao, String nomeOrcador, double valorTotal, boolean aprovado, String observacaoOrcador, boolean cancelado) {
        this.idOrcamento = idOrcamento;
        this.idUsuario = idUsuario;
        this.idCasamento = idCasamento;
        this.dataOrcamento = dataOrcamento;
        this.status = status;
        this.observacao = observacao;
        this.observacaoOrcador = observacaoOrcador;
        this.nomeOrcador = nomeOrcador;
        this.valorTotal = valorTotal;
        this.aprovado = aprovado;
        this.valorOrcado = 0.0; // Inicializando valorOrcado
        this.cancelado = cancelado;
    }

    public Double getValorOrcado() {
        return valorOrcado;
    }

    public void setValorOrcado(Double valorOrcado) {
        this.valorOrcado = valorOrcado;
    }

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

    public int getIdCasamento() {
        return idCasamento;
    }

    public void setIdCasamento(int idCasamento) {
        this.idCasamento = idCasamento;
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

    public String getObservacaoOrcador() {
        return observacaoOrcador;
    }

    public void setObservacaoOrcador(String observacaoOrcador) {
        this.observacaoOrcador = observacaoOrcador;
    }

    public boolean isCancelado() {
        return cancelado;
    }

    public void setCancelado(boolean cancelado) {
        this.cancelado = cancelado;
    }

    public double getValorService1() {
        return valorService1;
    }

    public void setValorService1(double valorService1) {
        this.valorService1 = valorService1;
    }

    public double getValorService2() {
        return valorService2;
    }

    public void setValorService2(double valorService2) {
        this.valorService2 = valorService2;
    }

    public double getValorService3() {
        return valorService3;
    }

    public void setValorService3(double valorService3) {
        this.valorService3 = valorService3;
    }

    public double getValorService4() {
        return valorService4;
    }

    public void setValorService4(double valorService4) {
        this.valorService4 = valorService4;
    }

    public double getValorService5() {
        return valorService5;
    }

    public void setValorService5(double valorService5) {
        this.valorService5 = valorService5;
    }
}
