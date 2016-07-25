package controller;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendConfirmation {
	
	private String to; 	      
	private String from = "eeitsurf2gather@gmail.com";    
	private String username="eeitsurf2gather";
	private String password="eeit8623";
	private String message;
	
	public void sendMail(){
			
	      try{      
		      Properties properties = System.getProperties();		 		      
		      properties.put("mail.smtp.host", "smtp.gmail.com");
		      properties.put("mail.smtp.auth", "true");
		      properties.put("mail.smtp.port", "465");
		      properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		      properties.put("mail.smtp.socketFactory.port", "465");
		      properties.put("mail.smtp.socketFactory.fallback", "false");
		 	      
		      Session mailSession = Session.getDefaultInstance(properties, null);
		      mailSession.setDebug(true);
		      Message mailMessage = new MimeMessage(mailSession);	        	         	        
	    	  mailMessage.setFrom(new InternetAddress(from));        
	    	  mailMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
	    	  mailMessage.setContent(message, "text/html" );
	    	  mailMessage.setSubject("聚浪商品網-訂單確認");	         	    	 
	    	  
	    	  Transport transport = mailSession.getTransport("smtp");
	    	  transport.connect("smtp.gmail.com", username, password);
	    	  transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
	    	  
	        
	      }catch (MessagingException mex) {
	         mex.printStackTrace();
	      }		
	}
}
