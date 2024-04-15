package br.com.dateoflove.model;

public class DetalheOrcamento {
        private int idDetalheOrcamento;
        private int idOrcamento;
        private int idServico;
        private int quantidade;
        private double preco;
        private String observacaoServico;

        public DetalheOrcamento(int idDetalheOrcamento, int idOrcamento, int idServico, int quantidade, double preco, String observacaoServico) {
            this.idDetalheOrcamento = idDetalheOrcamento;
            this.idOrcamento = idOrcamento;
            this.idServico = idServico;
            this.quantidade = quantidade;
            this.preco = preco;
            this.observacaoServico = observacaoServico;
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

        public double getPreco() {
            return preco;
        }

        public void setPreco(double preco) {
            this.preco = preco;
        }

        public String getObservacaoServico() {
            return observacaoServico;
        }

        public void setObservacaoServico(String observacaoServico) {
            this.observacaoServico = observacaoServico;
        }
    }


