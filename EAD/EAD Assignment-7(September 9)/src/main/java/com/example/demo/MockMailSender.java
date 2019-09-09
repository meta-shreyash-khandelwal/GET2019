package com.example.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Qualifier("mock")
@Component
public class MockMailSender implements MailSender {

	@Override
	public String emailService() {
		return "Writing Mail Contents";
	}

}
