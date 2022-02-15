package org.thibaut.thelibrary.brokerconsumer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.thibaut.thelibrary.model.SimpleMailMessageDTO;
import org.thibaut.thelibrary.service.EmailService;

import java.io.IOException;

import static org.thibaut.thelibrary.config.BrokerConfig.QUEUE_LOAN_CONFIRMATION;
import static org.thibaut.thelibrary.config.BrokerConfig.QUEUE_LOAN_OVERDUE;

@Slf4j
@Component
@AllArgsConstructor
public class Consumer {

	private EmailService emailService;
	private JavaMailSender emailSender;


	@RabbitListener(queues = QUEUE_LOAN_CONFIRMATION )
	public void sendLoanConfirmation( SimpleMailMessageDTO message ) throws IOException {
		log.info("Received LOAN CONFIRMATION EMAIL <" + message.toString() + ">");
		try {
			emailService.sendSimpleMessage( message.getTo( ), message.getSubject(), message.getText() );
			log.info( "Email sent to "+ message.getTo( ) + " !" );
		} catch ( MailException e ) {
			e.printStackTrace( );
		}
	}

	@RabbitListener(queues = QUEUE_LOAN_OVERDUE )
	public void sendLoanOverdueReminder( SimpleMailMessageDTO message ) throws IOException {
		log.info("Received LOAN OVERDUE REMINDER EMAIL<" + message.toString() + ">");
		try {
			emailService.sendSimpleMessage( message.getTo( ), message.getSubject(), message.getText() );
			log.info( "Email sent to "+ message.getTo( ) + " !" );
		} catch ( MailException e ) {
			e.printStackTrace( );
		}
	}

}
