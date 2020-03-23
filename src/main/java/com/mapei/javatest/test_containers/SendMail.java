//package com.mapei.javatest.test_containers;
//
//import org.springframework.mail.javamail.JavaMailSenderImpl;
//import org.springframework.mail.javamail.MimeMessageHelper;
//
//import javax.mail.*;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeBodyPart;
//import javax.mail.internet.MimeMessage;
//import javax.mail.internet.MimeMultipart;
//import java.util.Properties;
//import java.util.Stack;
//import java.util.Vector;
//
///**
// * @Author: MaPei
// * @Description:
// * @Date: Created in 2019/4/23
// */
//public class SendMail {
//    public static void main(String [] args)
//    {
//        try{
//            String userName="532621519@qq.com";
//            String password="propuhafrspnbhea";
//            String smtp_server="smtp.qq.com";
//            String from_mail_address=userName;
//            String to_mail_address="dpmapei@outlook.com";
//            Authenticator auth=new PopupAuthenticator(userName,password);
//            Properties mailProps=new Properties();
//            mailProps.setProperty("mail.transport.protocol", "smtp");
//            mailProps.setProperty("mail.smtp.host", smtp_server);
//            mailProps.setProperty("mail.smtp.auth", "true");
//            mailProps.setProperty("username", userName);
//            mailProps.setProperty("password", password);
//            mailProps.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//            mailProps.setProperty("mail.smtp.port", "465");
//            mailProps.setProperty("mail.smtp.socketFactory.port", "465");
//
//            Session mailSession=Session.getDefaultInstance(mailProps, auth);
//            mailSession.setDebug(true);
//            MimeMessage message=new MimeMessage(mailSession);
//            message.setFrom(new InternetAddress(from_mail_address));
//            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to_mail_address));
//            message.setSubject("Mail Test");
//
//            MimeMultipart multi=new MimeMultipart();
//            BodyPart textBodyPart=new MimeBodyPart();
//            textBodyPart.setText("This email is sended from java code!");
//
//            multi.addBodyPart(textBodyPart);
//            message.setContent(multi);
//            message.saveChanges();
//            // 发送信件
////       Transport.send(msg);
//            Transport transport = mailSession.getTransport();
//            if (!transport.isConnected()) {
//                transport.connect();
//            }
//            transport.sendMessage(message, message.getAllRecipients());
//            transport.close();
//        }catch(Exception ex){
//            System.err.println("邮件发送失败的原因是："+ex.getMessage());
//            System.err.println("具体的错误原因");
//            ex.printStackTrace(System.err);
//        }
//
//    }
//    static class PopupAuthenticator extends Authenticator {
//        private String username;
//        private String password;
//
//        public PopupAuthenticator(String username, String pwd) {
//            this.username = username;
//            this.password = pwd;
//        }
//
//        public PasswordAuthentication getPasswordAuthentication() {
//            return new PasswordAuthentication(this.username, this.password);
//        }
//    }
//}
