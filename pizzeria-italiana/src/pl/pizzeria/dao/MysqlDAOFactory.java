package pl.pizzeria.dao;

public class MysqlDAOFactory extends DAOFactory {

	@Override
	public PizzaProductDAO getPizzaProductDAO() {
		return new PizzaProductDAOImpl();
	}

	@Override
	public OtherProductDAO getOtherProductDAO() {
		return new OtherProductDAOImpl();
	}

	@Override
	public OrderDAO getOrderDAO() {
		return new OrderDAOImpl();
	}

	@Override
	public OrderProductDAO getOrderProductDAO() {
		return new OrderProductDAOImpl();
	}

}