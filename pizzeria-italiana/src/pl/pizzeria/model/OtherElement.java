package pl.pizzeria.model;

public class OtherElement {

	private long idElement;
	private String name;
	private String description;
	private String src;
	
	public OtherElement(long idElement, String name, String description, String src) {
		this.idElement = idElement;
		this.name = name;
		this.description = description;
		this.src = src;
	}
	
	public OtherElement(){}

	public long getIdElement() {
		return idElement;
	}

	public void setIdElement(long idElement) {
		this.idElement = idElement;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	@Override
	public String toString() {
		return "Element [idElement=" + idElement + ", name=" + name + ", description=" + description + ", src=" + src
				+ "]";
	}
	
	
}
