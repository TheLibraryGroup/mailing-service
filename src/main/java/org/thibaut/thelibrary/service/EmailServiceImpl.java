package org.thibaut.thelibrary.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmailServiceImpl implements EmailService {

	public JavaMailSender emailSender;

	@Override
	public void sendSimpleMessage( String to, String subject, String text ) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		emailSender.send(message);
	}

	@Override
	public void sendSimpleMessageUsingTemplate( String to, String subject, SimpleMailMessage template, String... templateArgs ) {

	}

	@Override
	public void sendMessageWithAttachment( String to, String subject, String text, String pathToAttachment ) {

	}
}
