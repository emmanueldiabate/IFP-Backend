package com.kalanso2manu.IdeeFinancementProjet.Message;

import com.kalanso2manu.IdeeFinancementProjet.Modeles.AnnonceurExpert;
import com.kalanso2manu.IdeeFinancementProjet.Modeles.Projets;
import com.kalanso2manu.IdeeFinancementProjet.Modeles.Utilisateurs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Component
public class EmailConstructor {

        @Autowired
        private Environment env;

        @Autowired
        private TemplateEngine templateEngine;

        public MimeMessagePreparator constructpossibleFinancementProjet(Utilisateurs utilisateur, Projets projets) {
            Context context = new Context();
            context.setVariable("utilisateur", utilisateur);
            context.setVariable("projets", projets);
            String text = templateEngine.process("PossibleFinancementEmailTemplate", context);
            MimeMessagePreparator messagePreparator = new MimeMessagePreparator() {
                @Override
                public void prepare(MimeMessage mimeMessage) throws Exception {
                    MimeMessageHelper email = new MimeMessageHelper(mimeMessage);
                    email.setPriority(1);
                    email.setTo(utilisateur.getEmail());
                    email.setSubject("Potencialité de financenement de projet");
                    email.setText(text, true);
                    email.setFrom(new InternetAddress(env.getProperty("support.email")));
                }
            };
            return messagePreparator;
        }


 /*    @Component
    public class EmailConstructor {

        @Autowired
        private Environment env;

        @Autowired
        private TemplateEngine templateEngine;

        public MimeMessagePreparator constructAssignerTacheEmail(User utilisateur, Tache tache) {
            Context context = new Context();
            context.setVariable("utilisateur", utilisateur);
            context.setVariable("tache", tache);
            String text = templateEngine.process("AssignerTacheEmailTemplate", context);
            MimeMessagePreparator messagePreparator = new MimeMessagePreparator() {
                @Override
                public void prepare(MimeMessage mimeMessage) throws Exception {
                    MimeMessageHelper email = new MimeMessageHelper(mimeMessage);
                    email.setPriority(1);
                    email.setTo(utilisateur.getEmail());
                    email.setSubject("Assiner Tache sur ODC Events");
                    email.setText(text, true);
                    email.setFrom(new InternetAddress(env.getProperty("support.email")));
                }
            };
            return messagePreparator;
        }

        public MimeMessagePreparator constructResetPasswordEmail(User utilisateur, String password) {
            Context context = new Context();
            context.setVariable("utilisateur", utilisateur);
            context.setVariable("password", password);
            String text =
                    templateEngine.process("resetPasswordEmailTemplate", context);
            MimeMessagePreparator messagePreparator = new MimeMessagePreparator() {
                @Override
                public void prepare(MimeMessage mimeMessage) throws Exception {
                    MimeMessageHelper email = new MimeMessageHelper(mimeMessage);
                    email.setPriority(1);
                    email.setTo(utilisateur.getEmail());
                    email.setSubject("Nouveau mots de passe - ODC Events");
                    email.setText(text, true);
                    email.setFrom(new InternetAddress(env.getProperty("support.email")));
                }
            };
            return messagePreparator;
        }

        public MimeMessagePreparator constructUpdateUserProfileEmail(User utilisateur) {
            Context context = new Context();
            context.setVariable("utilisateur", utilisateur);
            String text = templateEngine.process("updateUserProfileEmailTemplate", context);
            MimeMessagePreparator messagePreparator = new MimeMessagePreparator() {
                @Override
                public void prepare(MimeMessage mimeMessage) throws Exception {
                    MimeMessageHelper email = new MimeMessageHelper(mimeMessage);
                    email.setPriority(1);
                    email.setTo(utilisateur.getEmail());
                    email.setSubject("Profile Modifié - ODC Events");
                    email.setText(text, true);
                    email.setFrom(new InternetAddress(env.getProperty("support.email")));
                }
            };
            return messagePreparator;
        }
    }
   @Configuration
    @EnableJavaMailSender
    public class EmailConfig {

        @Value("${spring.mail.host}")
        private String host;

        @Value("${spring.mail.port}")
        private int port;

        @Value("${spring.mail.username}")
        private String username;

        @Value("${spring.mail.password}")
        private String password;

        @Bean
        public JavaMailSender javaMailSender() {
            JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
            mailSender.setHost(host);
            mailSender.setPort(port);
            mailSender.setUsername(username);
            mailSender.setPassword(password);

            Properties props = mailSender.getJavaMailProperties();
            props.put("mail.transport.protocol", "smtp");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.debug", "true");

            return mailSender;
        }
    }*/

}
