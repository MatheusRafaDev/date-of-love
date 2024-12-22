package br.com.dateoflove.model;

import java.io.Serializable;

public class DetalheOrcamento implements Serializable {
    private static final long serialVersionUID = 1L;

    private int idDetalheOrcamento;
    private int idOrcamento;
    private int idServico;
    private int quantidade;
    private double precoEditavel;
    private String observacaoServico;
    private char tipo; // 'S' = Simples, 'C' = Comum, 'P' = Premium, 'E' = Exclusivo

    public DetalheOrcamento() {
    }

    public DetalheOrcamento(int idDetalheOrcamento, int idOrcamento, int idServico, int quantidade, double precoEditavel, String observacaoServico, char tipo) {
        this.idDetalheOrcamento = idDetalheOrcamento;
        this.idOrcamento = idOrcamento;
        this.idServico = idServico;
        this.quantidade = quantidade;
        this.precoEditavel = precoEditavel;
        this.observacaoServico = observacaoServico;
        this.tipo = tipo;
    }

    // Getters and setters for all fields
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

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }
}