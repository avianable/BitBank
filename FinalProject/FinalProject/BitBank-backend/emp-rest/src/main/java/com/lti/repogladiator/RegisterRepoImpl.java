package com.lti.repogladiator;


import java.util.Properties;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;
import javax.net.ssl.HttpsURLConnection;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;


import org.springframework.stereotype.Repository;

import com.lti.entitygladiator.Customer;
import com.lti.pojogladiator.OTP;

/**
 * 
 * @author Abhinav Anand
 *
 */
@Repository
public class RegisterRepoImpl implements RegisterRepo {

	@PersistenceContext
	private EntityManager em;

	@Transactional(value = TxType.REQUIRED)
	public void saveCustomer(Customer customer) {
		em.persist(customer);
	}

	@Transactional(value = TxType.REQUIRED)
	public Customer fetchCustomerByEmail(String email) {
		Query query = em.createNamedQuery("register");
		query.setParameter("email", email);

		Customer customer = null;
		try {

			customer = (Customer) query.getSingleResult();
		}

		catch (NoResultException nre) {

		}
		return customer;

	}

	public Customer fetchCustomerByUsernameAndPassword(String username, String password) {
		Query query = em.createNamedQuery("login");
		query.setParameter("uname", username);
		query.setParameter("pwd", password);

		Customer customer = null;
		try {

			customer = (Customer) query.getSingleResult();
		}

		catch (NoResultException nre) {

		}
		return customer;
	}

	public Customer fetchCustomerByAccNumber(int accNumber) {
		return em.find(Customer.class, accNumber);
	}

	@Transactional(value = TxType.REQUIRED)
	public void updateCustomer(Customer customer) {
		em.merge(customer);

	}

	public void sendMail(String email, String messageText) {


		String host = "smtp.gmail.com";
		String user = "bitheadlti@gmail.com";
		String pass = "bitatma123";
		String to = email;
		String from = "bitheadlti@gmail.com";
		String subject = "BitBank ";
		boolean sessionDebug = false;

		Properties props = System.getProperties();

		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.required", "true");
		
		java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
		Session mailSession = Session.getDefaultInstance(props, null);
		mailSession.setDebug(sessionDebug);
		try {
			Message msg = new MimeMessage(mailSession);
			msg.setFrom(new InternetAddress(from));
			InternetAddress[] address = { new InternetAddress(to) };
			msg.setRecipients(Message.RecipientType.TO, address);
			msg.setSubject(subject);
			msg.setSentDate(new Date());
			msg.setText(messageText);
			Transport transport = mailSession.getTransport("smtp");
			transport.connect(host, user, pass);
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();
//			System.out.println("message send successfully");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}
	
	
	public OTP sendOTP(String message, String number) {
		
		OTP otp = new OTP();
		otp.sendOTP(message, number);
		
		return otp;
		
	}

}