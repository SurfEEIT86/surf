package controller;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendConfirmation {
	      
	private String from = "eeitsurf2gather@gmail.com";    
	private String username="eeitsurf2gather";
	private String password="eeit8623";
	private String message;
	
	public void sendMail(String to, String clientname, String ordertype){
			
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
	    	  message = "敬愛的會員 <span style='text-decoration:underline'>" +clientname +
	    			  	"</span>您好,<br>系統已收到您的"+ordertype+"。您可至網站會員專區查看訂單資訊。<br>若有任何問題歡迎與我們聯繫，期待您下次光臨。<br><br>聚浪  敬上";
	    	  mailMessage.setContent(message,  "text/html; charset=utf-8");
	    	  mailMessage.setSubject("聚浪商品網-訂單確認");	         	    	 
	    	  
	    	  Transport transport = mailSession.getTransport("smtp");
	    	  transport.connect("smtp.gmail.com", username, password);
	    	  transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
	    	  
	      }catch (MessagingException mex) {
	         mex.printStackTrace();
	      }		
	}
}
