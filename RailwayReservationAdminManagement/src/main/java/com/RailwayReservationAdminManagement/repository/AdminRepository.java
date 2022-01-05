package com.RailwayReservationAdminManagement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.RailwayReservationAdminManagement.model.TrainDetails;

@Repository
public interface AdminRepository  extends MongoRepository<TrainDetails,Integer>	{

}
