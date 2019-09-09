package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {

	private MailSender mailSender;

//	/*Constructor dependency injection for primary*/
//	 @Autowired
//	 public EmailController(MailSender mailSender)
//	 { this.mailSender=mailSender; }
//	 
//	
	
// //Dependency Injection by Name using constructor injection	
//	@Autowired
//	/* Setter injection using qualifier */
//	public EmailController(MailSender smtpMailSender) {
//		this.mailSender = smtpMailSender;
//	}
	
//	//Dependency Injection by Name using constructor injection 
//	@Autowired
//	/* Setter injection using qualifier */
//	public EmailController(MailSender mockMailSender) {
//		this.mailSender = mockMailSender;
//	}	
	

//	/*Constructor dependency injection by Qualifier*/
//	 @Autowired
//	 public EmailController(@Qualifier("mock") MailSender mailSender)
//	 { this.mailSender=mailSender; }


//	/*Setter dependency injection by Name*/
//	@Autowired
//	public void setMailSender(MailSender mockMailSender)
//	{
//		this.mailSender=mockMailSender;
//	}
	
//	/*Setter dependency injection by Name*/
//	@Autowired
//	public void setMailSender(MailSender smtpMailSender)
//	{
//		this.mailSender=smtpMailSender;
//	}
	
	
//	/*Setter dependency injection by Primary*/
//	@Autowired
//	public void setMailSender(MailSender mailSender)
//	{
//		this.mailSender=mailSender;
//	}
	
	/*Setter dependency injection by Qualifier*/
	@Autowired
	public void setMailSender(@Qualifier("mock") MailSender mailSender)
	{
		this.mailSender=mailSender;
	}
	
	

	@GetMapping
	public String showEmail() {
		return mailSender.emailService();
	}

}
