package vmo.hooks;


import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.*;
import io.cucumber.java.After;

import java.io.IOException;

public class HookSendEmail {
    public void sendMail() throws IOException {
        Email from = new Email("hoangkm197@gmail.com");
//        Email to = new Email("matthew@<REDACTED>"); // use your own email address here
        Email to = new Email("hoangkm@vmogroup.com"); // use your own email address here

        String subject = "Sending with Twilio SendGrid is Fun";
        Content content = new Content("text/html", "and <em>easy</em> to do anywhere with <strong>Java</strong>");

        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
        Request request = new Request();

        request.setMethod(Method.POST);
        request.setEndpoint("mail/send");
        request.setBody(mail.build());

        Response response = sg.api(request);

        System.out.println("aaaaaaaaaaaaaaaaaa"+response.getStatusCode());
        System.out.println(response.getHeaders());
        System.out.println(response.getBody());
    }
}
