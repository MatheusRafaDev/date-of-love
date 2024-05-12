package br.com.dateoflove.funcao;

import br.com.dateoflove.model.Usuario;
import br.com.dateoflove.model.Casamento;
import br.com.dateoflove.model.Orcamentos;


public class ConstrutorHTML {

    public static String criarConteudoHTMLBoasVindas(Usuario usuario) {

        String emailBody = "<!DOCTYPE html>\n"
                + "<html lang=\"pt-br\">\n"
                + "<head>\n"
                + "    <meta charset=\"UTF-8\">\n"
                + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                + "    <title>Bem-Vindo ao DateOfLove!</title>\n"
                + "</head>\n"
                + "<body style=\"margin: 0; padding: 0; display: flex; justify-content: center; align-items: center; height: 600px; width: 600px; background-color: #f4f4f4; color: #333; font-family: Arial, sans-serif;\">\n"
                + "<div style=\"text-align: center; padding: 20px;\">\n"
                + "    <h2>Bem-Vindo ao DateOfLove!</h2>\n"
                + "\n"
                + "    <p>Olá " + usuario.getNomesConcatenados() + ",</p>\n"
                + "\n"
                + "    <p>É com grande prazer que damos as boas-vindas ao nosso sistema de orçamento de casamento! Estamos empolgados por tê-lo(a) conosco e esperamos que tenha uma experiência tranquila e eficiente ao planejar o seu casamento.</p>\n"
                + "\n"
                + "    <p>Aqui estão algumas informações úteis para começar:</p>\n"
                + "\n"
                + "    <ol style=\"text-align: left;\">\n"
                + "        <li><strong>Perfil:</strong> Certifique-se de verificar e completar seu perfil. Isso garantirá que suas informações estejam corretas para facilitar o processo de orçamento.</li>\n"
                + "        <li><strong>Explorar Serviços:</strong> Explore os diferentes serviços disponíveis para o seu casamento. Temos uma ampla variedade de opções para atender às suas necessidades.</li>\n"
                + "        <li><strong>Solicitar Orçamento:</strong> Ao escolher os serviços desejados, aproveite a opção de solicitar orçamento. Isso proporcionará uma visão mais detalhada dos custos e ajudará a planejar seu orçamento de casamento.</li>\n"
                + "    </ol>\n"
                + "\n"
                + "    <p>Estamos aqui para ajudar. Se tiver alguma dúvida ou precisar de assistência, não hesite em entrar em contato conosco.</p>\n"
                + "\n"
                + "    <p>Mais uma vez, seja bem-vindo(a) ao DateOfLove! Estamos ansiosos para ajudá-lo(a) a planejar o casamento dos seus sonhos.</p>\n"
                + "\n"
                + "    <p>Atenciosamente,<br>\n"
                + "    DateOfLove<br>\n"
                + "\n"
                + "    <p style=\"color: #333; font-size: 12px;\">&copy; 2024 DateOfLove. Todos os direitos reservados.</p>\n"
                + "</div>\n"
                + "</body>\n"
                + "</html>";

        return emailBody;
    }

    public static String criarConteudoHTMLOrcamentoAprovado(Orcamentos orcamento, Usuario usuario) {

        String emailBody = "<!DOCTYPE html>\n"
                + "<html lang=\"pt-br\">\n"
                + "<head>\n"
                + "    <meta charset=\"UTF-8\">\n"
                + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                + "    <title>Orçamento de Casamento Aprovado - DateOfLove</title>\n"
                + "</head>\n"
                + "<body style=\"margin: 0; padding: 0; display: flex; justify-content: center; align-items: center; height: 600px; width: 600px; background-color: #f4f4f4; color: #333; font-family: Arial, sans-serif;\">\n"
                + "<div style=\"text-align: center; padding: 20px;\">\n"
                + "    <h2>Orçamento de Casamento Aprovado - DateOfLove</h2>\n"
                + "\n"
                + "    <p>Olá " + usuario.getNomesConcatenados() + ",</p>\n"
                + "\n"
                + "    <p>Parabéns! Seu orçamento de casamento foi aprovado. Aqui estão os detalhes:</p>\n"
                + "\n"
                + "    <h3>Detalhes do Orçamento</h3>\n"
                + "    <ul style=\"text-align: left;\">\n"
                + "        <li><strong>Número do Orçamento:</strong> " + orcamento.getIdOrcamento() + "</li>\n"
                + "        <li><strong>Valor Total:</strong> R$ " + orcamento.getValorTotal() + "</li>\n"
                + "        <li><strong>Orçador:</strong> " + orcamento.getNomeOrcador() + "</li>\n"
                + "        <li><strong>Status:</strong> Aprovado</li>\n"
                + "    </ul>\n"
                + "\n"
                + "    <p>Parabéns! Agora podemos prosseguir com os próximos passos para o seu casamento.</p>\n"
                + "\n"
                + "    <p>Atenciosamente,<br>\n"
                + "    DateOfLove<br>\n"
                + "\n"
                + "    <p style=\"color: #333; font-size: 12px;\">&copy; 2024 DateOfLove. Todos os direitos reservados.</p>\n"
                + "</div>\n"
                + "</body>\n"
                + "</html>";

        return emailBody;
    }

    public static String criarConteudoHTMLOrcamentoPendente(Orcamentos orcamento, Usuario usuario) {

        String emailBody = "<!DOCTYPE html>\n"
                + "<html lang=\"pt-br\">\n"
                + "<head>\n"
                + "    <meta charset=\"UTF-8\">\n"
                + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                + "    <title>Orçamento de Casamento Pendente - DateOfLove</title>\n"
                + "</head>\n"
                + "<body style=\"margin: 0; padding: 0; display: flex; justify-content: center; align-items: center; height: 600px; width: 600px; background-color: #f4f4f4; color: #333; font-family: Arial, sans-serif;\">\n"
                + "<div style=\"text-align: center; padding: 20px;\">\n"
                + "    <h2>Orçamento de Casamento Pendente - DateOfLove</h2>\n"
                + "\n"
                + "    <p>Olá " + usuario.getNomesConcatenados() + ",</p>\n"
                + "\n"
                + "    <p>Seu orçamento de casamento está pendente de aprovação.</p>\n"
                + "\n"
                + "    <p>Por favor, aguarde enquanto revisamos seu orçamento. Entraremos em contato em breve com mais informações.</p>\n"
                + "\n"
                + "    <p>Atenciosamente,<br>\n"
                + "    DateOfLove<br>\n"
                + "\n"
                + "    <p style=\"color: #333; font-size: 12px;\">&copy; 2024 DateOfLove. Todos os direitos reservados.</p>\n"
                + "</div>\n"
                + "</body>\n"
                + "</html>";

        return emailBody;
    }

    public static String criarConteudoHTMLOrcamentoCancelado(Orcamentos orcamento, Usuario usuario) {

        String emailBody = "<!DOCTYPE html>\n"
                + "<html lang=\"pt-br\">\n"
                + "<head>\n"
                + "    <meta charset=\"UTF-8\">\n"
                + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                + "    <title>Orçamento de Casamento Cancelado - DateOfLove</title>\n"
                + "</head>\n"
                + "<body style=\"margin: 0; padding: 0; display: flex; justify-content: center; align-items: center; height: 600px; width: 600px; background-color: #f4f4f4; color: #333; font-family: Arial, sans-serif;\">\n"
                + "<div style=\"text-align: center; padding: 20px;\">\n"
                + "    <h2>Orçamento de Casamento Cancelado - DateOfLove</h2>\n"
                + "\n"
                + "    <p>Olá " + usuario.getNomesConcatenados() + ",</p>\n"
                + "\n"
                + "    <p>Infelizmente, seu orçamento de casamento foi cancelado.</p>\n"
                + "\n"
                + "    <p>Se precisar de mais informações ou desejar discutir este assunto, não hesite em nos contatar.</p>\n"
                + "\n"
                + "    <p>Atenciosamente,<br>\n"
                + "    DateOfLove<br>\n"
                + "\n"
                + "    <p style=\"color: #333; font-size: 12px;\">&copy; 2024 DateOfLove. Todos os direitos reservados.</p>\n"
                + "</div>\n"
                + "</body>\n"
                + "</html>";

        return emailBody;
    }

}
