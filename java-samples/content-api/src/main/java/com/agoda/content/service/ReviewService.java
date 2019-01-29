package com.agoda.content.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.agoda.content.model.Review;

import io.leangen.graphql.annotations.GraphQLQuery;

@Service
public class ReviewService {
	
	@GraphQLQuery(name = "reviews")
	public List<Review> fetchReview(long propertyId){
		List<Review> list = new ArrayList<>();
		list.add(new Review(propertyId, 1, "This is a nice hotel", 4));
		list.add(new Review(propertyId, 2, "This is a good hotel", 4));
		list.add(new Review(propertyId, 3, "This is a bad hotel.", 2));
		return list;
	}
	

}
