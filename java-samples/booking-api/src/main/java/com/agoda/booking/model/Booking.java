package com.agoda.booking.model;

import java.util.Date;

import io.leangen.graphql.annotations.GraphQLQuery;

public class Booking {
	
	private long custId;
	private long bookingId;
	private Date checkInDate;
	private Date checkOutDate;
	private PropertySnapshot propertySnapShot;
	private long propertyId;
	
	public Booking() {}
	
	public Booking(long custId, long bookingId, Date checkInDate, Date checkOutDate,
			PropertySnapshot propertySnapShot,long propertyId) {
		super();
		this.custId = custId;
		this.bookingId = bookingId;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.propertySnapShot = propertySnapShot;
		this.propertyId = propertyId;
	}
	
	@GraphQLQuery(name = "custId", description = "Customer Id")
	public long getCustId() {
		return custId;
	}
	public void setCustId(long custId) {
		this.custId = custId;
	}
	
	@GraphQLQuery(name = "bookingId", description = "booking Id")
	public long getBookingId() {
		return bookingId;
	}
	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}
	
	@GraphQLQuery(name = "checkInDate", description = "checkInDate ")
	public Date getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}
	public Date getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	public PropertySnapshot getPropertySnapShot() {
		return propertySnapShot;
	}
	public void setPropertySnapShot(PropertySnapshot propertySnapShot) {
		this.propertySnapShot = propertySnapShot;
	}

	public long getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(long propertyId) {
		this.propertyId = propertyId;
	}
	
	
	
	
}
