package pl.pizzeria.model;

public enum ProductType {

	PASTA(1), SALAD(2), DRINK(3);
	
	private final long idProductType;	
	
	private ProductType(long idProductType) {
		this.idProductType= idProductType;
	}

	public long getIdProductType() {
		return idProductType;
	}
	
	public static ProductType getProductType(long idProductType){
		switch ((int)idProductType){
		  case 1: return ProductType.PASTA;
		  case 2: return ProductType.SALAD;
		  case 3: return ProductType.DRINK;	 
		}
		return null;		
	}
	
}
