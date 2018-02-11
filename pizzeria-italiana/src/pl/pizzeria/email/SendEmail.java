package pl.pizzeria.email;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.servlet.http.HttpServletRequest;

import pl.pizzeria.finder.NamesFinder;
import pl.pizzeria.model.OrderProduct;
import pl.pizzeria.model.OrderType;

public class SendEmail {
    private final static String MYUSERNAME = "pizzeriaitaliana.warszawa";  
    private final static String MYPASSWORD = "pizzeria2018"; 
    
    private static String EMAIL;
    private List<OrderProduct> listOrder= new ArrayList<OrderProduct>();
    private HttpServletRequest request;
    
    public SendEmail(String email, List<OrderProduct> listOrder, HttpServletRequest request) {
		EMAIL= email;	
		for (OrderProduct orderProduct : listOrder) {
			this.listOrder.add(orderProduct);
		}
		this.request=request;
	}

	public void sendFromGmail() throws AddressException, MessagingException {
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.trust", host);
        props.put("mail.smtp.user", MYUSERNAME);
        props.put("mail.smtp.password", MYPASSWORD);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);
        
        String[] to = { EMAIL };
        
        try {
            message.setFrom(new InternetAddress(MYUSERNAME));
            InternetAddress[] toAddress = new InternetAddress[to.length];

            for( int i = 0; i < to.length; i++ ) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for( int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }
            
            String orderItems="";
            double sum=0;
            double sumProduct=0;
            int index=1;
            
            NamesFinder nf= new NamesFinder(request);
            String name;
            
            DecimalFormat df=new DecimalFormat(); 
            df.setMaximumFractionDigits(2); 
            df.setMinimumFractionDigits(2); 
            
    		for (OrderProduct orderProduct : listOrder) {
    	
    			if(orderProduct.getOrderType()==OrderType.PIZZA) {
    				name=nf.findPizzaName(orderProduct.getIdProduct());			
    			}
    			else {
    				name=nf.findOtherProductName(orderProduct.getIdProduct());
    			}
    			orderProduct.getIdProduct();
    			sumProduct=orderProduct.getQuanity()*orderProduct.getPrice();
    			sum+=sumProduct;
    			orderItems+="<p style=\"color: black; margin: 0px;\">"+index+". "+name+", "+orderProduct.getQuanity()+", cena: "+df.format(sumProduct)+" z³</p>";
    			index++;
    		}
            
            String body=String.format("<div><p style=\"color: black;\">Twoje zamówienie: </p><hr>%s<hr><p style=\"color: black; margin: 0px;\">RAZEM: %.2f z³ </p><p style=\"color: black;\">Dziêkujemy! Pizzeria Italiana</p></div>", orderItems, sum);
            message.setContent(body, "text/html; charset=utf-8");
            message.setSubject("Pizzeria Italiana- ZAMÓWIENIE");

            Transport transport = session.getTransport("smtp");
            transport.connect(host, MYUSERNAME, MYPASSWORD);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (AddressException ae) {
            ae.printStackTrace();
        }
        catch (MessagingException me) {
            me.printStackTrace();
        }
    }
}