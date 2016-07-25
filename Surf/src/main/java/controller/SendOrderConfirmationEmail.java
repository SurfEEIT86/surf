package controller;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendOrderConfirmationEmail {
	
	 public void sendMail() {
	      
		 InternetAddress[] address = null ;
	      
	      //response.setContentType("text/html;charset=Big5");
	      
	       String mailserver   = "localhost:8080";
	       String From         = "idontknow7885@hotmail.com";
	       String to           = "jeffhwang7885@gmail.com";  
	       String Subject      = "contact us mail";	       	      
	       	      	       
	       String messageText  = "Hello";        
	              boolean sessionDebug = false;
	            try {
	               // 設定所要用的Mail 伺服器和所使用的傳送協定
	               java.util.Properties props = System.getProperties();
	               props.put("mail.host",mailserver);
	               props.put("mail.transport.protocol","smtp");
	               
	               // 產生新的Session 服務
	               javax.mail.Session mailSession = javax.mail.Session.getDefaultInstance(props,null);
	               mailSession.setDebug(sessionDebug);
	              
	               Message msg = new MimeMessage(mailSession);
	               
	               // 設定傳送郵件的發信人
	               msg.setFrom(new InternetAddress(From));
	               
	               // 設定傳送郵件至收信人的信箱
	               address = InternetAddress.parse(to,false);
	               msg.setRecipients(Message.RecipientType.TO, address);
	               
	               // 設定信中的主題 
	               msg.setSubject(Subject);
	               // 設定送信的時間
	               msg.setSentDate(new Date());             
	               // 設定傳送信的MIME Type
	               msg.setText(messageText);         
	               // 送信
	               Transport.send(msg);
	                 System.out.println("傳送成功!");
	                 
	             } catch (Exception e) {//response.sendRedirect("emp_select.jsp?msg=N");
	                 e.printStackTrace();                
	        }
	     }
}
