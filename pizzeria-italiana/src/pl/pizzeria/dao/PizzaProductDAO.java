package pl.pizzeria.dao;

import pl.pizzeria.model.PizzaElement;
import pl.pizzeria.model.PizzaProduct;

public interface PizzaProductDAO extends  GenericDAO<PizzaElement, Long> {
	
	PizzaProduct getPizzaProductById(Long idPizzaProduct);

}
