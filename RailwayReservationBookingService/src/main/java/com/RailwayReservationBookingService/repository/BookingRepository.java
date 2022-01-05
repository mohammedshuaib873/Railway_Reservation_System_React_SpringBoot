package com.RailwayReservationBookingService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.RailwayReservationBookingService.model.UserDetails;

@Repository
public interface BookingRepository extends MongoRepository<UserDetails, Integer> {

}
