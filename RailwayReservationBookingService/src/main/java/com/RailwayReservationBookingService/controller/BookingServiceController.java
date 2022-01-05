package com.RailwayReservationBookingService.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.RailwayReservationBookingService.model.TrainDetails;
import com.RailwayReservationBookingService.model.UserDetails;
import com.RailwayReservationBookingService.service.BookingServiceImpl;

import io.swagger.annotations.ApiOperation;

@Component
@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/user")
public class BookingServiceController {
	@Autowired
	private BookingServiceImpl bookingServiceImpl;

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/all")
	@ApiOperation(value = "Get all user details who booked their tickets")
	public List<UserDetails> getAll() {
		return bookingServiceImpl.getAll();
	}

	@GetMapping("/getDetailsByPnrNo")
	@ApiOperation(value = "Get user details by Pnr Number")
	public UserDetails getUserDetailsById(@RequestParam long pnrNo) {
		return bookingServiceImpl.getUserDetailsById(pnrNo);
	}

	@PostMapping("/book")
	@ApiOperation(value = "Book a ticket")
	public String addUserDetails(@Valid @RequestBody UserDetails userDetails) {
		userDetails.setId(bookingServiceImpl.getSequenceNumber(UserDetails.SEQUENCE_NAME));
		userDetails.setPnrNo();
		userDetails.setPayment("Pending");
		int trainNo = userDetails.getTrainNo();
		int noOfAdults = userDetails.getAdults();
		int noOfChildren = userDetails.getChildren();
		int totalPassengers = noOfAdults + noOfChildren;
		restTemplate.getForObject("http://localhost:8083/admin/updateSeats/" + trainNo + "/" + totalPassengers,
				TrainDetails.class);
		return bookingServiceImpl.addUserBookingDetails(userDetails);
	}

	@DeleteMapping("/cancel/{pnrNo}")
	@ApiOperation(value = "Cancel a ticket")
	public String deleteUserDetailsById(@PathVariable long pnrNo) {
		restTemplate.getForObject("http://localhost:8085/pay/cancel/"+pnrNo, String.class);
		return bookingServiceImpl.deleteUserBookingDetails(pnrNo);
	}

}
