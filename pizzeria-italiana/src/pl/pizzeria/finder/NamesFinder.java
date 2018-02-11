package pl.pizzeria.finder;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import pl.pizzeria.model.OtherProduct;
import pl.pizzeria.model.PizzaElement;

public class NamesFinder {
	
	private List<PizzaElement> listPizzaElement;
	private List<OtherProduct> listOtherProduct;
	
	@SuppressWarnings("unchecked")
	public NamesFinder(HttpServletRequest request) {
		listPizzaElement= (List<PizzaElement>) request.getSession().getAttribute("listPizzaElement");
		listOtherProduct= (List<OtherProduct>) request.getSession().getAttribute("listOtherProduct");
	}
	
	public String findPizzaName(long idElement) {
		String name="";
		
		for (PizzaElement pizzaProduct : listPizzaElement) {
			if(pizzaProduct.getIdElement()==idElement) {
				name+=pizzaProduct.getName();
			}
		}
		return name;
	}
	
	public String findOtherProductName(long idElement) {
		String name="";
		
		for (OtherProduct otherProduct : listOtherProduct) {
			if(otherProduct.getIdOtherProduct()==idElement) {
				name+=otherProduct.getElement().getName();
			}
		}
		return name;
	}
}
