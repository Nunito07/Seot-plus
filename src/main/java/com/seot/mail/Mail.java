package com.seot.mail;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import jakarta.mail.BodyPart;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

public class Mail {

    private final static String KEY_SMTP_SERVER = "mail.smtp.host";
    private final static String KEY_FROM = "mail.smtp.user";
    private final static String KEY_PASSWORD = "mail.smtp.password";

    private static Properties props;

    private static void loadConfig() {

        if (props == null) {
            props = new Properties();
            props.put(KEY_SMTP_SERVER, "smtp.gmail.com"); //Servidor smtp de google
            props.put(KEY_FROM, "seotcolombia@gmail.com"); // correo destinatario
            props.put(KEY_PASSWORD, "fuerzagaes");// clave del correo destinatario
            props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
            props.put("mail.smtp.auth", "true"); // User autenticacion usuario y clave
            props.put("mail.smtp.starttls.enable", "true"); //Conexión segura al SMTP
            props.put("mail.smtp.port", "587"); //Puerto SMTP seguro de Google

        }

    }

    /*public static void sendMail(String destinatario, String asunto, String cuerpo) {

        loadConfig();
        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(props.getProperty(KEY_FROM)));
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(destinatario)); // Se podrian añadir valores de la mínima manera
            message.setSubject(asunto);
            message.setText(cuerpo);
            try (Transport transport = session.getTransport("smtp")) {
                transport.connect(props.getProperty(KEY_SMTP_SERVER),
                        props.getProperty(KEY_FROM),
                        props.getProperty(KEY_PASSWORD));
                transport.sendMessage(message, message.getAllRecipients());
            }

        } catch (MessagingException me) {
            me.printStackTrace(); // Si se produce un error
        }
    }*/
    public static void sendMail(String destinatario, String asunto, String cuerpo) {
    loadConfig();
    Session session = Session.getDefaultInstance(props);
    MimeMessage message = new MimeMessage(session);
    Transport transport = null;
    try {
        message.setFrom(new InternetAddress(props.getProperty(KEY_FROM)));
        message.addRecipient(Message.RecipientType.TO,
                new InternetAddress(destinatario)); // Se podrian añadir valores de la mínima manera
        message.setSubject(asunto);
        message.setText(cuerpo);
        transport = session.getTransport("smtp");
        transport.connect(props.getProperty(KEY_SMTP_SERVER),
                props.getProperty(KEY_FROM),
                props.getProperty(KEY_PASSWORD));
        transport.sendMessage(message, message.getAllRecipients());
    } catch (MessagingException me) {
        me.printStackTrace(); // Si se produce un error
    } finally {
        // Cerrar la conexión manualmente
        try {
            transport.close();
        } catch (MessagingException me) {
            me.printStackTrace();
        }
    }
}


    public static void sendMailHTML(String destinatarios, String asunto, String cuerpoHTML) {

        loadConfig();
        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(props.getProperty(KEY_FROM)));
            message.addRecipients(Message.RecipientType.TO,
                    destinatarios); // Se podrian añadir valores de la mínima manera
            message.setSubject(asunto);
            Multipart parts = new MimeMultipart();
            BodyPart bodyMail = new MimeBodyPart();
            bodyMail.setContent(cuerpoHTML, "text/html");
            parts.addBodyPart(bodyMail);
            message.setContent(parts);
            //TRANSPORTE DE LOS CORREOS
            Transport transport = session.getTransport("smtp");
            transport.connect(props.getProperty(KEY_SMTP_SERVER),
                    props.getProperty(KEY_FROM),
                    props.getProperty(KEY_PASSWORD));
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();

        } catch (MessagingException me) {
            me.printStackTrace(); // Si se produce un error
        }
    }

    public static void sendMailHTML(String destinatarios, String asunto, String cuerpoHTML, List<File> files) throws IOException {

        loadConfig();
        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(props.getProperty(KEY_FROM)));
            message.addRecipients(Message.RecipientType.TO,
                    destinatarios); // Se podrian añadir valores de la mínima manera
            message.setSubject(asunto);
            //MULTIPARTES
            Multipart parts = new MimeMultipart();
            BodyPart bodyMail = new MimeBodyPart();
            bodyMail.setContent(cuerpoHTML, "text/html");
            parts.addBodyPart(bodyMail);
            for(File file : files){
                MimeBodyPart attached = new MimeBodyPart();
                attached.attachFile(file);
                parts.addBodyPart(attached);
            }
            message.setContent(parts);
            //TRANSPORTE DE LOS CORREOS
            Transport transport = session.getTransport("smtp");
            transport.connect(props.getProperty(KEY_SMTP_SERVER),
                    props.getProperty(KEY_FROM),
                    props.getProperty(KEY_PASSWORD));
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();

        } catch (MessagingException me) {
            me.printStackTrace(); // Si se produce un error
        }
    }
}
