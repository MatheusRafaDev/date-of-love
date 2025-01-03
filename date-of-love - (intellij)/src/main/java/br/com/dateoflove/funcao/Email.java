package br.com.dateoflove.funcao;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import br.com.dateoflove.model.Orcamentos;
import br.com.dateoflove.model.Usuario;
import br.com.dateoflove.funcao.ConstrutorHTML;

public class Email {
    private String fromEmail;
    private String password;
    private String toEmail;
    private String emailSubject;
    private String emailBody;
    private String emailType;

    public Email(String fromEmail, String password, String toEmail, String emailSubject, String emailBody, String emailType) {
        this.fromEmail = "dateooflove@gmail.com";
        this.password = "peyv xknj ikdy bbzi";
        this.toEmail = toEmail;
        this.emailSubject = emailSubject;
        this.emailBody = emailBody;
        this.emailType = emailType;
    }


    public void enviarEmail() {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject(emailSubject);
            message.setText(emailBody);

            if (emailType.equals("html")) {
                message.setContent(emailBody, "text/html");
            }

            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public void enviarBoasVindas(Usuario usuario) {

        this.emailSubject = "Seja bem vindo(a) à DateOfLove";
        this.emailType = "html";

        String emailBody = ConstrutorHTML.criarConteudoHTMLBoasVindas(usuario);

        Email email = new Email(fromEmail, password, toEmail, emailSubject, emailBody, emailType);
        email.enviarEmail();
    }

    public void enviarOrcamentoAprovado(Orcamentos orcamento, Usuario usuario) {
        this.emailSubject = "Orçamento solicitado";
        this.emailType = "html";

        String emailBody = ConstrutorHTML.criarConteudoHTMLOrcamentoAprovado(orcamento, usuario);

        Email email = new Email(fromEmail, password, toEmail, emailSubject, emailBody, emailType);
        email.enviarEmail();
    }

    public void enviarOrcamentoPendente(Orcamentos orcamento, Usuario usuario) {
        this.emailSubject = "Orçamento solicitado";
        this.emailType = "html";

        String emailBody = ConstrutorHTML.criarConteudoHTMLOrcamentoPendente(orcamento, usuario);

        Email email = new Email(fromEmail, password, toEmail, emailSubject, emailBody, emailType);
        email.enviarEmail();
    }

    public void enviarOrcamentoCancelado(Orcamentos orcamento, Usuario usuario) {
        this.emailSubject = "Orçamento cancelado";
        this.emailType = "html";

        String emailBody = ConstrutorHTML.criarConteudoHTMLOrcamentoCancelado(orcamento, usuario);

        Email email = new Email(fromEmail, password, toEmail, emailSubject, emailBody, emailType);
        email.enviarEmail();
    }

    public void enviarDuvida(String nome, String email, String mensagem) {
        String subject = "Nova dúvida enviada por " + nome;
        String body = ConstrutorHTML.criarConteudoHTMLDuvidaEnviada(nome, email, mensagem);

        Email emailObj = new Email(fromEmail, password, email, subject, body, emailType);
        emailObj.enviarEmail();

    }

}
