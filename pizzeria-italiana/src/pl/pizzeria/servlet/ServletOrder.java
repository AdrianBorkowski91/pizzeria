package pl.pizzeria.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.pizzeria.email.SendEmail;
import pl.pizzeria.model.Order;
import pl.pizzeria.model.OrderProduct;
import pl.pizzeria.model.OrderType;
import pl.pizzeria.service.OrderService;


@WebServlet("/ServletOrder")
public class ServletOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ServletOrder() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   request.setCharacterEncoding("utf-8");
	   String firstname= request.getParameter("firstname");
	   String lastname= request.getParameter("lastname");
	   String personalData= firstname+" "+lastname;
	   String email= request.getParameter("email"); 
	   String phone= request.getParameter("phone"); 
	   int phoneInt= Integer.parseInt(phone);
	   String street= request.getParameter("street"); 
	   String houseNumer= request.getParameter("house-numer"); 
	   String apartmentNumer= request.getParameter("apartment-numer"); 
	   String zipCode= request.getParameter("zip-code"); 
	   String city= request.getParameter("city"); 
	   String comment= request.getParameter("comment"); 
	   String newsletter= request.getParameter("newsletter"); 	   
	   boolean newsletterBool=true;

	   if(newsletter==null)
		   newsletterBool=false;
	   
	   Order order= new Order(personalData, phoneInt, email, newsletterBool, street, houseNumer, apartmentNumer, zipCode, city, comment);
	   order= OrderService.addOrder(order);

	   List<OrderProduct> listOrder= new ArrayList<OrderProduct>();
	   
	   int index=1;
	   while(request.getParameter(index+"-id")!=null) {
		   long id=0;
		   try {
		   id = Long.parseLong(request.getParameter(index+"-id"));
		   }catch(NumberFormatException e) {}
		   
		   String type = request.getParameter(index+"-type");
		   float price=0;
		   try {
			   price = Float.parseFloat(request.getParameter(index+"-price"));
		   }catch(NumberFormatException e) {}
		   
		   int quanity=0;
		   try {
		   quanity = Integer.parseInt(request.getParameter(index+"-quanity"));	   
		   }catch(NumberFormatException e) {}
		   OrderType ot= OrderType.getOrderType(type);		
		   
		   OrderProduct op= new OrderProduct(ot, order.getIdOrder(), id, price, quanity);
		   listOrder.add(op);
		   index++;
	   }
	   
	   listOrder= OrderService.addOrderProducts(listOrder);
	   
	   SendEmail se= new SendEmail(email, listOrder, request);
	   try {
		se.sendFromGmail();
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	   
	   request.setAttribute("order-confirm", "order-confirm");
	   
	   request.getRequestDispatcher("main.jsp").forward(request, response);	 
	}

}
