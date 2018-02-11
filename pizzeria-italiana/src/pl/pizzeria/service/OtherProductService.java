package pl.pizzeria.service;

import java.util.List;

import pl.pizzeria.dao.DAOFactory;
import pl.pizzeria.dao.OtherProductDAO;
import pl.pizzeria.model.OtherProduct;

public class OtherProductService {

	   public static List<OtherProduct> getAllOtherElement() {
	       DAOFactory factory = DAOFactory.getDAOFactory();
	       OtherProductDAO otherProductDao = factory.getOtherProductDAO();
	       List<OtherProduct> listOtherProduct = otherProductDao.getAll();
	       return listOtherProduct;
	   }


}
