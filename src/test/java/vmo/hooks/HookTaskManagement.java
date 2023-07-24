package vmo.hooks;


import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.environment.SystemEnvironmentVariables;
import net.thucydides.core.util.EnvironmentVariables;
import vmo.openurl.NavigateTo;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;
import javax.activation.DataSource;

public class HookTaskManagement {
    private static boolean beforeGroup = false;
    private static boolean beforeFeature = false;

    @Steps
    NavigateTo navigateTo;
    @Steps
    Login login;

    @Before()
    public void login() {
        if (!beforeFeature) {
            navigateTo.openBrowser();
            login.loginSuccess();
            beforeFeature = true;
        }
    }

    public void tearDown() {
        sendPDFReportByGMail("hoanghaohoa321@gmail.com", "hoangkm@197", "hoangkm197@gmail.com", "PDF Report", "Test");

    }

    private static void sendPDFReportByGMail(String from, String pass, String to, String subject, String body) {

        Properties props = System.getProperties();

        String host = "smtp.gmail.com";

        props.put("mail.smtp.starttls.enable", "true");

        props.put("mail.smtp.host", host);

        props.put("mail.smtp.user", from);

        props.put("mail.smtp.password", pass);

        props.put("mail.smtp.port", "587");

        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);

        MimeMessage message = new MimeMessage(session);

        try {

            //Set from address

            message.setFrom(new InternetAddress(from));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

        //Set subject

            message.setSubject(subject);

            message.setText(body);

            BodyPart objMessageBodyPart = new MimeBodyPart();

            objMessageBodyPart.setText("Please Find The Attached Report File!");

            Multipart multipart = new MimeMultipart();

            multipart.addBodyPart(objMessageBodyPart);

            objMessageBodyPart = new MimeBodyPart();

        //Set path to the pdf report file

//            String filename = System.getProperty("user.dir") + "\\Default test.pdf";
            String filename ="C:\\Tìm hiểu Automation test basic.pptx";

        //Create data source to attach the file in mail

            DataSource source = new FileDataSource(filename);

            objMessageBodyPart.setDataHandler(new DataHandler(source));

            objMessageBodyPart.setFileName(filename);

            multipart.addBodyPart(objMessageBodyPart);

            message.setContent(multipart);

            Transport transport = session.getTransport("smtp");

            transport.connect(host, from, pass);

            transport.sendMessage(message, message.getAllRecipients());

            transport.close();

        } catch (AddressException ae) {

            ae.printStackTrace();

        } catch (MessagingException me) {

            me.printStackTrace();

        }

    }

    @After()
    public static void sendMail() throws MessagingException {
        //Recipient's Mail id
        String receipientTo = "hoangkm197@gmail.com";

        //Sender's Mail id
        String senderFrom = "hoanghaohoa321@gmail.com";

        //Path of PDF test report
        String path = "C:\\Tìm hiểu Automation test basic.pptx";

        //Getting System properties
        Properties prop = System.getProperties();

        //Setting up smtp host
        prop.setProperty("mail.smtp.host", "smtp.gmail.com");

        //Creating a new session for smtp
        Session session = Session.getDefaultInstance(prop);

        MimeMessage msg = new MimeMessage(session);

        //Instance of From Internet address
        InternetAddress frmAddress = new InternetAddress(senderFrom);

        //Instance of To Internet address
        InternetAddress toAddress = new InternetAddress(receipientTo);

        //Setting up sender's address
        msg.setFrom(frmAddress);

        //Setting up recipient's address
        msg.addRecipient(Message.RecipientType.TO, toAddress);

        //Setting email's subject
        msg.setSubject("Test Status Report");

        BodyPart msgBody = new MimeBodyPart();

        //Setting email's message body
        msgBody.setText("This is test report through mail");

        //Instance of second part
        Multipart multiPart = new MimeMultipart();

        multiPart.addBodyPart(msgBody);

        //Another mail body
        msgBody = new MimeBodyPart();

        //Path to pdf file for attachment
        DataSource source = new FileDataSource(path);

        DataHandler dataHandler = new DataHandler(source);

        msgBody.setDataHandler(dataHandler);

        msgBody.setFileName(path);

        multiPart.addBodyPart(msgBody);

        msg.setContent(multiPart);

        //Authentication and connection establishment to the sender's mail
        Transport transport = session.getTransport("smtps");
        transport.connect("smtp.gmail.com",465,"hoanghaohoa321@gmail.com","hoangkm@197");
        transport.sendMessage(msg, msg.getAllRecipients());
        transport.close();

        System.out.println("Mail Sent");

    }
}
