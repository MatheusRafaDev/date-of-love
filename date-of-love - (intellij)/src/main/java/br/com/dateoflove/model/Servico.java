package br.com.dateoflove.model;

import java.io.Serializable;

public class Servico implements Serializable {

    private static final long serialVersionUID = 1L;

    private int idServico;
    private String nomeServico;
    private String descricaoSimples;
    private String descricaoComum;
    private String descricaoPremium;
    private String descricaoExclusivo;
    private double precoSimples;
    private double precoComum;
    private double precoPremium;
    private double precoExclusivo;

    // Construtores, getters, e setters
    public Servico() {
    }

    public Servico(int idServico, String nomeServico, String descricaoSimples, String descricaoComum, String descricaoPremium, String descricaoExclusivo, double precoSimples, double precoComum, double precoPremium, double precoExclusivo) {
        this.idServico = idServico;
        this.nomeServico = nomeServico;
        this.descricaoSimples = descricaoSimples;
        this.descricaoComum = descricaoComum;
        this.descricaoPremium = descricaoPremium;
        this.descricaoExclusivo = descricaoExclusivo;
        this.precoSimples = precoSimples;
        this.precoComum = precoComum;
        this.precoPremium = precoPremium;
        this.precoExclusivo = precoExclusivo;
    }

    // Getters and setters
    public int getIdServico() {
        return idServico;
    }

    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }

    public String getNomeServico() {
        return nomeServico;
    }

    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }

    public String getDescricaoSimples() {
        return descricaoSimples;
    }

    public void setDescricaoSimples(String descricaoSimples) {
        this.descricaoSimples = descricaoSimples;
    }

    public String getDescricaoComum() {
        return descricaoComum;
    }

    public void setDescricaoComum(String descricaoComum) {
        this.descricaoComum = descricaoComum;
    }

    public String getDescricaoPremium() {
        return descricaoPremium;
    }

    public void setDescricaoPremium(String descricaoPremium) {
        this.descricaoPremium = descricaoPremium;
    }

    public String getDescricaoExclusivo() {
        return descricaoExclusivo;
    }

    public void setDescricaoExclusivo(String descricaoExclusivo) {
        this.descricaoExclusivo = descricaoExclusivo;
    }

    public double getPrecoSimples() {
        return precoSimples;
    }

    public void setPrecoSimples(double precoSimples) {
        this.precoSimples = precoSimples;
    }

    public double getPrecoComum() {
        return precoComum;
    }

    public void setPrecoComum(double precoComum) {
        this.precoComum = precoComum;
    }

    public double getPrecoPremium() {
        return precoPremium;
    }

    public void setPrecoPremium(double precoPremium) {
        this.precoPremium = precoPremium;
    }

    public double getPrecoExclusivo() {
        return precoExclusivo;
    }

    public void setPrecoExclusivo(double precoExclusivo) {
        this.precoExclusivo = precoExclusivo;
    }
}