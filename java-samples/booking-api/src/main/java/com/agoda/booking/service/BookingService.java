package com.agoda.booking.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.agoda.booking.model.Booking;
import com.agoda.util.booking.PojoBuilder;

import io.leangen.graphql.annotations.GraphQLQuery;

@Service
public class BookingService {

	@GraphQLQuery(name = "bookings")
	public List<Booking> fetchBookings( long custId) {
		return PojoBuilder.buildBookingList(custId);
	}

	@GraphQLQuery(name = "booking")
	public Booking fetchBooking( long custId) {
		return PojoBuilder.buildBookingList(custId).get(0);
	} 

}
