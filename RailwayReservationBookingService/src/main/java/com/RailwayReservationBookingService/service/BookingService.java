package com.RailwayReservationBookingService.service;

import java.util.List;

import com.RailwayReservationBookingService.model.UserDetails;

public interface BookingService {
	public List<UserDetails> getAll();

	public UserDetails getUserDetailsById(long pnrNo);

	public String addUserBookingDetails(UserDetails userDetails);

	public String deleteUserBookingDetails(long pnrNo);
}
