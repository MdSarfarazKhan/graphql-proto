package com.agoda.content.model;

import io.leangen.graphql.annotations.GraphQLQuery;

public class Room {
	
	private long roomId;
	private long propertyId;
	private String roomClass;
	
	public Room() {}
	
	
	public Room(long roomId, long propertyId, String roomClass) {
		super();
		this.roomId = roomId;
		this.propertyId = propertyId;
		this.roomClass = roomClass;
	}
	
	//@GraphQLQuery
	public long getRoomId() {
		return roomId;
	}
	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}
	//@GraphQLQuery
	public long getPropertyId() {
		return propertyId;
	}
	public void setPropertyId(long propertyId) {
		this.propertyId = propertyId;
	}
	//@GraphQLQuery
	public String getRoomClass() {
		return roomClass;
	}
	public void setRoomClass(String roomClass) {
		this.roomClass = roomClass;
	}
	
	
	
	
}
