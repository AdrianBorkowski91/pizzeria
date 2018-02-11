package pl.pizzeria.model;

public class PizzaProduct {
	
	private long idPizzaProduct;
	private long idElement;
	private PizzaType pizzaType;
	private float price;
	
	public PizzaProduct(long idPizzaProduct, long idElement, PizzaType pizzaType, float price) {
		this.idPizzaProduct = idPizzaProduct;
		this.idElement = idElement;
		this.pizzaType = pizzaType;
		this.price = price;
	}
	
	public PizzaProduct(){}

	public long getIdPizzaProduct() {
		return idPizzaProduct;
	}

	public void setIdPizzaProduct(long idPizzaProduct) {
		this.idPizzaProduct = idPizzaProduct;
	}

	public long getIdElement() {
		return idElement;
	}

	public void setIdElement(long idElement) {
		this.idElement = idElement;
	}

	public PizzaType getPizzaType() {
		return pizzaType;
	}

	public void setPizzaType(PizzaType pizzaType) {
		this.pizzaType = pizzaType;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "PizzaProduct [idPizzaProduct=" + idPizzaProduct + ", pizzaType=" + pizzaType + ", price=" + price + "]";
	}

}
