package com.cg.capstore.shippingdetailscontroller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.capstore.beans.CustomerBean;
import com.cg.capstore.beans.OrderBean;
import com.cg.capstore.shippingdetailsservice.IShippingDetailsService;

@RestController
public class ShippingDetailsController {

	@Autowired
	private IShippingDetailsService service;
	
	@Autowired
	private JavaMailSender sender;

	 @RequestMapping("/simpleemail")
	    public String home(String email) {
		 
		 System.err.println("given:"+email);
	         try {
	        	 System.err.println(service.shippingDetailsMsg(email));
	            String customerEmail=service.shippingDetailsMsg(email).getEmail();
	         //   sendEmail(customerEmail);
	             return "Email Sent! to "+customerEmail;
	         }catch(Exception ex) {
	             return "Error in sending email: "+ex;
	         }
	     }

	     private void sendEmail(String customerEmail) throws Exception{
	         MimeMessage message = sender.createMimeMessage();
	         MimeMessageHelper helper = new MimeMessageHelper(message);
	         CustomerBean customer=service.shippingDetailsMsg(customerEmail);
	         OrderBean order=customer.getOrder();
	         helper.setTo(customerEmail);
	         helper.setText("Hello" +customer.getCustomerName() +",\n Your delivery date is on" +order.getDeliveryDate()
	         +"\n Your order will be send to the address:\n" +customer.getAddress() );
	         helper.setSubject("Hi");
	         sender.send(message);
	     }

}
