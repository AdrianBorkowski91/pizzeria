package pl.pizzeria.model;


public class Order {
	
	private long idOrder;
	private String personalData;
	private int phone;
	private String email;
	private boolean newsletter;
	private String street;
	private String houseNumber;
	private String apartmentNumber;
	private String zipCode;
	private String city;
	private String comment;
	
	public Order(String personalData, int phone, String email, boolean newsletter, String street, 
			String houseNumber, String apartmentNumber, String zipCode, String city, String comment){
		this.personalData=personalData;
		this.phone=phone;
		this.email=email;
		this.newsletter= newsletter;
		this.street=street;
		this.houseNumber=houseNumber;
		this.apartmentNumber=apartmentNumber;
		this.setZipCode(zipCode);
		this.city=city;
		this.comment=comment;
	}
	
	public Order(){}
	
	public long getIdOrder() {
		return idOrder;
	}
	public void setIdOrder(long idOrder) {
		this.idOrder = idOrder;
	}
	public String getPersonalData() {
		return personalData;
	}
	public void setPersonalData(String personalData) {
		this.personalData = personalData;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isNewsletter() {
		return newsletter;
	}
	public void setNewsletter(boolean newsletter) {
		this.newsletter = newsletter;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getApartmentNumber() {
		return apartmentNumber;
	}
	public void setApartmentNumber(String apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Order [idOrder=" + idOrder + ", personalData=" + personalData + ", phone=" + phone + ", email=" + email
				+ ", newsletter=" + newsletter + ", street=" + street + ", houseNumber=" + houseNumber
				+ ", apartmentNumber=" + apartmentNumber + ", zipCode=" + zipCode + ", city=" + city + ", comment="
				+ comment + "]";
	}

}
