package br.com.dateoflove.model;

import java.sql.Timestamp;

public class Chat {
    private int idChat;
    private int idUsuario;
    private String mensagem;
    private Timestamp dataEnvio;
    private boolean enviadoPorAdmin;

    // Getters and setters
    public int getIdChat() {
        return idChat;
    }

    public void setIdChat(int idChat) {
        this.idChat = idChat;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Timestamp getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(Timestamp dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public boolean isEnviadoPorAdmin() {
        return enviadoPorAdmin;
    }

    public void setEnviadoPorAdmin(boolean enviadoPorAdmin) {
        this.enviadoPorAdmin = enviadoPorAdmin;
    }
}