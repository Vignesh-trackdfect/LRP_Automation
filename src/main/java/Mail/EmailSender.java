package Mail;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

import commonMethods.Utils;

import java.io.File;
import java.util.Properties;

public class EmailSender {

    public static void sendTestSummaryEmail(String recipient, String subject, String content, String... attachments) {
        String senderMail = Utils.getDataFromTestConfig("Sender");
        String senderPassword = Utils.getDataFromTestConfig("Password");
        String provider = Utils.getDataFromTestConfig("Provider");

        // Common TLS settings
        System.setProperty("https.protocols", "TLSv1.2");
        System.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.starttls.required", "true");
        properties.put("mail.smtp.ssl.enable", "false"); // Using STARTTLS
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
        // Configure based on provider
        if ("Gmail".equalsIgnoreCase(provider)) {
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.port", "587");
        } else if ("Outlook".equalsIgnoreCase(provider)) {
            properties.put("mail.smtp.host", "smtp.office365.com");
            properties.put("mail.smtp.port", "587");
        } else {
            System.err.println("❌ Unsupported provider: " + provider);
            return;
        }

        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderMail, senderPassword);
            }
        });

//        session.setDebug(true); // Enable debug output

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderMail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
            message.setSubject(subject);

            Multipart multipart = new MimeMultipart();

            // Add HTML body
            MimeBodyPart bodyPart = new MimeBodyPart();
            bodyPart.setContent(content, "text/html");
            multipart.addBodyPart(bodyPart);

            // Add attachments if any
            if (attachments != null) {
                for (String path : attachments) {
                    if (path != null && !path.trim().isEmpty()) {
                        File file = new File(path);
                        if (file.exists() && file.isFile()) {
                            MimeBodyPart attachmentPart = new MimeBodyPart();
                            DataSource source = new FileDataSource(file);
                            attachmentPart.setDataHandler(new DataHandler(source));
                            attachmentPart.setFileName(file.getName());
                            multipart.addBodyPart(attachmentPart);
                        } else {
                            System.out.println("⚠️ Attachment not found or invalid: " + path);
                        }
                    }
                }
            }

            message.setContent(multipart);
            Transport.send(message);
            System.out.println("✅ Email sent successfully to: " + recipient);
        } catch (MessagingException e) {
            System.err.println("❌ Failed to send email:");
            e.printStackTrace();
        }
    }
}
