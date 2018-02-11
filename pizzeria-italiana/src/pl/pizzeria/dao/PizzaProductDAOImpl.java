package pl.pizzeria.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import pl.pizzeria.model.PizzaElement;
import pl.pizzeria.model.PizzaProduct;
import pl.pizzeria.model.PizzaType;
import pl.pizzeria.util.ConnectionProvider;

public class PizzaProductDAOImpl implements PizzaProductDAO{

    private static final String READ_ALL_ELEMENT= 
    		"SELECT DISTINCT e.id_element, e.name, e.description, e.src  FROM element e, pizza_product pp WHERE e.id_element=pp.element_id_element;";
    		
    private static final String READ_ALL_PIZZA_PRODUCT="SELECT pp.id_pizza, pp.pizza_type_id_type, pp.element_id_element, pp.price FROM pizza_product pp;";

    private List<PizzaElement> listElement;
    
    private NamedParameterJdbcTemplate template;
    
    public PizzaProductDAOImpl() {
        template = new NamedParameterJdbcTemplate(ConnectionProvider.getDataSource());
    }
    
	@Override
	public PizzaElement create(PizzaElement newObject) {
		return null;
	}

	@Override
	public PizzaElement read(Long primaryKey) {
		return null;
	}

	@Override
	public boolean update(PizzaElement updateObject) {
		return false;
	}

	@Override
	public boolean delete(Long key) {
		return false;
	}


	@Override
	public PizzaProduct getPizzaProductById(Long idPizzaProduct) {
		return null;
	}
	
	@Override
	public List<PizzaElement> getAll() {
        listElement = template.query(READ_ALL_ELEMENT, new ElementRowMapper());
        
        List<PizzaProduct> listPizzaProduct= template.query(READ_ALL_PIZZA_PRODUCT, new PizzaProductRowMapper());
        for (int i=0; i<listElement.size(); i++) {
			for (PizzaProduct pizzaProduct : listPizzaProduct) {
				if(listElement.get(i).getIdElement()==pizzaProduct.getIdElement()){
					listElement.get(i).setElementToList(pizzaProduct);
				}
			}
		}
        
        for (PizzaElement pizzaProduct : listElement) {
			System.out.println(pizzaProduct);
		}
        return listElement;
	}
	
    private class ElementRowMapper implements RowMapper<PizzaElement> {
        @Override
        public PizzaElement mapRow(ResultSet resultSet, int row) throws SQLException {      	 	
	        PizzaElement element= new PizzaElement();
	        element.setIdElement(resultSet.getLong("e.id_element"));
	        element.setName(resultSet.getString("e.name"));
	        element.setDescription(resultSet.getString("e.description"));  	
	        element.setSrc(resultSet.getString("e.src"));    	
	        return element;
        }
    }
    
    private class PizzaProductRowMapper implements RowMapper<PizzaProduct> {
        @Override
        public PizzaProduct mapRow(ResultSet resultSet, int row) throws SQLException {      	 	
        	PizzaProduct pizzaProduct= new PizzaProduct();
        	pizzaProduct.setIdPizzaProduct(resultSet.getLong("pp.id_pizza"));
        	pizzaProduct.setIdElement(resultSet.getLong("pp.element_id_element"));
        	pizzaProduct.setPizzaType(PizzaType.getPizzaType(resultSet.getLong("pp.pizza_type_id_type")));
        	pizzaProduct.setPrice(resultSet.getFloat("pp.price"));
	        return pizzaProduct;
        }
    }
}
