package com.example.demo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//Using Primary annotation
//@Primary 
@Qualifier("smtp")
@Component
public class SmtpMailSender implements MailSender {

	@Override
	public String emailService() {
		return "Sending SMTP Mail";
	}

}
