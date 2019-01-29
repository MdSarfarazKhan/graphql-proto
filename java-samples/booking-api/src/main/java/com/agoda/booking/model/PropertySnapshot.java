package com.agoda.booking.model;

public class PropertySnapshot {
	
	private long propertyId;
	private String propertyName;
	private String propertyCity;
	private double price;
	
	public PropertySnapshot() {}
	
	
	public PropertySnapshot(long propertyId, String propertyName, String propertyCity, double price) {
		super();
		this.propertyId = propertyId;
		this.propertyName = propertyName;
		this.propertyCity = propertyCity;
		this.price = price;
	}
	public long getPropertyId() {
		return propertyId;
	}
	public void setPropertyId(long propertyId) {
		this.propertyId = propertyId;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public String getPropertyCity() {
		return propertyCity;
	}
	public void setPropertyCity(String propertyCity) {
		this.propertyCity = propertyCity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
