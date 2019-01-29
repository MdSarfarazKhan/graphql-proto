package com.agoda.util.booking;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.agoda.booking.model.Booking;
import com.agoda.booking.model.PropertySnapshot;

public class PojoBuilder {

	public static Booking buildBookingObject(long custId,long bookingId,long propertyId) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd");
		return new Booking(custId, bookingId,sdf.parse("2018-01-01"), sdf.parse("2018-01-04"), 
				null,propertyId);
	}

	public static List<Booking> buildBookingList(long custId) {

		List<Booking> list = new ArrayList<>();
		try {
			list.add(buildBookingObject(custId,2,1));
			list.add(buildBookingObject(custId,2,2));
			list.add(buildBookingObject(custId,5,3));
		}catch(Exception e) {

		}
		return list;
	}

}
