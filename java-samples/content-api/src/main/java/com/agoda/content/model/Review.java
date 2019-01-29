package com.agoda.content.model;

public class Review {

	private long propertyId;
	private long reviewId;
	private String data;
	private int rating;
	
	
	
	public Review(long propertyId, long reviewId, String data, int rating) {
		super();
		this.propertyId = propertyId;
		this.reviewId = reviewId;
		this.data = data;
		this.rating = rating;
	}
	
	public long getPropertyId() {
		return propertyId;
	}
	public void setPropertyId(long propertyId) {
		this.propertyId = propertyId;
	}
	public long getReviewId() {
		return reviewId;
	}
	public void setReviewId(long reviewId) {
		this.reviewId = reviewId;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
	
	
}
