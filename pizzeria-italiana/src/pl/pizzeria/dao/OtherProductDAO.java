package pl.pizzeria.dao;

import pl.pizzeria.model.OtherProduct;

public interface OtherProductDAO extends  GenericDAO<OtherProduct, Long> {

	OtherProduct getOtherProductById(Long idOtherProduct);
	
}


