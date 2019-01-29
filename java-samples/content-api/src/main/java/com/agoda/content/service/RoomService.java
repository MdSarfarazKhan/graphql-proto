package com.agoda.content.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.agoda.content.model.Review;
import com.agoda.content.model.Room;

import io.leangen.graphql.annotations.GraphQLQuery;

@Service
public class RoomService {
	
	@GraphQLQuery(name = "room")
	public Room fetchRoom(long propertyId){
		return new Room(1, propertyId, "Gold");
	}
}
