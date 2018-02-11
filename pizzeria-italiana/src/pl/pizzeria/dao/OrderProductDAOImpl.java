package pl.pizzeria.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import pl.pizzeria.model.OrderProduct;
import pl.pizzeria.model.OrderType;
import pl.pizzeria.util.ConnectionProvider;

public class OrderProductDAOImpl implements OrderProductDAO{

	private static final String CREATE_ORDER_OTHER_PRODUCT = 
			"INSERT INTO pizzeria.order_other_product (order_id_order, other_product_id_other_product, quantity)"
			+ " VALUES(:order_id_order, :other_product_id_other_product, :quantity); ";
	private static final String CREATE_ORDER_PIZZA = 
			"INSERT INTO pizzeria.order_pizza (order_id_order, pizza_product_id_pizza, quantity)"
			+ " VALUES(:order_id_order, :pizza_product_id_pizza, :quantity); ";
	
    private NamedParameterJdbcTemplate template;
    
    public OrderProductDAOImpl() {
        template = new NamedParameterJdbcTemplate(ConnectionProvider.getDataSource());
    }
    
	
	@Override
	public OrderProduct create(OrderProduct newObject) {
		OrderProduct resultOrderProduct= newObject;
		
		KeyHolder holder = new GeneratedKeyHolder();
        Map<String, Object> paramMap = new HashMap<String, Object>();    
        paramMap.put("order_id_order", resultOrderProduct.getIdOrder());
        paramMap.put("quantity", resultOrderProduct.getQuanity());
        
        if(newObject.getOrderType()==OrderType.OTHER) {
            paramMap.put("other_product_id_other_product", resultOrderProduct.getIdProduct());
        }
        else {
            paramMap.put("pizza_product_id_pizza", resultOrderProduct.getIdProduct());
        }
        
        SqlParameterSource paramSource = new MapSqlParameterSource(paramMap);
        int update;
        
        if(newObject.getOrderType()==OrderType.OTHER) {
        	update= template.update(CREATE_ORDER_OTHER_PRODUCT, paramSource, holder);
        }
        else {
        	update= template.update(CREATE_ORDER_PIZZA, paramSource, holder);
        }
        
        if(update > 0) {
        	resultOrderProduct.setIdOrderProduct((Long)holder.getKey());
        }
        
		return resultOrderProduct;
	}

	@Override
	public OrderProduct read(Long primaryKey) {
		return null;
	}

	@Override
	public boolean update(OrderProduct updateObject) {
		return false;
	}

	@Override
	public boolean delete(Long key) {
		return false;
	}

	@Override
	public List<OrderProduct> getAll() {
		return null;
	}

}
