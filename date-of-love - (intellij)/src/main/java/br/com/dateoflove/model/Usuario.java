package br.com.dateoflove.model;

import java.util.Date;

public class Usuario {
    private int idUsuario;
    private String nomeNoivo;
    private String nomeNoiva;
    private String email;
    private String senha;
    private Date dataCadastro;
    private String nomesConcatenados;
    private String imagem;

    public Usuario() {
        super();
    }

    public Usuario(int idUsuario, String nomeNoivo, String nomeNoiva, String email, String senha, Date dataCadastro, String nomesConcatenados, String imagem) {
        this.idUsuario = idUsuario;
        this.nomeNoivo = nomeNoivo;
        this.nomeNoiva = nomeNoiva;
        this.email = email;
        this.senha = senha;
        this.dataCadastro = dataCadastro;
        this.nomesConcatenados = nomesConcatenados;
        this.imagem = imagem;
    }

    public Usuario(int idUsuario,String imagem) {
        this.idUsuario = idUsuario;
        this.imagem = imagem;
    }


    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeNoivo() {
        return nomeNoivo;
    }

    public void setNomeNoivo(String nomeNoivo) {
        this.nomeNoivo = nomeNoivo;
    }

    public String getNomeNoiva() {
        return nomeNoiva;
    }

    public void setNomeNoiva(String nomeNoiva) {
        this.nomeNoiva = nomeNoiva;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getNomesConcatenados() {
        return nomesConcatenados;
    }

    public void setNomesConcatenados(String nomesConcatenados) {
        this.nomesConcatenados = nomesConcatenados;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}

