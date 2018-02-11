package pl.pizzeria.model;

import java.util.ArrayList;
import java.util.List;

public class PizzaElement extends OtherElement{

	private List<PizzaProduct> listPizzaProduct;
	
	public PizzaElement() {
		listPizzaProduct= new ArrayList<>();
	}

	public List<PizzaProduct> getListPizzaProduct() {
		return listPizzaProduct;
	}

	public void setElementToList(PizzaProduct pizzaProduct) {
		listPizzaProduct.add(pizzaProduct);
	}

	@Override
	public String toString() {
		String toStringList="";
		for (PizzaProduct pizzaProduct : listPizzaProduct) {
			toStringList+=pizzaProduct.toString()+"; ";
		}
		return "Element [idElement=" + getIdElement() + ", name=" + getName() + ", description=" + getDescription() + ", src=" + getSrc() +"PizzaProduct ["+
				toStringList+ "]";
	}
	
}
