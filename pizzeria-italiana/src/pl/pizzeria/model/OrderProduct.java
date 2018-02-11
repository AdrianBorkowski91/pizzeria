package pl.pizzeria.model;

public class OrderProduct {
	
	private OrderType orderType;
	private long idOrderProduct;
	private long idOrder;
	private long idProduct;
	private float price;
	private int quanity;
	
	public OrderProduct(OrderType orderType, long idOrder, long idProduct, float price, int quanity){
		this.orderType=orderType;
		this.idOrder=idOrder;
		this.idProduct=idProduct;
		this.price= price;
		this.quanity=quanity;
	}
	
	public OrderProduct(){}

	public long getIdOrderProduct() {
		return idOrderProduct;
	}

	public void setIdOrderProduct(long idOrderProduct) {
		this.idOrderProduct = idOrderProduct;
	}

	public OrderType getOrderType() {
		return orderType;
	}

	public void setOrderType(OrderType orderType) {
		this.orderType = orderType;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public long getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(long idOrder) {
		this.idOrder = idOrder;
	}

	public long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(long idProduct) {
		this.idProduct = idProduct;
	}

	public int getQuanity() {
		return quanity;
	}

	public void setQuanity(int quanity) {
		this.quanity = quanity;
	}

	@Override
	public String toString() {
		return "OrderProduct [orderType=" + orderType + ", idOrder=" + idOrder + ", idProduct=" + idProduct + ", price="
				+ price + ", quanity=" + quanity + "]";
	}
	
}
