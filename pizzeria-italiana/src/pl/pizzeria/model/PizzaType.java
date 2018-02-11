package pl.pizzeria.model;

public enum PizzaType {
	
	CIENKIE_MALA(1, "cienkie, ma³a"), CIENKIE_DUZA(2, "cienkie, du¿a"), GRUBE_MALA(3, "grube, ma³a"), GRUBE_DUZA(4, "grube, du¿a");
	
	private final long idPizzaType;	
	private final String name;
	
	private PizzaType(long idPizzaType, String name) {
		this.idPizzaType= idPizzaType;
		this.name=name;
	}

	public long getIdPizzaType() {
		return idPizzaType;
	}
	
	public String getName() {
		return name;
	}

	public static PizzaType getPizzaType(long idPizzaType){
		switch ((int)idPizzaType){
		  case 1: return PizzaType.CIENKIE_MALA;
		  case 2: return PizzaType.CIENKIE_DUZA;
		  case 3: return PizzaType.GRUBE_MALA;
		  case 4: return PizzaType.GRUBE_DUZA;		 
		}
		return null;		
	}
	
}
