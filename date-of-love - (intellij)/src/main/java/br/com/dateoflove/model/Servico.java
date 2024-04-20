package br.com.dateoflove.model;

public class Servico {
    private String idNomeProduto;
    private String idTipoProduto;
    private String idDescricaoProduto;
    private String[] idItensProduto;

    // Construtor
    public Servico(String idNomeProduto, String idTipoProduto, String idDescricaoProduto, String[] idItensProduto) {
        this.idNomeProduto = idNomeProduto;
        this.idTipoProduto = idTipoProduto;
        this.idDescricaoProduto = idDescricaoProduto;
        this.idItensProduto = idItensProduto;
    }

    // Getters e Setters
    public String getIdNomeProduto() {
        return idNomeProduto;
    }

    public void setIdNomeProduto(String idNomeProduto) {
        this.idNomeProduto = idNomeProduto;
    }

    public String getIdTipoProduto() {
        return idTipoProduto;
    }

    public void setIdTipoProduto(String idTipoProduto) {
        this.idTipoProduto = idTipoProduto;
    }

    public String getIdDescricaoProduto() {
        return idDescricaoProduto;
    }

    public void setIdDescricaoProduto(String idDescricaoProduto) {
        this.idDescricaoProduto = idDescricaoProduto;
    }

    public String[] getIdItensProduto() {
        return idItensProduto;
    }

    public void setIdItensProduto(String[] idItensProduto) {
        this.idItensProduto = idItensProduto;
    }

    
}
