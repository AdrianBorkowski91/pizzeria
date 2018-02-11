package pl.pizzeria.model;

public enum OrderType {
	
	PIZZA(1), OTHER(2);
	
	private final long idProduct;	
	
	private OrderType(long idProduct) {
		this.idProduct= idProduct;
	}

	public long getIdProduct() {
		return idProduct;
	}
	
	public static OrderType getOrderType(String type){
		switch (type){
		  case "pizza": return OrderType.PIZZA;
		  case "pasta": return OrderType.OTHER;
		  case "salad": return OrderType.OTHER;
		  case "drink": return OrderType.OTHER;
		}
		return null;		
	}
	
}
