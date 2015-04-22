package com.sd.motoraccreditation.view.util;

import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.TemplateLoader;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;

public class EmailSenderUtil {
    public EmailSenderUtil() {
        super();
    }
    public static final String FROM_EMAIL_ID = "sdma.info@gmail.com";
    public static final String FROM_EMAIL_PWD = "sdmotoraccreditation";
    static Logger log = Logger.getLogger(EmailSenderUtil.class);

    private static Session mailSession() throws Exception {
        log.info("inside mailSession()");
        Properties props = System.getProperties();
        props.put("mail.smtp.password", FROM_EMAIL_PWD);
        props.put("mail.debug", "true");
        props.put("mail.smtp.user", FROM_EMAIL_ID);
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.verbose", "true");
        props.put("mail.disable", "false");
        props.put("mail.transport.protocol", "smtp");
        props.list(System.out);
        Session session = Session.getInstance(props, new SmtpAuthenticator());
        log.info("inside mailSession() session=" + session);
        return session;
    }

    /**
     * Generates the Message for Email
     * @param subject
     * @param body
     * @param to
     * @return
     */
    protected static Message createMessage(String subject, String body, String to) {
        log.info("Start executing createMessage() subject=" + subject + ";; body=" + body + ";; to=" + to);
        Message gMsg = null;
        try {
            gMsg = new MimeMessage(mailSession());
            InternetAddress frm = new InternetAddress(FROM_EMAIL_ID, "Show Distribution Co.");
            gMsg.setFrom(frm); // Set From Address
            gMsg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
            gMsg.setSubject(subject); // Set Subject line
            gMsg.setSentDate(new Date()); // Set Sent Date
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        // Content is stored in a MIME multi-part message
        // with one body part
        MimeBodyPart mbp = new MimeBodyPart();

        try {
            if (body.contains("<html>") || body.contains("<HTML>")) {
                mbp.setContent(body, "text/html");
            } else {
                //MimeBodyPart mbp = msg.getContent();
                mbp.setText(body);
            } // Set Body Text
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        Multipart msgBody = new MimeMultipart("related");
        try {
            msgBody.addBodyPart(mbp);
            gMsg.setContent(msgBody); // Attach Body Part to Message
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        log.info("End of mailSession() gMsg=" + gMsg);
        return gMsg;
    }

    public static java.lang.String sendEmail(java.lang.String to, java.lang.String cc, java.lang.String bcc, java.lang.String subject, java.lang.String msgStr) {
        log.info("Start executing createMessage() to=" + to + ";; subject=" + subject + ";; msgStr=" + msgStr);
        String mailStatus = null;
        Message message = null;
        try {
            message = createMessage(subject, msgStr, to);
            Transport.send(message);
            mailStatus = "sent";
        } catch (MessagingException me) {
            me.printStackTrace();
            mailStatus = "sendFailed with " + me.getMessage();
        }
        log.info("sendEmail() mailStatus: " + mailStatus);
        return mailStatus;
    }

    private static Template getFreemakerTemplate(String templatePath) {
        Template template = null;

        Configuration cfg = new Configuration();
        TemplateLoader templateLoader = new ClassTemplateLoader(EmailSenderUtil.class, "/");
        cfg.setTemplateLoader(templateLoader);
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);

        try {
            template = cfg.getTemplate(templatePath);
        } catch (IOException e) {
            System.out.println("Error Getting Template" + e);
        }
        return template;
    }

    public static String processFreemakerTemplate(Map rootMap, String templatePath) {
        Template template = getFreemakerTemplate(templatePath);
        if (template == null) {
            return null;
        }
        Writer writer = new StringWriter();
        try {
            template.process(rootMap, writer);
        } catch (TemplateException e) {
            System.out.println("Error Processing Template" + e);
        } catch (IOException e) {
            System.out.println("Error Processing Template" + e);
        }
        return writer.toString();
    }

    public void sendWelcomeEmployeeEmail(String toEmail, String userName) {
        Map rootMap = new HashMap();
        rootMap.put("emailTitle", "*** Welcome to Show Distribution ***");
        String emailHtmlTemplate = processFreemakerTemplate(rootMap, "");
        sendEmail(toEmail, null, null, userName + " - Welcome Alert", emailHtmlTemplate);
    }

    public static void sendLostPasswordRequestEmail(String toEmail) {
        String subject = "MAP lost password request";
        String mailBody = "MAP lost password request : includes all details";
        sendEmail(toEmail, null, null, subject, mailBody);
        sendEmail("santosh.mudududla@keste.com", null, null, subject, mailBody);
    }

    static class SmtpAuthenticator extends Authenticator {
        public SmtpAuthenticator() {

            super();
        }

        @Override
        public PasswordAuthentication getPasswordAuthentication() {
            String username = FROM_EMAIL_ID;
            String password = FROM_EMAIL_PWD;
            if ((username != null) && (username.length() > 0) && (password != null) && (password.length() > 0)) {

                return new PasswordAuthentication(username, password);
            }

            return null;
        }
    }
}

