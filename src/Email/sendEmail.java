/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Email;

import java.io.IOException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Mukhlish
 */
public class sendEmail {

    public static boolean main(String[] args) throws IOException {
        boolean status = false;
        try {

            Properties properties = new Properties();
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.ssl.enable", "true");
            properties.put("mail.smtp.port", "465");//default port dari smptp

            Session session = Session.getInstance(properties);
            session.setDebug(true);

            MimeMessage pesan = new MimeMessage(session);
            pesan.setFrom("Mukhlis.sant@gmail.com");//isi dengan gmail kalian sendiri, biasanya sama nanti dengan username
            pesan.setRecipient(Message.RecipientType.TO, new InternetAddress("mukhlish.purnomo@gmail.com"));//isi dengan tujuan email
            pesan.setSubject("Java Mail coba");
            pesan.setText("Email dikirim menggunakan Java Mail.");

            String username = "Mukhlis.sant@gmail.com"; //ganti dengan gmail kalian sendiri
            String password = "manshurin313"; //ganti dengan password kalian sendiri
            Transport.send(pesan, username, password);
            status = true;

        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
        return status;
    }
}
