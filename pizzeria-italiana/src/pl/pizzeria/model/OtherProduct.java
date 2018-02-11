package pl.pizzeria.model;

public class OtherProduct {
	
	private long idOtherProduct;
	private ProductType productType;
	private float price;
	private OtherElement element;
	
	public OtherProduct(long idOtherProduct, ProductType productType, float price, OtherElement element) {
		this.idOtherProduct = idOtherProduct;
		this.productType = productType;
		this.price = price;
		this.element = element;
	}
	
	public OtherProduct(){}

	public long getIdOtherProduct() {
		return idOtherProduct;
	}

	public void setIdOtherProduct(long idOtherProduct) {
		this.idOtherProduct = idOtherProduct;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public OtherElement getElement() {
		return element;
	}

	public void setElement(OtherElement element) {
		this.element = element;
	}

	@Override
	public String toString() {
		return "OtherProduct [idOtherProduct=" + idOtherProduct + ", productType=" + productType + ", price=" + price
				+ ", element=" + element + "]";
	}
	
}
