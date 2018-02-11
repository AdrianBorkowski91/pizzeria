package pl.pizzeria.service;

import java.util.List;

import pl.pizzeria.dao.DAOFactory;
import pl.pizzeria.dao.PizzaProductDAO;
import pl.pizzeria.model.PizzaElement;

public class PizzaProductService {
    
   public static List<PizzaElement> getAllPizzaElement() {
       DAOFactory factory = DAOFactory.getDAOFactory();
       PizzaProductDAO pizzaProductDao = factory.getPizzaProductDAO();
       List<PizzaElement> listPizzaProduct = pizzaProductDao.getAll();
       return listPizzaProduct;
   }	

}
