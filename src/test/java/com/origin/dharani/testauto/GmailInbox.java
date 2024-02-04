package com.origin.dharani.testauto;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMessage;

 

public class GmailInbox {
    public static void main(String[] args) {
        GmailInbox gmail = new GmailInbox();
        System.out.println(gmail.read());
    }
    public String read() {
    	String emailSubject;
    	Message emailMessage;
    	String otpExtract ="";
        Properties props = new Properties();
        try {
            props.load(new FileInputStream(new File("smtp.properties")));
            Session session = Session.getDefaultInstance(props, null);
            Store store = session.getStore("imaps");
            store.connect("smtp.gmail.com", "automation_directuser@originlearning.com", "0R1autoDi6");
            Folder inbox = store.getFolder("inbox");
            inbox.open(Folder.READ_WRITE);
            int messageCount = inbox.getMessageCount();
            System.out.println("Total Messages:- " + messageCount);
            Message[] messages = inbox.getMessages();
            System.out.println("------------------------------");
            emailMessage = inbox.getMessage(messageCount);
	        emailSubject = emailMessage.getSubject();
	        String otpPart = null; 
	        for (int i = messageCount-1; i >= 0; i--) {
                System.out.println("Mail Subject:- " + messages[i].getSubject());
         //       System.out.println("Text: " + messages[i].getContent());
                String actualSub = messages[i].getSubject();
                //String expectedSub = "Reset Password";
                String expectedSubFor = "Forgot Password";
                if(actualSub.equalsIgnoreCase(expectedSubFor)) {
                	//System.out.println("Got it--------------------------------------------------------------");
                	Object mp = (Object) messages[i].getContent();
                	
	                System.out.println("mp: " + mp);
	               /* if (mp instanceof String)  
	                {
	                    String body = (String)mp;
	                    
	                    System.out.println("--------------------------------------------------------------");
	                    System.out.println("MSG Body : " + body);
	                    System.out.println("--------------------------------------------------------------");
	                } */
	                if(mp instanceof Multipart)  
	                {  
	                    Multipart mpp = (Multipart)mp;
	                    final BodyPart bp = mpp.getBodyPart(0);
	                    System.out.println("Text: " +bp.getContent().toString());
	                    otpPart = bp.getContent().toString();
	                }/*else {
	                    System.out.println("Inside else");
	                    Multipart mpp = (Multipart)mp;
	                    final BodyPart bp = mpp.getBodyPart(0);
	                    System.out.println("Text: " +bp.getContent().toString());
	                }*/
	                break;
                }  
            }
	        //
            System.out.println("--------------------------------------------------------------");
            System.out.println(otpPart);
            String[] arrayData = otpPart.split(":");
            for (String e : arrayData) {
				System.out.println(e);
			}
            otpExtract = arrayData[1].substring(1, 8);
            System.out.println("-----------------------------OTP---------------------------------"+otpExtract);
            System.out.println("--------------------------------------------------------------");
           //
	        inbox.close(true);
            store.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return otpExtract;
    }
}
