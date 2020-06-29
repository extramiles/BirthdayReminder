package com.soprasteria.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.soprasteria.service.EmployeeService;
import com.soprasteria.service.TeamService;

//@Controller
public class MailController {
    
	@Autowired
	private EmployeeService employeeService;
	
	@Scheduled(fixedRate = 10000)
    public void sendReminder() throws IOException{
       System.out.println("<<<<<<<<<<<<<started>>>>>>>>>"); 
       
       List<Integer> employee_id = new ArrayList<Integer>();

       employee_id=employeeService.getEmail();
       List<String> emailTo =new ArrayList<String>();
       for(Integer emp:employee_id) {
    	   
    	   emailTo =employeeService.getTeamEmail(emp);
    	   
    	   
       }
       
       String res = String. join(",", emailTo);
       
       String to = "amit777bhandari@gmail.com";

       // Sender's email ID needs to be mentioned
       String from = "amit.bhandari@soprasteria.com";

       // Assuming you are sending email from localhost
       String host = "ptx.send.corp.sopra";

       // Get system properties
       Properties properties = System.getProperties();

       // Setup mail server
       properties.setProperty("mail.smtp.host", host);
       properties.put("mail.smtp.user", from);
       properties.put("mail.smtp.password", "password");
       properties.put("mail.smtp.port", "587");
       properties.put("mail.smtp.auth", "true");
       // Get the default Session object.
       Session session = Session.getDefaultInstance(properties);

       try {
          // Create a default MimeMessage object.
          MimeMessage message = new MimeMessage(session);

          // Set From: header field of the header.
          message.setFrom(new InternetAddress(from));

          // Set To: header field of the header.
          message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(res));

          // Set Subject: header field
          message.setSubject("This is the Subject Line!");
          
          String emailContent = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir")+"//src//main//resources//static//BirthdayTemplate.html")));
          
          emailContent =emailContent.replace("$Name", "Amit");
          
          // Now set the actual message
          message.setContent(
        		  emailContent,
                 "text/html");

          
          Transport transport = session.getTransport("smtp");
          transport.connect("ptx.send.corp.sopra","amit.bhandari@soprasteria.com", "password");
          transport.sendMessage(message, message.getAllRecipients());
          // Send message
          //Transport.send(message);
          System.out.println("Sent message successfully....");
       } catch (MessagingException mex) {
          mex.printStackTrace();
       }
    }

    @RequestMapping(value="/email")
    public String email(){
        return "emailMessage";
    }
}
