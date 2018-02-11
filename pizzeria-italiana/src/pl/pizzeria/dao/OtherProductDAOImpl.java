package pl.pizzeria.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import pl.pizzeria.model.OtherElement;
import pl.pizzeria.model.OtherProduct;
import pl.pizzeria.model.ProductType;
import pl.pizzeria.util.ConnectionProvider;

public class OtherProductDAOImpl implements OtherProductDAO{

    private static final String READ_ALL_OTHER_PRODUCT= 
    		"SELECT op.id_other_product, e.id_element, e.name, e.description, e.src, op.product_type_id_type_product, op.price  "
    		+ "FROM other_product op INNER JOIN element e ON op.element_id_element=e.id_element;";

    private NamedParameterJdbcTemplate template;
    
    public OtherProductDAOImpl() {
        template = new NamedParameterJdbcTemplate(ConnectionProvider.getDataSource());
    }
    
	@Override
	public OtherProduct create(OtherProduct newObject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OtherProduct read(Long primaryKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(OtherProduct updateObject) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Long key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public OtherProduct getOtherProductById(Long idOtherProduct) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<OtherProduct> getAll() {
        List<OtherProduct> otherPizzaProduct = template.query(READ_ALL_OTHER_PRODUCT, new OtherProductRowMapper());
        return otherPizzaProduct;
	}
	
    private class OtherProductRowMapper implements RowMapper<OtherProduct> {
        @Override
        public OtherProduct mapRow(ResultSet resultSet, int row) throws SQLException {
        	OtherElement element= new OtherElement();
        	element.setIdElement(resultSet.getLong("e.id_element"));
        	element.setName(resultSet.getString("e.name"));
        	element.setDescription(resultSet.getString("e.description"));  	
        	element.setSrc(resultSet.getString("e.src"));    	

        	OtherProduct otherProduct= new OtherProduct();
        	otherProduct.setElement(element);
        	otherProduct.setIdOtherProduct(resultSet.getLong("op.id_other_product"));
        	otherProduct.setProductType(ProductType.getProductType(resultSet.getLong("op.product_type_id_type_product")));
        	otherProduct.setPrice(resultSet.getFloat("op.price"));

            return otherProduct;
        }

    }
}
