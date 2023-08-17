package com.email.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.email.entities.EmailDetails;

@Service
public class EmailService {
	@Autowired
	private JavaMailSender javaMailSender;
	@Value("${spring.mail.username}")
	private String sender;

	public boolean sendMail(EmailDetails details) {
		boolean f = true;
		try {
			// Creating a simple mail message
			SimpleMailMessage mailMessage = new SimpleMailMessage();

			// Setting up necessary details
			mailMessage.setFrom(sender);
			mailMessage.setTo(details.getRecipient());
			mailMessage.setText(details.getMsg());
			mailMessage.setSubject(details.getSubject());
			javaMailSender.send(mailMessage);
			System.out.println("Done Sending mail");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return f;
	}

//	public boolean sendEmail(String subject, String message, String to)
//			throws AddressException, MessagingException, IOException {
//		boolean f = false;
//		String from = "tanusoni6563@gmail.com";
//		Properties props = new Properties();
//		props.put("mail.smtp.auth", "true");
//		props.put("mail.smtp.starttls.enable", "true");
//		props.put("mail.smtp.host", "smtp.gmail.com");
//		props.put("mail.smtp.port", "587");
//
//		Session session = Session.getInstance(props, new Authenticator() {
//			@Override
//			protected PasswordAuthentication getPasswordAuthentication() {
//				// TODO Auto-generated method stub
//				return new PasswordAuthentication("tanusoni6563@gmail.com", "Tanu@123#!##");
//			}
//		});
//		session.setDebug(true);
//		Message msg = new MimeMessage(session);
//		try {
//			msg.setFrom(new InternetAddress(from, false));
//			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//			msg.setSubject(subject);
//			msg.setText(message);
//			msg.setSentDate(new Date());
//			Transport.send(msg);
//			System.out.println("Done");
//			f = true;
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		return f;
//	}
}
