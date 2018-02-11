package pl.pizzeria.service;

import java.util.ArrayList;
import java.util.List;

import pl.pizzeria.dao.DAOFactory;
import pl.pizzeria.dao.OrderDAO;
import pl.pizzeria.dao.OrderProductDAO;
import pl.pizzeria.model.Order;
import pl.pizzeria.model.OrderProduct;

public class OrderService {
	
	public static Order addOrder(Order order) {
        DAOFactory factory = DAOFactory.getDAOFactory();
        OrderDAO orderDao = factory.getOrderDAO();
        order= orderDao.create(order);
        return order;
    }
	
	public static List<OrderProduct> addOrderProducts(List<OrderProduct> listOrderProducts) {
        DAOFactory factory = DAOFactory.getDAOFactory();
        OrderProductDAO orderProductDao = factory.getOrderProductDAO();
        
        List<OrderProduct> newListProduts= new ArrayList<OrderProduct>();
        
        for (OrderProduct orderProduct : listOrderProducts) {
            OrderProduct newOrderProduct= orderProductDao.create(orderProduct);
            newListProduts.add(newOrderProduct);
		}
        return newListProduts;
    }
}
