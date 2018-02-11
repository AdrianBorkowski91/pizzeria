package pl.pizzeria.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import pl.pizzeria.model.Order;
import pl.pizzeria.util.ConnectionProvider;

public class OrderDAOImpl implements OrderDAO{
	
	private static final String CREATE_ORDER = 
			"INSERT INTO pizzeria.order (personal_data, phone, email, newsletter, street, house_number, apartment_number, zip_code, city,"
			+ " comments) VALUES(:personal_data, :phone, :email, :newsletter, :street, :house_number, "
			+ ":apartment_number, :zip_code, :city, :comments);";

    private NamedParameterJdbcTemplate template;
    
    public OrderDAOImpl() {
        template = new NamedParameterJdbcTemplate(ConnectionProvider.getDataSource());
    }
    
	@Override
	public Order create(Order newObject) {
		Order resultOrder= newObject;

		KeyHolder holder = new GeneratedKeyHolder();
        Map<String, Object> paramMap = new HashMap<String, Object>();    
        paramMap.put("personal_data", resultOrder.getPersonalData());
        paramMap.put("phone", resultOrder.getPhone());
        paramMap.put("email", resultOrder.getEmail());
        paramMap.put("newsletter", "true");
        paramMap.put("street", resultOrder.getStreet());
        paramMap.put("house_number", resultOrder.getHouseNumber());
        paramMap.put("apartment_number", resultOrder.getApartmentNumber());
        paramMap.put("zip_code", resultOrder.getZipCode());
        paramMap.put("city", resultOrder.getCity());
        paramMap.put("comments", resultOrder.getComment());

        
        SqlParameterSource paramSource = new MapSqlParameterSource(paramMap);
        int update= template.update(CREATE_ORDER, paramSource, holder);
        if(update > 0) {
        	resultOrder.setIdOrder((Long)holder.getKey());
        }

    return resultOrder;
	}
	
	@Override
	public Order read(Long primaryKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Order updateObject) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Long key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Order> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
